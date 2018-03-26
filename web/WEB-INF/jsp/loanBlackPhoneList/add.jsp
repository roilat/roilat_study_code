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
		<form id="loanBlackPhoneListForm" action="post">
		<table class="table_list">
			<tr>
				<td>tableKey</td>
				<td><input type="text" id="tableKey" name="tableKey" data-validaterole="tableKey" data-rule="tableKey" value="" /></td>
			</tr>
			<tr>
				<td>phoneNum</td>
				<td><input type="text" id="phoneNum" name="phoneNum" data-validaterole="phoneNum" data-rule="phoneNum" value="" /></td>
			</tr>
			<tr>
				<td>certType</td>
				<td><input type="text" id="certType" name="certType" data-validaterole="certType" data-rule="certType" value="" /></td>
			</tr>
			<tr>
				<td>certNo</td>
				<td><input type="text" id="certNo" name="certNo" data-validaterole="certNo" data-rule="certNo" value="" /></td>
			</tr>
			<tr>
				<td>listStatus</td>
				<td><input type="text" id="listStatus" name="listStatus" data-validaterole="listStatus" data-rule="listStatus" value="" /></td>
			</tr>
			<tr>
				<td>listType</td>
				<td><input type="text" id="listType" name="listType" data-validaterole="listType" data-rule="listType" value="" /></td>
			</tr>
			<tr>
				<td>remark</td>
				<td><textarea id="remark" name="remark" data-validaterole="remark" data-rule="remark"</textarea></td>
			</tr>
			<tr>
				<td>createUser</td>
				<td><input type="text" id="createUser" name="createUser" data-validaterole="createUser" data-rule="createUser" value="" /></td>
			</tr>
			<tr>
				<td>createTime</td>
				<td><input type="text" id="createTime" name="createTime" data-validaterole="createTime" data-rule="createTime" value="" /></td>
			</tr>
			<tr>
				<td>checkUser</td>
				<td><input type="text" id="checkUser" name="checkUser" data-validaterole="checkUser" data-rule="checkUser" value="" /></td>
			</tr>
			<tr>
				<td>checkTime</td>
				<td><input type="text" id="checkTime" name="checkTime" data-validaterole="checkTime" data-rule="checkTime" value="" /></td>
			</tr>
			<tr>
				<td>cardNo</td>
				<td><input type="text" id="cardNo" name="cardNo" data-validaterole="cardNo" data-rule="cardNo" value="" /></td>
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
					con : "#loanBlackPhoneListForm",// 验证容器
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
					var serializedForm = $("#loanBlackPhoneListForm").serialize();
					$.post("${ctx}/loanBlackPhoneList/add.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/loanBlackPhoneList/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.loanBlackPhoneListDialog.close();
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