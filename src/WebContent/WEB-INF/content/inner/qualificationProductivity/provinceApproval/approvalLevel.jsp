<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>省级资质审批</title>
<script type="text/javascript">
	
	//审批通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			if(confirm("请确认是否通过"))
			{
				document.form1.action="<%=basepath %>/provinceApprovalAction_applyThrough.action";
				document.form1.submit();
			}
			else
			{
			}
			
		}else
		{
			alert("请输入审批意见!");	
		}
	}
	//申请退回
	function applyBack()
	{
		var nmv = document.getElementById("appId");
		if(nmv.value != "")
		{
			if(confirm("请确认是否不通过"))
			{
				document.form1.action="<%=basepath %>/provinceApprovalAction_applyThroughBack.action";
				document.form1.submit();
			}
			else
			{
			}
			
		}else
		{
			alert("请输入审批意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/provinceApprovalAction_goBack.action";
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
		window.open('<%=basepath %>/querySkilledworkerAction_getSkilledworker.action?condition.corpId='+corpId)   
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
        
         <h2 class="f16 fb" style="background:#80aced;">省级资质审批</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
                <tr>
                	<td>企业名称：</td>
                	<td>
                	<s:property value="newQualification.corpName"/>
                	<input type="hidden" name="newQualification.corpName" value="<s:property value="newQualification.corpName"/>" />
                	<input type="hidden" name="newQualification.newQualId" value="<s:property value="newQualification.newQualId"/>" />
                	<input type="hidden" name="newQualification.corpCode" value="<s:property value="newQualification.corpCode"/>" />
                	
                	</td>
                    <td>所属部门：</td>
               		<td><s:property value="newQualification.provinceName"/><s:property value="newQualification.cityName"/><s:property value="newQualification.countyName"/></td>
                </tr>
               
                <tr>
                    <td>资质资格类型：</td>
               		<td>
               		<s:property value="newQualification.cretTypeName"/>
               		<input type="hidden" name="newQualification.cretType" value="<s:property value="newQualification.cretType"/>" />
               		</td>
                    <td>资质资格序列：</td>
                    <td>
                    <s:property value="newQualification.cretSequenceName"/>
                    <input type="hidden" name="newQualification.cretSequence" value="<s:property value="newQualification.cretSequence"/>" />
                    </td>
                </tr>
                 <tr>
                    <td>专业类别：</td>
               		<td>
               		<s:property value="newQualification.specialtyTypeName"/>
               		<input type="hidden" name="newQualification.specialtyType" value="<s:property value="newQualification.specialtyType"/>" />
                    </td>
                    <td>资质资格等级：</td>
                    <td>
                    <s:property value="newQualification.cretLevelName"/>
                    <input type="hidden" name="newQualification.cretLevel" value="<s:property value="newQualification.cretLevel"/>" />
                    </td>
                </tr>
                <tr>
                    <td>资质资格取得方式：</td>
               		<td>
               		<s:property value="newQualification.addTypeName"/>
               		<input type="hidden" name="newQualification.addTypeNum" value="<s:property value="newQualification.addTypeNum"/>" />
                    </td>
                    <td>申请日期：</td>
                    <td>
                    <s:date name="newQualification.creatDate" format="yyyy-MM-dd" />
                    </td>
                </tr>
                <tr>
                    <td>企业净资产：</td>
               		<td>
               		<s:property value="newQualification.assets"/>万元
               		<input type="hidden" name="newQualification.assets" value="<s:property value="newQualification.assets"/>" />
                    </td>
                    <td>机械设备：</td>
               		<td>
               		<s:property value="newQualification.machinery"/>
               		<input type="hidden" name="newQualification.machinery" value="<s:property value="newQualification.machinery"/>" />
                    </td>
                </tr>
                <tr>
                    <td>审批部门：</td>
               		<td>
               			<s:property value="newQualification.approvalDeptName"/>
               			<!-- 审批部门Id -->
               			<input type="hidden" name="newQualification.approvalDept" value="<s:property value="newQualification.approvalDept"/>" />
                    	<!-- 审批部门名称 -->
                    	<input type="hidden" name="newQualification.approvalDeptName" value="<s:property value="newQualification.approvalDeptName"/>" />
                    </td>
                    <td>审批人员：</td>
                    <td>
                    	<s:property value="approvalStaff"/>
                    	<!-- 审批人员名称 -->
                    	<input type="hidden" name="newQualification.approvalStaff" value="<s:property value="approvalStaff"/>" />
                    	<!-- 审批人员Id -->
                    	<input type="hidden" name="newQualification.approvalStaffId" value="<s:property value="approvalStaffId"/>" />
                    	<!-- 企业Id -->
                    	<input type="hidden" name="newQualification.corpId" value="<s:property value="newQualification.corpId"/>" />
                    	<!-- 企业登记注册类型 -->
                    	<input type="hidden" name="newQualification.economicNum" value="<s:property value="newQualification.economicNum"/>" />
                    	<input type="hidden" name="newQualification.cretGrade" value="<s:property value="newQualification.cretGrade"/>" />
		                <!-- 工商营业执照注册号 -->
						<input type="hidden" name="newQualification.licenseNum" value="<s:property value="newQualification.licenseNum"/>" />
						<!-- 法定代表人姓名 -->
						<input type="hidden" name="newQualification.legalMan" value="<s:property value="newQualification.legalMan"/>" />
						<!-- 法定代表人证件类型 -->
						<input type="hidden" name="newQualification.idCardTypeNum" value="<s:property value="newQualification.idCardTypeNum"/>" />
						<!-- 法定代表人证件号码 -->
						<input type="hidden" name="newQualification.legalManIdCard" value="<s:property value="newQualification.legalManIdCard"/>" />
						<!-- 法定代表人职务 -->
						<input type="hidden" name="newQualification.legaLManDuty" value="<s:property value="newQualification.legaLManDuty"/>" />
						<!-- 法定代表人职称 -->
						<input type="hidden" name="newQualification.legaManProtitle" value="<s:property value="newQualification.legaManProtitle"/>" />
						<!-- 企业营业地址 -->
						<input type="hidden" name="newQualification.address" value="<s:property value="newQualification.address"/>" />
						
						
						<!-- 注册所在省 -->
						<input type="hidden" name="newQualification.provinceNum" value="<s:property value="newQualification.provinceNum"/>" />
						<!-- 注册所在市 -->
						<input type="hidden" name="newQualification.cityNum" value="<s:property value="newQualification.cityNum"/>" />
						<!-- 注册所在区 -->
						<input type="hidden" name="newQualification.countyNum" value="<s:property value="newQualification.countyNum"/>" />
						<!-- 服务事项名称 -->
						<input type="hidden" name="newQualification.certName" value="<s:property value="newQualification.certName"/>" />
						<!-- 注册资本 -->
						<input type="hidden" name="newQualification.regPrin" value="<s:property value="newQualification.regPrin"/>" />
						
						
					</td>
                </tr>
                <tr>
                    <td>注册建造师：</td>
               		<td>
               			<a href="#" onclick="getCountConstructor('<s:property value="newQualification.corpName"/>')">共&nbsp;<s:property value="countConstructor"/>&nbsp;人</a>
               		</td>
                    <td>岗位人员：</td>
                    <td>
                    	<a href="#" onclick="getCountPositions('<s:property value="newQualification.corpName"/>')">共&nbsp;<s:property value="countPositions"/>&nbsp;人</a>
                    </td>
                </tr>
                <tr>
                    <td>技术工人：</td>
               		<td>
               			<a href="#" onclick="getSkilledworker('<s:property value="newQualification.corpId"/>')">共&nbsp;<s:property value="countSkilledworker"/>&nbsp;人</a>
               		</td>
                    <td>职称人员：</td>
                    <td>
                    	<a href="#" onclick="getTitle('<s:property value="newQualification.corpId"/>')">共&nbsp;<s:property value="countTitle"/>&nbsp;人</a>
                    </td>
                </tr>
                
                
                
                
                
    
                <tr>
                	<td>原资质专业类别：</td>
               		<td>
               			<s:property value="newQualification.oldSpecialtyTypeName"/>
               		</td>
                    <td>原资质等级：</td>
               		<td>
               			<s:property value="newQualification.oldCretLevelName"/>
               		</td>
                    
                </tr>
                <tr>
                    <td>原资质申请时间：</td>
                    <td>
                    	<s:date name="newQualification.oldCreatDate" format="yyyy-MM-dd" />
                    </td>
                    <td>原资审批时间：</td>
               		<td>
               			<s:date name="newQualification.oldUltimateDate" format="yyyy-MM-dd" />
               		</td>
                </tr>
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                <tr style="height:60px; border:0">
                    <td>企业工程业绩：</td>
               		<td>
					<a href="#" onclick="getPerformance('<s:property value="newQualification.corpId"/>')">详细查看</a>
					</td>
					<td>&nbsp;</td>
                	<td>&nbsp;</td>
                </tr>
                <tr style="height:60px; border:0">
                    <td>审批建议：</td>
               		<td colspan="3"> <textarea id="appId" name="newQualification.ultimateOpinion" class="required"></textarea> </td>
                </tr>
            </table>
            <div class="sp_bton"> 
        		<a href="#"><span class="sp_first" onclick="applythrough()">通过</span></a>
        	    <a href="#"><span class="sp_second" onclick="applyBack()">不通过</span></a>
        	    <a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
            </div>
        </form>
    	</div>
  </div>
</body>
</html>