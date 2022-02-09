<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>

<h1>List of customers</h1>
${customers}

<br/>

<sec:authorize access="hasAuthority('ROLE_ADMIN')">
    <h2>To add new customer press "Add customer" button</h2>
    <form method="POST" action="/Spring_4_Additional_war_exploded/customer/add">
        <table>
            <tr>
                <td><label for="name">FirstName</label></td>
                <td><input type="text" name="name" id="name"/></td>
            </tr>
            <tr>
                <td><label for="lastName">LastName</label></td>
                <td><input type="text" name="lastName" id="lastName"/></td>
            </tr>
            <tr>
                <td><label for="age">Age</label></td>
                <td><input type="number" name="age" id="age"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Add Customer">
                </td>
            </tr>
        </table>
    </form>
</sec:authorize>

<br/><br/>
<form method="POST" action="/Spring_4_Additional_war_exploded/customer/findByName">
    <table>
        <tr>
            <td><label for="name">FirstName</label></td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Search by name">
            </td>
        </tr>
    </table>
</form>

<sec:authorize access="hasAuthority('ROLE_ADMIN')">
    <br/><br/>
    <form method="POST" action="/Spring_4_Additional_war_exploded/customer/deleteByName">
        <table>
            <tr>
                <td><label for="name">FirstName</label></td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Delete by name">
                </td>
            </tr>
        </table>
    </form>

    <br/><br/>
    <form method="POST" action="/Spring_4_Additional_war_exploded/customer/update">
        <table>
            <tr>
                <td><label for="id">ID</label></td>
                <td><input type="number" name="id" id="id"/></td>
            </tr>
            <tr>
                <td><label for="name">FirstName</label></td>
                <td><input type="text" name="name" id="name"/></td>
            </tr>
            <tr>
                <td><label for="lastName">LastName</label></td>
                <td><input type="text" name="lastName" id="lastName"/></td>
            </tr>
            <tr>
                <td><label for="age">Age</label></td>
                <td><input type="number" name="age" id="age"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </form>
    </body>
    </html>
</sec:authorize>