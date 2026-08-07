# ─────────────────────────────────────────────
# Stage 1: Build static binary using Go SDK
# ─────────────────────────────────────────────
FROM golang:1.22-alpine AS builder

WORKDIR /app

COPY go.mod .
RUN go mod download

COPY main.go .

# Build a fully static binary (no libc dependency)
RUN CGO_ENABLED=0 GOOS=linux GOARCH=amd64 \
    go build -ldflags="-s -w" -o hostname-server .

# ─────────────────────────────────────────────
# Stage 2: Scratch — the smallest possible image
# ─────────────────────────────────────────────
FROM scratch

COPY --from=builder /app/hostname-server /hostname-server

EXPOSE 7070

ENTRYPOINT ["/hostname-server"]
