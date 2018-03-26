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
		<form id="pubDebtForm">
			<input type="hidden" name="debtNo" value="${pubDebt.debtNo}" />
			<table class="table_list">
				<tr>
					<td>债券编号</td>
					<td><input type="text" id="debtNo" name="debtNo" data-validaterole="debtNo" data-rule="debtNo" value="${pubDebt.debtNo}" /></td>
				</tr>
				<tr>
					<td>原始产品编号</td>
					<td><input type="text" id="prodNo" name="prodNo" data-validaterole="prodNo" data-rule="prodNo" value="${pubDebt.prodNo}" /></td>
				</tr>
				<tr>
					<td>原始产品名称</td>
					<td><input type="text" id="prodName" name="prodName" data-validaterole="prodName" data-rule="prodName" value="${pubDebt.prodName}" /></td>
				</tr>
				<tr>
					<td>原始投资编号</td>
					<td><input type="text" id="invstNo" name="invstNo" data-validaterole="invstNo" data-rule="invstNo" value="${pubDebt.invstNo}" /></td>
				</tr>
				<tr>
					<td>还款方式</td>
					<td><input type="text" id="repayTyp" name="repayTyp" data-validaterole="repayTyp" data-rule="repayTyp" value="${pubDebt.repayTyp}" /></td>
				</tr>
				<tr>
					<td>转让用户</td>
					<td><input type="text" id="custNo" name="custNo" data-validaterole="custNo" data-rule="custNo" value="${pubDebt.custNo}" /></td>
				</tr>
				<tr>
					<td>原始产品期限</td>
					<td><input type="text" id="prodPerd" name="prodPerd" data-validaterole="prodPerd" data-rule="prodPerd" value="${pubDebt.prodPerd}" /></td>
				</tr>
				<tr>
					<td>转让金额</td>
					<td><input type="text" id="debtAmt" name="debtAmt" data-validaterole="debtAmt" data-rule="debtAmt" value="${pubDebt.debtAmt}" /></td>
				</tr>
				<tr>
					<td>转让类型</td>
					<td><input type="text" id="debtType" name="debtType" data-validaterole="debtType" data-rule="debtType" value="${pubDebt.debtType}" /></td>
				</tr>
				<tr>
					<td>dedtFeeRat</td>
					<td><input type="text" id="dedtFeeRat" name="dedtFeeRat" data-validaterole="dedtFeeRat" data-rule="dedtFeeRat" value="${pubDebt.dedtFeeRat}" /></td>
				</tr>
				<tr>
					<td>折价率</td>
					<td><input type="text" id="discountRat" name="discountRat" data-validaterole="discountRat" data-rule="discountRat" value="${pubDebt.discountRat}" /></td>
				</tr>
				<tr>
					<td>实际收益率</td>
					<td><input type="text" id="prftRat" name="prftRat" data-validaterole="prftRat" data-rule="prftRat" value="${pubDebt.prftRat}" /></td>
				</tr>
				<tr>
					<td>原始产品金额</td>
					<td><input type="text" id="loanAmt" name="loanAmt" data-validaterole="loanAmt" data-rule="loanAmt" value="${pubDebt.loanAmt}" /></td>
				</tr>
				<tr>
					<td>原始投资金额</td>
					<td><input type="text" id="invstAmt" name="invstAmt" data-validaterole="invstAmt" data-rule="invstAmt" value="${pubDebt.invstAmt}" /></td>
				</tr>
				<tr>
					<td>转让利息</td>
					<td><input type="text" id="dettolIntAmt" name="dettolIntAmt" data-validaterole="dettolIntAmt" data-rule="dettolIntAmt" value="${pubDebt.dettolIntAmt}" /></td>
				</tr>
				<tr>
					<td>产品剩余期数</td>
					<td><input type="text" id="debtPerd" name="debtPerd" data-validaterole="debtPerd" data-rule="debtPerd" value="${pubDebt.debtPerd}" /></td>
				</tr>
				<tr>
					<td>产品开始时间</td>
					<td><input type="text" id="bgnDate" name="bgnDate" data-validaterole="bgnDate" data-rule="bgnDate" value="${pubDebt.bgnDate}" /></td>
				</tr>
				<tr>
					<td>产品到期日</td>
					<td><input type="text" id="endDate" name="endDate" data-validaterole="endDate" data-rule="endDate" value="${pubDebt.endDate}" /></td>
				</tr>
				<tr>
					<td>产品剩余天数</td>
					<td><input type="text" id="days" name="days" data-validaterole="days" data-rule="days" value="${pubDebt.days}" /></td>
				</tr>
				<tr>
					<td>申请时间</td>
					<td><input type="text" id="applyDate" name="applyDate" data-validaterole="applyDate" data-rule="applyDate" value="${pubDebt.applyDate}" /></td>
				</tr>
				<tr>
					<td>转让时间</td>
					<td><input type="text" id="startDate" name="startDate" data-validaterole="startDate" data-rule="startDate" value="${pubDebt.startDate}" /></td>
				</tr>
				<tr>
					<td>sellTmsp</td>
					<td><input type="text" id="sellTmsp" name="sellTmsp" data-validaterole="sellTmsp" data-rule="sellTmsp" value="${pubDebt.sellTmsp}" /></td>
				</tr>
				<tr>
					<td>截止时间</td>
					<td><input type="text" id="bidDueDate" name="bidDueDate" data-validaterole="bidDueDate" data-rule="bidDueDate" value="${pubDebt.bidDueDate}" /></td>
				</tr>
				<tr>
					<td>minInvstAmt</td>
					<td><input type="text" id="minInvstAmt" name="minInvstAmt" data-validaterole="minInvstAmt" data-rule="minInvstAmt" value="${pubDebt.minInvstAmt}" /></td>
				</tr>
				<tr>
					<td>maxInvstAmt</td>
					<td><input type="text" id="maxInvstAmt" name="maxInvstAmt" data-validaterole="maxInvstAmt" data-rule="maxInvstAmt" value="${pubDebt.maxInvstAmt}" /></td>
				</tr>
				<tr>
					<td>转让状态</td>
					<td><input type="text" id="debtStat" name="debtStat" data-validaterole="debtStat" data-rule="debtStat" value="${pubDebt.debtStat}" /></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input type="text" id="prodRemk" name="prodRemk" data-validaterole="prodRemk" data-rule="prodRemk" value="${pubDebt.prodRemk}" /></td>
				</tr>
				<tr>
					<td>创建日期</td>
					<td><input type="text" id="instDate" name="instDate" data-validaterole="instDate" data-rule="instDate" value="${pubDebt.instDate}" /></td>
				</tr>
				<tr>
					<td>修改日期</td>
					<td><input type="text" id="updtDate" name="updtDate" data-validaterole="updtDate" data-rule="updtDate" value="${pubDebt.updtDate}" /></td>
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
					con : "#pubDebtForm",// 验证容器
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
					var serializedForm = $("#pubDebtForm").serialize();
					$.post("${ctx}/pubDebt/edit.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/pubDebt/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.pubDebtDialog.close();
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