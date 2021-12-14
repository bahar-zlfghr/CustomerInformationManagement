<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title>لیست مشتریان</title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <script src="<c:url value="/static/js/persian-utility.js"/>"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.rtl.min.css" rel="stylesheet">
    <link rel="icon" type="image/ico" href="<c:url value="/static/img/logo.png"/>">
    <link href="<c:url value="/static/css/main.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/alert-style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/customers-table.css"/>" rel="stylesheet"/>
</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row border-gradient border-gradient-purple">
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/"/>">صفحه اصلی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-real-customer"/>">ثبت نام مشتری حقیقی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-legal-customer"/>">ثبت نام مشتری حقوقی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/customers"/>">لیست مشتریان</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/customers"/>">به روز رسانی اطلاعات مشتریان</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/customers"/>">حذف اطلاعات مشتریان</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/customers"/>">جستجو میان مشتریان</a>
</nav>

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
                        <td>${realCustomer.firstName}</td>
                        <td>${realCustomer.lastName}</td>
                        <td>${realCustomer.fatherName}</td>
                        <td>${realCustomer.birthDate}</td>
                        <td>${realCustomer.nationalCode}</td>
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
                <h5> هیچ مشتری حقیقی در سیستم وجود ندارد! </h5>
            </div>
        </c:otherwise>
    </c:choose>
</div>
<div class="container rounded-3">
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
        <h5> جدول مشتریان حقوقی </h5>
    </div>
    <c:choose>
        <c:when test="${legalCustomers.size() != 0}">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th>نوع</th>
                    <th>نام شرکت</th>
                    <th>کد اقتصادی</th>
                    <th>تاریخ ثبت</th>
                    <th>شماره مشتری</th>
                    <th>به روز رسانی</th>
                    <th>حذف</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="legalCustomer" items="${legalCustomers}">
                    <tr>
                        <td>حقوقی</td>
                        <td>${legalCustomer.companyName}</td>
                        <td>${legalCustomer.economicCode}</td>
                        <td>${legalCustomer.registrationDate}</td>
                        <td>${legalCustomer.customerNO}</td>
                        <td>
                            <button type="button" class="btn btn-info">
                                <a href="<c:url value="/update-legal-customer/${legalCustomer.customerNO}"/>">به روز رسانی</a>
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger">
                                <a href="<c:url value="/delete-legal-customer/${legalCustomer.customerNO}"/>">حذف</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-light" role="alert">
                <h5> هیچ مشتری حقوقی در سیستم وجود ندارد! </h5>
            </div>
        </c:otherwise>
    </c:choose>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
