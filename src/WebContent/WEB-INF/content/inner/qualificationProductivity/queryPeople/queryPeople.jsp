<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册建造师</title>
<script type="text/javascript">
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryPeopleAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="">
	<div class="ry_wrapp">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	
              	<s:if test="constructor.idCard!=null">
              	<h2>注册人员详细基本信息</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>姓名：</th>
                            <td><s:property value="constructor.personName"/></td>
                            <th>证件类型：</th>
                            <td><s:property value="constructor.idCardTypeName"/></td>
                            
                         </tr>
                         <tr>
                         	<th>证件号码：</th>
                            <td><s:property value="constructor.idCard"/></td>
                            <th>注册类型及等级：</th>
                            <td><s:property value="constructor.sepecialtyTypName"/></td>
                           
                          
                         </tr>
                           <tr>
                         	<th>注册证书编号：</th>
                            <td><s:property value="constructor.certNum"/></td>
                            <th>发证日期：</th>
                            <td><s:date name="constructor.awardDate" format="yyyy-MM-dd" /></td>
                          
                          
                         </tr>
                         <tr>
                         	<th>发证单位：</th>
                            <td><s:property value="constructor.awardDepart"/></td>
                            <th>执业印章号：</th>
                            <td><s:property value="constructor.stampNum"/></td>
                           
                         </tr>
                         
                           <tr>
                         	<th>注册有效期：</th>
                            <td><s:date name="constructor.effectDate" format="yyyy-MM-dd" /></td>
                            <th>所在企业行业类型（1-8）：</th>
                            <td><s:property value="constructor.callingTypeName"/></td>
                            
                          
                         </tr>
                         <tr>
                         	<th>所在企业名称：</th>
                            <td><s:property value="constructor.corpName"/></td>
                            <th>所在企业组织代码证（1-8）：</th>
                            <td><s:property value="constructor.corpCode"/></td>
                            
                          
                         </tr>
                         <tr>
                         	<th>所在企业证书编号：</th>
                            <td><s:property value="constructor.certId"/></td>
                            <th>注册专业编号（1-8）：</th>
                            <td><s:property value="constructor.regTradeTypeName"/></td>
                            
                          
                         </tr>
                         <tr>
                         	<th>注册开始日期：</th>
                            <td><s:date name="constructor.tradeTypeAwardDate" format="yyyy-MM-dd" /></td>
                            <th>注册截止日期（1-8）：</th>
                            <td><s:date name="constructor.tradeTypeEffectDate" format="yyyy-MM-dd" /></td>
                        </tr>
                         <tr>
                         	<th>职业资格状态：</th>
                            <td><s:property value="constructor.stateName"/></td>
                            
                      </tr>
                      
             	</tbody>  
                </table>
                </s:if>
                <s:if test="positions.cardId!=null">
                	  <h2 class="f16 fb">岗位人员详细信息</h2>
                	<table class="" cellpadding="0" cellspacing="0">
						<tbody>
						<tr>
								<th>姓名：</th>
								<td>
									<s:property value="positions.name"/>
								</td>
								<th>性别：</th>
								<td>
								<s:property value="positions.sex"/>
								</td>
								</tr>
							<tr>
								<th>证件号码：</th>
								<td><s:property value="positions.cardId"/></td>
								<th>岗位名称：</th>
								<td>
								<s:property value="positions.duty"/>
								</td>
							</tr>
					<tr>
						<th>所属企业：</th>
						<td colspan="3" ><s:property value="positions.entName"/></td>
					</tr>
					<tr>
						
						<td colspan="4" ><font color="red" >*岗位人员仅显示'施工员','质量员','安全员','标准员','材料员','机械员','劳务员','资料员'</font></td>
					</tr>
					</tbody>
					</table>
                </s:if>
                <s:if test="skilledworker.identityCard!=null">
                <h2 class="f16 fb">技术人员详细信息</h2>
                	<table class="" cellpadding="0" cellspacing="0">
						<tbody>
						<tr>
								<th>姓名：</th>
								<td>
									<s:property value="skilledworker.personName"/>
								</td>
								<th>性别：</th>
								<td>
								<s:property value="skilledworker.sexName"/>
								</td>
								</tr>
							<tr>
								<th>证件类型：</th>
								<td>
								<s:property value="skilledworker.idCardTypeName"/>
								</td>
								<th>证件号码：</th>
								<td><s:property value="skilledworker.identityCard"/></td>
							</tr>
						<tr>
						<th>工种类型：</th>
						<td><s:property value="skilledworker.skilledType"/></td>
						<th>工种级别：</th>
						<td><s:property value="skilledworker.skilledLevel"/></td>
					</tr>
					
						<tr>
						<th>民族：</th>
						<td><s:property value="skilledworker.nationAlityName"/></td>
						<th>手机号码：</th>
						<td><s:property value="skilledworker.mobile"/></td>
					</tr>
					<tr>
						<th>学位：</th>
						<td><s:property value="skilledworker.degreeName"/></td>
						<th>学历：</th>
						<td><s:property value="skilledworker.eduLevelName"/></td>
					</tr>
					<tr>
						<th>出生日期：</th>
						<td><s:date name="skilledworker.birthday" format="yyyy-MM-dd" /></td>
						<th>所属企业：</th>
						<td><s:property value="skilledworker.corpName"/></td>
					</tr>
					</tbody>
					</table>
                </s:if>
                <s:if test="title.idCard!=null">
                <h2>职称人员详细信息</h2>
                	<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>姓名：</th>
								<td>
									<s:property value="title.personName"/>
								</td>
								<th>性别：</th>
								<td>
									<s:property value="title.sexName"/>
								</td>

							</tr>
							<tr>
								<th>证件类型：</th>
								<td>
									<s:property value="title.idCardTypeName"/>
								</td>
								<th>证件号码：</th>
								<td><s:property value="title.idCard"/></td>
							</tr>
							<tr>
								<th>职称：</th>
								<td><s:property value="title.titleName"/></td>
								<th>职称专业：</th>
								<td><s:property value="title.titleMajor"/></td>


							</tr>
							<tr>
								<th>职称级别：</th>
								<td><s:property value="title.titleLevel"/></td>
								<th>毕业学校：</th>
								<td><s:property value="title.graduatedSchool"/></td>

							</tr>

							<tr>
								<th>所学专业：</th>
								<td><s:property value="title.studyMajor"/></td>
								<th>毕业时间：</th>
								<td><s:date name="title.graduatedDate" format="yyyy-MM-dd" /></td>


							</tr>
							<tr>
								<th>手机号码：</th>
								<td><s:property value="title.mobile"/></td>
								<th>所属企业：</th>
								<td><s:property value="title.corpName"/></td>
							</tr>


						</tbody>
					</table>
                </s:if>
                <div class="ry_lbreturn">
                	
                       <a href="#" onclick="goBack()"> <img src="<%=basepath %>/img/ry_return.png" /></a>
                   
           </div>
                
                </div> 
            </div>
                 
         </div>
         	
    
    </div>
    </form>
</body>
</html>