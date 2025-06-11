# Kafka Consumer Application

This Spring Boot application consumes messages from Kafka and stores them in MongoDB. It uses Spring Cloud Config for configuration management and HashiCorp Vault for secrets management.

## Prerequisites

- Java 17
- Maven
- MongoDB (running on localhost:27017)
- Apache Kafka (running on localhost:9092)
- Spring Cloud Config Server (running on localhost:8888)
- HashiCorp Vault (running on localhost:8200)

## Configuration

1. **Spring Cloud Config Server**
   - Ensure the config server is running and accessible at http://localhost:8888
   - The application will fetch its configuration from the config server

2. **Vault Setup**
   - Start Vault server
   - Create a new token and update it in `bootstrap.yml`
   - Store your secrets in Vault under the `secret/consumer-application` path

3. **Kafka Setup**
   - Create a topic named according to the `kafka.topic.name` property
   - Ensure Kafka is running on localhost:9092

4. **MongoDB Setup**
   - Ensure MongoDB is running on localhost:27017
   - The application will automatically create the required database and collection

## Building and Running

1. Build the application:
   ```bash
   mvn clean install
   ```

2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on port 8080 and begin consuming messages from the configured Kafka topic.

## Monitoring

The application exposes several actuator endpoints for monitoring:
- Health check: http://localhost:8080/actuator/health
- Info: http://localhost:8080/actuator/info
- Metrics: http://localhost:8080/actuator/metrics

## Testing

To test the application, you can:
1. Publish messages to the Kafka topic
2. Check the application logs for message processing
3. Verify the messages are stored in MongoDB 