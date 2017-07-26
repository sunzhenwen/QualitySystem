<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>内网变更企业归属地</title>
<script type="text/javascript">
//查询
function query()
{
	document.form1.action="<%=basepath%>/innerChangeAreaAction_queryPage.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">变更企业归属地</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">
								<tr>
									<td>企业名称：</td>
									<td><input type="text" name="condition.corpName"
										value="<s:property value="condition.corpName"/>" /></td>
									<td>企业组织机构代码证：</td>
									<td><input type="text" name="condition.corpCode"
										value="<s:property value="condition.corpCode"/>" /></td>
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
					<th>企业名称</th>
					<th>企业组织机构代码证</th>
					<th>企业原归属地</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="corpName" /></td>
						<td><s:property value="corpCode" /></td>
						<td><s:if test='sapre1==230100'>哈尔滨</s:if> <s:if
								test='sapre1==230200'>齐齐哈尔</s:if> <s:if
								test='sapre1==231000'>牡丹江</s:if> <s:if
								test='sapre1==230600'>大庆</s:if> <s:if
								test='sapre1==230700'>伊春</s:if> <s:if
								test='sapre1==230400'>鹤岗</s:if> <s:if
								test='sapre1==230800'>佳木斯</s:if> <s:if
								test='sapre1==231100'>黑河</s:if> <s:if
								test='sapre1==232700'>大兴安岭地区</s:if> <s:if
								test='sapre1==400021'>森工</s:if> <s:if
								test='sapre1==400022'>绥芬河</s:if> <s:if
								test='sapre1==400023'>抚远</s:if> <s:if
								test='sapre1==230300'>鸡西</s:if> <s:if
								test='sapre1==400020'>农垦</s:if> <s:if
								test='sapre1==230900'>七台河</s:if> <s:if
								test='sapre1==230500'>双鸭山</s:if> <s:if
								test='sapre1==231200'>绥化</s:if></td>
						<td align='center'><a
							href="innerChangeAreaAction_changePage.action?corpCode=<s:property value="corpCode"/>">变更</a>
						</td>

					</tr>
				</s:iterator>

			</table>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
	</div>
</body>
</html>