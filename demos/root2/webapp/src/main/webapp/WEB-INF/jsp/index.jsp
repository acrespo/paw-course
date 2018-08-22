<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<body>

<c:url var="url" value="/users/list"> LISTA </c:url>

<form role="form" action="signUp" method="post">
    <div>
        <div class="form-group">
            <label>Nombre </label><input type="text" class="form-control"
                                        name="name" placeholder="Nombre" />
        </div>
        <div class="form-group">
            <label>Contraseña </label><input type="password"
                                             class="form-control" name="password" placeholder="Contraseña" />
        </div>
        <button type="submit" class="btn btn-success">Registrarse</button>
    </div>
</form>
</body>
</html>