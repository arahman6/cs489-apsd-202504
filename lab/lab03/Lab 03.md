### 1\. **What is Spring?**

**Spring** is a powerful, open-source Java-based framework used to build scalable, secure, and maintainable enterprise applications.\
It provides comprehensive infrastructure support for developing Java applications and promotes best practices like **loose coupling**, **testability**, and **separation of concerns**.

> Core features include Dependency Injection, Aspect-Oriented Programming (AOP), Data Access (JDBC, JPA), Transaction Management, and more.



### 2\. **What is Spring Boot?**

**Spring Boot** is a project built on top of the Spring Framework that simplifies application development by:

-   Eliminating boilerplate configuration

-   Providing production-ready features (e.g., health checks, metrics)

-   Offering embedded servers (Tomcat, Jetty)

-   Using **opinionated defaults** and **auto-configuration**

> It helps developers get started with Spring applications **quickly** --- "just run the main class and you're good to go."



### 3\. **What is the relation between Spring platform and Spring Boot?**

-   **Spring Platform** refers to the **ecosystem of Spring projects** (Spring Framework, Spring Boot, Spring Data, Spring Security, etc.)

-   **Spring Boot** is a **project within the Spring Platform**.

-   Spring Boot builds on **Spring Framework** and integrates with many other Spring projects to deliver a rapid development experience.

> Think of Spring Boot as the **entry point to the Spring ecosystem**, designed to simplify setup and development.



### 4\. **What is the relation between Spring platform and Spring framework?**

-   **Spring Platform** is the **umbrella term** for all Spring projects.

-   **Spring Framework** is the **core foundation** of the platform.

-   Other projects like Spring Boot, Spring Data, Spring Security, etc., **depend on Spring Framework** for fundamental features like IoC and AOP.

> Analogy:\
> Spring Platform = ecosystem\
> Spring Framework = backbone



### 5\. **What is Dependency Injection (DI) and how is it done in Spring?**

**Dependency Injection** is a design pattern where an object's dependencies are provided (injected) by an external source rather than being created by the object itself.

In **Spring**, DI can be done in three ways:

1.  **Constructor Injection** (Recommended):

    ```java

    @Component
    public class Service {
        private final Repository repo;
        public Service(Repository repo) {
            this.repo = repo;
        }
    }
    ```

2.  **Setter Injection**:

    ```java

    @Component
    public class Service {
        private Repository repo;
        @Autowired
        public void setRepository(Repository repo) {
            this.repo = repo;
        }
    }
    ```

3.  **Field Injection** (Not recommended for testing):

```java

    @Autowired
    private Repository repo;
```

> Spring handles DI using its **ApplicationContext** (or IoC container). 




### 6\. **What is Inversion of Control (IoC) and how is it related to Spring?**

**Inversion of Control (IoC)** is a broader principle where the control of object creation and dependency management is **delegated to a container or framework**.

In Spring:

-   The **IoC container** (e.g., `ApplicationContext`) is responsible for creating, wiring, and managing the lifecycle of beans (objects).

-   This enables **loose coupling**, easier testing, and better separation of concerns.

> IoC is the **core concept**, and **Dependency Injection is a pattern** used to implement it in Spring.




