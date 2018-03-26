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
		<form id="invstAcctIntDtlForm">
			<input type="hidden" name="txSeqNo" value="${invstAcctIntDtl.txSeqNo}" />
			<table class="table_list">
				<tr>
					<td>txSeqNo</td>
					<td><input type="text" id="txSeqNo" name="txSeqNo" data-validaterole="txSeqNo" data-rule="txSeqNo" value="${invstAcctIntDtl.txSeqNo}" /></td>
				</tr>
				<tr>
					<td>serlNo</td>
					<td><input type="text" id="serlNo" name="serlNo" data-validaterole="serlNo" data-rule="serlNo" value="${invstAcctIntDtl.serlNo}" /></td>
				</tr>
				<tr>
					<td>invstNo</td>
					<td><input type="text" id="invstNo" name="invstNo" data-validaterole="invstNo" data-rule="invstNo" value="${invstAcctIntDtl.invstNo}" /></td>
				</tr>
				<tr>
					<td>prftTyp</td>
					<td><input type="text" id="prftTyp" name="prftTyp" data-validaterole="prftTyp" data-rule="prftTyp" value="${invstAcctIntDtl.prftTyp}" /></td>
				</tr>
				<tr>
					<td>txDate</td>
					<td><input type="text" id="txDate" name="txDate" data-validaterole="txDate" data-rule="txDate" value="${invstAcctIntDtl.txDate}" /></td>
				</tr>
				<tr>
					<td>acctNo</td>
					<td><input type="text" id="acctNo" name="acctNo" data-validaterole="acctNo" data-rule="acctNo" value="${invstAcctIntDtl.acctNo}" /></td>
				</tr>
				<tr>
					<td>custNo</td>
					<td><input type="text" id="custNo" name="custNo" data-validaterole="custNo" data-rule="custNo" value="${invstAcctIntDtl.custNo}" /></td>
				</tr>
				<tr>
					<td>custName</td>
					<td><input type="text" id="custName" name="custName" data-validaterole="custName" data-rule="custName" value="${invstAcctIntDtl.custName}" /></td>
				</tr>
				<tr>
					<td>prodNo</td>
					<td><input type="text" id="prodNo" name="prodNo" data-validaterole="prodNo" data-rule="prodNo" value="${invstAcctIntDtl.prodNo}" /></td>
				</tr>
				<tr>
					<td>prodName</td>
					<td><input type="text" id="prodName" name="prodName" data-validaterole="prodName" data-rule="prodName" value="${invstAcctIntDtl.prodName}" /></td>
				</tr>
				<tr>
					<td>subjNo</td>
					<td><input type="text" id="subjNo" name="subjNo" data-validaterole="subjNo" data-rule="subjNo" value="${invstAcctIntDtl.subjNo}" /></td>
				</tr>
				<tr>
					<td>drCrFlag</td>
					<td><input type="text" id="drCrFlag" name="drCrFlag" data-validaterole="drCrFlag" data-rule="drCrFlag" value="${invstAcctIntDtl.drCrFlag}" /></td>
				</tr>
				<tr>
					<td>estIncomeDt</td>
					<td><input type="text" id="estIncomeDt" name="estIncomeDt" data-validaterole="estIncomeDt" data-rule="estIncomeDt" value="${invstAcctIntDtl.estIncomeDt}" /></td>
				</tr>
				<tr>
					<td>estIncomeAmt</td>
					<td><input type="text" id="estIncomeAmt" name="estIncomeAmt" data-validaterole="estIncomeAmt" data-rule="estIncomeAmt" value="${invstAcctIntDtl.estIncomeAmt}" /></td>
				</tr>
				<tr>
					<td>actualIncomeDt</td>
					<td><input type="text" id="actualIncomeDt" name="actualIncomeDt" data-validaterole="actualIncomeDt" data-rule="actualIncomeDt" value="${invstAcctIntDtl.actualIncomeDt}" /></td>
				</tr>
				<tr>
					<td>actualIncomeAmt</td>
					<td><input type="text" id="actualIncomeAmt" name="actualIncomeAmt" data-validaterole="actualIncomeAmt" data-rule="actualIncomeAmt" value="${invstAcctIntDtl.actualIncomeAmt}" /></td>
				</tr>
				<tr>
					<td>paymentPpleAmt</td>
					<td><input type="text" id="paymentPpleAmt" name="paymentPpleAmt" data-validaterole="paymentPpleAmt" data-rule="paymentPpleAmt" value="${invstAcctIntDtl.paymentPpleAmt}" /></td>
				</tr>
				<tr>
					<td>actualPpleAmt</td>
					<td><input type="text" id="actualPpleAmt" name="actualPpleAmt" data-validaterole="actualPpleAmt" data-rule="actualPpleAmt" value="${invstAcctIntDtl.actualPpleAmt}" /></td>
				</tr>
				<tr>
					<td>paymentIntAmt</td>
					<td><input type="text" id="paymentIntAmt" name="paymentIntAmt" data-validaterole="paymentIntAmt" data-rule="paymentIntAmt" value="${invstAcctIntDtl.paymentIntAmt}" /></td>
				</tr>
				<tr>
					<td>actualIntAmt</td>
					<td><input type="text" id="actualIntAmt" name="actualIntAmt" data-validaterole="actualIntAmt" data-rule="actualIntAmt" value="${invstAcctIntDtl.actualIntAmt}" /></td>
				</tr>
				<tr>
					<td>txStat</td>
					<td><input type="text" id="txStat" name="txStat" data-validaterole="txStat" data-rule="txStat" value="${invstAcctIntDtl.txStat}" /></td>
				</tr>
				<tr>
					<td>txCod</td>
					<td><input type="text" id="txCod" name="txCod" data-validaterole="txCod" data-rule="txCod" value="${invstAcctIntDtl.txCod}" /></td>
				</tr>
				<tr>
					<td>txDesc</td>
					<td><input type="text" id="txDesc" name="txDesc" data-validaterole="txDesc" data-rule="txDesc" value="${invstAcctIntDtl.txDesc}" /></td>
				</tr>
				<tr>
					<td>instDate</td>
					<td><input type="text" id="instDate" name="instDate" data-validaterole="instDate" data-rule="instDate" value="${invstAcctIntDtl.instDate}" /></td>
				</tr>
				<tr>
					<td>updtDate</td>
					<td><input type="text" id="updtDate" name="updtDate" data-validaterole="updtDate" data-rule="updtDate" value="${invstAcctIntDtl.updtDate}" /></td>
				</tr>
				<tr>
					<td>recordStat</td>
					<td><input type="text" id="recordStat" name="recordStat" data-validaterole="recordStat" data-rule="recordStat" value="${invstAcctIntDtl.recordStat}" /></td>
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
					con : "#invstAcctIntDtlForm",// 验证容器
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
					var serializedForm = $("#invstAcctIntDtlForm").serialize();
					$.post("${ctx}/invstAcctIntDtl/edit.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/invstAcctIntDtl/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.invstAcctIntDtlDialog.close();
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