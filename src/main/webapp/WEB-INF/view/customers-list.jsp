<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title>لیست مشتریان</title>
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
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-customer"/>">ثبت نام مشتری جدید</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/customers"/>">لیست مشتریان</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-type"/>">ثبت نوع تسهیلات جدید</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-file"/>">تشکیل پرونده تسهیلاتی</a>
</nav>

<div class="container rounded-3" style="width: 25%">
    <div class="alert alert-primary" role="alert">
        <h5> جستجو </h5>
    </div>

    <form id="search-form">
        <table class="table" dir="rtl" style="border: #FFFFFF">
            <tbody>
            <tr>
                <td>نام فرد / شرکت</td>
                <td>
                    <label><input type="text" name="name" id="name"/></label>
                </td>
            </tr>
            <tr>
                <td>نام خانوادگی</td>
                <td>
                    <label><input type="text" name="lastName" id="lastName"/></label>
                </td>
            </tr>
            <tr>
                <td>کد ملی / اقتصادی</td>
                <td>
                    <label><input type="text" name="code" id="code"/></label>
                </td>
            </tr>
            <tr>
                <td>شماره مشتری</td>
                <td>
                    <label><input type="text" name="customerNO" id="customerNO"/></label>
                </td>
            </tr>
            <tr>
                <td>نوع مشتری</td>
                <td>
                    <label>
                        <select class="form-select" name="customerType" id="customerType">
                            <option value="" selected style="font-family: Vazir-Regular">نوع مشتری را انتخاب کنید</option>
                            <option value="0" style="font-family: Vazir-Regular">حقیقی</option>
                            <option value="1" style="font-family: Vazir-Regular">حقوقی</option>
                        </select>
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <input class="btn btn-info" type="submit" id="search-button" value="جستجو"/>
                </td>
                <td>
                    <button class="btn btn-info">
                        <a href="<c:url value="/customers"/>">همه مشتریان</a>
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

    <c:if test="${sessionScope.legalCustomerNotFoundException.length() > 0}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <h5>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    ${sessionScope.legalCustomerNotFoundException}
            </h5>
            <%
                session.removeAttribute("legalCustomerNotFoundException");
            %>
        </div>
    </c:if>

    <c:if test="${sessionScope.updateLegalCustomerSuccessMessage.length() > 0}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <h5>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    ${sessionScope.updateLegalCustomerSuccessMessage}
            </h5>
            <%
                session.removeAttribute("updateLegalCustomerSuccessMessage");
            %>
        </div>
    </c:if>

    <c:if test="${sessionScope.deleteLegalCustomerSuccessMessage.length() > 0}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            <h5> ${sessionScope.deleteLegalCustomerSuccessMessage} </h5>
            <%
                session.removeAttribute("deleteLegalCustomerSuccessMessage");
            %>
        </div>
    </c:if>

    <div class="alert alert-primary" role="alert">
        <h5> جدول مشتریان </h5>
    </div>
    <c:choose>
        <c:when test="${customers.size() > 0}">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th>نوع</th>
                    <th>نام فرد / شرکت</th>
                    <th>نام خانوادگی</th>
                    <th>نام پدر</th>
                    <th>تاریخ تولد / ثبت</th>
                    <th>کد ملی / اقتصادی</th>
                    <th>شماره مشتری</th>
                    <th>به روز رسانی</th>
                    <th>حذف</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.customerType}</td>
                        <td>${customer.name}</td>
                        <c:if test='${customer.customerType.equals("حقیقی")}'>
                            <td>${customer.lastName}</td>
                            <td>${customer.fatherName}</td>
                        </c:if>
                        <c:if test='${customer.customerType.equals("حقوقی")}'>
                            <td>_</td>
                            <td>_</td>
                        </c:if>
                        <td>${customer.date}</td>
                        <td>${customer.code}</td>
                        <td>${customer.customerNO}</td>
                        <c:if test='${customer.customerType.equals("حقیقی")}'>
                            <td>
                                <button type="button" class="btn btn-info">
                                    <a href="<c:url value="/update-real-customer/${customer.customerNO}"/>">به روز رسانی</a>
                                </button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger">
                                    <a href="<c:url value="/delete-real-customer/${customer.customerNO}"/>">حذف</a>
                                </button>
                            </td>
                        </c:if>
                        <c:if test='${customer.customerType.equals("حقوقی")}'>
                            <td>
                                <button type="button" class="btn btn-info">
                                    <a href="<c:url value="/update-legal-customer/${customer.customerNO}"/>">به روز رسانی</a>
                                </button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger">
                                    <a href="<c:url value="/delete-legal-customer/${customer.customerNO}"/>">حذف</a>
                                </button>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-light" role="alert">
                <h5> هیچ مشتری در سیستم یافت نشد! </h5>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">

    $("#search-button").on("click", function() {
        $.ajax({
            type: "GET",
            url: "/customers?" + $.param({
                "name": document.getElementById('firstName').value,
                "lastName": document.getElementById('lastName').value,
                "code": document.getElementById('code').value,
                "customerNO": document.getElementById('customerNO').value,
                "customerType": document.getElementById('customerType').value
            }),
            dataType : 'json',
            contentType: 'application/json'
        });
    });
</script>
</body>
</html>
