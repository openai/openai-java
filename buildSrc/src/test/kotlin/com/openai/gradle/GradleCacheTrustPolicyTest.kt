package com.openai.gradle

import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.readText
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.jupiter.api.io.TempDir

class GradleCacheTrustPolicyTest {
    @TempDir lateinit var temporaryDirectory: Path

    @Test
    fun `all pull request Gradle jobs keep cross-run caches read-only`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        val setupCount =
            workflow.lines().count { it.contains("uses: gradle/actions/setup-gradle@") }
        val cachePolicies =
            workflow
                .lineSequence()
                .map { it.trim() }
                .filter { it.startsWith("cache-read-only:") }
                .map { it.removePrefix("cache-read-only:").trim() }
                .toList()

        assertEquals(
            setupCount,
            cachePolicies.size,
            "Every Gradle job must declare its cache policy.",
        )
        assertTrue(setupCount > 0, "The CI workflow must continue to exercise Gradle.")
        assertTrue(
            cachePolicies.all {
                it == "true" ||
                    it == "\${{ github.ref_name != github.event.repository.default_branch }}"
            },
            "Pull requests and all artifact-consuming jobs must not save cross-run caches.",
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
        assertFalse(buildJob.contains("overwrite: true"), "Cache artifacts must remain immutable.")

        val restoreSteps =
            workflow.split("\n      - name: Restore exact-run Gradle build cache\n").drop(1).map {
                it.substringBefore("\n      - name:")
            }

        assertEquals(3, restoreSteps.size, "All exact-run cache consumers must remain protected.")
        restoreSteps.forEach { restoreStep ->
            assertContains(
                restoreStep,
                "artifact-ids: \${{ needs.build.outputs.gradle-cache-artifact-id }}",
            )
            assertContains(restoreStep, "digest-mismatch: error")
            assertFalse(
                restoreStep.contains("github-token:"),
                "Cache artifacts must stay scoped to the current workflow run.",
            )
            assertFalse(
                restoreStep.contains("run-id:"),
                "Cache artifacts must never be restored from another workflow run.",
            )
        }
    }

    @Test
    fun `artifact ID restores keep cache entries at the Gradle lookup path`() {
        val workflow = Path.of("../.github/workflows/ci.yml").readText()
        val cacheKey = "0123456789abcdef0123456789abcdef"
        val cacheEntry = temporaryDirectory.resolve(cacheKey).apply { writeText("cached classes") }
        val restoreSteps =
            workflow.split("\n      - name: Restore exact-run Gradle build cache\n").drop(1).map {
                it.substringBefore("\n      - name:")
            }

        assertEquals(3, restoreSteps.size)
        restoreSteps.forEachIndexed { index, restoreStep ->
            val mergeMultiple = restoreStep.contains("merge-multiple: true")

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
        assertContains(publishJob, "cache-disabled: true")
        assertFalse(publishJob.contains("actions/download-artifact@"))
        assertFalse(publishJob.contains("actions/cache@"))
    }
}
