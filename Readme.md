1. <strong>Hibernate</strong> <br>
   It is a framework for persisting/saving Java objects in a database. <br>
   Advantages of using Hibernate: <br>
   &emsp;a. It handles low-level SQL
   &emsp;b. Minimizes the amount of JDBC code to be developed
   &emsp;c. Provides Object-to-Relational-Mapping(ORM) <br><br>
2. <strong>JPA</strong> <br>
    Jakarta Persistence API previously known as Java Persistence API. <br>
    It is Standard API for Object-to-Relational-Mapping(ORM). <br>
    It is only an interface i.e. only defines the interfaces and requires an implementation to be usable. <br>
    Some implementations of JPA are Hibernate and EclipseLink, but Hibernate is the most popular one. <br>
    Benefits of using JPA is: <br>
    &emsp;a. You can switch implementation if you face some problem in a particular vendor-implementation. <br>
    &emsp;b. Your code is not tied to vendor-specific implementation, thus making it flexible and loosely coupled. <br><br>
3. <strong>JPA, Hibernate and JDBC</strong> <br>
    ![JPA, Hibernate and JDBC](./img/jpaHibernateAndJDBC.PNG?raw=true "JPAHibernateAndJDBC") <br><br>
4. <strong>CommandLineRunner Interface</strong> <br>
    An instance that implements CommandLineRunner in SpringBoot application needs to implement <em>run</em> method. <br>
    The <em>run</em> method is executed once SpringBoot application starts and bean constructions are completed <br><br>
5. <strong>Startup SQL queries in SpringBoot</strong> <br>
    &emsp;a. When a SpringBoot application starts, if it has an in-memory database configured, 
        it will run "data.sql" and "schema.sql" by default. We should create schemas or tables in "schema.sql", 
        while we should populate-data into an existing table in "data.sql". <br>
    &emsp;b. If we have a database confirgured that is not an in-memory database, 
        we can enable SQL script to run by setting the properties in application.properties file.
    <pre>Example:
        # To enable SQl script to run always irrespective of database type
        spring.sql.init.mode=always
        
        # For MySQL Database
        spring.datasource.url=jdbc:mysql://localhost:3306/student_tracker
        spring.datasource.username=springstudent
        spring.datasource.password=springstudent
        spring.sql.init.platform=mysql
        
        # For H2 Database
        spring.h2.console.enabled=true
        spring.datasource.url=jdbc:h2:mem:testdb
        spring.sql.init.platform=h2
   
        <em>Note: spring.sql.init.platform tells spring which schema-${platform}.sql and data-${platform}.sql file to run</em> </pre><br>
