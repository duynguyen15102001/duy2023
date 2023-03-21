<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:url var="formUrl" value="/api/building"/>
<html>
<head>
    <title>Chỉnh sửa tòa nhà</title>
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
                <li class="active">Quản lý tòa nhà</li>
                <li class="active">Thêm tòa nhà</li>
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
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Tên tòa nhà </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">
                                <form:input path="name" id="name" cssClass="form-control " type="text"/>
                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="name" id="name" class="form-control" type="text"/>

                            </c:if>


                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for=""> Quận </label>

                        <div class="col-sm-9">
                            <div class="btn-group">
                                <c:if test="${not empty model.id}">



                                    <select name="district" id="districts" class="form-control">

                                        <c:forEach items="${districtList}" var="district">
                                            <option <c:if test="${district.key eq model.district}">selected="selected"</c:if> value="${district.key}">${district.value} </option>
                                        </c:forEach>
                                    </select>
                                </c:if>
                                <c:if test="${empty model.id}">


                                    <select name="district" id="districts" class="form-control">
                                        <option label="--Chọn quận--"/>
                                        <c:forEach items="${districtList}" var="district">
                                            <option value="${district.key}">${district.value}</option>
                                        </c:forEach>
                                    </select>
                                </c:if>

                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Phường </label>

                        <div class="col-sm-9">

                            <c:if test="${not empty model.id}">

                                <form:input path="ward" id="ward" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="ward" id="ward" Class="form-control"/>

                            </c:if>



                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Đường </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="street" id="street" Class="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="street" id="street" Class="form-control"/>

                            </c:if>

                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Kết cấu </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="structure" id="structure" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="structure" id="structure" Class="form-control"/>

                            </c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="numberOfBasement" > Số tầng hầm </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="numberOfBasement" id="numberOfBasement" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="numberOfBasement" id="numberOfBasement" Class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Diện tích sàn </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="floorArea" id="floorArea" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="floorArea" id="floorArea" class="form-control"/>

                            </c:if>

                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Hướng</label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="direction" id="direction" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="direction" id="direction" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Hạng </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="level" id="level" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="level" id="level" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Diện tích thuê </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="rentArea" id="rentArea" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="rentArea" id="rentArea" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Mô tả diện tích </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:textarea path="description" id="description" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="description" id="description" class="form-control"/>

                            </c:if>


                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Phí dịch vụ </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="serviceFee" id="serviceFee" css="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="serviceFee" id="serviceFee" class="form-control"/>

                            </c:if>


                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Phí ô tô </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="carFee" id="carFee" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="carFee" id="carFee" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Phí mô tô </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="motoFee" id="motoFee" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="motoFee" id="motoFee" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Phí ngoài giờ </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="overtimeFee" id="overtimeFee" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="overtimeFee" id="overtimeFee" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Đặt cọc </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="deposit" id="deposit" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="deposit" id="deposit" class="form-control"/>

                            </c:if>

                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Thanh toán </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="payment" id="payment" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="payment" id="payment" class="form-control"/>

                            </c:if>

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Thời hạn trang trí </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="decorationTime" id="decorationTime" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="decorationTime" id="decorationTime" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Tên quản lý </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="manageName" id="manageName" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="manageName" id="manageName" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Số điện thoại quản lý </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="managePhone" id="managePhone" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="managePhone" id="managePhone" class="form-control"/>

                            </c:if>


                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name"> Phí môi giới </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <form:input path="brokerageTee" id="brokerageTee" cssClass="form-control"/>

                            </c:if>
                            <c:if test="${empty model.id}">

                                <input name="brokerageTee" id="brokerageTee" class="form-control"/>

                            </c:if>
                        </div>



                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="buildingTypes"> Loại tòa nhà </label>

                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">

                                <label class="pos-rel">
                                    <c:forEach items="${buildingTypeList}" var="type">
                                        <input <c:if test="${fn:contains(model.types, type.key)}">checked="checked"</c:if> type="checkbox" name="type" value="${type.key}"/>
                                        <span class="lbl"></span>
                                        <label for="buildingType">${type.value}</label>
                                    </c:forEach>
                                </label>
                            </c:if>

                            <c:if test="${empty model.id}">
                            <label class="pos-rel">
                                    <c:forEach items="${buildingTypeList}" var="type">
                                        <input type="checkbox" name="type" value="${type.key}"/>
                                        <span class="lbl"></span>
                                        <label for="buildingType">${type.value}</label>
                                    </c:forEach>
                            </label>

                            </c:if>


                        </div>

                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="areaRents">Ghi chú </label>
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
                        <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                        <input class="col-sm-3 control-label no-padding-right" type="file" id="uploadImage"/>
                        <div class="col-sm-9">
                            <c:if test="${not empty model.id}">
                                <c:set var="imagePath" value="/repository${model.image}"/>
                                <img src="${imagePath}" id="viewImage" width="400px" height="400px" style="margin-top: 10px">
                            </c:if>
                            <c:if test="${empty model.id}">
                                <img src="/admin/image/default.png" id="viewImage" width="400px" height="400px" style="margin-top: 10px">
                            </c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" ></label>
                        <c:if test="${not empty model.id}">

                            <button type="button" class="btn btn-primary" id="btnUpdateBuilding">Cập nhật tòa nhà</button>
                            <img src="/img/loading.gif" style="display: none; height: 100px" id="loading_image">

                        </c:if>
                        <c:if test="${empty model.id}">

                            <button type="button" class="btn btn-primary" id="btnAddBuilding">Thêm tòa nhà</button>
                            <button type="button" class="btn btn-primary" id="btn-cancel">Hủy</button>
                            <img src="/img/loading.gif" style="display: none; height: 100px" id="loading_image">
                        </c:if>


                    </div>



                    <c:if test="${not empty model.id}">


                        <form:hidden path="id" id="buildingId"/>

                    </c:if>
                    <c:if test="${empty model.id}">

                        <input type="hidden" id="buildingId" name="id" >
                    </c:if>




                </form:form>


            </div>
        </div>
    </div>

</div>



</div><!-- /.page-content -->
</div>


<script>

   /* $('#btnAddBuilding').click(function name(){
        var data = {};
        var type = [];
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (index, v) {
            if(v.name == 'type'){
                type.push(v.value);
            }else{
                data[""+v.name+""] = v.value;
            }
        });
        data['type']= type;
        //tuong tu postman
        $('#loading_image').show();
        addBuilding(data);
    });
    function addBuilding(data) {
        $.ajax({
            url: '${formUrl}',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                $('#loading_image').show();
                window.location.href = "<c:url value='/admin/building-edit-"+res.id+"?message=insert_success'/>";
            },
            error: function (res) {
                $('#loading_image').hide();
                window.location.href = "<c:url value='/admin/building-edit-"+res.id+"?message=error_system'/>";
            }
        });
    }*/
    /*$('#btnUpdateBuilding').click(function name(){
        var data = {};
        var buildingType = [];
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (index, v) {
            if(v.name == 'buildingTypes'){
                buildingTypes.push(v.value);
            }else{
                data[""+v.name+""] = v.value;
            }
        });
        data['buildingType']= buildingTypes;
        //tuong tu postman
        $.ajax({
            type: "PUT",
            //chuyen thanh file json
            data: JSON.stringify(data),
            //tra ve tu server
            dataType: "json",
            url: "http://localhost:8083/api/building",
            // du liêu tu client về server
            contentType:"application/json",
            //khai bao khi phát hiện lỗi trong 2 luồng
            success: function (response) {
                console.log('success')
            },
            error: function (response) {
                console.log('failed')
                console.log(response)
            }
        });*/
   var imageBase64 = '';
   var imageName = '';
    $("#btnUpdateBuilding").click(function (event) {
        event.preventDefault();
        var type = [];
        var data = {};


        var formData = $("#formEdit").serializeArray();
        $.each(formData, function (i, e) {
            if ('' !== e.value && null != e.value) {
                data['' + e.name + ''] = e.value;
            }

            if ('' !== imageBase64) {
                data['imageBase64'] = imageBase64;
                data['imageName'] = imageName;
            }
            if(e.name == 'type'){
                type.push(e.value);
            }else{
                data[""+e.name+""] = e.value;
            }
        });
        data['type']= type;

        if ($('#buildingId').val() != "") {
            var buildingId = $('#buildingId').val();
            $('#loading_image').show();
            updateBuilding(data, buildingId);
        }
    });
    function updateBuilding(data, id) {
        $.ajax({
            url: '${formUrl}/' + id,
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                $('#loading_image').hide();
                showMessageConfirmation("Thành công", "Thao tác thành công!", "success", "/admin/building-edit-" + res.id);
            },
            error: function (res) {
                $('#loading_image').hide();
                var redirectUrl = (null === buildingId) ? "" : "/admin/building-edit-" + {buildingId};
                showMessageConfirmation("Thất bại", "Đã có lỗi xảy ra! Vui lòng kiểm tra lại.", "warning", redirectUrl);
            }
        });
    }


    $("#btnAddBuilding").click(function () {
        var data = {};
        var type = [];
        var formData = $("#formEdit").serializeArray();
        $.each(formData, function (i, e) {
            if ('' !== e.value && null != e.value) {
                data['' + e.name + ''] = e.value;
            }

            if ('' !== imageBase64) {
                data['imageBase64'] = imageBase64;
                data['imageName'] = imageName;
            }
            if(e.name == 'type'){
                type.push(e.value);
            }else{
                data[""+e.name+""] = e.value;
            }
        });
        data['type']= type;
        var buildingId = data['id'];

        $('#loading_image').show();

        $.ajax({
            type: "POST",
            url: "${formUrl}",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (res) {
                $('#loading_image').hide();
                showMessageConfirmation("Thành công", "Thao tác thành công!", "success", "/admin/building-edit-" + res.id);
            },
            error: function () {
                $('#loading_image').hide();
                var redirectUrl = (null === buildingId) ? "" : "/admin/building-edit-" + {buildingId};
                showMessageConfirmation("Thất bại", "Đã có lỗi xảy ra! Vui lòng kiểm tra lại.", "warning", redirectUrl);
            }
        });
    });

    $("#btn-cancel").click(function () {
        showAlertBeforeCancelForm(function() {
            window.location.href = '/admin/building-list';
        })
    });

    $('#uploadImage').change(function (event) {
        var reader = new FileReader();
        var file = $(this)[0].files[0];
        reader.onload = function(e){
            imageBase64 = e.target.result;
            imageName = file.name; // ten hinh khong dau, khoang cach. vd: a-b-c
        };
        reader.readAsDataURL(file);
        openImage(this, "viewImage");
    });

    function openImage(input, imageView) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' +imageView).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
</body>
</html>