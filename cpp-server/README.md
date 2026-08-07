# hostname-server (C++ / Crow)

A minimal C++17 HTTP server using the [Crow](https://crowcpp.org) framework that returns the container's hostname at `/`.

## Response
```html
<h1>ServerName: a3f92c1b04d7</h1>
```

The hostname resolves to the **container ID** when running inside Docker — perfect for demonstrating load-balancer round-robin across replicas.

---

## Stack

| Component     | Choice                        |
|---------------|-------------------------------|
| Language      | C++17                         |
| HTTP library  | Crow v1.2.0 (single-header)   |
| Build system  | CMake 3.16+                   |
| Dependencies  | Boost.Asio, OpenSSL, zlib     |

---

## Run with Docker

```bash
# Build image (first build downloads Crow via CMake FetchContent)
docker build -t hostname-server-cpp .

# Run container
docker run -p 8080:8080 hostname-server-cpp

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

## Build locally (without Docker)

```bash
# Prerequisites: cmake, g++, libboost-all-dev, libssl-dev
cmake -B build -DCMAKE_BUILD_TYPE=Release
cmake --build build --parallel
./build/hostname-server
# Listening on http://localhost:8080
```
