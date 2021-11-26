# epam-order-processing-web-2

## Running the service
java -jar -Dspring.profiles.active=mysql target/web-service-2-1.0-SNAPSHOT.war

## Make sure port is available
lsof -nP -iTCP:8091

## Implemented rest end points:
[get] http://localhost:8091/health

[get] http://localhost:8091/env

[get] http://localhost:8091/info

[get] http://localhost:8090/epam/v1/orders/{id}

[post] http://localhost:8090/epam/v1/orders

[delete] http://localhost:8090/epam/v1/orders/id}

[get] http://localhost:8090/epam/v1/products/{id}

[post] http://localhost:8090/epam/v1/products

[delete] http://localhost:8090/epam/v1/products/id}

[update] http://localhost:8090/epam/v1/products/{id}