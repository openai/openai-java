# Contributing to OpenAI Java SDK

## Setting up the environment

This repository uses [Gradle](https://gradle.org/) with Kotlin DSL for building and dependency management. The SDK requires Java 8, but development requires JDK 21 for the Kotlin toolchain.

## Project structure

The SDK consists of three artifacts:

- `openai-java-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`OpenAIClient`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClient.kt), [`OpenAIClientAsync`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsync.kt), [`OpenAIClientImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt), and [`OpenAIClientAsyncImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsyncImpl.kt), all of which can work with any HTTP client
- `openai-java-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`OpenAIOkHttpClient`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClient.kt) and [`OpenAIOkHttpClientAsync`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClientAsync.kt), which provide a way to construct [`OpenAIClientImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt) and [`OpenAIClientAsyncImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsyncImpl.kt), respectively, using OkHttp
- `openai-java`
  - Depends on and exposes the APIs of

## Modifying or adding code

Most of the SDK is generated code. Modifications to code will be persisted between generations, but may
result in merge conflicts between manual patches and changes from the generator. The generator will never
modify the contents of the `openai-java-example/` directory.

## Adding and running examples

All files in the `openai-java-example/` directory are not modified by the generator and can be freely edited or added to.

```java
// openai-java-example/src/main/java/com/openai/example/YourExample.java
package com.openai.example;

public class YourExample {
    public static void main(String[] args) {
        // ...
    }
}
```

```sh
$ ./gradlew :openai-java-example:run -PmainClass=com.openai.example.YourExample
```

## Using the repository from source

If you'd like to use the repository from source, you can either [install from git](https://jitpack.io/) or link to a cloned repository.

To use a local version of this library from source in another project, you can publish it to your local Maven repository:

```sh
$ ./gradlew publishToMavenLocal
```

Note: for now you'll need to comment out the line for `signAllPublications()` here: `buildSrc/src/main/kotlin/openai.publish.gradle.kts`

Then in your project's `build.gradle.kts` or `pom.xml`, reference the locally published version:

<!-- x-release-please-start-version -->

```kotlin
implementation("com.openai:openai-java:2.9.1")
```

```xml
<dependency>
  <groupId>com.openai</groupId>
  <artifactId>openai-java</artifactId>
  <version>2.9.1</version>
</dependency>
```

<!-- x-release-please-end -->

Alternatively, you can build and install the JAR files directly:

```sh
$ ./gradlew build
```

JAR files will be available in each module's build/libs/ directory

## Running tests

Most tests require [our mock server](https://github.com/stoplightio/prism) to be running against the OpenAPI spec to work.

The test script will automatically start the mock server for you (if it's not already running) and run the tests against it:

```sh
$ ./scripts/test
```

You can also manually start the mock server if you want to run tests repeatedly:

```sh
$ ./scripts/mock
```

Then run the tests:

```sh
$ ./scripts/test

```

### Test configuration

- Tests run in parallel for better performance
- Mock server runs on `localhost:4010`
- You can disable mock server tests with `SKIP_MOCK_TESTS=true`
- You can target a custom API URL with `TEST_API_BASE_URL=<url>`

### Testing framework

The project uses:

- **JUnit 5** for test framework
- **Mockito** for mocking
- **AssertJ** for fluent assertions
- **WireMock** for HTTP service mocking
- **Custom TestServerExtension** for mock server management

## Linting and formatting

This repository uses [Spotless](https://github.com/diffplug/spotless) with Palantir Java Format for code formatting and various linting tools.

To check formatting and run lints:

```sh
$ ./scripts/lint
```

This will compile all modules and run static analysis checks.

To format and fix all formatting issues automatically:

```sh
$ ./scripts/format
```

You can also check formatting directly with Gradle:

```sh
$ ./gradlew spotlessCheck  # Check formatting
```

## Building

To build all modules:

```sh
$ ./gradlew build
```

To build a specific module:

```sh
$ ./gradlew :openai-java-core:build
```

## Adding and running examples

All files in the `openai-java-example/` directory are not modified by the generator and can be freely edited or added to.

```java
// add an example to openai-java-example/src/main/java/com/openai/example/<YourExample>.java

package com.openai.example;

public class YourExample {
    public static void main(String[] args) {
        // ...
    }
}
```

## Publishing and releases

Changes made to this repository via the automated release PR pipeline should publish to Maven Central automatically. If
the changes aren't made through the automated pipeline, you may want to make releases manually.

### Publish with a GitHub workflow

You can release to package managers by using [the `Publish Sonatype` GitHub action](https://www.github.com/openai/openai-java/actions/workflows/publish-sonatype.yml). This requires setup organization or repository secrets to be configured.

### Publish manually

If you need to manually release a package, you can run:

```sh
$ ./gradlew publishToSonatype closeAndReleaseSonatypeStagingRepository
```

This requires the following environment variables to be set:

- `SONATYPE_USER` - Your Sonatype Central Portal username
- `SONATYPE_PASSWORD` - Your Sonatype Central Portal password
- `GPG_SIGNING_KEY` - Your GPG private key for signing artifacts
- `GPG_SIGNING_PASSWORD` - Your GPG key passphrase

## Development tools

### Available gradle tasks

Some useful Gradle tasks:

```sh
$ ./gradlew tasks               # List all available tasks
$ ./gradlew build               # Build all modules
$ ./gradlew test                # Run all tests
$ ./gradlew spotlessApply       # Format code
$ ./gradlew publishToMavenLocal # Publish to local Maven repository
$ ./gradlew dependencies        # Show dependency tree
```
