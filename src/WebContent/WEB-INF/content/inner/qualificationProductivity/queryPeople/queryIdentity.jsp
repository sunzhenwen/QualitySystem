<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<script type="text/javascript">
	
	function query() {
		
		var idCard = document.getElementById("idCard").value;
		if(idCard == null) {
			alert("请输入身份证号");
		} else {
			document.form1.action="<%=basepath%>/queryPeopleAction_queryPeopleID.action";
			document.form1.submit();
		}
		
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
 <form id="form1" name="form1" method="post" action="">
		<input type="hidden" id="message" value='<s:property value="message" />' >
        <div class="index_bottom">
            
	
           	
      	        <ul>
                       <li style="padding:30px 30px; font-size:xx-large;  "  >人员查询</li>
                       <li style="padding:20px 20px; font-size:x-large;  "  >人员身份证号查询</li>
                       <li style="padding:0px 0px; font-size:medium; color: red "  >*请输入准确的身份证号，该功能不支持模糊查询</li>
                       
                       <li ><input id="idCard"  name="idCard" type="text" size="39" maxlength="18" style="width:30%;padding:10px ;height:30px;" /></li>
                     	
                      <li style="padding:20px 20px;"><input type="image" src="<%=basepath %>/img/ry_look.png" onclick="query()" /></li>
                      
                      
              </ul>
            
            

        
        
    </div>
    </form>
</body>
</html>