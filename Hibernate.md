# Hibernate

## `@Embedded` y `@Embeddable`

A veces queremos tener composicion de clases, sin necesidad de asignarle ENTIDAD per se, es decir, no quiero generar una tabla y un id unico por cada objeto. Ejemplos claros de este tipo de situaciones son objetos de tipo Point o Coordinates en juegos de tablero o mapas, o Address (line1, line2, city, zipcode, country) en cualquier webapp sencilla.

Para esto anotamos con `@Embeddable` a la clase Point y luego en el objeto que la contenga (por ejemplo Board, Game, Building, Player, etc...) anotamos la referencia con un `@Embedded`. 

- http://blogs.sourceallies.com/2010/01/hibernate-embeddable-objects/

## Many to many 

Al trabajar con many-to-many 

- https://www.mkyong.com/hibernate/hibernate-many-to-many-relationship-example-annotation/
- http://www.mkyong.com/hibernate/hibernate-many-to-many-example-join-table-extra-column-annotation/
- http://stackoverflow.com/questions/5127129/mapping-many-to-many-association-table-with-extra-columns
- http://www.codejava.net/frameworks/hibernate/hibernate-many-to-many-association-with-extra-columns-in-join-table-example
- https://hellokoding.com/jpa-many-to-many-extra-columns-relationship-mapping-example-with-spring-boot-maven-and-mysql/

Alternative way:

- http://stackoverflow.com/questions/18975312/manytomany-with-additional-columns-using-elementcollection-and-java-util-map
- https://kptek.wordpress.com/2012/06/26/collection-mapping/