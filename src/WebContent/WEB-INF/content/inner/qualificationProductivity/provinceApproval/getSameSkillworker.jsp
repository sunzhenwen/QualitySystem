<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>重复技术工种查看</title>

</head>
<body>
	<form id="form1" name="form1" method="post" action="">
		<div class="libiao">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">重复技术工种查看</legend>
							<p style="margin-bottom: 10px; text-align: right;">
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">
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
					<th>工种类型</th>
					<th>工种级别</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="personName" /></td>
						<td><s:property value="sexName" /></td>
						<td><s:property value="identityCard" /></td>
						<td><s:property value="skilledType" /></td>
						<td><s:property value="skilledLevel" /></td>
					</tr>
				</s:iterator>

			</table>
		</div>
	</form>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>