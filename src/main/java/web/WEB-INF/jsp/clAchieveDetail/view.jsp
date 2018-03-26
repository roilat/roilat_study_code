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
		<table class="table_list">
				<tr>
					<td>主键序列</td>
					<td>${clAchieveDetail.priNumber}</td>
				</tr>
				<tr>
					<td>合同编号</td>
					<td>${clAchieveDetail.loanContractNo}</td>
				</tr>
				<tr>
					<td>贷款人姓名</td>
					<td>${clAchieveDetail.loanName}</td>
				</tr>
				<tr>
					<td>合同额</td>
					<td>${clAchieveDetail.loanAmount}</td>
				</tr>
				<tr>
					<td>放款额</td>
					<td>${clAchieveDetail.grantLoanAmount}</td>
				</tr>
				<tr>
					<td>约定放款日</td>
					<td>${clAchieveDetail.grantLoanDate}</td>
				</tr>
				<tr>
					<td>实际放款日</td>
					<td>${clAchieveDetail.payDate}</td>
				</tr>
				<tr>
					<td>业务经理编号</td>
					<td>${clAchieveDetail.businessManagerNo}</td>
				</tr>
				<tr>
					<td>团队经理编号</td>
					<td>${clAchieveDetail.teamManagerNo}</td>
				</tr>
				<tr>
					<td>门店经理编号</td>
					<td>${clAchieveDetail.orgManagerNo}</td>
				</tr>
				<tr>
					<td>区域经理编号</td>
					<td>${clAchieveDetail.areaManagerNo}</td>
				</tr>
				<tr>
					<td>外访专员编号</td>
					<td>${clAchieveDetail.wfEmpNo}</td>
				</tr>
				<tr>
					<td>信审专员编号</td>
					<td>${clAchieveDetail.xsEmpNo}</td>
				</tr>
				<tr>
					<td>客服专员编号</td>
					<td>${clAchieveDetail.kfEmpNo}</td>
				</tr>
				<tr>
					<td>分公司编号</td>
					<td>${clAchieveDetail.orgNo}</td>
				</tr>
				<tr>
					<td>部门编号</td>
					<td>${clAchieveDetail.deptNo}</td>
				</tr>
				<tr>
					<td>团队编号</td>
					<td>${clAchieveDetail.teamNo}</td>
				</tr>
				<tr>
					<td>工资年月</td>
					<td>${clAchieveDetail.gzYm}</td>
				</tr>
				<tr>
					<td>创建时间</td>
					<td>${clAchieveDetail.createTime}</td>
				</tr>
				<tr>
					<td>创建者</td>
					<td>${clAchieveDetail.creatorNo}</td>
				</tr>
				<tr>
					<td>修改时间</td>
					<td>${clAchieveDetail.updateTime}</td>
				</tr>
				<tr>
					<td>修改者</td>
					<td>${clAchieveDetail.modifierNo}</td>
				</tr>
				<tr>
					<td>区域编号</td>
					<td>${clAchieveDetail.areaNo}</td>
				</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="returnBtn" value="返回" />
				</td>
			</tr>
		</table>	
	</div>
	
	<script type="text/javascript">
		$(function(){
			// 注册返回按钮事件
			$("#returnBtn").click(function () {
				// 关闭弹窗窗口
				parent.sysDeptDialog.close();
	        });
		});
	</script>
</body>
</html>