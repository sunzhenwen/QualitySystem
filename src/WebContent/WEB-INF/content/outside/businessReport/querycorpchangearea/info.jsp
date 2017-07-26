<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业归属地变更查询</title>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/queryQualificationInfoAction_goBack.action";
		document.form1.submit();
	}

	//操作提示信息
	function getMessage() {
		var message = document.getElementById("message").value;
		if (message != "") {
			alert(message);
		}
	}
</script>
</head>
<body onload="getMessage()">
	<input type="hidden" id="message"
		value="<s:property value="message" />" />
	<div class="ry_wrapp">
		<div class="index_top">
			<img src="<%=basepath%>/img/zhindex_name.png" />
		</div>
		<div class="ry_content">
			<form id="form1" name="form1" method="post" action="">
				<table class="ry_right right">
					<tr>
						<td><input type="image" src="<%=basepath%>/img/ry_return.png"
							onclick="goBack()" /></td>
					</tr>
				</table>
			</form>
			<div class="ry_liebiao">
				<p class="f16 pd10 fb">
					归属地变更查询<img src="<%=basepath%>/img/ry_lie.png" />
				</p>
				<table class="" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<th>序号</th>
							<th>企业名称</th>
							<th>原归属地名称</th>
							<th>原归属地审批意见</th>
							<th>欲变更归属地名称</th>
							<th>欲变更归属对审批意见</th>
							<th>省局审批意见</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						<s:iterator status="i" value="currentPage.data">
							<tr>
								<td><s:property value="#i.count" /></td>
								<td><s:property value="corpName" /></td>
								<td><s:if test='beforeArea==230100'>哈尔滨</s:if> <s:if
										test='beforeArea==230200'>齐齐哈尔</s:if> <s:if
										test='beforeArea==231000'>牡丹江</s:if> <s:if
										test='beforeArea==230600'>大庆</s:if> <s:if
										test='beforeArea==230700'>伊春</s:if> <s:if
										test='beforeArea==230400'>鹤岗</s:if> <s:if
										test='beforeArea==230800'>佳木斯</s:if> <s:if
										test='beforeArea==231100'>黑河</s:if> <s:if
										test='beforeArea==232700'>大兴安岭地区</s:if> <s:if
										test='beforeArea==400021'>森工</s:if> <s:if
										test='beforeArea==400022'>绥芬河</s:if> <s:if
										test='beforeArea==400023'>抚远</s:if> <s:if
										test='beforeArea==230300'>鸡西</s:if> <s:if
										test='beforeArea==400020'>农垦</s:if> <s:if
										test='beforeArea==230900'>七台河</s:if> <s:if
										test='beforeArea==230500'>双鸭山</s:if> <s:if
										test='beforeArea==231200'>绥化</s:if></td>
								<td><s:property value="beforeOp" /></td>
								<td><s:if test='status==2'>跨省变更</s:if> <s:if
										test='status==1'>
										<s:if test='afterCityArea==230100'>哈尔滨</s:if>
										<s:if test='afterCityArea==230200'>齐齐哈尔</s:if>
										<s:if test='afterCityArea==231000'>牡丹江</s:if>
										<s:if test='afterCityArea==230600'>大庆</s:if>
										<s:if test='afterCityArea==230700'>伊春</s:if>
										<s:if test='afterCityArea==230400'>鹤岗</s:if>
										<s:if test='afterCityArea==230800'>佳木斯</s:if>
										<s:if test='afterCityArea==231100'>黑河</s:if>
										<s:if test='afterCityArea==232700'>大兴安岭地区</s:if>
										<s:if test='afterCityArea==400021'>森工</s:if>
										<s:if test='afterCityArea==400022'>绥芬河</s:if>
										<s:if test='afterCityArea==400023'>抚远</s:if>
										<s:if test='afterCityArea==230300'>鸡西</s:if>
										<s:if test='afterCityArea==400020'>农垦</s:if>
										<s:if test='afterCityArea==230900'>七台河</s:if>
										<s:if test='afterCityArea==230500'>双鸭山</s:if>
										<s:if test='afterCityArea==231200'>绥化</s:if>
									</s:if></td>
								<td><s:property value="afterOp" /></td>
								<td><s:property value="lastOp" /></td>
								<td><s:if test='process==1'>待审批</s:if> <s:if
										test='process==2'>释放地市审批同意</s:if> <s:if test='process==3'>释放地市审批不同意</s:if>
									<s:if test='process==4'>接收地市审批同意</s:if> <s:if test='process==5'>接收地市审批不同意</s:if>
									<s:if test='process==6'>省厅审批同意</s:if> <s:if test='process==7'>省厅审批不同意</s:if>
								</td>
								<td><s:if test="process==1">
										<a
											href="queryCorpChangeAreaAction_deleteChange.action?changeId=<s:property value="changeId"/>">
											<span>删除</span>
										</a>
									</s:if></td>
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