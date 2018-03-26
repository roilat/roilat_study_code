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
					<td>${invstAcctIntDtl.txSeqNo}</td>
				</tr>
				<tr>
					<td>serlNo</td>
					<td>${invstAcctIntDtl.serlNo}</td>
				</tr>
				<tr>
					<td>invstNo</td>
					<td>${invstAcctIntDtl.invstNo}</td>
				</tr>
				<tr>
					<td>prftTyp</td>
					<td>${invstAcctIntDtl.prftTyp}</td>
				</tr>
				<tr>
					<td>txDate</td>
					<td>${invstAcctIntDtl.txDate}</td>
				</tr>
				<tr>
					<td>acctNo</td>
					<td>${invstAcctIntDtl.acctNo}</td>
				</tr>
				<tr>
					<td>custNo</td>
					<td>${invstAcctIntDtl.custNo}</td>
				</tr>
				<tr>
					<td>custName</td>
					<td>${invstAcctIntDtl.custName}</td>
				</tr>
				<tr>
					<td>prodNo</td>
					<td>${invstAcctIntDtl.prodNo}</td>
				</tr>
				<tr>
					<td>prodName</td>
					<td>${invstAcctIntDtl.prodName}</td>
				</tr>
				<tr>
					<td>subjNo</td>
					<td>${invstAcctIntDtl.subjNo}</td>
				</tr>
				<tr>
					<td>drCrFlag</td>
					<td>${invstAcctIntDtl.drCrFlag}</td>
				</tr>
				<tr>
					<td>estIncomeDt</td>
					<td>${invstAcctIntDtl.estIncomeDt}</td>
				</tr>
				<tr>
					<td>estIncomeAmt</td>
					<td>${invstAcctIntDtl.estIncomeAmt}</td>
				</tr>
				<tr>
					<td>actualIncomeDt</td>
					<td>${invstAcctIntDtl.actualIncomeDt}</td>
				</tr>
				<tr>
					<td>actualIncomeAmt</td>
					<td>${invstAcctIntDtl.actualIncomeAmt}</td>
				</tr>
				<tr>
					<td>paymentPpleAmt</td>
					<td>${invstAcctIntDtl.paymentPpleAmt}</td>
				</tr>
				<tr>
					<td>actualPpleAmt</td>
					<td>${invstAcctIntDtl.actualPpleAmt}</td>
				</tr>
				<tr>
					<td>paymentIntAmt</td>
					<td>${invstAcctIntDtl.paymentIntAmt}</td>
				</tr>
				<tr>
					<td>actualIntAmt</td>
					<td>${invstAcctIntDtl.actualIntAmt}</td>
				</tr>
				<tr>
					<td>txStat</td>
					<td>${invstAcctIntDtl.txStat}</td>
				</tr>
				<tr>
					<td>txCod</td>
					<td>${invstAcctIntDtl.txCod}</td>
				</tr>
				<tr>
					<td>txDesc</td>
					<td>${invstAcctIntDtl.txDesc}</td>
				</tr>
				<tr>
					<td>instDate</td>
					<td>${invstAcctIntDtl.instDate}</td>
				</tr>
				<tr>
					<td>updtDate</td>
					<td>${invstAcctIntDtl.updtDate}</td>
				</tr>
				<tr>
					<td>recordStat</td>
					<td>${invstAcctIntDtl.recordStat}</td>
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