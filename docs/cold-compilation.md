# Cold in-process Kotlin compilation

The SDK enables the Build Tools API runner for its pinned Kotlin 2.2.21 plugin.
The normal Kotlin daemon execution strategy remains the default. Callers such as
OkTest that explicitly select `in-process` also retain that strategy and their
existing memory limits.

Kotlin 2.2.21's [legacy in-process runner](https://github.com/JetBrains/kotlin/blob/v2.2.21/libraries/tools/kotlin-gradle-plugin/src/common/kotlin/org/jetbrains/kotlin/compilerRunner/GradleKotlinCompilerWork.kt)
creates a new compiler classloader for each compilation. Its
[Build Tools API runner](https://github.com/JetBrains/kotlin/blob/v2.2.21/libraries/tools/kotlin-gradle-plugin/src/common/kotlin/org/jetbrains/kotlin/compilerRunner/btapi/BuildToolsApiCompilationWork.kt)
uses the plugin's classloader caching service instead. This avoids repeatedly
loading and JIT-compiling the compiler as the SDK's internal shards execute.
Revisit this version-specific opt-in when upgrading the Kotlin plugin.

This Build Tools API version supports `daemon` and `in-process`, but not
`out-of-process`. Builds that require the latter can select the legacy runner
with `-Pkotlin.compiler.runViaBuildToolsApi=false`.

## Full SDK profile

These are local exploratory measurements, not production timings. Both runs used
the source tree at `c73a2625992791f1f2ce41ef25fdea4f5db045a3` (SDK 4.89.0),
containing 2,369 core Kotlin files and 65,661,287 source bytes. The local merge
commit `81a01b56d67e4d1791b04b6a61d5e335b63c43a6` has the same tree.

- AMD EPYC-Milan devbox with 16 available CPUs; one Gradle worker.
- Temurin 21.0.12.1+1, Gradle 9.8.1, SDK Kotlin compiler/plugin 2.2.21.
- Kotlin language/API 1.8 and JVM target 1.8 in both runs.
- In-process compilation, 4 GiB heap, 768 MiB metaspace, no task build cache.
- Fresh SDK compilation outputs; Gradle profiles, compiler phase reports, and JFR
  enabled in both runs. All 16 SDK Kotlin compilation tasks executed.

The measured invocation was OkTest's composite SDK-JAR stage:
`:openai-java:openai-java-client-okhttp:jar`. It excludes the preceding dependency
invocation, bridge compilation, the compatibility suite, and cache transfers.
The baseline initially populated its dependency cache; the candidate reused
downloaded dependencies. Dependency-invocation times therefore are not a paired
performance comparison.

| Measurement | Legacy runner | Build Tools API |
| --- | ---: | ---: |
| SDK invocation, Gradle profile | 962.350 s | 695.650 s |
| Sum of 16 SDK Kotlin compilation tasks | 927.232 s | 661.479 s |
| Core class aggregation | 17.656 s | 18.498 s |
| Common model compilation | 112.380 s | 104.150 s |
| Beta model compilation | 127.450 s | 106.170 s |
| Admin service compilation | 40.136 s | 16.610 s |
| Final core client compilation | 20.979 s | 5.995 s |

The SDK invocation fell 27.7%, or 266.7 seconds. Baseline compiler phase reports
attribute 618 seconds to semantic analysis and type resolution. The candidate
recording shows one large compiler URL classloader where the baseline recording
shows multiple separately loaded compiler instances.

All 34,851 aggregate core output files, including Kotlin module metadata, were
byte-for-byte identical. The complete OkHttp client JAR was also identical:
`7af2b4b18f42c314319e997b338f617970e18a2abb52deaad9f086ff7e6dd72e`.

## Controlled two-CPU comparison

Both variants then ran offline in separate disposable containers created from
the same prepared image, with a two-CPU quota and 6 GiB memory limit. Downloads
and toolchain were identical; compilation retained one worker, a 4 GiB heap,
and 768 MiB metaspace. These runs used compiler/Gradle reports without JFR.
The candidate set the property in the SDK's `gradle.properties`; the baseline
omitted it. The separate `buildSrc` build did not inherit the property.

The requested tasks were `openai-java-core-models-common:compileKotlin` and
`openai-java-core-models-admin:compileKotlin`, plus their runtime and foundation
dependencies. Before the cold invocation, all four shards' build directories
were removed inside each disposable container. Task build caching was disabled.
The warm invocation repeated the same tasks without changing files. The final
invocation changed only the `toString()` string literal in the handwritten
`StructuredResponse.kt`, leaving signatures unchanged. These are representative
shard measurements, not full-SDK timings.

| Scenario, complete invocation wall time | Legacy runner | Build Tools API |
| --- | ---: | ---: |
| Cold compilation of four shards | 358.733 s | 303.812 s |
| Unchanged outputs | 16.684 s | 17.477 s |
| One-file body edit | 165.578 s | 24.042 s |

Cold time fell 15.3%; the body-edit case fell 85.5%. The single unchanged-build
sample does not demonstrate an improvement. All 4,941 common-model output files
matched between runners after both cold compilation and the body edit. Comparing
the edited output with the original output changed exactly
`StructuredResponse.class`; the incremental result matched the legacy runner's
full recompilation of that same edited source.

Peak container memory across the three invocations was 4,673,671,168 bytes for
the baseline and 4,801,507,328 bytes for the candidate, both below the 6 GiB limit.
These are container peaks, including filesystem cache, not JVM heap measurements.

## Cache and execution boundaries

The Build Tools API also supports incremental in-process compilation. Its local
SDK compiler state occupied approximately 167 MiB more uncompressed space in
this experiment. A local gzip archive of that state was 24,419,086 bytes
(23.3 MiB). That is a size measurement, not a hosted transfer timing or the size
of a complete Gradle seed. The state is distinct from compiled classes, whose
contents were unchanged. Docker-layer and cache-transfer costs must be considered
separately from compiler time.

This setting does not change dependency versions, compiler language/API levels,
worker counts, test selection, or cache-publication rules. OkTest consumers still
use disposable builders and must never export a builder after executing private
SDK inputs. Only separately qualified public-source producers may publish seeds.
