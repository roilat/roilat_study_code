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
					<td>acctNo</td>
					<td>${invstAcct.acctNo}</td>
				</tr>
				<tr>
					<td>custNo</td>
					<td>${invstAcct.custNo}</td>
				</tr>
				<tr>
					<td>custName</td>
					<td>${invstAcct.custName}</td>
				</tr>
				<tr>
					<td>loginPwd</td>
					<td>${invstAcct.loginPwd}</td>
				</tr>
				<tr>
					<td>payPwd</td>
					<td>${invstAcct.payPwd}</td>
				</tr>
				<tr>
					<td>acctTyp</td>
					<td>${invstAcct.acctTyp}</td>
				</tr>
				<tr>
					<td>openOrg</td>
					<td>${invstAcct.openOrg}</td>
				</tr>
				<tr>
					<td>subjNo</td>
					<td>${invstAcct.subjNo}</td>
				</tr>
				<tr>
					<td>Bal</td>
					<td>${invstAcct.Bal}</td>
				</tr>
				<tr>
					<td>avalBal</td>
					<td>${invstAcct.avalBal}</td>
				</tr>
				<tr>
					<td>frzAmt</td>
					<td>${invstAcct.frzAmt}</td>
				</tr>
				<tr>
					<td>invstAmt</td>
					<td>${invstAcct.invstAmt}</td>
				</tr>
				<tr>
					<td>batFlag</td>
					<td>${invstAcct.batFlag}</td>
				</tr>
				<tr>
					<td>acctStat</td>
					<td>${invstAcct.acctStat}</td>
				</tr>
				<tr>
					<td>frzStat</td>
					<td>${invstAcct.frzStat}</td>
				</tr>
				<tr>
					<td>openDate</td>
					<td>${invstAcct.openDate}</td>
				</tr>
				<tr>
					<td>lastTxDate</td>
					<td>${invstAcct.lastTxDate}</td>
				</tr>
				<tr>
					<td>lastDayPrft</td>
					<td>${invstAcct.lastDayPrft}</td>
				</tr>
				<tr>
					<td>lastMthPrft</td>
					<td>${invstAcct.lastMthPrft}</td>
				</tr>
				<tr>
					<td>lastYearPrft</td>
					<td>${invstAcct.lastYearPrft}</td>
				</tr>
				<tr>
					<td>totlPrft</td>
					<td>${invstAcct.totlPrft}</td>
				</tr>
				<tr>
					<td>totlInvst</td>
					<td>${invstAcct.totlInvst}</td>
				</tr>
				<tr>
					<td>totlAmt</td>
					<td>${invstAcct.totlAmt}</td>
				</tr>
				<tr>
					<td>totlPpleAmt</td>
					<td>${invstAcct.totlPpleAmt}</td>
				</tr>
				<tr>
					<td>totlIntAmt</td>
					<td>${invstAcct.totlIntAmt}</td>
				</tr>
				<tr>
					<td>baseTotlPrft</td>
					<td>${invstAcct.baseTotlPrft}</td>
				</tr>
				<tr>
					<td>prftAvgRat</td>
					<td>${invstAcct.prftAvgRat}</td>
				</tr>
				<tr>
					<td>instDate</td>
					<td>${invstAcct.instDate}</td>
				</tr>
				<tr>
					<td>updtDate</td>
					<td>${invstAcct.updtDate}</td>
				</tr>
				<tr>
					<td>recordStat</td>
					<td>${invstAcct.recordStat}</td>
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