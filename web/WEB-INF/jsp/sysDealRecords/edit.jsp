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
		<form id="sysDealRecordsForm">
			<input type="hidden" name="txSeqNo" value="${sysDealRecords.txSeqNo}" />
			<table class="table_list">
				<tr>
					<td>交易流水号</td>
					<td><input type="text" id="txSeqNo" name="txSeqNo" data-validaterole="txSeqNo" data-rule="txSeqNo" value="${sysDealRecords.txSeqNo}" /></td>
				</tr>
				<tr>
					<td>账号</td>
					<td><input type="text" id="acctNo" name="acctNo" data-validaterole="acctNo" data-rule="acctNo" value="${sysDealRecords.acctNo}" /></td>
				</tr>
				<tr>
					<td>收款账号</td>
					<td><input type="text" id="toAcctNo" name="toAcctNo" data-validaterole="toAcctNo" data-rule="toAcctNo" value="${sysDealRecords.toAcctNo}" /></td>
				</tr>
				<tr>
					<td>支付状态信息</td>
					<td><input type="text" id="payResult" name="payResult" data-validaterole="payResult" data-rule="payResult" value="${sysDealRecords.payResult}" /></td>
				</tr>
				<tr>
					<td>平台处理结果</td>
					<td><input type="text" id="dealResult" name="dealResult" data-validaterole="dealResult" data-rule="dealResult" value="${sysDealRecords.dealResult}" /></td>
				</tr>
				<tr>
					<td>交易日期</td>
					<td><input type="text" id="txDate" name="txDate" data-validaterole="txDate" data-rule="txDate" value="${sysDealRecords.txDate}" /></td>
				</tr>
				<tr>
					<td>交易金额</td>
					<td><input type="text" id="txAmt" name="txAmt" data-validaterole="txAmt" data-rule="txAmt" value="${sysDealRecords.txAmt}" /></td>
				</tr>
				<tr>
					<td>交易状态</td>
					<td><input type="text" id="txStat" name="txStat" data-validaterole="txStat" data-rule="txStat" value="${sysDealRecords.txStat}" /></td>
				</tr>
				<tr>
					<td>交易类型</td>
					<td><input type="text" id="txCod" name="txCod" data-validaterole="txCod" data-rule="txCod" value="${sysDealRecords.txCod}" /></td>
				</tr>
				<tr>
					<td>txDesc</td>
					<td><input type="text" id="txDesc" name="txDesc" data-validaterole="txDesc" data-rule="txDesc" value="${sysDealRecords.txDesc}" /></td>
				</tr>
				<tr>
					<td>创建日期</td>
					<td><input type="text" id="instDate" name="instDate" data-validaterole="instDate" data-rule="instDate" value="${sysDealRecords.instDate}" /></td>
				</tr>
				<tr>
					<td>修改日期</td>
					<td><input type="text" id="updtDate" name="updtDate" data-validaterole="updtDate" data-rule="updtDate" value="${sysDealRecords.updtDate}" /></td>
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
					con : "#sysDealRecordsForm",// 验证容器
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
					var serializedForm = $("#sysDealRecordsForm").serialize();
					$.post("${ctx}/sysDealRecords/edit.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/sysDealRecords/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.sysDealRecordsDialog.close();
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