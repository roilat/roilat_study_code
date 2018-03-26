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
					<td>主键ID</td>
					<td>${vacateManage.priNumber}</td>
				</tr>
				<tr>
					<td>员工编码</td>
					<td>${vacateManage.empNo}</td>
				</tr>
				<tr>
					<td>员工姓名</td>
					<td>${vacateManage.empName}</td>
				</tr>
				<tr>
					<td>大区编码</td>
					<td>${vacateManage.regionCode}</td>
				</tr>
				<tr>
					<td>分公司编码</td>
					<td>${vacateManage.filialeCode}</td>
				</tr>
				<tr>
					<td>营业部编码</td>
					<td>${vacateManage.businessdeptCode}</td>
				</tr>
				<tr>
					<td>团队编码</td>
					<td>${vacateManage.teamCode}</td>
				</tr>
				<tr>
					<td>部门编码</td>
					<td>${vacateManage.deptCode}</td>
				</tr>
				<tr>
					<td>请假类型</td>
					<td>${vacateManage.leaveType}</td>
				</tr>
				<tr>
					<td>职务</td>
					<td>${vacateManage.post}</td>
				</tr>
				<tr>
					<td>职级类别</td>
					<td>${vacateManage.rankType}</td>
				</tr>
				<tr>
					<td>请假开始时间到结束的时间</td>
					<td>${vacateManage.leaveInterval}</td>
				</tr>
				<tr>
					<td>开始时间</td>
					<td>${vacateManage.startTime}</td>
				</tr>
				<tr>
					<td>结束时间</td>
					<td>${vacateManage.endTime}</td>
				</tr>
				<tr>
					<td>合计时间</td>
					<td>${vacateManage.totalTime}</td>
				</tr>
				<tr>
					<td>开始时间对应月份</td>
					<td>${vacateManage.starttimeCorspmonth}</td>
				</tr>
				<tr>
					<td>结束时间对应月份</td>
					<td>${vacateManage.endtimeCorspmonth}</td>
				</tr>
				<tr>
					<td>开始时间在月份的合计时间</td>
					<td>${vacateManage.dayBystart}</td>
				</tr>
				<tr>
					<td>结束时间所在月份的时间</td>
					<td>${vacateManage.dayByend}</td>
				</tr>
				<tr>
					<td>请假原因</td>
					<td>${vacateManage.leaveReason}</td>
				</tr>
				<tr>
					<td>状态</td>
					<td>${vacateManage.status}</td>
				</tr>
				<tr>
					<td>审核意见</td>
					<td>${vacateManage.auditOpinion}</td>
				</tr>
				<tr>
					<td>请休假对应操作的月份</td>
					<td>${vacateManage.dateofLeave}</td>
				</tr>
				<tr>
					<td>创建人</td>
					<td>${vacateManage.createUser}</td>
				</tr>
				<tr>
					<td>某个营业部登录并且录入城市经理时做记录</td>
					<td>${vacateManage.salescreateflag}</td>
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