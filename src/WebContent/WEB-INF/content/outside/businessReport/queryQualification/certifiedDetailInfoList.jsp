<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业资质详细信息</title>
<script type="text/javascript">
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/queryQualificationAction_queryQualificationPage.action";
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
						<h2>公司资质详细信息</h2>
						<table class="" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<th>企业名称：</th>
									<td><s:property value="qualification.corpName" /> <input
										type="hidden" name="qualification.corpId"
										value="<s:property value="qualification.personId"/>" /></td>
									<th>资质资格类型：</th>
									<td><s:property value="qualification.CertTypeName" /></td>
								<tr>
									<th>证书编号：</th>
									<td><s:property value="qualification.CertId" /></td>
									<th>资质资格序列：</th>
									<td><s:property value="qualification.TradeTypeName" /></td>
								</tr>
								<tr>
									<th>专业类别：</th>
									<td><s:property value="qualification.TradeBoundName" /></td>
									<th>资质资格等级：</th>
									<td><s:property value="qualification.TitleLevelLevel" />
									</td>
								</tr>

								<tr>
									<th>资质资格取得方式：</th>
									<td><s:property value="qualification.AddTypeName" /></td>
									<th>资质资格状态：</th>
									<td><s:property value="qualification.CertTradeStatusName" /></td>
								</tr>
								
								<tr>
									<th>首次批准资质资格日期：</th>
									<td><s:date name="qualification.NoteDate" format="yyyy-MM-dd" /></td>
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