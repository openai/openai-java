package com.openai.gradle

import java.nio.file.Path
import kotlin.io.path.readText
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ApiCompatibilityCachePolicyTest {
    @Test
    fun `compatibility compilation always executes while production caching stays enabled`() {
        val detector = Path.of("../scripts/detect-breaking-changes").readText()

        assertFalse(
            detector.contains("--no-build-cache"),
            "The API compatibility detector must leave the build cache enabled for production compilation.",
        )
        assertContains(detector, "compileExternalApiCompatibilityKotlin")
        assertContains(detector, "compileProposedApiCompatibilityKotlin")
        assertContains(detector, "project.tasks.named(taskName).configure")
        assertContains(detector, "task.outputs.upToDateWhen { false }")
        assertContains(detector, "task.outputs.doNotCacheIf")
    }

    @Test
    fun `tests consume the exact build cache after build succeeds`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        val testJob =
            workflow.substringAfter("\n  test:\n").substringBefore("\n  api_compatibility:\n")

        assertContains(testJob, "needs: build")
        assertContains(testJob, "if: needs.build.result == 'success'")
        assertContains(testJob, "cache-read-only: true")
        assertContains(testJob, "name: Restore exact-run Gradle build cache")
        assertContains(testJob, "name: ci-gradle-build-cache-\${{ github.run_id }}")
    }

    @Test
    fun `trusted detector always runs and proposed detector only runs when changed`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        val apiCompatibilityJob =
            workflow
                .substringAfter("\n  api_compatibility:\n")
                .substringBefore("\n  version_support_matrix:\n")

        val trustedDetector = apiCompatibilityJob.indexOf("\"\$BASE_DETECTOR\" \"\$BASE_COMMIT\"")
        val changeCheck =
            apiCompatibilityJob.indexOf(
                "git diff --quiet \"\$BASE_COMMIT\" -- scripts/detect-breaking-changes"
            )
        val proposedDetector =
            apiCompatibilityJob.indexOf("./scripts/detect-breaking-changes \"\$BASE_COMMIT\"")

        assertTrue(trustedDetector >= 0, "The trusted detector must always run.")
        assertTrue(
            changeCheck > trustedDetector,
            "Check for detector changes after trusted validation.",
        )
        assertTrue(
            proposedDetector > changeCheck,
            "Only run the proposed detector inside the changed-detector branch.",
        )
    }
}
