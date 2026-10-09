package com.openai.gradle

import java.nio.file.Files
import java.nio.file.Path
import java.util.Locale
import kotlin.io.path.readText
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.jupiter.api.io.TempDir
import org.yaml.snakeyaml.LoaderOptions
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.SafeConstructor

class GradleCacheTrustPolicyTest {
    @TempDir lateinit var temporaryDirectory: Path

    @Test
    fun `Graal release test step supports current and older source tasks and stops on query failure`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val script =
            requireNotNull(
                parseWorkflow(workflow)
                    .job("publish")
                    .steps
                    .single { it.name == "Run GraalVM native-image agent tests" }
                    .run
            )
        Files.copy(
            Path.of("../.github/scripts/run-graalvm-tests.sh"),
            temporaryDirectory.resolve("run-graalvm-tests.sh"),
        )
        val wrapper = temporaryDirectory.resolve("gradlew")
        wrapper.writeText(
            """
            |#!/usr/bin/env bash
            |set -euo pipefail
            |case "${'$'}1" in
            |    :openai-java-core:tasks)
            |        printf '%s\n' "${'$'}AVAILABLE_TASKS"
            |        exit "${'$'}QUERY_STATUS"
            |        ;;
            |    :openai-java-core:test)
            |        printf '%s\n' "${'$'}@" > "${'$'}RUNNER_TEMP/test-arguments"
            |        ;;
            |    *) exit 93 ;;
            |esac
            """
                .trimMargin() + "\n"
        )
        assertTrue(wrapper.toFile().setExecutable(true))
        val testArguments = temporaryDirectory.resolve("test-arguments")
        val baseArguments =
            listOf(
                ":openai-java-core:test",
                "-x",
                "compileJava",
                "-x",
                "compileTestJava",
                "-x",
                "compileKotlin",
                "-x",
                "compileTestKotlin",
            )
        val shards = listOf("compileBetaModelTestKotlin", "compileAdminModelTestKotlin")
        val currentListing = shards.joinToString("\n") { "$it - Compiles the test sources." }
        // An old source or unrelated task prefix must not produce an unknown exclusion.
        val oldListing =
            "compileTestKotlin - Compiles tests.\ncompileBetaModelTestKotlinOther - Unrelated."
        for ((listing, status, expectedShards) in
            listOf(
                Triple(currentListing, "0", shards),
                Triple(oldListing, "0", emptyList()),
                Triple(currentListing, "19", emptyList()),
            )) {
            Files.deleteIfExists(testArguments)
            val builder =
                ProcessBuilder("bash", "-euo", "pipefail", "-c", script)
                    .directory(temporaryDirectory.toFile())
                    .redirectErrorStream(true)
            builder
                .environment()
                .putAll(
                    mapOf(
                        "RUNNER_TEMP" to temporaryDirectory.toString(),
                        "AVAILABLE_TASKS" to listing,
                        "QUERY_STATUS" to status,
                    )
                )
            val process = builder.start()
            val output = process.inputStream.bufferedReader().use { it.readText() }
            assertEquals(status.toInt(), process.waitFor(), output)
            if (status == "0") {
                assertEquals(
                    baseArguments +
                        expectedShards.flatMap { listOf("-x", ":openai-java-core:$it") } +
                        "-PgraalvmAgent",
                    testArguments.readText().lines().filter { it.isNotEmpty() },
                    output,
                )
            } else {
                assertFalse(
                    Files.exists(testArguments),
                    "Failed task query must stop before tests.",
                )
            }
        }
    }

    @Test
    fun `all pull request Gradle jobs keep cross-run caches read-only`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        assertPullRequestCachePolicy(workflow)
    }

    @Test
    fun `SDK compilation cache cannot be saved by a PR or an earlier job`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        val trustedSave =
            "github.event_name == 'push' &&\n" +
                "          github.ref_name == github.event.repository.default_branch &&\n" +
                "          steps.sdk-compilation-cache.outputs.cache-hit != 'true'"

        for (unsafeSave in listOf("true", "github.event_name == 'pull_request'", "always()")) {
            val poisonedWorkflow = workflow.replace(trustedSave, unsafeSave)
            assertTrue(poisonedWorkflow != workflow)
            assertFailsWith<AssertionError> { assertPullRequestCachePolicy(poisonedWorkflow) }
        }

        val earlierSave =
            workflow.replace(
                "      - name: Run lints\n",
                "      - name: Save incomplete compilation cache\n" +
                    "        uses: actions/cache/save@caa296126883cff596d87d8935842f9db880ef25\n" +
                    "        with:\n" +
                    "          path: ~/.gradle/caches/build-cache-1\n" +
                    "          key: java-sdk-compile-v1-incomplete\n\n" +
                    "      - name: Run lints\n",
            )
        assertTrue(earlierSave != workflow)
        assertFailsWith<AssertionError> { assertPullRequestCachePolicy(earlierSave) }
    }

    @Test
    fun `untrusted CI cannot move outside GitHub enforced pull request cache scope`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()

        listOf(
                workflow.replaceFirst("\n  pull_request:\n", "\n  pull_request_target:\n"),
                workflow.replaceFirst(
                    "\n  workflow_dispatch:\n",
                    "\n  workflow_run:\n" +
                        "    workflows: [CI]\n" +
                        "    types: [completed]\n" +
                        "  workflow_dispatch:\n",
                ),
                "$workflow\n\"on\":\n  pull_request:\n",
            )
            .forEach { poisonedWorkflow ->
                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> { assertPullRequestCachePolicy(poisonedWorkflow) }
            }
    }

    @Test
    fun `pull request cache policy rejects write-only overrides`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()

        listOf("true", "TRUE", "\${{ github.event_name == 'pull_request' }}").forEach { writeOnly ->
            val poisonedWorkflow =
                workflow.replaceFirst(
                    "          cache-read-only: true",
                    "          cache-read-only: true\n          cache-write-only: $writeOnly",
                )

            assertTrue(poisonedWorkflow != workflow)
            assertFailsWith<AssertionError> { assertPullRequestCachePolicy(poisonedWorkflow) }
        }

        assertPullRequestCachePolicy(
            workflow.replaceFirst(
                "          cache-read-only: true",
                "          cache-read-only: true\n          cache-write-only: false",
            )
        )
    }

    @Test
    fun `pull request cache policy rejects case-insensitive inputs and duplicates`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()

        listOf(
                "CACHE-WRITE-ONLY: true",
                "CACHE-READ-ONLY: false",
                "\"CACHE-\\u0052EAD-ONLY\": false",
            )
            .forEach { poisonedInput ->
                val poisonedWorkflow =
                    workflow.replaceFirst(
                        "          cache-read-only: true",
                        "          cache-read-only: true\n          $poisonedInput",
                    )

                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> { assertPullRequestCachePolicy(poisonedWorkflow) }
            }

        assertPullRequestCachePolicy(
            workflow.replaceFirst(
                "          cache-read-only: true",
                "          CACHE-READ-ONLY: true",
            )
        )
    }

    @Test
    fun `pull request rejects Gradle setup aliases before the protected initializer`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        val protectedSetup = "      - name: Set up Gradle\n"
        val poisonedWorkflow =
            workflow.replaceFirst(
                protectedSetup,
                "      - name: Initialize legacy Gradle cache\n" +
                    "        uses: gradle/gradle-build-action@12318b01111bfa6462c00534ffa998f8b397b979\n\n" +
                    protectedSetup,
            )

        assertTrue(poisonedWorkflow != workflow)
        assertFailsWith<AssertionError> { assertPullRequestCachePolicy(poisonedWorkflow) }
    }

    @Test
    fun `pull request rejects every Gradle-owned initializer and writable cache override`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        val protectedSetup = "      - name: Set up Gradle\n"
        val actionRevision = "0723195856401067f7a2779048b490ace7a47d7c"

        listOf(
                "gradle/actions/dependency-submission@$actionRevision",
                "GRADLE/Actions/Dependency-Submission@$actionRevision",
                "\"gradle/actions/dependency-\\u0073ubmission@$actionRevision\"",
                "gradle/actions/future-initializer@$actionRevision",
                "gradle/future-gradle-action@$actionRevision",
            )
            .forEach { action ->
                val poisonedWorkflow =
                    workflow.replaceFirst(
                        protectedSetup,
                        "      - name: Initialize unprotected Gradle cache\n" +
                            "        uses: $action\n" +
                            "        with:\n" +
                            "          cache-write-only: true\n" +
                            "          gradle-home-cache-includes: init.d\n\n" +
                            protectedSetup,
                    )

                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> { assertPullRequestCachePolicy(poisonedWorkflow) }
            }
    }

    @Test
    fun `exact-run cache artifacts are immutable identified and digest-verified`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        val buildJob = parseWorkflow(workflow).job("build")

        assertEquals(
            "\${{ steps.gradle-cache-artifact.outputs.artifact-id }}",
            buildJob.outputs["gradle-cache-artifact-id"],
        )
        val uploadStep =
            buildJob.steps.single { it.action?.repository == "actions/upload-artifact" }
        assertEquals("gradle-cache-artifact", uploadStep.id)
        val uploadAction = requireNotNull(uploadStep.action)
        assertEquals(
            "ci-gradle-build-cache-\${{ github.run_id }}-\${{ github.run_attempt }}",
            uploadAction.inputs["name"],
        )
        assertFalse(
            uploadAction.inputs["overwrite"].equals("true", ignoreCase = true),
            "Cache artifacts must remain immutable.",
        )

        val restoreSteps = artifactRestoreActions(workflow)

        assertEquals(4, restoreSteps.size, "All exact-run cache consumers must remain protected.")
        restoreSteps.forEach { restoreStep ->
            assertEquals(
                "\${{ needs.build.outputs.gradle-cache-artifact-id }}",
                restoreStep.inputs["artifact-ids"],
            )
            assertEquals("error", restoreStep.inputs["digest-mismatch"])
            assertEquals("~/.gradle/caches/build-cache-1", restoreStep.inputs["path"])
            assertFalse(
                "github-token" in restoreStep.inputs,
                "Cache artifacts must stay scoped to the current workflow run.",
            )
            assertFalse(
                "run-id" in restoreStep.inputs,
                "Cache artifacts must never be restored from another workflow run.",
            )
        }
    }

    @Test
    fun `artifact ID restores keep cache entries at the Gradle lookup path`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        val cacheKey = "0123456789abcdef0123456789abcdef"
        val cacheEntry = temporaryDirectory.resolve(cacheKey).apply { writeText("cached classes") }
        val restoreSteps = artifactRestoreActions(workflow)

        assertEquals(4, restoreSteps.size)
        restoreSteps.forEachIndexed { index, restoreStep ->
            val mergeMultiple =
                restoreStep.inputs["merge-multiple"].equals("true", ignoreCase = true)

            listOf(1, 2).forEach { selectedArtifactCount ->
                val cacheRoot =
                    temporaryDirectory
                        .resolve("consumer-$index-$selectedArtifactCount")
                        .resolve("build-cache-1")
                val extractionRoot =
                    if (mergeMultiple || selectedArtifactCount == 1) {
                        cacheRoot
                    } else {
                        cacheRoot.resolve("ci-gradle-build-cache")
                    }

                Files.createDirectories(extractionRoot)
                Files.copy(cacheEntry, extractionRoot.resolve(cacheKey))

                assertTrue(
                    Files.isRegularFile(cacheRoot.resolve(cacheKey)),
                    "Gradle must find ID-selected cache entries directly in build-cache-1.",
                )
            }
        }
    }

    @Test
    fun `publishing creates a private fresh Gradle home and never restores shared caches`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        assertPublishingCachePolicy(workflow)
    }

    @Test
    fun `publishing releases obsolete daemons and serializes documentation generation`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        assertPublishingRunnerStabilityPolicy(workflow)

        listOf(
                workflow.replaceFirst(
                    "      - name: Stop pre-GraalVM Gradle daemon\n" +
                        "        run: ./gradlew --stop\n\n",
                    "",
                ),
                workflow.replaceFirst("            --no-parallel \\\n", ""),
            )
            .forEach { poisonedWorkflow ->
                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> {
                    assertPublishingRunnerStabilityPolicy(poisonedWorkflow)
                }
            }
    }

    @Test
    fun `publishing credential lint rejects unconditional or inverted secret mappings`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val lint = parseWorkflow(Path.of("../.github/workflows/ci.yml").readText()).job("lint")
        val guard =
            requireNotNull(
                lint.steps
                    .single {
                        it.run?.contains("workflow=.github/workflows/create-releases.yml") == true
                    }
                    .run
            )
        val target = temporaryDirectory.resolve(".github/workflows/create-releases.yml")
        Files.createDirectories(target.parent)
        val conditional =
            "vars.MAVEN_CENTRAL_AUTH_PROXY_URL == '' && secrets.OPENAI_SONATYPE_USERNAME || ''"
        listOf(
                workflow to 0,
                workflow.replace(conditional, "secrets.OPENAI_SONATYPE_USERNAME") to 1,
                workflow.replace(
                    "vars.MAVEN_CENTRAL_AUTH_PROXY_URL == '' &&",
                    "vars.MAVEN_CENTRAL_AUTH_PROXY_URL != '' &&",
                ) to 1,
                workflow.replace("secrets.OPENAI_SONATYPE_PASSWORD", "secrets.WRONG_SECRET") to 1,
            )
            .forEach { (candidate, expected) ->
                target.writeText(candidate)
                val process =
                    ProcessBuilder("bash", "-c", guard)
                        .directory(temporaryDirectory.toFile())
                        .redirectErrorStream(true)
                        .start()
                val output = process.inputStream.bufferedReader().use { it.readText() }
                assertEquals(expected, process.waitFor(), output)
            }
    }

    @Test
    fun `publishing uses pinned Microsoft OIDC login with isolated cache and environment token`() {
        val job =
            parseWorkflow(Path.of("../.github/workflows/create-releases.yml").readText())
                .job("publish")
        val login = job.steps.single { it.action?.repository == "azure/login" }
        assertEquals(
            "azure/login@a641126d1b8aa4d1fa005f4f92df94a3a4c4c906",
            login.action!!.reference,
        )
        assertEquals(
            mapOf(
                "client-id" to "\${{ vars.MAVEN_CENTRAL_AZURE_CLIENT_ID }}",
                "tenant-id" to "\${{ vars.MAVEN_CENTRAL_AZURE_TENANT_ID }}",
                "allow-no-subscriptions" to "true",
            ),
            login.action.inputs,
        )
        assertEquals("vars.MAVEN_CENTRAL_AUTH_PROXY_URL != ''", login.condition)
        assertEquals(
            "\${{ runner.temp }}/maven-azure-\${{ github.run_id }}-\${{ github.run_attempt }}",
            job.environment["AZURE_CONFIG_DIR"],
        )
        val prepare = job.steps.single { it.run == "mkdir -m 700 \"\$AZURE_CONFIG_DIR\"" }
        val upload = job.steps.single { it.run?.contains("publishViaAuthProxy") == true }
        assertEquals(login.condition, prepare.condition)
        assertEquals(login.condition, upload.condition)
        assertTrue(job.steps.indexOf(prepare) < job.steps.indexOf(login))
        assertTrue(job.steps.indexOf(login) < job.steps.indexOf(upload))
        assertTrue(
            login.environment.isEmpty(),
            "Keep the action's default post-job cleanup enabled",
        )
        assertFalse(requireNotNull(upload.run).contains("GITHUB_ENV"))
        assertFalse(requireNotNull(upload.run).contains("GITHUB_OUTPUT"))
    }

    @Test
    fun `publishing passes the Azure token only in the child environment and fails on CLI errors`() {
        val job =
            parseWorkflow(Path.of("../.github/workflows/create-releases.yml").readText())
                .job("publish")
        val script =
            requireNotNull(job.steps.single { it.run?.contains("publishViaAuthProxy") == true }.run)
        val bin = Files.createDirectory(temporaryDirectory.resolve("bin"))
        val az = bin.resolve("az")
        az.writeText(
            "#!/usr/bin/env bash\n[[ \"\$1 \$2\" == 'account get-access-token' ]] || exit 91\nprintf '%s' '{\"accessToken\":\"fake-azure-token\",\"expires_on\":2000000000}'\n"
        )
        assertTrue(az.toFile().setExecutable(true))
        val wrapper = temporaryDirectory.resolve("gradlew")
        wrapper.writeText(
            "#!/usr/bin/env bash\nprintf '%s\\n' \"\$MAVEN_CENTRAL_AUTH_PROXY_TOKEN\" \"\$MAVEN_CENTRAL_AUTH_PROXY_TOKEN_EXPIRES_AT\" \"\$@\" > child-env\n"
        )
        assertTrue(wrapper.toFile().setExecutable(true))
        fun execute(): Pair<Int, String> {
            val builder =
                ProcessBuilder("bash", "-c", script)
                    .directory(temporaryDirectory.toFile())
                    .redirectErrorStream(true)
            builder.environment()["PATH"] = "$bin:${System.getenv("PATH")}"
            builder.environment()["MAVEN_CENTRAL_AZURE_RESOURCE"] = "api://fake-resource"
            val process = builder.start()
            val output = process.inputStream.bufferedReader().use { it.readText() }
            return process.waitFor() to output
        }
        val (status, output) = execute()
        assertEquals(0, status, output)
        assertEquals("::add-mask::fake-azure-token", output.trim())
        val received = temporaryDirectory.resolve("child-env").readText().lines()
        assertEquals(
            listOf(
                "fake-azure-token",
                "2000000000",
                "publishViaAuthProxy",
                "-PstageForAuthProxy=true",
                "--no-daemon",
                "--no-configuration-cache",
                "",
            ),
            received,
        )
        Files.delete(temporaryDirectory.resolve("child-env"))
        az.writeText("#!/usr/bin/env bash\nexit 42\n")
        assertEquals(42, execute().first)
        assertFalse(Files.exists(temporaryDirectory.resolve("child-env")))
    }

    @Test
    fun `publishing shares signing setup without giving vendor credentials to proxy mode`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val steps = parseWorkflow(workflow).job("publish").steps
        val signing = steps.single { "GPG_SIGNING_KEY" in it.environment }
        val upload = steps.single { it.run?.contains("publishViaAuthProxy") == true }
        assertEquals(1, steps.count { "GPG_SIGNING_KEY" in it.environment })
        for (kind in listOf("Username", "Password")) {
            val secret = "OPENAI_SONATYPE_${kind.uppercase(Locale.ROOT)}"
            assertEquals(
                "\${{ vars.MAVEN_CENTRAL_AUTH_PROXY_URL == '' && secrets.$secret || '' }}",
                signing.environment["ORG_GRADLE_PROJECT_mavenCentral$kind"],
            )
        }
        val script = requireNotNull(signing.run)
        assertContains(script, "publish_tasks=(publishAndReleaseToMavenCentral)")
        assertContains(
            script,
            "publish_tasks=(publishAllPublicationsToAuthProxyStagingRepository -PstageForAuthProxy=true)",
        )
        assertContains(script, "if [[ -n \"\${MAVEN_CENTRAL_AUTH_PROXY_URL:-}\" ]]")
        assertEquals("vars.MAVEN_CENTRAL_AUTH_PROXY_URL != ''", upload.condition)
        assertTrue(upload.environment.values.none { "secrets." in it })
        assertEquals(
            "-Djdk.httpclient.redirects.retrylimit=1",
            upload.environment["JAVA_TOOL_OPTIONS"],
        )
        assertContains(requireNotNull(upload.run), "publishViaAuthProxy")
        assertContains(requireNotNull(upload.run), "--no-daemon --no-configuration-cache")
    }

    @Test
    fun `publishing attests every released artifact before exposing signing secrets`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        assertPublishingProvenancePolicy(workflow)
    }

    @Test
    fun `publishing rejects missing or late prepublication digest verification`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val verification =
            "          sha256sum --check \"\$RUNNER_TEMP/maven-artifact-provenance.sha256\"\n"

        listOf(
                workflow.replaceFirst(verification, ""),
                workflow.replaceFirst(
                    verification,
                    "          ./gradlew \"\${publish_tasks[@]}\"\n$verification",
                ),
            )
            .forEach { poisonedWorkflow ->
                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> {
                    assertPublishingProvenancePolicy(poisonedWorkflow)
                }
            }
    }

    @Test
    fun `publishing rejects missing or misdirected attested jar producer exclusions`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val producer = "          publish_exclusions+=(\"--exclude-task\" \":\$artifact:jar\")"
        val invocation = "            \"\${publish_exclusions[@]}\""

        listOf(
                workflow.replaceFirst(producer, ""),
                workflow.replaceFirst(producer, producer.replace(":jar", ":sourcesJar")),
                workflow.replaceFirst(producer, producer.replace("\$artifact", "openai-java")),
                workflow.replaceFirst(invocation, "            --no-daemon"),
            )
            .forEach { poisonedWorkflow ->
                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> {
                    assertPublishingProvenancePolicy(poisonedWorkflow)
                }
            }
    }

    @Test
    fun `tampered provenance subjects abort before irreversible Maven publication`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val parsedWorkflow = parseWorkflow(workflow)
        val artifacts = parsedWorkflow.environment.getValue("MAVEN_ARTIFACTS").split(" ")
        val publishScript =
            requireNotNull(
                parsedWorkflow
                    .job("publish")
                    .steps
                    .single { it.name == "Publish to Maven Central" }
                    .run
            )
        val guardedPublication = publishScript.substringAfter("export GPG_SIGNING_KEY_ID\n")
        val runnerTemp = temporaryDirectory.resolve("runner").also(Files::createDirectories)
        val subjects =
            artifacts.map { artifact ->
                temporaryDirectory.resolve("$artifact/build/libs/$artifact-test.jar").apply {
                    Files.createDirectories(parent)
                    writeText("attested-$artifact")
                }
            }
        val manifest = runnerTemp.resolve("maven-artifact-provenance.sha256")
        val digest =
            ProcessBuilder(
                    listOf("sha256sum") +
                        subjects.map { temporaryDirectory.relativize(it).toString() }
                )
                .directory(temporaryDirectory.toFile())
                .redirectOutput(manifest.toFile())
                .start()
        assertEquals(0, digest.waitFor())

        val wrapper = temporaryDirectory.resolve("gradlew")
        wrapper.writeText(
            listOf(
                    "#!/usr/bin/env bash",
                    "set -euo pipefail",
                    "touch \"\$RUNNER_TEMP/publication-started\"",
                    "printf '%s\\n' \"\$@\" > \"\$RUNNER_TEMP/publication-arguments\"",
                    "exclusions=' '",
                    "while [[ \$# -gt 0 ]]; do",
                    "  if [[ \$1 == --exclude-task ]]; then",
                    "    exclusions=\"\$exclusions\$2 \"",
                    "    shift 2",
                    "  else",
                    "    shift",
                    "  fi",
                    "done",
                    "for artifact in \$MAVEN_ARTIFACTS; do",
                    "  if [[ \"\$exclusions\" != *\" :\$artifact:jar \"* ]]; then",
                    "    printf 'regenerated' > \"\$artifact/build/libs/\$artifact-test.jar\"",
                    "  fi",
                    "done",
                )
                .joinToString("\n", postfix = "\n")
        )
        assertTrue(wrapper.toFile().setExecutable(true, true))

        fun publish(): Pair<Int, String> {
            val process =
                ProcessBuilder("bash", "-euo", "pipefail", "-c", guardedPublication)
                    .directory(temporaryDirectory.toFile())
                    .redirectErrorStream(true)
                    .apply {
                        environment()["RUNNER_TEMP"] = runnerTemp.toString()
                        environment()["MAVEN_ARTIFACTS"] = artifacts.joinToString(" ")
                    }
                    .start()
            val output = process.inputStream.bufferedReader().readText()
            return process.waitFor() to output
        }

        val altered = subjects[1]
        val original = altered.readText()
        altered.writeText("tampered-after-attestation")
        val rejected = publish()
        assertTrue(rejected.first != 0, rejected.second)
        assertFalse(
            Files.exists(runnerTemp.resolve("publication-started")),
            "Tampered artifacts must never reach the irreversible publication invocation.",
        )

        altered.writeText(original)
        val accepted = publish()
        assertEquals(0, accepted.first, accepted.second)
        assertTrue(Files.exists(runnerTemp.resolve("publication-started")))
        subjects.forEachIndexed { index, subject ->
            assertEquals("attested-" + artifacts[index], subject.readText())
        }
        val arguments = runnerTemp.resolve("publication-arguments").readText().lines()
        artifacts.forEach { artifact ->
            val index = arguments.indexOf(":$artifact:jar")
            assertTrue(index > 0 && arguments[index - 1] == "--exclude-task")
        }
    }

    @Test
    fun `retry provenance records historical release source beside canonical workflow source`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val parsedWorkflow = parseWorkflow(workflow)
        val preparation =
            requireNotNull(
                parsedWorkflow.job("publish").steps.single { it.id == "maven-artifacts" }.run
            )
        val artifacts = parsedWorkflow.environment.getValue("MAVEN_ARTIFACTS").split(" ")
        val checkout = temporaryDirectory.resolve("checkout").also(Files::createDirectories)

        fun git(vararg arguments: String): String {
            val process =
                ProcessBuilder(listOf("git", "-C", checkout.toString()) + arguments)
                    .redirectErrorStream(true)
                    .start()
            val output = process.inputStream.bufferedReader().readText()
            assertEquals(0, process.waitFor(), output)
            return output.trim()
        }

        git("init", "--quiet", "--initial-branch=main")
        git("config", "user.name", "Release provenance fixture")
        git("config", "user.email", "release-fixture@example.invalid")
        val tracked = checkout.resolve("tracked.txt")
        tracked.writeText("historical release")
        git("add", "tracked.txt")
        git("commit", "--quiet", "-m", "historical release")
        val sourceSha = git("rev-parse", "HEAD")
        git("tag", "v1.2.3")
        tracked.writeText("newer main")
        git("add", "tracked.txt")
        git("commit", "--quiet", "-m", "advance main")
        val workflowSha = git("rev-parse", "HEAD")
        assertTrue(sourceSha != workflowSha)
        git("checkout", "--quiet", sourceSha)

        val runnerTemp = temporaryDirectory.resolve("runner").also(Files::createDirectories)
        val wrapper = checkout.resolve("gradlew")
        wrapper.writeText(
            listOf(
                    "#!/usr/bin/env bash",
                    "set -euo pipefail",
                    "touch \"\$RUNNER_TEMP/build-started\"",
                    "for task in \"\$@\"; do",
                    "  if [[ \"\$task\" == :*:jar ]]; then",
                    "    artifact=\"\${task#:}\"",
                    "    artifact=\"\${artifact%:jar}\"",
                    "    mkdir -p \"\$artifact/build/libs\"",
                    "    printf 'attested-%s' \"\$artifact\" > \"\$artifact/build/libs/\$artifact-1.2.3.jar\"",
                    "  fi",
                    "done",
                )
                .joinToString("\n", postfix = "\n")
        )
        assertTrue(wrapper.toFile().setExecutable(true, true))

        fun prepare(source: String, tag: String): Pair<Int, String> {
            val process =
                ProcessBuilder("bash", "-euo", "pipefail", "-c", preparation)
                    .directory(checkout.toFile())
                    .redirectErrorStream(true)
                    .apply {
                        val values = environment()
                        values["MAVEN_ARTIFACTS"] = artifacts.joinToString(" ")
                        values["RELEASE_TAG"] = tag
                        values["SOURCE_SHA"] = source
                        values["RUNNER_TEMP"] = runnerTemp.toString()
                        values["GITHUB_OUTPUT"] = runnerTemp.resolve("step-output").toString()
                        values["GITHUB_SERVER_URL"] = "https://github.com"
                        values["GITHUB_REPOSITORY"] = "openai/openai-java"
                        values["GITHUB_REPOSITORY_ID"] = "100"
                        values["GITHUB_REPOSITORY_OWNER_ID"] = "200"
                        values["GITHUB_REF"] = "refs/heads/main"
                        values["GITHUB_SHA"] = workflowSha
                        values["GITHUB_WORKFLOW_REF"] =
                            "openai/openai-java/.github/workflows/create-releases.yml@refs/heads/main"
                        values["GITHUB_EVENT_NAME"] = "workflow_dispatch"
                        values["GITHUB_RUN_ID"] = "12345"
                        values["GITHUB_RUN_ATTEMPT"] = "2"
                        values["RUNNER_ENVIRONMENT"] = "github-hosted"
                    }
                    .start()
            val output = process.inputStream.bufferedReader().readText()
            return process.waitFor() to output
        }

        val accepted = prepare(sourceSha, "v1.2.3")
        assertEquals(0, accepted.first, accepted.second)
        val predicate =
            Yaml(SafeConstructor(LoaderOptions()))
                .load<Map<*, *>>(runnerTemp.resolve("maven-release-provenance.json").readText())
        val definition = predicate["buildDefinition"] as Map<*, *>
        assertEquals("https://actions.github.io/buildtypes/workflow/v1", definition["buildType"])
        val external = definition["externalParameters"] as Map<*, *>
        val workflowSource = external["workflow"] as Map<*, *>
        assertEquals("refs/heads/main", workflowSource["ref"])
        assertEquals(".github/workflows/create-releases.yml", workflowSource["path"])
        val dependencies = definition["resolvedDependencies"] as List<*>
        assertEquals(2, dependencies.size)
        val workflowDependency = dependencies[0] as Map<*, *>
        assertEquals(
            "git+https://github.com/openai/openai-java@refs/heads/main",
            workflowDependency["uri"],
        )
        val workflowDigest = workflowDependency["digest"] as Map<*, *>
        assertEquals(workflowSha, workflowDigest["gitCommit"])
        val releaseDependency = dependencies[1] as Map<*, *>
        assertEquals(
            "git+https://github.com/openai/openai-java@refs/tags/v1.2.3",
            releaseDependency["uri"],
        )
        val releaseDigest = releaseDependency["digest"] as Map<*, *>
        assertEquals(sourceSha, releaseDigest["gitCommit"])
        assertTrue(releaseDigest["gitCommit"] != workflowSha)
        val details = predicate["runDetails"] as Map<*, *>
        val builder = details["builder"] as Map<*, *>
        assertEquals(
            "https://github.com/openai/openai-java/.github/workflows/create-releases.yml@refs/heads/main",
            builder["id"],
        )

        listOf(
                workflowSha to "v1.2.3",
                "invalid-source" to "v1.2.3",
                sourceSha to "v1.2.3;touch-injected",
            )
            .forEach { (source, tag) ->
                Files.deleteIfExists(runnerTemp.resolve("build-started"))
                val rejected = prepare(source, tag)
                assertTrue(rejected.first != 0, rejected.second)
                assertFalse(
                    Files.exists(runnerTemp.resolve("build-started")),
                    "Invalid source or tag must fail before artifact creation.",
                )
            }
    }

    @Test
    fun `publishing rejects run-SHA provenance and unreviewed custom predicate inputs`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val source = "          SOURCE_SHA: \${{ needs.release.outputs.source_sha }}"
        val argument = "            --arg source_sha \"\$SOURCE_SHA\""
        val checkout = "\"\$SOURCE_SHA\" != \"\$(git rev-parse HEAD)\""
        val predicateType = "          predicate-type: https://slsa.dev/provenance/v1"
        val predicatePath =
            "          predicate-path: \${{ steps.maven-artifacts.outputs.predicate_path }}"

        listOf(
                workflow.replaceFirst(source, "          SOURCE_SHA: \${{ github.sha }}"),
                workflow.replaceFirst(argument, argument.replace("\$SOURCE_SHA", "\$GITHUB_SHA")),
                workflow.replaceFirst(checkout, checkout.replace("HEAD", "refs/heads/main")),
                workflow.replaceFirst(
                    predicateType,
                    predicateType.replace("slsa.dev", "example.invalid"),
                ),
                workflow.replaceFirst(predicatePath, ""),
                workflow.replaceFirst(predicatePath, "$predicatePath\n          predicate: '{}'"),
            )
            .forEach { poisonedWorkflow ->
                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> { assertPublishingCachePolicy(poisonedWorkflow) }
            }
    }

    @Test
    fun `publishing rejects missing or excessive attestation permissions`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val permissions =
            "    permissions:\n" +
                "      contents: read\n" +
                "      id-token: write\n" +
                "      attestations: write\n"

        listOf(
                permissions.replace("      id-token: write\n", ""),
                permissions.replace("      attestations: write\n", ""),
                permissions.replace("      contents: read\n", "      contents: write\n"),
                permissions + "      actions: write\n",
            )
            .forEach { unsafePermissions ->
                val poisonedWorkflow = workflow.replaceFirst(permissions, unsafePermissions)

                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> {
                    assertPublishingProvenancePolicy(poisonedWorkflow)
                }
            }
    }

    @Test
    fun `publishing rejects unreviewed provenance subjects action inputs and revisions`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val subject = "          subject-path: \${{ steps.maven-artifacts.outputs.subject_paths }}"

        listOf(
                workflow.replaceFirst(subject, "          subject-path: '**/*.jar'"),
                workflow.replaceFirst(
                    subject,
                    "$subject\n          github-token: \${{ secrets.GITHUB_TOKEN }}",
                ),
                workflow.replaceFirst(
                    "actions/attest@1e69f48acb82d1966a394da916b4c1698aa569d6",
                    "actions/attest@v4",
                ),
            )
            .forEach { poisonedWorkflow ->
                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> { assertPublishingCachePolicy(poisonedWorkflow) }
            }
    }

    @Test
    fun `publishing rejects provenance generation after signing secrets are exposed`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val attestationStart = workflow.indexOf("      - name: Attest Maven artifact provenance\n")
        val signingStart = workflow.indexOf("      - name: Publish to Maven Central\n")
        val attestation = workflow.substring(attestationStart, signingStart)
        val verification = "      - name: Verify attested Maven artifacts\n"
        val poisonedWorkflow =
            workflow
                .removeRange(attestationStart, signingStart)
                .replaceFirst(verification, "$attestation$verification")

        assertTrue(poisonedWorkflow != workflow)
        assertFailsWith<AssertionError> { assertPublishingProvenancePolicy(poisonedWorkflow) }
    }

    @Test
    fun `published Maven artifact provenance verification is documented`() {
        val securityModel = Path.of("../docs/architecture/security-model.md").readText()

        assertContains(securityModel, "### Maven artifact provenance")
        assertContains(
            securityModel,
            "gh attestation verify path/to/openai-java-VERSION.jar -R openai/openai-java",
        )
        assertContains(securityModel, "not exposed to the attestation action")
    }

    @Test
    fun `publishing rejects untrusted pull request and completion triggers`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()

        listOf(
                "  pull_request:\n    branches: [main]\n",
                "  pull_request_target:\n    branches: [main]\n",
                "  workflow_run:\n    workflows: [CI]\n    types: [completed]\n",
            )
            .forEach { untrustedTrigger ->
                val poisonedWorkflow = workflow.replaceFirst("on:\n", "on:\n$untrustedTrigger")

                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> { assertPublishingCachePolicy(poisonedWorkflow) }
            }
    }

    @Test
    fun `documented cache trust boundary is enforced outside pull request code`() {
        val securityModel = Path.of("../docs/architecture/security-model.md").readText()

        assertContains(securityModel, "`refs/pull/<number>/merge`")
        assertContains(securityModel, "cannot write to the default-branch cache scope")
        assertContains(securityModel, "not a security boundary")
        assertContains(securityModel, "base branch's CODEOWNERS")
        assertContains(
            securityModel,
            "https://docs.github.com/en/actions/reference/workflows-and-actions/dependency-caching",
        )
    }

    @Test
    fun `publishing rejects the complete GitHub cache action family`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val compilationStep = "      - name: Compile the openai-java-core project\n"

        listOf(
                "actions/cache",
                "actions/cache/restore",
                "actions/cache/save",
                "Actions/CACHE/restore",
            )
            .forEach { action ->
                val poisonedWorkflow =
                    workflow.replaceFirst(
                        compilationStep,
                        "      - name: Restore untrusted cross-run cache\n" +
                            "        uses: $action@0123456789abcdef0123456789abcdef01234567\n" +
                            "        with:\n" +
                            "          path: \${{ env.GRADLE_USER_HOME }}\n" +
                            "          key: untrusted\n\n" +
                            compilationStep,
                    )

                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> { assertPublishingCachePolicy(poisonedWorkflow) }
            }
    }

    @Test
    fun `publishing rejects case-insensitive duplicate cache disable inputs`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()

        listOf("CACHE-DISABLED", "\"CACHE-\\u0044ISABLED\"").forEach { disabledInput ->
            val poisonedWorkflow =
                workflow.replaceFirst(
                    "          cache-disabled: true",
                    "          cache-disabled: true\n" +
                        "          $disabledInput: false\n" +
                        "          gradle-home-cache-includes: init.d",
                )

            assertTrue(poisonedWorkflow != workflow)
            assertFailsWith<AssertionError> { assertPublishingCachePolicy(poisonedWorkflow) }
        }

        assertPublishingCachePolicy(
            workflow.replaceFirst(
                "          cache-disabled: true",
                "          CACHE-DISABLED: true",
            )
        )
    }

    @Test
    fun `publishing rejects legacy Gradle setup before the protected initializer`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val protectedSetup = "      - name: Set up Gradle\n"
        val actionRevision = "12318b01111bfa6462c00534ffa998f8b397b979"

        listOf(
                "gradle/gradle-build-action@$actionRevision",
                "GRADLE/Gradle-Build-Action@$actionRevision",
                "\"gradle/gradle-\\u0062uild-action@$actionRevision\"",
            )
            .forEach { action ->
                val poisonedWorkflow =
                    workflow.replaceFirst(
                        protectedSetup,
                        "      - name: Restore legacy Gradle cache\n" +
                            "        uses: $action\n" +
                            "        with:\n" +
                            "          gradle-home-cache-includes: init.d\n\n" +
                            protectedSetup,
                    )

                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> { assertPublishingCachePolicy(poisonedWorkflow) }
            }
    }

    @Test
    fun `publishing rejects Gradle-owned initializers before and after protected setup`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val protectedSetup = "      - name: Set up Gradle\n"
        val compilationStep = "      - name: Compile the openai-java-core project\n"
        val actionRevision = "0723195856401067f7a2779048b490ace7a47d7c"

        listOf(protectedSetup, compilationStep).forEach { followingStep ->
            listOf(
                    "gradle/actions/dependency-submission@$actionRevision",
                    "GRADLE/Actions/Dependency-Submission@$actionRevision",
                    "\"gradle/actions/dependency-\\u0073ubmission@$actionRevision\"",
                    "gradle/actions/future-initializer@$actionRevision",
                    "gradle/future-gradle-action@$actionRevision",
                )
                .forEach { action ->
                    val poisonedWorkflow =
                        workflow.replaceFirst(
                            followingStep,
                            "      - name: Restore delegated Gradle cache\n" +
                                "        uses: $action\n" +
                                "        with:\n" +
                                "          dependency-graph: download-and-submit\n" +
                                "          dependency-graph-continue-on-failure: true\n" +
                                "          gradle-home-cache-includes: init.d\n\n" +
                                followingStep,
                        )

                    assertTrue(poisonedWorkflow != workflow)
                    assertFailsWith<AssertionError> {
                        assertPublishingCachePolicy(poisonedWorkflow)
                    }
                }
        }
    }

    @Test
    fun `publishing rejects unreviewed action capabilities and cache-enabled inputs`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val protectedSetup = "      - name: Set up Gradle\n"
        val javaSetup = "          distribution: temurin\n          java-version: |\n"

        listOf(
                workflow.replaceFirst(
                    protectedSetup,
                    "      - name: Initialize third-party Gradle cache\n" +
                        "        uses: third-party/gradle-cache@0123456789abcdef0123456789abcdef01234567\n" +
                        "        with:\n" +
                        "          cache: gradle\n\n" +
                        protectedSetup,
                ),
                workflow.replaceFirst(javaSetup, "          cache: gradle\n$javaSetup"),
                workflow.replaceFirst(
                    Regex("gradle/actions/setup-gradle@[0-9a-fA-F]{40}"),
                    "gradle/actions/setup-gradle@v6",
                ),
            )
            .forEach { poisonedWorkflow ->
                assertTrue(poisonedWorkflow != workflow)
                assertFailsWith<AssertionError> { assertPublishingCachePolicy(poisonedWorkflow) }
            }
    }

    @Test
    fun `publishing decodes YAML-escaped cache action references`() {
        val workflow = Path.of("../.github/workflows/create-releases.yml").readText()
        val compilationStep = "      - name: Compile the openai-java-core project\n"
        val poisonedWorkflow =
            workflow.replaceFirst(
                compilationStep,
                "      - name: Restore escaped attacker-controlled Gradle home\n" +
                    "        uses: \"actions/\\u0063ache/restore@0057852bfaa89a56745cba8c7296529d2fc39830\"\n" +
                    "        with:\n" +
                    "          path: \${{ env.GRADLE_USER_HOME }}\n" +
                    "          key: attacker-controlled-gradle-home\n\n" +
                    compilationStep,
            )

        assertTrue(poisonedWorkflow != workflow)
        assertFailsWith<AssertionError> { assertPublishingCachePolicy(poisonedWorkflow) }
    }

    private fun assertPullRequestCachePolicy(workflow: String) {
        val parsedWorkflow = parseWorkflow(workflow)
        assertTrue(
            "pull_request" in parsedWorkflow.events,
            "Untrusted CI must use GitHub's server-enforced pull-request cache scope.",
        )
        assertTrue(
            parsedWorkflow.events.all {
                it in setOf("push", "pull_request", "merge_group", "workflow_dispatch")
            },
            "Untrusted CI must not run in a default-branch-context event such as pull_request_target.",
        )
        val setupActions =
            parsedWorkflow.jobs.values.flatMap { job ->
                val initializers = job.actions.filter { it.initializesGradle }

                if (initializers.isNotEmpty()) {
                    assertEquals(
                        "gradle/actions/setup-gradle",
                        initializers.first().repository,
                        "The first Gradle initializer in job ${job.name} must enforce cache policy.",
                    )
                    assertTrue(
                        initializers.all { it.repository == "gradle/actions/setup-gradle" },
                        "Job ${job.name} must not use delegated Gradle setup aliases.",
                    )
                }

                initializers
            }

        assertTrue(setupActions.isNotEmpty(), "The CI workflow must continue to exercise Gradle.")
        setupActions.forEach { action ->
            val readOnly = action.inputs["cache-read-only"]
            val writeOnly = action.inputs["cache-write-only"]
            val trustedReadOnly =
                readOnly == "true" ||
                    readOnly == "\${{ github.ref_name != github.event.repository.default_branch }}"
            val effectivelyReadOnly =
                trustedReadOnly &&
                    (writeOnly == null || writeOnly.equals("false", ignoreCase = true))

            assertTrue(
                effectivelyReadOnly,
                "Gradle cache for job ${action.job} must remain effectively read-only on pull requests and merge groups.",
            )
        }

        val compilationCacheActions =
            parsedWorkflow.jobs.values.flatMap { job ->
                job.steps.filter { step ->
                    step.action?.repository == "actions/cache" ||
                        step.action?.repository?.startsWith("actions/cache/") == true
                }
            }
        assertEquals(
            2,
            compilationCacheActions.size,
            "Only the SDK build owns compilation caching.",
        )
        val restore = compilationCacheActions[0]
        val save = compilationCacheActions[1]
        assertEquals("build", restore.action?.job)
        assertEquals("build", save.action?.job)
        assertEquals("actions/cache/restore", restore.action?.repository)
        assertEquals("actions/cache/save", save.action?.repository)
        for (step in compilationCacheActions) {
            assertTrue(
                step.action!!.reference.substringAfter('@').matches(Regex("[0-9a-fA-F]{40}"))
            )
            assertEquals("~/.gradle/caches/build-cache-1", step.action.inputs["path"])
        }
        assertEquals(
            "java-sdk-compile-v1-\${{ runner.os }}-\${{ runner.arch }}-\${{ github.sha }}",
            restore.action?.inputs?.get("key"),
            "Each successful main revision must be able to refresh the compilation cache.",
        )
        assertEquals(
            "java-sdk-compile-v1-\${{ runner.os }}-\${{ runner.arch }}-",
            restore.action?.inputs?.get("restore-keys"),
        )
        assertEquals(
            "\${{ steps.sdk-compilation-cache.outputs.cache-primary-key }}",
            save.action?.inputs?.get("key"),
        )
        assertEquals(
            "github.event_name == 'push' && " +
                "github.ref_name == github.event.repository.default_branch && " +
                "steps.sdk-compilation-cache.outputs.cache-hit != 'true'",
            save.condition?.trim(),
            "PRs, merge groups and workflow dispatch must never publish compilation cache entries.",
        )
        val buildSteps = parsedWorkflow.job("build").steps
        val buildIndex = buildSteps.indexOfFirst { it.name == "Build SDK" }
        assertTrue(buildSteps.indexOf(restore) < buildIndex)
        assertTrue(buildSteps.indexOf(save) > buildIndex)
    }

    private fun assertPublishingCachePolicy(workflow: String) {
        val parsedWorkflow = parseWorkflow(workflow)
        assertTrue(
            parsedWorkflow.events.all { it in setOf("push", "schedule", "workflow_dispatch") },
            "Privileged publishing must accept only trusted default-branch events.",
        )
        val publishJob = parsedWorkflow.job("publish")
        val reviewedActionInputs =
            mapOf(
                "actions/checkout" to setOf("persist-credentials", "ref"),
                "actions/setup-java" to setOf("distribution", "java-version"),
                "gradle/actions/setup-gradle" to setOf("cache-disabled", "cache-provider"),
                "graalvm/setup-graalvm" to setOf("distribution", "java-version"),
                "actions/attest" to setOf("subject-path", "predicate-type", "predicate-path"),
                "azure/login" to setOf("client-id", "tenant-id", "allow-no-subscriptions"),
            )

        publishJob.actions.forEach { action ->
            val approvedInputs = reviewedActionInputs[action.repository]

            assertTrue(
                approvedInputs != null,
                "Privileged publishing must reject unreviewed action ${action.repository}.",
            )
            assertTrue(
                action.reference.substringAfterLast('@', "").matches(Regex("[0-9a-fA-F]{40}")),
                "Privileged publishing action ${action.repository} must remain SHA-pinned.",
            )
            assertTrue(
                action.inputs.keys.all { it in approvedInputs },
                "Privileged publishing action ${action.repository} has unreviewed inputs.",
            )
        }

        val workflowCheckout =
            publishJob.steps.indexOfFirst { it.name == "Check out workflow scripts" }
        val preserveHelper =
            publishJob.steps.indexOfFirst {
                it.name == "Preserve GraalVM test script for older release retries"
            }
        val releaseCheckout =
            publishJob.steps.indexOfFirst {
                it.action?.repository == "actions/checkout" &&
                    it.action.inputs["ref"] == "\${{ needs.release.outputs.source_sha }}"
            }
        assertTrue(
            workflowCheckout >= 0 &&
                preserveHelper > workflowCheckout &&
                releaseCheckout > preserveHelper,
            "Copy the helper from the pinned workflow before checking out the verified release.",
        )
        assertEquals(
            mapOf("persist-credentials" to "false", "ref" to "\${{ github.workflow_sha }}"),
            requireNotNull(publishJob.steps[workflowCheckout].action).inputs,
        )
        assertEquals(
            mapOf(
                "persist-credentials" to "false",
                "ref" to "\${{ needs.release.outputs.source_sha }}",
            ),
            requireNotNull(publishJob.steps[releaseCheckout].action).inputs,
        )
        assertEquals(
            "install -m 700 .github/scripts/run-graalvm-tests.sh " +
                "\"\$RUNNER_TEMP/run-graalvm-tests.sh\"",
            publishJob.steps[preserveHelper].run,
        )

        val isolation =
            publishJob.steps.indexOfFirst { it.name == "Create isolated release Gradle User Home" }
        val initializers =
            publishJob.steps.mapIndexedNotNull { index, step ->
                if (step.action?.initializesGradle == true) index to step else null
            }
        val signing = publishJob.steps.indexOfFirst { "GPG_SIGNING_KEY" in it.environment }

        assertTrue(isolation >= 0, "Create a fresh Gradle User Home before configuring Gradle.")
        assertEquals(
            1,
            initializers.size,
            "Privileged publishing must have exactly one protected Gradle initializer.",
        )
        val (setup, setupStep) = initializers.single()
        val setupAction = requireNotNull(setupStep.action)
        assertEquals(
            "gradle/actions/setup-gradle",
            setupAction.repository,
            "The first effective release Gradle initializer must be the protected setup action.",
        )
        assertTrue(setup > isolation, "Set up Gradle only after the isolated home exists.")
        assertTrue(signing > setup, "Configure isolated Gradle before exposing signing secrets.")
        val isolationStep = publishJob.steps[isolation]
        assertContains(
            isolationStep.environment.getValue("TRUSTED_GRADLE_USER_HOME"),
            "trusted-release-gradle-\${{ github.run_id }}-\${{ github.run_attempt }}",
        )
        val isolationScript = requireNotNull(isolationStep.run)
        assertContains(
            isolationScript,
            "[[ -e \"\$TRUSTED_GRADLE_USER_HOME\" || -L \"\$TRUSTED_GRADLE_USER_HOME\" ]]",
        )
        assertContains(isolationScript, "mkdir -m 700 \"\$TRUSTED_GRADLE_USER_HOME\"")
        assertContains(isolationScript, "\"\$TRUSTED_GRADLE_USER_HOME\" >> \"\$GITHUB_ENV\"")

        assertEquals("true", setupAction.inputs["cache-disabled"])
        assertFalse(
            publishJob.actions.any {
                it.repository == "actions/download-artifact" ||
                    it.repository == "actions/cache" ||
                    it.repository.startsWith("actions/cache/")
            },
            "Privileged publishing must reject every cross-run artifact and GitHub cache action.",
        )

        assertPublishingProvenancePolicy(workflow)
    }

    private fun assertPublishingRunnerStabilityPolicy(workflow: String) {
        val publishSteps = parseWorkflow(workflow).job("publish").steps
        val compilation =
            publishSteps.indexOfFirst { it.name == "Compile the openai-java-core project" }
        val daemonStop = publishSteps.indexOfFirst { it.name == "Stop pre-GraalVM Gradle daemon" }
        val graalVm = publishSteps.indexOfFirst { it.name == "Set up GraalVM" }

        assertTrue(
            compilation >= 0 && daemonStop > compilation && graalVm > daemonStop,
            "Stop the build-JDK Gradle daemon before switching to GraalVM.",
        )
        assertEquals("./gradlew --stop", publishSteps[daemonStop].run)

        val publication =
            requireNotNull(publishSteps.single { it.name == "Publish to Maven Central" }.run)
        val serializedInvocation =
            "./gradlew \"\${publish_tasks[@]}\" \\\n" +
                "  \"\${publish_exclusions[@]}\" \\\n" +
                "  --stacktrace \\\n" +
                "  --no-parallel \\\n" +
                "  --no-configuration-cache"
        assertTrue(
            publication.contains(serializedInvocation),
            "Serialize Dokka publication tasks to keep the standard runner within memory limits.",
        )
    }

    private fun assertPublishingProvenancePolicy(workflow: String) {
        val parsedWorkflow = parseWorkflow(workflow)
        val publishJob = parsedWorkflow.job("publish")

        assertEquals(
            mapOf("contents" to "read", "id-token" to "write", "attestations" to "write"),
            publishJob.permissions,
            "Publishing must have only the GitHub permissions required to attest release artifacts.",
        )
        assertEquals(
            listOf(
                "openai-java",
                "openai-java-core",
                "openai-java-client-okhttp",
                "openai-java-bedrock",
            ),
            parsedWorkflow.environment.getValue("MAVEN_ARTIFACTS").split(" "),
            "Every published Maven artifact must receive a provenance attestation.",
        )

        val preparation = publishJob.steps.single { it.id == "maven-artifacts" }
        val preparationIndex = publishJob.steps.indexOf(preparation)
        val preparationScript = requireNotNull(preparation.run)
        val attestation = publishJob.steps.single { it.action?.repository == "actions/attest" }
        val attestationIndex = publishJob.steps.indexOf(attestation)
        val signingIndex = publishJob.steps.indexOfFirst { "GPG_SIGNING_KEY" in it.environment }
        val verificationIndex =
            publishJob.steps.indexOfFirst { it.name == "Verify attested Maven artifacts" }

        assertEquals(
            "\${{ needs.release.outputs.release_tag }}",
            preparation.environment.getValue("RELEASE_TAG"),
        )
        assertEquals(
            "\${{ needs.release.outputs.source_sha }}",
            preparation.environment.getValue("SOURCE_SHA"),
        )
        assertContains(preparationScript, "\"\$SOURCE_SHA\" != \"\$(git rev-parse HEAD)\"")
        assertContains(preparationScript, "--arg workflow_sha \"\$GITHUB_SHA\"")
        assertContains(preparationScript, "--arg source_sha \"\$SOURCE_SHA\"")
        assertContains(preparationScript, "--arg workflow_ref \"\$GITHUB_REF\"")
        assertContains(preparationScript, "uri: (\"git+\" + \$repository + \"@\" + \$workflow_ref)")
        assertContains(preparationScript, "digest: { gitCommit: \$workflow_sha }")
        assertContains(
            preparationScript,
            "uri: (\"git+\" + \$repository + \"@refs/tags/\" + \$release_tag)",
        )
        assertContains(preparationScript, "digest: { gitCommit: \$source_sha }")
        assertContains(preparationScript, "builder: { id: \$workflow_identity }")
        assertContains(
            preparationScript,
            "predicate_path=\$RUNNER_TEMP/maven-release-provenance.json",
        )
        assertContains(preparationScript, "for artifact in \$MAVEN_ARTIFACTS; do")
        assertContains(preparationScript, "tasks+=(\":\$artifact:jar\")")
        assertContains(
            preparationScript,
            "subjects+=(\"\$artifact/build/libs/\$artifact-\$version.jar\")",
        )
        assertContains(preparationScript, "./gradlew \"\${tasks[@]}\" --no-configuration-cache")
        assertContains(preparationScript, "[[ ! -f \"\$subject\" || -L \"\$subject\" ]]")
        assertContains(
            preparationScript,
            "sha256sum \"\${subjects[@]}\" > \"\$RUNNER_TEMP/maven-artifact-provenance.sha256\"",
        )
        assertEquals(
            mapOf(
                "subject-path" to "\${{ steps.maven-artifacts.outputs.subject_paths }}",
                "predicate-type" to "https://slsa.dev/provenance/v1",
                "predicate-path" to "\${{ steps.maven-artifacts.outputs.predicate_path }}",
            ),
            requireNotNull(attestation.action).inputs,
        )
        assertTrue(
            attestation.environment.isEmpty(),
            "The provenance action must not receive Maven publishing or PGP credentials.",
        )
        assertTrue(preparationIndex < attestationIndex, "Build Maven artifacts before attesting.")
        assertTrue(signingIndex > attestationIndex, "Attest artifacts before exposing PGP secrets.")
        val publicationScript = requireNotNull(publishJob.steps[signingIndex].run)
        val verification = "sha256sum --check \"\$RUNNER_TEMP/maven-artifact-provenance.sha256\""
        val verificationStart = publicationScript.indexOf(verification)
        val publicationStart = publicationScript.indexOf("./gradlew \"\${publish_tasks[@]}\"")
        assertTrue(
            verificationStart >= 0 && publicationStart > verificationStart,
            "Verify attested artifact digests before irreversible Maven Central publication.",
        )
        assertTrue(
            publicationScript
                .substring(verificationStart + verification.length, publicationStart)
                .isBlank(),
            "Verify attested artifact digests immediately before the publishing invocation.",
        )

        val exclusionsStart = publicationScript.indexOf("publish_exclusions=()")
        val artifactLoop =
            publicationScript.indexOf("for artifact in \$MAVEN_ARTIFACTS; do", exclusionsStart)
        val producerExclusion =
            publicationScript.indexOf(
                "publish_exclusions+=(\"--exclude-task\" \":\$artifact:jar\")",
                artifactLoop,
            )
        assertTrue(
            exclusionsStart >= 0 &&
                artifactLoop > exclusionsStart &&
                producerExclusion > artifactLoop &&
                verificationStart > producerExclusion,
            "Exclude the exact JAR producer for every attested Maven artifact before publishing.",
        )
        assertTrue(
            publicationScript.substring(publicationStart).contains("\"\${publish_exclusions[@]}\""),
            "The publishing invocation must receive every attested JAR producer exclusion.",
        )

        assertTrue(
            verificationIndex > signingIndex,
            "Verify attested artifact digests after the publishing Gradle invocation.",
        )
        assertEquals(
            "sha256sum --check \"\$RUNNER_TEMP/maven-artifact-provenance.sha256\"",
            publishJob.steps[verificationIndex].run,
        )
    }

    private fun artifactRestoreActions(workflow: String): List<WorkflowAction> =
        parseWorkflow(workflow)
            .jobs
            .values
            .flatMap { it.actions }
            .filter { it.repository == "actions/download-artifact" }

    private fun parseWorkflow(workflow: String): Workflow {
        val options = LoaderOptions().apply { setAllowDuplicateKeys(false) }
        val document =
            Yaml(SafeConstructor(options)).load<Any>(workflow) as? Map<*, *>
                ?: error("A GitHub Actions workflow must be a YAML mapping.")
        val jobs =
            document["jobs"] as? Map<*, *> ?: error("A GitHub Actions workflow must declare jobs.")
        val eventDeclarations = document.entries.filter { (key, _) -> key == "on" || key == true }
        assertEquals(
            1,
            eventDeclarations.size,
            "A GitHub Actions workflow must have exactly one trigger declaration.",
        )
        val events =
            eventDeclarations
                .single()
                .value
                .workflowMapping("workflow events")
                .keys
                .map { it.workflowScalar("workflow event") }
                .toSet()

        return Workflow(
            events,
            document["env"].workflowScalars("workflow environment"),
            jobs.entries.associate { (name, value) ->
                val jobName = name.workflowScalar("job name")
                val job = value.workflowMapping("job $jobName")
                val steps =
                    (job["steps"] as? List<*>)?.map { step ->
                        val fields = step.workflowMapping("step in job $jobName")
                        val action =
                            fields["uses"]?.let { reference ->
                                WorkflowAction(
                                    jobName,
                                    reference.workflowScalar("action reference"),
                                    canonicalActionInputs(fields["with"], jobName),
                                )
                            }

                        WorkflowStep(
                            fields["name"]?.workflowScalar("step name"),
                            fields["id"]?.workflowScalar("step ID"),
                            action,
                            fields["run"]?.workflowScalar("step script"),
                            fields["env"].workflowScalars("step environment"),
                            fields["if"]?.workflowScalar("step condition"),
                        )
                    } ?: emptyList()

                jobName to
                    WorkflowJob(
                        jobName,
                        job["outputs"].workflowScalars("job outputs"),
                        job["permissions"].workflowScalars("job permissions"),
                        job["env"].workflowScalars("job environment"),
                        steps,
                    )
            },
        )
    }

    private fun canonicalActionInputs(value: Any?, job: String): Map<String, String> {
        val inputs = mutableMapOf<String, String>()

        value.workflowScalars("action inputs in job $job").forEach { (name, input) ->
            val canonicalName = name.lowercase(Locale.ROOT)
            assertFalse(
                canonicalName in inputs,
                "Duplicate case-insensitive workflow action input in job $job: $name",
            )
            inputs[canonicalName] = input
        }

        return inputs
    }

    private fun Any?.workflowScalars(description: String): Map<String, String> =
        if (this == null) {
            emptyMap()
        } else {
            workflowMapping(description).entries.associate { (key, value) ->
                key.workflowScalar("$description key") to value.workflowScalar("$description value")
            }
        }

    private fun Any?.workflowMapping(description: String): Map<*, *> =
        this as? Map<*, *> ?: error("$description must be a YAML mapping.")

    private fun Any?.workflowScalar(description: String): String =
        when (this) {
            is String -> this
            is Number,
            is Boolean -> toString()
            else -> error("$description must be a YAML scalar.")
        }

    private data class Workflow(
        val events: Set<String>,
        val environment: Map<String, String>,
        val jobs: Map<String, WorkflowJob>,
    ) {
        fun job(name: String): WorkflowJob =
            jobs[name] ?: error("GitHub Actions workflow is missing job $name.")
    }

    private data class WorkflowJob(
        val name: String,
        val outputs: Map<String, String>,
        val permissions: Map<String, String>,
        val environment: Map<String, String>,
        val steps: List<WorkflowStep>,
    ) {
        val actions: List<WorkflowAction>
            get() = steps.mapNotNull { it.action }
    }

    private data class WorkflowStep(
        val name: String?,
        val id: String?,
        val action: WorkflowAction?,
        val run: String?,
        val environment: Map<String, String>,
        val condition: String?,
    )

    private data class WorkflowAction(
        val job: String,
        val reference: String,
        val inputs: Map<String, String>,
    ) {
        val repository: String = reference.substringBefore('@').lowercase(Locale.ROOT)
        val initializesGradle: Boolean = repository.substringBefore('/') == "gradle"
    }
}
