<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 4/17/2017
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<table id="list">
    <tr id="start">
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th colspan="2">Actions</th>
    </tr>
</table>


<form id="addUserInfoForm" style="display: none">

    <label for="name">Name:</label>
    <span id="incorectName"></span>
    <input id="name" name="name" type="text" size="25" maxlength="30" value="" placeholder="name"/> <br/>
    <label for="email">Email:</label>
    <span id="incorectEmail"></span>
    <input id="email" name="email" type="email" size="25" maxlength="30" value="" placeholder="email"/> <br/>
    <label for="password">Password</label>
    <span id="incorectpass"></span>
    <input id="password" name="password" type="password" size="25" maxlength="30" value="" placeholder="password"/>
    <br/>

    <input id="addUserSubmit" type="submit">Add Info</input>
</form>

<button id="showForm">Add</button>

<script>
    generateTable();
    $(document).ready(function () {
        showUserForm();
        submitUserForm();


    });
    function submitUserForm() {
        $("#addUserInfoForm").submit(function (event) {
            var name = $("#name").val();
            var email = $("#email").val();
            var pass = $("#password").val();
            var json = {"name": name, "email": email, "password": pass};
            addUser(json);
            hideUserForm();
            event.preventDefault();
        });
    }

    function showUserForm() {

        $("#showForm").click(function () {
            $("#addUserInfoForm").show(1000, function () {
                $("#showForm").hide();
            });
        });
    }

    function addUser(json) {
        $.ajax({
            url: "adduser",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(json),
            success: function () {
                alert("User add successful.");
            }
        });
    }

    function generateTable() {
        $("#list").append($.ajax({
            url: "userlist",
            datatype: "json",
            type: "Get",
            success: function (data) {
                var list = JSON.parse(data);
                for (var user = 0; user < list.length; user++) {
                    $("#list").append("<tr id='"+user+"'><td>" + list[user].id + "</td><td>" + list[user].name + "</td><td>" + list[user].email + "</td><td><button id='edit' type='button'onclick='editUser(" + list[user].id + ","+user+")'>Edit</button></td><td><button id='delete' type='button' onclick='deleteuser(" + list[user].id + ")'>Delete</button></td></tr>");
                }
            }

        }));
    }

    function hideUserForm() {
        $("#name").val("");
        $("#email").val("");
        $("#pass").val("");
        $("#addUserInfoForm").hide(1000, function () {
            $("#showForm").show();
        });
    }

    function deleteuser(id) {
        $.ajax({
            url: "deleteuser",
            datatype: "json",
            type: "POST",
            data: JSON.stringify(id),
            contentType: "application/json",
            success: function () {
            }

        });
    }
    function editUser(id,tr) {
            $(document.getElementById(tr)).after("<tr><td></td><td ><input id='editname' type='text'></td><td><input id='editemail' type='email'></td><td colspan='2'><button id='OK' type='button'>Accept</button></td></tr>");
        $("#OK").click(function () {
            var name = $("#editname").val();
            var email = $("#editemail").val();

        $.ajax({
            url: "updateuser",
            datatype: "json",
            type: "POST",
            data: JSON.stringify(id,name,email),
            contentType: "application/json",
            success: function () {
                alert("User updated.")
            }
        });
    });
    }

</script>

</body>
</html>