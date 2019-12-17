/**
 * 
 */
let SchemaSet = {};
SchemaSet.demo = {
	"name" : "demo",
	"desc" : "测试数据",
	"filters" : [ "name" ],
	"fields" : [ {
		"fieldName" : "name",
		"fieldDesc" : "名称",
		"fieldType" : "text",
		"required" : true
	}, {
		"fieldName" : "number",
		"fieldDesc" : "数字",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "date",
		"fieldDesc" : "时间",
		"fieldType" : "date",
		"required" : false
	}, {
		"fieldName" : "choice",
		"fieldDesc" : "选项",
		"fieldType" : "select",
		"listItems" : [ {
			"value" : "boy",
			"desc" : "男"
		}, {
			"value" : "girl",
			"desc" : "女"
		} ],
		"required" : false
	} ]
};

SchemaSet.utilitiesFee = {
	"name" : "utilitiesFee",
	"desc" : "水电气费数据",
	"filters" : [ "waterFee" ],
	"fields" : [ {
		"fieldName" : "waterFee",
		"fieldDesc" : "水费",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "electricFee",
		"fieldDesc" : "电费",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "natgasFee",
		"fieldDesc" : "天然气费",
		"fieldType" : "number",
		"required" : false
	} ]
};
SchemaSet.dueoutWage = {
	"name" : "dueoutWage",
	"desc" : "待发工资数据",
	"filters" : [ "dueoutCnt" ],
	"fields" : [ {
		"fieldName" : "dueoutCnt",
		"fieldDesc" : "代发人数",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "dueoutAmt",
		"fieldDesc" : "代发金额",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "dueoutDt",
		"fieldDesc" : "代发时间",
		"fieldType" : "date",
		"required" : true
	} ]

};
SchemaSet.cashFlow = {
	"name" : "cashFlow",
	"desc" : "资金流入流出",
	"filters" : [ "cashInflow" ],
	"fields" : [ {
		"fieldName" : "cashInflow",
		"fieldDesc" : "资金流入",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "cashOutflow",
		"fieldDesc" : "资金流出",
		"fieldType" : "number",
		"required" : true
	} ]

};
SchemaSet.operationalData = {
	"name" : "operationalData",
	"desc" : "监管经营数据",
	"filters" : [ "Revenue" ],
	"fields" : [ {
		"fieldName" : "Revenue",
		"fieldDesc" : "经营收入",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "Roomrev",
		"fieldDesc" : "客房收入",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "F&Brev",
		"fieldDesc" : "餐饮收入",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "Otherev",
		"fieldDesc" : "其他收入",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "Operatingexp",
		"fieldDesc" : "经营支出",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "Roomexp",
		"fieldDesc" : "客房支出",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "F&Bexp",
		"fieldDesc" : "餐饮支出",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "Otherexp",
		"fieldDesc" : "其他支出",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "Managementexp",
		"fieldDesc" : "管理部门总支出",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "Non-opexp",
		"fieldDesc" : "非营运支出",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "Managementfee",
		"fieldDesc" : "管理费支出",
		"fieldType" : "number",
		"required" : true
	}, {
		"fieldName" : "EBITDA",
		"fieldDesc" : "息税折旧摊销前利润",
		"fieldType" : "number",
		"required" : true
	} ]

};