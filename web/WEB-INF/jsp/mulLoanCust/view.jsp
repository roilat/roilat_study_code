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
					<td>客户姓名</td>
					<td>${mulLoanCust.custName}</td>
				</tr>
				<tr>
					<td>证件类型</td>
					<td>${mulLoanCust.certType}</td>
				</tr>
				<tr>
					<td>证件号</td>
					<td>${mulLoanCust.certNo}</td>
				</tr>
				<tr>
					<td>手机号</td>
					<td>${mulLoanCust.mobileTel}</td>
				</tr>
				<tr>
					<td>借贷公司</td>
					<td>${mulLoanCust.loanCorp}</td>
				</tr>
				<tr>
					<td>插入时间</td>
					<td>${mulLoanCust.insertTime}</td>
				</tr>
				<tr>
					<td>更新日期</td>
					<td>${mulLoanCust.updateTime}</td>
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