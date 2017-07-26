<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>职称人员</title>
<script type="text/javascript">
	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/titleAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function addTitle()
	{
		document.form1.action="<%=basepath %>/titleAction_addPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/titleAction_goBack.action";
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
	<div class="ry_wrapp">
    	<div class="index_top">
        	<img src="<%=basepath %>/img/zhindex_name.png" />
        	<input type="hidden" id="message" value="<s:property value="message" />" />
        </div>
      
        <div class="ry_content">
        <form id="form1" name="form1" method="post" action="">
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>职称人员基本情况搜索</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>人员名称：</td>
                        <td><input type="text" name="condition.personName" value="<s:property value="condition.personName"/>"/></td>
                        <td>证件号码：</td>
                        <td><input type="text" name="condition.idCard" value="<s:property value="condition.idCard"/>" />
                        </td>
                    </tr>
                    <tr>
                        <td>职称：</td>
                        <td>
                        <input type="text" name="condition.titleName" value="<s:property value="condition.titleName"/>" />
						</td>
                        <td >职称专业：</td>
                        <td>
                        <input type="text" name="condition.titleMajor" value="<s:property value="condition.titleMajor"/>" />
						</td>
                    </tr>
                    <tr>
                        <td>职称级别：</td>
                        <td>
                        <input type="text" name="condition.titleLevel" value="<s:property value="condition.titleLevel"/>" />
						</td>
                        <td >所学专业：</td>
                        <td>
                        <input type="text" name="condition.studyMajor" value="<s:property value="condition.studyMajor"/>" />
						</td>
                    </tr>
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/img/ry_look.png" onclick="queryTitle()"/></td>
                        <td><input type="image" src="<%=basepath %>/img/ry_tianjia.png" onclick="addTitle()" /></td>
                        <td><input type="image" src="<%=basepath %>/img/ry_return.png" onclick="goBack()" /></td>
                    </tr>
                </table>		
            
            </div>
         </form>
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">职称人员列表<img src="<%=basepath %>/img/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>证件号码</th>
                            <th>职称</th>
                            <th>职称专业</th>
                            <th>职称级别</th>
                            <th>毕业学校</th>
                            <th>所学专业</th>
                            <th>毕业时间</th>
                            <th>手机号码</th>
                            <th>操作</th>
                          </tr>
						  <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="personName"/></td>
                            <td><s:property value="sexName"/></td>
                            <td><s:property value="idCard"/></td>
                            <td><s:property value="titleName"/></td>
                            <td><s:property value="titleMajor"/></td>
                            <td><s:property value="titleLevel"/></td>
                            <td><s:property value="graduatedSchool"/></td>
                            <td><s:property value="studyMajor"/></td>
                            <td><s:date name="graduatedDate" format="yyyy-MM-dd" /></td>
                            <td><s:property value="mobile"/></td>
                            <td><a href="titleAction_modifyPage.action?personId=<s:property value="personId"/>"><span>修改</span></a>&nbsp;<a href="titleAction_delete.action?personId=<s:property value="personId"/>"><span>删除</span></a></td>
                            
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