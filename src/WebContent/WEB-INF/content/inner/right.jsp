<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>建筑企业资质管理信息系统</title>

<script type="text/javascript"
	src="http://www.jb51.net/workspace/js/jquery-1.7.min.js"></script>
<script type="text/javascript">
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
<body style="background:#9999ff url(<%=basepath%>/img/welcome.jpg) no-repeat; margin:0 auto; background-size:cover;
 -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover;">
	<div>
		<div style="height: 1000px;"></div>
		<div id="only_one_floatAd" style="position: absolute">
		<h2 class="h2_01">通知</h2>
        	<p>根据国家、省对新资质换证要求，请各地市</p>
            <p>主管部门对企业的基本信息进行审核，确保</p>
            <p>报送省级受理部门的企业基本信息正确。</p>
            <p>对企业电子基本信息查询方式如下：</p>
            <p>点击企业信息登记，搜索企业信息进行查询核对。</p>
			<span id="close_floatAd" style="display: none; position: absolute; right: 0; top: 0; font-family: Arial, Helvetica, sans-serif; color: #ff0000; cursor: default; padding: 3px;">X</span>
		</div>

	</div>
</body>
</html>