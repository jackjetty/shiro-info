<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Spring Boot Demo - JSP</title>  
    <script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>  
</head>  
  
  
<body>  

<shiro:guest>  
    Hi there!  Please <a href="login.jsp">Login</a> or <a href="signup.jsp">Signup</a> today!  
</shiro:guest>  
<shiro:authenticated>  
    <a href="updateAccount.jsp">Update your contact information</a>.  
</shiro:authenticated>  
Hello, <shiro:principal/>, how are you today?  
<shiro:hasRole name="administrator">  
    <a href="admin.jsp">Administer the system</a>  
</shiro:hasRole>  
<shiro:hasPermission name="user:create">  
    <a href="createUser.jsp">Create a new User</a>  
</shiro:hasPermission>  
    <center>  
        <h1 id="title">${title}</h1>  
    </center>  
    <div style="align-text:center;">
         <a href="javascript:fnRole();">权限</a>
         <br/>
         <br/>
         <button name="btn_logout">退出</button>
       
    </div>
      
    
      
    
</body> 
 <script language="javascript">  
        $(function(){  
            $('#title').click(function(){  
                alert($(this).text());  
            });  
        }) ;
        $("button[name=btn_logout]").click(function(){
        	 location.href="${ctx}/logout.do";
        });
</script>    
</html>
