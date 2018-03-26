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
					<td>txSeqNo</td>
					<td>${sysAcctDtl.txSeqNo}</td>
				</tr>
				<tr>
					<td>serlNo</td>
					<td>${sysAcctDtl.serlNo}</td>
				</tr>
				<tr>
					<td>acctNo</td>
					<td>${sysAcctDtl.acctNo}</td>
				</tr>
				<tr>
					<td>subjNo</td>
					<td>${sysAcctDtl.subjNo}</td>
				</tr>
				<tr>
					<td>drCrFlag</td>
					<td>${sysAcctDtl.drCrFlag}</td>
				</tr>
				<tr>
					<td>prodNo</td>
					<td>${sysAcctDtl.prodNo}</td>
				</tr>
				<tr>
					<td>prodName</td>
					<td>${sysAcctDtl.prodName}</td>
				</tr>
				<tr>
					<td>txDate</td>
					<td>${sysAcctDtl.txDate}</td>
				</tr>
				<tr>
					<td>txAmt</td>
					<td>${sysAcctDtl.txAmt}</td>
				</tr>
				<tr>
					<td>BAL</td>
					<td>${sysAcctDtl.BAL}</td>
				</tr>
				<tr>
					<td>strkFlag</td>
					<td>${sysAcctDtl.strkFlag}</td>
				</tr>
				<tr>
					<td>strkDate</td>
					<td>${sysAcctDtl.strkDate}</td>
				</tr>
				<tr>
					<td>txCod</td>
					<td>${sysAcctDtl.txCod}</td>
				</tr>
				<tr>
					<td>txDesc</td>
					<td>${sysAcctDtl.txDesc}</td>
				</tr>
				<tr>
					<td>instDate</td>
					<td>${sysAcctDtl.instDate}</td>
				</tr>
				<tr>
					<td>updtDate</td>
					<td>${sysAcctDtl.updtDate}</td>
				</tr>
				<tr>
					<td>txStat</td>
					<td>${sysAcctDtl.txStat}</td>
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