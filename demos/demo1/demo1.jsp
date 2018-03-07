<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
	<TITLE>Demo JSP</TITLE>
	<LINK REL=STYLESHEET HREF="style1.css" TYPE="text/css">
</HEAD>
<BODY>
<H2>Demo JSP</H2>
  <LI>La hora actual es: <%= new java.util.Date() %>

  <% String mensaje = request.getParameter("mensaje");
     if (mensaje != null) {
	    mensaje = mensaje.toUpperCase();
     } else {
	    mensaje = "Default";
     }
   %>

  <LI>El parámetro <CODE>mensaje</CODE> vale: <%= mensaje %>
</BODY>
</HTML>