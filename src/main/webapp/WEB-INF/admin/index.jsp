<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>后台管理系统</title>
	<%
    	String path = request.getContextPath();
    %>
    <script src="${path }/js/jquery1.10.js"></script>
	<link href='${path }/images/favicon.ico' rel='shortcut icon' type='image/x-icon' />
 	<link href="${path }/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<!-- js引入 -->
    <script src="${path }/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${path }/js/zeroModal/zeroModal.css" />
</head>
	<frameset rows="15%, *" frameborder="0">
    	<frame src="${path }/adminhead" name="head" noresize="noresize" />
    	<frameset cols="15%, *" frameborder="0">
    		<frame src="${path }/adminleft" name="left" noresize="noresize" />
    		<frameset rows="7%, *">
	    		<frame src="${path }/adminnav" name="nav" noresize="noresize" />
	    		<frame src="${path }/adminhome" name="right" noresize="noresize" />
    		</frameset>
    	</frameset>
    </frameset>
</html>