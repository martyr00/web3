<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculation Results</title>
    <style>
        body {
            background-color: #2f2f2f;
            color: white;
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        h2, h3 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #fff;
        }

        th {
            background-color: #444;
        }

        tr:nth-child(even) {
            background-color: #3c3c3c;
        }

        tr:nth-child(odd) {
            background-color: #2f2f2f;
        }

        a {
            color: #FFD700;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h2>Calculation results</h2>

<table>
    <tr>
        <th>i</th>
        <th>x</th>
        <th>y</th>
    </tr>
    <%
        double[] xValues = (double[]) request.getAttribute("xValues");
        double[] yValues = (double[]) request.getAttribute("yValues");

        for (int i = 0; i < xValues.length; i++) {
    %>
    <tr>
        <td><%= i %></td>
        <td><%= xValues[i] %></td>
        <td><%= yValues[i] %></td>
    </tr>
    <% } %>
</table>

<h3>Max Index: <%= request.getAttribute("maxIndex") %></h3>
<h3>Min Index: <%= request.getAttribute("minIndex") %></h3>
<h3>Sum: <%= request.getAttribute("sum") %></h3>
<h3>Average: <%= request.getAttribute("average") %></h3>

<br>
<a href="index.jsp">Back</a>
</body>
</html>
