<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp" %>

<p/>							   

<H3>Hola <c:out value="${user.name}" /> </H3>
<H3>El horoscopo para <c:out value="${horoscope.sign}" /> es: </H3>
<H4><c:out value="${horoscope.description}" /></H4>

<%@ include file="footer.jsp" %>