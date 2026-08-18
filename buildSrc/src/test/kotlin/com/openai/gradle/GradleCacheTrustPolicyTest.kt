package com.openai.gradle

import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.readText
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.jupiter.api.io.TempDir

class GradleCacheTrustPolicyTest {
    @TempDir lateinit var temporaryDirectory: Path

    @Test
    fun `all pull request Gradle jobs keep cross-run caches read-only`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        assertPullRequestCachePolicy(workflow)
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
    fun `exact-run cache artifacts are immutable identified and digest-verified`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        val buildJob = workflow.substringAfter("\n  build:\n").substringBefore("\n  test:\n")

        assertContains(
            buildJob,
            "gradle-cache-artifact-id: \${{ steps.gradle-cache-artifact.outputs.artifact-id }}",
        )
        assertContains(buildJob, "id: gradle-cache-artifact")
        assertContains(
            buildJob,
            "name: ci-gradle-build-cache-\${{ github.run_id }}-\${{ github.run_attempt }}",
        )
        val uploadAction =
            parseWorkflowActions(workflow).single {
                it.job == "build" && it.repository == "actions/upload-artifact"
            }
        assertFalse(
            uploadAction.inputs["overwrite"].equals("true", ignoreCase = true),
            "Cache artifacts must remain immutable.",
        )

        val restoreSteps = artifactRestoreActions(workflow)

        assertEquals(3, restoreSteps.size, "All exact-run cache consumers must remain protected.")
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

        assertEquals(3, restoreSteps.size)
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

    private fun assertPullRequestCachePolicy(workflow: String) {
        val setupActions =
            parseWorkflowActions(workflow).filter { it.repository == "gradle/actions/setup-gradle" }

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
                "Gradle cache for job ${action.job} must remain effectively read-only on pull requests.",
            )
        }
    }

    private fun assertPublishingCachePolicy(workflow: String) {
        val publishJob =
            workflow.substringAfter("\n  publish:\n").substringBefore("\n  release_outcome:\n")
        val isolation = publishJob.indexOf("name: Create isolated release Gradle User Home")
        val setup = publishJob.indexOf("name: Set up Gradle")
        val signing = publishJob.indexOf("GPG_SIGNING_KEY:")

        assertTrue(isolation >= 0, "Create a fresh Gradle User Home before configuring Gradle.")
        assertTrue(setup > isolation, "Set up Gradle only after the isolated home exists.")
        assertTrue(signing > setup, "Configure isolated Gradle before exposing signing secrets.")
        assertContains(
            publishJob,
            "trusted-release-gradle-\${{ github.run_id }}-\${{ github.run_attempt }}",
        )
        assertContains(
            publishJob,
            "[[ -e \"\$TRUSTED_GRADLE_USER_HOME\" || -L \"\$TRUSTED_GRADLE_USER_HOME\" ]]",
        )
        assertContains(publishJob, "mkdir -m 700 \"\$TRUSTED_GRADLE_USER_HOME\"")
        assertContains(publishJob, "\"\$TRUSTED_GRADLE_USER_HOME\" >> \"\$GITHUB_ENV\"")
        val publishActions = parseWorkflowActions(workflow).filter { it.job == "publish" }
        val setupAction = publishActions.single { it.repository == "gradle/actions/setup-gradle" }

        assertEquals("true", setupAction.inputs["cache-disabled"])
        assertFalse(
            publishActions.any {
                it.repository == "actions/download-artifact" ||
                    it.repository == "actions/cache" ||
                    it.repository.startsWith("actions/cache/")
            },
            "Privileged publishing must reject every cross-run artifact and GitHub cache action.",
        )
    }

    private fun artifactRestoreActions(workflow: String): List<WorkflowAction> =
        parseWorkflowActions(workflow).filter { it.repository == "actions/download-artifact" }

    private fun parseWorkflowActions(workflow: String): List<WorkflowAction> {
        val actions = mutableListOf<WorkflowAction>()
        var inJobs = false
        var currentJob: String? = null
        var currentAction: WorkflowActionBuilder? = null
        var inInputs = false

        fun finishStep() {
            currentAction?.let { step ->
                step.reference?.let { reference ->
                    actions += WorkflowAction(step.job, reference, step.inputs.toMap())
                }
            }
            currentAction = null
            inInputs = false
        }

        workflow.lineSequence().forEach { line ->
            val indentation = line.indexOfFirst { !it.isWhitespace() }
            if (indentation < 0) return@forEach

            val content = line.substring(indentation)
            if (content.startsWith("#")) return@forEach

            when {
                indentation == 0 -> {
                    finishStep()
                    inJobs = content == "jobs:"
                    if (!inJobs) currentJob = null
                }

                !inJobs -> Unit

                indentation == 2 && content.endsWith(":") -> {
                    finishStep()
                    currentJob = content.removeSuffix(":")
                }

                indentation == 6 && content.startsWith("- ") -> {
                    finishStep()
                    currentJob?.let { job ->
                        val step = WorkflowActionBuilder(job)
                        val firstField = content.removePrefix("- ")
                        if (firstField.startsWith("uses:")) {
                            step.reference = firstField.workflowValue()
                        }
                        currentAction = step
                    }
                }

                indentation == 8 && currentAction != null -> {
                    inInputs = content == "with:"
                    if (content.startsWith("uses:")) {
                        currentAction?.reference = content.workflowValue()
                    }
                }

                indentation == 10 && inInputs -> {
                    val separator = content.indexOf(':')
                    if (separator >= 0) {
                        val key = content.substring(0, separator)
                        val value = content.substring(separator + 1).trim().unquoted()
                        check(currentAction?.inputs?.put(key, value) == null) {
                            "Duplicate workflow action input: $key"
                        }
                    }
                }
            }
        }

        finishStep()
        return actions
    }

    private fun String.workflowValue(): String =
        substringAfter(':').substringBefore(" #").trim().unquoted()

    private fun String.unquoted(): String = removeSurrounding("\"").removeSurrounding("'")

    private data class WorkflowAction(
        val job: String,
        val reference: String,
        val inputs: Map<String, String>,
    ) {
        val repository: String = reference.substringBefore('@').lowercase()
    }

    private data class WorkflowActionBuilder(
        val job: String,
        var reference: String? = null,
        val inputs: MutableMap<String, String> = mutableMapOf(),
    )
}
