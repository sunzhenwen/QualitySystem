<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function getPosperson(corpName){
		var openUrl = "<%=basepath%>/querySkillworkerNumAction_getPosNum.action?corpName="+corpName;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)
	}
	
	function getTitleperson(corpName){
		var openUrl = "<%=basepath%>/querySkillworkerNumAction_getTitleNum.action?corpName="+ corpName;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>技术工种查看</title>

</head>
<body>
	<form id="form1" name="form1" method="post" action="">
		<div class="libiao">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">技术工种查看</legend>
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
									<td>重复岗位人员：<s:property value="corpName" /></td>
									<td><s:iterator status="i" value="currentPage.data">
											<s:if test="#i.count==1">
												<a href="#"
													onclick="getPosperson('<s:property value="corpName" />')">查看
												</a>
											</s:if>
										</s:iterator></td>

									<td>重复职称人员：<s:property value="corpName" /></td>
									<td><s:iterator status="i" value="currentPage.data">
											<s:if test="#i.count==1">
												<a href="#"
													onclick="getTitleperson('<s:property value="corpName" />')">查看
												</a>
											</s:if>
										</s:iterator>
										<s:property value="corpName" /></td>
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
					<th>学历</th>
					<th>学位</th>
					<th>工种类型</th>
					<th>工种级别</th>
					<th>企业编码</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="personName" /></td>
						<td><s:property value="sexName" /></td>
						<td><s:property value="identityCard" /></td>
						<td><s:property value="eduLevelName" /></td>
						<td><s:property value="degreeName" /></td>
						<td><s:property value="skilledType" /></td>
						<td><s:property value="skilledLevel" /></td>
						<td><s:property value="corpCode" /></td>
					</tr>
				</s:iterator>

			</table>
		</div>
	</form>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>