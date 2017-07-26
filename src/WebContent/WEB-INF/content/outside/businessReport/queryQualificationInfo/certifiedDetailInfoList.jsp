<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业资质审批查询详细信息</title>
<script type="text/javascript">
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/queryQualificationInfoAction_queryQualificationInfoPage.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="ry_wrapp">
		<div class="index_top">
			<img src="<%=basepath%>/img/zhindex_name.png" />

		</div>
		<form id="form1" name="form1" method="post" action="">
			<div class="ry_content">

				<div class="ry_lbxx">
					<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
						<h2>企业资质审批查询详细信息</h2>
						<table class="" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<th>企业名称：</th>
									<td><s:property value="qualification.corpName" /> <input
										type="hidden" name="qualification.corpId"
										value="<s:property value="qualification.personId"/>" /></td>
									<th>资质审批状态：</th>
									<td><s:property value="qualification.qualifType" /></td>
								<tr>
									<th>资质种类：</th>
									<td><s:property value="qualification.cretLevelName" /></td>
									<th>资质等级：</th>
									<td><s:property value="qualification.cretTypeName" /></td>
								</tr>
								<tr>
									<th>服务事项名称：</th>
									<td><s:property value="qualification.cretName" /></td>
									<th>资质序列名称：</th>
									<td><s:property value="qualification.CretSequenceName" /></td>
								</tr>
								<tr>
									<th>资质专业类别名称：</th>
									<td><s:property value="qualification.SpecialtyTypeName" /></td>
									<th>资质级别名称：</th>
									<td><s:property value="qualification.CretGradeName" /></td>
								</tr>
								<tr>
									<th>审批部门名称：</th>
									<td><s:property value="qualification.ApprovalDeptName" /></td>
									<th>申请日期：</th>
									<td><s:date name="qualification.creatDate" format="yyyy-MM-dd" />
									</td>
								</tr>
								<tr>
									<th>专业厅局审批部门名称：</th>
									<td><s:property value="qualification.TwoApprovalDeptName" /></td>
									<th>专业厅局审批意见：</th>
									<td><s:property value="qualification.OneUltimateOpinion" />
									</td>
								</tr>
								<tr>
									<th>专业厅局审批人员：</th>
									<td><s:property value="qualification.TwoApprovalStaff" />
									</td>
									<th>专业厅局审批日期：</th>
									<td><s:date name="qualification.oneAppDate" format="yyyy-MM-dd" /></td>
								</tr>
								<tr>
									<th>资质审批意见：</th>
									<td><s:property value="qualification.UltimateOpinion" /></td>
									<th>资质审批人员：</th>
									<td><s:property value="qualification.ApprovalStaff" />
									</td>
								</tr>
								<tr>
									<th>行政受理中心受理时间：</th>
									<td><s:date name="qualification.floorDate" format="yyyy-MM-dd" /></td>
									<th>行政受理中心受理意见：</th>
									<td><s:property value="qualification.floorOp" />
									</td>
								</tr>
						</table>

						<div class="botn">
							<input type="image" src="<%=basepath%>/img/qy_01.png"
								onclick="goBack()" />
						</div>

					</div>
					<%@include file="/WEB-INF/content/outside/footer.jsp"%>
				</div>
		</form>
</body>
</html>