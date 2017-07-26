<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>岗位人员查看</title>
<script type="text/javascript">

//岗位人员
function getCountPositions(duty,corpName)
{
	window.open('<%=basepath%>/queryPositionsAction_getSomePositions.action?FDuty='
						+ duty + '&corpName=' + corpName)
	}
	
	function getSkillworker(corpName){
		var openUrl = "<%=basepath%>/queryPosNumAction_getSkillworkerNum.action?corpName="+corpName;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)
	}
	
	function getTitleperson(corpName){
		var openUrl = "<%=basepath%>/queryPosNumAction_getTitleNum.action?corpName="+corpName;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)
	}
</script>

</head>
<body>
	<form id="form1" name="form1" method="post" action="">
		<div class="libiao">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">岗位人员查看</legend>
							<p style="margin-bottom: 10px; text-align: right;">
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">
								<tr>
									<td colspan="4">企业名称：<s:property value="corpName" />
									</td>
								</tr>
								<tr>
									<td>安全员：</td>
									<td><a href="#"
										onclick="getCountPositions('1','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Anquan" />&nbsp;人
									</a></td>

									<td>标准员：</td>
									<td><a href="#"
										onclick="getCountPositions('2','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Biaozhun" />&nbsp;人
									</a></td>
								</tr>
								<tr>
									<td>材料员：</td>
									<td><a href="#"
										onclick="getCountPositions('3','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Cailiao" />&nbsp;人
									</a></td>

									<td>工程测量员：</td>
									<td><a href="#"
										onclick="getCountPositions('4','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Celiang" />&nbsp;人
									</a></td>
								</tr>
								<tr>
									<td>工程检测员：</td>
									<td><a href="#"
										onclick="getCountPositions('5','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Jiance" />&nbsp;人
									</a></td>

									<td>工程造价员：</td>
									<td><a href="#"
										onclick="getCountPositions('6','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Zaojia" />&nbsp;人
									</a></td>
								</tr>
								<tr>
									<td>合同员：</td>
									<td><a href="#"
										onclick="getCountPositions('7','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Hetong" />&nbsp;人
									</a></td>

									<td>机械员：</td>
									<td><a href="#"
										onclick="getCountPositions('8','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Jixie" />&nbsp;人
									</a></td>
								</tr>
								<tr>
									<td>技术人员：</td>
									<td><a href="#"
										onclick="getCountPositions('9','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Jishu" />&nbsp;人
									</a></td>

									<td>见证员：</td>
									<td><a href="#"
										onclick="getCountPositions('10','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Jianzheng" />&nbsp;人
									</a></td>
								</tr>
								<tr>
									<td>劳务员：</td>
									<td><a href="#"
										onclick="getCountPositions('11','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Laowu" />&nbsp;人
									</a></td>

									<td>取样员：</td>
									<td><a href="#"
										onclick="getCountPositions('12','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Quyang" />&nbsp;人
									</a></td>
								</tr>
								<tr>
									<td>施工现场技术负责人：</td>
									<td><a href="#"
										onclick="getCountPositions('13','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Fuze" />&nbsp;人
									</a></td>

									<td>施工员：</td>
									<td><a href="#"
										onclick="getCountPositions('14','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Shigong" />&nbsp;人
									</a></td>
								</tr>
								<tr>
									<td>质量员：</td>
									<td><a href="#"
										onclick="getCountPositions('15','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Zhiliang" />&nbsp;人
									</a></td>

									<td>资料员：</td>
									<td><a href="#"
										onclick="getCountPositions('16','<s:property value="corpName"/>')">共&nbsp;<s:property
												value="Ziliao" />&nbsp;人
									</a></td>
								</tr>
								<tr>
									<td>重复技术工人：</td>
									<td><a href="#"
										onclick="getSkillworker('<s:property value="corpName" />')">查看
									</a></td>

									<td>重复职称人员：</td>
									<td><a href="#"
										onclick="getTitleperson('<s:property value="corpName" />')">查看
									</a></td>
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
					<th>岗位名称</th>
					<th>证书号码</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="sex" /></td>
						<td><s:property value="cardId" /></td>
						<td><s:property value="duty" /></td>
						<td><s:property value="FCertNumber" /></td>
					</tr>
				</s:iterator>

			</table>
		</div>
	</form>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>