<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询债权信息列表</title>
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
				<th>债券编号</th>
				<th>原始产品编号</th>
				<th>原始产品名称</th>
				<th>原始投资编号</th>
				<th>还款方式</th>
				<th>转让用户</th>
				<th>原始产品期限</th>
				<th>转让金额</th>
				<th>转让类型</th>
				<th>dedtFeeRat</th>
				<th>折价率</th>
				<th>实际收益率</th>
				<th>原始产品金额</th>
				<th>原始投资金额</th>
				<th>转让利息</th>
				<th>产品剩余期数</th>
				<th>产品开始时间</th>
				<th>产品到期日</th>
				<th>产品剩余天数</th>
				<th>申请时间</th>
				<th>转让时间</th>
				<th>sellTmsp</th>
				<th>截止时间</th>
				<th>minInvstAmt</th>
				<th>maxInvstAmt</th>
				<th>转让状态</th>
				<th>备注</th>
				<th>创建日期</th>
				<th>修改日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody data-type="body">
			<!if(list.length>0) { !>
				<!for(var i=0,len=list.length;i<len;i++){
					var item = list[i],classItem = (i%2!=0)?"odd td_odd":"even";
				!>
				<tr class="gradeA <!=classItem!>">
					<td title="<!=item["debtNo"]!>"><!=item["debtNo"]!></td>
					<td title="<!=item["prodNo"]!>"><!=item["prodNo"]!></td>
					<td title="<!=item["prodName"]!>"><!=item["prodName"]!></td>
					<td title="<!=item["invstNo"]!>"><!=item["invstNo"]!></td>
					<td title="<!=item["repayTyp"]!>"><!=item["repayTyp"]!></td>
					<td title="<!=item["custNo"]!>"><!=item["custNo"]!></td>
					<td title="<!=item["prodPerd"]!>"><!=item["prodPerd"]!></td>
					<td title="<!=item["debtAmt"]!>"><!=item["debtAmt"]!></td>
					<td title="<!=item["debtType"]!>"><!=item["debtType"]!></td>
					<td title="<!=item["dedtFeeRat"]!>"><!=item["dedtFeeRat"]!></td>
					<td title="<!=item["discountRat"]!>"><!=item["discountRat"]!></td>
					<td title="<!=item["prftRat"]!>"><!=item["prftRat"]!></td>
					<td title="<!=item["loanAmt"]!>"><!=item["loanAmt"]!></td>
					<td title="<!=item["invstAmt"]!>"><!=item["invstAmt"]!></td>
					<td title="<!=item["dettolIntAmt"]!>"><!=item["dettolIntAmt"]!></td>
					<td title="<!=item["debtPerd"]!>"><!=item["debtPerd"]!></td>
					<td title="<!=item["bgnDate"]!>"><!=item["bgnDate"]!></td>
					<td title="<!=item["endDate"]!>"><!=item["endDate"]!></td>
					<td title="<!=item["days"]!>"><!=item["days"]!></td>
					<td title="<!=item["applyDate"]!>"><!=item["applyDate"]!></td>
					<td title="<!=item["startDate"]!>"><!=item["startDate"]!></td>
					<td title="<!=item["sellTmsp"]!>"><!=item["sellTmsp"]!></td>
					<td title="<!=item["bidDueDate"]!>"><!=item["bidDueDate"]!></td>
					<td title="<!=item["minInvstAmt"]!>"><!=item["minInvstAmt"]!></td>
					<td title="<!=item["maxInvstAmt"]!>"><!=item["maxInvstAmt"]!></td>
					<td title="<!=item["debtStat"]!>"><!=item["debtStat"]!></td>
					<td title="<!=item["prodRemk"]!>"><!=item["prodRemk"]!></td>
					<td title="<!=item["instDate"]!>"><!=item["instDate"]!></td>
					<td title="<!=item["updtDate"]!>"><!=item["updtDate"]!></td>
					<td>
						<a title="详情" data-value="<!=item["debtNo"]!>" class="detail">详情</a>
						<a title="修改" data-value="<!=item["debtNo"]!>" class="edit">修改</a>
						<a title="删除" data-value="<!=item["debtNo"]!>" class="delete">删除</a>
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
		var pubDebtDialog;
		$(function(){
			// 1、添加
			$("#addBtn").click(function(){
				seajs.use("component/dialog", function (dialog) {
				    pubDebtDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/pubDebt/toAdd.do", // 内容
				        "title" : "添加债权信息信息" //标题
					});
				});
			});
			// 2、详细
			$("#tbwrap").delegate(".detail", "click", function () {
				// 2.1 获取主键
				var debtNo = $(this).data("value");
				// 2.2 弹窗窗口，显示详细信息
				seajs.use("component/dialog", function (dialog) {
				    pubDebtDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/pubDebt/view.do?debtNo="+debtNo, // 内容
				        "title" : "查看{beanCnName}详细信息" //标题
					});
				});
			});
			// 3、编辑
			$("#tbwrap").delegate(".edit", "click", function () {
				// 3.1 获取主键
				var debtNo = $(this).data("value");
				// 3.2 弹窗窗口，显示详细信息
				seajs.use("component/dialog", function (dialog) {
				    pubDebtDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/pubDebt/toEdit.do?debtNo="+debtNo, // 内容
				        "title" : "编辑{beanCnName}详细信息" //标题
					});
				});
			});
			// 4、删除
			$("#tbwrap").delegate(".delete", "click", function () {
				var debtNo = $(this).data("value");
				if (confirm('确定删除？')) {
					$.post("${ctx}/pubDebt/delete.do", {debtNo : debtNo}, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/pubDebt/list.do?ts="+new Date().getTime()); //如果操作成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.pubDebtDialog.close();
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
		        $.post("${ctx}/pubDebt/ajaxPage.do",
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
	                	$.post("${ctx}/pubDebt/ajaxPage.do", { page: page,  deptCnName: deptCnName, deptEnName: deptEnName },
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
