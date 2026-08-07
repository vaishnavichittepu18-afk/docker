cmake_minimum_required(VERSION 3.16)
project(hostname-server VERSION 1.0.0 LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Download Crow header (single-header HTTP library)
include(FetchContent)
FetchContent_Declare(
    crow
    GIT_REPOSITORY https://github.com/CrowCpp/Crow.git
    GIT_TAG        v1.2.0
)
FetchContent_MakeAvailable(crow)

find_package(Threads REQUIRED)

add_executable(hostname-server main.cpp)

target_link_libraries(hostname-server
    PRIVATE
        Crow::Crow
        Threads::Threads
)
