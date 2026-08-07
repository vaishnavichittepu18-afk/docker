# hostname-server (Go)

A minimal Go HTTP server using only the standard library (`net/http`) that returns the container's hostname at `/`.

## Response
```html
<h1>ServerName: a3f92c1b04d7</h1>
```

The hostname resolves to the **container ID** when running inside Docker — perfect for demonstrating load-balancer round-robin across replicas.

---

## Stack

| Component     | Choice                          |
|---------------|---------------------------------|
| Language      | Go 1.22                         |
| HTTP library  | `net/http` (standard library)   |
| Build system  | Go toolchain                    |
| Runtime image | `scratch` (empty — ~6MB total)  |

---

## Run with Docker

```bash
# Build image
docker build -t hostname-server-go .

# Run container
docker run -p 8080:8080 hostname-server-go

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

## Run locally (without Docker)

```bash
go run main.go
# Listening on http://localhost:8080
```
