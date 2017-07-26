<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>资质变更</title>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
<script type="text/javascript">
	



	function validateForm(){
		//var effect = document.loginForm.effecttime.value;
		//var abate = document.loginForm.abatetime.value;
		//if(effect != "" && abate!= "") 
		//{
		//	alert("失效时间必须大于生效时间");
		//	return false;
		//}
		return Validator.Validate(form1,2);
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
	<form id="form1" name="form1" method="post" action="<%=basepath %>/qualityChangeAction_addQualityChange.action" onsubmit="return validateForm()">
		<div class="qy_wrapp">
			<div class="index_top">
				<img src="<%=basepath %>/img/zhindex_name.png" />

			</div>

			<div class="qyxg_main">

				<h2 class="f16 fb">企业资质信息变更</h2>

				<table cellpadding="0" cellspacing="0">


					<tr>
						<td>企业名称：</td>
						<td>
						<s:property value="corp.corpName"/> 
						<input type="hidden" value="<s:property value="corp.corpId" />" name="corp.corpId" />
						<input type="hidden" value="<s:property value="login.spare1" />" name="qualityChange.CHANGE_SPARE1" />
						</td>
					</tr>

					<tr>
						<td>工商营业执照注册号：</td>
						<td><s:property value="corp.licenseNum" /></td>
					
					</tr>
					<tr>
							<td>详细地址：</td>
							<td><s:property value="corp.address" /></td>
						
					</tr>
					<tr>
							<td>注册资本(万元)：</td>
							<td><s:property value="corp.regPrin" /></td>
					</tr>
					<tr>
							<td>经济性质：</td>
							<td><s:property value="corp.economicName" /></td>
					</tr>
					<tr>
							<td>法定代表人：</td>
							<td><s:property value="corp.legalMan" /></td>
					</tr>
					<!--  
					<tr>
							<td>企业归属地：</td>
							<td><s:property value="login.spareName" /></td>
					</tr>
					-->
				</table>
				<hr />
				<table cellpadding="0" cellspacing="0">	
					<tr>
						<td>企业名称：</td>
						<td>
							<input type="text" size="120" maxlength='200' value="<s:property value="corp.corpName"/>" name="qualityChange.CHANGE_CORPNAME" dataType="Require" msg="企业名称不能为空" />
						</td>
					</tr>
					<tr>
						<td>工商营业执照注册号：</td>
						<td>
							<input type="text" maxlength='18' size="120" value="<s:property value="corp.licenseNum"/>" name="qualityChange.CHANGE_LICENSENUM" dataType="Require" msg="工商营业执照注册号不能为空" />
						</td>
					</tr>
					<tr>
						<td>详细地址：</td>
						<td>
							<input type="text" maxlength='200' size="120" value="<s:property value="corp.address" />" name="qualityChange.CHANGE_ADDRESS" dataType="Require" msg="详细地址不能为空"/>
						</td>
					</tr>
					<tr>
						<td>注册资本(万元)：</td>
						<td>
							<input type="text" maxlength='15'  size="120" value="<s:property value="corp.regPrin" />" name="qualityChange.CHANGE_REGPRIN" dataType="Double" msg="注册资金不能为空且只能是数字" />
							<!-- <strong><font color="#FF0000">*</font></strong> -->
						</td>
					</tr>
					<tr>
						<td>经济性质：</td>
						<td>
							<select id="" name="qualityChange.CHANGE_ECONOMICNUM" >
								<s:iterator value="economicNum">
									<option value="<s:property value="code"/>"
										<s:if test='corp.economicNum==code'>selected</s:if>><s:property value="name" /></option>
								</s:iterator>
							</select>
												
						</td>
					</tr>	
					<tr>
						<td>法定代表人：</td>
						<td>
							<input type="text" maxlength='50' size="120" value="<s:property value="corp.legalMan" />" name="qualityChange.CHANGE_LEGALMAN" dataType="Require" msg="法定代表人不能为空"/>
						</td>
					</tr>
					
					<tr>
						<td>是否做四码合一：</td>
						<td>
							<input type="checkbox" name="qualityChange.IS_CODE_MERGE" value="1" />
							（工商营业执照注册号与组织机构代码为统一社会信用代码的请选中 没有做过四码合一的不要选）
						</td>
					</tr>
					<!-- 
					<tr>
						<td>企业归属地：</td>
						<td>							
							<select id="" name="qualityChange.CHANGE_SPARE1" >
								<option value="230100" <s:if test='login.spare1==230100'>selected</s:if>>哈尔滨</option>
								<option value="230200" <s:if test='login.spare1==230200'>selected</s:if>>齐齐哈尔</option>
								<option value="231000" <s:if test='login.spare1==231000'>selected</s:if>>牡丹江</option>
								<option value="230600" <s:if test='login.spare1==230600'>selected</s:if>>大庆</option>
								<option value="230700" <s:if test='login.spare1==230700'>selected</s:if>>伊春</option>
								<option value="230400" <s:if test='login.spare1==230400'>selected</s:if>>鹤岗</option>
								<option value="230800" <s:if test='login.spare1==230800'>selected</s:if>>佳木斯</option>
								<option value="231100" <s:if test='login.spare1==231100'>selected</s:if>>黑河</option>
								<option value="232700" <s:if test='login.spare1==232700'>selected</s:if>>大兴安岭地区</option>
								<option value="400021" <s:if test='login.spare1==400021'>selected</s:if>>森工</option>
								<option value="400022" <s:if test='login.spare1==400022'>selected</s:if>>绥芬河</option>
								<option value="400023" <s:if test='login.spare1==400023'>selected</s:if>>抚远</option>
								<option value="230300" <s:if test='login.spare1==230300'>selected</s:if>>鸡西</option>
								<option value="400020" <s:if test='login.spare1==400020'>selected</s:if>>农垦</option>
								<option value="230900" <s:if test='login.spare1==230900'>selected</s:if>>七台河</option>
								<option value="230500" <s:if test='login.spare1==230500'>selected</s:if>>双鸭山</option>
								<option value="231200" <s:if test='login.spare1==231200'>selected</s:if>>绥化</option>
							</select>
											
						</td>
					</tr>
					 -->
					 
					 
					<!--  
					<tr>
						<td>法定代表人证件类型：</td>
						<td>
							<select id="" name="corp.idCardTypeNum">
							  <option>身份证</option>
							</select>
						</td>
					</tr>
					<tr>
					<td>法定代表人证件号码：</td>
					<td>
						<input type="text" value="23012519871103551X" name="corp.legalManIdCard"  />
					</td>
					</tr>
-->
				</table>

				<div class="botn">
					<input type="image" src="<%=basepath %>/img/qy_02.png" onclick="document.form.submit()"/> 
					<input type="image" src="<%=basepath %>/img/qy_01.png" onclick="goBack()" />
				</div>

			</div>
			<%@include file="/WEB-INF/content/outside/footer.jsp"%>
		</div>
	</form>
</body>
</html>