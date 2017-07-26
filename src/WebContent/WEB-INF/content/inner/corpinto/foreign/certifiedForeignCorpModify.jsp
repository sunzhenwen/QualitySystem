<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外商企业基本信息修改</title>
<script type="text/javascript">
	
	//修改
	function modify(){
		document.form1.action="<%=basepath%>/certifiedForeignCorpAction_modifyForeignCorp.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/certifiedForeignCorpAction_goBusiness.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<form id="form1" name="form1" method="post"
		action="<%=basepath%>/certifiedForeignCorpAction_modifyCorp.action">
		<div class="qy_wrapp">
			<div class="index_top">
				<img src="<%=basepath%>/img/zhindex_name.png" />

			</div>

			<div class="qyxg_main">

				<h2 class="f16 fb">外商企业基本信息修改</h2>

				<table class="qyxg_mtable qyxgtop " cellpadding="0" cellspacing="0">
					<tr>
						<td>企业名称：</td>
						<td><s:property value="corp.corpName" /> <input
							type="hidden" value="<s:property value="corp.corpId" />"
							name="corp.corpId" /></td>

						<td>组织机构代码：</td>
						<td><s:property value="corp.corpCode" /></td>
					</tr>
					<tr>
						<td>注册所在国家或地区：</td>
						<td><s:property value="corp.nationName" /></td>

						<td>注册投资币种：</td>
						<td><s:property value="corp.principalUnitName" /></td>

					</tr>

					<tr>
						<td>外商投入注册资金（万元）:</td>
						<td><s:property value="corp.regPrin" /></td>

						<td>外商投资所占比例（%）:</td>
						<td><s:property value="corp.percentTage" /></td>

					</tr>

					<tr>
						<td>外商投资者类型:</td>
						<td><s:property value="corp.foreignIvestor" /></td>
						
						<td>外商投资者名称：</td>
						<td><input type="text"
							value="<s:property value="corp.foreignCorpName" />"
							name="corp.foreignCorpName" class="required" />
						</td>

					</tr>
				</table>
				
				<div class="botn">
					<input type="image" src="<%=basepath%>/img/qy_02.png" onclick="modify()"/> <input
						type="image" src="<%=basepath%>/img/qy_01.png" onclick="goBack()" />
				</div>

			</div>
			<%@include file="/WEB-INF/content/outside/footer.jsp"%>
		</div>
	</form>
</body>
</html>