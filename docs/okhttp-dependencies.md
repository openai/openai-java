# OkHttp dependencies

The Java SDK uses `com.squareup.okhttp3:okhttp:4.12.1` for the default transport.
The previous version was 4.12.0. Version 4.12.1 blocks eight compromised
intermediate certificates. The SDK uses the Okio version that OkHttp declares,
3.6.0. Transport tests use MockWebServer and okhttp-tls from the same OkHttp
release. [Upstream release notes](https://lysine.dev/okhttp/changelogs/changelog_4x/#version-4121)

## Migration

Maven and Gradle applications can continue to depend on `com.openai:openai-java`.
If your application pins OkHttp at 4.12.0, update the pin to 4.12.1 to receive
the certificate fix. The default client builder and its
`okHttpClient(okhttp3.OkHttpClient)` overload retain the same signatures.
Applications that supply a transport through `openai-java-core` can continue
to use core without adding OkHttp.

## Shrinker configuration

The OkHttp transport JAR includes `META-INF/proguard/openai-java-client-okhttp.pro`.
If you invoke ProGuard directly, include this file alongside the consumer rules
from the other JARs on your classpath. It prevents ProGuard 7.10.0 from emitting
invalid bytecode for Okio’s input and output stream adapters.

## Version selection

The patch keeps the existing Java 8 target and OkHttp 4 JVM coordinate.
Before changing OkHttp generations, verify that installed Maven and Gradle
applications both resolve JVM classes, and compile a Kotlin caller that passes
its own OkHttp client at the SDK's minimum supported compiler version.
Review the upstream support status and transport tests before each major SDK
release or when a required fix is unavailable on the current dependency line.
