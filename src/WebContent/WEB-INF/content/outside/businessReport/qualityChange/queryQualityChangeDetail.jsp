<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>资质变更</title>
<script type="text/javascript">
	
	//审批通过
	function applythrough()
	{
		document.form1.action="<%=basepath %>/provinceApprovalAction_applythrough.action";
		document.form1.submit();
	}
	//申请退回
	function applyBack()
	{
		document.form1.action="<%=basepath %>/provinceApprovalAction_applyBack.action";
		document.form1.submit();
	}
	
	//返回
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryQualityChangeAction_showQualityChangeQueryInner.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">资质变更</h2>
         
         <form style="margin:50px;" id="form1" name="form1" method="post" action="">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
            
              
                <tr>
                	<td></td>
                	<td style="text-align:center;">
                	变更前
                	</td>
                    <td style="text-align:center;">变更后</td>
                </tr>
               
                <tr>
                    <td>企业名称：</td>
               		<td>
               			${qualityChange.CORPNAME}
               		</td>
                    <td style="text-align:left; padding-left:6px;">
						${qualityChange.CHANGE_CORPNAME}
					</td>
                   
                </tr>
                 <tr>
                    <td>营业执照注册号：</td>
               		<td >
              			${qualityChange.LICENSENUM}
                    </td>
                    <td style="text-align:left; padding-left:6px;">
                    	${qualityChange.CHANGE_LICENSENUM}
                    </td>

                </tr>
                <tr>
                    <td>详细地址：</td>
               		<td>
               			${qualityChange.ADDRESS}
                    </td>
                    <td style="text-align:left; padding-left:6px;">
                  		${qualityChange.CHANGE_ADDRESS}
                    </td>
                   
                </tr>
                <tr>
                    <td>注册资本(万元)：</td>
               		<td>
               			${qualityChange.REGPRIN}
                    </td>
                    <td style="text-align:left; padding-left:6px;">
                  		${qualityChange.CHANGE_REGPRIN}
                    </td>

                </tr>
                <tr>
                    <td>经济性质：</td>
               		<td>
               			${qualityChange.ECONOMICNAME}
                    </td>
                    <td style="text-align:left; padding-left:6px;">
                    	${qualityChange.CHANGE_ECONOMICNAME}
                    </td>
   
                </tr>
                <tr>
                    <td>法定代表人：</td>
               		<td>
               			${qualityChange.LEGALMAN}
               		</td>
                    <td style="text-align:left; padding-left:6px;">
                    	${qualityChange.CHANGE_LEGALMAN}
                    </td>

                </tr>
                 <tr>
                    <td>是否做四码合一：</td>
               		<td colspan="2">
              		  <input type="checkbox" name="qualityChange.IS_CODE_MERGE" value="1" <s:if test='qualityChange.IS_CODE_MERGE==1'>checked</s:if> disabled="disabled" />
					
                    </td>

                 </tr>
                <tr>
                	<td></td>
                	<td style="text-align:center;">
                	审批人
                	</td>
                    <td style="text-align:center;">审批时间</td>
                </tr>
                <tr>
                    <td>国家审批：</td>
               		<td>
               			${qualityChange.STAFF_COUNTRY}
               		</td>
                    <td style="text-align:left; padding-left:6px;">
                    	${qualityChange.APPROVALTIME_COUNTRY}
                    </td>

                </tr>
                <tr>
                    <td>省级审批：</td>
               		<td>
               			${qualityChange.STAFF_PROVINCE}
               		</td>
                    <td style="text-align:left; padding-left:6px;">
                    	${qualityChange.APPROVALTIME_PROVINCE}
                    </td>

                </tr>
                <tr>
                    <td>地市审批：</td>
               		<td>
               			${qualityChange.STAFF_CITY}
               		</td>
                    <td style="text-align:left; padding-left:6px;">
                    	${qualityChange.APPROVALTIME_CITY}
                    </td>

                </tr>
                <!--  
                <tr>
                    <td>企业归属地(市级)：</td>
               		<td>
               			${qualityChange.SPARENAME}
               		</td>
                    <td style="text-align:left; padding-left:6px;">
                    	${qualityChange.CHANGE_SPARENAME}
                    </td>			
			    </tr>
				-->
				
            </table>
             <div class="sp_bton"> 
        	    <a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
            </div>
           
        </form>
        
    	</div>
  </div>
</body>
</html>