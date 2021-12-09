<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title>مدیریت اطلاعات مشتری</title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.rtl.min.css" rel="stylesheet">
    <link rel="icon" type="image/ico" href="<c:url value="/static/img/logo.png"/>">
    <link href="<c:url value="/static/css/main.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/alert-style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/customers-table.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="container rounded-3">
    <c:if test="${sessionScope.deleteIndividualCustomerSuccessMessage.length() > 0}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            <h5> ${sessionScope.deleteIndividualCustomerSuccessMessage} </h5>
            <%
                session.removeAttribute("deleteIndividualCustomerSuccessMessage");
            %>
        </div>
    </c:if>

    <div class="alert alert-primary" role="alert">
        <h5> جدول مشتریان حقیقی </h5>
    </div>
    <c:choose>
        <c:when test="${individualCustomers.size() != 0}">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th>نوع</th>
                    <th>نام</th>
                    <th>نام خانوادگی</th>
                    <th>کد ملی</th>
                    <th>شماره مشتری</th>
                    <th>حذف</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="individualCustomer" items="${individualCustomers}">
                    <tr>
                        <td>${individualCustomer.customerType}</td>
                        <td>${individualCustomer.firstName}</td>
                        <td>${individualCustomer.lastName}</td>
                        <td>${individualCustomer.nationalCode}</td>
                        <td>${individualCustomer.customerNO}</td>
                        <td>
                            <button type="button" class="btn btn-danger">
                                <a href="<c:url value="/delete-individual-customer/${individualCustomer.customerNO}"/>">حذف</a>
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
                    <th>شماره مشتری</th>
                    <th>حذف</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="legalCustomer" items="${legalCustomers}">
                    <tr>
                        <td>${legalCustomer.customerType}</td>
                        <td>${legalCustomer.companyName}</td>
                        <td>${legalCustomer.economicCode}</td>
                        <td>${legalCustomer.customerNO}</td>
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
