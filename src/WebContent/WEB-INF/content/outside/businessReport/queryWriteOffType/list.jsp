<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业资质注销查询</title>
<script type="text/javascript">
	//查询
	function query()
	{
		document.form1.action="<%=basepath %>/queryWriteOffTypeAction_queryPage.action";
		document.form1.submit();
	}
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryWriteOffTypeAction_goBack.action";
		document.form1.submit();
	}
	
</script>
</head>
<body>
	<div class="ry_wrapp">
	<form id="form1" name="form1" method="post" action="">
    	<div class="index_top">
        	<img src="<%=basepath %>/img/zhindex_name.png" />
        	
        </div>
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>企业资质注销查询</h2>
            	<table class="ry_left left">
                <tr>
			    	<td>资质类别及等级：</td>
			  		<td>
			  	    	<input type="text" name="condition.certName" value="<s:property value="condition.certName"/>" />
			  		</td>
					<td>证书编号：</td>
			        <td>
			  	 		<input type="text" name="condition.certId" value="<s:property value="condition.certId"/>" />
			  		</td>
	  	        </tr>
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/img/ry_look.png" onclick="query()" /></td>
                        <td><input type="image" src="<%=basepath %>/img/ry_return.png" onclick="goBack()" /></td>
                    </tr>
                </table>		
            
            </div>
         
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">企业资质注销申请<img src="<%=basepath %>/img/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
						<th>序号</th>
						<th>企业名称</th>
						<th>资质类别及等级</th>
						<th>营业执照注册号</th>
						<th>证书编号</th>
						<th>申请状态</th>
						<th>申请时间</th>
						  </tr>
						  <s:iterator status="i" value="currentPage.data" > 
						<tr>
							<td><s:property value="#i.count"/></td>
							<td><s:property value="corpName"/></td>
							<td><s:property value="certName"/></td>
							<td><s:property value="licenseNum"/></td>
							<td><s:property value="certId"/></td>
							<td>
							<s:if test="writeOffType==1">
								申请已提交
							</s:if>
							<s:if test="writeOffType==2">
								申请通过
							</s:if>
							<s:if test="writeOffType==3">
								申请未通过
							</s:if>
							<s:if test="writeOffType==4">
								待主管部门审批
							</s:if>
							<s:if test="writeOffType==5">
								大厅审批未通过
							</s:if>
							<s:if test="writeOffType==6">
								主管部门审批通过
							</s:if>
							<s:if test="writeOffType==7">
								主管部门审批未通过
							</s:if>
							</td>
							<td><s:date name="writeOffAppDate" format="yyyy-MM-dd"/></td>
						</tr>
						</s:iterator>
                         
                	</tbody>  
                </table>
                 <%@include file="/WEB-INF/content/inc/page.jsp"%> 
                
         </div>
    	</div>
    	</form>
         <%@include file="/WEB-INF/content/outside/footer.jsp"%> 
    </div>
</body>
</html>