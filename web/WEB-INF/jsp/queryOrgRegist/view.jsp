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
					<td>orgId</td>
					<td>${queryOrgRegist.orgId}</td>
				</tr>
				<tr>
					<td>orgName</td>
					<td>${queryOrgRegist.orgName}</td>
				</tr>
				<tr>
					<td>orgType</td>
					<td>${queryOrgRegist.orgType}</td>
				</tr>
				<tr>
					<td>registTime</td>
					<td>${queryOrgRegist.registTime}</td>
				</tr>
				<tr>
					<td>userName</td>
					<td>${queryOrgRegist.userName}</td>
				</tr>
				<tr>
					<td>passwd</td>
					<td>${queryOrgRegist.passwd}</td>
				</tr>
				<tr>
					<td>acctNo</td>
					<td>${queryOrgRegist.acctNo}</td>
				</tr>
				<tr>
					<td>acctStatus</td>
					<td>${queryOrgRegist.acctStatus}</td>
				</tr>
				<tr>
					<td>consumeMethod</td>
					<td>${queryOrgRegist.consumeMethod}</td>
				</tr>
				<tr>
					<td>updateTime</td>
					<td>${queryOrgRegist.updateTime}</td>
				</tr>
				<tr>
					<td>ticket</td>
					<td>${queryOrgRegist.ticket}</td>
				</tr>
				<tr>
					<td>token</td>
					<td>${queryOrgRegist.token}</td>
				</tr>
				<tr>
					<td>privateKey</td>
					<td>${queryOrgRegist.privateKey}</td>
				</tr>
				<tr>
					<td>publicKey</td>
					<td>${queryOrgRegist.publicKey}</td>
				</tr>
				<tr>
					<td>tokenUpdateTime</td>
					<td>${queryOrgRegist.tokenUpdateTime}</td>
				</tr>
				<tr>
					<td>keypairUpdateTime</td>
					<td>${queryOrgRegist.keypairUpdateTime}</td>
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