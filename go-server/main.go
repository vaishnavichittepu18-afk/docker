package main

import (
	"fmt"
	"log"
	"net/http"
	"os"
)

func hostnameHandler(w http.ResponseWriter, r *http.Request) {
	hostname, err := os.Hostname()
	if err != nil {
		hostname = "unknown-host"
	}
	w.Header().Set("Content-Type", "text/html")
	fmt.Fprintf(w, "<h1>GO - ServerName: %s</h1>", hostname)
}

func main() {
	http.HandleFunc("/", hostnameHandler)
	log.Println("Server listening on :7070")
	if err := http.ListenAndServe(":7070", nil); err != nil {
		log.Fatalf("Server failed: %v", err)
	}
}
