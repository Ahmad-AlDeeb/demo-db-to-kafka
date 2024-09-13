# ⚫ Introduction
This project demonstrates a real-time data pipeline using Kafka for messaging between two databases. It consists of two demos:
1. `demo-db-to-kafka`: Produces student data from a source database and publishes it to a Kafka topic named `student`.
2. `demo-kafka-to-db`: Consumes student data from the `student` topic and inserts it into a destination database.

### Workflow Overview
1. Every second, 5 student records are produced from the `source` database and published to the Kafka topic in a batch.
2. The batch is then consumed and inserted into the `destination` database as soon as the data is received from the Kafka topic.

### Visual Representation
- **Left window**: Shows the Kafka consumer listening for incoming data.
- **Right window**: Displays the `destination` database inserting the consumed data.

<div align="center">
  <video src="https://github.com/user-attachments/assets/5d52b5c3-d0bb-419f-b3fe-46f97af1ae68" width="400" autoplay loop muted></video>
</div>

# 🔴 Prerequisites
Ensure the following tools are installed to run the project smoothly:
- **Java 21.0.3**: Required to build and run the Spring Boot applications.
- **Apache Maven 3.9.8**: Used for dependency management and building the project.
- **Spring Boot 3.3.3**: Framework for building the Kafka producer and consumer demos.
- **Docker 26.1.4**: Necessary to set up MySQL, Zookeeper, and Kafka services in containers.

# ⚡ Running the Project
Follow these steps to run the project locally:

1. **Clone the repository**: 
   ```
   git clone https://github.com/Ahmad-AlDeeb/demo-db-to-kafka-to-db.git
   ```
2. **Navigate to the project directory**:
   ```
   cd demo-db-to-kafka-to-db
   ```
3. **Start Docker services**: Make sure Docker is running, then start the required services (MySQL, Zookeeper, Kafka) using:
   ```
   docker-compose up -d
   ```
4. **Build and run the producer demo**: 
   ```
   mvn -f ./demo-db-to-kafka clean install spring-boot:run
   ```
5. **Build and run the consumer demo**: Open another terminal in the same directory and run:
   ```
   mvn -f ./demo-kafka-to-db clean install spring-boot:run
   ```
6. **Stop the services**: After testing, stop both demos by pressing `CTRL + C` in each terminal.

# 🙋‍♂️ Contributing to the Project
1. **[Code Quality And Style](https://github.com/Ahmad-AlDeeb/demo-db-to-kafka-to-db/blob/main/docs/Code%20Quality%20And%20Style.md)**: Ensure your code adheres to the standards.
2. **[Setup Pre-commit Hooks](https://github.com/Ahmad-AlDeeb/demo-db-to-kafka-to-db/blob/main/docs/Setup%20Pre-commit%20Hooks.md)**: Follow this guide to ensure proper Git hygiene before committing.
3. **[Git Management Policy](https://github.com/Ahmad-AlDeeb/demo-db-to-kafka-to-db/blob/main/docs/Git%20Management%20Policy.md)**: Read about how to manage branches, commits, and pull requests.
