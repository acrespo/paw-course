<%@ include file="header.jsp" %>

<p/>

<jsp:useBean id="user" class="ar.edu.itba.it.paw.horoscope.domain.user.User" scope="request"/> 
<jsp:useBean id="horoscope" class="ar.edu.itba.it.paw.horoscope.domain.horoscope.Horoscope" scope="request"/> 					      

<H3>Hola <jsp:getProperty name="user" property="name" /></H3>
<H3>El horoscopo para <jsp:getProperty name="horoscope" property="sign" /> es: </H3>
<jsp:getProperty name="horoscope" property="description" />

<h3>Para volver a la pagina anterior haga click <A href="<%= response.encodeURL("welcome")%>">aqui</a></h3>

<%@ include file="footer.jsp" %>