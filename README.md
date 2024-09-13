# ⚫ Introduction
- This project is using 2 demos:
  1. `demo-db-to-kafka`: which produce students data from a database into the Kafka topic `student`.
  2. `demo-kafka-to-db`: which consume students data from `student` topic and insert them into another database.
<div align="center">
  <video src="https://github.com/user-attachments/assets/5d52b5c3-d0bb-419f-b3fe-46f97af1ae68" width="400" autoplay loop muted></video>
</div>

- For each seconds, 5 students data are sent from source DB to Kafka topic in one batch, then inserted into another DB from the topic.
- **On the left**: a consumer listening to data sent.
- **On the right**: destination database inserting consumed data.
# 🔴 Prerequisites
- Java 21.0.3
- Apache Maven 3.9.8
- Spring Boot 3.3.3
- Docker 26.1.4 (for MySQL, Zookeeper, and Kafka).

# ⚡ Running
1. Clone repository: `git clone https://github.com/Ahmad-AlDeeb/demo-db-to-kafka-to-db.git`
2. Change directory to it: `cd demo-db-to-kafka-to-db`
3. Make sure Docker is running and start docker compose: `docker-compose up -d`
4. Build and run 1st demo (producer): `mvn -f ./demo-db-to-kafka clean install spring-boot:run`
5. Open another terminal in same location.
6. Build and run 2nd demo (consumer): `mvn -f ./demo-kafka-to-db clean install spring-boot:run`
7. When you are done, terminate demos using `CTRL + C` command for both terminals.

# 🙋‍♂️ Contribution
1. [Code Quality And Style](https://github.com/Ahmad-AlDeeb/demo-db-to-kafka-to-db/blob/main/docs/Code%20Quality%20And%20Style.md).
2. [Setup pre-commit hooks](https://github.com/Ahmad-AlDeeb/demo-db-to-kafka-to-db/blob/main/docs/Setup%20Pre-commit%20Hooks.md).
3. [Check Git management policy](https://github.com/Ahmad-AlDeeb/demo-db-to-kafka-to-db/blob/main/docs/Git%20Management%20Policy.md).
