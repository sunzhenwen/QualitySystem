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
			document.form1.action="<%=basepath%>/floorApprovalAction_approvalSuccess.action?";
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
	
	//当天日期
	function currentTime() {
		
		var time = new Date( ); //获得当前时间
		//获得年、月、日
		var year = time.getFullYear( );
		var month = time.getMonth( )+1;
		var date = time.getDate( ); 
		//给页面中年、月、日赋值
		$(".year").val(year);
		$(".month").val(month);
		$(".date").val(date);
		
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
<body onload="currentTime()" >
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">大厅资质受理成功填写界面</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<div>
						<p>受理行政许通知书</p>
						<div style="text-align: right;">
							<input type="text" size="20" name="floor.mes1" />许受字〔<input
								type="text" size="10" name="floor.mes2" />〕第<input type="text"
								size="10" name="floor.mes3" />号
						</div>
						<div>
							<s:if test="null != corpName">
								<input type="text" size="25" name="floor.mes4" value='<s:property value="corpName" />' />：
							</s:if>
							<s:else>
								<input type="text" size="25" name="floor.mes4" value='<s:property value="NewQualification.corpName" />' />：
							</s:else>
							
						</div>
						<div style="text-indent: 2em;">
							你单位于<input type="text" size="10" name="floor.mes5" class="year" />年<input
								type="text" size="10" name="floor.mes6" class="month" />月<input type="text"
								size="10" name="floor.mes7" class="date" />日提出的
								<s:if test="null!=newQualifications">
									<s:iterator value="newQualifications">
										<input type="text" size="33" value="<s:property value="certName" />" />
									</s:iterator>
								</s:if>
								<s:else>
									<input type="text" size="22" name="floor.mes8" value="<s:property value="NewQualification.certName" />"/>
								</s:else>
								行政许可申请收愁。经审查，符合法定受理条件，本机关决定于<input
								type="text" size="10" name="floor.mes9" class="year" />年<input type="text"
								size="10" name="floor.mes10" class="month" />月<input type="text" size="10"
								name="floor.mes11" class="date" />日受理。
						</div>

						<div style="text-align: right; width: 80%; margin-top: 100px;">（行政机关许可专用印章）</div>
						<div style="text-align: right; width: 80%;">
							<input type="text" size="10" name="floor.mes12" class="year" />年<input
								type="text" size="10" name="floor.mes13" class="month"/>月<input type="text"
								size="10" name="floor.mes14" class="date" />日
						</div>
					<tr>
					<tr style="height: 60px; border: 0">
						<td>&nbsp;&nbsp;&nbsp;&nbsp;业务受理意见：<br /><br />
						
						<textarea id="appId" name="floor.approvalOpinion"></textarea>
							<s:if test="newQualifications!=null">
								<s:iterator value="newQualifications" status="i" >
									<input type="hidden"
									name="floors[<s:property value="#i.count-1" />].corpName"
									value="<s:property value="corpName"/>" /> 
									<input
									type="hidden" name="floors[<s:property value="#i.count-1" />].newQualId"
									value="<s:property value="newQualId"/>" /> 
									<input
									type="hidden" name="floors[<s:property value="#i.count-1" />].corpCode"
									value="<s:property value="corpCode"/>" /> 
									<input
									type="hidden" name="floors[<s:property value="#i.count-1" />].certMess"
									value="<s:property value="cretSequenceName"/><s:property value="specialtyTypeName"/><s:property value="cretLevelName"/>" />
									<input type="hidden" name="acceptDate"
									value="<s:property value="acceptDate"/>" />
									<input
									type="hidden" name="floors[<s:property value="#i.count-1" />].certName"
									value="<s:property value="certName"/>" />
									<input
									type="hidden" name="floors[<s:property value="#i.count-1" />].mes8"
									value="<s:property value="certName"/>" />
								</s:iterator>
							</s:if><s:else>
								<input type="hidden"
								name="floor.corpName"
								value="<s:property value="newQualification.corpName"/>" /> 
								<input
								type="hidden" name="floor.newQualId"
								value="<s:property value="newQualification.newQualId"/>" /> 
								<input
								type="hidden" name="floor.corpCode"
								value="<s:property value="newQualification.corpCode"/>" /> 
								<input
								type="hidden" name="floor.certMess"
								value="<s:property value="newQualification.cretSequenceName"/><s:property value="newQualification.specialtyTypeName"/><s:property value="newQualification.cretLevelName"/>" />
								<input type="hidden" name="acceptDate"
								value="<s:property value="acceptDate"/>" />
								<input
								type="hidden" name="floor.certName"
								value="<s:property value="newQualification.certName"/>" />
							</s:else>
							</td>
					</tr>

				</table>
				<div class="sp_bton">
					<a href="#"><span class="sp_first" onclick="applythrough()">受理通过</span></a>
					<a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>