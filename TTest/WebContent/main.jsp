<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<style>
        body{
				background-image: url(images/banner.png);
				background-repeat: no-repeat;
				background-size: cover;/* 自适应窗口，会把图片拉伸足够大，但是部分图片会显示不全 */
			}
#rig{
text-align: right;
font-size: 8px;

}
#menu{
padding: 35px 20px 0 0

}
#menu ul {
    float: right;
    list-style: none;
    margin: 0px;
}
#menu ul li {
    float: left;
    display: block;
    line-height: 30px;
    margin: 0 10px
}
#menu ul li a {
    font-weight: bold;
    color: #666
}
.menuDiv {
    width: 1px;
    height: 28px;
    background: #999
}
    </style>
<body>
<%
	if(session.getAttribute("uname")==null){
%>
<script type="text/javascript">
	 window.location.href='error.jsp';
</script>

<%

return;
}
%>
<div id="rig">
 <h1>欢迎你：${sessionScope.uname}
 		<c:if test="${sessionScope.uname== 'admin' }">
	    				【管理员】
	    </c:if>
	    
 <a href="javascript:void(0);" onclick="out();">安全退出</a></h1>
 </div>
   <div id="menu">
    <ul>
    <li>
    <a href="Download">资源下载</a>
    </li>
    <li class="menuDiv"></li>
    <li>
    <a href="userManage.jsp">用户管理</a>
    </li>
    </li>
    <li class="menuDiv"></li>
    <li>
    <a href="downloadManage.jsp">资源管理</a>
    </li>
     </li>
    <li class="menuDiv"></li>
    <li>
    <a href="user.jsp">个人中心</a>
    </li>
    
    </ul>
    
    </div>
</body>
<script>
	
	window.setInterval(function dl(){
		
	    if(session.getAttribute("userName")!=null){
	    	alert(second);
	    	}
	},100);
</script>
</html>
