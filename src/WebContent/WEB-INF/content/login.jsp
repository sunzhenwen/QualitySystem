<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript">

	//新企业注册
	function regCorp()
	{
		document.form1.action="<%=basepath%>/corpAction_flowChart.action";
		document.form1.submit();
	}
	
	//UKey登陆
	function checkOne()
	{
		document.form1.action="<%=basepath%>/loginAction_checkOne.action";
		document.form1.submit();
	}
	
	function getMessage()
	{
		var message = document.getElementById("message").value;
		var messages = document.getElementById("messages").value;
		if(message != "")
		{
			alert(message);
		}
		if(messages != "")
		{
			alert(messages);
		}
	}
	function regForeignCorp()
	{
		document.form1.action="<%=basepath%>/foreignCorpAction_foreignFlowChart.action";
		document.form1.submit();
	}
	
	
	
	$(function() {//下面的代码放在这个匿名函数里面，不会引起命名冲突
		var x = 0, y = 0;//控制起始位置
		var xin = true, yin = true;//从左上向右下 即初始状态为左侧和上侧碰撞
		var step = 1;//控制速度
		var delay = 15;//控制帧率
		var objOfFloatAd = $('#only_one_floatAd');//漂浮对象
		var closeOfFloatAd = $('#close_floatAd');//关闭按钮
		var Timer = setTimeout(adFloat, delay);
		function adFloat() {
			var L = T = 0;
			var R = $(window).width() - objOfFloatAd.width();
			var B = $(window).height() - objOfFloatAd.height();
			objOfFloatAd.css('left', x + $(document).scrollLeft());
			objOfFloatAd.css('top', y + $(document).scrollTop());
			x = x + step * (xin ? 1 : -1);
			if (x < L) {
				xin = true;//左侧碰撞
				x = L;
			}
			if (x > R) {
				xin = false;//右侧碰撞
				x = R;
			}
			y = y + step * (yin ? 1 : -1);
			if (y < T) {
				yin = true;//上侧碰撞
				y = T;
			}
			if (y > B) {
				yin = false;//下侧碰撞
				y = B;
			}
			Timer = setTimeout(adFloat, delay);
		}
		objOfFloatAd.hover(function() {
			closeOfFloatAd.show();//鼠标浮动在ad上时显示关闭按钮
			clearTimeout(Timer);
		}, function() {
			closeOfFloatAd.hide();//鼠标移出ad时隐藏关闭按钮
			clearTimeout(Timer);
			Timer = setTimeout(adFloat, delay);
		});
		$('#close_floatAd').click(function() {
			objOfFloatAd.hide();
			clearTimeout(Timer);
		});
	});
	
</script>
</head>
<body onload="getMessage()"
	style="background:#f0a093 url(<%=basepath%>/img/zhkeybg.jpg) no-repeat left top;background-size:cover;-webkit-background-size: cover;-moz-background-size: cover;
 -o-background-size: cover;">
 <div>
		<div style="height: 0px;"></div>
		<div id="only_one_floatAd" style="position: absolute">
		<img alt="" src="<%=basepath%>/img/tzbz.png">
		<!-- <h2 class="h2_01">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			停办换证申请通知</h2>
        	<p>各有关单位：</p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我厅将于2016年6月30日起停止受理建筑</p>
            <p>业企业资质换证申请，请未换证的企业抓紧办理。</p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            2016年6月20日</p> -->
			<span id="close_floatAd" style="display: none; position: absolute; right: 0; top: 0; font-family: Arial, Helvetica, sans-serif; color: #ff0000; cursor: default; padding: 3px;">X</span>
		</div>

	</div>
	<form id="form1" name="form1" method="post" action="">
		<div class="zhkey_wrap">
			<img src="<%=basepath%>/img/zhkey_01.png" />
			<p>
				<a href="#" onclick="checkOne()"><input type="image"
					src="<%=basepath%>/img/zhkey_02.png" /></a>
			</p>
			<ul class="zhkey_content f16">
				<a href="#" onclick="regCorp()"><li><img
						src="<%=basepath%>/img/xinqiyelr_03.png" /></li></a>
				<h3>新办理加密锁的企业，请先录入企业基本信息！</h3>
				<!-- <a href="#" onclick="regForeignCorp()" ><li>外商投资企业录入</li></a> -->
			</ul>
			<p style="font-size: 16px; color: #fff; text-align: center;">咨询群号：418426764（2群）	153741424(1群 已满)</p>
			<p style="font-size: 16px; color: #fff; text-align: center;">建筑管理处：53605394
				城建处：53633357 网络技术服务电话：53654718 行政许可服务中心：53670378</p>
			<ul class="wenjian">
				<a href="<%=basepath%>/downloadDrive/changefile/1.doc"><li>1.关于换发新版建筑业企业资质证书的通知</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/2.doc"><li>2.建筑业企业资质管理规定</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/3.doc"><li>3.建筑业企业资质标准</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/4.doc"><li>4.黑龙江省建筑业企业资质管理实施意见</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/4.1.xls"><li>4.1黑龙江省建筑业企业资质申报材料清单</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/4.2.doc"><li>4.2企业资质申请表</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/4.3.doc"><li>4.3建筑业企业资质证书变更、遗失补办申请审核表</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/4.4.xls"><li>4.4专业承包资质修订情况对照表</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/4.5.doc"><li>4.5新版建筑业企业资质证书编码规则</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/4.6.xls"><li>4.6工程设计资质与施工总承包资质类别对照表</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/5.doc"><li>5.建筑业企业资质管理规定和资质标准实施意见</li></a>
				<a href="<%=basepath%>/downloadDrive/changefile/6.doc"><li>6.住房城乡建设部办公厅关于换发新版建筑业企业资质证书的通知</li></a>
			</ul>
		</div>
		<input type="hidden" value="<s:property value="corp.message" />"
			id="message" /> <input type="hidden"
			value="<s:property value="message" />" id="messages" />

	</form>
</body>
</html>