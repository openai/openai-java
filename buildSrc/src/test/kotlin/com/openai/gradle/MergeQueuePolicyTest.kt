package com.openai.gradle

import java.nio.file.Path
import kotlin.io.path.readText
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import org.yaml.snakeyaml.LoaderOptions
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.SafeConstructor

class MergeQueuePolicyTest {
    @Test
    fun `required CI workflow runs on merge groups`() {
        // CodeQL is intentionally not a merge requirement; see PR #916 and codeql.yml.
        val workflow = workflow("ci")
        // SnakeYAML's YAML 1.1 resolver may interpret the key `on` as true.
        val events = (workflow["on"] ?: workflow[true]) as Map<*, *>
        val mergeGroup = events["merge_group"] as Map<*, *>
        assertEquals(listOf("checks_requested"), mergeGroup["types"])
        assertFalse(events.containsKey("pull_request_target"))
        assertEquals("CI / required", job(workflow, "required")["name"])
        assertEquals(mapOf("contents" to "read"), workflow["permissions"])
    }

    @Test
    fun `API compatibility checks the event base on pull requests and merge groups`() {
        val api = job(workflow("ci"), "api_compatibility")
        assertEquals(
            "needs.build.result == 'success' && " +
                "(github.event_name == 'pull_request' || github.event_name == 'merge_group')",
            (api["if"] as String).trim(),
        )
        val comparison =
            steps(api).single { it["name"] == "Compile previous tests against the proposed SDK" }
        val environment = comparison["env"] as Map<*, *>
        assertEquals(
            "\${{ github.event_name == 'pull_request' && github.event.pull_request.base.sha || " +
                "github.event.merge_group.base_sha }}",
            environment["BASE_COMMIT"],
        )
        assertContains(comparison["run"] as String, "\"\$BASE_DETECTOR\" \"\$BASE_COMMIT\"")
        val checkout =
            steps(api).single { (it["uses"] as? String)?.startsWith("actions/checkout@") == true }
        assertEquals(0, (checkout["with"] as Map<*, *>)["fetch-depth"])
    }

    @Test
    fun `aggregate gate fails closed for every required queue job`() {
        val required = job(workflow("ci"), "required")
        assertEquals("always()", required["if"])
        assertEquals(
            setOf("lint", "build", "test", "api_compatibility", "runtime_compatibility"),
            (required["needs"] as List<*>).toSet(),
        )
        val gate = steps(required).single { it["name"] == "Verify required jobs succeeded" }
        val environment = gate["env"] as Map<*, *>
        val jobs =
            mapOf(
                "LINT_RESULT" to "lint",
                "BUILD_RESULT" to "build",
                "TEST_RESULT" to "test",
                "API_COMPATIBILITY_RESULT" to "api_compatibility",
                "RUNTIME_COMPATIBILITY_RESULT" to "runtime_compatibility",
            )
        assertEquals("\${{ github.event_name }}", environment["EVENT_NAME"])
        jobs.forEach { (variable, job) ->
            assertEquals("\${{ needs.$job.result }}", environment[variable])
        }
        val success = jobs.keys.associateWith { "success" }
        val script = gate["run"] as String
        for (event in listOf("pull_request", "merge_group")) {
            assertGate(script, event, success, 0)
            for (variable in jobs.keys) {
                for (result in listOf("failure", "cancelled", "skipped", "")) {
                    assertGate(script, event, success + (variable to result), 1)
                }
            }
        }
        for (event in listOf("push", "workflow_dispatch")) {
            assertGate(script, event, success + ("API_COMPATIBILITY_RESULT" to "skipped"), 0)
        }
    }

    private fun assertGate(script: String, event: String, results: Map<String, String>, exit: Int) {
        val builder = ProcessBuilder("bash", "-c", script).redirectErrorStream(true)
        builder.environment().putAll(results + ("EVENT_NAME" to event))
        val process = builder.start()
        val output = process.inputStream.bufferedReader().use { it.readText() }
        assertEquals(exit, process.waitFor(), "$event $results\n$output")
    }

    private fun workflow(name: String): Map<*, *> {
        val options = LoaderOptions().apply { setAllowDuplicateKeys(false) }
        return Yaml(SafeConstructor(options))
            .load<Map<*, *>>(Path.of("../.github/workflows/$name.yml").readText())
    }

    private fun job(workflow: Map<*, *>, name: String): Map<*, *> =
        (workflow["jobs"] as Map<*, *>)[name] as Map<*, *>

    private fun steps(job: Map<*, *>): List<Map<*, *>> =
        (job["steps"] as List<*>).map { it as Map<*, *> }
}
