
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body>
<h1>Simple Calculator</h1>
<form method="post" action="/caculator">
    <fieldset>
        <legend>Calculator</legend>
        <table >
            <tr>
                <td>First operand:</td>
                <td><input class="form-control" name="first_Operand" type="text"/></td>
            </tr>
            <tr>
                <td>Second operand:</td>
                <td><input class="form-control" name="sercond_Operand" type="text"/></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td>

                        <input type="button" name="+" value="Addition">
                        <input type="button" name="-"  value="Subtraction">
                        <input type="button" name="+"  value="Multiplication">
                        <input type="button" name="+"  value="Division">

                </td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" class="btn btn-outline-info" value="calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>