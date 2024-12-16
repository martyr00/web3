<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Calculate Function</title>
  <style>
    body {
      background-color: #2f2f2f;
      color: white;
      font-family: Arial, sans-serif;
      padding: 20px;
    }

    h2 {
      text-align: center;
    }

    label, input {
      font-size: 16px;
      margin: 10px 0;
    }

    input[type="text"] {
      padding: 5px;
      width: 200px;
      background-color: #444;
      color: white;
      border: 1px solid #fff; /* Белая граница */
    }

    input[type="submit"] {
      padding: 10px 20px;
      background-color: #FFD700;
      color: black;
      border: none;
      font-size: 16px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #FFA500;
    }

    form {
      text-align: center;
      margin-top: 20px;
    }
  </style>
</head>
<body>

<h2>Enter the value for the calculation</h2>

<form action="calculate" method="get">
  <label for="start">Start:</label>
  <input type="text" id="start" name="start" required><br><br>

  <label for="end">End:</label>
  <input type="text" id="end" name="end" required><br><br>

  <label for="step">Step:</label>
  <input type="text" id="step" name="step" required><br><br>

  <input type="submit" value="Calculate">
</form>

</body>
</html>
