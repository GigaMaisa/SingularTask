# Saucedemo E2E Test Suite

## Overview

This project is a sample E2E test suite built using **Playwright (Java)** to automate the user journey of adding multiple items to the cart and completing checkout on [https://www.saucedemo.com](https://www.saucedemo.com).

---

## Tech Stack

- ✅ Java 17+
- ✅ Playwright Java
- ✅ TestNG
- ✅ Maven
- ✅ Page Object Model (POM)

---

## 🧪 Features Covered

- ✅ Login using valid credentials
- ✅ Dynamically add multiple products to cart
- ✅ Validate cart contents
- ✅ Proceed through checkout flow
- ✅ Validate correct items in checkout overview
- ✅ Confirm success message on order completion

---

## 🛠️ How to Run

```bash
mvn clean test

```
# Test Strategy & Planning

## Objective
To automate the critical user journey on [https://www.saucedemo.com](https://www.saucedemo.com):  
**Login → Add Multiple Products to Cart → Checkout → Confirm Success**

---

## Test Scope
- Validates standard login with valid credentials.
- Dynamically adds multiple products (ensuring resilience to product list changes).
- Asserts added items appear correctly in the cart.
- Completes the checkout form with dummy user data.
- Verifies cart items in the checkout overview match expectations.
- Confirms final order success page is reached with visible confirmation elements.

---

## Test Design
- Follows **Page Object Model (POM)** for maintainability.
- Page classes contain locators and page-specific logic.
- Uses a **BaseTest** for browser setup and teardown.
- Keeps test data and logic **decoupled** from structure.

---

## Test Data Strategy
- Products are selected dynamically (e.g., first two from the list).
- Hardcoded but safe credentials (`standard_user`).
- Simple static input for checkout form fields.

---

## Limitations
- Test assumes that at least two products are always visible.
- No API stubbing or mocking (live UI only).
- Username/password is static.
- Success criteria depend on visible UI elements, not backend confirmation.
- No external test data file or parameterization (yet).

---

## Future Improvements
- Add **negative tests** (e.g. invalid login, empty cart checkout).
- Use **external test data** (JSON/CSV).
- Add support for **parallel execution** and **cross-browser testing**.
- Add **GitHub Actions or Jenkins** CI pipeline.
