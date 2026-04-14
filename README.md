# API Automation Framework

A Maven-based Java framework for REST API automation and testing using RestAssured and TestNG.

## Project Structure

```
api-automation/
├── src/
│   ├── main/
│   │   ├── java/com/backend/
│   │   │   ├── apis/              # API test classes (e.g., GenderAPIs)
│   │   │   ├── helpers/           # Helper classes
│   │   │   │   ├── endpoints/     # Service and endpoint configurations
│   │   │   │   ├── common/        # Common utilities
│   │   │   │   ├── restassured/   # Rest client implementations
│   │   │   ├── pojo/              # Response models
│   │   │   └── utils/             # Utility classes
│   │   └── resources/             # Configuration files (log4j2.xml)
│   └── test/
│       └── java/                  # Test cases (e.g., SampleTest)
├── src/test/resources/            # Test resources
├── Jenkinsfile                    # CI/CD pipeline configuration
├── pom.xml                        # Maven project configuration
├── README.md                      # This file
├── checkstyle.xml                 # Code style configuration
├── File.checkstyle                # Checkstyle filter configuration
├── testNGsuite/                   # TestNG suite configurations
└── .github/workflows/             # GitHub Actions workflows
```

## Technologies Used

- **Java 8** - Core programming language
- **Maven** - Build automation and dependency management
- **RestAssured** - REST API testing library
- **TestNG** - Testing framework
- **Lombok** - Reduce boilerplate code
- **Log4j2** - Logging framework
- **Test Results (Tesults)** - Test result reporting
- **Checkstyle** - Code quality enforcement

## Key Dependencies

| Dependency | Version | Purpose |
|------------|---------|-----|----|
| rest-assured | 4.3.1 | REST API testing |
| testng | 7.7.0 | Test execution framework |
| lombok | 1.18.34 | Annotation processing |
| log4j-api | 2.20.0 | Logging API |
| jackson-databind | 2.12.7.1 | JSON processing |
| groovy-all | 2.4.21 | Groovy scripting support |

## Setup Instructions

### Prerequisites
- JDK 1.8 or higher
- Maven 3.x

### Build the Project
```bash
mvn clean compile
```

### Run Tests
```bash
mvn clean test
```

### Run Specific Test Suite
```bash
mvn test -DsuiteXmlFile=testNGsuite/sample.xml
```

## How to Add New API Tests

1. Create a new test class under `src/main/java/com/backend/apis/`
2. Implement API test logic using `GenderAPIs` pattern
3. Create corresponding request models under `src/main/java/com/backend/pojo/`
4. Add configuration endpoints under `src/main/java/com/backend/helpers/endpoints/`

## Code Style

This project uses Checkstyle for code quality. Configuration is in `checkstyle.xml`.

## CI/CD Integration

- **Jenkinsfile** - Jenkins build pipeline
- **GitHub Actions** - Automated CI/CD in `.github/workflows/maven.yml`

## Logging Configuration

Logging is configured via `src/main/resources/log4j2.xml`. Customize log levels and appenders as needed.

## License

This project is a template for API automation projects.
