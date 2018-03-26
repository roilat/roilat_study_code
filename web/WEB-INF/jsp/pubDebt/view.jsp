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
					<td>债券编号</td>
					<td>${pubDebt.debtNo}</td>
				</tr>
				<tr>
					<td>原始产品编号</td>
					<td>${pubDebt.prodNo}</td>
				</tr>
				<tr>
					<td>原始产品名称</td>
					<td>${pubDebt.prodName}</td>
				</tr>
				<tr>
					<td>原始投资编号</td>
					<td>${pubDebt.invstNo}</td>
				</tr>
				<tr>
					<td>还款方式</td>
					<td>${pubDebt.repayTyp}</td>
				</tr>
				<tr>
					<td>转让用户</td>
					<td>${pubDebt.custNo}</td>
				</tr>
				<tr>
					<td>原始产品期限</td>
					<td>${pubDebt.prodPerd}</td>
				</tr>
				<tr>
					<td>转让金额</td>
					<td>${pubDebt.debtAmt}</td>
				</tr>
				<tr>
					<td>转让类型</td>
					<td>${pubDebt.debtType}</td>
				</tr>
				<tr>
					<td>dedtFeeRat</td>
					<td>${pubDebt.dedtFeeRat}</td>
				</tr>
				<tr>
					<td>折价率</td>
					<td>${pubDebt.discountRat}</td>
				</tr>
				<tr>
					<td>实际收益率</td>
					<td>${pubDebt.prftRat}</td>
				</tr>
				<tr>
					<td>原始产品金额</td>
					<td>${pubDebt.loanAmt}</td>
				</tr>
				<tr>
					<td>原始投资金额</td>
					<td>${pubDebt.invstAmt}</td>
				</tr>
				<tr>
					<td>转让利息</td>
					<td>${pubDebt.dettolIntAmt}</td>
				</tr>
				<tr>
					<td>产品剩余期数</td>
					<td>${pubDebt.debtPerd}</td>
				</tr>
				<tr>
					<td>产品开始时间</td>
					<td>${pubDebt.bgnDate}</td>
				</tr>
				<tr>
					<td>产品到期日</td>
					<td>${pubDebt.endDate}</td>
				</tr>
				<tr>
					<td>产品剩余天数</td>
					<td>${pubDebt.days}</td>
				</tr>
				<tr>
					<td>申请时间</td>
					<td>${pubDebt.applyDate}</td>
				</tr>
				<tr>
					<td>转让时间</td>
					<td>${pubDebt.startDate}</td>
				</tr>
				<tr>
					<td>sellTmsp</td>
					<td>${pubDebt.sellTmsp}</td>
				</tr>
				<tr>
					<td>截止时间</td>
					<td>${pubDebt.bidDueDate}</td>
				</tr>
				<tr>
					<td>minInvstAmt</td>
					<td>${pubDebt.minInvstAmt}</td>
				</tr>
				<tr>
					<td>maxInvstAmt</td>
					<td>${pubDebt.maxInvstAmt}</td>
				</tr>
				<tr>
					<td>转让状态</td>
					<td>${pubDebt.debtStat}</td>
				</tr>
				<tr>
					<td>备注</td>
					<td>${pubDebt.prodRemk}</td>
				</tr>
				<tr>
					<td>创建日期</td>
					<td>${pubDebt.instDate}</td>
				</tr>
				<tr>
					<td>修改日期</td>
					<td>${pubDebt.updtDate}</td>
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