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
					<td>流水号</td>
					<td>${orgAcctLedger.flowId}</td>
				</tr>
				<tr>
					<td>机构ID</td>
					<td>${orgAcctLedger.orgId}</td>
				</tr>
				<tr>
					<td>机构名称</td>
					<td>${orgAcctLedger.orgName}</td>
				</tr>
				<tr>
					<td>账号</td>
					<td>${orgAcctLedger.acctNo}</td>
				</tr>
				<tr>
					<td>交易金额</td>
					<td>${orgAcctLedger.transAmt}</td>
				</tr>
				<tr>
					<td>交易时间</td>
					<td>${orgAcctLedger.transTime}</td>
				</tr>
				<tr>
					<td>交易类型:300001-充值,3000002-消费,300003-冲销</td>
					<td>${orgAcctLedger.tansType}</td>
				</tr>
				<tr>
					<td>账户余额</td>
					<td>${orgAcctLedger.acctBal}</td>
				</tr>
				<tr>
					<td>登记人</td>
					<td>${orgAcctLedger.insertUser}</td>
				</tr>
				<tr>
					<td>登记时间</td>
					<td>${orgAcctLedger.insertTime}</td>
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