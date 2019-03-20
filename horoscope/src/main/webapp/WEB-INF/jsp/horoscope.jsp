<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body >
<div style="overflow: auto;">
    <h1 style="float: left; margin-top: 0;">Hor&oacute;scopo Online</h1>
</div>

<H3 id="user" >Hola <c:out value="${user.name}" /> </H3>
<H3 id="sign">El horoscopo para <c:out value="${horoscope.sign}" /> es: </H3>
<H4 id="sign-desc"><c:out value="${horoscope.description}" /></H4>

<div class="footer">Proyecto de Aplicaciones web</div>

</body>
</html>