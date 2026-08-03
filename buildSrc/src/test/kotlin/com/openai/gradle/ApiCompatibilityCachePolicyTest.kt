package com.openai.gradle

import java.nio.file.Path
import kotlin.io.path.readText
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse

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
}
