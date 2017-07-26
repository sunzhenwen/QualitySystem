<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业基本信息</title>
<script type="text/javascript">

	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/corpInfoAction_queryCorpInfo.action?type=1";
		document.form1.submit();
	}
	
	//注册建造师
	function getCountConstructor(corpName)
	{
		var openUrl = "<%=basepath %>/queryConstructorAction_getConstructor.action?condition.corpName="+corpName;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)   
	}
	
	//技术工人
	function getSkilledworker(corpId)
	{
		window.open('<%=basepath %>/querySkilledworkerAction_getSkilledworker.action?condition.corpId='+corpId);  
	}
	
	//职称人员
	function getTitle(corpId)
	{
		window.open('<%=basepath %>/queryTitleAction_getTitle.action?condition.corpId='+corpId)   
	}
	
	//岗位人员
	function getCountPositions(corpName)
	{
		var url = "<%=basepath %>/queryPositionsAction_getPositions.action?condition.corpName="+corpName;
		url = encodeURI(url);
	    url = encodeURI(url);
		window.open(url)   
	}
	
	//企业拥有资质
	function getCertification(corpId)
	{
		window.open('<%=basepath %>/queryQualificationAction_detailCretPage.action?corpId='+corpId)   
	}
	
	//企业工程业绩
	function getPerformance(corpId)
	{
		window.open('<%=basepath %>/queryPerformanceAction_queryPage.action?condition.corpId='+corpId)   
	}
	
	//企业申请资质信息
	function getCorpApply(corpCode)
	{
		window.open('<%=basepath %>/queryCorpApplyAction_queryPage.action?corpCode='+corpCode)   
	}
	
</script>
</head>
<body onload="getMessage()">
	<div class="qy_wrapp">
		<input type="hidden" id="message"
			value="<s:property value="message" />" />
		<div class="qy_main" style="width: 100%; background: #FFF; border: 0;">

			<h2 class="f16 fb" style="background: #80aced;">企业信息查看</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">


					<tr>
						<td>企业名称：</td>
						<td><s:property value="corpInfo.corpName" /> 
						<input type="hidden" name="corpInfo.corpId" value="<s:property value="corpInfo.corpId"/>" />
						<input type="hidden" name="corpInfo.corpName" value="<s:property value="corpInfo.corpName"/>" /></td>
						<td>组织机构代码或统一社会信用代码：</td>
						<td><s:property value="corpInfo.corpCode" /></td>
					</tr>

					<tr>
						<td>工商营业执照注册号：</td>
						<td><s:property value="corpInfo.licenseNum" /></td>

						<td>企业营业地址：</td>
						<td><s:property value="corpInfo.address" /></td>
					</tr>

					<tr>
						<td>注册所在省（自治区、直辖市）：</td>
						<td><select id="provinceId" name="corpInfo.provinceNum"
							onchange="queryCity()" class="required">
								<s:iterator value="provinces">
									<option value="<s:property value="code"/>"
										<s:if test='corpInfo.provinceNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>

						<td>注册所在地（市、州、盟）：</td>
						<td><select id="cityId" name="corpInfo.cityNum"
							onchange="queryArea()" class="required">
								<s:iterator value="citys">
									<option value="<s:property value="code"/>"
										<s:if test='corpInfo.cityNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>

					</tr>

					<tr>
						<td>注册所在县（区、市、旗）：</td>
						<td><select id="areaId" name="corpInfo.countyNum"
							class="required">
								<option value="">请选择</option>
								<s:iterator value="areas">
									<option value="<s:property value="code"/>"
										<s:if test='corpInfo.countyNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>

						<td>企业营业地址邮政编码：</td>
						<td><s:property value="corpInfo.postalCode" /></td>

					</tr>

					<tr>
						<td>法定代表人姓名：</td>
						<td><s:property value="corpInfo.legalMan" /></td>

						<td>法定代表人证件类型：</td>
						<td><select id="" name="corpInfo.idCardTypeNum">
								<s:iterator value="idCardType">
									<option value="<s:property value="code"/>"
										<s:if test='corpInfo.idCardTypeNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>

					<tr>
						<td>法定代表人证件号码：</td>

						<td><s:property value="corpInfo.legalManIdCard" /></td>
						<td>法定代表职务：</td>
						<td><s:property value="corpInfo.legalManDuty" /></td>

					</tr>

					<tr>
						<td>法定代表职称：</td>
						<td><s:property value="corpInfo.legaManProtitle" /></td>

						<td>企业登记注册类型：</td>
						<td><select id="" name="corpInfo.economicNum"
							class="required">
								<option value="">请选择</option>
								<s:iterator value="economicNum">
									<option value="<s:property value="code"/>"
										<s:if test='corpInfo.economicNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>

					<tr>
						<td>注册资本（万元）：</td>
						<td><s:property value="corpInfo.regPrin" /></td>

						<td>实收资本（万元）：</td>
						<td><s:property value="corpInfo.factRegPrin" /></td>

					</tr>

					<tr>
						<td>注册资本币种：</td>
						<td><select id="" name="corpInfo.principalUnitNum"
							class="required">
								<option value="">请选择</option>
								<s:iterator value="principalUnit">
									<option value="<s:property value="code"/>"
										<s:if test='corpInfo.principalUnitNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>

						<td>成立日期：</td>
						<td><s:date name="corpInfo.corpBirthDate" format="yyyy-MM-dd" /></td>

					</tr>

					<tr>
						<td>办公电话：</td>
						<td><s:property value="corpInfo.officePhone" /></td>

						<td>传真号码：</td>
						<td><s:property value="corpInfo.fax" /></td>
					</tr>

					<tr>
						<td>联系人姓名：</td>
						<td><s:property value="corpInfo.linkMan" /></td>

						<td>联系人办公电话：</td>
						<td><s:property value="corpInfo.linkTel" /></td>
					</tr>

					<tr>
						<td>联系邮箱：</td>
						<td><s:property value="corpInfo.email" /></td>

						<td>联系人手机号码：</td>
						<td><s:property value="corpInfo.linkPhone" /></td>
					</tr>



					<tr>
						<td>企业网址：</td>
						<td><s:property value="corpInfo.url" /></td>

						<td>备注：</td>
						<td><s:property value="corpInfo.description" /></td>

					</tr>

					<tr>
						<td>净资产(万元)：</td>
						<td><s:property value="corpInfo.assets" /></td>

						<td>机械设备：</td>
						<td><s:property value="corpInfo.machinery" /></td>

					</tr>
					
					 <tr>
                    <td>注册建造师：</td>
               		<td>
               			<a href="#" onclick="getCountConstructor('<s:property value="corpInfo.corpName"/>')">点击查看</a>
               		</td>
                    <td>岗位人员：</td>
                    <td>
                    	<a href="#" onclick="getCountPositions('<s:property value="corpInfo.corpName"/>')">点击查看</a>
                    </td>
                </tr>
                
                <tr>
                    <td>技术工人：</td>
               		<td>
               			<a href="#" onclick="getSkilledworker('<s:property value="corpInfo.corpId"/>')">点击查看</a>
               		</td>
                    <td>职称人员：</td>
                    <td>
                    	<a href="#" onclick="getTitle('<s:property value="corpInfo.corpId"/>')">点击查看</a>
                    </td>
                </tr>
                 <tr style="height:60px; border:0">
                    <td>企业工程业绩：</td>
               		<td>
					<a href="#" onclick="getPerformance('<s:property value="corpInfo.corpId" /> ')">详细查看</a>
					</td>
					<td>企业拥有资质：</td>
                	<td>
                	<a href="#" onclick="getCertification('<s:property value="corpInfo.corpId" /> ')">详细查看</a>
                	</td>
                </tr>
                <tr style="height:60px; border:0">
                	<td>企业换证资质信息：</td>
                	<td>
                	<a href="#" onclick="getCorpApply('<s:property value="corpInfo.corpCode"/>')">详细查看</a>
                	</td>
                </tr>
					
				</table>
					<div class="nw_bton">
						<input type="image" src="<%=basepath%>/img/fanhui_03.png"
							onclick="goBack()" />
					</div>
			</form>
		</div>
	</div>

</body>
</html>