<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>

<div style="overflow: auto;">
    <h1 style="float: left; margin-top: 0;">Hor&oacute;scopo Online</h1>
</div>

<h2>Buen dia, digame su nombre y signo: </h2> <br>

<form action="horoscope" method="POST">
    <input id="form-name" type="text" name="name" title="name">
    <br>
    <input id="form-sign" type="text" name="sign" title="sign">
    <br>
    <input type="submit" onclick="login()">
</form>

<div class="footer">Proyecto de Aplicaciones web</div>

</body>
</html>