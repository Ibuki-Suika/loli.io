<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="../taglib.jsp" />

<nav id="top" class="navbar navbar-default navbar-static-top" role="navigation">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">点击下拉</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
        class="icon-bar"></span>
    </button>

    <a class="navbar-brand title" href="${pageContext.request.contextPath}/">萝莉图床</a>
  </div>

  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/pan" class="title">网盘</a></li>
      <li><a href="${pageContext.request.contextPath}/" class="title">图床</a></li>
    </ul>

    <ul class="nav navbar-nav navbar-right">
      <c:if test="${sessionScope.user eq null}">
        <li><a href="${pageContext.request.contextPath}/user/regist" class="title">注册</a></li>
        <li><a href="${pageContext.request.contextPath}/user/login" class="title">登陆</a></li>
      </c:if>
      <c:if test="${sessionScope.user!=null}">
        <li><a href="#" class="title dropdown-toggle" data-toggle="dropdown">${sessionScope.user.email} <b
            class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/user/edit">个人资料</a></li>
            <li><a href="${pageContext.request.contextPath}/img/list">查看已上传图片</a></li>
          </ul></li>

        <li><a href="${pageContext.request.contextPath}/user/logout" class="title">登出</a></li>
      </c:if>
    </ul>
  </div>
</nav>