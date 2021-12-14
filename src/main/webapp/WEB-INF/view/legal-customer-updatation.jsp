<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title>به روز رسانی اطلاعات مشتری حقیقی</title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script src="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-date/dist/persian-date.js"></script>
    <script src="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-datepicker/dist/js/persian-datepicker.js"></script>
    <script src="<c:url value="/static/js/validate-legal-customer-registration.js"/>"></script>
    <script src="<c:url value="/static/js/persian-utility.js"/>"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.rtl.min.css" rel="stylesheet">
    <link href="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-datepicker/dist/css/persian-datepicker.css" rel="stylesheet"/>
    <link rel="icon" type="image/ico" href="<c:url value="/static/img/logo.png"/>">
    <link href="<c:url value="/static/css/main.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/table-style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/datepicker.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/alert-style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/form-style.css"/>" rel="stylesheet"/>
</head>
<body style="flex-direction: column">
<nav class="nav nav-pills flex-column flex-sm-row border-gradient border-gradient-purple">
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/"/>">صفحه اصلی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-real-customer"/>">ثبت نام مشتری حقیقی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-legal-customer"/>">ثبت نام مشتری حقوقی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/real-customers"/>">لیست مشتریان حقیقی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/legal-customers"/>">لیست مشتریان حقوقی</a>
</nav>

<div class="container rounded-3" style="margin: 100px auto">
    <div class="alert alert-primary" role="alert">
        <h5> اطلاعات زیر را به دقت وارد کنید </h5>
    </div>

    <form:form name="registration-form"
               modelAttribute="legalCustomer"
               method="post"
               action="/update-legal-customer"
               onsubmit="return validateLegalCustomerRegistrationForm()">
        <table class="table" dir="rtl">
            <tbody>
            <tr>
                <td>نوع مشتری</td>
                <td>
                    <label>
                        <input type="text" value="حقوقی" disabled/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>شماره مشتری</td>
                <td>
                    <form:label path="customerNO">
                        <form:input path="customerNO" type="text" readonly="true"/>
                    </form:label>
                </td>
            </tr>
            <tr>
                <td>نام شرکت</td>
                <td>
                    <form:label path="companyName">
                        <form:input path="companyName" id="companyName" type="text"/>
                    </form:label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="companyNameError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td>تاریخ ثبت</td>
                <td>
                    <form:label path="registrationDate">
                        <form:input path="registrationDate" type="text" id="registrationDate" class="registration-date" />
                    </form:label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="registrationDateError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td>کد اقتصادی</td>
                <td>
                    <form:label path="economicCode">
                        <form:input path="economicCode" type="text" id="economicCode"/>
                    </form:label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                        <%--@elvariable id="duplicateLegalCustomerException" type="String"--%>
                    <c:set var="duplucateCustomer" value="${duplicateLegalCustomerException}"/>
                    <c:if test="${duplucateCustomer.length() > 0}">
                        <div class="alert alert-danger" role="alert">
                                ${duplucateCustomer}
                        </div>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="economicCodeError" class="alert alert-danger" role="alert" style=" display: none"></div>
                </td>
            </tr>
            <tr>
                <td rowspan="2">
                    <input type="submit" class="btn btn-success" value="به روز رسانی">
                    <button type="button" class="btn btn-danger">
                        <a href="<c:url value="/legal-customers"/>">انصراف</a>
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $(".registration-date").persianDatepicker({
            format: 'YYYY/MM/DD',
            initialValue: false
        });
    });

    $(function () {
        $('[id*=economicCode]').keyup(function () {
            $('[id*=economicCode]').val(toPersianNumber($(this).val()));
        });
    });
</script>
</body>
</html>
