# Dead Letter Queue - Manual Acknowledgement 

## Spring Cloud Stream - RabbitMQ

This app simulates use of dead letter queue and Consumer's manual ack.

mvn spring-boot:run | tee tempmanual.log

http://localhost:9090/orders/publish

{
    "orderNumber": 1003,
    "quantity": 5,
    "productName": "Study Lamp",
    "productDesc": "Lights and Lamps",
    "orderStatus": "CREATED"
}

