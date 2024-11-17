package main

import (
	"fmt"
	"net/http"
)

// helloHandler responds with "Hello, World!"
func helloHandler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "Hello, Labresult")
}

func main() {
	// Register the handler for the root URL path
	http.HandleFunc("/", helloHandler)

	// Start the server on port 8080
	fmt.Println("Starting server on :8080")
	if err := http.ListenAndServe(":8080", nil); err != nil {
		fmt.Println("Error starting server:", err)
	}
}
