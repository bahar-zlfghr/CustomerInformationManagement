<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title><fmt:message key="grant.condition.creation.page.title"/></title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script src="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-date/dist/persian-date.js"></script>
    <script src="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-datepicker/dist/js/persian-datepicker.js"></script>
    <script src="<c:url value="/static/js/validate-grant-condition-creation.js"/>"></script>
    <script src="<c:url value="/static/js/messages.js"/>"></script>
    <script src="<c:url value="/static/js/persian-utility.js"/>"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.rtl.min.css" rel="stylesheet">
    <link href="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-datepicker/dist/css/persian-datepicker.css" rel="stylesheet"/>
    <link rel="icon" type="image/ico" href="<c:url value="/static/img/logo.png"/>">
    <link href="<c:url value="/static/css/main.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/customers-table.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/grant-conditions-table.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/alert-style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/css/form-style.css"/>" rel="stylesheet"/>
</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row border-gradient border-gradient-purple">
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/"/>"><fmt:message key="menu.item.main.page"/></a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-customer"/>"><fmt:message key="menu.item.save.customer"/></a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/customers"/>"><fmt:message key="menu.item.customers.list"/></a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-type"/>"><fmt:message key="menu.item.save.loan.type"/></a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-file"/>"><fmt:message key="menu.item.save.loan.file"/></a>
</nav>

<div class="container rounded-3" style="margin: 100px 50px">
    <div class="alert alert-primary" role="alert">
        <h5><fmt:message key="grant.condition.save.message"/></h5>
    </div>

    <form>
        <table class="table grant-condition" dir="rtl">
            <tbody>
            <tr>
                <td><fmt:message key="grant.condition.name"/></td>
                <td>
                    <label>
                        <input id="name" type="text"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="nameError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td><fmt:message key="grant.condition.min.period"/></td>
                <td>
                    <label>
                        <input type="number" id="minPeriod" lang="en" />
                    </label>
                </td>
                <td><fmt:message key="period.unit"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="minPeriodError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td><fmt:message key="grant.condition.max.period"/></td>
                <td>
                    <label>
                        <input type="number" id="maxPeriod" lang="en" />
                    </label>
                </td>
                <td><fmt:message key="period.unit"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="maxPeriodError" class="alert alert-danger" role="alert" style="display: none"></div>
                    <div id="periodError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td><fmt:message key="grant.condition.min.amount"/></td>
                <td>
                    <label>
                        <input type="number" id="minAmount" lang="en" />
                    </label>
                </td>
                <td><fmt:message key="amount.unit"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="minAmountError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td><fmt:message key="grant.condition.max.amount"/></td>
                <td>
                    <label>
                        <input type="number" id="maxAmount" lang="en" />
                    </label>
                </td>
                <td><fmt:message key="amount.unit"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="maxAmountError" class="alert alert-danger" role="alert" style="display: none"></div>
                    <div id="amountError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td colspan="1">
                    <input type="button" id="add-button" class="btn btn-info" value="<fmt:message key="button.add"/>" style="color: #FFFFFF;">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<div class="container rounded-3" style="margin-left: 50px">
    <div class="alert alert-primary" role="alert">
        <h5><fmt:message key="table.name.grant.conditions"/></h5>
    </div>
    <div id="grant-condition-alert" class="alert alert-light" role="alert" style="display: none">
        <h5><fmt:message key="grant.condition.alert.not.added.any.condition"/></h5>
    </div>

    <table class="table table-bordered" id="table" style="display: none">
        <thead>
            <tr>
                <th><fmt:message key="grant.condition.name"/></th>
                <th><fmt:message key="grant.condition.min.period"/></th>
                <th><fmt:message key="grant.condition.max.period"/></th>
                <th><fmt:message key="grant.condition.min.amount"/></th>
                <th><fmt:message key="grant.condition.max.amount"/></th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>

    <div class="alert alert-primary" role="alert">
        <h5><fmt:message key="table.name.loan.type"/></h5>
    </div>
    <table class="table table-sm" style="border-color: #FFFFFF">
        <thead>
            <tr>
                <th><fmt:message key="loan.type.name"/></th>
                <th><fmt:message key="loan.type.interest.rate"/></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${sessionScope.loanType.name}</td>
                <td>${sessionScope.loanType.interestRate} <fmt:message key="interest.rate.unit"/></td>
            </tr>
            <tr>
                <td colspan="4">
                    <div id="grantConditionsError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td colspan="1">
                    <input type="submit" id="save-button" class="btn btn-success" value="<fmt:message key="button.submit"/>">
                    <button type="button" class="btn btn-danger">
                        <a href="<c:url value="/"/>" onclick="removeGrantConditionsFromLocalStorage()"><fmt:message key="button.cancel"/></a>
                    </button>
                </td>
            </tr>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
    $(function() {
        if (grantConditions.length === 0) {
            document.getElementById('grant-condition-alert').style.display = 'block';
        }
        showGrantConditionItems();
    });

    $("#add-button").on("click", function() {
        if (validateGrantConditionCreationForm()) {
            let name = document.getElementById('name').value;
            let minPeriod = document.getElementById('minPeriod').value;
            let maxPeriod = document.getElementById('maxPeriod').value;
            let minAmount = document.getElementById('minAmount').value;
            let maxAmount = document.getElementById('maxAmount').value;

            if (maxPeriod < minPeriod) {
                printError(grant_condition_min_max_period_error, 'periodError');
            }
            else {
                document.getElementById('periodError').style.display = 'none';
            }
            if (maxAmount < minAmount) {
                printError(grant_condition_min_max_amount_error, 'amountError');
            }
            else {
                document.getElementById('amountError').style.display = 'none';
            }
            if (maxPeriod >= minPeriod && maxAmount >= minAmount) {
                grantConditions.push({
                    name: name,
                    minPeriod: minPeriod,
                    maxPeriod: maxPeriod,
                    minAmount: minAmount,
                    maxAmount: maxAmount
                });
                localStorage.setItem('grantConditions', JSON.stringify(grantConditions));
                document.getElementById('grant-condition-alert').style.display = 'none';

                const table = document.getElementById("table");

                table.style.display = 'flex';
                table.style.justifyContent = 'center';

                let row = table.insertRow(table.rows.length);
                row.insertCell(0).innerHTML = name;
                row.insertCell(1).innerHTML = minPeriod;
                row.insertCell(2).innerHTML = maxPeriod;
                row.insertCell(3).innerHTML = minAmount;
                row.insertCell(4).innerHTML = maxAmount;
            }
        }
    });

    $("#save-button").on("click", function() {
        if (validateGrantConditions()) {
            $.ajax({
                type: "post",
                url: "/save-loan-type",
                data: JSON.stringify(grantConditions),
                dataType : 'json',
                contentType: 'application/json',
                complete: function () {
                    window.location.replace('http://localhost:8080/');
                }
            });
        }
    });

    function removeGrantConditionsFromLocalStorage() {
        localStorage.removeItem('grantConditions');
    }
</script>
</body>
</html>
