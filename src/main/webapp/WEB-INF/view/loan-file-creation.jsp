<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title>تشکیل پرونده تسهیلاتی</title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script src="<c:url value="/static/js/validate-loan-file-creation.js"/>"></script>
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

<div class="container rounded-3" style="margin-right: 50px">
    <c:if test="${sessionScope.loanFilePeriodNotValidException.length() > 0}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <h5>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                <%
                    out.print(session.getAttribute("loanFilePeriodNotValidException"));
                %>
            </h5>
            <%
                session.removeAttribute("loanFilePeriodNotValidException");
            %>
        </div>
    </c:if>

    <c:if test="${sessionScope.loanFileAmountNotValidException.length() > 0}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <h5>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                <%
                    out.print(session.getAttribute("loanFileAmountNotValidException"));
                %>
            </h5>
            <%
                session.removeAttribute("loanFileAmountNotValidException");
            %>
        </div>
    </c:if>

    <div class="alert alert-primary" role="alert">
        <h5> اطلاعات پرونده تسهیلاتی را جهت ثبت با دقت وارد کنید </h5>
    </div>

    <form action="<c:url value="/real-customers"/>"
          method="get"
          onsubmit="return validateCustomerNO()"
          autocomplete="off">
        <table class="table" dir="rtl" style="border: #FFFFFF">
            <tbody>
                <tr>
                    <td>شماره مشتری حقیقی</td>
                    <td>
                        <label>
                            <input type="text" name="customerNO" id="customerNO" value="${realCustomer.customerNO}"/>
                        </label>
                    </td>
                    <td>
                        <input class="btn btn-info" type="submit" id="recovery-button" value="بازیابی"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <div id="customerNOError" class="alert alert-danger" role="alert" style=" display: none"></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <c:if test="${sessionScope.realCustomerNotFoundException.length() > 0}">
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                ${sessionScope.realCustomerNotFoundException}
                                <%
                                    session.removeAttribute("realCustomerNotFoundException");
                                %>
                            </div>
                        </c:if>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>

    <form:form action="/save-loan-file"
          method="post"
          modelAttribute="loanFile"
          onsubmit="return validateLoanFileCreationForm()"
          autocomplete="off">
        <table class="table" dir="rtl" style="border: #FFFFFF">
            <tbody>
            <tr hidden>
                <td>
                    <form:label path="realCustomerNO">
                        <form:input path="realCustomerNO" value="${realCustomer.customerNO}" type="number" lang="en"/>
                    </form:label>
                </td>
            </tr>
            <tr>
                <td>نوع تسهیلات</td>
                <td>
                    <form:label path="loanTypeID">
                        <form:select path="loanTypeID" class="form-select" id="loanType" onclick="getGrantConditions()">
                            <option value="-1" selected style="font-family: Vazir-Regular">نوع تسهیلات را انتخاب کنید
                            </option>
                            <c:forEach items="${loanTypes}" var="loanType">
                                <option value="${loanType.id}"
                                        style="font-family: Vazir-Regular">${loanType.name}</option>
                            </c:forEach>
                        </form:select>
                    </form:label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="loanTypeError" class="alert alert-danger" role="alert" style=" display: none"></div>
                </td>
            </tr>
            <tr>
                <td>مدت قرارداد</td>
                <td>
                    <form:label path="period">
                        <form:input path="period" type="number" id="period" lang="en"/>
                    </form:label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="min-max-period" class="alert alert-secondary" style="display: none">

                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="periodError" class="alert alert-danger" role="alert" style=" display: none"></div>
                </td>
            </tr>
            <tr>
                <td>مبلغ قرارداد</td>
                <td>
                    <form:label path="amount">
                        <form:input path="amount" type="number" id="amount" lang="en"/>
                    </form:label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="min-max-amount" class="alert alert-secondary" style="display: none">

                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="amountError" class="alert alert-danger" role="alert" style=" display: none"></div>
                </td>
            </tr>
            <tr>
                <td rowspan="2">
                    <input class="btn btn-success" type="submit" id="submit-button" value="ثبت"/>
                    <button type="button" class="btn btn-danger">
                        <a href="<c:url value="/"/>">انصراف</a>
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>

<div class="container rounded-3" style="width: 70%; margin: 100px 50px">
    <div class="alert alert-primary" role="alert">
        <h5> اطلاعات مشتری حقیقی </h5>
    </div>
    <c:choose>
        <c:when test="${realCustomer != null}">
            <table class="table table-sm" style="border-color: #FFFFFF">
                <thead>
                <tr>
                    <th>نام مشتری حقیقی</th>
                    <th>نام خانوادگی مشتری حقیقی</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td id="real-customer-name">${realCustomer.name}</td>
                    <td>${realCustomer.lastName}</td>
                </tr>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-light" role="alert">
                <h5> اطلاعاتی جهت نمایش وجود ندارد! </h5>
            </div>
        </c:otherwise>
    </c:choose>

    <div class="alert alert-primary" role="alert">
        <h5> اطلاعات پرونده های تسهیلاتی مشتری حقیقی </h5>
    </div>
    <c:choose>
        <c:when test="${realCustomerLoanFiles != null}">
            <table class="table table-sm" style="border-color: #FFFFFF">
                <thead>
                <tr>
                    <th>نوع تسهیلات</th>
                    <th>مبلغ قرارداد (ریال)</th>
                    <th>مدت قرارداد (ماه)</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${realCustomerLoanFiles}" var="loanFile">
                        <tr>
                            <td>${loanFile.loanType.name}</td>
                            <td>${loanFile.amount.longValue()}</td>
                            <td>${loanFile.period}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-light" role="alert">
                <h5> اطلاعاتی جهت نمایش وجود ندارد! </h5>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
    function getGrantConditions() {
        let loanTypeID = document.getElementById('loanType').value;
        console.log(loanTypeID);
        if (loanTypeID !== '-1') {
            $.ajax({
                url: '/loan-types/' + loanTypeID,
                method: 'get',
                dataType : 'json',
                contentType: 'application/json',
                success: function (result) {
                    let period = document.getElementById('min-max-period');
                    let amount = document.getElementById('min-max-amount');
                    if (result.length > 0) {
                        let periodMsg = '';
                        let amountMsg = '';
                        for (i = 0; i < result.length; i++) {
                            periodMsg +=
                                'حداقل: ' + result[i].minPeriod +
                                '، حداکثر: ' + result[i].maxPeriod + ' <br> ';
                            amountMsg +=
                                'حداقل: ' + result[i].minAmount +
                                '، حداکثر: ' + result[i].maxAmount + ' <br> ';
                        }
                        period.style.display = 'block';
                        period.innerHTML = periodMsg.substring(0, periodMsg.length - 6);
                        amount.style.display = 'block';
                        amount.innerHTML = amountMsg.substring(0, amountMsg.length - 6);
                    }
                    else {
                        period.style.display = 'none';
                        amount.style.display = 'none';
                    }
                }
            });
        }
    }

</script>

</body>
</html>
