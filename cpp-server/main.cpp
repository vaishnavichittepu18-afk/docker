#include "crow.h"
#include <unistd.h>
#include <limits.h>
#include <string>

int main() {
    crow::SimpleApp app;

    CROW_ROUTE(app, "/")
    ([]() {
        char hostname[HOST_NAME_MAX + 1];
        if (gethostname(hostname, sizeof(hostname)) != 0) {
            std::string(hostname, sizeof(hostname)) = "unknown-host";
        }
        std::string html = "<h1>CPP - ServerName: " + std::string(hostname) + "</h1>";
        auto res = crow::response(html);
        res.add_header("Content-Type", "text/html");
        return res;
    });

    app.port(7070).multithreaded().run();
    return 0;
}
