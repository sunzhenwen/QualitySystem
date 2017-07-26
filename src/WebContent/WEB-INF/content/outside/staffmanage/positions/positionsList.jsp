<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>岗位人员</title>
<script type="text/javascript">
	//查询
	function queryConstructor()
	{
		document.form1.action="<%=basepath %>/positionsAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/positionsAction_goBack.action";
		document.form1.submit();
	}
	
</script>
</head>
<body>
	<div class="ry_wrapp">
    	<div class="index_top">
        	<img src="<%=basepath %>/img/zhindex_name.png" />
        	
        </div>
      
        <div class="ry_content">
        <form id="form1" name="form1" method="post" action="">
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>岗位人员基本情况搜索</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>人员名称：</td>
                        <td><input type="text" name="condition.personName" value="<s:property value="condition.personName"/>"/></td>
                        <td>证件号码：</td>
                        <td><input type="text" name="condition.idCard" value="<s:property value="condition.idCard"/>" />
                        </td>
                    </tr>
                    <tr >
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/img/ry_look.png" onclick="queryConstructor()" /></td>
                        <td><input type="image" src="<%=basepath %>/img/ry_return.png" onclick="goBack()" /></td>
                    </tr>
                </table>		
            
            </div>
         </form>
            <div class="ry_liebiao">
           		<p><font color="red">*根据政策要求，岗位人员只显示'施工员','质量员','安全员','标准员','材料员','机械员','劳务员','资料员'</font></p>
            	<p class="f16 pd10 fb">岗位人员列表<img src="<%=basepath %>/img/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>证件号码</th>
                            <th>岗位名称</th>
                            <th>企业名称</th>
                          </tr>
						  <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="name"/></td>
                            <td><s:property value="sex"/></td>
                            <td><s:property value="cardId"/></td>
                            <td><s:property value="duty"/></td>
                            <td><s:property value="entName"/></td>
                         </tr>
						 </s:iterator>
                         
                	</tbody>  
                </table>
                 <%@include file="/WEB-INF/content/inc/page.jsp"%> 
                
         </div>
    	</div>
         <%@include file="/WEB-INF/content/outside/footer.jsp"%> 
    </div>
</body>
</html>