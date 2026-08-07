# hostname-server

A minimal Spring Boot API that returns the Docker container's hostname at `/`.

## Response
```html
<h1>ServerName: a3f92c1b04d7</h1>
```
The hostname resolves to the **container ID** when running inside Docker — perfect for demonstrating load-balancer round-robin across replicas.

---

## Run with Docker

```bash
# Build image
docker build -t hostname-server .

# Run container
docker run -p 8080:8080 hostname-server

# Test
curl http://localhost:8080/
```

## Run with Docker Compose

```bash
docker-compose up --build
```

## Scale replicas (load-balancer demo)

```bash
docker-compose up --build --scale hostname-server=3
```
> Use an Nginx/Traefik reverse proxy in front to see different hostnames per request.

## Run locally (without Docker)

```bash
mvn clean package -DskipTests
java -jar target/hostname-server.jar
```
