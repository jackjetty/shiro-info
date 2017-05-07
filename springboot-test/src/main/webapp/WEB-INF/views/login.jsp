<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Login - JSP</title> 
    <script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>  
</head>  
  
  
<body> 
  <form method="post" action="${ctx}/login.do"> 
    <center>  
         用户名：<input name="username" type="text" value="abby"></input> 
         <br>
         密码：<input name="password" type="password" value="password"></input> 
         <br>
         <button name="submit">登录</button>
    </center>  
  </form>    
     
      
    <script>  
        $(function(){  
            $('#title').click(function(){  
                alert($(this).text());  
            });  
        })  
    </script>  
</body>  
</html>  