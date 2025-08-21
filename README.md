How to run
Clone this repo to your local machine

Make sure you have Java 17 and Maven installed

Run the app with bash
mvn spring-boot:run
The app will start on port 8083 by default

You can test APIs through any REST client Postman

will attach postman collecion and swagger in info.txt

----------------------------------------------------------

API Examples
GET /api/orders/all — Get all orders

GET /api/orders/{id} — Get order by ID

POST /api/orders — Create a new order (send JSON body)

PUT /api/orders/{id} — Update order quantity

DELETE /api/orders/{id} — Delete order
