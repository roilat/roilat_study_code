/**
 * 
 */
let pager = {};
	pager.init = function(selectorDom,formDom,checkDom,schemaSet,validator){
		this.selectorDom = selectorDom;
		this.formDom = formDom;
		this.checkDom = checkDom;
		this.schemaSet = SchemaSet;
		this.validator = validator;
		this.currentSchema = "";
		this.initSelector();
		this.generateTable();
		this.bindCheck();
		
	}
	pager.initSelector=function(){
		let options = '';
		for(let item in this.schemaSet){
			options += `<option value="${this.schemaSet[item].name}" >${this.schemaSet[item].desc}</option>`;
		}
		this.selectorDom.innerHTML=options;
		this.selectorDom.onchange = e=>{
			this.generateTable();
		};
	}
	pager.generateTable = function(){
		let value = this.selectorDom.value;
		let schema = this.schemaSet[value];
		let form = "";
		for(let field of schema.fields){
			let inputType = field.fieldType == "date"?"date":field.fieldType=="select"?"select":"text";
			if("select" == inputType){
				let options = '';
				for(let item of field.listItems){
					options += `<option value="${item.value}" >${item.desc}</option>`;
				}
				form += `<label for="${field.fieldName}">${field.fieldDesc}：</label><select name="${field.fieldName}" id="${field.fieldName}">
				${options}</select>`;
			}else{
				form += `<label for="${field.fieldName}">${field.fieldDesc}：</label>
					<input name="${field.fieldName}" id="${field.fieldName}" type="${inputType}" required="${field.required}" /><br/>`;
			}
		}
		this.currentSchema = value;
		this.formDom.innerHTML=form;
	}
	pager.bindCheck = function(){
		let $this = this;
		this.checkDom.onclick = function(){
			let inputs = $this.formDom.getElementsByTagName("input");
			let selects = $this.formDom.getElementsByTagName("select");
			let obj = {};
			inputs && Array.from(inputs).forEach(item => {
				obj[item.name] = item.value;
			});
			selects && Array.from(selects).forEach(item => {
				obj[item.name] = item.value;
			});
			$this.validate(obj);
		}
	}
	pager.validate = function(obj){
		console.log(obj)
			this.validator.validate(this.schemaSet[this.currentSchema], obj, function(msg) {
				alert(msg || "验证成功");
			});
	}
