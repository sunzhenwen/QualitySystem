<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技术工人注册页面</title>
<script type="text/javascript">
	

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
		document.form1.action="<%=basepath %>/skilledworkerAction_goList.action";
		document.form1.submit();
	}
	
	//操作提示信息
	function getMessage()
	{
		var message = document.getElementById("message").value;
		if(message != "")
		{
			alert(message);
		}
	}
</script>

</head>
<body onload="getMessage()">
<div class="ry_wrapp">
		<div class="index_top">
			<img src="<%=basepath %>/img/zhindex_name.png" />
		</div>
		<form id="form1" name="form1" method="post" action="<%=basepath %>/skilledworkerAction_created.action">
		<div class="ry_content">
<input type="hidden" id="message" value="<s:property value="message" />" />
			<div class="ry_lbxx">
				<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
				<h2 class="f16 fb">新技术人员信息录入表</h2>
				<table class="" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td>人员名称：</td>
						<td>
						<input type="text" maxlength='50'  name="skilledworker.personName" value="<s:property value="skilledworker.personName"/>" class="required" /><strong><font color="#FF0000">*</font></strong>
						<input type="hidden" name="skilledworker.personId" value="<s:property value="skilledworker.personId"/>"/>
						</td>
					</tr>

					<tr>
						<td>性别：</td>
						<td>
						<select id="" name="skilledworker.sexNum" class="required">
							<option value="">请选择</option>
							<s:iterator value="sexName">
								<option value="<s:property value = "code" />" <s:if test='skilledworker.sexNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>

					<tr>
						<td>证件类型：</td>
						<td>
						<select id="" name="skilledworker.idCardTypeNum" class="required">
							<option value="">请选择</option>
							<s:iterator value="idCardTypeName">
								<option value="<s:property value = "code" />"<s:if test='skilledworker.idCardTypeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>

					<tr>
						<td>证件号码：</td>
						<td><input type="text" maxlength='18'  name="skilledworker.identityCard" class="{required:true,digits:true,}" /><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					
					<tr>
						<td>工种类型：</td>
						<td>
						<select id="" name="skilledworker.skilledType" class="required">
							<option value="">请选择</option>
							<s:iterator value="typedNums">
								<option value="<s:property value = "code" />"<s:if test='skilledworker.skilledTypeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					
					<tr>
						<td>工种级别：</td>
						<td>
						<select id="" name="skilledworker.skilledLevel" class="required">
							<option value="">请选择</option>
							<s:iterator value="levelNums">
								<option value="<s:property value = "code" />"<s:if test='skilledworker.skilledLevelNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
						<tr>
						<td>民族：</td>
						<td>
						<select id="" name="skilledworker.nationAlityNum" class="required">
							<option value="">请选择</option>
							<s:iterator value="nationalName">
								<option value="<s:property value="code"/>"<s:if test='skilledworker.nationAlityNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>

					<tr>
						<td>手机号码：</td>
						<td>
						<input type="text" maxlength='50'  name="skilledworker.mobile" value="<s:property value="skilledworker.mobile"/>" class="required" /><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>

					<tr>
						<td>学位：</td>
						<td>
						<select id="" name="skilledworker.degreeNum" class="required">
							<option value="">请选择</option>
							<s:iterator value="degreeName">
								<option value="<s:property value="code"/>"<s:if test='skilledworker.degreeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>

					<tr>
						<td>学历：</td>
						<td>
						<select id="" name="skilledworker.eduLevelNum" class="required">
							<option value="">请选择</option>
							<s:iterator value="eduLevelName">
								<option value="<s:property value="code"/>"<s:if test='skilledworker.eduLevelNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					
					<tr>
						<td>出生日期：</td>
						<td><input type="text" name="skilledworker.birthday" value="<s:date name="skilledworker.birthday" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					</tbody>
					</table>
					<div class="ry_lbreturn">
						<input type="image" src="<%=basepath %>/img/qy_02.png" />
						<input type="image" src="<%=basepath %>/img/fanhui_03.png" onclick="goBack()" />
					</div>
					</div>
			</div>
		</div>
		</form>
		<%@include file="/WEB-INF/content/outside/footer.jsp"%>
	</div>
</body>
</html>