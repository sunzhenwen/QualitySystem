<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外资企业信息修改</title>
<script type="text/javascript">
	
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/foreignCorpAction_queryOutLoginPage.action";
		document.form1.submit();
	}
</script>

</head>
<body>
	<form id="form1" name="form1" method="post"
		action="<%=basepath%>/foreignCorpAction_modifyforeginCorp.action">
		<div class="qy_wrapp">
			<div class="index_top">
				<img src="<%=basepath%>/img/zhindex_name.png" />
			</div>
			<div class="qy_main">

				<h2 class="f16 fb">新外商企业基本信息修改表</h2>
				<table class="qy_mtable p_left60 left" cellpadding="0" cellspacing="0">
					<tr>
                	<td>企业名称：</td>
                	<td>
                	<input type="text" value="<s:property value="foreignCorp.corpName" />" name="foreignCorp.corpName" class="required" />
                	<input type="hidden" value="<s:property value="foreignCorp.corpId" />" name="foreignCorp.corpId" />
                	</td>
                </tr>
					<tr>
						<td>组织机构代码：</td>
						<td><input type="text" name="foreignCorp.corpCode"
							value="<s:property value="foreignCorp.corpCode" />"
							class="required" /></td>
					</tr>
					<tr>
						<td>外商投资者名称：</td>
						<td><input type="text" name="foreignCorp.foreignCorpName"
							value="<s:property value="foreignCorp.foreignCorpName" />"
							class="required" /></td>
					</tr>
					<tr>
						<td>国籍或地区：</td>
						<td><select id="" name="foreignCorp.nationNume"
							class="required">
								<option value="">请选择</option>
								<s:iterator value="nations">
									<option value="<s:property value = "code" />"
										<s:if test='foreignCorp.nationNume==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>
				</table>
				<table class="qy_mtable left" cellpadding="0" cellspacing="0">
					<tr>
						<td>注册资本币种：</td>
						<td><select id="" name="foreignCorp.principalUnitNum"
							class="required">
								<s:iterator value="principalUnit">
									<option value="<s:property value="code"/>"
										<s:if test='corp.principalUnitNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>

					<tr>
						<td>外商投入注册资金（万元）：</td>
						<td><input type="text" name="foreignCorp.regPrin"
							value="<s:property value="foreignCorp.regPrin" />"
							class="required" /></td>
					</tr>

					<tr>
						<td>外商投资所占比例（%）：</td>
						<td><input type="text" name="foreignCorp.percentTage"
							value="<s:property value="foreignCorp.percentTage" />"
							class="required" /></td>
					</tr>

					<tr>
						<td>外商投资者类型：</td>
						<td><select id="" name="foreignCorp.foreignIvestor"
							class="required">
								<s:iterator value="ivestors">
									<option value="<s:property value="code"/>"
										<s:if test='foreignCorp.foreignIvestor == code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>
				</table>
				<div class="wsbotn">
					<input type="image" src="<%=basepath%>/img/qy_02.png" /> <input
						type="image" src="<%=basepath%>/img/qy_01.png" onclick="goBack()" />
				</div>
			</div>
			<%@include file="/WEB-INF/content/outside/footer.jsp"%>
		</div>
	</form>
</body>
</html>