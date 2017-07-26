<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业资质变更申请查询</title>
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
		document.form1.action="<%=basepath %>/titleAction_goBack.action";
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

			<div class="ry_liebiao">
				<p class="f16 pd10 fb">
					企业申请的资质变更列表<img src="<%=basepath %>/img/ry_lie.png" />
				</p>
				<form  id="form1" name="form1" method="post" action="">
				<table class="" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<th>序号</th>
							<th>企业名称</th>
							<th>申请时间</th>
							<th>当前受理的部门</th>
							<th>受理状态</th>
							<th>详细</th>
						</tr>
						<s:iterator status="i" value="currentPage.data">
							<tr>
								<td><s:property value="#i.count" /></td>
								<td><s:property value="CORPNAME" /></td>
								<td><s:property value="CREATE_TIME" /></td>
								<td><s:property value="ACCEPT_DEPARTMENT" /></td>
								<td><s:property value="ACCEPT_STATE" /></td>
								<td>
								<a href="qualityChangeAction_queryCorpQualityChangeDetail.action?qualityChangeId=<s:property value="QUALITY_CHANGE_ID"/>">
									<span>详细</span>
								</a>
								<s:if test="STATE.equals(\"1\") ">
								
								<a href="qualityChangeAction_deleteCorpQualityChangeDetail.action?qualityChangeId=<s:property value="QUALITY_CHANGE_ID"/>">
									<span>删除</span>
								</a>
								
								 </s:if>
								</td>

							</tr>
						</s:iterator>

					</tbody>
				</table>
				</form>
				<div class="sp_bton"> 
		        	    <a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
		         </div>
				<%@include file="/WEB-INF/content/inc/page.jsp"%>

			</div>
		</div>
		<%@include file="/WEB-INF/content/outside/footer.jsp"%>
	</div>
</body>
</html>