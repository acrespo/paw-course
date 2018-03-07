<%@ include file="header.jsp" %>

<p/>
   
<h2>Buen dia, digame su nombre y signo: </h2> <br>
<form action="horoscope" method="POST">
	<input type="text" length="20" name="name">
	<p/><br>
	<input type="text" length="20" name="sign">
	<p/><br>
	<input type="submit">
</form>

<%@ include file="footer.jsp" %>