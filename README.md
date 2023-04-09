# virt-course 
This is a simple Online Course project built with Spring Boot, JWT, and Data JPA. 
The platform provides RESTful APIs for managing courses, enrollments, users, purchase course, and authentication.
## Technologies used

- Spring Boot
- MySQL Workbench
- Spring Security
- JSON Web Tokens (JWT)
- DataJpa


## Sample Postman Requests
Register a new user
 - POST http://localhost:1313/addUser
![image](https://user-images.githubusercontent.com/92798791/230748597-3cb6f385-b86f-4869-a2bf-357eb3e22f1b.png)

Authenticate user
 - POST http://localhost:1313/authenticate
![image](https://user-images.githubusercontent.com/92798791/230748676-0f013c49-454b-40a2-b047-2acd338a344d.png)

Add to cart
- GET http://localhost:1313/addToCart/2
![image](https://user-images.githubusercontent.com/92798791/230748772-8923f56c-e95b-4566-80d6-dc41dd311688.png)

Place order
- POST http://localhost:1313/placeOrder/true

![image](https://user-images.githubusercontent.com/92798791/230748828-1f742fe8-4200-43e4-ae09-4bfebd213d77.png)

Order details
- GET http://localhost:1313/getAllOrderDetails
![image](https://user-images.githubusercontent.com/92798791/230748885-ae01aef7-7c32-433d-97ad-f36a221727dd.png)

Order delivered
- http://localhost:1313/markOrderAsDelivered/6
![image](https://user-images.githubusercontent.com/92798791/230748915-e95bf2b3-6807-4e53-a774-10cb4324cff7.png)

## MySQL Workbench
- user table

![image](https://user-images.githubusercontent.com/92798791/230749197-8251c8e1-5da2-4a96-b44d-5c4b554e779b.png)
- roles table

![image](https://user-images.githubusercontent.com/92798791/230749247-66c63ef2-6993-467e-baa1-e1403ff1a602.png)
- course table

![image](https://user-images.githubusercontent.com/92798791/230749265-033f5d70-7f09-403d-8d0c-5ea3c8559077.png)

- cart table

![image](https://user-images.githubusercontent.com/92798791/230749324-82d02023-3f8b-499b-a2dd-7fb952f69e02.png)
## Getting Started

To get started with this project, clone the repository and navigate to the root directory:

Repository https://github.com/gilm57/virt-course
-Java 11 or later
- Maven
- MySQL Workbench
- Git

