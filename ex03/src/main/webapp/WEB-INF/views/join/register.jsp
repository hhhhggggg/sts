<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@include file="../includes/header.jsp"%>

<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title" style="text-align:center;">회원가입</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/join/register" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="아이디" name="id" type="text" autofocus>
                                </div>
                                <c:if test="${not empty msg}">
                                <div style="color:red; text-align:center; margin-bottom:15px;">${msg}</div>
                                </c:if>
                                <div class="form-group">
                                    <input class="form-control" placeholder="비밀번호" name="pw" type="password" value="">
                                </div>
                                <c:if test="${not empty msg2}">
                                <div style="color:red; text-align:center; margin-bottom:15px;">${msg2}</div>
                                </c:if>
                                <div class="form-group">
                                    <input class="form-control" placeholder="이름" name="name" type="text" value="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="이메일" name="email" type="email" value="">
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-lg btn-success btn-block">가입하기</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@include file="../includes/footer.jsp"%>
    
    