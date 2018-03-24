<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String scheme = request.getScheme();
    String serverName = request.getServerName();
    int serverPort = request.getServerPort();

    request.setAttribute("contextPath", path);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户新增</title>

</head>
<body>

    <div>
        basePath:<%=basePath%> <br>

        request.getScheme():<%=scheme%> <br/>
        request.getServerName():<%=serverName%> <br/>
        request.getServerPort():<%=serverPort%> <br/>
        request.getContextPath():<%=path%> <br/>

        contextPath:${contextPath}

    </div>
    <form method="post"  action="${basePath}methodOr">

        客户名：<input type="text" name="username"/><br/>
        密码：<input type="text" name="password"/><br/>
        <input type="submit" value="新增2"/>
    </form>
</body>
</html>