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
		<form id="clAchieveDetailForm" action="post">
		<table class="table_list">
			<tr>
				<td>主键序列</td>
				<td><input type="text" id="priNumber" name="priNumber" data-validaterole="priNumber" data-rule="priNumber" value="" /></td>
			</tr>
			<tr>
				<td>合同编号</td>
				<td><input type="text" id="loanContractNo" name="loanContractNo" data-validaterole="loanContractNo" data-rule="loanContractNo" value="" /></td>
			</tr>
			<tr>
				<td>贷款人姓名</td>
				<td><input type="text" id="loanName" name="loanName" data-validaterole="loanName" data-rule="loanName" value="" /></td>
			</tr>
			<tr>
				<td>合同额</td>
				<td><input type="text" id="loanAmount" name="loanAmount" data-validaterole="loanAmount" data-rule="loanAmount" value="" /></td>
			</tr>
			<tr>
				<td>放款额</td>
				<td><input type="text" id="grantLoanAmount" name="grantLoanAmount" data-validaterole="grantLoanAmount" data-rule="grantLoanAmount" value="" /></td>
			</tr>
			<tr>
				<td>约定放款日</td>
				<td><input type="text" id="grantLoanDate" name="grantLoanDate" data-validaterole="grantLoanDate" data-rule="grantLoanDate" value="" /></td>
			</tr>
			<tr>
				<td>实际放款日</td>
				<td><input type="text" id="payDate" name="payDate" data-validaterole="payDate" data-rule="payDate" value="" /></td>
			</tr>
			<tr>
				<td>业务经理编号</td>
				<td><input type="text" id="businessManagerNo" name="businessManagerNo" data-validaterole="businessManagerNo" data-rule="businessManagerNo" value="" /></td>
			</tr>
			<tr>
				<td>团队经理编号</td>
				<td><input type="text" id="teamManagerNo" name="teamManagerNo" data-validaterole="teamManagerNo" data-rule="teamManagerNo" value="" /></td>
			</tr>
			<tr>
				<td>门店经理编号</td>
				<td><input type="text" id="orgManagerNo" name="orgManagerNo" data-validaterole="orgManagerNo" data-rule="orgManagerNo" value="" /></td>
			</tr>
			<tr>
				<td>区域经理编号</td>
				<td><input type="text" id="areaManagerNo" name="areaManagerNo" data-validaterole="areaManagerNo" data-rule="areaManagerNo" value="" /></td>
			</tr>
			<tr>
				<td>外访专员编号</td>
				<td><input type="text" id="wfEmpNo" name="wfEmpNo" data-validaterole="wfEmpNo" data-rule="wfEmpNo" value="" /></td>
			</tr>
			<tr>
				<td>信审专员编号</td>
				<td><input type="text" id="xsEmpNo" name="xsEmpNo" data-validaterole="xsEmpNo" data-rule="xsEmpNo" value="" /></td>
			</tr>
			<tr>
				<td>客服专员编号</td>
				<td><input type="text" id="kfEmpNo" name="kfEmpNo" data-validaterole="kfEmpNo" data-rule="kfEmpNo" value="" /></td>
			</tr>
			<tr>
				<td>分公司编号</td>
				<td><input type="text" id="orgNo" name="orgNo" data-validaterole="orgNo" data-rule="orgNo" value="" /></td>
			</tr>
			<tr>
				<td>部门编号</td>
				<td><input type="text" id="deptNo" name="deptNo" data-validaterole="deptNo" data-rule="deptNo" value="" /></td>
			</tr>
			<tr>
				<td>团队编号</td>
				<td><input type="text" id="teamNo" name="teamNo" data-validaterole="teamNo" data-rule="teamNo" value="" /></td>
			</tr>
			<tr>
				<td>工资年月</td>
				<td><input type="text" id="gzYm" name="gzYm" data-validaterole="gzYm" data-rule="gzYm" value="" /></td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td><input type="text" id="createTime" name="createTime" data-validaterole="createTime" data-rule="createTime" value="" /></td>
			</tr>
			<tr>
				<td>创建者</td>
				<td><input type="text" id="creatorNo" name="creatorNo" data-validaterole="creatorNo" data-rule="creatorNo" value="" /></td>
			</tr>
			<tr>
				<td>修改时间</td>
				<td><input type="text" id="updateTime" name="updateTime" data-validaterole="updateTime" data-rule="updateTime" value="" /></td>
			</tr>
			<tr>
				<td>修改者</td>
				<td><input type="text" id="modifierNo" name="modifierNo" data-validaterole="modifierNo" data-rule="modifierNo" value="" /></td>
			</tr>
			<tr>
				<td>区域编号</td>
				<td><input type="text" id="areaNo" name="areaNo" data-validaterole="areaNo" data-rule="areaNo" value="" /></td>
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
					con : "#clAchieveDetailForm",// 验证容器
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
					var serializedForm = $("#clAchieveDetailForm").serialize();
					$.post("${ctx}/clAchieveDetail/add.do", serializedForm, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/clAchieveDetail/list.do?ts="+new Date().getTime()); //如果发表成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.clAchieveDetailDialog.close();
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