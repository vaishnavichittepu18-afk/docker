# ─────────────────────────────────────────────
# Stage 1: Build using .NET SDK
# ─────────────────────────────────────────────
FROM mcr.microsoft.com/dotnet/sdk:8.0 AS builder

WORKDIR /app

# Copy project file and restore dependencies (layer cache)
COPY HostnameServer.csproj .
RUN dotnet restore

# Copy source and publish
COPY . .
RUN dotnet publish -c Release -o /publish --no-restore

# ─────────────────────────────────────────────
# Stage 2: Run using slim ASP.NET runtime
# ─────────────────────────────────────────────
FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS runtime

WORKDIR /app

COPY --from=builder /publish .

EXPOSE 7070

ENV ASPNETCORE_URLS=http://+:7070

ENTRYPOINT ["dotnet", "HostnameServer.dll"]
