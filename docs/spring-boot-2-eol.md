# Spring Boot 2 starter end-of-life

**Status:** Accepted 2026-07-27

## Decision

`com.openai:openai-java-spring-boot-starter` targets Spring Boot 2.7 and is OpenAI EOL effective
2026-07-27. Version 4.45.0 is its final supported, tested, and published OpenAI SDK release. That
release remains downloadable, but no later starter versions will be published and it receives no
fixes, testing, or compatibility support.

Spring ended public OSS support for Boot 2 with
[2.7.18 on 2023-11-23](https://spring.io/blog/2023/11/23/spring-boot-2-7-18-available-now/).
The policy's maximum six-month grace period therefore ended 2024-05-23. Commercial maintenance does
not satisfy the repository's OSS-support admission rule, and the upstream gap is already much
longer than the permitted grace period.

Declaring the unchanged starter EOL is a minor release. Removing the artifact, raising its Java
floor, or changing the same coordinate to a newer Spring generation would require a SemVer major.
A future supported Spring integration must use generation-specific coordinates and independently
pass the policy's 12-month admission gate.

## Consumer migration

Applications that cannot leave Boot 2 may pin the starter to 4.45.0, but do so without OpenAI or
upstream OSS security support. The preferred path is:

1. Follow Spring's [Boot 3 migration guide](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Migration-Guide):
   upgrade to the latest 2.7 release first, move to Java 17 and Spring Framework 6, and migrate
   affected Java EE imports to Jakarta EE.
2. Remove `openai-java-spring-boot-starter`.
3. Depend on `com.openai:openai-java` and provide a normal application-owned `OpenAIClient` bean.

```java
@Bean
OpenAIClient openAIClient() {
    return OpenAIOkHttpClient.fromEnv();
}
```

This keeps Spring's dependency platform authoritative and avoids pretending that a Boot 2
auto-configuration artifact supports Boot 3 or later.
