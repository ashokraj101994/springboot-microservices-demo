# Spring Boot Microservices Demo

A simple demonstration of two Spring Boot microservices with REST communication:

1. **User Service**
   - Manages user data
   - Returns user existence status

2. **Order Service**
   - Creates orders
   - Verifies user existence by calling User Service
   - Handles service unavailability and timeouts

---

## 🧱 Architecture


Order Service uses **RestTemplate** with timeout and exception handling for resilient service-to-service communication.

---

## 📦 Services Details

### 🔹 User Service
- Endpoint: `GET /isUserExist/{uId}`
- Returns `true` if the user exists, otherwise `404 NOT FOUND`

### 🔹 Order Service
- Endpoint: `POST /orders`
- Validates user before saving
- Handles:
  - User not found
  - User service down
  - Timeout scenarios

---

## 🚀 How to Run

1. Import both services into your IDE (STS / Eclipse / VS Code)
2. Run `UserServiceApplication`:
   - Default port: `8081`
3. Run `OrderServiceApplication`:
   - Default port: `8082`

Use Postman / curl to test.

---

## ⚠️ Error Handling

Both services have **centralized exception handling** using `@RestControllerAdvice` and return meaningful `ErrorResponse`.



# User exists
curl http://localhost:8081/isUserExist/1

# User not found
curl http://localhost:8081/isUserExist/999

# Create order
curl -X POST http://localhost:8082/orders \
-H "Content-Type: application/json" \
-d '{"userId":1,"productName":"Laptop","qty":1}'


---

## 👨‍💻 Author

Ashok — *Java Developer*
