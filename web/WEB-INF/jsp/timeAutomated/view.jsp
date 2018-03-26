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
					<td>priNumber</td>
					<td>${timeAutomated.priNumber}</td>
				</tr>
				<tr>
					<td>员工编号</td>
					<td>${timeAutomated.empNo}</td>
				</tr>
				<tr>
					<td>工资年月</td>
					<td>${timeAutomated.gzYm}</td>
				</tr>
				<tr>
					<td>当月天数</td>
					<td>${timeAutomated.days}</td>
				</tr>
				<tr>
					<td>创建时间</td>
					<td>${timeAutomated.createTime}</td>
				</tr>
				<tr>
					<td>修改时间</td>
					<td>${timeAutomated.updateTime}</td>
				</tr>
				<tr>
					<td>创建人</td>
					<td>${timeAutomated.creator}</td>
				</tr>
				<tr>
					<td>修改人</td>
					<td>${timeAutomated.updator}</td>
				</tr>
				<tr>
					<td>职位</td>
					<td>${timeAutomated.jobName}</td>
				</tr>
				<tr>
					<td>one</td>
					<td>${timeAutomated.one}</td>
				</tr>
				<tr>
					<td>two</td>
					<td>${timeAutomated.two}</td>
				</tr>
				<tr>
					<td>three</td>
					<td>${timeAutomated.three}</td>
				</tr>
				<tr>
					<td>four</td>
					<td>${timeAutomated.four}</td>
				</tr>
				<tr>
					<td>five</td>
					<td>${timeAutomated.five}</td>
				</tr>
				<tr>
					<td>six</td>
					<td>${timeAutomated.six}</td>
				</tr>
				<tr>
					<td>seven</td>
					<td>${timeAutomated.seven}</td>
				</tr>
				<tr>
					<td>eight</td>
					<td>${timeAutomated.eight}</td>
				</tr>
				<tr>
					<td>nine</td>
					<td>${timeAutomated.nine}</td>
				</tr>
				<tr>
					<td>ten</td>
					<td>${timeAutomated.ten}</td>
				</tr>
				<tr>
					<td>eleven</td>
					<td>${timeAutomated.eleven}</td>
				</tr>
				<tr>
					<td>twelve</td>
					<td>${timeAutomated.twelve}</td>
				</tr>
				<tr>
					<td>thirteen</td>
					<td>${timeAutomated.thirteen}</td>
				</tr>
				<tr>
					<td>fourteen</td>
					<td>${timeAutomated.fourteen}</td>
				</tr>
				<tr>
					<td>fifteen</td>
					<td>${timeAutomated.fifteen}</td>
				</tr>
				<tr>
					<td>sixteen</td>
					<td>${timeAutomated.sixteen}</td>
				</tr>
				<tr>
					<td>seventeen</td>
					<td>${timeAutomated.seventeen}</td>
				</tr>
				<tr>
					<td>eighteen</td>
					<td>${timeAutomated.eighteen}</td>
				</tr>
				<tr>
					<td>nineteen</td>
					<td>${timeAutomated.nineteen}</td>
				</tr>
				<tr>
					<td>twenty</td>
					<td>${timeAutomated.twenty}</td>
				</tr>
				<tr>
					<td>twentyOne</td>
					<td>${timeAutomated.twentyOne}</td>
				</tr>
				<tr>
					<td>twentyTwo</td>
					<td>${timeAutomated.twentyTwo}</td>
				</tr>
				<tr>
					<td>twentyThree</td>
					<td>${timeAutomated.twentyThree}</td>
				</tr>
				<tr>
					<td>twentyFour</td>
					<td>${timeAutomated.twentyFour}</td>
				</tr>
				<tr>
					<td>twentyFive</td>
					<td>${timeAutomated.twentyFive}</td>
				</tr>
				<tr>
					<td>twentySix</td>
					<td>${timeAutomated.twentySix}</td>
				</tr>
				<tr>
					<td>twentySeven</td>
					<td>${timeAutomated.twentySeven}</td>
				</tr>
				<tr>
					<td>twentyEight</td>
					<td>${timeAutomated.twentyEight}</td>
				</tr>
				<tr>
					<td>twentyNine</td>
					<td>${timeAutomated.twentyNine}</td>
				</tr>
				<tr>
					<td>thirty</td>
					<td>${timeAutomated.thirty}</td>
				</tr>
				<tr>
					<td>thirtyOne</td>
					<td>${timeAutomated.thirtyOne}</td>
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