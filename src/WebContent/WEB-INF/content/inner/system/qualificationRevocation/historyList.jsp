<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业已获资质打回历史</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/revocationHistoryAction_historyList.action";
		document.form1.submit();
	}
	
	//批量审批通过
	function batchApplythrough(){   
		if(hasChecked(form1)==false){
			alert("请选择要审批的记录!");
			return;
		}
		if(confirm("您确定要审批选中的记录吗？")==true){
			document.form1.action="<%=basepath%>/provinceApprovalAction_batchApplythrough.action";
			document.form1.submit();
		}
	}
	
	function getMessage() {
		var mes = document.getElementById("mes").value;
		if(mes != "")
		{
			alert(mes);
		}
	}
	
</script>
</head>
<body onload="getMessage()">
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
		<input id="mes" type="hidden" value='<s:property value="message" />' />
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">企业已获资质打回历史</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">
								
								<tr>
									<td>企业名称：</td>
									<td><input type="text" name="historyCondition.corpName"
										value="<s:property value="historyCondition.corpName"/>" /></td>
									<td>组织机构代码号：</td>
									<td><input type="text" name="historyCondition.corpCode"
										value="<s:property value="historyCondition.corpCode"/>" /></td>
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
					<th>打回时间</th>
					<th>打回原因</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><a href="corpInfoAction_detailCorpPage2.action?corpId=<s:property value="corpId"/>" target="_blank"><s:property value="corpName" /></a></td>
						<td><s:property value="certName" /></td>
						<td><s:date name="revocationDate" format="yyyy-MM-dd" /></td>
						<td><s:property value="revocationReason" /></td>
						<td align='center'><a
							href="revocationHistoryAction_revocationHistoryPage.action?revocationId=<s:property value="revocationId"/>">详细</a>
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