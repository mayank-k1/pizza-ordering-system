# 🍕 Pizza Ordering System

## 📌 Project Overview
The Pizza Ordering System is a Java-based web application developed using Spring MVC, JSP, and JPA. The application allows users to view pizza menu, place orders, and generate order reports. The project follows a layered MVC architecture including Controller, Service, DAO, and Entity layers.

This project demonstrates backend development using Java, Spring MVC architecture, database integration, and web-based order processing.

---

## 🚀 Features
- View pizza menu
- Place pizza order
- Calculate total bill
- Generate order report
- Exception handling for invalid inputs
- Database connectivity using JPA
- Layered architecture (Controller → Service → DAO → Entity)

---

## 🛠️ Tech Stack
- Java
- Spring MVC
- JSP
- JPA (Hibernate)
- MySQL
- Apache Tomcat
- MVC Architecture

---

## 📂 Project Structure

HON_PizzaParticipant
│
├── src/com/accenture/lkm
│ ├── bean
│ ├── controller
│ ├── dao
│ ├── entity
│ ├── exception
│ ├── service
│ └── resources
│
├── WebContent
│ ├── jspViews
│ └── WEB-INF
│
├── root-config.xml
├── spring-config-servlet.xml
├── spring-jpa-config.xml
└── web.xml


---

## ▶️ How to Run
1. Clone the repository
2. Open project in Eclipse / IntelliJ
3. Configure database in `cst_conn.properties`
4. Deploy project on Apache Tomcat Server
5. Open browser and run the application:

http://localhost:8080/pizza-ordering-system


---

## 🗄️ Database Structure
```markdown
## 💾 Database Structure
```sql
CREATE TABLE Pizza (
    pizza_id INT PRIMARY KEY,
    pizza_name VARCHAR(50),
    price DOUBLE
);

CREATE TABLE Pizza_Order (
    order_id INT PRIMARY KEY,
    pizza_id INT,
    quantity INT,
    total_price DOUBLE
);
```

🔮 Future Improvements
1. Add user login system
2. Add online payment integration
3. Add order history
4. Convert project to Spring Boot REST API
5. Deploy on cloud
👨‍💻 Author

### Mayank Kumar
Java Backend Developer | Spring MVC | Hibernate | SQL
GitHub: https://github.com/mayank-k1
