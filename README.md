# Full Authentication System

A complete authentication system built with Spring Boot, supporting traditional email/password login as well as OAuth2 social login via Google and GitHub.

## Features

- User registration with email and password
- Secure login with email and password
- OAuth2 login with Google
- OAuth2 login with GitHub
- Password encryption (BCrypt)
- Session/JWT-based authentication
- Centralized exception handling

## Tech Stack

- **Backend:** Java, Spring Boot, Spring Security 6
- **Database:** PostgreSQL
- **Auth:** OAuth2 (Google, GitHub), Spring Data JPA
- **Build Tool:** Maven

## Getting Started

### Prerequisites

- Java 17+
- Maven
- PostgreSQL

### Setup

1. Clone the repository
   ```bash
   git clone https://github.com/SharwanKunwar/full-auth-system.git
   cd full-auth-system
   ```

2. Configure your database and OAuth2 credentials in `application.properties` (or `application.yml`)

3. Run the application
   ```bash
   mvn spring-boot:run
   ```

## OAuth2 Setup

You'll need to register OAuth2 apps with Google and GitHub to get your `client-id` and `client-secret`:

- [Google Cloud Console](https://console.cloud.google.com/)
- [GitHub Developer Settings](https://github.com/settings/developers)

Add the credentials to your application config under `spring.security.oauth2.client.registration`.

## License

This project is open source and available under the MIT License.
