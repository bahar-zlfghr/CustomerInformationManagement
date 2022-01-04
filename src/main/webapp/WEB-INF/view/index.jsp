<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title><fmt:message key="index.page.title"/></title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.rtl.min.css" rel="stylesheet">
    <link rel="icon" type="image/ico" href="<c:url value="/static/img/logo.png"/>">
    <link href="<c:url value="/static/css/main.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/alert-style.css"/>" rel="stylesheet"/>
</head>
<body style="flex-direction: column;">
<nav class="nav nav-pills flex-column flex-sm-row border-gradient border-gradient-purple">
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/"/>"><fmt:message key="menu.item.main.page"/></a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-customer"/>"><fmt:message key="menu.item.save.customer"/></a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/customers"/>"><fmt:message key="menu.item.customers.list"/></a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-type"/>"><fmt:message key="menu.item.save.loan.type"/></a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-file"/>"><fmt:message key="menu.item.save.loan.file"/></a>
</nav>

<div class="container rounded-3">
    <c:if test="${sessionScope.saveCustomerSuccessMessage.length() > 0}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <h5>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    ${sessionScope.saveCustomerSuccessMessage}
            </h5>
            <%
                session.removeAttribute("saveCustomerSuccessMessage");
            %>
        </div>
    </c:if>

    <c:if test="${sessionScope.saveLoanFileSuccessfullyMessage.length() > 0}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <h5>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    ${sessionScope.saveLoanFileSuccessfullyMessage}
            </h5>
            <%
                session.removeAttribute("saveLoanFileSuccessfullyMessage");
            %>
        </div>
    </c:if>

    <c:if test="${sessionScope.customerNumberMessage.length() > 0}">
        <div class="alert alert-info alert-dismissible fade show" role="alert">
            <h5>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                <%
                    out.print(session.getAttribute("customerNumberMessage"));
                %>
            </h5>
            <%
                session.removeAttribute("customerNumberMessage");
            %>
        </div>
    </c:if>

    <c:if test="${saveLoanTypeSuccessMessage.length() > 0}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <h5>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    ${saveLoanTypeSuccessMessage}
            </h5>
        </div>
    </c:if>

    <div class="alert alert-primary" role="alert">
        <h5><fmt:message key="index.page.welcome.message"/></h5>
    </div>

    <button type="button" class="btn btn-outline-primary">
        <a href="<c:url value="/save-customer"/>"><fmt:message key="menu.item.save.customer"/></a>
    </button>

    <button type="button" class="btn btn-outline-primary">
        <a href="<c:url value="/customers"/>"><fmt:message key="menu.item.customers.list"/></a>
    </button>

    <button type="button" class="btn btn-outline-primary">
        <a href="<c:url value="/save-loan-type"/>"><fmt:message key="menu.item.save.loan.type"/></a>
    </button>

    <button type="button" class="btn btn-outline-primary">
        <a href="<c:url value="/save-loan-file"/>"><fmt:message key="menu.item.save.loan.file"/></a>
    </button>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
