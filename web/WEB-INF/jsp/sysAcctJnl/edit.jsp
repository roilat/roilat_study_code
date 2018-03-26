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
		<form id="sysAcctJnlForm">
			<input type="hidden" name="txSeqNo" value="${sysAcctJnl.txSeqNo}" />
			<table class="table_list">
				<tr>
					<td>txSeqNo</td>
					<td><input type="text" id="txSeqNo" name="txSeqNo" data-validaterole="txSeqNo" data-rule="txSeqNo" value="${sysAcctJnl.txSeqNo}" /></td>
				</tr>
				<tr>
					<td>serlNo</td>
					<td><input type="text" id="serlNo" name="serlNo" data-validaterole="serlNo" data-rule="serlNo" value="${sysAcctJnl.serlNo}" /></td>
				</tr>
				<tr>
					<td>txDate</td>
					<td><input type="text" id="txDate" name="txDate" data-validaterole="txDate" data-rule="txDate" value="${sysAcctJnl.txDate}" /></td>
				</tr>
				<tr>
					<td>acctNo</td>
					<td><input type="text" id="acctNo" name="acctNo" data-validaterole="acctNo" data-rule="acctNo" value="${sysAcctJnl.acctNo}" /></td>
				</tr>
				<tr>
					<td>custNo</td>
					<td><input type="text" id="custNo" name="custNo" data-validaterole="custNo" data-rule="custNo" value="${sysAcctJnl.custNo}" /></td>
				</tr>
				<tr>
					<td>custName</td>
					<td><input type="text" id="custName" name="custName" data-validaterole="custName" data-rule="custName" value="${sysAcctJnl.custName}" /></td>
				</tr>
				<tr>
					<td>subjNo</td>
					<td><input type="text" id="subjNo" name="subjNo" data-validaterole="subjNo" data-rule="subjNo" value="${sysAcctJnl.subjNo}" /></td>
				</tr>
				<tr>
					<td>drCrFlag</td>
					<td><input type="text" id="drCrFlag" name="drCrFlag" data-validaterole="drCrFlag" data-rule="drCrFlag" value="${sysAcctJnl.drCrFlag}" /></td>
				</tr>
				<tr>
					<td>prodNo</td>
					<td><input type="text" id="prodNo" name="prodNo" data-validaterole="prodNo" data-rule="prodNo" value="${sysAcctJnl.prodNo}" /></td>
				</tr>
				<tr>
					<td>txCod</td>
					<td><input type="text" id="txCod" name="txCod" data-validaterole="txCod" data-rule="txCod" value="${sysAcctJnl.txCod}" /></td>
				</tr>
				<tr>
					<td>txAbbr</td>
					<td><input type="text" id="txAbbr" name="txAbbr" data-validaterole="txAbbr" data-rule="txAbbr" value="${sysAcctJnl.txAbbr}" /></td>
				</tr>
				<tr>
					<td>txAmt</td>
					<td><input type="text" id="txAmt" name="txAmt" data-validaterole="txAmt" data-rule="txAmt" value="${sysAcctJnl.txAmt}" /></td>
				</tr>
				<tr>
					<td>BAL</td>
					<td><input type="text" id="BAL" name="BAL" data-validaterole="BAL" data-rule="BAL" value="${sysAcctJnl.BAL}" /></td>
				</tr>
				<tr>
					<td>cntAcctNo</td>
					<td><input type="text" id="cntAcctNo" name="cntAcctNo" data-validaterole="cntAcctNo" data-rule="cntAcctNo" value="${sysAcctJnl.cntAcctNo}" /></td>
				</tr>
				<tr>
					<td>cntAcctName</td>
					<td><input type="text" id="cntAcctName" name="cntAcctName" data-validaterole="cntAcctName" data-rule="cntAcctName" value="${sysAcctJnl.cntAcctName}" /></td>
				</tr>
				<tr>
					<td>bookFlag</td>
					<td><input type="text" id="bookFlag" name="bookFlag" data-validaterole="bookFlag" data-rule="bookFlag" value="${sysAcctJnl.bookFlag}" /></td>
				</tr>
				<tr>
					<td>strkFlag</td>
					<td><input type="text" id="strkFlag" name="strkFlag" data-validaterole="strkFlag" data-rule="strkFlag" value="${sysAcctJnl.strkFlag}" /></td>
				</tr>
				<tr>
					<td>strkDate</td>
					<td><input type="text" id="strkDate" name="strkDate" data-validaterole="strkDate" data-rule="strkDate" value="${sysAcctJnl.strkDate}" /></td>
				</tr>
				<tr>
					<td>instDate</td>
					<td><input type="text" id="instDate" name="instDate" data-validaterole="instDate" data-rule="instDate" value="${sysAcctJnl.instDate}" /></td>
				</tr>
				<tr>
					<td>updtDate</td>
					<td><input type="text" id="updtDate" name="updtDate" data-validaterole="updtDate" data-rule="updtDate" value="${sysAcctJnl.updtDate}" /></td>
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
					con : "#sysAcctJnlForm",// 验证容器
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
					var serializedForm = $("#sysAcctJnlForm").serialize();
					$.post("${ctx}/sysAcctJnl/edit.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/sysAcctJnl/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.sysAcctJnlDialog.close();
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