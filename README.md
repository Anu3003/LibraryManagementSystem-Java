# 📘 Week 3: Java Programming Basics

## 📚 Theory Concepts
- Java syntax and basic programming concepts  
- Object-Oriented Programming (OOP) principles  
- Classes, objects, and methods  
- Data types and control structures  
- Arrays and collections (ArrayList)  
- Basic input/output operations  
- Exception handling  

---

## 🛠️ Hands-On Practice
- Set up Java development environment (JDK + VS Code)  
- Create simple Java programs using classes and objects  
- Build a student management system  
- Implement basic banking operations  
- Practice with arrays and ArrayList  
- Create console-based applications using menu-driven approach  

---

## 🎯 Project: Console-Based Library Management System

A **Java console-based application** that allows librarians to manage books, members, and borrowing operations efficiently using **Object-Oriented Programming (OOP)** and **file-based data persistence**.

---

## 🛠️ Technical Requirements
- Java classes with proper encapsulation  
- Object-Oriented Design principles  
- File I/O operations for data persistence  
- ArrayList for storing collections  
- Console-based menu system  
- Exception handling  
- Input validation and user feedback  
- Search and filter functionality  

---

## 📋 Step-by-Step Guide

### 🔹 Step 1: Class Design
- Create `Book` class with properties:
  - ISBN
  - Title
  - Author
  - Year
  - Availability
  - Borrowed member
  - Due date
- Create `Member` class with:
  - Member ID
  - Name
  - Borrowed books list
- Create `Library` class to manage books, members, and transactions  
- Implement constructors, getters, setters, and `toString()` methods  

---

### 🔹 Step 2: Core Functionality
- Add book to library collection  
- Remove book from collection  
- Register new library member  
- Borrow book with due date tracking  
- Return book with overdue checking  
- Display all books and members  

---

### 🔹 Step 3: Data Persistence
- Save book data to `books.txt`  
- Save member data to `members.txt`  
- Load data automatically when program starts  
- Handle file read/write errors gracefully  

---

### 🔹 Step 4: User Interface
- Create menu-driven console interface  
- Validate all user inputs  
- Display formatted output for books and members  
- Implement search by title, author, or ISBN  

---

### 🔹 Step 5: Advanced Features
- Calculate overdue fines  
- Generate library statistics  
- Export data to CSV (optional)  
- Book reservation system (future enhancement)  

---

## 💻 Sample Code

### 📌 Book.java
```java
package library;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;
    private String borrowedBy;
    private LocalDate dueDate;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public boolean isOverdue() {
        return dueDate != null && LocalDate.now().isAfter(dueDate);
    }
}
📊 Sample Output
=== LIBRARY MANAGEMENT SYSTEM ===
1. Add New Book
2. View All Books
3. Search Books
4. Register Member
5. Borrow Book
6. Return Book
7. View Library Statistics
8. Exit

📈 Library Statistics
Total Books: 3
Available Books: 2
Borrowed Books: 1
Registered Members: 5
Overdue Books: 0

📤 Submission Requirements
📁 GitHub Project Structure
week3-library-system/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── library/
│   │   │   │   ├── Main.java
│   │   │   │   ├── Book.java
│   │   │   │   ├── Member.java
│   │   │   │   ├── Library.java
│   │   │   │   └── FileHandler.java
│── data/
│   ├── books.txt
│   └── members.txt
│── screenshots/
│── README.md
│── .gitignore

▶️ How to Run
# Compile
javac -d bin src/main/java/library/*.java

# Run
java -cp bin library.Main

✅ Features Summary

Add, remove, and search books

Register and manage members

Borrow and return books with due dates

File-based data persistence

Input validation

Library statistics generation