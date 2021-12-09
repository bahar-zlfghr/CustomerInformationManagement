<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.dotin.service.component.DigitConverterComponent" %>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title>مدیریت اطلاعات مشتری</title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.rtl.min.css" rel="stylesheet">
    <link rel="icon" type="image/ico" href="<c:url value="/static/img/logo.png"/>">
    <link href="<c:url value="/static/css/main.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/alert-style.css"/>" rel="stylesheet"/>
</head>
<body>
    <div class="container rounded-3">
        <c:if test="${saveCustomerSuccessMessage.length() > 0}">
            <div class="alert alert-success" role="alert">
                <h5> ${saveCustomerSuccessMessage} </h5>
            </div>
        </c:if>

        <c:if test="${sessionScope.customerNumberMessage.length() > 0}">
            <div class="alert alert-info" role="alert">
                <h5>
                    <%
                        out.print(DigitConverterComponent.convertDigitsEnToFa(
                                String.valueOf(session.getAttribute("customerNumberMessage"))));
                        session.removeAttribute("customerNumberMessage");
                    %>
                </h5>
            </div>
        </c:if>

        <div class="alert alert-primary" role="alert">
            <h5> نوع مشتری مورد نظر را انتخاب کنید </h5>
        </div>

        <button type="button" class="btn btn-outline-primary">
            <a href="<c:url value="/save-individual-customer"/>">مشتری حقیقی</a>
        </button>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
