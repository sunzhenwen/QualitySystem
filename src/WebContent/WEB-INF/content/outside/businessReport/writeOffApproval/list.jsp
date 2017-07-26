<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业资质注销申请</title>
<script type="text/javascript">
	//查询
	function query()
	{
		document.form1.action="<%=basepath %>/writeOffApprovalAction_queryPage.action";
		document.form1.submit();
	}
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/writeOffApprovalAction_goBack.action";
		document.form1.submit();
	}
	//注销
	function writeOffApp()
	{
		if(hasChecked(form1)==false){
			alert("请选择要注销的记录!");
			return;
		}
		if(confirm("您确定要注销选中的记录吗？")==true){
			document.form1.action="<%=basepath %>/writeOffApprovalAction_writeOffApp.action";
			document.form1.submit();
		}
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
              	<h2>企业资质注销申请</h2>
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
                        <td><input type="image" src="<%=basepath %>/img/zhuxiao.png" onclick="writeOffApp()" /></td>
                        <td><input type="image" src="<%=basepath %>/img/ry_return.png" onclick="goBack()" /></td>
                    </tr>
                </table>		
            
            </div>
         
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">企业资质注销申请<img src="<%=basepath %>/img/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
						<th><input type="checkbox" name="all" onclick="javascript:check(form1,form1.all);" class="henglan"></th>
						<th>序号</th>
						
						<th>企业名称</th>
						<th>资质类别及等级</th>
						<th>营业执照注册号</th>
						<th>证书编号</th>
						
						  </tr>
						  <s:iterator status="i" value="currentPage.data" > 
						<tr>
							<td><input type="checkbox" name="ids" value="<s:property value="relationId"/>" onclick="javascript:setChecked(form1);"/></td>
							<td><s:property value="#i.count"/></td>
							<td><s:property value="corpName"/></td>
							<td><s:property value="certName"/></td>
							<td><s:property value="licenseNum"/></td>
							<td><s:property value="certId"/></td>
							
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