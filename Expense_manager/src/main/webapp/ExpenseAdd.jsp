<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Expense</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#deleteExpense").hide();
     $("#updateExpense").hide();
    
    $("#update").click(function(){
        $("#updateExpense").show();
        $("#deleteExpense").hide();
    });
    $("#delete").click(function(){
        $("#deleteExpense").show();
         $("#updateExpense").hide();
    });
});

</script>


<style>
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        /* background-color: rgb(208, 208, 208); */
    }
  form .table th, td {
  border: 2px solid rgb(108, 55, 115);
  border-radius: 10px;
  font-size: 20px;
   }


.heading{
    color: white;
    /* background-color: rgb(108, 59, 253); */
    background-color: black;
    text-align: center;
    margin-bottom: 100px;
    padding: 12px;
    margin: 10px;
}

#add{
    /* background-color: rgb(214, 214, 214); */

}

form .table{
    background-color: rgb(222, 212, 255);
    border: 2px solid rgb(108, 55, 115);
      border-radius: 10px;
     font-size: 20px;
 
}

form .btn {
    margin-left: 150px;
    width: 20%;
  
   
}
.secHeading{
    color: white;
    background-color: rgb(36, 126, 3);
    background-color: black;

    text-align: center;
    margin-bottom: 10px;
    padding: 12px;
    margin: 10px;
    margin-top: 50px;
    
}

.seccontent table th, td{
    background-color: rgb(234, 234, 234);
    border: 2px solid rgb(108, 55, 115);
  border-radius: 10px;
  font-size: 20px;
}

.seccontent .table {
    background-color: rgb(222, 212, 255);
    border: 2px solid rgb(108, 55, 115);
      border-radius: 10px;
     font-size: 20px;
}
table .subheading{
    color: black;
    /* background-color: rgb(108, 55, 115); */
  background-color: black;


}

.radio_check{
    font-size: 22px;
    font-weight: bold;
}

.btn-danger{
    margin-bottom: 20px;
}

.thirdheading{
    color: white;
    /* background-color: rgb(36, 126, 3); */
    /* background-color: black; */

    color: black;
    text-align: center;
    margin-bottom: 10px;
    padding: 12px;
    margin: 10px;
    margin-top: 50px;
    
}

</style>
</head>
<body class="container container-fluid">
	<div id="add">
		<h1 class="heading"> Expense TODO</h1>
		<form action="ExpenseController" method="GET">
			<table class="table">
				<tr >
					<td>Expense Name:</td>
					<td><input type="text" name="ename" placeholder="Type Name Here"></td>
				</tr>
				<tr >
					<td>Expense Price:</td>
					<td><input type="range" value="0" name="eprice" min="0" max="5000" oninput="this.nextElementSibling.value = this.value"> <output>0</output></td>
				</tr>
				<tr >
					<td>Expense Date:</td>
					<td><input type="date" name="edate"></td>
				</tr>
				<tr >
					<td>Expense Color:</td>
					<td><input type="color" name="ecolor"></td>
				</tr>
				<tr >
					<td>Expense URL:</td>
					<td><input type="url" name="eurl" placeholder="Type URL here"></td>
				</tr>
				<tr >
					<td>Expense Remarks:</td>
				<!-- 	<td><input type="text" name="eremark"></td> -->
					<td><textarea rows="4" cols="50" name="eremark" placeholder="Type Remarks here"></textarea></td>
				</tr>
				

				
			</table>
		<div>
            <div>

                <button class="btn btn-primary" type="submit" name="addExpense" value="Add">ADD</button>
                <button class="btn btn-secondary" type="submit" formmethod="post" name="showExpense" value="Show">SHOW</button>
            </div>
		</div>
		</form>
	</div>
    <div class="mt-3 seccontent">
		<h1 class="secHeading">Expenses List </h1>
		<br>
		<table class="table">
			<thead>
				<tr class="subheading">
					<th scope="col">ID</th>
					<th scope="col">Expense Name</th>
					<th scope="col">Expense Price</th>
					<th scope="col">Expense Date</th>
					<th scope="col">Expense Color</th>
					<th scope="col">Expense URL</th>
					<th scope="col">Expense Remark</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="exp" items="${ExpenseList}">
					<tr>
						<th scope="row">${exp.id}</th>
						<td>${exp.ename}</td>
						<td>${exp.eprice}</td>
						<td>${exp.edate}</td>
					    <td><input type="color" value="${exp.ecolor}" disabled></td> 
					    <td>${exp.eurl}</td>
						<td>${exp.eremark}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<form name="formid" action="ExpenseController" method="POST">
			<br> <h2 class="thirdheading" > Select By ID </h2> <select class="browser-default custom-select" name="id" onchange="document.getElementById('butn').click()">
			    <option value="">--Select one--</option>
				<c:forEach items="${ExpenseList}" var="Expense">
     			
     				<option value="${Expense.id}" ${record.id == Expense.id ? 'selected' : ''}>${Expense.id}</option>
     				
				</c:forEach>
			</select> 
			<input class="btn btn-white mt-2" type="submit" hidden="true" id="butn" value="Fill existing field values" name="showInfo" formmethod="get">
			<br>
			<br>
			<div class="d-flex flex-column radio_check">
			<div><input type="radio"  id="update" name="choice" onclick="document.getElementById('hiddenUpdate').hidden=!this.checked;" ${empty record ? 'disabled': ''}>   Update</div>
			<div><input type="radio" id="delete" name="choice" 
				onclick="document.getElementById('hiddenUpdate').hidden=this.checked;" ${empty record ? 'disabled': ''}>   Delete<br>
				</div></div>
			<div id="hiddenUpdate" hidden="true" >
			<table class="table mt-3" border="2">
				<tr >
					<td>Update Expense Name:</td>
					<td><input type="text" id="enameupdate" name="enameupdate" value="${record.ename}"></td>
				</tr>
				<tr >
					<td>Update Expense Price:</td>
					<td><input type="text" id="epriceupdate" name="epriceupdate" value="${record.eprice}" ></td>
				</tr>
				<tr >
					<td>Update Expense Date:</td>
					<td><input type="date" id="edateupdate" name="edateupdate" value="${record.edate}" ></td>
				</tr>
				<tr >
					<td>Update Expense Color:</td>
					<td><input type="color" id="ecolorupdate" name="ecolorupdate" value="${record.ecolor}" ></td>
				</tr>
				<tr >
					<td>Update Expense URL:</td>
					<td><input type="url" id="eurlupdate" name="eurlupdate" value="${record.eurl}" ></td>
				</tr>
				<tr >
					<td>Update Expense Remark:</td>
					<td><textarea rows="4" cols="50" name="eremarkupdate" id="eremarkupdate">${record.eremark}</textarea></td>
				</tr>
			</table>
			</div>	
			<button type="submit" class="btn btn-success" id="updateExpense" name="updateExpense">
				UPDATE</button>
			<br> <br>
			<button class="btn btn-danger" type="submit" id="deleteExpense" name="deleteExpense">
				DELETE</button>




		</form>
	</div>
	
</body>
</html>




