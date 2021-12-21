<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title>لیست مشتریان حقیقی</title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script src="<c:url value="/static/js/persian-utility.js"/>"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.rtl.min.css" rel="stylesheet">
    <link rel="icon" type="image/ico" href="<c:url value="/static/img/logo.png"/>">
    <link href="<c:url value="/static/css/main.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/alert-style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/customers-table.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/search-style.css"/>" rel="stylesheet"/>
</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row border-gradient border-gradient-purple">
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/"/>">صفحه اصلی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-real-customer"/>">ثبت نام مشتری حقیقی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-legal-customer"/>">ثبت نام مشتری حقوقی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/real-customers"/>">لیست مشتریان حقیقی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/legal-customers"/>">لیست مشتریان حقوقی</a>
</nav>

<div class="container rounded-3" style="width: 25%">
    <div class="alert alert-primary" role="alert">
        <h5> جستجو </h5>
    </div>

    <form id="search-form">
        <table class="table" dir="rtl" style="border: #FFFFFF">
            <tbody>
            <tr>
                <td>نام</td>
                <td>
                    <label><input type="text" name="firstName" id="firstName"/></label>
                </td>
            </tr>
            <tr>
                <td>نام خانوادگی</td>
                <td>
                    <label><input type="text" name="lastName" id="lastName"/></label>
                </td>
            </tr>
            <tr>
                <td>کد ملی</td>
                <td>
                    <label><input type="text" name="nationalCode" id="nationalCode"/></label>
                </td>
            </tr>
            <tr>
                <td>شماره مشتری</td>
                <td>
                    <label><input type="text" name="customerNO" id="customerNO"/></label>
                </td>
            </tr>
            <tr>
                <td>
                    <input class="btn btn-info" type="submit" id="search-button" value="جستجو"/>
                </td>
                <td>
                    <button class="btn btn-info">
                        <a href="<c:url value="/real-customers"/>">همه مشتریان حقیقی</a>
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<div class="container rounded-3">
    <c:if test="${sessionScope.realCustomerNotFoundException.length() > 0}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <h5>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    ${sessionScope.realCustomerNotFoundException}
            </h5>
            <%
                session.removeAttribute("realCustomerNotFoundException");
            %>
        </div>
    </c:if>

    <c:if test="${sessionScope.updateRealCustomerSuccessMessage.length() > 0}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <h5>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    ${sessionScope.updateRealCustomerSuccessMessage}
            </h5>
            <%
                session.removeAttribute("updateRealCustomerSuccessMessage");
            %>
        </div>
    </c:if>

    <c:if test="${sessionScope.deleteRealCustomerSuccessMessage.length() > 0}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            <h5> ${sessionScope.deleteRealCustomerSuccessMessage} </h5>
            <%
                session.removeAttribute("deleteRealCustomerSuccessMessage");
            %>
        </div>
    </c:if>

    <div class="alert alert-primary" role="alert">
        <h5> جدول مشتریان حقیقی </h5>
    </div>
    <c:choose>
        <c:when test="${realCustomers.size() > 0}">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th>نوع</th>
                    <th>نام</th>
                    <th>نام خانوادگی</th>
                    <th>نام پدر</th>
                    <th>تاریخ تولد</th>
                    <th>کد ملی</th>
                    <th>شماره مشتری</th>
                    <th>به روز رسانی</th>
                    <th>حذف</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="realCustomer" items="${realCustomers}">
                    <tr>
                        <td>حقیقی</td>
                        <td>${realCustomer.name}</td>
                        <td>${realCustomer.lastName}</td>
                        <td>${realCustomer.fatherName}</td>
                        <td>${realCustomer.date}</td>
                        <td>${realCustomer.code}</td>
                        <td id="real-customerNO">${realCustomer.customerNO}</td>
                        <td>
                            <button type="button" class="btn btn-info">
                                <a href="<c:url value="/update-real-customer/${realCustomer.customerNO}"/>">به روز رسانی</a>
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger">
                                <a href="<c:url value="/delete-real-customer/${realCustomer.customerNO}"/>">حذف</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-light" role="alert">
                <h5> هیچ مشتری حقیقی در سیستم یافت نشد! </h5>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
    $(function () {
        $('[id*=nationalCode]').keyup(function () {
            $('[id*=nationalCode]').val(toPersianNumber($(this).val()));
        });
        $('[id*=customerNO]').keyup(function () {
            $('[id*=customerNO]').val(toPersianNumber($(this).val()));
        });
    });

    $("#search-button").on("click", function() {
        $.ajax({
            type: "GET",
            url: "/real-customers?" + $.param({
                "firstName": document.getElementById('firstName').value,
                "lastName": document.getElementById('lastName').value,
                "nationalCode": document.getElementById('nationalCode').value,
                "customerNO": document.getElementById('customerNO').value
            }),
            dataType : 'json',
            contentType: 'application/json'
        });
    });
</script>
</body>
</html>
