# 🏬 Warehouse Management System (Console Application)

A menu-driven console application that simulates a complete online warehouse workflow — from inventory management and discounts to customer orders and shipment tracking.

---

## ❓ Why This Project Exists

This project was created to model a **real-world warehouse system** using object-oriented programming concepts.  
It focuses on enforcing business rules (such as discount overlaps and shipping costs) while keeping the system simple and easy to use from the console.

The goal is to demonstrate:
- End-to-end warehouse operations
- Clean system organization
- Accurate transaction-based reporting
- Clear separation between staff and customer actions

---

## 🧠 What the System Does

The system represents **one warehouse** managed by staff and accessed by customers.

### 👩‍💼 Staff Can:
- Add customers
- Stock products (books, electronics, groceries)
- Create and manage discounts
- Activate/deactivate discounts with a **no-overlap rule**
- Update shipment statuses
- Generate operational reports

### 🧑‍💻 Customers Can:
- Log in using their customer ID
- Browse products by category
- Add or remove items from a cart
- Checkout with automatic discount and shipping calculation
- Pay using card or cash

---

## 💸 Discounts & Shipping (Quick Rules)

- Discounts can be **percentage-based** or **fixed-amount**
- Only one discount can be active for a given date range
- If a new active discount overlaps an old one, the **new discount wins**
- Shipping cost is calculated based on **total item weight**

---

## 📂 Project Structure
<pre>
WareHouse/
├── Customers
├── Products
│ ├── Books
│ ├── Electronics
│ └── Groceries
├── Discounts
├── Orders
├── Shipments
├── Reports
└── Main Menu
</pre>

---

## ▶️ How to Download, Run, and Use the Project

### 🔹 Option 1: Download ZIP (Recommended for Beginners)

1. Open the repository
2. Click **Code** → **Download ZIP**
3. Extract the ZIP file
4. Open the project in your IDE (IntelliJ, Eclipse, VS Code, etc.)
5. Run the `Main` class

---
### 🔹 Option 2: Fork the Repository

1. Click **Fork** at the top-right of the repository
2. Clone your fork locally
3. Open the project in your IDE
4. Run the `Main` class

---

## 🖥️ Using the Application

1. Run the program
2. Choose between:
   - **Staff Menu**
   - **Customer Menu**
3. Follow the on-screen numbered menus
4. Seeded data is included, so you can test immediately

---

## 🧪 Sample Features You Can Test Quickly

- Activate overlapping discounts
- Add products and reduce stock after checkout
- Track shipment status changes
- Generate daily sales and inventory reports

---

## 🛠️ Technologies Used

- **Java**
- Console-based user interface
- Object-Oriented Programming


