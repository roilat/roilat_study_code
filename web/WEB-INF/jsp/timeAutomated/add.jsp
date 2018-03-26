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
		<form id="timeAutomatedForm" action="post">
		<table class="table_list">
			<tr>
				<td>priNumber</td>
				<td><input type="text" id="priNumber" name="priNumber" data-validaterole="priNumber" data-rule="priNumber" value="" /></td>
			</tr>
			<tr>
				<td>员工编号</td>
				<td><input type="text" id="empNo" name="empNo" data-validaterole="empNo" data-rule="empNo" value="" /></td>
			</tr>
			<tr>
				<td>工资年月</td>
				<td><input type="text" id="gzYm" name="gzYm" data-validaterole="gzYm" data-rule="gzYm" value="" /></td>
			</tr>
			<tr>
				<td>当月天数</td>
				<td><input type="text" id="days" name="days" data-validaterole="days" data-rule="days" value="" /></td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td><input type="text" id="createTime" name="createTime" data-validaterole="createTime" data-rule="createTime" value="" /></td>
			</tr>
			<tr>
				<td>修改时间</td>
				<td><input type="text" id="updateTime" name="updateTime" data-validaterole="updateTime" data-rule="updateTime" value="" /></td>
			</tr>
			<tr>
				<td>创建人</td>
				<td><input type="text" id="creator" name="creator" data-validaterole="creator" data-rule="creator" value="" /></td>
			</tr>
			<tr>
				<td>修改人</td>
				<td><input type="text" id="updator" name="updator" data-validaterole="updator" data-rule="updator" value="" /></td>
			</tr>
			<tr>
				<td>职位</td>
				<td><input type="text" id="jobName" name="jobName" data-validaterole="jobName" data-rule="jobName" value="" /></td>
			</tr>
			<tr>
				<td>one</td>
				<td><input type="text" id="one" name="one" data-validaterole="one" data-rule="one" value="" /></td>
			</tr>
			<tr>
				<td>two</td>
				<td><input type="text" id="two" name="two" data-validaterole="two" data-rule="two" value="" /></td>
			</tr>
			<tr>
				<td>three</td>
				<td><input type="text" id="three" name="three" data-validaterole="three" data-rule="three" value="" /></td>
			</tr>
			<tr>
				<td>four</td>
				<td><input type="text" id="four" name="four" data-validaterole="four" data-rule="four" value="" /></td>
			</tr>
			<tr>
				<td>five</td>
				<td><input type="text" id="five" name="five" data-validaterole="five" data-rule="five" value="" /></td>
			</tr>
			<tr>
				<td>six</td>
				<td><input type="text" id="six" name="six" data-validaterole="six" data-rule="six" value="" /></td>
			</tr>
			<tr>
				<td>seven</td>
				<td><input type="text" id="seven" name="seven" data-validaterole="seven" data-rule="seven" value="" /></td>
			</tr>
			<tr>
				<td>eight</td>
				<td><input type="text" id="eight" name="eight" data-validaterole="eight" data-rule="eight" value="" /></td>
			</tr>
			<tr>
				<td>nine</td>
				<td><input type="text" id="nine" name="nine" data-validaterole="nine" data-rule="nine" value="" /></td>
			</tr>
			<tr>
				<td>ten</td>
				<td><input type="text" id="ten" name="ten" data-validaterole="ten" data-rule="ten" value="" /></td>
			</tr>
			<tr>
				<td>eleven</td>
				<td><input type="text" id="eleven" name="eleven" data-validaterole="eleven" data-rule="eleven" value="" /></td>
			</tr>
			<tr>
				<td>twelve</td>
				<td><input type="text" id="twelve" name="twelve" data-validaterole="twelve" data-rule="twelve" value="" /></td>
			</tr>
			<tr>
				<td>thirteen</td>
				<td><input type="text" id="thirteen" name="thirteen" data-validaterole="thirteen" data-rule="thirteen" value="" /></td>
			</tr>
			<tr>
				<td>fourteen</td>
				<td><input type="text" id="fourteen" name="fourteen" data-validaterole="fourteen" data-rule="fourteen" value="" /></td>
			</tr>
			<tr>
				<td>fifteen</td>
				<td><input type="text" id="fifteen" name="fifteen" data-validaterole="fifteen" data-rule="fifteen" value="" /></td>
			</tr>
			<tr>
				<td>sixteen</td>
				<td><input type="text" id="sixteen" name="sixteen" data-validaterole="sixteen" data-rule="sixteen" value="" /></td>
			</tr>
			<tr>
				<td>seventeen</td>
				<td><input type="text" id="seventeen" name="seventeen" data-validaterole="seventeen" data-rule="seventeen" value="" /></td>
			</tr>
			<tr>
				<td>eighteen</td>
				<td><input type="text" id="eighteen" name="eighteen" data-validaterole="eighteen" data-rule="eighteen" value="" /></td>
			</tr>
			<tr>
				<td>nineteen</td>
				<td><input type="text" id="nineteen" name="nineteen" data-validaterole="nineteen" data-rule="nineteen" value="" /></td>
			</tr>
			<tr>
				<td>twenty</td>
				<td><input type="text" id="twenty" name="twenty" data-validaterole="twenty" data-rule="twenty" value="" /></td>
			</tr>
			<tr>
				<td>twentyOne</td>
				<td><input type="text" id="twentyOne" name="twentyOne" data-validaterole="twentyOne" data-rule="twentyOne" value="" /></td>
			</tr>
			<tr>
				<td>twentyTwo</td>
				<td><input type="text" id="twentyTwo" name="twentyTwo" data-validaterole="twentyTwo" data-rule="twentyTwo" value="" /></td>
			</tr>
			<tr>
				<td>twentyThree</td>
				<td><input type="text" id="twentyThree" name="twentyThree" data-validaterole="twentyThree" data-rule="twentyThree" value="" /></td>
			</tr>
			<tr>
				<td>twentyFour</td>
				<td><input type="text" id="twentyFour" name="twentyFour" data-validaterole="twentyFour" data-rule="twentyFour" value="" /></td>
			</tr>
			<tr>
				<td>twentyFive</td>
				<td><input type="text" id="twentyFive" name="twentyFive" data-validaterole="twentyFive" data-rule="twentyFive" value="" /></td>
			</tr>
			<tr>
				<td>twentySix</td>
				<td><input type="text" id="twentySix" name="twentySix" data-validaterole="twentySix" data-rule="twentySix" value="" /></td>
			</tr>
			<tr>
				<td>twentySeven</td>
				<td><input type="text" id="twentySeven" name="twentySeven" data-validaterole="twentySeven" data-rule="twentySeven" value="" /></td>
			</tr>
			<tr>
				<td>twentyEight</td>
				<td><input type="text" id="twentyEight" name="twentyEight" data-validaterole="twentyEight" data-rule="twentyEight" value="" /></td>
			</tr>
			<tr>
				<td>twentyNine</td>
				<td><input type="text" id="twentyNine" name="twentyNine" data-validaterole="twentyNine" data-rule="twentyNine" value="" /></td>
			</tr>
			<tr>
				<td>thirty</td>
				<td><input type="text" id="thirty" name="thirty" data-validaterole="thirty" data-rule="thirty" value="" /></td>
			</tr>
			<tr>
				<td>thirtyOne</td>
				<td><input type="text" id="thirtyOne" name="thirtyOne" data-validaterole="thirtyOne" data-rule="thirtyOne" value="" /></td>
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
					con : "#timeAutomatedForm",// 验证容器
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
					var serializedForm = $("#timeAutomatedForm").serialize();
					$.post("${ctx}/timeAutomated/add.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/timeAutomated/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.timeAutomatedDialog.close();
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