<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询业绩明细表列表</title>
<!-- 加载公共的样式，主要作用是清除浏览器的一些默认样式，页面公共排版，包括头部以及一些组件样式 -->
<link href="${ctx}/css/reset.css" rel="stylesheet" type="text/css" />

<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/page.css" rel="stylesheet" type="text/css" />
<!-- css load end -->

<!-- 前端框架核心库加载放在 -->
<script src="${ctx}/js/lib/core.js" type="text/javascript"></script>
<script src="${ctx}/js/component/modal.js" type="text/javascript"></script>

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
		<table class="table_list">
			<tr>
				<td>
					<!-- 查询条件 -->
					<input type="button" value="查询" id="searchBtn" />
					<input type="button" value="添加" id="addBtn" />
				</td>
			</tr>
		</table>
		<br/>
		<table id="tbwrap" class="table_list"></table>
		<div class="page eui-pager-custom" id="j_pager"></div>
	</div>
	
		<script type="text/html" id="tb_template">
		<thead>
			<tr>
				<th>主键序列</th>
				<th>合同编号</th>
				<th>贷款人姓名</th>
				<th>合同额</th>
				<th>放款额</th>
				<th>约定放款日</th>
				<th>实际放款日</th>
				<th>业务经理编号</th>
				<th>团队经理编号</th>
				<th>门店经理编号</th>
				<th>区域经理编号</th>
				<th>外访专员编号</th>
				<th>信审专员编号</th>
				<th>客服专员编号</th>
				<th>分公司编号</th>
				<th>部门编号</th>
				<th>团队编号</th>
				<th>工资年月</th>
				<th>创建时间</th>
				<th>创建者</th>
				<th>修改时间</th>
				<th>修改者</th>
				<th>区域编号</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody data-type="body">
			<!if(list.length>0) { !>
				<!for(var i=0,len=list.length;i<len;i++){
					var item = list[i],classItem = (i%2!=0)?"odd td_odd":"even";
				!>
				<tr class="gradeA <!=classItem!>">
					<td title="<!=item["priNumber"]!>"><!=item["priNumber"]!></td>
					<td title="<!=item["loanContractNo"]!>"><!=item["loanContractNo"]!></td>
					<td title="<!=item["loanName"]!>"><!=item["loanName"]!></td>
					<td title="<!=item["loanAmount"]!>"><!=item["loanAmount"]!></td>
					<td title="<!=item["grantLoanAmount"]!>"><!=item["grantLoanAmount"]!></td>
					<td title="<!=item["grantLoanDate"]!>"><!=item["grantLoanDate"]!></td>
					<td title="<!=item["payDate"]!>"><!=item["payDate"]!></td>
					<td title="<!=item["businessManagerNo"]!>"><!=item["businessManagerNo"]!></td>
					<td title="<!=item["teamManagerNo"]!>"><!=item["teamManagerNo"]!></td>
					<td title="<!=item["orgManagerNo"]!>"><!=item["orgManagerNo"]!></td>
					<td title="<!=item["areaManagerNo"]!>"><!=item["areaManagerNo"]!></td>
					<td title="<!=item["wfEmpNo"]!>"><!=item["wfEmpNo"]!></td>
					<td title="<!=item["xsEmpNo"]!>"><!=item["xsEmpNo"]!></td>
					<td title="<!=item["kfEmpNo"]!>"><!=item["kfEmpNo"]!></td>
					<td title="<!=item["orgNo"]!>"><!=item["orgNo"]!></td>
					<td title="<!=item["deptNo"]!>"><!=item["deptNo"]!></td>
					<td title="<!=item["teamNo"]!>"><!=item["teamNo"]!></td>
					<td title="<!=item["gzYm"]!>"><!=item["gzYm"]!></td>
					<td title="<!=item["createTime"]!>"><!=item["createTime"]!></td>
					<td title="<!=item["creatorNo"]!>"><!=item["creatorNo"]!></td>
					<td title="<!=item["updateTime"]!>"><!=item["updateTime"]!></td>
					<td title="<!=item["modifierNo"]!>"><!=item["modifierNo"]!></td>
					<td title="<!=item["areaNo"]!>"><!=item["areaNo"]!></td>
					<td>
						<a title="详情" data-value="<!=item["priNumber"]!>" class="detail">详情</a>
						<a title="修改" data-value="<!=item["priNumber"]!>" class="edit">修改</a>
						<a title="删除" data-value="<!=item["priNumber"]!>" class="delete">删除</a>
					</td>
				</tr>
			<!}!>
			<!}else{!>
				<tr>
					<td colspan="10"> 暂无数据</td>
				</tr>
			<!}!>
		</tbody>
	</script>


	<script type="text/javascript">
		var clAchieveDetailDialog;
		$(function(){
			// 1、添加
			$("#addBtn").click(function(){
				seajs.use("component/dialog", function (dialog) {
				    clAchieveDetailDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/clAchieveDetail/toAdd.do", // 内容
				        "title" : "添加业绩明细表信息" //标题
					});
				});
			});
			// 2、详细
			$("#tbwrap").delegate(".detail", "click", function () {
				// 2.1 获取主键
				var priNumber = $(this).data("value");
				// 2.2 弹窗窗口，显示详细信息
				seajs.use("component/dialog", function (dialog) {
				    clAchieveDetailDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/clAchieveDetail/view.do?priNumber="+priNumber, // 内容
				        "title" : "查看{beanCnName}详细信息" //标题
					});
				});
			});
			// 3、编辑
			$("#tbwrap").delegate(".edit", "click", function () {
				// 3.1 获取主键
				var priNumber = $(this).data("value");
				// 3.2 弹窗窗口，显示详细信息
				seajs.use("component/dialog", function (dialog) {
				    clAchieveDetailDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/clAchieveDetail/toEdit.do?priNumber="+priNumber, // 内容
				        "title" : "编辑{beanCnName}详细信息" //标题
					});
				});
			});
			// 4、删除
			$("#tbwrap").delegate(".delete", "click", function () {
				var priNumber = $(this).data("value");
				if (confirm('确定删除？')) {
					$.post("${ctx}/clAchieveDetail/delete.do", {priNumber : priNumber}, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/clAchieveDetail/list.do?ts="+new Date().getTime()); //如果操作成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.clAchieveDetailDialog.close();
			            } else {
			            	alert("操作失败");
			            }
			        }, "json");
				}
				
			});
			// 5、查询
			$("#searchBtn").click(function () {
				search();
	        });
		});
	
	</script>
	
	<script type="text/javascript">
		$(function () {
	        search();
	    });
		
		function strToObj(json){
		    return eval("("+json+")");
		}
		
		function search() {
			
	        seajs.use(["component/table"], function (uiTable) {
		        $.post("${ctx}/clAchieveDetail/ajaxPage.do",
		        {
		        	page: 1
		        	// 其他查询条件
		        }, function (result) {
		        	result = strToObj(result);
		        	// alert("status="+result.status+", currentPage="+result.currentPage+", pageCount="+result.pageCount+", rowCount="+result.rowCount);
	            	var table = new uiTable({
	                	"con": "#tbwrap",
	                    "data": {
	                         "list": result.dataList
	                    },
	                    "template": "tb_template",
	                    "pager": {
	                    	"con": "#j_pager",
	                        "data": {
	                        	"currentPage": result.currentPage,
	                            "pageCount": result.pageCount,
	                            "rowCount": result.rowCount
	                        },
	                        template: '<a title="首页" class="page_first" data-role="first" href="#"></a><a title="上一页" class="page_prev" href="#" data-role="prev"></a><div data-value="pageNum"></div><a title="下一页" class="page_next" href="#" data-role="next"></a><a title="尾页" class="page_last" href="#" data-role="last"></a> 共<span data-target="rowCount"></span>条 跳转到 <input type="text" data-target="input" class="page_input"/><a href="#" data-role="go" class="go">GO</a>'
	                    }
	                });

	                table.getPager().bind("changePage", function (event, page, hander) {
	                	$.post("${ctx}/clAchieveDetail/ajaxPage.do", { page: page,  deptCnName: deptCnName, deptEnName: deptEnName },
	                    function (result) {
	                    	result = strToObj(result);
	                    	table.render({ "list": result.dataList });
		                    hander({"currentPage": result.currentPage, "pageCount": result.pageCount, "rowCount": result.rowCount });
	                 	}, "json");
	                });
	        	}, "json");
	      	});
		}
	</script>

</body>
</html>
