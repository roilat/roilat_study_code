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
		<form id="prodLoanRelForm" action="post">
		<table class="table_list">
			<tr>
				<td>prodTyp</td>
				<td><input type="text" id="prodTyp" name="prodTyp" data-validaterole="prodTyp" data-rule="prodTyp" value="" /></td>
			</tr>
			<tr>
				<td>loanNo</td>
				<td><input type="text" id="loanNo" name="loanNo" data-validaterole="loanNo" data-rule="loanNo" value="" /></td>
			</tr>
			<tr>
				<td>redomNo</td>
				<td><input type="text" id="redomNo" name="redomNo" data-validaterole="redomNo" data-rule="redomNo" value="" /></td>
			</tr>
			<tr>
				<td>prodNo</td>
				<td><input type="text" id="prodNo" name="prodNo" data-validaterole="prodNo" data-rule="prodNo" value="" /></td>
			</tr>
			<tr>
				<td>prodName</td>
				<td><input type="text" id="prodName" name="prodName" data-validaterole="prodName" data-rule="prodName" value="" /></td>
			</tr>
			<tr>
				<td>prodPerd</td>
				<td><input type="text" id="prodPerd" name="prodPerd" data-validaterole="prodPerd" data-rule="prodPerd" value="" /></td>
			</tr>
			<tr>
				<td>loanCustNo</td>
				<td><input type="text" id="loanCustNo" name="loanCustNo" data-validaterole="loanCustNo" data-rule="loanCustNo" value="" /></td>
			</tr>
			<tr>
				<td>loanCustName</td>
				<td><input type="text" id="loanCustName" name="loanCustName" data-validaterole="loanCustName" data-rule="loanCustName" value="" /></td>
			</tr>
			<tr>
				<td>marginAmt</td>
				<td><input type="text" id="marginAmt" name="marginAmt" data-validaterole="marginAmt" data-rule="marginAmt" value="" /></td>
			</tr>
			<tr>
				<td>loanAmt</td>
				<td><input type="text" id="loanAmt" name="loanAmt" data-validaterole="loanAmt" data-rule="loanAmt" value="" /></td>
			</tr>
			<tr>
				<td>actualAmt</td>
				<td><input type="text" id="actualAmt" name="actualAmt" data-validaterole="actualAmt" data-rule="actualAmt" value="" /></td>
			</tr>
			<tr>
				<td>invstFlag</td>
				<td><input type="text" id="invstFlag" name="invstFlag" data-validaterole="invstFlag" data-rule="invstFlag" value="" /></td>
			</tr>
			<tr>
				<td>instDate</td>
				<td><input type="text" id="instDate" name="instDate" data-validaterole="instDate" data-rule="instDate" value="" /></td>
			</tr>
			<tr>
				<td>updtDate</td>
				<td><input type="text" id="updtDate" name="updtDate" data-validaterole="updtDate" data-rule="updtDate" value="" /></td>
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
					con : "#prodLoanRelForm",// 验证容器
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
					var serializedForm = $("#prodLoanRelForm").serialize();
					$.post("${ctx}/prodLoanRel/add.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/prodLoanRel/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.prodLoanRelDialog.close();
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