<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业申请资质状态查询</title>
<script type="text/javascript">
	//查询
	function queryQualification()
	{
		document.form1.action="<%=basepath%>/queryQualificationInfoAction_queryQualificationInfoPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/queryQualificationInfoAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="ry_wrapp">
		<div class="index_top">
			<img src="<%=basepath%>/img/zhindex_name.png" />
		</div>
		<div class="ry_content">
			<form id="form1" name="form1" method="post" action="">
				<div class="ry_main" cellpadding="0" cellspacing="0">
					<h2>企业所申请资质审批查询搜索</h2>
					<table class="ry_left left">
						<tr>
							<td>资质等级：</td>
							<td><select name="condition.cretLevel">
									<option value="">请选择</option>
									<s:iterator value="CretLevelNums">
										<option value="<s:property value="code"/>"
											<s:if test='condition.cretLevel==code'>selected</s:if>><s:property
												value="name" /></option>
									</s:iterator>
							</select></td>
						</tr>
					</table>
					<table class="ry_right left">
						<tr>
							<td><input type="image" src="<%=basepath%>/img/ry_look.png"
								onclick="queryQualification()" /></td>
							<td><input type="image"
								src="<%=basepath%>/img/ry_return.png" onclick="goBack()" /></td>
						</tr>
					</table>
				</div>
			</form>
			<div class="ry_liebiao">
				<p class="f16 pd10 fb">
					企业所上报审批的资质信息列表<img src="<%=basepath%>/img/ry_lie.png" />
				</p>
				<table class="" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<th>序号</th>
							<th>企业名称</th>
							<th>资质等级</th>
							<th>专业类别</th>
							<th>资质名称</th>
							<th>申请类型</th>
							<th>审批状态</th>
							<th>申请日期</th>
							<th>操作</th>
						</tr>
						<s:iterator status="i" value="currentPage.data">
							<tr>
								<td><s:property value="#i.count" /></td>
								<td><s:property value="CorpName" /></td>
								<td><s:property value="cretLevelName" /></td>
								<td><s:property value="specialtyTypeName" /></td>
								<td><s:property value="certName" /></td>
								<td><s:property value="addTypeName" /></td>
								<td><s:property value="qualifType" /></td>
								<td><s:date name="creatDate" format="yyyy-MM-dd" /></td>
								<td><a
										href="queryQualificationInfoAction_queryQualification.action?NewQualId=<s:property value="NewQualId"/>">
										<span>详细</span>
								    </a>
									&nbsp;&nbsp; 
									<s:if test="(floorDate == null)&&(oneAppDate == null)&&(ultimateDate == null)">
										<a
											href="queryQualificationInfoAction_deleteQualification.action?NewQualId=<s:property value="NewQualId"/>">
											<span>删除</span>
										</a>
									</s:if>
								</td>
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