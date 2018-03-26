<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<!-- 模块化框架配置 -->
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
		<form id="cfPaidLeaveForm" action="post">
		<table class="table_list">
			<tr>
				<td>唯一标识符</td>
				<td><input type="text" id="priNumber" name="priNumber" data-validaterole="priNumber" data-rule="priNumber" value="" /></td>
			</tr>
			<tr>
				<td>工资年月</td>
				<td><input type="text" id="gzym" name="gzym" data-validaterole="gzym" data-rule="gzym" value="" /></td>
			</tr>
			<tr>
				<td>工作日调休天数</td>
				<td><input type="text" id="paidLeaveDays" name="paidLeaveDays" data-validaterole="paidLeaveDays" data-rule="paidLeaveDays" value="" /></td>
			</tr>
			<tr>
				<td>周末调休天数</td>
				<td><input type="text" id="weekendPaidLeave" name="weekendPaidLeave" data-validaterole="weekendPaidLeave" data-rule="weekendPaidLeave" value="" /></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><input type="text" id="comments" name="comments" data-validaterole="comments" data-rule="comments" value="" /></td>
			</tr>
			<tr>
				<td>创建人姓名</td>
				<td><input type="text" id="createName" name="createName" data-validaterole="createName" data-rule="createName" value="" /></td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td><input type="text" id="createDate" name="createDate" data-validaterole="createDate" data-rule="createDate" value="" /></td>
			</tr>
			<tr>
				<td>修改人姓名</td>
				<td><input type="text" id="updateName" name="updateName" data-validaterole="updateName" data-rule="updateName" value="" /></td>
			</tr>
			<tr>
				<td>修改时间</td>
				<td><input type="text" id="updateDate" name="updateDate" data-validaterole="updateDate" data-rule="updateDate" value="" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="addBtn" value="保存" />
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
					con : "#cfPaidLeaveForm",// 验证容器
					onSubmit : "#addBtn",// 提交按钮
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
				
				// 设置拼装规则: 这里加上各个验证规则
				//d.setValidateRule({ dsName : ["isBlank"] });
				
				// 注册保存按钮事件
				d.bind("onsubmit",function(){
					// 序列化表单参数
					var serializedForm = $("#cfPaidLeaveForm").serialize();
					$.post("${ctx}/cfPaidLeave/add.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/cfPaidLeave/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.cfPaidLeaveDialog.close();
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