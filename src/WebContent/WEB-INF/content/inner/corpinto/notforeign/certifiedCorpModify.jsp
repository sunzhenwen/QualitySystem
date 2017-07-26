<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业基本信息修改</title>
<script type="text/javascript">
	
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});
	
	function shuru(txt){
	    txt.value=txt.value.replace(/\D/g,"");
	  }
	
	//textare限制I长度
	function checkMaxInput(txt)
	{
	       if (txt.value.length > 500)
	       txt.value = txt.value.substring(0, 500);
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/certifiedCorpAction_goBusiness.action";
		document.form1.submit();
	}
	
		
</script>
</head>
<body>
	<form id="form1" name="form1" method="post"
		action="<%=basepath %>/certifiedCorpAction_modifyCorp.action">
		<div class="qy_wrapp">
			<div class="index_top">
				<img src="<%=basepath %>/img/zhindex_name.png" />

			</div>

			<div class="qyxg_main">

				<h2 class="f16 fb">企业基本信息修改</h2>

				<table class="qyxg_mtable qyxgtop " cellpadding="0" cellspacing="0">


					<tr>
						<td>企业名称：</td>
						<td>
						<s:property value="corp.corpName" /> 
						<input type="hidden" value="<s:property value="corp.corpId" />" name="corp.corpId"    />
						</td>
						<td>组织机构代码或统一社会信用代码：</td>
						<td><s:property value="corp.corpCode"   /></td>
					</tr>

					<tr>
						<td>工商营业执照注册号：</td>
						<td><s:property value="corp.licenseNum" /></td>
						<td>注册所在省（自治区、直辖市）：</td>
						<td><s:property value="corp.provinceName" /></td>
					</tr>
					<tr>
						<td>注册所在地（市、州、盟）：</td>
						<td><s:property value="corp.cityName" /></td>
						<td>注册所在县（区、市、旗）：</td>
						<td><s:property value="corp.countyName" /></td>
					</tr>
					<tr>
						<td>企业营业地址：</td>
						<td><s:property value="corp.address" /></td>
						<td>企业登记注册类型：</td>
						<td><s:property value="corp.economicName" /></td>
					</tr>
					<tr>
						<td>注册资本（万元）：</td>
						<td><s:property value="corp.regPrin" /></td>
						<td>实收资本（万元）：</td>
						<td><s:property value="corp.factRegPrin" /></td>
					</tr>
					<tr>
						<td>注册资本币种：</td>
						<td><s:property value="corp.principalUnitName" /></td>
						<td>法定代表人姓名：</td>
						<td><s:property value="corp.legalMan" /></td>
					</tr>

				</table>
				<hr />
				<table class="qyxg_mtable qyxgbottom" cellpadding="0" cellspacing="0">
					<tr>
						<td>法定代表人证件类型：</td>
						<td>
						<select id="" name="corp.idCardTypeNum">
							<s:iterator value="idCardType">
								<option value="<s:property value="code"/>"
									<s:if test='corp.idCardTypeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							
						</select>&nbsp;&nbsp;
						</td>
						<td>法定代表人证件号码：</td>
						<td>
							<input type="text" value="<s:property value="corp.legalManIdCard" />"  maxlength='30'  name="corp.legalManIdCard" class="{required:true,digits:true}" /><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					<tr>
						<td>企业营业地址邮政编码：</td>
						<td>
							<input type="text"  maxlength='6'  value="<s:property value="corp.postalCode" />" name="corp.postalCode" class="required"/><strong><font color="#FF0000">*</font></strong>
						</td>
						<td>法定代表职务：</td>
						<td><input type="text"  maxlength='50'  value="<s:property value="corp.legalManDuty" />" name="corp.legalManDuty" class="required" /><strong><font color="#FF0000">*</font></strong></td>
						
					</tr>
					<tr>
						<td>法定代表职称：</td>
						<td><input type="text"  maxlength='50'  value="<s:property value="corp.legaManProtitle" />" name="corp.legaManProtitle" class="required" /><strong><font color="#FF0000">*</font></strong></td>
						<td>办公电话：</td>
						<td><input type="text"  maxlength='30'  value="<s:property value="corp.officePhone" />" name="corp.officePhone" class="required" /><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>传真号码：</td>
						<td><input type="text"  maxlength='30'  value="<s:property value="corp.fax" />" name="corp.fax" class="required" />&nbsp;&nbsp;</td>
						<td>联系人号码：</td>
						<td><input type="text" value="<s:property value="corp.linkMan" />" name="corp.linkMan" class="required" /><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>联系人办公电话：</td>
						<td><input type="text"  maxlength='30'  value="<s:property value="corp.linkTel" />" name="corp.linkTel" class="required" />&nbsp;&nbsp;</td>

						<td>联系人手机号码：</td>
						<td><input type="text"  maxlength='30'  value="<s:property value="corp.linkPhone" />" name="corp.linkPhone" class="required" />&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>联系邮箱：</td>
						<td><input type="text"  maxlength='100'  value="<s:property value="corp.email" />" name="corp.email" class="email" />&nbsp;&nbsp;</td>
						<td>企业网址：</td>
						<td><input type="text"  maxlength='200'  value="<s:property value="corp.url" />" name="corp.url" />&nbsp;&nbsp;</td>
					</tr>
					    </tr>
					<tr>
						<td>备注：</td><td><textarea id="${msg.openId}" name="corp.description" style="height:80px" cols="20" rows="10"  onKeyUp="checkMaxInput(this)" onKeyDown="checkMaxInput(this)"><s:property value="corp.description" /></textarea>&nbsp;&nbsp;</td>
						<td>机械设备：</td><td><textarea id="${msg.openId}" name="corp.machinery" style="height:80px" cols="20" rows="10"  onKeyUp="checkMaxInput(this)" onKeyDown="checkMaxInput(this)"><s:property value="corp.machinery" /></textarea>&nbsp;&nbsp;</td>
					</tr>
					<tr><td>净资产(万元)：</td>
	                    <td><input type="text"  maxlength='15' onkeyup="if(isNaN(value))execCommand('undo')"  onafterpaste="if(isNaN(value))execCommand('undo')" value="<s:property value="corp.assets" />"  name="corp.assets" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
						<td>成立日期：</td>
						<td><input id="time1" type="text"
							value="<s:date name="corp.corpBirthDate" format="yyyy-MM-dd" />"
							name="corp.corpBirthDate"
							onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})"
							class="required" /><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
				</table>

				<div class="botn">
					<input type="image" src="<%=basepath %>/img/qy_02.png" /> 
					<input type="image" src="<%=basepath %>/img/qy_01.png" onclick="goBack()" />
				</div>

			</div>
			<%@include file="/WEB-INF/content/outside/footer.jsp"%>
		</div>
	</form>
</body>
</html>