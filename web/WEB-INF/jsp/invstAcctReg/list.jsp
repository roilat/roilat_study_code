<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询投资登记薄列表</title>
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
				<th>invstNo</th>
				<th>contrNo</th>
				<th>acctNo</th>
				<th>invstTyp</th>
				<th>prodNo</th>
				<th>prodName</th>
				<th>custNo</th>
				<th>custName</th>
				<th>invstDate</th>
				<th>acctTyp</th>
				<th>invstAmt</th>
				<th>prodRat</th>
				<th>lockRat</th>
				<th>busnTyp</th>
				<th>repayTyp</th>
				<th>bgnDate</th>
				<th>endDate</th>
				<th>lockTyp</th>
				<th>mthRepayDay</th>
				<th>mthRepayAmt</th>
				<th>totlRepayAmt</th>
				<th>clrDate</th>
				<th>invstStat</th>
				<th>fstRepayDate</th>
				<th>invstDesc</th>
				<th>instDate</th>
				<th>updtDate</th>
				<th>redomAmt</th>
				<th>batFlag</th>
				<th>recordStat</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody data-type="body">
			<!if(list.length>0) { !>
				<!for(var i=0,len=list.length;i<len;i++){
					var item = list[i],classItem = (i%2!=0)?"odd td_odd":"even";
				!>
				<tr class="gradeA <!=classItem!>">
					<td title="<!=item["invstNo"]!>"><!=item["invstNo"]!></td>
					<td title="<!=item["contrNo"]!>"><!=item["contrNo"]!></td>
					<td title="<!=item["acctNo"]!>"><!=item["acctNo"]!></td>
					<td title="<!=item["invstTyp"]!>"><!=item["invstTyp"]!></td>
					<td title="<!=item["prodNo"]!>"><!=item["prodNo"]!></td>
					<td title="<!=item["prodName"]!>"><!=item["prodName"]!></td>
					<td title="<!=item["custNo"]!>"><!=item["custNo"]!></td>
					<td title="<!=item["custName"]!>"><!=item["custName"]!></td>
					<td title="<!=item["invstDate"]!>"><!=item["invstDate"]!></td>
					<td title="<!=item["acctTyp"]!>"><!=item["acctTyp"]!></td>
					<td title="<!=item["invstAmt"]!>"><!=item["invstAmt"]!></td>
					<td title="<!=item["prodRat"]!>"><!=item["prodRat"]!></td>
					<td title="<!=item["lockRat"]!>"><!=item["lockRat"]!></td>
					<td title="<!=item["busnTyp"]!>"><!=item["busnTyp"]!></td>
					<td title="<!=item["repayTyp"]!>"><!=item["repayTyp"]!></td>
					<td title="<!=item["bgnDate"]!>"><!=item["bgnDate"]!></td>
					<td title="<!=item["endDate"]!>"><!=item["endDate"]!></td>
					<td title="<!=item["lockTyp"]!>"><!=item["lockTyp"]!></td>
					<td title="<!=item["mthRepayDay"]!>"><!=item["mthRepayDay"]!></td>
					<td title="<!=item["mthRepayAmt"]!>"><!=item["mthRepayAmt"]!></td>
					<td title="<!=item["totlRepayAmt"]!>"><!=item["totlRepayAmt"]!></td>
					<td title="<!=item["clrDate"]!>"><!=item["clrDate"]!></td>
					<td title="<!=item["invstStat"]!>"><!=item["invstStat"]!></td>
					<td title="<!=item["fstRepayDate"]!>"><!=item["fstRepayDate"]!></td>
					<td title="<!=item["invstDesc"]!>"><!=item["invstDesc"]!></td>
					<td title="<!=item["instDate"]!>"><!=item["instDate"]!></td>
					<td title="<!=item["updtDate"]!>"><!=item["updtDate"]!></td>
					<td title="<!=item["redomAmt"]!>"><!=item["redomAmt"]!></td>
					<td title="<!=item["batFlag"]!>"><!=item["batFlag"]!></td>
					<td title="<!=item["recordStat"]!>"><!=item["recordStat"]!></td>
					<td>
						<a title="详情" data-value="<!=item["invstNo"]!>" class="detail">详情</a>
						<a title="修改" data-value="<!=item["invstNo"]!>" class="edit">修改</a>
						<a title="删除" data-value="<!=item["invstNo"]!>" class="delete">删除</a>
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
		var invstAcctRegDialog;
		$(function(){
			// 1、添加
			$("#addBtn").click(function(){
				seajs.use("component/dialog", function (dialog) {
				    invstAcctRegDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/invstAcctReg/toAdd.do", // 内容
				        "title" : "添加投资登记薄信息" //标题
					});
				});
			});
			// 2、详细
			$("#tbwrap").delegate(".detail", "click", function () {
				// 2.1 获取主键
				var invstNo = $(this).data("value");
				// 2.2 弹窗窗口，显示详细信息
				seajs.use("component/dialog", function (dialog) {
				    invstAcctRegDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/invstAcctReg/view.do?invstNo="+invstNo, // 内容
				        "title" : "查看{beanCnName}详细信息" //标题
					});
				});
			});
			// 3、编辑
			$("#tbwrap").delegate(".edit", "click", function () {
				// 3.1 获取主键
				var invstNo = $(this).data("value");
				// 3.2 弹窗窗口，显示详细信息
				seajs.use("component/dialog", function (dialog) {
				    invstAcctRegDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/invstAcctReg/toEdit.do?invstNo="+invstNo, // 内容
				        "title" : "编辑{beanCnName}详细信息" //标题
					});
				});
			});
			// 4、删除
			$("#tbwrap").delegate(".delete", "click", function () {
				var invstNo = $(this).data("value");
				if (confirm('确定删除？')) {
					$.post("${ctx}/invstAcctReg/delete.do", {invstNo : invstNo}, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/invstAcctReg/list.do?ts="+new Date().getTime()); //如果操作成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.invstAcctRegDialog.close();
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
		        $.post("${ctx}/invstAcctReg/ajaxPage.do",
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
	                	$.post("${ctx}/invstAcctReg/ajaxPage.do", { page: page,  deptCnName: deptCnName, deptEnName: deptEnName },
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
