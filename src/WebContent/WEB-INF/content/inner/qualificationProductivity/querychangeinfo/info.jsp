<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审批详细信息</title>
<script type="text/javascript">
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/queryChangeInfoAction_queryPage.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">历史审批详细信息</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>企业名称：</td>
						<td><s:property value="change.corpName" /></td>

						<td>企业变更之前归属地：</td>
						<td><s:if test='change.beforeArea==230100'>哈尔滨</s:if> <s:if
								test='change.beforeArea==230200'>齐齐哈尔</s:if> <s:if
								test='change.beforeArea==231000'>牡丹江</s:if> <s:if
								test='change.beforeArea==230600'>大庆</s:if> <s:if
								test='change.beforeArea==230700'>伊春</s:if> <s:if
								test='change.beforeArea==230400'>鹤岗</s:if> <s:if
								test='change.beforeArea==230800'>佳木斯</s:if> <s:if
								test='change.beforeArea==231100'>黑河</s:if> <s:if
								test='change.beforeArea==232700'>大兴安岭地区</s:if> <s:if
								test='change.beforeArea==400021'>森工</s:if> <s:if
								test='change.beforeArea==400022'>绥芬河</s:if> <s:if
								test='change.beforeArea==400023'>抚远</s:if> <s:if
								test='change.beforeArea==230300'>鸡西</s:if> <s:if
								test='change.beforeArea==400020'>农垦</s:if> <s:if
								test='change.beforeArea==230900'>七台河</s:if> <s:if
								test='change.beforeArea==230500'>双鸭山</s:if> <s:if
								test='change.beforeArea==231200'>绥化</s:if></td>
					</tr>
					<tr>
						<td>企业欲变更归属地：</td>
						<td><s:if test="change.status==2">
								<s:property value="provinceName" />
								<s:property value="cityName" />
							</s:if> <s:if test="change.status==1">
								<s:if test='change.afterCityArea==230100'>哈尔滨</s:if>
								<s:if test='change.afterCityArea==230200'>齐齐哈尔</s:if>
								<s:if test='change.afterCityArea==231000'>牡丹江</s:if>
								<s:if test='change.afterCityArea==230600'>大庆</s:if>
								<s:if test='change.afterCityArea==230700'>伊春</s:if>
								<s:if test='change.afterCityArea==230400'>鹤岗</s:if>
								<s:if test='change.afterCityArea==230800'>佳木斯</s:if>
								<s:if test='change.afterCityArea==231100'>黑河</s:if>
								<s:if test='change.afterCityArea==232700'>大兴安岭地区</s:if>
								<s:if test='change.afterCityArea==400021'>森工</s:if>
								<s:if test='change.afterCityArea==400022'>绥芬河</s:if>
								<s:if test='change.afterCityArea==400023'>抚远</s:if>
								<s:if test='change.afterCityArea==230300'>鸡西</s:if>
								<s:if test='change.afterCityArea==400020'>农垦</s:if>
								<s:if test='change.afterCityArea==230900'>七台河</s:if>
								<s:if test='change.afterCityArea==230500'>双鸭山</s:if>
								<s:if test='change.afterCityArea==231200'>绥化</s:if>
							</s:if></td>
						<td>审批结果：</td>
						<td><s:if test='change.process==6'>归属地变更成功</s:if> <s:if
								test='change.process==7'>归属地变更失败</s:if></td>
					</tr>
					<tr>
						<td>释放部门意见：</td>
						<td><s:property value="change.beforeOp" /></td>
						<td>释放部门审批时间：</td>
						<td><s:date name="change.beforeDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>接收部门意见：</td>
						<td><s:property value="change.afterOp" /></td>
						<td>接收部门审批时间：</td>
						<td><s:date name="change.afterDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>省厅审批意见：</td>
						<td><s:property value="change.lastOp" /></td>

						<td>省厅审批时间：</td>
						<td><s:date name="change.lastDate" format="yyyy-MM-dd" /></td>
					</tr>
				</table>
				<div class="sp_bton">
					<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>