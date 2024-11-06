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
6. <strong>@Entity</strong> <br>
    An entity is a Java class that is mapped to a table in database. <br>
    An entity class must have a public or protected no-argument constructor in addition to any other constructor. <br><br>
7. <strong>@Table</strong> <br>
   Annotation to tell Spring which table the entity is mapped to. <br>
    If the annotation is not provided, Spring assumes the Entity is mapped to Table with name same as that of the class. <br><br>
    <em>Note: Camel case is replaced with snake case during naming. eg: firstName will map to first_name</em> <br>
    <pre>Example:
        @Entity
        @Table(name="student")
        public class Student {
            ...
        } </pre><br>
8. <strong>@Id</strong> <br>
    Annotation to tell Spring that a field is Primary key of the table the Entity is mapped to. <br><br>
9. <strong>@GeneratedValue</strong> <br>
    Annotation to tell Spring that the field value is generated using some Generation strategy. <br>
   <pre>Example:
            @Entity
            @Table(name="student")
            public class Student {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                int id;
                ...
            } </pre><br>
   ![Generation Strategies](./img/generationStrategies.PNG?raw=true "GenerationStrategies") <br><br>
10. <strong>@Column</strong> <br>
    Annotation to tell Spring which column the field is mapped to. <br>
    If the annotation is not provided, Spring assumes the Field is mapped to Column with name same as that of the field. <br>
   <pre>Example:
            @Entity
            @Table(name="student")
            public class Student {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Column(name = "id")
                int id;
                ...
            } </pre><br>
11. <strong>Data Access Object(DAO)</strong> <br>
    It is the most common architecture for communicating with databases. <br>
    ![DAO Design Pattern](./img/daoDesignPattern.PNG?raw=true "DAODesignPattern") <br>
    The DAO instance requires an EntityManager to communicate with Database. <br>
    The EntityManager needs other dependencies like DataSource. <br>
    The DataSource is provided by Spring based on our configuration in application.properties file <br>
    ![Spring DAO Dependencies](./img/springDAODependencies.PNG?raw=true "SpringDAODependencies") <br><br> 
12. <strong>JPA Repository</strong> <br>
    Interface which must be extended in any EntityRepository eg: StudentJPARepository interface. <br>
    This interface then can be used to perform basic CRUD operations on the entity. <br><br>
13. <strong>JPARepository vs DAO and EntityManager</strong> <br>
    If one needs to have low-level-control and flexibility, 
        like writing custom, complex queries or work with stored procedures then use EntityManager. <br>
    If one wants high-level of abstraction, then use JPARepository. <br><br>
14. <strong>@Repository</strong> <br>
    Annotation to tell Spring a call is a component of repository type. <br>
    The repository annotation translates JDBC exceptions. <br><br>
15. <strong>@Transactional</strong> <br>
    Annotation to tell Spring that <br>
    &emsp;a. All methods are transactional if annotated at class level
    &emsp;b. The method is transactional if annotated at function level. <br><br>
16. <strong>JPQL(JPA Query Language)</strong> <br>
    Similar to SQL query language, here we use entity name and entity field instead of table name and column name. <br>
    <pre>Example:
        public List&lt;Student&gt; findAll() {
            TypedQuery&lt;Student&gt; fromStudent = entityManager.createQuery("FROM Student", Student.class);
            return fromStudent.getResultList();
        }
    
        public List&lt;Student&gt; findAllSort() {
            TypedQuery&lt;Student&gt; fromStudent = entityManager.createQuery("SELECT s FROM Student s ORDER BY lastName", Student.class);
            return fromStudent.getResultList();
        } 
    
        <em>Note: SELECT s is optional in HQL as it gives us the flexibility, but it is mandatory in JPQL</em> </pre>
    We can also have named parameters in query i.e. placeholders
    <pre>Example: 
        public List&lt;Student&gt; findByLastName(String theLastName) {
            TypedQuery&lt;Student&gt; fromStudent = entityManager.createQuery(
                    "FROM Student WHERE lastName=:theLastName", Student.class
            );
            fromStudent.setParameter("theLastName", theLastName);
            return fromStudent.getResultList();
        } </pre>
    For queries that do not return any result, rather they perform some update on database, we use executeUpdate method
    <pre>Example:
        @Override
        @Transactional
        public void deleteHql(Integer studentId) {
            entityManager.createQuery(
                    "DELETE FROM Student WHERE id=:studentId"
            ).setParameter(
                    "studentId", studentId
            ).executeUpdate();
        } 
    
        <em>Note: @Transactional annotation is needed as it does some changes to database</em> </pre><br>
17. <strong>SQL Queries Executed in JPA</strong> <br>
    To see the SQL queries being executed: <br>
    &emsp;a. logging.level.org.hibernate.SQL=debug <br>
    &emsp;b. spring.jpa.show-sql=true <br>
    To see the binding that happens for SQL queries:    
    &emsp;a. logging.level.org.hibernate.orm.jdbc.bind=trace <br><br>
18. <strong>Data Definition Language in Hibernate and JPA</strong> <br>
    We can select different options for DDL on startup for our Spring application. <br>
    ![DDL Configuration](./img/ddlConfiguration.PNG?raw=true "DDLConfiguration") <br>
    We can update this property in application.properties file
    <pre>Example:
        spring.jpa.hibernate.ddl-auto=create</pre>