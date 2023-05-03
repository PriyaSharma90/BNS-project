<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="assets/jquery-ui-1.12.1/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="assets/jquery.jqGrid-4.4.3/css/ui.jqgrid.css" />

<script type="text/javascript"
	src="assets/jquery-ui-1.12.1/external/jquery/jquery.js"></script>
<script type="text/javascript"
	src="assets/jquery/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript"
	src="assets/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="assets/jquery.jqGrid-4.4.3/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript"
	src="assets/jquery.jqGrid-4.4.3/js/i18n/grid.locale-en.js"></script>
<script type="text/javascript"
	src="assets/jquery.jqGrid-4.4.3/js/jquery.jqGrid.src.js"></script>
<!-- <script type = "text/javascript" src="assets/jqGrid/src/grid.common.js"></script>
<script type = "text/javascript" src="assets/jqGrid/src/grid.formedit.js"></script>
 -->
<title>Insert title here</title>

</head>
<body>
	<table id="list">
	</table>
	<div id="gridPager"></div>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			jQuery("#list").jqGrid({
				mtype : "POST",
				datatype : "JSON",
				height : "auto",
				url : "JqgridOperation",
				editurl: 'JqgridOperation',
				//editurl : 'GridUpdate',
				colModel : [ {
					label : "Id",
					name : 'id',
					index : 'id',
					width : 150,
					editable : false
				}, {
					label : "Name",
					name : 'name',
					index : 'name',
					width : 150,
					editable : true,
					edittype:'text'
				}, {
					label : "Password",
					name : 'epassword',
					index : 'epassword',
					width : 150,
					editable : true,
					edittype:'password'
					
				}, {
					label : "Email",
					name : 'email',
					index : 'email',
					width : 150,
					editable : true,
					edittype:'text'
					
				}, {
					label : "Country",
					name : 'country',
					index : 'country',
					width : 150,
					editable : true,
					edittype:'select',
					editoptions:{value:{India:'India',USA:'USA',UK:'UK',London:'London',Other:'Other'}} 
				} ],

				height : '100%',
				viewrecords : true,
				caption : 'Employee Report',
				emptyrecords : 'No records',
				rowNum : 50,
				iconSet : "fontAwesome",
				//gridview : true,
				pager : '#gridPager',
				rowList : [ 10, 20, 30, 40 ],
				jsonReader : {
					root : "rows",
					page : "page",
					total : "total",
					records : "records",
					repeatitems : false,
					Id : "0"
				},
				autowidth : true,
			});
			$('#list').navGrid('#gridPager', {
				edit : true,
				add : true,
				del : true,
				view : false,
				search : false,
				refresh : true,
				position : "left",
				cloneToTop : true
			},// options for the Edit Dialog
			{
				editCaption : "The Edit Dialog",
				recreateForm : true,
				closeAfterEdit : true,
				onclickSubmit : function(response, postdata) {

					edit();
				}
			},
			// options for the Add Dialog
			{
				closeAfterAdd : false,
				recreateForm : true,
				onclickSubmit : function(response, postdata) {

					add();

				},
				errorTextFormat : function(data) {
					return 'Error: ' + data.responseText
				}
			},
			// options for the Delete Dailog
			{
				onclickSubmit : function(response, postdata) {

					del();
				},

				errorTextFormat : function(data) {

					return 'Error: ' + data.responseText
				}
			});
		});
		function add() {
			var id = $("#id").val();
			var name = $("#name").val();
			var epassword = $("#epassword").val();
			var email = $("#email").val();
			var country = $("#country").val();

			$.ajax({
				type : "POST",
				data : {
					id : id,
					name : name,
					epassword : epassword,
					email : email,
					country : country,
				},
				url : "AddServlet",
				success : function(gridmodel) {
					alert("Data Inserted Successfully");
				},
				error : function(gridmodel) {
					alert("FAIL");
				}

			});

		}

		function edit() {
			var rowId = $("#list").jqGrid('getGridParam', 'selrow');
			var rowData = jQuery("#list").getRowData(rowId);
			if (rowData != null) {
				var id = $("#id").val();
				var name = $("#name").val();
				var epassword = $("#epassword").val();
				var email = $("#email").val();
				var country = $("#country").val();
			}
			$.ajax({
				type : "POST",
				data : {
					'id' : rowId,
					name : name,
					epassword : epassword,
					email : email,
					country : country,
				},
				url : "GridUpdate",
				success : function(gridmodel) {
					alert("Row Updated Successfully");
				},
			/* error : function(gridmodel) {
				alert("FAIL");
			} */
			});
		}

		function del() {
			var rowId = $("#list").jqGrid('getGridParam', 'selrow');
			var rowData = jQuery("#list").getRowData(rowId);
			if (rowData != null)
				var id = $("#id").val();
			$.ajax({
				type : "GET",
				data : {
					'id' : rowId,
				},
				url : "DeleteEmpServlet",

				success : function(gridmodel) {

					alert("Row Deleted Successfully");
				},
				error : function(gridmodel) {
					alert("FAIL");
				}
			});

		}
	</script>

</body>
</html>