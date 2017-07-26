<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审批查询</title>
<script type="text/javascript">

	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/queryChangeInfoAction_queryPage.action";
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
							<legend class="chaxuntj">历史归属地变更查询</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">
								<tr>
									<td>企业名称：</td>
									<td><input type="text" name="condition.corpName"
										value="<s:property value="condition.corpName"/>" /></td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</form>
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			onmouseover="changeto()" onmouseout="changeback()">
			<tr>
				<th>序号</th>
				<th>企业名称</th>
				<th>原归属地名称</th>
				<th>欲变更归属地名称</th>
				<th>审批结果</th>
				<th>审批时间</th>
				<th>状态</th>
			</tr>
			<s:iterator status="i" value="currentPage.data">
				<tr>
					<td><s:property value="#i.count" /></td>
					<td><s:property value="corpName" /></td>
					<td><s:if test='beforeArea==230100'>哈尔滨</s:if> <s:if
							test='beforeArea==230200'>齐齐哈尔</s:if> <s:if
							test='beforeArea==231000'>牡丹江</s:if> <s:if
							test='beforeArea==230600'>大庆</s:if> <s:if
							test='beforeArea==230700'>伊春</s:if> <s:if
							test='beforeArea==230400'>鹤岗</s:if> <s:if
							test='beforeArea==230800'>佳木斯</s:if> <s:if
							test='beforeArea==231100'>黑河</s:if> <s:if
							test='beforeArea==232700'>大兴安岭地区</s:if> <s:if
							test='beforeArea==400021'>森工</s:if> <s:if
							test='beforeArea==400022'>绥芬河</s:if> <s:if
							test='beforeArea==400023'>抚远</s:if> <s:if
							test='beforeArea==230300'>鸡西</s:if> <s:if
							test='beforeArea==400020'>农垦</s:if> <s:if
							test='beforeArea==230900'>七台河</s:if> <s:if
							test='beforeArea==230500'>双鸭山</s:if> <s:if
							test='beforeArea==231200'>绥化</s:if></td>
					<td><s:if test='status==2'>跨省变更</s:if> <s:if test='status==1'>
							<s:if test='afterCityArea==230100'>哈尔滨</s:if>
							<s:if test='afterCityArea==230200'>齐齐哈尔</s:if>
							<s:if test='afterCityArea==231000'>牡丹江</s:if>
							<s:if test='afterCityArea==230600'>大庆</s:if>
							<s:if test='afterCityArea==230700'>伊春</s:if>
							<s:if test='afterCityArea==230400'>鹤岗</s:if>
							<s:if test='afterCityArea==230800'>佳木斯</s:if>
							<s:if test='afterCityArea==231100'>黑河</s:if>
							<s:if test='afterCityArea==232700'>大兴安岭地区</s:if>
							<s:if test='afterCityArea==400021'>森工</s:if>
							<s:if test='afterCityArea==400022'>绥芬河</s:if>
							<s:if test='afterCityArea==400023'>抚远</s:if>
							<s:if test='afterCityArea==230300'>鸡西</s:if>
							<s:if test='afterCityArea==400020'>农垦</s:if>
							<s:if test='afterCityArea==230900'>七台河</s:if>
							<s:if test='afterCityArea==230500'>双鸭山</s:if>
							<s:if test='afterCityArea==231200'>绥化</s:if>
						</s:if></td>
					<td><s:if test='process==1'>待审批</s:if> <s:if test='process==2'>释放地市审批同意</s:if>
						<s:if test='process==3'>释放地市审批不同意</s:if> <s:if test='process==4'>接收地市审批同意</s:if>
						<s:if test='process==5'>接收地市审批不同意</s:if> <s:if test='process==6'>变更成功</s:if>
						<s:if test='process==7'>变更失败</s:if></td>
					<td><s:date name="lastDate" format="yyyy-MM-dd" /></td>
					<td align='center'><a
						href="queryChangeInfoAction_queryInfo.action?changeId=<s:property value="changeId"/>">详细</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
	</div>
</body>
</html>