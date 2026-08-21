# Contributing to OpenAI Java SDK

## Setting up the environment

This repository uses [Gradle](https://gradle.org/) with Kotlin DSL for building and dependency
management. The framework-neutral SDK requires Java 8, while development requires JDK 21 for the
Kotlin toolchain. See the [Java version support policy](docs/version-support-policy.md) for
artifact-level runtime, framework, lifecycle, and release rules.

## Custom-code budget

The custom-code budget counts additions plus deletions in the remaining patch
against verified generated output. `.castiron-ratchet.json` defines this repository's
ceiling. CI uses the checker and budget on main, not the PR's proposed versions.

Budget changes must be in a separate PR modifying **only `.castiron-ratchet.json`**.
Justify the current usage, proposed ceiling, and why fixing generation is not
appropriate in the PR description. Increases require a **human approving review**
and must merge before an SDK change relies on them. Agents may draft proposals,
but must not approve increases or bypass the gate. Keep default CODEOWNERS.
Lower the ceiling after cleanup while retaining headroom; decreases must still
fit the measured usage.

See [custom-code technical details](scripts/castiron/CUSTOM_CODE.md) for accounting,
local checks, trusted CI, and activation instructions.

## Security expectations

- Never commit API keys, bearer tokens, AWS/Bedrock credentials, Maven Central/Sonatype tokens, GPG
  private keys or passphrases, or other secrets. Use environment variables such as `OPENAI_API_KEY`
  and clearly fake values in examples, JUnit/WireMock fixtures, recordings, and snapshots.
- Keep credentials, authorization headers, signed requests, and customer data out of default or
  uncontrolled logs, errors, and test output. Preserve documented `OpenAIServiceException.body()`,
  API-error and validation messages, and explicitly enabled `DEBUG` diagnostics; use sanitized
  fixtures and redact sensitive data before forwarding it to untrusted sinks.
- Scrutinize direct and transitive Maven dependencies, Gradle plugins and repositories, Gradle
  wrapper/distribution changes, dependency locks, and build/install scripts. Verify integrity and
  provenance before adding or updating anything that executes during the build.
- Pin third-party GitHub Actions to full commit SHAs, minimize workflow token and publishing
  permissions, avoid exposing secrets to untrusted pull requests, and protect Sonatype credentials,
  GPG signing keys, and tokens in their release or publishing environments.
- Obtain security-focused review and add regression tests for changes to authentication, OkHttp
  transport, redirects/TLS, file uploads or paths, Jackson deserialization, AWS/Bedrock credentials,
  or signing and release workflows.
- Report vulnerabilities privately through [SECURITY.md](SECURITY.md), never in public issues,
  discussions, or pull requests.

## Project structure

The SDK's primary artifacts are:

- `openai-java-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`OpenAIClient`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClient.kt), [`OpenAIClientAsync`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsync.kt), [`OpenAIClientImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt), and [`OpenAIClientAsyncImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsyncImpl.kt), all of which can work with any HTTP client
- `openai-java-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`OpenAIOkHttpClient`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClient.kt) and [`OpenAIOkHttpClientAsync`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClientAsync.kt), which provide a way to construct [`OpenAIClientImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt) and [`OpenAIClientAsyncImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsyncImpl.kt), respectively, using OkHttp
- `openai-java`
  - Depends on and exposes the APIs of both `openai-java-core` and `openai-java-client-okhttp`
  - Does not have its own logic
- `openai-java-bedrock`
  - Adds optional Amazon Bedrock authentication and credential-provider integration

The retired Spring Boot 2 starter is not part of the active build. Its final source remains available
in the [`v4.45.0` tag](https://github.com/openai/openai-java/tree/v4.45.0/openai-java-spring-boot-starter),
and its lifecycle history and consumer migration path are documented in the
[Spring Boot 2 EOL decision](docs/spring-boot-2-eol.md).

`openai-java-runtime-compatibility` is a non-published fixture that exercises representative
behavior for each supported artifact on an isolated runtime classpath. Its JVM matrix and each
artifact's eligibility on a given JVM come from `gradle/version-support.properties`.

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

> [!NOTE]
> For now, to publish locally, you'll need to comment out the line for `signAllPublications()` here: `buildSrc/src/main/kotlin/openai.publish.gradle.kts`

Then in your project's `build.gradle.kts` or `pom.xml`, reference the locally published version:

<!-- x-release-please-start-version -->

```kotlin
implementation("com.openai:openai-java:4.52.0")
```

```xml
<dependency>
  <groupId>com.openai</groupId>
  <artifactId>openai-java</artifactId>
  <version>4.52.0</version>
</dependency>
```

<!-- x-release-please-end -->

Alternatively, you can build and install the JAR files directly:

```sh
$ ./gradlew build
```

JAR files will be available in each module's `build/libs/` directory.

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

Kotlin formatting uses the repository-pinned ktfmt version and Kotlin style. The same
Gradle tasks cover SDK sources and the `.kt` build-logic sources under `buildSrc/src`,
whether or not a standalone `ktfmt` is installed. Java formatting uses Palantir Java Format.

To check formatting:

```sh
$ ./scripts/lint
```

To fix formatting:

```sh
$ ./scripts/format
```

For Kotlin only, run `./gradlew lintKotlin` or `./gradlew formatKotlin`. A module's
own tasks remain available, such as `./gradlew :openai-java-core:lintKotlin`.

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

The [`Create releases` workflow](https://www.github.com/openai/openai-java/actions/workflows/create-releases.yml)
publishes new releases automatically. To recover a failed Maven Central publication, run that workflow manually from
`main` with the existing GitHub release tag.

Before retrying, check Central Portal and confirm that the version has no existing deployment. Maven Central releases are
immutable, so do not upload the same version while an earlier deployment is still processing. The workflow verifies the
exact release source, runs the runtime compatibility matrix, and waits for every expected artifact to become public.

The workflow requires the GitHub `publish` environment to be configured.

The `publish` environment must have these environment secrets:

- `OPENAI_SONATYPE_USERNAME` - The username from a Central Portal user token
- `OPENAI_SONATYPE_PASSWORD` - The password from a Central Portal user token
- `OPENAI_SONATYPE_GPG_SIGNING_KEY` - The ASCII-armored GPG private key used for signing artifacts
- `OPENAI_SONATYPE_GPG_SIGNING_PASSWORD` - The GPG key passphrase

To rotate credentials, generate a new Central Portal user token and update `OPENAI_SONATYPE_USERNAME` and
`OPENAI_SONATYPE_PASSWORD`. If rotating the signing key, generate a passphrase-protected GPG key and publish the public
key:

```sh
$ gpg --quick-gen-key "OpenAI Maven Central <maintainer@openai.com>" rsa4096 sign 0
$ gpg --list-secret-keys --keyid-format LONG
$ gpg --keyserver keyserver.ubuntu.com --send-keys KEY_ID
```

The `0` makes the key non-expiring. `KEY_ID` is the value after the slash on the `sec` line from
`gpg --list-secret-keys`, for example `42B825E73825CCEB` in `sec rsa4096/42B825E73825CCEB`. The GPG email does not need
to match the Central Portal token account.

```sh
$ gh secret set OPENAI_SONATYPE_USERNAME --env publish --repo openai/openai-java
$ gh secret set OPENAI_SONATYPE_PASSWORD --env publish --repo openai/openai-java
$ (
>   set -eu
>   trap 'unset signing_key' EXIT
>   signing_key="$(gpg --armor --export-secret-keys KEY_ID)"
>   case "$signing_key" in
>     "-----BEGIN PGP PRIVATE KEY BLOCK-----"*"-----END PGP PRIVATE KEY BLOCK-----") ;;
>     *) echo "Refusing to store an empty or invalid private key" >&2; exit 1 ;;
>   esac
>   printf '%s\n' "$signing_key" |
>     gh secret set OPENAI_SONATYPE_GPG_SIGNING_KEY --env publish --repo openai/openai-java
>   unset signing_key
> )
$ gh secret set OPENAI_SONATYPE_GPG_SIGNING_PASSWORD --env publish --repo openai/openai-java
```

Validate the armored private key in a short-lived shell variable before updating the protected
`publish` environment. Never write it to the repository or another file, print it in logs, or run
these commands with shell tracing enabled.

After the rotated secrets work, revoke the old Central Portal token and remove any old repository-level copies of the
`OPENAI_SONATYPE_*` secrets.

### Publish manually

The GitHub workflow is preferred because it validates the immutable release identity and requires a Central Portal check
before retrying. If you need to publish directly as a last resort, first confirm in Central Portal that the version has no
existing deployment, then run:

```sh
$ ORG_GRADLE_PROJECT_mavenCentralUsername="$SONATYPE_USERNAME" \
    ORG_GRADLE_PROJECT_mavenCentralPassword="$SONATYPE_PASSWORD" \
    ./gradlew publishAndReleaseToMavenCentral --no-configuration-cache
```

Pass Maven Central credentials through Gradle's environment-backed project properties, not `-P`
command-line arguments, committed `gradle.properties` files, logs, or shell history.

This requires the following environment variables to be set:

- `SONATYPE_USERNAME` - The username from a Central Portal user token
- `SONATYPE_PASSWORD` - The password from a Central Portal user token
- `GPG_SIGNING_KEY` - Your ASCII-armored GPG private key for signing artifacts
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
