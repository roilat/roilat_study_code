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
<script src="${ctx}/js/component/modal.js" type="text/javascript"></script>
<script src="${ctx}/js/lib/jquery-ui.custom.js" type="text/javascript"></script>


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
		<form id="vacateManageForm">
			<input type="hidden" name="priNumber" value="${vacateManage.priNumber}" />
			<table class="table_list">
				<tr>
					<td>主键ID</td>
					<td><input type="text" id="priNumber" name="priNumber" data-validaterole="priNumber" data-rule="priNumber" value="${vacateManage.priNumber}" /></td>
				</tr>
				<tr>
					<td>员工编码</td>
					<td><input type="text" id="empNo" name="empNo" data-validaterole="empNo" data-rule="empNo" value="${vacateManage.empNo}" /></td>
				</tr>
				<tr>
					<td>员工姓名</td>
					<td><input type="text" id="empName" name="empName" data-validaterole="empName" data-rule="empName" value="${vacateManage.empName}" /></td>
				</tr>
				<tr>
					<td>大区编码</td>
					<td><input type="text" id="regionCode" name="regionCode" data-validaterole="regionCode" data-rule="regionCode" value="${vacateManage.regionCode}" /></td>
				</tr>
				<tr>
					<td>分公司编码</td>
					<td><input type="text" id="filialeCode" name="filialeCode" data-validaterole="filialeCode" data-rule="filialeCode" value="${vacateManage.filialeCode}" /></td>
				</tr>
				<tr>
					<td>营业部编码</td>
					<td><input type="text" id="businessdeptCode" name="businessdeptCode" data-validaterole="businessdeptCode" data-rule="businessdeptCode" value="${vacateManage.businessdeptCode}" /></td>
				</tr>
				<tr>
					<td>团队编码</td>
					<td><input type="text" id="teamCode" name="teamCode" data-validaterole="teamCode" data-rule="teamCode" value="${vacateManage.teamCode}" /></td>
				</tr>
				<tr>
					<td>部门编码</td>
					<td><input type="text" id="deptCode" name="deptCode" data-validaterole="deptCode" data-rule="deptCode" value="${vacateManage.deptCode}" /></td>
				</tr>
				<tr>
					<td>请假类型</td>
					<td><input type="text" id="leaveType" name="leaveType" data-validaterole="leaveType" data-rule="leaveType" value="${vacateManage.leaveType}" /></td>
				</tr>
				<tr>
					<td>职务</td>
					<td><input type="text" id="post" name="post" data-validaterole="post" data-rule="post" value="${vacateManage.post}" /></td>
				</tr>
				<tr>
					<td>职级类别</td>
					<td><input type="text" id="rankType" name="rankType" data-validaterole="rankType" data-rule="rankType" value="${vacateManage.rankType}" /></td>
				</tr>
				<tr>
					<td>请假开始时间到结束的时间</td>
					<td><input type="text" id="leaveInterval" name="leaveInterval" data-validaterole="leaveInterval" data-rule="leaveInterval" value="${vacateManage.leaveInterval}" /></td>
				</tr>
				<tr>
					<td>开始时间</td>
					<td><input type="text" id="startTime" name="startTime" data-validaterole="startTime" data-rule="startTime" value="${vacateManage.startTime}" /></td>
				</tr>
				<tr>
					<td>结束时间</td>
					<td><input type="text" id="endTime" name="endTime" data-validaterole="endTime" data-rule="endTime" value="${vacateManage.endTime}" /></td>
				</tr>
				<tr>
					<td>合计时间</td>
					<td><input type="text" id="totalTime" name="totalTime" data-validaterole="totalTime" data-rule="totalTime" value="${vacateManage.totalTime}" /></td>
				</tr>
				<tr>
					<td>开始时间对应月份</td>
					<td><input type="text" id="starttimeCorspmonth" name="starttimeCorspmonth" data-validaterole="starttimeCorspmonth" data-rule="starttimeCorspmonth" value="${vacateManage.starttimeCorspmonth}" /></td>
				</tr>
				<tr>
					<td>结束时间对应月份</td>
					<td><input type="text" id="endtimeCorspmonth" name="endtimeCorspmonth" data-validaterole="endtimeCorspmonth" data-rule="endtimeCorspmonth" value="${vacateManage.endtimeCorspmonth}" /></td>
				</tr>
				<tr>
					<td>开始时间在月份的合计时间</td>
					<td><input type="text" id="dayBystart" name="dayBystart" data-validaterole="dayBystart" data-rule="dayBystart" value="${vacateManage.dayBystart}" /></td>
				</tr>
				<tr>
					<td>结束时间所在月份的时间</td>
					<td><input type="text" id="dayByend" name="dayByend" data-validaterole="dayByend" data-rule="dayByend" value="${vacateManage.dayByend}" /></td>
				</tr>
				<tr>
					<td>请假原因</td>
					<td><input type="text" id="leaveReason" name="leaveReason" data-validaterole="leaveReason" data-rule="leaveReason" value="${vacateManage.leaveReason}" /></td>
				</tr>
				<tr>
					<td>状态</td>
					<td><input type="text" id="status" name="status" data-validaterole="status" data-rule="status" value="${vacateManage.status}" /></td>
				</tr>
				<tr>
					<td>审核意见</td>
					<td><input type="text" id="auditOpinion" name="auditOpinion" data-validaterole="auditOpinion" data-rule="auditOpinion" value="${vacateManage.auditOpinion}" /></td>
				</tr>
				<tr>
					<td>请休假对应操作的月份</td>
					<td><input type="text" id="dateofLeave" name="dateofLeave" data-validaterole="dateofLeave" data-rule="dateofLeave" value="${vacateManage.dateofLeave}" /></td>
				</tr>
				<tr>
					<td>创建人</td>
					<td><input type="text" id="createUser" name="createUser" data-validaterole="createUser" data-rule="createUser" value="${vacateManage.createUser}" /></td>
				</tr>
				<tr>
					<td>某个营业部登录并且录入城市经理时做记录</td>
					<td><input type="text" id="salescreateflag" name="salescreateflag" data-validaterole="salescreateflag" data-rule="salescreateflag" value="${vacateManage.salescreateflag}" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" id="editBtn" value="保存" />
					</td>
				</tr>
			</table>			
		</form>
	</div>
	
	<script type="text/javascript">
		$(function(){
			// 验证
			seajs.use(["component/validate","component/tip"], function (validate,tip) {
				var ntip = function(){
		         	// 定义一个提示对象
					var t = new tip({
						content: 'hello tip',
						hasArrow: true,
						arrowOption: { dir: "left", position: { top:8 } },
						con: "body",
						hasCloseBtn: false,
						position: { my: "center", at: "center", of: "#tipcon" },
						css: { width: "120" }
					});
		         	return t;	
				};
				
				// 定义一个验证对象
	            var d = new validate({
					con : "#vacateManageForm",// 验证容器
					onSubmit : "#editBtn",// 提交按钮
					eachInvalidField : function(res,field){// 验证不通过的处理
						var oldTip = field.data("tip");
						var tip;
						if(typeof oldTip == "undefined"){
							tip = ntip();
							field.data("tip",tip);
						}else{
							tip = oldTip;
						}
						tip.setContent(res.message);
						tip.setPosition({ my: "left center-15", at: "right+10 center", of: field });
						tip.show();
					},
					eachValidField : function(res,field){// 验证通过则隐藏提示
						var oldTip = field.data("tip");
						var tip;
						if(typeof oldTip == "undefined"){
						   
						}else{
							tip = oldTip;
							tip.hide();
						}
					}
				});
				
				// 设置拼装规则
				// d.setValidateRule({ dsName : ["isBlank"] });
				
				// 注册保存按钮事件
				d.bind("onsubmit",function(){
					// 序列化表单参数
					var serializedForm = $("#vacateManageForm").serialize();
					$.post("${ctx}/vacateManage/edit.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/vacateManage/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.vacateManageDialog.close();
			            } else {
			            	alert("操作失败");
			            }
			        }, "json");
	        	});
			});
		});
	</script>
</body>
</html>