# Java version support policy

This policy governs the OpenAI Java SDK's supported JVMs, framework integrations, and
material runtime dependencies. Compatibility is declared per published artifact, not inferred
from the JDK used to build the repository. Dependency-specific decisions belong in short ADRs
that apply this policy.

## Compatibility contract

- Every artifact declares its runtime and bytecode/API floor and lifecycle state in
  [`gradle/version-support.properties`](../gradle/version-support.properties). Framework
  generations and tested ranges belong in the relevant artifact documentation or ADR.
- A newer build JDK must not silently raise the consumer runtime floor.
- The framework-neutral core evolves independently from optional integrations. An integration may
  require a newer JVM only when it uses a separate, generation-specific artifact.

## Kotlin callers on the next major

Kotlin callers need compiler **2.3.0 or later**. Java-only applications can use the SDK on Java 8.
The SDK build uses JDK 21 and the Kotlin 2.4.21 compiler and Gradle plugin. It compiles SDK
sources at language and API level 2.0 and publishes JVM 8 bytecode with Kotlin metadata 2.0.0.
The published dependencies request Kotlin stdlib and reflection 2.4.21.

See the [Kotlin migration guide](next-kotlin-migration.md) for consumer build changes and tested versions.

## Admission and retirement

- Do not add support for a runtime, framework, or major dependency generation with fewer than
  **12 months of expected public OSS security maintenance** remaining. Commercial-only maintenance
  does not count.
- An already-supported generation enters maintenance during its final 12 months: critical fixes and
  migration help only, with no feature expansion.
- At upstream EOL, retire support or grant a documented grace period of **up to six months**. State
  the exact end date and the limits of supporting software that no longer receives upstream fixes.
- After the grace period, the generation is OpenAI EOL. Old artifacts may remain downloadable, but
  availability is not support.
- Security risk may shorten timelines. It does not turn a breaking change into a compatible one.

## Framework and dependency ownership

- Use separate coordinates for materially incompatible framework generations. Do not span them
  with reflection or hidden runtime branching.
- The consuming application's framework platform or BOM is authoritative. Do not force isolated
  framework components outside its supported dependency graph.
- OpenAI owns core implementation dependencies. Consumers own their application platform.
  Optional integration dependencies are shared: OpenAI declares and tests the range; consumers
  choose the version through their platform.

## Release treatment

| Change | Default release |
| --- | --- |
| Fix or dependency update within the supported contract | Patch |
| Add a new, explicit integration artifact | Minor |
| Move an existing generation to maintenance, deprecate it, or declare it EOL while leaving its last release available | Minor |
| Raise an artifact's JVM/API floor; change its framework generation; remove an artifact; or remove a transitive dependency consumers may rely on | Major |
| Urgent security-driven incompatible change | Major by default; security changes timing, not compatibility |

## Required proof

- **Every PR:** verify every published artifact's declared JVM floor, compiler API floor, and
  emitted bytecode; run each supported artifact's isolated consumer smoke test on its runtime floor
  and the current LTS; check public API compatibility; and run the normal build, test, and
  dependency-compatibility suites.
- **Nightly and before release:** run every supported artifact's isolated consumer smoke test on
  every compatible supported LTS and use the current non-LTS JDK as a forward-compatibility signal.
- **Quarterly and before GA:** review upstream lifecycles and revalidate the 12-month admission gate,
  generated metadata, dependency ownership, and migration plan.
- Any material runtime, framework, or dependency-generation change requires an ADR covering
  lifecycle evidence, affected artifacts, consumer resolution, migration, SemVer treatment, final
  compatible release, and verification.

## Current decisions

| Surface | Decision | Next action |
| --- | --- | --- |
| Framework-neutral artifacts | Keep Java 8 through SDK v5. | Raise the floor only in an SDK major; first prefer replacing or isolating a constraining dependency. |
| Default HTTP transport | Use OkHttp 4.12.1 and its Okio 3.6.0 dependency on Java 8 and newer. | Recheck JVM artifact resolution and Kotlin consumer compatibility before moving to OkHttp 5. See [the transport decision](okhttp-dependencies.md). |
| Retired Spring Boot 2 starter | OpenAI EOL as of 2026-07-27; 4.45.0 is the final supported and published release, and its source is no longer in the active build. | Keep the final artifact and tagged source available; follow the [Spring Boot 2 EOL decision](spring-boot-2-eol.md); publish no later versions. |
| Potential Spring Boot 4 integration | Candidate Java 17 integration using a new generation-specific artifact. | Pass the admission gate and Spring ADR before implementation. |

Do not publish an OpenAI Java BOM until independently versioned artifacts or demonstrated consumer
resolution failures create a real alignment need. Add an optional integration only when it passes
the lifecycle gate, solves substantial repeated work for SDK users, and has a named owner and funded
compatibility matrix.

## Jackson in v5

The SDK uses Jackson 2 for request bodies, response models, and streamed events.
The default is Jackson 2.21.8 LTS. FasterXML plans to maintain the 2.21 line
through January 31, 2028. The SDK also tests behavior with older Jackson 2
versions. Upstream maintenance dates apply to each Jackson release line.
[Jackson 2.21 support window](https://github.com/FasterXML/jackson/wiki/Jackson-Release-2.21#status)

Keep the SDK's transitive Jackson 2 dependencies when your application uses Jackson 3.
The application can continue to use its own mapper. To pass a generated model between
mappers, exchange JSON bytes. For example, an application using Jackson 3 can read an
SDK content part as follows:

```java
byte[] json = ObjectMappers.jsonMapper().writeValueAsBytes(contentPart);
tools.jackson.databind.JsonNode tree = applicationMapper.readTree(json);
```

Use `ObjectMappers.jsonMapper().readValue(bytes, ChatCompletionContentPart.class)`
for the reverse conversion. Generated union deserializers use Jackson 2 APIs. Direct
binding of SDK models with an application's Jackson 3 mapper is unsupported.
Migrating core to Jackson 3 would require Java 17 and change public Jackson 2 types.
[Jackson 3 requirements and API changes](https://github.com/FasterXML/jackson/wiki/Jackson-Release-3.0)

Structured Outputs use Victools 4.38.0. Applications may supply either
`swagger-annotations` or `swagger-annotations-jakarta` when they need Swagger schema
constraints. On Java 8 or 11, use a 2.x annotation JAR. Both 2.2.31 variants
work on Java 8. The standard 3.0.0 annotation JAR requires Java 17.
Models using Jackson annotations alone need neither provider. Victools
5 uses Jackson 3 and would require a separate schema integration.
[Victools 5.0.0 dependency versions](https://repo.maven.apache.org/maven2/com/github/victools/jsonschema-generator-parent/5.0.0/jsonschema-generator-parent-5.0.0.pom)

The installed-core check exercises the Spring Boot 3.5.16 BOM with Jackson 2.21.4
and the 4.1.2 BOM with Jackson 2.21.7 alongside application Jackson 3.1.7.
These are dependency-management configurations. The SDK exposes no Spring starter
for either generation.

## Supporting rationale

- Direct AI SDK peers such as [Anthropic Java](https://github.com/anthropics/anthropic-sdk-java#requirements)
  and [Google Gen AI Java](https://github.com/googleapis/java-genai/blob/main/pom.xml) retain a Java 8
  core floor.
- [Google Cloud Java](https://github.com/googleapis/java-datastore#supported-java-versions) treats
  raising the JVM floor as a SemVer-major boundary.
- The [AWS SDK maintenance policy](https://docs.aws.amazon.com/sdkref/latest/guide/maint-policy.html)
  demonstrates explicit, time-bounded support beyond an upstream dependency's EOL.
- [Jackson](https://github.com/FasterXML/jackson-databind#jdk) and
  [Spring Boot](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-4.0-Migration-Guide)
  use major generations for JVM, package, namespace, and framework compatibility boundaries.
