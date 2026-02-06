# Unit Testing – Calculator Library
📌 Overview

This project implements unit tests for the library Calculator-1.0.jar.
The goal is to validate the behavior of each public method using automated tests, following a data-driven approach, with parallel execution, and applying pre-conditions and post-conditions as required.

The tests were developed using TestNG and executed via an XML suite configuration.

🧮 Library Under Test

The Calculator library provides several mathematical operations, including:

Arithmetic operations (sum, sub, mult, div)

Mathematical functions (pow, sqrt)

Trigonometric functions (sin, cos, tg, ctg)

Logical validations (isPositive, isNegative)

Each public method is tested in a separate test class, following the principle one test class per method.

🧪 Testing Framework & Tools

Language: Java 17

Testing framework: TestNG

Build tool: Maven

The calculator library is added as a project dependency, and TestNG is configured in the pom.xml.

⚙️ Pre-conditions and Post-conditions

All test classes include the following lifecycle methods:

@BeforeMethod
public void setUp() {
    // pre-condition
}

@AfterMethod
public void tearDown() {
    // post-condition
}


The Calculator instance is created inside each test method to avoid shared state and ensure stable execution in parallel mode.

🔁 Data-Driven Tests

Parameterized tests are implemented using TestNG’s @DataProvider, allowing the same test logic to run with multiple input values.

🚀 Parallel Execution

Parallel execution is configured at the suite level using testng.xml:

<suite name="Calculator Suite" parallel="classes" thread-count="4">


This setup runs test classes in parallel, satisfying the parallel execution requirement while keeping tests stable.

🧩 Test Groups

Tests are organized using TestNG groups:

smoke

regression

Groups can be included or excluded directly from the XML suite.

▶️ Running the Tests
From IntelliJ IDEA

Right-click testng.xml

Select Run 'testng.xml'

From command line
mvn test

## 📸 Evidence (Screenshots)

Screenshots of the IDE execution are available in the `/screenshots` folder:
- Run from `testng.xml`
- Successful TestNG execution results (all tests passed)
- Project structure showing one test class per library method
- XML suite configuration (parallel execution and groups)
- Different groups of tests (include or exclude)

✅ Conclusion

This project fulfills all acceptance criteria:

TestNG is used

One test class per library method

Pre-conditions and post-conditions implemented

Data-driven tests included

Parallel execution configured via XML

Tests executed successfully from the IDE

