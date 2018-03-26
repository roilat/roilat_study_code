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
		<form id="invstAcctRegForm" action="post">
		<table class="table_list">
			<tr>
				<td>invstNo</td>
				<td><input type="text" id="invstNo" name="invstNo" data-validaterole="invstNo" data-rule="invstNo" value="" /></td>
			</tr>
			<tr>
				<td>contrNo</td>
				<td><input type="text" id="contrNo" name="contrNo" data-validaterole="contrNo" data-rule="contrNo" value="" /></td>
			</tr>
			<tr>
				<td>acctNo</td>
				<td><input type="text" id="acctNo" name="acctNo" data-validaterole="acctNo" data-rule="acctNo" value="" /></td>
			</tr>
			<tr>
				<td>invstTyp</td>
				<td><input type="text" id="invstTyp" name="invstTyp" data-validaterole="invstTyp" data-rule="invstTyp" value="" /></td>
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
				<td>custNo</td>
				<td><input type="text" id="custNo" name="custNo" data-validaterole="custNo" data-rule="custNo" value="" /></td>
			</tr>
			<tr>
				<td>custName</td>
				<td><input type="text" id="custName" name="custName" data-validaterole="custName" data-rule="custName" value="" /></td>
			</tr>
			<tr>
				<td>invstDate</td>
				<td><input type="text" id="invstDate" name="invstDate" data-validaterole="invstDate" data-rule="invstDate" value="" /></td>
			</tr>
			<tr>
				<td>acctTyp</td>
				<td><input type="text" id="acctTyp" name="acctTyp" data-validaterole="acctTyp" data-rule="acctTyp" value="" /></td>
			</tr>
			<tr>
				<td>invstAmt</td>
				<td><input type="text" id="invstAmt" name="invstAmt" data-validaterole="invstAmt" data-rule="invstAmt" value="" /></td>
			</tr>
			<tr>
				<td>prodRat</td>
				<td><input type="text" id="prodRat" name="prodRat" data-validaterole="prodRat" data-rule="prodRat" value="" /></td>
			</tr>
			<tr>
				<td>lockRat</td>
				<td><input type="text" id="lockRat" name="lockRat" data-validaterole="lockRat" data-rule="lockRat" value="" /></td>
			</tr>
			<tr>
				<td>busnTyp</td>
				<td><input type="text" id="busnTyp" name="busnTyp" data-validaterole="busnTyp" data-rule="busnTyp" value="" /></td>
			</tr>
			<tr>
				<td>repayTyp</td>
				<td><input type="text" id="repayTyp" name="repayTyp" data-validaterole="repayTyp" data-rule="repayTyp" value="" /></td>
			</tr>
			<tr>
				<td>bgnDate</td>
				<td><input type="text" id="bgnDate" name="bgnDate" data-validaterole="bgnDate" data-rule="bgnDate" value="" /></td>
			</tr>
			<tr>
				<td>endDate</td>
				<td><input type="text" id="endDate" name="endDate" data-validaterole="endDate" data-rule="endDate" value="" /></td>
			</tr>
			<tr>
				<td>lockTyp</td>
				<td><input type="text" id="lockTyp" name="lockTyp" data-validaterole="lockTyp" data-rule="lockTyp" value="" /></td>
			</tr>
			<tr>
				<td>mthRepayDay</td>
				<td><input type="text" id="mthRepayDay" name="mthRepayDay" data-validaterole="mthRepayDay" data-rule="mthRepayDay" value="" /></td>
			</tr>
			<tr>
				<td>mthRepayAmt</td>
				<td><input type="text" id="mthRepayAmt" name="mthRepayAmt" data-validaterole="mthRepayAmt" data-rule="mthRepayAmt" value="" /></td>
			</tr>
			<tr>
				<td>totlRepayAmt</td>
				<td><input type="text" id="totlRepayAmt" name="totlRepayAmt" data-validaterole="totlRepayAmt" data-rule="totlRepayAmt" value="" /></td>
			</tr>
			<tr>
				<td>clrDate</td>
				<td><input type="text" id="clrDate" name="clrDate" data-validaterole="clrDate" data-rule="clrDate" value="" /></td>
			</tr>
			<tr>
				<td>invstStat</td>
				<td><input type="text" id="invstStat" name="invstStat" data-validaterole="invstStat" data-rule="invstStat" value="" /></td>
			</tr>
			<tr>
				<td>fstRepayDate</td>
				<td><input type="text" id="fstRepayDate" name="fstRepayDate" data-validaterole="fstRepayDate" data-rule="fstRepayDate" value="" /></td>
			</tr>
			<tr>
				<td>invstDesc</td>
				<td><input type="text" id="invstDesc" name="invstDesc" data-validaterole="invstDesc" data-rule="invstDesc" value="" /></td>
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
				<td>redomAmt</td>
				<td><input type="text" id="redomAmt" name="redomAmt" data-validaterole="redomAmt" data-rule="redomAmt" value="" /></td>
			</tr>
			<tr>
				<td>batFlag</td>
				<td><input type="text" id="batFlag" name="batFlag" data-validaterole="batFlag" data-rule="batFlag" value="" /></td>
			</tr>
			<tr>
				<td>recordStat</td>
				<td><input type="text" id="recordStat" name="recordStat" data-validaterole="recordStat" data-rule="recordStat" value="" /></td>
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
					con : "#invstAcctRegForm",// 验证容器
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
					var serializedForm = $("#invstAcctRegForm").serialize();
					$.post("${ctx}/invstAcctReg/add.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/invstAcctReg/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.invstAcctRegDialog.close();
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