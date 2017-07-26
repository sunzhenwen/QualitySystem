<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>大厅资质受理历史查询</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/queryFloorApprovalAction_queryPage.action";
		document.form1.submit();
	}

	//操作提示信息
	function getMessage() {
		var message = document.getElementById("message").value;
		if (message != "") {
			alert(message);
		}
	}
	
	function jump(){
		window.open("print/printpage.jsp")
	}
</script>
</head>
<body onload="querySpecialtyType();getMessage()">
	<input type="hidden" id="message"
		value="<s:property value="message" />" />
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">大厅资质受理历史查询</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
								<a href="#" onclick="jump()"><span class="lbchx">打印</span></a>
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
					<th>资质名称</th>
					<th>企业组织机构代码证</th>
					<th>资质名称</th>
					<th>处理状态</th>
					<th>处理日期</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="corpName" /></td>
						<td><s:property value="certName" /></td>
						<td><s:property value="corpCode" /></td>
						<td><s:property value="certMess" /></td>
						<td><s:property value="type" /></td>
						<td><s:date name="approvalDate" format="yyyy-MM-dd" /></td>
						<td align='center'><a
							href="queryFloorApprovalAction_queryInfo.action?id=<s:property value="newQualId"/>">查看</a>
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