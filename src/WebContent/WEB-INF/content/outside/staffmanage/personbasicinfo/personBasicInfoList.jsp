<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册人员基本信息</title>
<script type="text/javascript">
	//查询
	function queryPersonBasicInfo()
	{
		document.form1.action="<%=basepath %>/personBasicInfoAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/personBasicInfoAction_goBack.action";
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
              	<h2>注册人员基本情况搜索</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>人员名称：</td>
                        <td><input type="text" name="condition.personName" value="<s:property value="condition.personName"/>"/></td>
                        <td>证件号码：</td>
                        <td><input type="text" name="condition.idCard" value="<s:property value="condition.idCard"/>" />
                        </td>
                    </tr>
                    <tr >
                        <td>学历：</td>
                        <td>
                        <select name="condition.eduLevelNum">
      					<option value="">请选择</option>
      						<s:iterator value="eduLevelNums">
          						<option value="<s:property value="code"/>" <s:if test='condition.eduLevelNum==code'>selected</s:if>><s:property value="name"/></option>
      						</s:iterator>
						</select>
						</td>
                        <td >学位：</td>
                        <td>
						<select name="condition.degreeNum">
      					<option value="">请选择</option>
      						<s:iterator value="degreeNums">
          						<option value="<s:property value="code"/>" <s:if test='condition.degreeNum==code'>selected</s:if>><s:property value="name"/></option>
      						</s:iterator>
						</select>
						</td>
                    </tr>
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/img/ry_look.png" onclick="queryPersonBasicInfo()" /></td>
                        <td><input type="image" src="<%=basepath %>/img/ry_return.png" onclick="goBack()" /></td>
                    </tr>
                </table>		
            
            </div>
         </form>
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">注册人员基本信息列表<img src="<%=basepath %>/img/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>证件类型</th>
                            <th>证件号码</th>
                            <th>出生日期</th>
                            <th>民族</th>
                            <th>学历</th>
                            <th>学位</th>
                            <th>手机号码</th>
                            <th>详细</th>
                          </tr>
						  <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="personName"/></td>
                            <td><s:property value="sexName"/></td>
                            <td><s:property value="idCardTypeName"/></td>
                            <td><s:property value="idCard"/></td>
                            <td><s:date name="birthday" format="yyyy-MM-dd" /></td>
                            <td><s:property value="nationAlityName"/></td>
                            <td><s:property value="eduLevelName"/></td>
                            <td><s:property value="degreeName"/></td>
                            <td><s:property value="modile"/></td>
                            <td><a href=""><span>详细</span></a></td>
                            
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