# Facebook Login Example

This is a simple web application demonstrating Facebook login integration using Java and Spring Boot.

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/shahashanay/test.git
   cd test
   ```

## Prerequisites

- Java 8 or higher
- Maven
- Facebook App credentials (client-id and client-secret) using with Auth 0 for mutisocial login
- Auth0 (client-id , client-secret , issuer-uri )

## Getting Started

mvn spring-boot:run

## run by docker

docker build -t <name> .  
docker run -p 8080:8080 <name>

## deploy

The runtime for your web service Docker

## Sequence Diagram

User -> Browser: Access Application (http://localhost:8080)
Browser -> Application: Request Home Page
Application -> Facebook: Initiate OAuth2 Authorization
Facebook -> Application: Redirect User to Login Page
Application -> Facebook: Request User Authorization
Facebook -> User: Display Authorization Prompt
User -> Facebook: Authorize Application
Facebook -> Application: Redirect User back to Callback URL
Application -> Facebook: Exchange Authorization Code for Access Token
Facebook -> Application: Return User Profile Information
Application -> Browser: Render Home Page with User Profile
