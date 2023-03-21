<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/17/2023
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<c:url var="customerAPI" value="/api/customer"/>
<c:url var="assignStaffAPI" value="/api/assignmentcustomer"/>
<html>
<head>
    <title>Danh sách khách hàng</title>
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
            <li class="active">Quản lý khách hàng</li>
            <li class="active">Danh sách khách hàng</li>
        </ul><!-- /.breadcrumb -->
    </div>
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
                                        <form:form class="form-horizontal" role="form" id="formEdit" method="get" modelAttribute="model">
                                        <div class="row">

                                            <div class="col-sm-4">


                                                    <label for="name">Tên khách hàng</label>
                                                <div class="input-group">
                                                    <span class="input-group-addon">
																	  <i class="ace-icon glyphicon glyphicon-user"></i>
																</span>

                                                    <form:input path="fullName" id="fullName" class="form-control"  placeholder="Nhập tên khách hàng" />


                                             </div>





                                            </div>
                                            <div class="col-sm-4">

                                                <div>
                                                    <label for="phone">Di động</label>
                                                    <div class="input-group">
																<span class="input-group-addon">
																	<i class="ace-icon fa fa-phone"></i>
																</span>

                                                        <form:input path="phone" id="phone" class="form-control" placeholder="Nhập số điện thoại"/>
                                                    </div>

                                                </div>
                                            </div>

                                            <div class="col-sm-4">

                                                <div>
                                                    <label for="email">Email</label>
                                                    <div class="input-group">
																<span class="input-group-addon">
																	<i class="ace-icon glyphicon glyphicon-envelope"></i>
																</span>

                                                        <form:input path="email" id="email" class="form-control" placeholder="Nhập email"/>
                                                    </div>


                                                </div>
                                            </div>
                                        </div>
                                            <div class="row">
                                        <div class="col-sm-4">
                                            <div>
                                                <label for="name">Nhân viên phụ trách</label>
                                                <br>
                                                <form:select path="staffId">
                                                    <form:option value="">--Chọn nhân viên phụ trách</form:option>
                                                    <form:options items="${model.staffs}"/>
                                                </form:select>
                                            </div>
                                        </div>
                                            </div>
                                            <br>


                                                <button class="btn btn-success btn-next" id="btnSearch" data-last="Finish">
                                                    Tìm kiếm
                                                    <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                                </button>
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
                                        id="btnDeleteCustomer" data-toggle="tooltip" title="Xóa khách hàng"
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

                        <display:column headerClass="text-left" property="fullName" title="Tên"/>
                        <display:column headerClass="text-left" property="staffNames" title="Nhân viên quản lý"/>
                        <display:column headerClass="text-left" property="phone" title="Di động"/>
                        <display:column headerClass="text-left" property="email" title="Email"/>
                        <display:column headerClass="text-left" property="demand" title="Nhu cầu"/>
                        <display:column headerClass="text-left" property="createdBy" title="Người nhập"/>
                        <display:column headerClass="text-left" property="createdDate" title="Ngày nhập"
                                        format="{0,date,dd-MM-yyyy}"/>

                        <display:column headerClass="col-actions" title="Thao tác">
                            <security:authorize access="hasRole('MANAGER')">
                                <button class="btn btn-xs btn-info" data-toggle="tooltip" title="Giao tòa nhà"
                                        onclick="assignmentCustomer(${tableList.id})">
                                    <i class="fa fa-bars" aria-hidden="true"></i>
                                </button>
                            </security:authorize>

                            <a class="btn btn-xs btn-primary" data-toggle="tooltip"
                               title="Cập nhật tòa nhà"
                               href='<c:url value="/admin/customer-edit-${tableList.id}"/>'>
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

</div>
<div class="modal fade" id="assignmentCustomerModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên giao khách hàng</h4>
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

                    </tbody>
                </table>
                <input type="hidden" id="customerId" name="customerId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignCustomer">Giao khách hàng</button>
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
        window.location.replace("/admin/customer-edit");

    });

    function assignmentCustomer(customerId) {
        openModalAssignmentCustomer();
        loadStaff(customerId);
        $('#customerId').val(customerId);
        console.log($('#customerId').val());

    }

    function loadStaff(customerId) {
        $.ajax({
            type: "GET",
            url: "${customerAPI}/" + customerId + "/staffs",
            dataType: "json",
            success: function (response) {
                console.log('success')

                var row = '';
                $.each(response.data, function (index, item) {

                    row += '<tr>';
                    row += '<td><input type="checkbox" value=' + item.staffId + ' id="checkbox_' + item.staffId + '" class="check-box-element" ' + item.checked + '></td>';
                    row += '<td >' + item.fullName + '</td>'
                    row += '</tr>';


                    $('#staffList tbody').html(row);
                })
            },
            error: function (response) {
                console.log('failed')
                console.log(response)
            }
        });
    }

    function openModalAssignmentCustomer() {
        $('#assignmentCustomerModal').modal();

    }

    $('#btn-cancel').click(function (e) {

        showAlertBeforeCancelForm(function () {
            window.location.href = '/admin/customer-list';
        })
    });

    $('#btnAssignCustomer').click(function (e) {
        e.preventDefault();
        var data = {};
        var staffId = [];
        data['customerId'] = $('#customerId').val();
        //$('#staffList').find('tbody input[type=checkbox]')

        var staffId = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();

        data['staffId'] = staffId;

        $.ajax({
            type: "POST",
            data: JSON.stringify(data),
            dataType: "json",
            url: "${assignStaffAPI}",
            contentType: "application/json",
            success: function (response) {
                console.log('success')
                showAlertAfterAssignCustomer(function () {
                    window.location.href = '/admin/customer-list';
                    console.log(response)
                });
            },
            error: function (response) {
                console.log('failed')

            }
        });
    });



    function warningBeforeDelete() {
        showAlertBeforeDelete(function () {
            event.preventDefault();
            var dataArray = $('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            deleteCustomer(dataArray);
        });
    }

    function deleteCustomer(data) {
        $.ajax({
            type: "DELETE",
            data: JSON.stringify(data),
            dataType: "json",
            url: "${customerAPI}",
            contentType: "application/json",
            success: function (res) {
                window.location.href = "<c:url value='/admin/customer-list?message=delete_success'/>";
            },
            error: function (res) {
                console.log(res);
                window.location.href = "<c:url value='/admin/customer-list?message=error_system'/>";
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
