<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title>ثبت نوع تسهیلات جدید</title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script src="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-date/dist/persian-date.js"></script>
    <script src="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-datepicker/dist/js/persian-datepicker.js"></script>
    <script src="<c:url value="/static/js/validate-loan-type-creation.js"/>"></script>
    <script src="<c:url value="/static/js/persian-utility.js"/>"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.rtl.min.css" rel="stylesheet">
    <link href="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-datepicker/dist/css/persian-datepicker.css" rel="stylesheet"/>
    <link rel="icon" type="image/ico" href="<c:url value="/static/img/logo.png"/>">
    <link href="<c:url value="/static/css/main.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/table-style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/alert-style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/form-style.css"/>" rel="stylesheet"/>
</head>
<body style="flex-direction: column">
<nav class="nav nav-pills flex-column flex-sm-row border-gradient border-gradient-purple">
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/"/>">صفحه اصلی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-customer"/>">ثبت نام مشتری جدید</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/customers"/>">لیست مشتریان</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-type"/>">ثبت نوع تسهیلات جدید</a>
</nav>

<div class="container rounded-3" style="margin: 100px auto">
    <div class="alert alert-primary" role="alert">
        <h5> اطلاعات نوع تسهیلات را جهت ثبت با دقت وارد کنید </h5>
    </div>

    <form:form modelAttribute="loanType"
               method="get"
               action="/save-grant-condition"
               onsubmit="return validateLoanTypeCreationForm()">
        <table class="table" dir="rtl">
            <tbody>
            <tr>
                <td>نام نوع تسهیلات</td>
                <td>
                    <form:label path="name">
                        <form:input path="name" id="name" type="text"/>
                    </form:label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="nameError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td>نرخ سود</td>
                <td>
                    <form:label path="interestRate">
                        <form:input path="interestRate" type="text" id="interestRate" />
                    </form:label>
                </td>
                <td>درصد</td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="interestRateError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td rowspan="2">
                    <input type="submit" class="btn btn-success" value="ادامه">
                    <button type="button" class="btn btn-danger">
                        <a href="<c:url value="/"/>">انصراف</a>
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
