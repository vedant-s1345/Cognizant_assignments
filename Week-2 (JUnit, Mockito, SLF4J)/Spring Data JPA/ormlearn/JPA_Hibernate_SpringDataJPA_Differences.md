# Difference between JPA, Hibernate and Spring Data JPA

## JPA (Java Persistence API)
- JPA is a specification (JSR 338) for persisting Java objects to a database
- It defines rules and interfaces but has NO actual implementation
- Think of it like an interface — it defines WHAT to do, not HOW

## Hibernate
- Hibernate is a concrete IMPLEMENTATION of the JPA specification
- It is an ORM (Object Relational Mapping) tool
- Hibernate does the actual heavy lifting — manages sessions, 
  transactions, SQL generation
- Requires manual session management:
  Session session = factory.openSession();
  Transaction tx = session.beginTransaction();
  session.save(employee);
  tx.commit();
  session.close();

## Spring Data JPA
- Spring Data JPA is an ABSTRACTION on top of JPA/Hibernate
- It does NOT replace Hibernate — it uses it underneath
- Removes boilerplate code by providing ready-made repository methods
- Just extend JpaRepository and get CRUD for free:
  public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
- Manages transactions automatically with @Transactional

## Key Comparison

| Feature              | JPA          | Hibernate        | Spring Data JPA     |
|----------------------|--------------|------------------|---------------------|
| Type                 | Specification| Implementation   | Abstraction layer   |
| Code required        | High         | Medium           | Minimal             |
| Transaction handling | Manual       | Manual           | Automatic           |
| Query language       | JPQL         | HQL + JPQL       | Query Methods + HQL |
| Boilerplate code     | High         | Medium           | Very Low            |

## Real Example from this project

### Without Spring Data JPA (pure Hibernate):
Session session = factory.openSession();
Transaction tx = session.beginTransaction();
session.save(country);
tx.commit();
session.close();

### With Spring Data JPA:
countryRepository.save(country); // That's it!

## Conclusion
JPA defines the rules → Hibernate implements them → 
Spring Data JPA makes it even simpler to use.