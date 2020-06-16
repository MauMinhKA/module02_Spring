<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Login Page</title>
    <style type="text/css">
        body{
            margin-left: 42%;
        }
        .chuyendoi {
            border-radius: 5px ;
            background: aqua;
            height:180px; width:240px;
            margin:0;
            padding:10px;
            border:1px #CCC solid;
        }
        .chuyendoi input {
            padding:5px; margin:5px
        }
    </style>
</head>
<body>
<h2>Currency Converter</h2>
<form method="post" action="/index2">
    <div class="chuyendoi">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
    </div>
</form>
</body>
</html>