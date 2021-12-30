<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title>ثبت اطلاعات مشتری جدید</title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script src="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-date/dist/persian-date.js"></script>
    <script src="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-datepicker/dist/js/persian-datepicker.js"></script>
    <script src="<c:url value="/static/js/validate-real-customer-registration.js"/>"></script>
    <script src="<c:url value="/static/js/validate-legal-customer-registration.js"/>"></script>
    <script src="<c:url value="/static/js/persian-utility.js"/>"></script>
    <script src="<c:url value="/static/js/validate-national-code.js"/>"></script>
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
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-customer"/>">ثبت نام مشتری جدید</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/customers"/>">لیست مشتریان</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-type"/>">ثبت نوع تسهیلات جدید</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-file"/>">تشکیل پرونده تسهیلاتی</a>
</nav>

<div class="customer-type" style="margin: 100px auto 0 auto">
    <input type="button" class="btn btn-light" id="real-customer-button" value="مشتری حقیقی" onclick="showRealCustomerRegistrationFrom()">
    <input type="button" class="btn btn-light" id="legal-customer-button" value="مشتری حقوقی" onclick="showLegalCustomerRegistrationFrom()">
</div>

<div class="container rounded-3" style="margin: 0 auto 100px auto">
    <div id="real-customer-form">
        <div class="alert alert-primary" role="alert">
            <h5> اطلاعات مشتری حقیقی را جهت ثبت نام با دقت وارد کنید </h5>
        </div>

        <form:form name="registration-form"
                   modelAttribute="customer"
                   method="post"
                   action="/save-real-customer"
                   onsubmit="return validateRealCustomerRegistrationForm()">
            <table class="table" dir="rtl">
                <tbody>
                <tr>
                    <td>نوع مشتری</td>
                    <td>
                        <label>
                            <input type="text" value="حقیقی" readonly onclick="alert('فیلد نوع مشتری قابل تغییر نیست!')"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>نام</td>
                    <td>
                        <form:label path="name">
                            <form:input path="name" id="firstName" type="text"/>
                        </form:label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div id="firstNameError" class="alert alert-danger" role="alert" style="display: none"></div>
                    </td>
                </tr>
                <tr>
                    <td>نام خانوادگی</td>
                    <td>
                        <form:label path="lastName">
                            <form:input path="lastName" id="lastName" type="text"/>
                        </form:label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div id="lastNameError" class="alert alert-danger" role="alert" style="display: none"></div>
                    </td>
                </tr>
                <tr>
                    <td>نام پدر</td>
                    <td>
                        <form:label path="fatherName">
                            <form:input path="fatherName" id="fatherName" type="text"/>
                        </form:label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div id="fatherNameError" class="alert alert-danger" role="alert" style="display: none"></div>
                    </td>
                </tr>
                <tr>
                    <td>تاریخ تولد</td>
                    <td>
                        <form:label path="date">
                            <form:input path="date" type="text" id="birthDate" class="birth-date" />
                        </form:label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div id="birthDateError" class="alert alert-danger" role="alert" style="display: none"></div>
                    </td>
                </tr>
                <tr>
                    <td>کد ملی</td>
                    <td>
                        <form:label path="code">
                            <form:input path="code" type="text" id="nationalCode"/>
                        </form:label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                            <%--@elvariable id="duplicateRealCustomerException" type="String"--%>
                        <c:set var="duplucateCustomer" value="${duplicateRealCustomerException}"/>
                        <c:if test="${duplucateCustomer.length() > 0}">
                            <div class="alert alert-danger" role="alert">
                                    ${duplucateCustomer}
                            </div>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div id="nationalCodeError" class="alert alert-danger" role="alert" style=" display: none"></div>
                    </td>
                </tr>
                <tr>
                    <td rowspan="2">
                        <input type="submit" class="btn btn-success" value="ثبت">
                        <button type="button" class="btn btn-danger">
                            <a href="<c:url value="/"/>">انصراف</a>
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form:form>
    </div>

    <div id="legal-customer-form" style="display: none">
        <div class="alert alert-primary" role="alert">
            <h5> اطلاعات مشتری حقوقی را جهت ثبت نام با دقت وارد کنید </h5>
        </div>

        <form:form name="registration-form"
                   modelAttribute="customer"
                   method="post"
                   action="/save-legal-customer"
                   onsubmit="return validateLegalCustomerRegistrationForm()">
            <table class="table" dir="rtl">
                <tbody>
                <tr>
                    <td>نوع مشتری</td>
                    <td>
                        <label>
                            <input type="text" value="حقوقی" readonly onclick="alert('فیلد نوع مشتری قابل تغییر نیست!')"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>نام شرکت</td>
                    <td>
                        <form:label path="name">
                            <form:input path="name" id="companyName" type="text"/>
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
                        <form:label path="date">
                            <form:input path="date" type="text" id="registrationDate" class="registration-date" />
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
                        <form:label path="code">
                            <form:input path="code" type="text" id="economicCode"/>
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
                        <input type="submit" class="btn btn-success" value="ثبت">
                        <button type="button" class="btn btn-danger">
                            <a href="<c:url value="/"/>">انصراف</a>
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form:form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $(".birth-date").persianDatepicker({
            format: 'YYYY/MM/DD',
            initialValue: false
        });
    });

    $(document).ready(function() {
        $(".registration-date").persianDatepicker({
            format: 'YYYY/MM/DD',
            initialValue: false
        });
    });

    function showRealCustomerRegistrationFrom() {
        document.getElementById('legal-customer-button').style.color = '#743ad5';
        document.getElementById('legal-customer-button').style.backgroundColor = '#FFFFFF';
        document.getElementById('real-customer-button').style.color = '#FFFFFF';
        document.getElementById('real-customer-button').style.backgroundColor = '#743ad5';
        document.getElementById('real-customer-form').style.display = 'block';
        document.getElementById('legal-customer-form').style.display = 'none';
    }

    function showLegalCustomerRegistrationFrom() {
        document.getElementById('real-customer-button').style.color = '#743ad5';
        document.getElementById('real-customer-button').style.backgroundColor = '#FFFFFF';
        document.getElementById('legal-customer-button').style.color = '#FFFFFF';
        document.getElementById('legal-customer-button').style.backgroundColor = '#743ad5';
        document.getElementById('real-customer-form').style.display = 'none';
        document.getElementById('legal-customer-form').style.display = 'block';
    }
</script>
</body>
</html>
