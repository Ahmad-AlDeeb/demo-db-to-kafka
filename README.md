# ⚫ Introduction
- This project is using 2 demos:
  1. `demo-db-to-kafka`: which produce students data from a database into the Kafka topic `student`.
  2. `demo-kafka-to-db`: which consume students data from `student` topic and insert them into another database.

# 🔴 Prerequisites
- Java 21.0.3
- Apache Maven 3.9.8
- Spring Boot 3.3.3
- Docker 26.1.4 (for Zookeeper & Kafka).

# ⚡ Running
1. Clone repository: `git clone https://github.com/Ahmad-AlDeeb/demo-db-to-kafka-to-db.git`
2. Change directory to it: `cd demo-db-to-kafka-to-db`
3. Make sure Docker is running and start docker compose: `docker-compose up`
4. Change directory to the 1st demo: `cd demo-db-to-kafka`
5. Build and run it `mvn clean install spring-boot:run`
6. Change directory to the 2st demo: `cd ../demo-kafka-to-db`
7. Build and run it `mvn clean install spring-boot:run`

# 🙋‍♂️ Contribution
- [Code Quality And Style](https://github.com/Ahmad-AlDeeb/ittovative-knowledge-base/blob/master/%F0%9F%94%B4%20Demos/Code%20Quality%20And%20Style.md).
- [Git Management](https://github.com/Ahmad-AlDeeb/ittovative-knowledge-base/blob/master/%F0%9F%94%B4%20Demos/Git%20Management%20Policy.md).
- [Documentation](https://github.com/Ahmad-AlDeeb/ittovative-knowledge-base/blob/master/%F0%9F%94%B4%20Demos/Documentation.md).
