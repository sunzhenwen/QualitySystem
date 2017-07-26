<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>驱动安装说明</title>
</head>
<body style="background:#eeeeee;">
    <div class="qudongmain">
    <h2>加密锁驱动问题</h2>
    
    
    <h3>一、驱动</h3>
    <h3 style="color:#ff0008;">特别注意:安装驱动或卸载驱动时，务必将加密锁从电脑上拔出。</h3>
    <h4>白锁(ET99)驱动：</h4>
     
    <h5>旧版驱动：[<a style="color:#ff0008;" href="<%=basepath %>/downloadDrive/driveInstructions/white/xp/USBKEY.exe">XP推荐</a>]
    </h5>
    <h5>新版驱动：[<a style="color:#ff0008;" href="<%=basepath %>/downloadDrive/driveInstructions/white/win7/ET99Setup.zip">Win7/Win8推荐</a>]</h5>
     
    
    <h3>二、驱动文件说明</h3>
    <h5>如果您使用的是windows xp及以前版本操作系统，推荐使用<b>旧版</b>驱动。</h5>
    <h5>如果您使用的是windows 7/windows 8 32位或64位操作系统，推荐使用<b>新版</b>驱动。</h5>
    <h5>注意：windows7操作系统在安装新版驱动时可能会出现驱动安装失败或无法安装的情况，出现这种情况可以尝试将新版驱动删除掉后，安装旧版驱动。</h5>
     
    
    <h3>三、驱动安装成功</h3>
    <h5>安装成功后，在桌面右下方状态栏中会出现（如图1、图2）：</h5>
    <h6><img src="<%=basepath %>/img/dog_icon_1.jpg">图1-(xp)</h6>
    <h6><img src="<%=basepath %>/img/dog_icon_2.jpg">图2-(win7/win8)</h6>
     
    
    <h3>四、使用</h3>
    <h5>windows xp系统，直接插锁即可会出现(如图3)：</h5>
    <h6><img src="<%=basepath %>/img/dog2.jpg">图3</h6>
    <h5>windows 
    7/windows8系统，插锁后，如果第一次插入该USB口，系统会针对该USB口进一步安装驱动（如图4）。这个安装过程可能用时比较长,请等待安装完成。安装成功后，出现图3提示。</h5>
    <h6><img src="<%=basepath %>/img/dog1.jpg">图4</h6>
     
    
    <h3>五、安装驱动后无法登陆</h3>
    <h5>如出现下图(如图5)：</h5>
    <h6><img src="<%=basepath %>/img/dog5.jpg">图5</h6>
    <h5>首先请选择IE的internet选项功能，如下图红色标记。</h5>
    <h6><img src="<%=basepath %>/img/dog6.jpg">图6</h6>
    <h5>之后选择"安全"页签，然后选中"受信任的站点"，然后点"站点"按钮，见图红色标记。</h5>
    <h6><img src="<%=basepath %>/img/dog7.jpg">图7</h6>
    <h5>之后在下面的页面中，点"添加"按钮。在点"添加"按钮前，请先确认Https?验证被取消。见下图红色标记。</h5>
    <h6><img src="<%=basepath %>/img/dog8.jpg">图8</h6>
    <h5>以上操作完成后，再刷新该页面，或者重新打开IE输入注册地址刷新，会出现下面的界面，证明设置成功。可以点"是(Y)"按钮继续安装所需要的ActiveX控件。</h5>
    <h6><img src="<%=basepath %>/img/dog9.jpg">图9</h6>
    <h5>如果浏览器开启弹出窗口拦截，请注意拦截提示</h5>
    <h6><img src="<%=basepath %>/img/dog10.jpg">图10</h6>
    <h5>在弹出拦截栏上右键选择运行ActiveX控件</h5>
    <h6><img src="<%=basepath %>/img/dog11.jpg">图11</h6>
    <h6><img src="<%=basepath %>/img/dog12.jpg">图12</h6>
    <h5>还是无法登陆可以修改IE受信任站点的安全级别(此项可选：工具—&gt;Internet选项—&gt;安全—受信任站点—&gt;自定义级别—&gt;启用ActiveX控件或插件)</h5>
    <h6><img src="<%=basepath %>/img/dog13.jpg">图13</h6>
    <h5>修改后刷新即可登陆</h5>
     
    </div>
</body>
</html>