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
		<form id="invstRechgWithdCashForm" action="post">
		<table class="table_list">
			<tr>
				<td>rechgWithdNo</td>
				<td><input type="text" id="rechgWithdNo" name="rechgWithdNo" data-validaterole="rechgWithdNo" data-rule="rechgWithdNo" value="" /></td>
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
				<td>txDate</td>
				<td><input type="text" id="txDate" name="txDate" data-validaterole="txDate" data-rule="txDate" value="" /></td>
			</tr>
			<tr>
				<td>acctNo</td>
				<td><input type="text" id="acctNo" name="acctNo" data-validaterole="acctNo" data-rule="acctNo" value="" /></td>
			</tr>
			<tr>
				<td>txAmt</td>
				<td><input type="text" id="txAmt" name="txAmt" data-validaterole="txAmt" data-rule="txAmt" value="" /></td>
			</tr>
			<tr>
				<td>BAL</td>
				<td><input type="text" id="BAL" name="BAL" data-validaterole="BAL" data-rule="BAL" value="" /></td>
			</tr>
			<tr>
				<td>bankNo</td>
				<td><input type="text" id="bankNo" name="bankNo" data-validaterole="bankNo" data-rule="bankNo" value="" /></td>
			</tr>
			<tr>
				<td>bankName</td>
				<td><input type="text" id="bankName" name="bankName" data-validaterole="bankName" data-rule="bankName" value="" /></td>
			</tr>
			<tr>
				<td>cardNo</td>
				<td><input type="text" id="cardNo" name="cardNo" data-validaterole="cardNo" data-rule="cardNo" value="" /></td>
			</tr>
			<tr>
				<td>txFee</td>
				<td><input type="text" id="txFee" name="txFee" data-validaterole="txFee" data-rule="txFee" value="" /></td>
			</tr>
			<tr>
				<td>feeAcctNo</td>
				<td><input type="text" id="feeAcctNo" name="feeAcctNo" data-validaterole="feeAcctNo" data-rule="feeAcctNo" value="" /></td>
			</tr>
			<tr>
				<td>feeAcctName</td>
				<td><input type="text" id="feeAcctName" name="feeAcctName" data-validaterole="feeAcctName" data-rule="feeAcctName" value="" /></td>
			</tr>
			<tr>
				<td>txCod</td>
				<td><input type="text" id="txCod" name="txCod" data-validaterole="txCod" data-rule="txCod" value="" /></td>
			</tr>
			<tr>
				<td>txStat</td>
				<td><input type="text" id="txStat" name="txStat" data-validaterole="txStat" data-rule="txStat" value="" /></td>
			</tr>
			<tr>
				<td>txDesc</td>
				<td><input type="text" id="txDesc" name="txDesc" data-validaterole="txDesc" data-rule="txDesc" value="" /></td>
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
					con : "#invstRechgWithdCashForm",// 验证容器
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
					var serializedForm = $("#invstRechgWithdCashForm").serialize();
					$.post("${ctx}/invstRechgWithdCash/add.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/invstRechgWithdCash/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.invstRechgWithdCashDialog.close();
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