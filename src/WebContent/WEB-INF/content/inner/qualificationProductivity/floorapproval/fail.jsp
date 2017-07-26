<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>大厅资质受理通过页面</title>
<script type="text/javascript">
	
	//审批通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath%>/floorApprovalAction_approvalFailed.action";
			document.form1.submit();
		}else
		{
			alert("请输入受理意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/floorApprovalAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>
<style type="text/css">
body {
	color: #000;
	font-size: 14px;
}

input {
	border-bottom: 1px solid #000;
	border-top: 1px solid #fff;
	border-right: 1px solid #fff;
	border-left: 1px solid #fff;
}

P {
	text-align: center;
	font-size: 24px;
	font-weight: bold;
}

div {
	line-height: 36px;
	text-align: left;
	width: 80%;
	margin: auto;
}
</style>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">大厅资质受理成功填写界面</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<p>不予受理行政许可申请通知书</p>
					<div style="text-align: right;">
						<input type="text" size="20" name="floor.mes1" />许不字〔<input
							type="text" size="10" name="floor.mes2" />〕第<input type="text"
							size="10" name="floor.mes3" />号
					</div>
					<div>
						<input type="text" size="25" name="floor.mes4" />：
					</div>
					<div style="text-indent: 2em;">
						于<input type="text" size="10" name="floor.mes5" />年<input
							type="text" size="10" name="floor.mes6" />月<input type="text"
							size="10" name="floor.mes7" />日提出的<input type="text" size="22"
							name="floor.mes8" />行政许可申请收愁。经审查，不符合法定受理条件，本机关决定不予受理。
					</div>
					<div style="text-indent: 2em;">
						如不服本决定，可以自收到本决定书之日起六十日内向<input type="text" size="25"
							name="floor.mes9" />申请行政复议，或者三个月内向 <input type="text" size="25"
							name="floor.mes10" />人民法院提起行政诉讼。
					</div>
					<div style="text-align: right; width: 80%; margin-top: 100px;">（行政机关许可专用印章）</div>
					<div style="text-align: right; width: 80%;">
						<input type="text" size="10" name="floor.mes11" />年<input
							type="text" size="10" name="floor.mes12" />月<input type="text"
							size="10" name="floor.mes13" />日
					</div>
					<div></div>
					<div></div>

					<tr>
					<tr style="height: 60px; border: 0">
						<td>业务受理意见：</td>
						<td colspan="3"><textarea id="appId"
								name="floor.approvalOpinion"></textarea><input type="hidden"
							name="floor.corpName"
							value="<s:property value="newQualification.corpName"/>" /> <input
							type="hidden" name="floor.newQualId"
							value="<s:property value="newQualification.newQualId"/>" /> <input
							type="hidden" name="floor.corpCode"
							value="<s:property value="newQualification.corpCode"/>" /> <input
							type="hidden" name="floor.certMess"
							value="<s:property value="newQualification.cretSequenceName"/><s:property value="newQualification.specialtyTypeName"/><s:property value="newQualification.cretLevelName"/>" />

							<input type="hidden" name="acceptDate"
							value="<s:property value="acceptDate"/>" /></td>
					</tr>





				</table>
				<div class="sp_bton">
					<a href="#"><span class="sp_first" onclick="applythrough()">不予受理</span></a>
					<a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>