package cn.roilat.framework.core.netty.handler;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cn.roilat.framework.core.SpringApplicationContext;
import cn.roilat.framework.core.redis.RedisService;
import cn.roilat.framework.result.ResponseResult;
import cn.roilat.framework.result.ResultCodeEnum;
import cn.roilat.framework.utils.JwtUtil;
import cn.roilat.framework.utils.StringUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class NettyServerHandler extends BaseHandler<FullHttpRequest> {
	private static final String ACCESS_TOKEN = "ACCESSTOKEN";
	private static final String UUID = "UUID";
	Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);
	private String env = "dev";

	@Override
	public void readData(ChannelHandlerContext ctx, FullHttpRequest request) {
		String token = request.headers().get(ACCESS_TOKEN);
		String uuid = request.headers().get(UUID);
		String uri = request.uri();
		ByteBuf buf = request.content();
		String bodyString = buf.toString(Charset.defaultCharset());
		if (env.equals("dev")) {
			Object result = super.invokeMethod(uri, bodyString);
			if (result == null) {
				result = ResponseResult.fail();
			}
			writeData2Client(ctx, result);
		}

		System.out.println("接受到客户端传递过来的参数---->" + bodyString);
		buf.release();

		// 验证token
		ResponseResult validate = validateToken(uri, token, uuid);
		if (!ResultCodeEnum.SUCCESS.getCode().equals(validate.getStatusCode())) {
			writeData2Client(ctx, validate);
		} else {
			// 验证权限
			ResponseResult validatePermission = validatePermission(uri);
			if (!ResultCodeEnum.SUCCESS.getCode().equals(validatePermission.getStatusCode())) {
				writeData2Client(ctx, validatePermission);
			} else {
				Object result = super.invokeMethod(uri, bodyString);
				if (result == null) {
					result = ResponseResult.fail();
				}
				writeData2Client(ctx, result);
			}
		}
	}

	private ResponseResult validateToken(String url, String token, String uuid) {
		System.out.println("url---->" + url);

		if (!"/user/login".equals(url)) {
			if (StringUtil.isEmpty(token)) { // token为空
				return ResponseResult.fail(ResultCodeEnum.TOKEN_EMPTY.getCode(),
						ResultCodeEnum.TOKEN_EMPTY.getMessage());
			}

			if (StringUtil.isEmpty(uuid)) { // uuid为空
				return ResponseResult.fail("参数中不存在uuid");
			}

			String value = JwtUtil.parseJWT(token);
			if (!StringUtil.isEmpty(value)) {
				// 新token
				JSONObject obj = JSON.parseObject(value);
				if (obj != null) {
					String redisKey = obj.getString("username");
					String newUuid = obj.getString("uuid");

					// 校验uuid和token一致性
					if (!newUuid.equals(uuid)) {
						// token非法
						return ResponseResult.fail(ResultCodeEnum.TOKEN_ILLEGAL.getCode(),
								ResultCodeEnum.TOKEN_ILLEGAL.getMessage());
					}

					RedisService jedisService = SpringApplicationContext.getBean("redisService", RedisService.class);
					String redisValue = (String) jedisService.get(redisKey);

					if (redisValue != null) {
						String oldValue = redisValue.toString();
						if (oldValue.equals(token)) {
							// TOKEN验证成功后，又重新设置token到缓存中，更新缓存时间
							jedisService.set(redisKey, redisValue, 1200);
							// 将操作用户信息保存至线程变量中
							//Constant.userName.set(redisKey);
							// 将操作用户信息保存至线程变量中
							// SpringApplicationContext.userInfo.set(redisKey);
							return ResponseResult.succ("token验证通过");
						} else {
							// redis有相同用户的token，token被覆盖
							return ResponseResult.fail(ResultCodeEnum.TOKEN_COVER.getCode(),
									ResultCodeEnum.TOKEN_COVER.getMessage());
						}
					} else {
						// redis查询不到，token失效
						return ResponseResult.fail(ResultCodeEnum.TOKEN_EXPIRED.getCode(),
								ResultCodeEnum.TOKEN_EXPIRED.getMessage());
					}
				} else {
					// token转换json出错，token非法
					return ResponseResult.fail(ResultCodeEnum.TOKEN_ILLEGAL.getCode(),
							ResultCodeEnum.TOKEN_ILLEGAL.getMessage());
				}
			} else {
				// token不能被解析，token非法
				return ResponseResult.fail(ResultCodeEnum.TOKEN_ILLEGAL.getCode(),
						ResultCodeEnum.TOKEN_ILLEGAL.getMessage());
			}
		} else { // 登录
			return ResponseResult.succ();
		}
	}

	/**
	 * 验证权限
	 * 
	 * @param url
	 * @return
	 */
	private ResponseResult validatePermission(String url) {
		if (StringUtil.isEmpty(url)) { // URL为空
			return ResponseResult.fail(ResultCodeEnum.URL_ERROR.getCode(), ResultCodeEnum.URL_ERROR.getMessage());
		} else {
			if ("/user/login".equals(url)) {
				return ResponseResult.succ();
			} else if ("/user/refresh".equals(url)) {
				return ResponseResult.succ();
			} else if ("/user/updateSkin".equals(url)) {
				return ResponseResult.succ();
			} else if ("/user/updateUserInfo".equals(url)) {
				return ResponseResult.succ();
			} else if ("/user/updatePassword".equals(url)) {
				return ResponseResult.succ();
			} else {
				return ResponseResult.succ();
				/*String userName = Constant.userName.get();
				UserService userService = (UserService) SpringApplicationContext.context.getBean("userService");
				MsUser msUser = new MsUser();
				msUser.setUserName(userName);
				List<MsUser> msUsers = null;
				try {
					msUsers = userService.get(msUser);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (msUsers != null && msUsers.size() != 0) {

					PermissionService permissionService = (PermissionService) SpringApplicationContext.context
							.getBean("permissionService");

					List<MsPermission> permissions = permissionService.getPermissionByUserId(msUsers.get(0).getId());
					MsPermission permission = null;
					boolean permissionExit = false;
					if (permissions == null || permissions.size() == 0) {
						return ResponseResult.fail(ResultCodeEnum.PERMISSION_ERROR.getCode(),
								ResultCodeEnum.PERMISSION_ERROR.getMessage());
					}
					for (int i = 0; i < permissions.size(); i++) {
						permission = permissions.get(i);
						if (permission.getPermissionUri() != null && !permission.getPermissionUri().equals("")) {
							// System.out.println(permission.getPermissionUri()
							// + ":" + url);
							if (permission.getPermissionUri().contains(url)) {
								permissionExit = true;
								break;
							}
						}
					}
					if (permissionExit) {
						return ResponseResult.succ();
					} else {
						return ResponseResult.fail(ResultCodeEnum.PERMISSION_ERROR.getCode(),
								ResultCodeEnum.PERMISSION_ERROR.getMessage());
					}
				} else {
					return ResponseResult.fail(ResultCodeEnum.TOKEN_EXPIRED.getCode(),
							ResultCodeEnum.TOKEN_EXPIRED.getMessage());
				}*/
			}
		}
	}
}
