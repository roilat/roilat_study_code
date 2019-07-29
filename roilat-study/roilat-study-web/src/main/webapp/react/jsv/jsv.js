/**
 * 
 */
let JSV = {
			fieldTypes : [ "text", "number", "date", "select" ],/* 支持的数据类型 */
			dateFormat : /^\d{4}-(((01|03|05|07|08|10|12)-((0[1-9])|([12][0-9])|(3[01])))|((04|06|09|11)-((0[1-9])|([12][0-9])|(30)))|(02-((0[1-9])|([12][0-9]))))$/,
			schemaCheck : function(schema) {
				if (!schema)
					return "配置信息为空";
				if (!schema.name)
					return "配置名称为空";
				if (!schema.desc)
					return "配置描述为空";
				if (!schema.fields)
					return "配置字段为空";
				var filters = schema.filters;
				for (let field of schema.fields) {
					if (!field)
						return "字段配置错误";
					if (!field.fieldName)
						return "字段名称为空";
					if (!field.fieldDesc)
						return "字段描述为空";
					if (!field.fieldType||this.fieldTypes.indexOf(field.fieldType) < 0)
						return "字段类型为空或不支持";
					if(("select" == field.fieldType) && (!field.listItems || field.listItems.length <= 0))
						return "下拉框"+field.fieldDesc+"的可选项为空";
					filters && filters.forEach((x,i)=>{if(field.fieldName==x)filters.splice(i,1);});
					
				}
				if(filters && filters.length > 0){
					return "查询条件"+filters+"不存在";
				}
				return null;
			}
		};
		JSV.validate = function validate(schema, instance, callback) {
			let $this = this;
			var errMsg = this.schemaCheck(schema);
			if (!errMsg) {
				if(!instance){
					errMsg = "数据为空";
				}else{
					schema.fields.every(field=>{
						var fieldValue = instance[field.fieldName];
						if(field.required && !fieldValue){
							errMsg = field.fieldDesc + "为空";
							return false;
						}
						var valueType = typeof(fieldValue);
						console.log(field,valueType)
						switch(field.fieldType){
							case "text":
							case "date":
							case "select":{
								if("string" != valueType){//
									errMsg = field.fieldDesc + "格式错误，期望的格式是[" + field.fieldType + "]";
									return false;
								}
								if("date" == field.fieldType && fieldValue && !$this.dateFormat.test(fieldValue)){
									errMsg = field.fieldDesc + "格式错误，日期格式是[yyyy-MM-dd]";
									return false;
								}
								break;
							}
							case "number":{
								if(fieldValue && !(/^-?(([1-9]\d*)|0)(\.\d+)?$/.test(fieldValue))){
									errMsg = field.fieldDesc + "格式错误，期望的格式是[" + field.fieldType + "]";
									return false;
								}
							}
						}
						return true;
					});
				}
			}
			return callback && (callback instanceof Function)?callback(errMsg) : errMsg || true;
		};
