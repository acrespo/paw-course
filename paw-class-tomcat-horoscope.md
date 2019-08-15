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

Tomcat
======
---------------------------


Hay un mundo de cosas por explorar con respecto a Tomcat. Las iremos viendo conforme sean necesarias. Siempre pueden investigar por sus propios medios pero lo que nos importa que tengan bien en claro es lo siguiente:

Tomcat tiene varios componentes. **Catalina** es el principal componente, es el contenedor de Servlets. Implementa las especificaciones de servlet y JavaServer Pages (JSP).
Para más info les recomiendo este [post](https://www.mulesoft.com/tcat/tomcat-catalina).

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




Archivos de logs
======
---------------------------

* Catalina.out: es el log donde se imprimen la sálida standard y la sálida de error del servidor (System.out y System.err). Van a ver que todo lo que se imprima en los archivos catalina.* lo vana ver también acá.

* catalina.*: es el log de catalina, el contenedor de servlets. Acá van a tener información acerca de los deploys que vayan realizando y el estado de ellos. Si tienen problemas con el deploy es un buen lugar para investigar. 
 
* localhost\_access\_log:  es el log donde se registran los accesos al servidor Tomcat. Como vimos en clase, el formato de log no contiene mucha información más alla de data båsica acerca de los requests http recibidos. Es un formato bastante estándar.
 
* localhost.*: es el log del host, aca van a ver errores de aplicación, por ejemplo errores en los jsp aparecen acá.
 
* host-manager.* y manager.*: son los logs de aplicaciones (en este caso de la aplicacion host-manager y la aplicación manager). 



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


