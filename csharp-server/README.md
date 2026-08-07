# hostname-server (C# / ASP.NET Core 8)

A minimal ASP.NET Core Minimal API that returns the container's hostname at `/`.

## Response
```html
<h1>ServerName: a3f92c1b04d7</h1>
```
The hostname resolves to the **container ID** when running inside Docker — perfect for demonstrating load-balancer round-robin across replicas.

---

## Run with Docker

```bash
# Build image
docker build -t hostname-server-csharp .

# Run container
docker run -p 8080:8080 hostname-server-csharp

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
dotnet run
# App starts on http://localhost:8080
```
