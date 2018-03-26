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
					<td>rechgWithdNo</td>
					<td>${invstRechgWithdCash.rechgWithdNo}</td>
				</tr>
				<tr>
					<td>custNo</td>
					<td>${invstRechgWithdCash.custNo}</td>
				</tr>
				<tr>
					<td>custName</td>
					<td>${invstRechgWithdCash.custName}</td>
				</tr>
				<tr>
					<td>txDate</td>
					<td>${invstRechgWithdCash.txDate}</td>
				</tr>
				<tr>
					<td>acctNo</td>
					<td>${invstRechgWithdCash.acctNo}</td>
				</tr>
				<tr>
					<td>txAmt</td>
					<td>${invstRechgWithdCash.txAmt}</td>
				</tr>
				<tr>
					<td>BAL</td>
					<td>${invstRechgWithdCash.BAL}</td>
				</tr>
				<tr>
					<td>bankNo</td>
					<td>${invstRechgWithdCash.bankNo}</td>
				</tr>
				<tr>
					<td>bankName</td>
					<td>${invstRechgWithdCash.bankName}</td>
				</tr>
				<tr>
					<td>cardNo</td>
					<td>${invstRechgWithdCash.cardNo}</td>
				</tr>
				<tr>
					<td>txFee</td>
					<td>${invstRechgWithdCash.txFee}</td>
				</tr>
				<tr>
					<td>feeAcctNo</td>
					<td>${invstRechgWithdCash.feeAcctNo}</td>
				</tr>
				<tr>
					<td>feeAcctName</td>
					<td>${invstRechgWithdCash.feeAcctName}</td>
				</tr>
				<tr>
					<td>txCod</td>
					<td>${invstRechgWithdCash.txCod}</td>
				</tr>
				<tr>
					<td>txStat</td>
					<td>${invstRechgWithdCash.txStat}</td>
				</tr>
				<tr>
					<td>txDesc</td>
					<td>${invstRechgWithdCash.txDesc}</td>
				</tr>
				<tr>
					<td>instDate</td>
					<td>${invstRechgWithdCash.instDate}</td>
				</tr>
				<tr>
					<td>updtDate</td>
					<td>${invstRechgWithdCash.updtDate}</td>
				</tr>
				<tr>
					<td>recordStat</td>
					<td>${invstRechgWithdCash.recordStat}</td>
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