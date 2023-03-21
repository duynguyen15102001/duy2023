<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/9/2022
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ page import="com.laptrinhjavaweb.security.utils.SecurityUtils" %>
<c:url var="loadStaffAPI" value="/api/building"/>
<c:url var="assignStaffAPI" value="/api/assignmentbuilding"/>
<c:url var="buildingListURL" value="/admin/building-list"/>
<html>
<head>
    <title>Danh sách tòa nhà</title>
</head>
<body>

<div class="main-content">

    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Quản lý tòa nhà</li>
                <li class="active">Danh sách tòa nhà</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="ace-settings-container" id="ace-settings-container">
                <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                    <i class="ace-icon fa fa-cog bigger-130"></i>
                </div>

                <div class="ace-settings-box clearfix" id="ace-settings-box">
                    <div class="pull-left width-50">
                        <div class="ace-settings-item">
                            <div class="pull-left">
                                <select id="skin-colorpicker" class="hide">
                                    <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                    <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                    <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                    <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                </select>
                            </div>
                            <span>&nbsp; Choose Skin</span>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar"/>
                            <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar"/>
                            <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs"/>
                            <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl"/>
                            <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container"/>
                            <label class="lbl" for="ace-settings-add-container">
                                Inside
                                <b>.container</b>
                            </label>
                        </div>
                    </div><!-- /.pull-left -->

                    <div class="pull-left width-50">
                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover"/>
                            <label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact"/>
                            <label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
                        </div>


                    </div><!-- /.pull-left -->
                </div><!-- /.ace-settings-box -->
            </div><!-- /.ace-settings-container -->
            <div class="row">
                <div class="widget-box">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="widget-header">
                            <h4 class="widget-title">Tìm kiếm</h4>

                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>

                        <div class="row">

                            <div class="col-xs-12">
                                <div class="widget-box">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div class="form-horizontal"></div>
                                            <div class="row">
                                                <form:form class="form-horizontal" role="form" id="formEdit"
                                                           modelAttribute="model" method="get">

                                                <div class="col-sm-6">
                                                    <div>
                                                        <label for="name">Tên tòa nhà</label>
                                                        <form:input path="name" id="name" class="form-control"
                                                                    placeholder="Nhập tên tòa nhà, ví dụ: Vincom, Vietcombank, International Plaza..."/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">

                                                    <div>
                                                        <label for="buildingArea">Diện tích sàn</label>
                                                        <form:input path="floorArea" id="floorArea" class="form-control"
                                                                    type="number"
                                                                    placeholder="Nhập diện tích sàn, ví dụ: 500, 600,..."/>
                                                            <%--<input type="number" id="floorArea" class="form-control" name="floorArea" />--%>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <div class="btn-group">
                                                        <label for="buildingArea">Quận hiện có</label>


                                                        <form:select path="district" class="form-control">
                                                            <form:option value="" label="--Chọn quận--"/>
                                                            <c:forEach items="${districtList}" var="district">

                                                                <form:option value="${district.key}"
                                                                             label="${district.value}"/>

                                                            </c:forEach>

                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div>
                                                        <label for="name">Phường</label>
                                                        <form:input path="ward" id="name" class="form-control"
                                                                    placeholder="Nhập tên phường, ví dụ: Thủ Thiêm,..."/>

                                                    </div>
                                                </div>
                                                <div class="col-sm-4">

                                                    <div>
                                                        <label for="buildingArea">Đường</label>
                                                        <form:input path="street" id="street" class="form-control"
                                                                    placeholder="Nhập tên đường, ví dụ: Mai Chí Thọ,..."/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <div>
                                                        <div>
                                                            <label for="name">Số tầng hầm</label>
                                                            <form:input path="numberOfBasement" id="numberOfBasement"
                                                                        class="form-control" type="number"
                                                                        placeholder="Nhập số tầng hầm, ví dụ: 1,..."/>

                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div>
                                                        <label for="name">Hướng</label>
                                                        <form:input path="direction" id="direct" class="form-control"
                                                                    placeholder="Nhập hướng, ví dụ: Bắc,..."/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">

                                                    <div>
                                                        <label for="buildingArea">Hạng</label>
                                                        <form:input path="level" id="level" class="form-control"
                                                                    placeholder="Nhập hạng, ví dụ: C,..."/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <div>
                                                        <div>
                                                            <label for="buildingArea">Diện tích từ</label>
                                                            <form:input path="areaRentFrom" id="areaRentFrom"
                                                                        class="form-control" type="number"
                                                                        placeholder="Nhập diện tích từ, ví dụ: 200,..."/>

                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div>
                                                        <label for="name">Diện tích đến</label>
                                                        <form:input path="areaRentTo" id="areaRentTo"
                                                                    class="form-control" type="number"
                                                                    placeholder="Nhập diện tích đến, ví dụ: 200,300..."/>

                                                    </div>
                                                </div>
                                                <div class="col-sm-3">

                                                    <div>
                                                        <label for="buildingArea">Giá thuê từ</label>
                                                        <form:input path="rentPriceFrom" id="rentPriceFrom"
                                                                    class="form-control" type="number"
                                                                    placeholder="Nhập giá thuê từ, ví dụ:100,200..."/>

                                                    </div>
                                                </div>
                                                <div class="col-sm-3">

                                                    <div>
                                                        <label for="buildingArea">Giá thuê đến</label>
                                                        <form:input path="rentPriceTo" id="rentPriceTo"
                                                                    class="form-control" type="number"
                                                                    placeholder="Nhập giá thuê đến, ví dụ: 200,300,..."/>

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <div>
                                                        <div>
                                                            <label for="buildingArea">Tên quản lý</label>
                                                            <input type="text" id="nameManager" class="form-control"
                                                                   name="nameManager"
                                                                   placeholder="Nhập tên quản lý, ví dụ: Duy,..."/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div>
                                                        <label for="name">Điện thoại quản lý</label>
                                                        <input type="text" id="phoneManager" class="form-control"
                                                               name="phoneManager"
                                                               placeholder="Nhập điện thoại quản lý, ví dụ: 0767162821,..."/>
                                                    </div>
                                                </div>
                                                <security:authorize access="hasRole('MANAGER')">
                                                    <div class="col-sm-4">

                                                        <div>
                                                            <label for="name">Chọn nhân viên phụ trách</label>
                                                            <br>
                                                            <form:select path="staffId">
                                                                <form:option value="">--Chọn nhân viên</form:option>
                                                                <form:options items="${model.buildinhDTOs}"/>
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                </security:authorize>

                                            </div>

                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <div>
                                                        <c:forEach items="${buildingTypeList}" var="type">
                                                            <input type="checkbox" name="type" value="${type.key}"/>
                                                            <span class="lbl"></span>
                                                            <label for="buildingType">${type.value}</label>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </div>

                                            <button class="btn btn-success btn-next" id="btnSearch" data-last="Finish">
                                                Tìm kiếm
                                                <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                            </button>
                                        </div>
                                    </div>
                                    </form:form>
                                    <!-- PAGE CONTENT BEGINS --

                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div class="form-horizontal"></div>
                            </div>
                            <!-- PAGE CONTENT ENDS -->
                                </div><!-- /.col -->
                                <!-- PAGE CONTENT ENDS -->
                            </div><!-- /.col -->
                            <security:authorize access="hasRole('MANAGER')">
                                <div class="pull-right">
                                    <button class="btn btn-white btn-info btn-bold" data-toggle="tooltip" id="btn-add"
                                            title="Thêm tòa nhà">
                                        <i class="fa fa-plus-circle" aria-hidden="true"></i>

                                    </button>
                                    <button class="btn btn-white btn-warning btn-bold"
                                            id="btnDeleteBuilding" data-toggle="tooltip" title="Xóa tòa nhà"
                                            onclick="warningBeforeDelete()">
                                        <i class="fa fa-trash" aria-hidden="true"></i>

                                    </button>
                                </div>
                            </security:authorize>
                        </div>
                        <tbody>
                        <display:table name="model.listResult" cellspacing="0" cellpadding="0"
                                       requestURI="${formUrl}" partialList="true" sort="external"
                                       size="${model.totalItems}" defaultsort="2" defaultorder="ascending"
                                       id="tableList" pagesize="${model.maxPageItems}"
                                       export="false"
                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                       style="margin: 3em 0 1.5em;">
                            <security:authorize access="hasRole('MANAGER')">
                                <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                                headerClass="center select-cell">

                                    <fieldset>

                                        <input type="checkbox" name="checkList" value="${tableList.id}"
                                               id="checkbox_${tableList.id}" class="check-box-element"/>

                                    </fieldset>

                                </display:column>
                            </security:authorize>
                            <display:column headerClass="text-left" property="createdDate" title="Ngày"
                                            format="{0,date,dd/MM/yyyy}"/>
                            <display:column headerClass="text-left" property="name" title="Tên"/>
                            <display:column headerClass="text-left" property="address" title="Địa chỉ"/>
                            <display:column headerClass="text-left" property="manageName" title="Tên quản lý"/>
                            <display:column headerClass="text-left" property="managePhone" title="Số điện thoại"/>
                            <display:column headerClass="text-left" property="street" title="Diện tích sàn"/>
                            <display:column headerClass="text-left" property="rentPrice" title="Giá thuê"/>
                            <display:column headerClass="text-left" property="serviceFee" title="Phí dịch vụ"/>
                            <display:column headerClass="col-actions" title="Thao tác">
                                <security:authorize access="hasRole('MANAGER')">
                                    <button class="btn btn-xs btn-info" data-toggle="tooltip" title="Giao tòa nhà"
                                            onclick="assignmentBuilding(${tableList.id})">
                                        <i class="fa fa-bars" aria-hidden="true"></i>
                                    </button>
                                </security:authorize>

                                <a class="btn btn-xs btn-primary" data-toggle="tooltip"
                                   title="Cập nhật tòa nhà"
                                   href='<c:url value="/admin/building-edit-${tableList.id}"/>'>
                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                </a>
                            </display:column>
                        </display:table>
                        </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</div><!-- /.page-content -->
</div>

<div class="modal fade" id="assignmentBuildingModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên giao sản phẩm</h4>
            </div>
            <div class="modal-body">

                <table class="table" id="staffList">
                    <thead>
                    <tr>
                        <th>Chọn nhân viên</th>
                        <th>Tên nhân viên</th>

                    </tr>
                    </thead>
                    <tbody>

                    <%-- <tr>
                         <td class="text-center"><input type="checkbox" value="2" id="checkbox_2" checked></td>
                         <td>${item.fullName}</td>

                     </tr>
                     <tr>
                         <td class="text-center"><input type="checkbox" value="3" id="checkbox_3" checked></td>
                         <td>Nguyễn Văn C</td>

                     </tr>
                     <tr>
                         <td class="text-center"><input type="checkbox" value="4" id="checkbox_4"></td>
                         <td>Nguyễn Văn D</td>

                     </tr>--%>

                    </tbody>
                </table>
                <input type="hidden" id="buildingId" name="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-default" id="btn-cancel" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>
<script>
    $('#btnSearch').click(function (e) {
        e.preventDefault();
        $('#formEdit').submit();
    });
    $('#btn-add').click(function (e) {
        e.preventDefault();
        window.location.replace("/admin/building-edit");

    });

    function assignmentBuilding(buildingId) {
        openModalAssignmentBuilding();
        loadStaff(buildingId);
        $('#buildingId').val(buildingId);
        console.log($('#buildingId').val());

    }

    function loadStaff(buildingId) {
        $.ajax({
            type: "GET",
            url: "${loadStaffAPI}/" + buildingId + "/staffs",
            /*data: JSON.stringify(data),*/
            dataType: "json",

            /*contentType:"application/json",*/
            success: function (response) {
                console.log('success')

                var row = '';
                $.each(response.data, function (index, item) {

                    row += '<tr>';
                    /* row+='<td><input type="checkbox" value=






                    ${item.staffId} id="checkbox_'+item.staffId+'" id="checkbox_






                    ${item.staffId}"  class="check-box-element" '+item.checked+'></td>';*/
                    row += '<td><input type="checkbox" value=' + item.staffId + ' id="checkbox_' + item.staffId + '" class="check-box-element" ' + item.checked + '></td>';
                    row += '<td >' + item.fullName + '</td>'
                    row += '</tr>';

                    //add html vao row
                    $('#staffList tbody').html(row);
                })
            },
            error: function (response) {
                console.log('failed')
                console.log(response)
            }
        });
    }

    function openModalAssignmentBuilding() {
        $('#assignmentBuildingModal').modal();

    }

    $('#btn-cancel').click(function (e) {

        showAlertBeforeCancelForm(function () {
            window.location.href = '/admin/building-list';
        })
    });

    $('#btnAssignBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        var staffId = [];
        data['buildingId'] = $('#buildingId').val();
        //$('#staffList').find('tbody input[type=checkbox]')

        var staffId = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();

        data['staffId'] = staffId;
        assignStaff(data);
        $.ajax({
            type: "POST",
            data: JSON.stringify(data),
            dataType: "json",
            url: "${assignStaffAPI}",
            contentType: "application/json",
            success: function (response) {
                console.log('success')
                showAlertAfterAssignBuilding(function () {
                    window.location.href = '/admin/building-list';
                    console.log(response)
                });
            },
            error: function (response) {
                console.log('failed')

            }
        });
    });

    function assignStaff(data) {
        $.ajax({
            type: "POST",
            data: JSON.stringify(data),
            dataType: "json",
            url: "http://localhost:8086/api/userassignment",
            contentType: "application/json",
            success: function (response) {
                console.log('success')
                showAlertAfterAssignBuilding();
            },
            error: function (response) {
                console.log('failed')
                console.log(response)
            }
        });
    }


    function warningBeforeDelete() {
        showAlertBeforeDelete(function () {
            event.preventDefault();
            var dataArray = $('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            deleteBuilding(dataArray);
        });
    }

    function deleteBuilding(data) {
        $.ajax({
            type: "DELETE",
            data: JSON.stringify(data),
            dataType: "json",
            url: "${loadStaffAPI}",
            contentType: "application/json",
            success: function (res) {
                window.location.href = "<c:url value='/admin/building-list?message=delete_success'/>";
            },
            error: function (res) {
                console.log(res);
                window.location.href = "<c:url value='/admin/building-list?message=error_system'/>";
            }
        });
    }

    /* $('#btnSearch').click(function name(){
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
          data['buildingType']= buildingType;

          $.ajax({
              type: "GET",
              data: JSON.stringify(data),
              dataType: "json",
              contentType:"application/json",
              success: function (response) {

              },
              error: function (response) {
                  console.log('failed')
                  console.log(response)
              }
          });
      });*/
</script>

</body>

</html>
