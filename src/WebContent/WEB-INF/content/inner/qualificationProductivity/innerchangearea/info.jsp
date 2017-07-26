<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>归属地变更</title>
<script type="text/javascript">
	
	//审批通过
	function applythrough()
	{
		document.form1.action="<%=basepath%>/innerChangeAreaAction_change.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/innerChangeAreaAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">归属地变更审批</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>企业名称：</td>
						<td><s:property value="corp.corpName" /> <input
							type="hidden" name="corpName"
							value="<s:property value="corp.corpName"/>" /> <input
							type="hidden" name="corpCode"
							value="<s:property value="corp.corpCode"/>" />
							<input type="hidden" name="beforeCity"  value="<s:property value="corp.sapre1"/>"/></td>
						<td>原归属地：</td>
						<td><s:if test='corp.sapre1==230100'>哈尔滨</s:if> <s:if
								test='corp.sapre1==230200'>齐齐哈尔</s:if> <s:if
								test='corp.sapre1==231000'>牡丹江</s:if> <s:if
								test='corp.sapre1==230600'>大庆</s:if> <s:if
								test='corp.sapre1==230700'>伊春</s:if> <s:if
								test='corp.sapre1==230400'>鹤岗</s:if> <s:if
								test='corp.sapre1==230800'>佳木斯</s:if> <s:if
								test='corp.sapre1==231100'>黑河</s:if> <s:if
								test='corp.sapre1==232700'>大兴安岭地区</s:if> <s:if
								test='corp.sapre1==400021'>森工</s:if> <s:if
								test='corp.sapre1==400022'>绥芬河</s:if> <s:if
								test='corp.sapre1==400023'>抚远</s:if> <s:if
								test='corp.sapre1==230300'>鸡西</s:if> <s:if
								test='corp.sapre1==400020'>农垦</s:if> <s:if
								test='corp.sapre1==230900'>七台河</s:if> <s:if
								test='corp.sapre1==230500'>双鸭山</s:if> <s:if
								test='corp.sapre1==231200'>绥化</s:if></td>
					</tr>
					<tr>
						<td>新归属地所属：</td>
						<td><select id="" name="cityNum">
								<option value="230100">哈尔滨</option>
								<option value="230200">齐齐哈尔</option>
								<option value="231000">牡丹江</option>
								<option value="230600">大庆</option>
								<option value="230700">伊春</option>
								<option value="230400">鹤岗</option>
								<option value="230800">佳木斯</option>
								<option value="231100">黑河</option>
								<option value="232700">大兴安岭地区</option>
								<option value="400021">森工</option>
								<option value="400022">绥芬河</option>
								<option value="400023">抚远</option>
								<option value="230300">鸡西</option>
								<option value="400020">农垦</option>
								<option value="230900">七台河</option>
								<option value="230500">双鸭山</option>
								<option value="231200">绥化</option>
						</select></td>
					</tr>
				</table>
				<div class="sp_bton">
					<a href="#"><span class="sp_first" onclick="applythrough()">变更</span></a>
					<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>