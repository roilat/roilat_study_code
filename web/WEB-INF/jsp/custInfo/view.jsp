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
		<table class="table_list">
				<tr>
					<td>custNo</td>
					<td>${custInfo.custNo}</td>
				</tr>
				<tr>
					<td>userName</td>
					<td>${custInfo.userName}</td>
				</tr>
				<tr>
					<td>moblNo</td>
					<td>${custInfo.moblNo}</td>
				</tr>
				<tr>
					<td>loginPwd</td>
					<td>${custInfo.loginPwd}</td>
				</tr>
				<tr>
					<td>acctPwd</td>
					<td>${custInfo.acctPwd}</td>
				</tr>
				<tr>
					<td>mesgPwd</td>
					<td>${custInfo.mesgPwd}</td>
				</tr>
				<tr>
					<td>SEX</td>
					<td>${custInfo.SEX}</td>
				</tr>
				<tr>
					<td>custName</td>
					<td>${custInfo.custName}</td>
				</tr>
				<tr>
					<td>certTyp</td>
					<td>${custInfo.certTyp}</td>
				</tr>
				<tr>
					<td>certNo</td>
					<td>${custInfo.certNo}</td>
				</tr>
				<tr>
					<td>certValidPerd</td>
					<td>${custInfo.certValidPerd}</td>
				</tr>
				<tr>
					<td>birthDate</td>
					<td>${custInfo.birthDate}</td>
				</tr>
				<tr>
					<td>POINT</td>
					<td>${custInfo.POINT}</td>
				</tr>
				<tr>
					<td>loginStat</td>
					<td>${custInfo.loginStat}</td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td>${custInfo.EMAIL}</td>
				</tr>
				<tr>
					<td>acctStat</td>
					<td>${custInfo.acctStat}</td>
				</tr>
				<tr>
					<td>vipFlag</td>
					<td>${custInfo.vipFlag}</td>
				</tr>
				<tr>
					<td>authFlag</td>
					<td>${custInfo.authFlag}</td>
				</tr>
				<tr>
					<td>regDate</td>
					<td>${custInfo.regDate}</td>
				</tr>
				<tr>
					<td>loanPsnFlag</td>
					<td>${custInfo.loanPsnFlag}</td>
				</tr>
				<tr>
					<td>openId</td>
					<td>${custInfo.openId}</td>
				</tr>
				<tr>
					<td>loginFlag</td>
					<td>${custInfo.loginFlag}</td>
				</tr>
				<tr>
					<td>lastLoginDate</td>
					<td>${custInfo.lastLoginDate}</td>
				</tr>
				<tr>
					<td>custTyp</td>
					<td>${custInfo.custTyp}</td>
				</tr>
				<tr>
					<td>instDate</td>
					<td>${custInfo.instDate}</td>
				</tr>
				<tr>
					<td>updtDate</td>
					<td>${custInfo.updtDate}</td>
				</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="returnBtn" value="返回" />
				</td>
			</tr>
		</table>	
	</div>
	
	<script type="text/javascript">
		$(function(){
			// 注册返回按钮事件
			$("#returnBtn").click(function () {
				// 关闭弹窗窗口
				parent.sysDeptDialog.close();
	        });
		});
	</script>
</body>
</html>