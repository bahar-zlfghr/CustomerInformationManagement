<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html dir="rtl" lang="fa-IR">
<head>
    <title>ثبت شروط اعطاء نوع تسهیلات جدید</title>
    <script src="https://cdn.jsdelivr.net/npm/@persian-tools/persian-tools/build/persian-tools.umd.js"></script>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script src="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-date/dist/persian-date.js"></script>
    <script src="http://babakhani.github.io/PersianWebToolkit/beta/lib/persian-datepicker/dist/js/persian-datepicker.js"></script>
    <script src="<c:url value="/static/js/validate-grant-condition-creation.js"/>"></script>
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
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/"/>">صفحه اصلی</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-customer"/>">ثبت نام مشتری جدید</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/customers"/>">لیست مشتریان</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-type"/>">ثبت نوع تسهیلات جدید</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/save-loan-file"/>">تشکیل پرونده تسهیلاتی</a>
</nav>

<div class="container rounded-3" style="margin: 100px 50px">
    <div class="alert alert-primary" role="alert">
        <h5> شروط اعطاء نوع تسهیلات را جهت ثبت با دقت وارد کنید </h5>
    </div>

    <form>
        <table class="table grant-condition" dir="rtl">
            <tbody>
            <tr>
                <td>نام</td>
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
                <td>حداقل مدت قرارداد</td>
                <td>
                    <label>
                        <input type="number" id="minPeriod" lang="en" />
                    </label>
                </td>
                <td>ماه</td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="minPeriodError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td>حداکثر مدت قرارداد</td>
                <td>
                    <label>
                        <input type="number" id="maxPeriod" lang="en" />
                    </label>
                </td>
                <td>ماه</td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="maxPeriodError" class="alert alert-danger" role="alert" style="display: none"></div>
                    <div id="periodError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td>حداقل مبلغ قرارداد</td>
                <td>
                    <label>
                        <input type="number" id="minAmount" lang="en" />
                    </label>
                </td>
                <td>ریال</td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="minAmountError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td>حداکثر مبلغ قرارداد</td>
                <td>
                    <label>
                        <input type="number" id="maxAmount" lang="en" />
                    </label>
                </td>
                <td>ریال</td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="maxAmountError" class="alert alert-danger" role="alert" style="display: none"></div>
                    <div id="amountError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td colspan="1">
                    <input type="button" id="add-button" class="btn btn-info" value="افزودن" style="color: #FFFFFF;">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<div class="container rounded-3" style="margin-left: 50px">
    <div class="alert alert-primary" role="alert">
        <h5> اطلاعات شروط اعطاء </h5>
    </div>
    <div id="grant-condition-alert" class="alert alert-light" role="alert" style="display: none">
        <h5> هیچ شرط اعطائی اضافه نشده است ! </h5>
    </div>

    <table class="table table-bordered" id="table" style="display: none">
        <thead>
            <tr>
                <th>نام</th>
                <th>حداقل مدت قرارداد</th>
                <th>حداکثر مدت قرارداد</th>
                <th>حداقل مبلغ قرارداد</th>
                <th>حداکثر مبلغ قرارداد</th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>

    <div class="alert alert-primary" role="alert">
        <h5> اطلاعات نوع تسهیلات </h5>
    </div>
    <table class="table table-sm" style="border-color: #FFFFFF">
        <thead>
            <tr>
                <th>نام نوع تسهیلات</th>
                <th> نرخ سود</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${sessionScope.loanType.name}</td>
                <td>${sessionScope.loanType.interestRate} درصد</td>
            </tr>
            <tr>
                <td colspan="4">
                    <div id="grantConditionsError" class="alert alert-danger" role="alert" style="display: none"></div>
                </td>
            </tr>
            <tr>
                <td colspan="1">
                    <input type="submit" id="save-button" class="btn btn-success" value="ثبت">
                    <button type="button" class="btn btn-danger">
                        <a href="<c:url value="/"/>">انصراف</a>
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
    });

    $("#add-button").on("click", function() {
        if (validateGrantConditionCreationForm()) {
            let name = document.getElementById('name').value;
            let minPeriod = document.getElementById('minPeriod').value;
            let maxPeriod = document.getElementById('maxPeriod').value;
            let minAmount = document.getElementById('minAmount').value;
            let maxAmount = document.getElementById('maxAmount').value;

            if (maxPeriod < minPeriod) {
                printError(
                    'حداکثر مدت قرارداد باید از حداقل مدت قرارداد بزرگتر باشد',
                    'periodError'
                );
            }
            else {
                document.getElementById('periodError').style.display = 'none';
            }
            if (maxAmount < minAmount) {
                printError(
                    'حداکثر مبلغ قرارداد باید از حداقل مبلغ قرارداد بزرگتر باشد',
                    'amountError'
                );
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
</script>
</body>
</html>
