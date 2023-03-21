<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:url var="formUrl" value="/api/customer"/>
<html>
<head>
    <title>Chỉnh sửa khách hàng</title>
</head>
<body>
<div class="main-content">

    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Quản lý khách hàng</li>
                <li class="active">Thêm khách hàng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">

            <div class="col-xs-12">
                <c:if test="${not empty messageResponse}">
                    <div class="alert alert-block alert-${alert}">
                        <button type="button" class="close" data-dismiss="alert">
                            <i class="ace-icon fa fa-times"></i>
                        </button>
                            ${messageResponse}
                    </div>
                </c:if>
                <!-- PAGE CONTENT BEGINS -->
                <form:form class="form-horizontal" role="form" id="formEdit" modelAttribute="model">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Tên đầy đủ </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">
                                <form:input path="fullName" id="fullName" cssClass="form-control " type="text"/>
                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="fullName" id="fullName" class="form-control" type="text"/>

                            </c:if>


                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Số diện thoại </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="phone" id="phone" Class="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="phone" id="phone" Class="form-control"/>

                            </c:if>

                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Email </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="email" id="email" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="email" id="email" Class="form-control"/>

                            </c:if>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Tên công ty</label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="companyName" id="companyName" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="companyName" id="companyName" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Nhu cầu </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="demand" id="demand" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="demand" id="demand" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Ghi chú </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="note" id="note" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="note" id="note" class="form-control"/>

                            </c:if>


                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" ></label>
                        <c:if test="${not empty model.id}">

                            <button type="button" class="btn btn-primary" id="btnUpdateCustomer">Cập nhật khách hàng</button>
                            <img src="/img/loading.gif" style="display: none; height: 100px" id="loading_image">

                        </c:if>
                        <c:if test="${empty model.id}">

                            <button type="button" class="btn btn-primary" id="btnAddCustomer">Thêm khách hàng</button>
                            <button type="button" class="btn btn-primary" id="btn-cancel">Hủy</button>
                            <img src="/img/loading.gif" style="display: none; height: 100px" id="loading_image">
                        </c:if>


                    </div>



                    <c:if test="${not empty model.id}">


                        <form:hidden path="id" id="customerId"/>

                    </c:if>
                    <c:if test="${empty model.id}">

                        <input type="hidden" id="customerId" name="id" >
                    </c:if>




                </form:form>


            </div>
        </div>
    </div>

</div>



</div><!-- /.page-content -->
</div>


<script>



    $("#btnUpdateCustomer").click(function (event) {
        event.preventDefault();

        var data = {};


        var formData = $("#formEdit").serializeArray();
        $.each(formData, function (i, e) {

                data[""+e.name+""] = e.value;

        });


        if ($('#customerId').val() != "") {
            var customerId = $('#customerId').val();
            $('#loading_image').show();
            updateCustomer(data, customerId);
        }
    });
    function updateCustomer(data, id) {
        $.ajax({
            url: '${formUrl}/' + id,
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                $('#loading_image').hide();
                showMessageConfirmation("Thành công", "Thao tác thành công!", "success", "/admin/customer-edit-" + res.id);
            },
            error: function (res) {
                $('#loading_image').hide();
                var redirectUrl = (null === id) ? "" : "/admin/customer-edit-" + id;
                showMessageConfirmation("Thất bại", "Đã có lỗi xảy ra! Vui lòng kiểm tra lại.", "warning", redirectUrl);
            }
        });
    }


    $("#btnAddCustomer").click(function () {
        var data = {};

        var formData = $("#formEdit").serializeArray();
        $.each(formData, function (i, e) {


                data[""+e.name+""] = e.value;

        });

        var customerId = data['id'];

        $('#loading_image').show();

        $.ajax({
            type: "POST",
            url: "${formUrl}",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (res) {
                $('#loading_image').hide();
                showMessageConfirmation("Thành công", "Thao tác thành công!", "success", "/admin/customer-edit-" + res.id);
            },
            error: function () {
                $('#loading_image').hide();
                var redirectUrl = (null === customerId) ? "" : "/admin/customer-edit-" + customerId;
                showMessageConfirmation("Thất bại", "Đã có lỗi xảy ra! Vui lòng kiểm tra lại.", "warning", redirectUrl);
            }
        });
    });

    $("#btn-cancel").click(function () {
        showAlertBeforeCancelForm(function() {
            window.location.href = '/admin/customer-list';
        })
    });




</script>
</body>
</html>