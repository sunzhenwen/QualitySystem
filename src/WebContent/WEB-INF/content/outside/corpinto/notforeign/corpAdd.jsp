<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新企业注册</title>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
<script type="text/javascript">

	function validateForm() 
	{
		return Validator.Validate(form1,2);
	}
	
	function shuru(txt){
	    txt.value=txt.value.replace(/\D/g,"");
	  }
	

	//textare限制I长度
	function checkMaxInput(txt)
	{
	       if (txt.value.length > 500)
	       txt.value = txt.value.substring(0, 500);
	}
	
	
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/corpAction_queryOutLoginPage.action";
		document.form1.submit();
	}

	//查询市
	function queryCity() {
		$(document).ready(
				function() {
					//获取部门下拉列表的值
					var provinceId = $("#provinceId").val();
					$.ajax({
						url : 'corpAction_queryCity.action',
						type : 'post',
						dataType : 'json',
						data : 'provinceId=' + provinceId,
						success : function(data) {
							//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
							var items = eval("(" + data + ")");
							$("#cityId").empty();
							$("#areaId").empty();
							$("#cityId")
									.append("<option value=''>请选择</option>");
							$("#areaId")
									.append("<option value=''>请选择</option>");
							//循环items,i为循环下标,(默认i从0开始取值)
							$.each(items, function(i) {
								$("#cityId").append(
										"<option value='" + items[i].code+ "'>"
												+ items[i].name + "</option>");
							});
						}
					});
				});
	}

	//查询区
	function queryArea() {
		$(document).ready(
				function() {
					//获取部门下拉列表的值
					var cityNum = $("#cityId").val();
					$.ajax({
						url : 'corpAction_queryArea.action',
						type : 'post',
						dataType : 'json',
						data : 'cityNum=' + cityNum,
						success : function(data) {
							//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
							var items = eval("(" + data + ")");
							$("#areaId").empty();
							//循环items,i为循环下标,(默认i从0开始取值)
							$.each(items, function(i) {
								$("#areaId").append(
										"<option value='" + items[i].code+ "'>"
												+ items[i].name + "</option>");
							});
						}
					});
				});
	}
</script>
</head>
<body>
	<form id="form1" name="form1" method="post"
		action="<%=basepath%>/corpAction_addCorp.action"
		onsubmit="return validateForm()">
		<div class="qy_wrapp">
			<div class="index_top">
				<img src="<%=basepath%>/img/zhindex_name.png" />

			</div>

			<div class="qy_main">

				<h2 class="f16 fb">新企业基本信息录入表</h2>
				
						
						<p style="color:red;text-align:center;font-size:16px;">*为必填项</p>
						
						
					
				<table class="qy_mtable p_left60 left" cellpadding="0"
					cellspacing="0">
					
					
					<tr>
					<tr>
						<td>企业名称：</td>
						<td><input type="text" maxlength='200' id="corpName"
							name="corp.corpName" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>组织机构代码：</td>
						<td><s:property value="corp.corpCode" /> <input
							type="hidden" name="corp.corpCode"
							value="<s:property value = "corp.corpCode"/>" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td>工商营业执照注册号：</td>
						<td><input type="text" maxlength='30' id="corp.licenseNum"
							name="corp.licenseNum" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>注册所在省（自治区、直辖市）：</td>
						<td><select id="provinceId" name="corp.provinceNum"
							onchange="queryCity()" class="required">
								<option value="">请选择</option>
								<s:iterator value="provinces">
									<option value="<s:property value="code"/>" 
									<s:if test="230000 == code">selected</s:if>
									><s:property
											value="name" /></option>
								</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong></td>

					</tr>
					<tr>
						<td>注册所在地（市、州、盟）：</td>
						<td><select id="cityId" name="corp.cityNum"
							onchange="queryArea()" class="required">
								<option value="">请选择</option>
								<s:iterator value="citys">
									<option value='<s:property value="code"/>'><s:property value="name" /></option>
								</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>注册所在县（区、市、旗）：</td>
						<td><select id="areaId" name="corp.countyNum"
							class="required">
								<option value="">请选择</option>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>企业营业地址(按营业执照填写)：</td>
						<td><input type="text" maxlength='200' id="corp.address"
							name="corp.address" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>企业营业地址邮政编码：</td>
						<td><input type="text" maxlength='6' id="corp.postalCode"
							name="corp.postalCode" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>法定代表人姓名：</td>
						<td><input type="text" maxlength='50' id="corp.legalMan"
							name="corp.legalMan" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>法定代表人证件类型：</td>
						<td><select id="" name="corp.idCardTypeNum" class="required">
								<option value="">请选择</option>
								<s:iterator value="idCardType">
									<option value="<s:property value="code"/>"><s:property
											value="name" /></option>
								</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>法定代表人证件号码：</td>
						<td><input type="text" maxlength='30'
							id="corp.legalManIdCard" name="corp.legalManIdCard"
							class="{required:true,digits:true}" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>法定代表职务：</td>
						<td><input type="text" id="corp.legalManDuty"
							name="corp.legalManDuty" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>法定代表职称：</td>
						<td><input type="text" maxlength='50'
							id="corp.legaManProtitle" name="corp.legaManProtitle"
							class="required" /><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>机械设备：</td>
						<td><textarea id="${msg.openId}" name="corp.machinery"
								style="height: 80px" cols="20" rows="10"
								onKeyUp="checkMaxInput(this)" onKeyDown="checkMaxInput(this)"><s:property
									value="corp.machinery" /></textarea>&nbsp;&nbsp;</td>
					</tr>

					</div>
					<table class="qy_mtable left" cellpadding="0" cellspacing="0">

						<tr>
							<td>企业登记注册类型：</td>
							<td><select id="" name="corp.economicNum" class="required">
									<option value="">请选择</option>
									<s:iterator value="economicNum">
										<option value="<s:property value="code"/>"><s:property
												value="name" /></option>
									</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>注册资本（万元）：</td>
							<td><input type="text" maxlength='15' id="corp.regPrin"
								name="corp.regPrin" onkeyup="if(isNaN(value))execCommand('undo')"  onafterpaste="if(isNaN(value))execCommand('undo')"
								class="{required:true,number:true}" /><strong><font
									color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>实收资本（万元）：</td>
							<td><input type="text" maxlength='15' id="corp.factRegPrin"
								onkeyup="if(isNaN(value))execCommand('undo')"  onafterpaste="if(isNaN(value))execCommand('undo')" name="corp.factRegPrin"
								class="{required:true,number:true}" /><strong><font
									color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>净资产(万元)：</td>
							<td><input type="text" maxlength='15' id="corp.assets"
								onkeyup="if(isNaN(value))execCommand('undo')"  onafterpaste="if(isNaN(value))execCommand('undo')" name="corp.assets"
								class="{required:true,number:true}" /><strong><font
									color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>注册资本币种：</td>
							<td><select id="" name="corp.principalUnitNum"
								class="required">
									<option value="">请选择</option>
									<s:iterator value="principalUnit">
										<option value="<s:property value="code"/>"><s:property
												value="name" /></option>
									</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>成立日期：</td>
							<td><input id="time1" type="text" id="corp.corpBirthDate"
								name="corp.corpBirthDate"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})"
								class="required" /><strong><font color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>办公电话：</td>
							<td><input type="text" maxlength='30' id="corp.officePhone"
								name="corp.officePhone" class="required" /><strong><font
									color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>传真号码：</td>
							<td><input type="text" maxlength='30' id="corp.fax"
								name="corp.fax" class="required" /><strong><font
									color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>联系人姓名：</td>
							<td><input type="text" maxlength='50' id="corp.linkMan"
								name="corp.linkMan" class="required" /><strong><font
									color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>联系人办公电话：</td>
							<td><input type="text" maxlength='30' id="corp.linkTel"
								name="corp.linkTel" class="required" /><strong><font
									color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>联系人手机号码：</td>
							<td><input type="text" maxlength='30' id="corp.linkPhone"
								name="corp.linkPhone" class="required" /><strong><font
									color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
							<td>联系邮箱：</td>
							<td><input type="text" maxlength='50' name="corp.email"
								class="email" />&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>企业网址：</td>
							<td><input type="text" maxlength='200' name="corp.url"
								class="url" />&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>备注：</td>
							<td><textarea id="${msg.openId}" name="corp.description"
									style="height: 80px" cols="20" rows="10"
									onKeyUp="checkMaxInput(this)" onKeyDown="checkMaxInput(this)"><s:property
										value="corp.description" /></textarea>&nbsp;&nbsp;</td>
						</tr>
						<tr></tr>
					</table>

					<div class="botn">
						<input type="image" src="<%=basepath%>/img/qy_02.png" /> <input
							type="image" src="<%=basepath%>/img/qy_01.png" onclick="goBack()" />
					</div>
					</div>

					<%@include file="/WEB-INF/content/outside/footer.jsp"%>

					</form>
</body>
</html>