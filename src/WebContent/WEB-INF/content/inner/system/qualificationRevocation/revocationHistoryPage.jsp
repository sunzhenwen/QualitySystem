<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业已获资质打回历史详细</title>
<script type="text/javascript">
  
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
		window.open(url);
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
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">企业已获资质打回历史详细</h2>
         <form id="form1" name="form1" method="post">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
               <tr>
						<td>企业名称：</td>
						<td><s:property value="qualificationRevocation.corpName" /> 
						<input type="hidden" name="qualificationRevocation.corpId" value="<s:property value="qualificationRevocation.corpId"/>" />
						<input type="hidden" name="qualificationRevocation.corpName" value="<s:property value="qualificationRevocation.corpName"/>" />
						<input type="hidden" name="qualificationRevocation.relationid" value="<s:property value="qualificationRevocation.relationid"/>" />
						<input type="hidden" name="qualificationRevocation.certId" value="<s:property value="qualificationRevocation.certId"/>" />
						<input type="hidden" name="qualificationRevocation.qualifType" value="<s:property value="qualificationRevocation.qualifType"/>" />
						<input type="hidden" name="qualificationRevocation.cretGrade" value="<s:property value="qualificationRevocation.cretGrade"/>" />
						<input type="hidden" name="qualificationRevocation.revocationId" value="<s:property value="qualificationRevocation.revocationId"/>" /></td>
						<td>组织机构代码或统一社会信用代码：</td>
						<td><s:property value="qualificationRevocation.corpCode" />
						</td>
					</tr>

					<tr>
						<td>工商营业执照注册号：</td>
						<td><s:property value="qualificationRevocation.licenseNum" />
							<input type="hidden" name="qualificationRevocation.licenseNum" value="<s:property value="qualificationRevocation.licenseNum"/>" />
						</td>

						<td>企业营业地址：</td>
						<td><s:property value="qualificationRevocation.address" />
							<input type="hidden" name="qualificationRevocation.address" value="<s:property value="qualificationRevocation.address"/>" />
						</td>
					</tr>

					<tr>
						<td>注册所在省（自治区、直辖市）：</td>
						<td>
							<s:property value="qualificationRevocation.provinceName" />
							<input type="hidden" name="qualificationRevocation.provinceName" value="<s:property value="qualificationRevocation.provinceName"/>" />
							<input type="hidden" name="qualificationRevocation.provinceNum" value="<s:property value="qualificationRevocation.provinceNum"/>" />
						</td>
						<td>注册所在地（市、州、盟）：</td>
						<td>
							<s:property value="qualificationRevocation.cityName" />
							<input type="hidden" name="qualificationRevocation.cityName" value="<s:property value="qualificationRevocation.cityName"/>" />
							<input type="hidden" name="qualificationRevocation.cityNum" value="<s:property value="qualificationRevocation.cityNum"/>" />
						</td>

					</tr>
					<tr>
						<td>注册所在县（区、市、旗）：</td>
						<td>
							<s:property value="qualificationRevocation.adminareaName" />
							<input type="hidden" name="qualificationRevocation.adminareaName" value="<s:property value="qualificationRevocation.adminareaName"/>" />
							<input type="hidden" name="qualificationRevocation.countyNum" value="<s:property value="qualificationRevocation.countyNum"/>" />
						</td>

						<td>企业营业地址邮政编码：</td>
						<td><s:property value="qualificationRevocation.postalcode" />
							<input type="hidden" name="qualificationRevocation.postalcode" value="<s:property value="qualificationRevocation.postalcode"/>" />
						</td>
					</tr>
					<tr>
						<td>法定代表人姓名：</td>
						<td><s:property value="qualificationRevocation.legalMan" />
							<input type="hidden" name="qualificationRevocation.legalMan" value="<s:property value="qualificationRevocation.legalMan"/>" />
						</td>

						<td>法定代表人证件类型：</td>
						<td>
							<s:property value="qualificationRevocation.papertypeName" />
							<input type="hidden" name="qualificationRevocation.papertypeName" value="<s:property value="qualificationRevocation.papertypeName"/>" />
							<input type="hidden" name="qualificationRevocation.idcardtypeNum" value="<s:property value="qualificationRevocation.idcardtypeNum"/>" />
						</td>
					</tr>

					<tr>
						<td>法定代表人证件号码：</td>

						<td><s:property value="qualificationRevocation.legalmanidCard" />
							<input type="hidden" name="qualificationRevocation.legalmanidCard" value="<s:property value="qualificationRevocation.legalmanidCard"/>" />
						</td>
						<td>法定代表职务：</td>
						<td><s:property value="qualificationRevocation.legalmanDuty" />
							<input type="hidden" name="qualificationRevocation.legalmanDuty" value="<s:property value="qualificationRevocation.legalmanDuty"/>" />
						</td>

					</tr>

					<tr>
						<td>法定代表职称：</td>
						<td><s:property value="qualificationRevocation.legamanProtitle" />
							<input type="hidden" name="qualificationRevocation.legamanProtitle" value="<s:property value="qualificationRevocation.legamanProtitle"/>" />
						</td>

						<td>企业登记注册类型：</td>
						<td>
							<s:property value="qualificationRevocation.economicPropertyName" />
							<input type="hidden" name="qualificationRevocation.economicPropertyName" value="<s:property value="qualificationRevocation.economicPropertyName"/>" />
							<input type="hidden" name="qualificationRevocation.economicNum" value="<s:property value="qualificationRevocation.economicNum"/>" />
						</td>
					</tr>

					<tr>
						<td>注册资本（万元）：</td>
						<td><s:property value="qualificationRevocation.regPrin" />
							<input type="hidden" name="qualificationRevocation.regPrin" value="<s:property value="qualificationRevocation.regPrin"/>" />
						</td>

						<td>实收资本（万元）：</td>
						<td><s:property value="qualificationRevocation.factRegPrin" />
							<input type="hidden" name="qualificationRevocation.factRegPrin" value="<s:property value="qualificationRevocation.factRegPrin"/>" />
						</td>

					</tr>

					<tr>
						<td>注册资本币种：</td>
						<td>
							<s:property value="qualificationRevocation.principalUnitName" />
							<input type="hidden" name="qualificationRevocation.principalUnitName" value="<s:property value="qualificationRevocation.principalUnitName"/>" />
							<input type="hidden" name="qualificationRevocation.principalUnitNum" value="<s:property value="qualificationRevocation.principalUnitNum"/>" />
						</td>

						<td>成立日期：</td>
						<td><s:date name="qualificationRevocation.corpBirthDate" format="yyyy-MM-dd" />
							<input type="hidden"
								value="<s:date name="qualificationRevocation.corpBirthDate" format="yyyy-MM-dd" />"
								name="qualificationRevocation.corpBirthDate"
								class="required" />
						</td>

					</tr>

					<tr>
						<td>办公电话：</td>
						<td><s:property value="qualificationRevocation.officePhone" />
							<input type="hidden" name="qualificationRevocation.officePhone" value="<s:property value="qualificationRevocation.officePhone"/>" />
						</td>

						<td>传真号码：</td>
						<td><s:property value="qualificationRevocation.fax" />
							<input type="hidden" name="qualificationRevocation.fax" value="<s:property value="qualificationRevocation.fax"/>" />
						</td>
					</tr>

					<tr>
						<td>联系人姓名：</td>
						<td><s:property value="qualificationRevocation.linkMan" />
							<input type="hidden" name="qualificationRevocation.linkMan" value="<s:property value="qualificationRevocation.linkMan"/>" />
						</td>

						<td>联系人办公电话：</td>
						<td><s:property value="qualificationRevocation.linkTel" />
							<input type="hidden" name="qualificationRevocation.linkTel" value="<s:property value="qualificationRevocation.linkTel"/>" />
						</td>
					</tr>

					<tr>
						<td>联系邮箱：</td>
						<td><s:property value="qualificationRevocation.email" />
							<input type="hidden" name="qualificationRevocation.email" value="<s:property value="qualificationRevocation.email"/>" />
						</td>

						<td>联系人手机号码：</td>
						<td><s:property value="qualificationRevocation.linkPhone" />
							<input type="hidden" name="qualificationRevocation.linkPhone" value="<s:property value="qualificationRevocation.linkPhone"/>" />
						</td>
					</tr>
					<tr>
						<td>企业网址：</td>
						<td><s:property value="qualificationRevocation.url" />
							<input type="hidden" name="qualificationRevocation.url" value="<s:property value="qualificationRevocation.url"/>" />
						</td>

						<td>备注：</td>
						<td><s:property value="qualificationRevocation.description" />
							<input type="hidden" name="qualificationRevocation.description" value="<s:property value="qualificationRevocation.description"/>" />
						</td>

					</tr>

					<tr>
						<td>净资产(万元)：</td>
						<td><s:property value="qualificationRevocation.assets" />
							<input type="hidden" name="qualificationRevocation.assets" value="<s:property value="qualificationRevocation.assets"/>" />
						</td>

						<td>机械设备：</td>
						<td><s:property value="qualificationRevocation.machinery" />
							<input type="hidden" name="qualificationRevocation.machinery" value="<s:property value="qualificationRevocation.machinery"/>" />
						</td>

					</tr>
					<tr>
		               	<td>企业归属地：</td>
		               	<td>
		               	<s:if test="qualificationRevocation.spare1==230100">哈尔滨</s:if>
		               	<s:if test="qualificationRevocation.spare1==230200">齐齐哈尔</s:if>
		               	<s:if test="qualificationRevocation.spare1==231000">牡丹江</s:if> 
						<s:if test="qualificationRevocation.spare1==230600">大庆</s:if> 
						<s:if test="qualificationRevocation.spare1==230700">伊春</s:if>
						<s:if test="qualificationRevocation.spare1==230400">鹤岗</s:if> 
						<s:if test="qualificationRevocation.spare1==230800">佳木斯</s:if> 
						<s:if test="qualificationRevocation.spare1==231100">黑河</s:if> 
						<s:if test="qualificationRevocation.spare1==232700">大兴安岭地区</s:if>
						<s:if test="qualificationRevocation.spare1==400021">森工</s:if> 
						<s:if test="qualificationRevocation.spare1==400022">绥芬河</s:if> 
						<s:if test="qualificationRevocation.spare1==400023">抚远</s:if> 
						<s:if test="qualificationRevocation.spare1==230300">鸡西</s:if>
						<s:if test="qualificationRevocation.spare1==400020">农垦</s:if> 
						<s:if test="qualificationRevocation.spare1==230900">七台河</s:if>
						<s:if test="qualificationRevocation.spare1==230500">双鸭山</s:if> 
						<s:if test="qualificationRevocation.spare1==231200">绥化</s:if>
		               	<input type="hidden" name="qualificationRevocation.spare1" value="<s:property value="qualificationRevocation.spare1"/>" />
		               	</td>
		                <td>审批部门：</td>
		              	<td><s:property value="qualificationRevocation.approvaldeptname"/>
		              		<input type="hidden" name="qualificationRevocation.approvaldeptname" value="<s:property value="qualificationRevocation.approvaldeptname"/>" />
		        	</td>
		        </tr>
		        <tr>
                    <td>审批时间：</td>
               		<td>
               			<s:date name="qualificationRevocation.ultimatedate" format="yyyy-MM-dd" />
               			<input id="time1" type="hidden"
								value="<s:date name="qualificationRevocation.ultimatedate" format="yyyy-MM-dd" />"
								name="qualificationRevocation.ultimatedate"
								class="required" />
                    </td>
                    <td>审批建议：</td>
                    <td>
                    	<s:property value="qualificationRevocation.ultimateopinion"/>
                    	<input type="hidden" name="qualificationRevocation.ultimateopinion" value="<s:property value="qualificationRevocation.ultimateopinion"/>" />
                    </td>
                </tr>
                <tr>
					<td>资质名称：</td>
					<td colspan="3">
						<s:property value="qualificationRevocation.certName" />
						<input type="hidden" name="qualificationRevocation.certName" value='<s:property value="qualificationRevocation.certName" />' />
					</td>
				</tr>
                <tr>
                    <td>专业类别：</td>
               		<td>
               		<s:property value="qualificationRevocation.tradetypeName"/>
               		<input type="hidden" name="qualificationRevocation.tradetypeName" value="<s:property value="qualificationRevocation.tradetypeName"/>" />
               		<input type="hidden" name="qualificationRevocation.tradeboundnum" value="<s:property value="qualificationRevocation.tradeboundnum"/>" />
                    </td>
                    <td>资质资格等级：</td>
                    <td>
                    <s:property value="qualificationRevocation.gradeName"/>
                    <input type="hidden" name="qualificationRevocation.gradeName" value="<s:property value="qualificationRevocation.gradeName"/>" />
                    <input type="hidden" name="qualificationRevocation.titlelevelnum" value="<s:property value="qualificationRevocation.titlelevelnum"/>" />
                    </td>
                </tr>
                <tr>
                    <td>资质资格取得方式：</td>
               		<td>
               		<s:property value="qualificationRevocation.addtypeName"/>
               		<input type="hidden" name="qualificationRevocation.addtypeName" value="<s:property value="qualificationRevocation.addtypeName"/>" />
               		<input type="hidden" name="qualificationRevocation.addtypenum" value="<s:property value="qualificationRevocation.addtypenum"/>" />
                    </td>
                    <td>部门审批结果：</td>
                    <td>
                    	<s:property value="qualificationRevocation.ultimateresults" />
                    	<input type="hidden" name="qualificationRevocation.ultimateresults" value="<s:property value="qualificationRevocation.ultimateresults"/>" />
                    </td>
                </tr>
                <tr>
                    <td>注册建造师：</td>
               		<td>
               			<a href="#" onclick="getCountConstructor('<s:property value="qualificationRevocation.corpName"/>')">点击查看</a>
               		</td>
                    <td>岗位人员：</td>
                    <td>
                    	<a href="#" onclick="getCountPositions('<s:property value="qualificationRevocation.corpName"/>')">点击查看</a>
                    </td>
                </tr>
                 <tr>
                    <td>技术工人：</td>
               		<td>
               			<a href="#" onclick="getSkilledworker('<s:property value="qualificationRevocation.corpId"/>')">点击查看</a>
               		</td>
                    <td>职称人员：</td>
                    <td>
                    	<a href="#" onclick="getTitle('<s:property value="qualificationRevocation.corpId"/>')">点击查看</a>
                    </td>
                </tr>
                 <tr style="height:60px; border:0">
                    <td>企业工程业绩：</td>
               		<td>
					<a href="#" onclick="getPerformance('<s:property value="qualificationRevocation.corpId" /> ')">详细查看</a>
					</td>
					<td>企业拥有资质：</td>
                	<td>
                	<a href="#" onclick="getCertification('<s:property value="qualificationRevocation.corpId" /> ')">详细查看</a>
                	</td>
                </tr>
                <tr style="height:60px; border:0">
                    <td>打回原因：</td>
               		<td colspan="3"><s:property value="qualificationRevocation.revocationReason" /></td>
                </tr>
            </table>
            <div class="sp_bton"> 
            	<a href="javascript:history.go(-1)"><span class="sp_first">返回</span></a>
            </div>
        </form>
    	</div>
  </div>
</body>
</html>