# ventaplata
A personal api rest project written in Java and using Maven, SpringBoot, Spring Security, JPA,
Hibernate and other Java tools that mainly serves to provide services that can be consumed by
an angular client application to carry out the management of a personal sales business silver articles.
Para que éste proyecto funcione al momento de correrlo, recomiendo que se utilice el IDE STS4, una base de datos llamada
'ventaplata' debe estar creada en MySQL, en el archivo application.properties vienen los datos de la base de datos 
(usuario, contraseña, etc.).
Éste proyecto también funciona mediante la autenticación básica de SpringSecurity, es por eso que al
momento de que se ejecuta crea un usuario por default llamado 'root' y con contraseña '12345' (Si ya existe, no se crea).
Los servicios REST pueden consumirse desde el propio navegador o con la ayuda del programa
Postman.
No está terminado, aun le falta bastante para que sea funcional, pero puede servir de ejemplo para el uso de SpringBoot
y algunas herramientas de Java.
