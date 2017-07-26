<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册技术工种</title>
<script type="text/javascript">
	//查询
	function querySkilledworker()
	{
		document.form1.action="<%=basepath %>/skilledworkerAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/skilledworkerAction_goBack.action";
		document.form1.submit();
	}
	
	//增加
	function createSkilledworker()
	{
		document.form1.action="<%=basepath %>/skilledworkerAction_createdPage.action";
		document.form1.submit();
	}
	
	//操作提示信息
	function getMessage()
	{
		var message = document.getElementById("message").value;
		if(message != "")
		{
			alert(message);
		}
	}
	
</script>
</head>
<body onload="getMessage()">
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">
    	<div class="index_top">
        	<img src="<%=basepath %>/img/zhindex_name.png" />
        	
        </div>
      
        <div class="ry_content">
        <form id="form1" name="form1" method="post" action="">
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>注册技术人员搜索</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>人员名称：</td>
                        <td><input type="text" name="condition.personName" value="<s:property value="condition.personName"/>"/></td>
                        <td>证件号码：</td>
                        <td><input type="text" name="condition.identityCard" value="<s:property value="condition.identityCard"/>" />
                        </td>
                    </tr>
                    <tr >
                        <td>技术人员种类：</td>
                        <td>
                        <select name="condition.skilledTypeNum">
      					<option value="">请选择</option>
      						<s:iterator value="typedNums">
          						<option value="<s:property value="code"/>" <s:if test='condition.skilledTypeNum==code'>selected</s:if>><s:property value="name"/></option>
      						</s:iterator>
						</select>
						</td>
                        <td >技术人员级别：</td>
                        <td>
						<select name="condition.skilledLevelNum">
      					<option value="">请选择</option>
      						<s:iterator value="levelNums">
          						<option value="<s:property value="code"/>" <s:if test='condition.skilledLevelNum==code'>selected</s:if>><s:property value="name"/></option>
      						</s:iterator>
						</select>
						</td>
                    </tr>
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/img/ry_look.png" onclick="querySkilledworker()" /></td>
                        <td><input type="image" src="<%=basepath %>/img/ry_tianjia.png" onclick="createSkilledworker()" /></td>
                        <td><input type="image" src="<%=basepath %>/img/ry_return.png" onclick="goBack()" /></td>
                    </tr>
                </table>		
            
            </div>
         </form>
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">注册技术人员列表<img src="<%=basepath %>/img/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>证件号码</th>
                            <th>技术工种类型</th>
                            <th>技术级别</th>
                            <th>修改</th>
                          </tr>
						  <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="personName"/></td>
                            <td><s:property value="sexName"/></td>
                            <td><s:property value="identityCard"/></td>
                            <td><s:property value="skilledType"/></td>
                            <td><s:property value="skilledLevel"/></td>
                            <td><a href="skilledworkerAction_modifiedPage.action?personId=<s:property value="personId"/>">
                            <span>修改</span></a>&nbsp;
                            <a href="skilledworkerAction_delete.action?personId=<s:property value="personId"/>">
                            <span>删除</span></a></td>
                            
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