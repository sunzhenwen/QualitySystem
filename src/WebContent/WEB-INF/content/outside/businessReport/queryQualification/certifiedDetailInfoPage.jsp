<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业所拥有的资质</title>
<script type="text/javascript">
	//查询
	function queryQualification()
	{
		document.form1.action="<%=basepath %>/queryQualificationAction_queryQualificationPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryQualificationAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="ry_wrapp">
		<div class="index_top">
			<img src="<%=basepath %>/img/zhindex_name.png" />
		</div>
		<div class="ry_content">
			<form id="form1" name="form1" method="post" action="">
				<div class="ry_main" cellpadding="0" cellspacing="0">
					<h2>企业所拥有资质搜索</h2>
					<table class="ry_left left">
						<tr>
							<td>资质资格名称：</td>
							<td><select name="condition.CertTypeNum">
									<option value="">请选择</option>
									<s:iterator value="CertTypeNums">
										<option value="<s:property value="code"/>"
											<s:if test='condition.CertTypeNum==code'>selected</s:if>><s:property
												value="name" /></option>
									</s:iterator>
							</select></td>
						</tr>
						<tr>
							<td>资质资格等级：</td>
							<td><select name="condition.TitleLevelNum">
									<option value="">请选择</option>
									<s:iterator value="TitleLevelNums">
										<option value="<s:property value="code"/>"
											<s:if test='condition.TitleLevelNum==code'>selected</s:if>><s:property
												value="name" /></option>
									</s:iterator>
							</select></td>
						</tr>
					</table>
					<table class="ry_right left">
						<tr>
							<td><input type="image" src="<%=basepath %>/img/ry_look.png"
								onclick="queryQualification()" /></td>
							<td><input type="image"
								src="<%=basepath %>/img/ry_return.png" onclick="goBack()" /></td>
						</tr>
					</table>
				</div>
			</form>
			<div class="ry_liebiao">
				<p class="f16 pd10 fb">
					企业所拥有的资质列表<img src="<%=basepath %>/img/ry_lie.png" />
				</p>
				<table class="" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<th>序号</th>
							<th>企业名称</th>
							<th>资质名称</th>
							<th>资质等级</th>
							<th>资质取得方式</th>
							<th>专业类别</th>
							<th>资质状态</th>
							<th>详细</th>
						</tr>
						<s:iterator status="i" value="currentPage.data">
							<tr>
								<td><s:property value="#i.count" /></td>
								<td><s:property value="CorpName" /></td>
								<td><s:property value="CertTypeName" /></td>
								<td><s:property value="TitleLevelName" /></td>
								<td><s:property value="AddTypeName" /></td>
								<td><s:property value="TradeBoundName" /></td>
								<td><s:property value="CertTradeStatusName" /></td>
								<td><a
									href="queryQualificationAction_queryQualification.action?CertDetailId=<s:property value="CertDetailId"/>">
										<span>详细</span>
								</a></td>

							</tr>
						</s:iterator>

					</tbody>
				</table>
				<%@include file="/WEB-INF/content/inc/page.jsp"%>

			</div>
		</div>
		<%@include file="/WEB-INF/content/outside/footer.jsp"%>
	</div>
</body>
</html>