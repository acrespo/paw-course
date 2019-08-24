Tomcat
======
---------------------------


Hay un mundo de cosas por explorar con respecto a Tomcat. Las iremos viendo conforme sean necesarias. Siempre pueden investigar por sus propios medios pero lo que nos importa que tengan bien en claro es lo siguiente:

Tomcat tiene varios componentes. **Catalina** es el principal componente, es el contenedor de Servlets. Implementa las especificaciones de servlet y JavaServer Pages (JSP).
Para más info les recomiendo este [post](https://www.mulesoft.com/tcat/tomcat-catalina).


Instalación y uso
======
---------------------------

Normalmente, pueden instalar Tomcat con el Package Manager de su sistema operativo favorito.
Aquí les dejo algunos links con guías útiles al respecto:

- [Tomcat 8 en ubuntu](https://www.digitalocean.com/community/tutorials/how-to-install-apache-tomcat-8-on-ubuntu-16-04) y [otra guía con más detalles](https://www.linode.com/docs/development/frameworks/apache-tomcat-on-ubuntu-16-04/)
- [Tomcat 9 en ubuntu](https://linuxize.com/post/how-to-install-tomcat-9-on-ubuntu-18-04/)
- [Tomcat 7 en ubuntu](https://www.liquidweb.com/kb/how-to-install-apache-tomcat-7-on-ubuntu-14-04/)
- [Tomcat (latest available) en OSX](https://github.com/mhulse/mhulse.github.io/wiki/Installing-Apache-Tomcat-using-Homebrew-on-OS-X-Yosemite )


Si usan Windows, o las guías previas no les sirven por el motivo que sea, siempre pueden descargarse la versión standalone del [sitio de Apache](https://archive.apache.org/dist/tomcat/).

En este último caso, los programas o scripts para interactuar con el servidor los encontrarán en la carpeta `bin` de la instalación. Los que normalmente usaremos son `bin/startup.sh` y `shutdown.sh` (si están en un sistema Unix, si están en Windows pueden usar las versiones `.bat` de los mismos).

Como verán, todos archivos de la carpeta `bin` no vienen con permisos de ejecución (buena práctica de seguridad). Para poder utilizar estos scripts es necesario cambiarles los permisos, cosa que podemos hacer con `chmod +x bin/*`.

Para levantar/prender el servidor Tomcat usaremos el script `/bin/startup.sh`. Tener en cuenta que el output puede variar según la versión de Tomcat, la versión de Java, y, obviamente, de acuerdo a la carpeta donde hayan ubicado la carpeta de tomcat.

```
$ sh bin/startup.sh
Using CATALINA_BASE:   /Users/acrespo/tmp/apache-tomcat-7.0.76
Using CATALINA_HOME:   /Users/acrespo/tmp/apache-tomcat-7.0.76
Using CATALINA_TMPDIR: /Users/acrespo/tmp/apache-tomcat-7.0.76/temp
Using JRE_HOME:        /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home
Using CLASSPATH:       /Users/acrespo/tmp/apache-tomcat-7.0.76/bin/bootstrap.jar:/Users/acrespo/tmp/apache-tomcat-7.0.76/bin/tomcat-juli.jar
Tomcat started.
```

Una vez levantado, si accedemos desde el browser (o via cUrl) a `http://localhost:8080/` deberiamos ver la página index de Tomcat (el contenido varía según la versión). **El puerto 8080 es el puerto default de Tomcat**.


Para bajar/apagar el servidor usamos el script `/bin/shutdown.sh`.

```
$ sh bin/shutdown.sh
Using CATALINA_BASE:   /Users/acrespo/tmp/apache-tomcat-7.0.76
Using CATALINA_HOME:   /Users/acrespo/tmp/apache-tomcat-7.0.76
Using CATALINA_TMPDIR: /Users/acrespo/tmp/apache-tomcat-7.0.76/temp
Using JRE_HOME:        /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home
Using CLASSPATH:       /Users/acrespo/tmp/apache-tomcat-7.0.76/bin/bootstrap.jar:/Users/acrespo/tmp/apache-tomcat-7.0.76/bin/tomcat-juli.jar
```

Con el servidor apagado, acceder a `http://localhost:8080/` nos debería dar un error.

### Cambiar el puerto default de Tomcat

Como se mencionó anteriormente, Tomcat escucha/atiende requests por default en el puerto `8080`. Si se encuentran errores al intentar levantar Tomcat, puede que la razón sea que el puerto ya esté siendo usado por alguna otra aplicación. Por ejemplo, por algún `nginx` que hayan configurado en otra materia (cough cough, Protocolos de Comunicación) y les haya quedado corriendo, o por servidores, aplicaciones o contenedores de Docker que hayan corrido alguna vez y nunca apagaron (por ejemplo, entornos de desarrollo locales que usen algun Tomcat, de los que estén trabajando).

Una buena forma de chequear esto es scanear los puertos que tienen abiertos en su máquina. Para esto ver la sección **Port Scanning** de esta guía.

Sea como sea, si necesitan cambiar el puerto default de Tomcat, esto es lo que deben hacer:

- Abrir el archivo `conf/server.xml` (contenido en la carpeta de instalación de Tomcat).
- Buscar la línea con la configuración del `connector`, que normalmente se vería asi:
	- `<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />`
- Cambiar el número de puerto de 8080 al valor que deseen, por ejemplo 8081, guardar y volver a levantar Tomcat.
- Deberían poder acceder a Tomcat en `http://localhost:8081/`


Archivos de logs
======
---------------------------

* Catalina.out: es el log donde se imprimen la sálida standard y la sálida de error del servidor (System.out y System.err). Van a ver que todo lo que se imprima en los archivos catalina.* lo vana ver también acá.

* catalina.*: es el log de catalina, el contenedor de servlets. Acá van a tener información acerca de los deploys que vayan realizando y el estado de ellos. Si tienen problemas con el deploy es un buen lugar para investigar. 
 
* localhost\_access\_log:  es el log donde se registran los accesos al servidor Tomcat. Como vimos en clase, el formato de log no contiene mucha información más alla de data båsica acerca de los requests http recibidos. Es un formato bastante estándar.
 
* localhost.*: es el log del host, aca van a ver errores de aplicación, por ejemplo errores en los jsp aparecen acá.
 
* host-manager.* y manager.*: son los logs de aplicaciones (en este caso de la aplicacion host-manager y la aplicación manager). 


Versiones
======
---------------------------

Mi recomendación es que se bajen la version **7.0.76**, ya que **es la versión del servidor donde realizar las entregas de sus Trabajos Prácticos**. Esta versión es compatible con Java 6, 7 y 8. Si tienen alguna de esas versiones de Java instaladas, no van a tener ningún problema. Si tienen instalado Java 9 o superior, pueden instalar alguna de las versiones anteriores y mantener ambas versiones conviviendo en la máquina. Solo asegurense de setear correctamente la variable de entorno **$JAVA_HOME** y/o **JRE_HOME** acordemente según la versión que quieran usar en cada momento.

¿Pueden usar otras versiones de Tomcat para probar localmente? SI.

¿Por qué recomendamos usar esa versión vieja, cuando Tomcat ya va por la versión 9? Porque justamente, muchas cosas cambiaron y podrían tener el problema de tener su aplicación funcionando OK en un Tomcat con una versión nueva en sus máquinas pero al hacer el deploy en el servidor de la entrega, no anda (nos suele pasar).


Manejo de versiones de Java
======
---------------------------


En caso de que tengan problemas con las versiones de Java y deban instalar otra versión y/o mantener varias versiones en su máquina, pueden hacer uso de la herramienta [jenv](http://www.jenv.be/). Esta herramienta tengo funciona en cualquier sistema unix, si no les funciona por algún motivo, o si usan Windows, pueden probar [esta otra herramienta](http://www.jenv.io/#), que funciona de forma muy similar.

Van a encontrar que las guías de instalación y uso de jEnv suelen necesitar **conocer la carpeta de la instalación de Java**. Si no saben cual es esta carpeta en su sistema operativo les ahorro la búsqueda en Google, dirigiendolos a [esta respuesta de SO si usan un sistema operativo unix](https://stackoverflow.com/a/23427862/901465) o [esta otra respuesta si usan OSX](https://stackoverflow.com/a/18144853/901465).

Les recomiendo leer el siguiente [post](http://davidcai.github.io/blog/posts/install-multiple-jdk-on-mac/), que tiene un ejemplo de un típico caso de uso, el mismo que seguramente necesiten. Quizás no con las mismas versiones exactas de Java pero igualmente les va a servir. Tanto en mac como en linux debería funcionar de la misma forma, salvo la forma de instalar la herramienta.

Si les interesa, pueden ver el [repo de Giuthub](https://github.com/gcuisinier/jenv) que tiene instrucciones más detalladas y alguno ejemplos extras.


Port scanning
======
---------------------------


Para ver que puertos tienen abiertos en su localhost pueden usar el comando `nmap`

`nmap localhost`

En las últimas versiones de mac no viene instalado por default, lo pueden instalar con homebrew:

`brew install nmap`

O bajar el dmg desde el [sitio oficial de nmap.](https://nmap.org/)

Nota: en Windows en teoría deberían poder utilizar el mismo comando. En distros de Linux también lo pueden usar, hasta donde sé, viene instalado por default en casi todas. Pero sino, en Linux tmb pueden usar el comando netstat que es mucho más amistoso que el de mac OS X:

`netstat`
o
`netstat -ntl`

Pueden jugar un poco con los flags de `netstat`, en Linux es una herramienta muy útil. Ya la utilizarán a diestra y siniestra en Protocolos de Comunicación.


Horoscope Project
======
---------------------------


Con respecto al proyecto Horoscope. Quería dejarles un par de comentarios de cosas que vimos medio por arriba.

Les recomiendo importar el proyecto a su IDE preferido. Recordar importarlo como proyecto maven. 

Como vimos, bajo la carpeta `src/main/java` vamos a encontrar el código Java.

El archivo `web.xml` es interesante porque contiene varias configuraciones de nuestra webapp. Por ejemplo, acá es donde están los mapeos de urls a servlets, es decir, que servlet atiende los pedidos de determinada url.


Maven
======
---------------------------


Dado que es un proyecto `maven`, para buildear/compilar vamos a usar dicha herramienta. 

Para esto es necesario tener instalado maven. En general viene instalado con el SO. Para verificar esto basta correr

`mvn --version`

Si no esta instalado, cualquier instalador de paquetes de una distro de Linux decente te permite instalarlo. En mac, homebrew permite instalarlo:

`brew install maven`

Sino, y si usan Windows, pueden descargarlo del [sitio oficial de maven](https://maven.apache.org/) e instalarlo.

Existen plugins de maven para los IDE (las versiones mas nuevas CREO que los traen ya incorporados), que permiten buildear desde el IDE. Como esto puede variar levemente dependiendo del IDE, les pido que lo investiguen por su cuenta, sino mándenos un mail o en la próxima clase lo vemos.

De cualquier forma, siempre podemos buildear por línea de comandos. Más adelante verán más en profundidad los comandos disponibles que tiene maven. Por ahora, nos alcanza con hacer:

`mvn clean package`

Esto, si el proyecto compila correctamente (BUILD SUCCESSFUL) les va a generar en la carpeta `target`, un archivo `.war` (junto con varias otras cosas). Pueden pensar a este archivo `.war` como los `.jar` que ya conocen. Copien este archivo a la carpeta `webapps` de tomcat y vean lo que sucede.
Tomcat, si esta levantado y con la configuración que hablamos en clase de estar "watcheando"/"escuchando" los cambios de la carpeta webapps, les va a extraer el contenido del `.war` y setupear su webapp. 

Ahora, veamos que sucede si accedemos a `localhost:8080/Horoscope/welcome`

(Si todo salió bien deberian poder ver la webapp Horoscope, que les invita a ingresar su nombre y signo del zodiaco :p)

Congrats! Acaban de hacer el deploy de la webapp. 

Les recomiendo que lo miren y jueguen un poco, intenten hacerle alguna modificación, como por ejemplo mostrar una sola página con TODO el horóscopo, es decir para cada signo, mostrar que dice el horóscopo.

Para realizar cambios y verlos en el browser van a tener que buildear de nuevo y volver a hacer el deploy (copiar el `.war` a la carpeta `webapps` de tomcat). Recomendación, previo al deploy, borren tanto el `.war`, como la carpeta de su webapp de tomcat.


