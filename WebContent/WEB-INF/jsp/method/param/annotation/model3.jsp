<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    String requestURI = request.getRequestURI();
    String requestURL = request.getRequestURL().toString();
    String requestPath = basePath + request.getServletPath();
    String requestPathWithParams = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"?"+request.getQueryString();
    /*RequestDispatcher req = request.getRequestDispatcher("/model2?username=requestDispatcher222");
    String userAgent = request.getHeader("User-Agent");
    String authType = request.getAuthType();
    Cookie[] cookies = request.getCookies();
    request.getDateHeader("");*/


    request.setAttribute("basePath",basePath);
    request.setAttribute("requestURI",requestURI);
    request.setAttribute("requestURL",requestURL);
    request.setAttribute("requestPath",requestPath);
    request.setAttribute("requestPathWithParams",requestPathWithParams);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功</title>
</head>
<body>

<span class="aaa">requestURI: </span>${requestURI} <br>
<span class="aaa">requestURL: </span>${requestURL} <br>
<span class="aaa">basePath: </span>${basePath} <br>
<span class="aaa">requestPath: </span>${requestPath} <br>
<span class="aaa">requestPathWithParams: </span>${requestPathWithParams} <br> <br>
<%--TODO 获取请求相对路径 2018-04-11 16:21--%>

username:${user2.username } <br>
schoolInfo:${user2.schoolInfo.schoolName} ${user2.schoolInfo.schoolType} ${user2.schoolInfo.specialty} <br>


<style>
    .aaa{
        color: green;
        font-weight:bold;
    }
</style>

</body>
</html>