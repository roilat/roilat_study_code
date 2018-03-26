<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<!-- 加载公共的样式，主要作用是清除浏览器的一些默认样式，页面公共排版，包括头部以及一些组件样式 -->
<link href="${ctx}/css/reset.css" rel="stylesheet" type="text/css" />

<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/page.css" rel="stylesheet" type="text/css" />
<!-- css load end -->

<!-- 前端框架核心库加载放在 -->
<script src="${ctx}/js/lib/core.js" type="text/javascript"></script>
<script src="${ctx}/js/component/modal.js" type="text/javascript"></script>
<script src="${ctx}/js/lib/jquery-ui.custom.js" type="text/javascript"></script>


<script type="text/javascript">
    // seajs 的简单配置
    seajs.config({
        base: "${ctx}/js",
        alias: {

        }
    });
</script>
</head>
<body>
	<div>
		<form id="custInfoForm">
			<input type="hidden" name="custNo" value="${custInfo.custNo}" />
			<table class="table_list">
				<tr>
					<td>custNo</td>
					<td><input type="text" id="custNo" name="custNo" data-validaterole="custNo" data-rule="custNo" value="${custInfo.custNo}" /></td>
				</tr>
				<tr>
					<td>userName</td>
					<td><input type="text" id="userName" name="userName" data-validaterole="userName" data-rule="userName" value="${custInfo.userName}" /></td>
				</tr>
				<tr>
					<td>moblNo</td>
					<td><input type="text" id="moblNo" name="moblNo" data-validaterole="moblNo" data-rule="moblNo" value="${custInfo.moblNo}" /></td>
				</tr>
				<tr>
					<td>loginPwd</td>
					<td><input type="text" id="loginPwd" name="loginPwd" data-validaterole="loginPwd" data-rule="loginPwd" value="${custInfo.loginPwd}" /></td>
				</tr>
				<tr>
					<td>acctPwd</td>
					<td><input type="text" id="acctPwd" name="acctPwd" data-validaterole="acctPwd" data-rule="acctPwd" value="${custInfo.acctPwd}" /></td>
				</tr>
				<tr>
					<td>mesgPwd</td>
					<td><input type="text" id="mesgPwd" name="mesgPwd" data-validaterole="mesgPwd" data-rule="mesgPwd" value="${custInfo.mesgPwd}" /></td>
				</tr>
				<tr>
					<td>SEX</td>
					<td><input type="text" id="SEX" name="SEX" data-validaterole="SEX" data-rule="SEX" value="${custInfo.SEX}" /></td>
				</tr>
				<tr>
					<td>custName</td>
					<td><input type="text" id="custName" name="custName" data-validaterole="custName" data-rule="custName" value="${custInfo.custName}" /></td>
				</tr>
				<tr>
					<td>certTyp</td>
					<td><input type="text" id="certTyp" name="certTyp" data-validaterole="certTyp" data-rule="certTyp" value="${custInfo.certTyp}" /></td>
				</tr>
				<tr>
					<td>certNo</td>
					<td><input type="text" id="certNo" name="certNo" data-validaterole="certNo" data-rule="certNo" value="${custInfo.certNo}" /></td>
				</tr>
				<tr>
					<td>certValidPerd</td>
					<td><input type="text" id="certValidPerd" name="certValidPerd" data-validaterole="certValidPerd" data-rule="certValidPerd" value="${custInfo.certValidPerd}" /></td>
				</tr>
				<tr>
					<td>birthDate</td>
					<td><input type="text" id="birthDate" name="birthDate" data-validaterole="birthDate" data-rule="birthDate" value="${custInfo.birthDate}" /></td>
				</tr>
				<tr>
					<td>POINT</td>
					<td><input type="text" id="POINT" name="POINT" data-validaterole="POINT" data-rule="POINT" value="${custInfo.POINT}" /></td>
				</tr>
				<tr>
					<td>loginStat</td>
					<td><input type="text" id="loginStat" name="loginStat" data-validaterole="loginStat" data-rule="loginStat" value="${custInfo.loginStat}" /></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" id="EMAIL" name="EMAIL" data-validaterole="EMAIL" data-rule="EMAIL" value="${custInfo.EMAIL}" /></td>
				</tr>
				<tr>
					<td>acctStat</td>
					<td><input type="text" id="acctStat" name="acctStat" data-validaterole="acctStat" data-rule="acctStat" value="${custInfo.acctStat}" /></td>
				</tr>
				<tr>
					<td>vipFlag</td>
					<td><input type="text" id="vipFlag" name="vipFlag" data-validaterole="vipFlag" data-rule="vipFlag" value="${custInfo.vipFlag}" /></td>
				</tr>
				<tr>
					<td>authFlag</td>
					<td><input type="text" id="authFlag" name="authFlag" data-validaterole="authFlag" data-rule="authFlag" value="${custInfo.authFlag}" /></td>
				</tr>
				<tr>
					<td>regDate</td>
					<td><input type="text" id="regDate" name="regDate" data-validaterole="regDate" data-rule="regDate" value="${custInfo.regDate}" /></td>
				</tr>
				<tr>
					<td>loanPsnFlag</td>
					<td><input type="text" id="loanPsnFlag" name="loanPsnFlag" data-validaterole="loanPsnFlag" data-rule="loanPsnFlag" value="${custInfo.loanPsnFlag}" /></td>
				</tr>
				<tr>
					<td>openId</td>
					<td><input type="text" id="openId" name="openId" data-validaterole="openId" data-rule="openId" value="${custInfo.openId}" /></td>
				</tr>
				<tr>
					<td>loginFlag</td>
					<td><input type="text" id="loginFlag" name="loginFlag" data-validaterole="loginFlag" data-rule="loginFlag" value="${custInfo.loginFlag}" /></td>
				</tr>
				<tr>
					<td>lastLoginDate</td>
					<td><input type="text" id="lastLoginDate" name="lastLoginDate" data-validaterole="lastLoginDate" data-rule="lastLoginDate" value="${custInfo.lastLoginDate}" /></td>
				</tr>
				<tr>
					<td>custTyp</td>
					<td><input type="text" id="custTyp" name="custTyp" data-validaterole="custTyp" data-rule="custTyp" value="${custInfo.custTyp}" /></td>
				</tr>
				<tr>
					<td>instDate</td>
					<td><input type="text" id="instDate" name="instDate" data-validaterole="instDate" data-rule="instDate" value="${custInfo.instDate}" /></td>
				</tr>
				<tr>
					<td>updtDate</td>
					<td><input type="text" id="updtDate" name="updtDate" data-validaterole="updtDate" data-rule="updtDate" value="${custInfo.updtDate}" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" id="editBtn" value="保存" />
					</td>
				</tr>
			</table>			
		</form>
	</div>
	
	<script type="text/javascript">
		$(function(){
			// 验证
			seajs.use(["component/validate","component/tip"], function (validate,tip) {
				var ntip = function(){
		         	// 定义一个提示对象
					var t = new tip({
						content: 'hello tip',
						hasArrow: true,
						arrowOption: { dir: "left", position: { top:8 } },
						con: "body",
						hasCloseBtn: false,
						position: { my: "center", at: "center", of: "#tipcon" },
						css: { width: "120" }
					});
		         	return t;	
				};
				
				// 定义一个验证对象
	            var d = new validate({
					con : "#custInfoForm",// 验证容器
					onSubmit : "#editBtn",// 提交按钮
					eachInvalidField : function(res,field){// 验证不通过的处理
						var oldTip = field.data("tip");
						var tip;
						if(typeof oldTip == "undefined"){
							tip = ntip();
							field.data("tip",tip);
						}else{
							tip = oldTip;
						}
						tip.setContent(res.message);
						tip.setPosition({ my: "left center-15", at: "right+10 center", of: field });
						tip.show();
					},
					eachValidField : function(res,field){// 验证通过则隐藏提示
						var oldTip = field.data("tip");
						var tip;
						if(typeof oldTip == "undefined"){
						   
						}else{
							tip = oldTip;
							tip.hide();
						}
					}
				});
				
				// 设置拼装规则
				// d.setValidateRule({ dsName : ["isBlank"] });
				
				// 注册保存按钮事件
				d.bind("onsubmit",function(){
					// 序列化表单参数
					var serializedForm = $("#custInfoForm").serialize();
					$.post("${ctx}/custInfo/edit.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/custInfo/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.custInfoDialog.close();
			            } else {
			            	alert("操作失败");
			            }
			        }, "json");
	        	});
			});
		});
	</script>
</body>
</html>