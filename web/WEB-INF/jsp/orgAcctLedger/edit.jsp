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
		<form id="orgAcctLedgerForm">
			<input type="hidden" name="flowId" value="${orgAcctLedger.flowId}" />
			<table class="table_list">
				<tr>
					<td>流水号</td>
					<td><input type="text" id="flowId" name="flowId" data-validaterole="flowId" data-rule="flowId" value="${orgAcctLedger.flowId}" /></td>
				</tr>
				<tr>
					<td>机构ID</td>
					<td><input type="text" id="orgId" name="orgId" data-validaterole="orgId" data-rule="orgId" value="${orgAcctLedger.orgId}" /></td>
				</tr>
				<tr>
					<td>机构名称</td>
					<td><input type="text" id="orgName" name="orgName" data-validaterole="orgName" data-rule="orgName" value="${orgAcctLedger.orgName}" /></td>
				</tr>
				<tr>
					<td>账号</td>
					<td><input type="text" id="acctNo" name="acctNo" data-validaterole="acctNo" data-rule="acctNo" value="${orgAcctLedger.acctNo}" /></td>
				</tr>
				<tr>
					<td>交易金额</td>
					<td><input type="text" id="transAmt" name="transAmt" data-validaterole="transAmt" data-rule="transAmt" value="${orgAcctLedger.transAmt}" /></td>
				</tr>
				<tr>
					<td>交易时间</td>
					<td><input type="text" id="transTime" name="transTime" data-validaterole="transTime" data-rule="transTime" value="${orgAcctLedger.transTime}" /></td>
				</tr>
				<tr>
					<td>交易类型:300001-充值,3000002-消费,300003-冲销</td>
					<td><input type="text" id="tansType" name="tansType" data-validaterole="tansType" data-rule="tansType" value="${orgAcctLedger.tansType}" /></td>
				</tr>
				<tr>
					<td>账户余额</td>
					<td><input type="text" id="acctBal" name="acctBal" data-validaterole="acctBal" data-rule="acctBal" value="${orgAcctLedger.acctBal}" /></td>
				</tr>
				<tr>
					<td>登记人</td>
					<td><input type="text" id="insertUser" name="insertUser" data-validaterole="insertUser" data-rule="insertUser" value="${orgAcctLedger.insertUser}" /></td>
				</tr>
				<tr>
					<td>登记时间</td>
					<td><input type="text" id="insertTime" name="insertTime" data-validaterole="insertTime" data-rule="insertTime" value="${orgAcctLedger.insertTime}" /></td>
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
					con : "#orgAcctLedgerForm",// 验证容器
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
					var serializedForm = $("#orgAcctLedgerForm").serialize();
					$.post("${ctx}/orgAcctLedger/edit.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/orgAcctLedger/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.orgAcctLedgerDialog.close();
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