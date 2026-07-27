package com.openai.gradle

import java.nio.file.Path
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import org.junit.jupiter.api.io.TempDir

class VersionSupportPolicyTest {
    @TempDir lateinit var temporaryDirectory: Path

    @Test
    fun `matrices include supported artifact floors and exclude EOL floors`() {
        val policy =
            loadPolicy(
                """
                build.jdk=21
                test.current-lts=25
                test.supported-lts=8,11,17,21,25
                test.current-non-lts=26
                artifact.java-8.runtime=8
                artifact.java-8.lifecycle=active
                artifact.java-17.runtime=17
                artifact.java-17.lifecycle=maintenance
                artifact.eol.runtime=11
                artifact.eol.lifecycle=eol
                """
            )

        assertEquals(listOf(8, 17, 25), policy.runtimeMatrix("pull-request"))
        assertEquals(listOf(8, 11, 17, 21, 25, 26), policy.runtimeMatrix("full"))
    }

    @Test
    fun `Java properties syntax has one validated interpretation`() {
        val policy =
            loadPolicy(
                """
                build.jdk : 21
                test.current-lts = 25
                test.supported-lts = 8,11,17,21,\
                  25
                test.current-non-lts = 26
                artifact.core.runtime = 8
                artifact.core.lifecycle = active
                """
            )

        assertEquals(listOf(8, 11, 17, 21, 25), policy.supportedLts)
    }

    @Test
    fun `unknown properties fail closed`() {
        val error =
            assertFailsWith<IllegalStateException> {
                loadPolicy(
                    """
                    build.jdk=21
                    test.current-lts=25
                    test.supported-lts=8,11,17,21,25
                    test.current-non-lts=26
                    test.minimum=8
                    artifact.core.runtime=8
                    artifact.core.lifecycle=active
                    """
                )
            }

        assertTrue(error.message.orEmpty().contains("Unknown version support properties"))
    }

    private fun loadPolicy(contents: String): VersionSupportPolicy {
        val policyFile = temporaryDirectory.resolve("version-support.properties")
        policyFile.writeText(contents.trimIndent())
        return VersionSupportPolicy.load(policyFile.toFile())
    }
}
