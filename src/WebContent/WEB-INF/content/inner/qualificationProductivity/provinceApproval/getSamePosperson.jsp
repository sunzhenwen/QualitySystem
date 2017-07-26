<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>重复岗位人员查看</title>
</head>
<body>
	<form id="form1" name="form1" method="post" action="">
		<div class="libiao">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">重复岗位人员查看</legend>
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
					<th>岗位名称</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="sex" /></td>
						<td><s:property value="cardId" /></td>
						<td><s:property value="duty" /></td>
					</tr>
				</s:iterator>

			</table>
		</div>
	</form>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>