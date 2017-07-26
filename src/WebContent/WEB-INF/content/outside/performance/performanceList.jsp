<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业工程业绩</title>
<script type="text/javascript">
	//查询
	function query()
	{
		document.form1.action="<%=basepath %>/performanceAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function addPage()
	{
		document.form1.action="<%=basepath %>/performanceAction_addPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/performanceAction_goBack.action";
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
           	  <h2>企业工程业绩</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>录入时间：</td>
                        <td colspan="3" >
						<input id="time1" type="text" name="condition.startDate" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
						~
						<input id="time2" type="text" name="condition.endDate" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
						</td>
                    </tr>
                	
                	<tr>
                        <td>项目名称：</td>
                        <td><input type="text" name="condition.proName" value="<s:property value="condition.proName"/>"/></td>
                        <td>项目类型：</td>
                        <td><input type="text" name="condition.proType" value="<s:property value="condition.proType"/>" />
                        </td>
                    </tr>
                    
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/img/ry_look.png" onclick="query()"/></td>
                        <td><input type="image" src="<%=basepath %>/img/ry_tianjia.png" onclick="addPage()" /></td>
                        <td><input type="image" src="<%=basepath %>/img/ry_return.png" onclick="goBack()" /></td>
                  </tr>
              </table>		
            
            </div>
         </form>
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">企业工程业绩<img src="<%=basepath %>/img/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>项目名称</th>
                            <th>项目类型</th>
                            <th>工程规模</th>
                            <th>工程造价</th>
                            <th>开工时间</th>
                            <th>竣工时间</th>
                            <th>建设单位</th>
                            <th>总承包单位</th>
                            <th>设计单位</th>
                            <th>监理</th>
                            <th>操作</th>
                          </tr>
						  <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="proName"/></td>
                            <td><s:property value="proType"/></td>
                            <td><s:property value="proScale"/></td>
                            <td><s:property value="proCost"/></td>
                            <td><s:date name="startsDate" format="yyyy-MM-dd" /></td>
                            <td><s:date name="completedDate" format="yyyy-MM-dd" /></td>
                            <td><s:property value="construction"/></td>
                            <td><s:property value="contractor"/></td>
                            <td><s:property value="design"/></td>
                            <td><s:property value="supervisor"/></td>
                            <td>
                            <a href="performanceAction_detailed.action?perId=<s:property value="perId"/>"><span>详细</span></a>
                            &nbsp;
                            <a href="performanceAction_delete.action?perId=<s:property value="perId"/>"><span>删除</span></a>
                            </td>
                            
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