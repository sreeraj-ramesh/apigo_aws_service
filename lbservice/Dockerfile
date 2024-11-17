# Start with a minimal base image containing Go
FROM golang:1.21 as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Go modules configuration files
COPY go.mod ./

# Download dependencies
RUN go mod download

# Copy the source code into the container
COPY . .

# Build the Go application
RUN go build -o labresult .

# Use a minimal image for the final container
FROM debian:bullseye-slim

# Set the working directory
WORKDIR /app

# Copy the compiled binary from the builder stage
COPY --from=builder /app/labresult .

# Expose the application port
EXPOSE 8080

# Command to run the application
CMD ["./labresult"]
