<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function getPosperson(corpName){
		var openUrl = "<%=basepath%>/queryTitleNumAction_getPosNum.action?corpName=" + corpName;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)
	}
	
	function getSkillworkerperson(corpName){
		var openUrl = "<%=basepath%>/queryTitleNumAction_getSkillworkerNum.action?corpName="+ corpName;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>职称人员查看</title>

</head>
<body>
	<form id="form1" name="form1" method="post" action="">
		<div class="libiao">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">职称人员查看</legend>
							<p style="margin-bottom: 10px; text-align: right;">
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">
								<tr>
									<td colspan="4">企业名称：<s:iterator status="i"
											value="currentPage.data">
											<s:if test="#i.count==1">
												<s:property value="corpName" />
											</s:if>
										</s:iterator>
									</td>
								</tr>
								<tr>
									<td>重复岗位人员：</td>
									<td><s:iterator status="i"
											value="currentPage.data">
											<s:if test="#i.count==1"><a href="#"
										onclick="getPosperson('<s:property value="corpName"/>')">查看
									</a></s:if>
										</s:iterator></td>

									<td>重复技术人员：</td>
									<td><s:iterator status="i"
											value="currentPage.data">
											<s:if test="#i.count==1"><a href="#"
										onclick="getSkillworkerperson('<s:property value="corpName"/>')">查看
									</a></s:if>
										</s:iterator></td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				onmouseover="changeto()" onmouseout="changeback()">
				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>证件号码</th>
					<th>企业编码</th>
					<th>职称</th>
					<th>职称专业</th>
					<th>职称级别</th>
					<th>毕业学校</th>
					<th>毕业时间</th>
					<th>所学专业</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="personName" /></td>
						<td><s:property value="sexName" /></td>
						<td><s:property value="idCard" /></td>
						<td><s:property value="corpCode" /></td>
						<td><s:property value="titleName" /></td>
						<td><s:property value="titleMajor" /></td>
						<td><s:property value="titleLevel" /></td>
						<td><s:property value="graduatedSchool" /></td>
						<td><s:date name="graduatedDate" format="yyyy-MM-dd" /></td>
						<td><s:property value="studyMajor" /></td>
					</tr>
				</s:iterator>

			</table>
		</div>
	</form>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>