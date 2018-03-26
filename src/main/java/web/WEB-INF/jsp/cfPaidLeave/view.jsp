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
					<td>唯一标识符</td>
					<td>${cfPaidLeave.priNumber}</td>
				</tr>
				<tr>
					<td>工资年月</td>
					<td>${cfPaidLeave.gzym}</td>
				</tr>
				<tr>
					<td>工作日调休天数</td>
					<td>${cfPaidLeave.paidLeaveDays}</td>
				</tr>
				<tr>
					<td>周末调休天数</td>
					<td>${cfPaidLeave.weekendPaidLeave}</td>
				</tr>
				<tr>
					<td>描述</td>
					<td>${cfPaidLeave.comments}</td>
				</tr>
				<tr>
					<td>创建人姓名</td>
					<td>${cfPaidLeave.createName}</td>
				</tr>
				<tr>
					<td>创建时间</td>
					<td>${cfPaidLeave.createDate}</td>
				</tr>
				<tr>
					<td>修改人姓名</td>
					<td>${cfPaidLeave.updateName}</td>
				</tr>
				<tr>
					<td>修改时间</td>
					<td>${cfPaidLeave.updateDate}</td>
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