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
		<form id="invstAcctForm">
			<input type="hidden" name="acctNo" value="${invstAcct.acctNo}" />
			<table class="table_list">
				<tr>
					<td>acctNo</td>
					<td><input type="text" id="acctNo" name="acctNo" data-validaterole="acctNo" data-rule="acctNo" value="${invstAcct.acctNo}" /></td>
				</tr>
				<tr>
					<td>custNo</td>
					<td><input type="text" id="custNo" name="custNo" data-validaterole="custNo" data-rule="custNo" value="${invstAcct.custNo}" /></td>
				</tr>
				<tr>
					<td>custName</td>
					<td><input type="text" id="custName" name="custName" data-validaterole="custName" data-rule="custName" value="${invstAcct.custName}" /></td>
				</tr>
				<tr>
					<td>loginPwd</td>
					<td><input type="text" id="loginPwd" name="loginPwd" data-validaterole="loginPwd" data-rule="loginPwd" value="${invstAcct.loginPwd}" /></td>
				</tr>
				<tr>
					<td>payPwd</td>
					<td><input type="text" id="payPwd" name="payPwd" data-validaterole="payPwd" data-rule="payPwd" value="${invstAcct.payPwd}" /></td>
				</tr>
				<tr>
					<td>acctTyp</td>
					<td><input type="text" id="acctTyp" name="acctTyp" data-validaterole="acctTyp" data-rule="acctTyp" value="${invstAcct.acctTyp}" /></td>
				</tr>
				<tr>
					<td>openOrg</td>
					<td><input type="text" id="openOrg" name="openOrg" data-validaterole="openOrg" data-rule="openOrg" value="${invstAcct.openOrg}" /></td>
				</tr>
				<tr>
					<td>subjNo</td>
					<td><input type="text" id="subjNo" name="subjNo" data-validaterole="subjNo" data-rule="subjNo" value="${invstAcct.subjNo}" /></td>
				</tr>
				<tr>
					<td>Bal</td>
					<td><input type="text" id="Bal" name="Bal" data-validaterole="Bal" data-rule="Bal" value="${invstAcct.Bal}" /></td>
				</tr>
				<tr>
					<td>avalBal</td>
					<td><input type="text" id="avalBal" name="avalBal" data-validaterole="avalBal" data-rule="avalBal" value="${invstAcct.avalBal}" /></td>
				</tr>
				<tr>
					<td>frzAmt</td>
					<td><input type="text" id="frzAmt" name="frzAmt" data-validaterole="frzAmt" data-rule="frzAmt" value="${invstAcct.frzAmt}" /></td>
				</tr>
				<tr>
					<td>invstAmt</td>
					<td><input type="text" id="invstAmt" name="invstAmt" data-validaterole="invstAmt" data-rule="invstAmt" value="${invstAcct.invstAmt}" /></td>
				</tr>
				<tr>
					<td>batFlag</td>
					<td><input type="text" id="batFlag" name="batFlag" data-validaterole="batFlag" data-rule="batFlag" value="${invstAcct.batFlag}" /></td>
				</tr>
				<tr>
					<td>acctStat</td>
					<td><input type="text" id="acctStat" name="acctStat" data-validaterole="acctStat" data-rule="acctStat" value="${invstAcct.acctStat}" /></td>
				</tr>
				<tr>
					<td>frzStat</td>
					<td><input type="text" id="frzStat" name="frzStat" data-validaterole="frzStat" data-rule="frzStat" value="${invstAcct.frzStat}" /></td>
				</tr>
				<tr>
					<td>openDate</td>
					<td><input type="text" id="openDate" name="openDate" data-validaterole="openDate" data-rule="openDate" value="${invstAcct.openDate}" /></td>
				</tr>
				<tr>
					<td>lastTxDate</td>
					<td><input type="text" id="lastTxDate" name="lastTxDate" data-validaterole="lastTxDate" data-rule="lastTxDate" value="${invstAcct.lastTxDate}" /></td>
				</tr>
				<tr>
					<td>lastDayPrft</td>
					<td><input type="text" id="lastDayPrft" name="lastDayPrft" data-validaterole="lastDayPrft" data-rule="lastDayPrft" value="${invstAcct.lastDayPrft}" /></td>
				</tr>
				<tr>
					<td>lastMthPrft</td>
					<td><input type="text" id="lastMthPrft" name="lastMthPrft" data-validaterole="lastMthPrft" data-rule="lastMthPrft" value="${invstAcct.lastMthPrft}" /></td>
				</tr>
				<tr>
					<td>lastYearPrft</td>
					<td><input type="text" id="lastYearPrft" name="lastYearPrft" data-validaterole="lastYearPrft" data-rule="lastYearPrft" value="${invstAcct.lastYearPrft}" /></td>
				</tr>
				<tr>
					<td>totlPrft</td>
					<td><input type="text" id="totlPrft" name="totlPrft" data-validaterole="totlPrft" data-rule="totlPrft" value="${invstAcct.totlPrft}" /></td>
				</tr>
				<tr>
					<td>totlInvst</td>
					<td><input type="text" id="totlInvst" name="totlInvst" data-validaterole="totlInvst" data-rule="totlInvst" value="${invstAcct.totlInvst}" /></td>
				</tr>
				<tr>
					<td>totlAmt</td>
					<td><input type="text" id="totlAmt" name="totlAmt" data-validaterole="totlAmt" data-rule="totlAmt" value="${invstAcct.totlAmt}" /></td>
				</tr>
				<tr>
					<td>totlPpleAmt</td>
					<td><input type="text" id="totlPpleAmt" name="totlPpleAmt" data-validaterole="totlPpleAmt" data-rule="totlPpleAmt" value="${invstAcct.totlPpleAmt}" /></td>
				</tr>
				<tr>
					<td>totlIntAmt</td>
					<td><input type="text" id="totlIntAmt" name="totlIntAmt" data-validaterole="totlIntAmt" data-rule="totlIntAmt" value="${invstAcct.totlIntAmt}" /></td>
				</tr>
				<tr>
					<td>baseTotlPrft</td>
					<td><input type="text" id="baseTotlPrft" name="baseTotlPrft" data-validaterole="baseTotlPrft" data-rule="baseTotlPrft" value="${invstAcct.baseTotlPrft}" /></td>
				</tr>
				<tr>
					<td>prftAvgRat</td>
					<td><input type="text" id="prftAvgRat" name="prftAvgRat" data-validaterole="prftAvgRat" data-rule="prftAvgRat" value="${invstAcct.prftAvgRat}" /></td>
				</tr>
				<tr>
					<td>instDate</td>
					<td><input type="text" id="instDate" name="instDate" data-validaterole="instDate" data-rule="instDate" value="${invstAcct.instDate}" /></td>
				</tr>
				<tr>
					<td>updtDate</td>
					<td><input type="text" id="updtDate" name="updtDate" data-validaterole="updtDate" data-rule="updtDate" value="${invstAcct.updtDate}" /></td>
				</tr>
				<tr>
					<td>recordStat</td>
					<td><input type="text" id="recordStat" name="recordStat" data-validaterole="recordStat" data-rule="recordStat" value="${invstAcct.recordStat}" /></td>
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
					con : "#invstAcctForm",// 验证容器
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
					var serializedForm = $("#invstAcctForm").serialize();
					$.post("${ctx}/invstAcct/edit.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/invstAcct/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.invstAcctDialog.close();
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