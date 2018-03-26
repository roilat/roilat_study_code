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
					<td>invstNo</td>
					<td>${invstAcctReg.invstNo}</td>
				</tr>
				<tr>
					<td>contrNo</td>
					<td>${invstAcctReg.contrNo}</td>
				</tr>
				<tr>
					<td>acctNo</td>
					<td>${invstAcctReg.acctNo}</td>
				</tr>
				<tr>
					<td>invstTyp</td>
					<td>${invstAcctReg.invstTyp}</td>
				</tr>
				<tr>
					<td>prodNo</td>
					<td>${invstAcctReg.prodNo}</td>
				</tr>
				<tr>
					<td>prodName</td>
					<td>${invstAcctReg.prodName}</td>
				</tr>
				<tr>
					<td>custNo</td>
					<td>${invstAcctReg.custNo}</td>
				</tr>
				<tr>
					<td>custName</td>
					<td>${invstAcctReg.custName}</td>
				</tr>
				<tr>
					<td>invstDate</td>
					<td>${invstAcctReg.invstDate}</td>
				</tr>
				<tr>
					<td>acctTyp</td>
					<td>${invstAcctReg.acctTyp}</td>
				</tr>
				<tr>
					<td>invstAmt</td>
					<td>${invstAcctReg.invstAmt}</td>
				</tr>
				<tr>
					<td>prodRat</td>
					<td>${invstAcctReg.prodRat}</td>
				</tr>
				<tr>
					<td>lockRat</td>
					<td>${invstAcctReg.lockRat}</td>
				</tr>
				<tr>
					<td>busnTyp</td>
					<td>${invstAcctReg.busnTyp}</td>
				</tr>
				<tr>
					<td>repayTyp</td>
					<td>${invstAcctReg.repayTyp}</td>
				</tr>
				<tr>
					<td>bgnDate</td>
					<td>${invstAcctReg.bgnDate}</td>
				</tr>
				<tr>
					<td>endDate</td>
					<td>${invstAcctReg.endDate}</td>
				</tr>
				<tr>
					<td>lockTyp</td>
					<td>${invstAcctReg.lockTyp}</td>
				</tr>
				<tr>
					<td>mthRepayDay</td>
					<td>${invstAcctReg.mthRepayDay}</td>
				</tr>
				<tr>
					<td>mthRepayAmt</td>
					<td>${invstAcctReg.mthRepayAmt}</td>
				</tr>
				<tr>
					<td>totlRepayAmt</td>
					<td>${invstAcctReg.totlRepayAmt}</td>
				</tr>
				<tr>
					<td>clrDate</td>
					<td>${invstAcctReg.clrDate}</td>
				</tr>
				<tr>
					<td>invstStat</td>
					<td>${invstAcctReg.invstStat}</td>
				</tr>
				<tr>
					<td>fstRepayDate</td>
					<td>${invstAcctReg.fstRepayDate}</td>
				</tr>
				<tr>
					<td>invstDesc</td>
					<td>${invstAcctReg.invstDesc}</td>
				</tr>
				<tr>
					<td>instDate</td>
					<td>${invstAcctReg.instDate}</td>
				</tr>
				<tr>
					<td>updtDate</td>
					<td>${invstAcctReg.updtDate}</td>
				</tr>
				<tr>
					<td>redomAmt</td>
					<td>${invstAcctReg.redomAmt}</td>
				</tr>
				<tr>
					<td>batFlag</td>
					<td>${invstAcctReg.batFlag}</td>
				</tr>
				<tr>
					<td>recordStat</td>
					<td>${invstAcctReg.recordStat}</td>
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