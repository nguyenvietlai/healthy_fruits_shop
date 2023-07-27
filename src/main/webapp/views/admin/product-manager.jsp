<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product manager</title>
<%@include file="/commons/admin-css.jsp"%>
<link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<jsp:include page="nav-bar.jsp"></jsp:include>

			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Product managerment</h3>
						</div>
					</div>
					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_title">
									<h2>Form CRUD</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<br />


									<form:form action="/admin/product/add" method="post"
										id="demo-form2" class="form-horizontal form-label-left"
										modelAttribute="product" enctype="multipart/form-data">
										<form:input type="hidden" id="first-name" required="required"
											class="form-control " path="id" />
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align"
												for="first-name">Name<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input type="text" id="first-name" required="required"
													class="form-control " path="name" />
											</div>
										</div>

										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align"
												for="last-name">Price<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input type="number" id="last-name" name="last-name"
													required="required" class="form-control" path="price" />
											</div>
										</div>

										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align"
												for="last-name">Category<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">

												<form:select class="form-control" path="category.id">
													<form:options items="${categories }" itemValue="id"
														itemLabel="name" />
												</form:select>

											</div>
											<button type="button" class="btn btn-success"
												data-toggle="modal" data-target="#exampleModal">new
												cate</button>
										
										</div>

										<!-- 									 -->
										<div class="form-group row">
											<label class="col-form-label col-md-3 col-sm-3 label-align ">Description<span
												class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:textarea class="form-control" rows="3"
													placeholder="Description of product" path="description" />
											</div>
										</div>
										<c:if test="${newForm != null }">
											<div class="form-group row">
												<label class="col-form-label col-md-3 col-sm-3 label-align ">Image
													description<span class="required">*</span>
												</label>
												<div class="col-md-6 col-sm-6 ">

													<table id="fileTable">
														<tr>
															<td><input name="files" type="file" /></td>
														</tr>
													</table>
													<br /> <input onclick="addFile()" type="button"
														value="Add File" />

												</div>
											</div>
										</c:if>
										<c:if test="${newForm == null }">
											<c:forEach var="e" items="${product.imagesofproducts }">
												<div class="item form-group">
													<label class="col-form-label col-md-3 col-sm-3 label-align"
														for="last-name">Image item </label>
													<div class="col-md-6 col-sm-6 ">
														<li><img style="width: 50px; height: 50px;" alt=""
															src="/templates/assets/images/${e.image }"><span
															class="close">&times;</span></li>
													</div>
													<input type="hidden" value="${ e.image }"
														name="oldImageChange">
												</div>
												<input type="hidden" value="${ e.image }" name="oldImage">

											</c:forEach>
											<label class="col-form-label col-md-3 col-sm-3 label-align"
												for="last-name">Image item </label>
											<div class="form-group row">

												<div class="col-md-6 col-sm-6 ">

													<table id="fileTable">

													</table>
													<br /> <input onclick="addFile()" type="button"
														value="Add File" />

												</div>
											</div>
										</c:if>
										<div class="ln_solid"></div>

										<%-- 										<form:input path="imagesofproducts"  id='files'  type='file' multiple/> --%>
										<!--  										 <output id='result' /> -->

										<div class="item form-group">
											<div class="col-md-6 col-sm-6 offset-md-3">
												<c:if test="${newForm!=null }">
													<button class="btn btn-primary" type="submit">ADD</button>
												</c:if>
												<a style="color: white;" href="/admin/products-manager"
													class="btn btn-primary" type="reset">Reset</a>
												<c:if test="${newForm==null }">
													<button formaction="/admin/product/update"
														class="btn btn-success">Update</button>
												</c:if>
											</div>
										</div>

									</form:form>






								</div>
							</div>
						</div>


						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Default Example <small>Users</small>
									</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-expanded="false"><i
												class="fa fa-wrench"></i></a>
											<div class="dropdown-menu"
												aria-labelledby="dropdownMenuButton">
												<a class="dropdown-item" href="#">Settings 1</a> <a
													class="dropdown-item" href="#">Settings 2</a>
											</div></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<div class="row">
										<div class="col-sm-12">
											<div class="card-box table-responsive">

												<table id="datatable"
													class="table table-striped table-bordered"
													style="width: 100%">
													<thead>
														<tr>
															<th>Name</th>
															<th>Price</th>
															<th>Image</th>
															<th>Description</th>
															<th>Created date</th>
															<th>Action</th>
														</tr>
													</thead>


													<tbody>
														<c:if test="${products != null }">
															<c:forEach var="e" items="${products}" varStatus="loop">
																<tr>
																	<td>${e.name }</td>
																	<td>${e.price }</td>
																	<td>${e.image }</td>
																	<td>${e.description }</td>
																	<td>${e.createdate }</td>
																	<td><a href="/admin/product/edit/${e.id }"
																		class="btn btn-primary">Edit</a> <a
																		href="/admin/product/delete/${e.id }"
																		class="btn btn-primary">Delete</a></td>
																</tr>
															</c:forEach>
														</c:if>


													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
		<!-- Modal -->
											<div class="modal fade" id="exampleModal" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
													 <form action="/admin/category/add" method="post">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Add new category</h5>
														
												
														</div>
														<div class="modal-body">
																
														          <div class="form-group">
														            <label for="recipient-name" class="col-form-label">Name:</label>
														            <input type="text" class="form-control" id="recipient-name" name="cate">
														          </div>
														   
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Close</button>
															<button type="submit" class="btn btn-primary">Save
																changes</button>
														</div>
														
														     </form>
													</div>
												</div>
											</div>

	<%@include file="/commons/admin-script.jsp"%>
	<script type="text/javascript">
		function addFile() {

			var fileIndex = $('#fileTable tr').children().length - 1;
			$('#fileTable').append(
					'<tr><td>' + '   <input type="file" name="files" />'
							+ '</td></tr>');

		}
	</script>

	<script>
		var closebtns = document.getElementsByClassName("close");
		var i;

		for (i = 0; i < closebtns.length; i++) {
			closebtns[i]
					.addEventListener(
							"click",
							function() {

								this.parentElement.parentElement.parentElement.parentElement
										.removeChild(this.parentElement.parentElement.parentElement);
							});
		}
	</script>


</body>
</html>