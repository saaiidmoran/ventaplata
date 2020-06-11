# ventaplata
A personal api rest project written in Java and using Maven, SpringBoot, Spring Security, JPA,
Hibernate and other Java tools that mainly serves to provide services that can be consumed by
an angular client application to carry out the management of a personal sales business silver articles.

In order for this project to work at run time, I recommend using the STS4 IDE, a database called
'ventaplata' must be created in MySQL, the database data is specified in the application.properties file
(username, password, etc.).
This project also works through basic SpringSecurity authentication, that's why when
it is run it creates a default user named 'root' and a password '12345' (if it already exists, it is not created).
REST services can be consumed from the browser itself or with the help of the program
Postman.
It is not finished, it still lacks enough to be functional, but it can serve as an example for the use of SpringBoot
and some Java tools.
