Buenas!

Ya tienen disponible un host interno en un server de pampero para hacer el **deploy productivo** de sus aplicaciones.

Como les decía, tienen a su disposición el host interno **10.16.1.110**, accesible desde el lab y desde `pampero`. Allí podrán publicar los **.war** via **sftp**. Además tiene una base de datos **postgres** con la cual pueden trabajar.

### Deploy

Estos son los pasos a seguir:

* Conectarse a **pampero.itba.edu.ar** como suelen hacer con su user y pass. (Van a tener que subir el **.war** a `pampero` también, asumo saben utilizar herramientas como **putty**, **scp**, etc…)

* Subir via **sftp** el **.war** a **10.16.1.110** a `/web/app.war` (tiene que estar en *ESA* carpeta y con *ESE* nombre). Para esto tienen asignados los siguientes usuarios y claves.

### Credenciales para SFTP

Se las mandaré en un mail siguiente a cada grupo en particular.

Si nunca usaron **sftp**, no se preocupen. Tienen man **sftp** y como verán es similar a otros comandos como **ssh**, **scp**, etc…

Una vez hecho esto, deberían poder ver lo que subieron en `http://pawserver.it.itba.edu.ar/paw-$YEAR$cuatri-$i/`, siendo `$YEAR` el año en curso, siendo `$cuatri` igual a `a` si el semestre es el primer semestre del año o `b` si es el segundo, y `$i` el número de su grupo. Puede que demore unos segundos en actualizarse.

Para conectarse a **postgres** pueden usar las mismas credenciales que usaron para conectarse por **sftp**. Tendrán una db con el nombre de su grupo (que coincide con el nombre de usuario).

Pueden conectarse directamente a la DB usando **psql**, siempre desde el lab o desde pampero. Ejemplo:

`psql -h 10.16.1.110 -U paw-$YEAR$cuatri-$i`

y a continuación se les pedirá la contraseña (de nuevo, es la misma que para **sftp**). El nombre de usuario sigue la misma convención usada para la URL, explicada anteriormente.

