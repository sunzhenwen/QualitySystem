<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业资质详细信息</title>
<script type="text/javascript">
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/qualityChangeAction_queryCorpQualityChange.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="ry_wrapp">
		<div class="index_top">
			<img src="<%=basepath%>/img/zhindex_name.png" />

		</div>
		<form id="form1" name="form1" method="post" action="">
			<div class="ry_content">

				<div class="ry_lbxx">
					<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
						<h2>资质变更详细信息</h2>

			            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
			            
			              
			                <tr>
			                	<td></td>
			                	<td style="text-align:center;">
			                	变更前
			                	</td>
			                    <td style="text-align:center;">变更后</td>
			                </tr>
			               
			                <tr>
			                    <th>企业名称：</th>
			               		<td>
			               			${qualityChange.CORPNAME}
			               		</td>
			                    <td style="text-align:left; padding-left:6px;">
									${qualityChange.CHANGE_CORPNAME}
								</td>
			                   
			                </tr>
			                 <tr>
			                    <th>营业执照注册号：</th>
			               		<td >
			              			${qualityChange.LICENSENUM}
			                    </td>
			                    <td style="text-align:left; padding-left:6px;">
			                    	${qualityChange.CHANGE_LICENSENUM}
			                    </td>
			
			                </tr>
			                <tr>
			                    <th>详细地址：</th>
			               		<td>
			               			${qualityChange.ADDRESS}
			                    </td>
			                    <td style="text-align:left; padding-left:6px;">
			                  		${qualityChange.CHANGE_ADDRESS}
			                    </td>
			                   
			                </tr>
			                <tr>
			                    <th>注册资本(万元)：</th>
			               		<td>
			               			${qualityChange.REGPRIN}
			                    </td>
			                    <td style="text-align:left; padding-left:6px;">
			                  		${qualityChange.CHANGE_REGPRIN}
			                    </td>
			
			                </tr>
			                <tr>
			                    <th>经济性质：</th>
			               		<td>
			               			${qualityChange.ECONOMICNAME}
			                    </td>
			                    <td style="text-align:left; padding-left:6px;">
			                    	${qualityChange.CHANGE_ECONOMICNAME}
			                    </td>
			   
			                </tr>
			                <tr>
			                    <th>法定代表人：</th>
			               		<td>
			               			${qualityChange.LEGALMAN}
			               		</td>
			                    <td style="text-align:left; padding-left:6px;">
			                    	${qualityChange.CHANGE_LEGALMAN}
			                    </td>
			
			                </tr>
			                  <tr>
			                    <th>是否做四码合一：</th>
			               		<td colspan="2">
			              		  <input type="checkbox" name="qualityChange.IS_CODE_MERGE" value="1" <s:if test='qualityChange.IS_CODE_MERGE==1'>checked</s:if> disabled="disabled" />
								  
			                    </td>
                			 </tr>
			                <!--  
			                <tr>
			                    <th>企业归属地(市级)：</th>
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

					</div>
					<%@include file="/WEB-INF/content/outside/footer.jsp"%>
				</div>
		</form>
</body>
</html>