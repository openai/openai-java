package com.openai.helpers

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.live.DecisionCreateEvent
import com.openai.models.live.SessionConfig
import com.openai.models.live.sideband.SidebandClientEvent
import java.io.File
import java.lang.reflect.Method
import java.net.URLClassLoader
import java.nio.file.Path
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class VisitorCompatibilityTest {
    @TempDir lateinit var tempDir: Path

    @ParameterizedTest
    @ValueSource(ints = [1, 2])
    fun oldVisitorsRemainSourceAndBinaryCompatible(index: Int) {
        val union: Any
        val visitor: Class<*>
        val added: Set<String>
        when (index) {
            1 -> {
                union =
                    SessionConfig.Delegation.ofDecisions(
                        jsonMapper()
                            .readValue(
                                "{\"extra\":\"preserved\"}",
                                SessionConfig.Delegation.Decisions::class.java,
                            )
                    )
                visitor = SessionConfig.Delegation.Visitor::class.java
                added = setOf("visitDecisions")
            }
            else -> {
                union =
                    SidebandClientEvent.ofDecisionCreate(
                        DecisionCreateEvent.builder().eventId("test").build()
                    )
                visitor = SidebandClientEvent.Visitor::class.java
                added =
                    setOf(
                        "visitDecisionCreate",
                        "visitDecisionItemCreate",
                        "visitDecisionItemDelete",
                    )
            }
        }
        val methods =
            visitor.declaredMethods.filter { it.name.startsWith("visit") }.sortedBy { it.name }
        val oldMethods = methods.filter { it.name !in added }
        val newMethods = methods.filter { it.name in added }
        assertThat(newMethods.map { it.name }.toSet()).isEqualTo(added)
        assertThat(newMethods).allMatch { it.isDefault }
        val classpath =
            (listOf(visitor, JsonValue::class.java, Metadata::class.java) +
                    methods.flatMap { it.parameterTypes.toList() })
                .mapNotNull { it.protectionDomain.codeSource?.location }
                .map { File(it.toURI()).path }
                .distinct()
                .joinToString(File.pathSeparator)
        fun method(method: Method, result: String) =
            "public String ${method.name}(${method.parameterTypes.single().canonicalName} value) { return \"$result\"; }"
        fun consumer(name: String, overrideNew: Boolean = false) =
            "public class $name implements ${visitor.canonicalName}<String> { " +
                "public int calls; public com.openai.core.JsonValue value; " +
                "public String unknown(com.openai.core.JsonValue value) { calls++; this.value=value; return \"unknown\"; } " +
                oldMethods.joinToString("\n") { method(it, "old") } +
                (if (overrideNew) newMethods.joinToString("\n") { method(it, "new") } else "") +
                " }"
        val root = generateSequence(visitor) { it.enclosingClass }.last()
        val oldAbi =
            compileJava(
                tempDir,
                "old-abi",
                root.simpleName,
                oldVisitorAbi(root, visitor, oldMethods),
                classpath,
            )
        val binary =
            compileJava(
                tempDir,
                "old-consumer",
                "LegacyVisitor",
                consumer("LegacyVisitor"),
                "$oldAbi${File.pathSeparator}$classpath",
            )
        val source =
            compileJava(
                tempDir,
                "source-consumer",
                "LegacyVisitor",
                consumer("LegacyVisitor"),
                classpath,
            )
        for (classes in listOf(binary, source)) {
            URLClassLoader(arrayOf(classes.toUri().toURL()), visitor.classLoader).use { loader ->
                val instance =
                    loader.loadClass("LegacyVisitor").getDeclaredConstructor().newInstance()
                assertThat(union.javaClass.getMethod("accept", visitor).invoke(union, instance))
                    .isEqualTo("unknown")
                assertThat(instance.javaClass.getField("calls").getInt(instance)).isEqualTo(1)
                assertThat(instance.javaClass.getField("value").get(instance))
                    .isEqualTo(JsonValue.from(union))
                assertThat(oldMethods.first().invoke(instance, null)).isEqualTo("old")
            }
        }
        val explicit =
            compileJava(
                tempDir,
                "new-consumer",
                "NewVisitor",
                consumer("NewVisitor", true),
                classpath,
            )
        URLClassLoader(arrayOf(explicit.toUri().toURL()), visitor.classLoader).use { loader ->
            val instance = loader.loadClass("NewVisitor").getDeclaredConstructor().newInstance()
            assertThat(union.javaClass.getMethod("accept", visitor).invoke(union, instance))
                .isEqualTo("new")
            assertThat(instance.javaClass.getField("calls").getInt(instance)).isZero()
        }
    }

    // Reconstruct the pre-addition JVM interface, including exact nested payload names.
    // Only the consumer class files enter the runtime loader; the old ABI stays on the compile
    // path.
    private fun oldVisitorAbi(root: Class<*>, visitor: Class<*>, methods: List<Method>): String {
        class Node(val name: String) {
            val children = linkedMapOf<String, Node>()
            var declaration: String? = null

            fun render(top: Boolean = false): String =
                declaration
                    ?: "public ${if (top) "" else "static "}class $name { ${children.values.joinToString(" ") { it.render() }} }"
        }
        val tree = Node(root.simpleName)
        fun node(type: Class<*>): Node {
            var at = tree
            for (part in type.name.removePrefix(root.name + "$").split('$')) {
                at = at.children.getOrPut(part) { Node(part) }
            }
            return at
        }
        methods
            .flatMap { it.parameterTypes.toList() }
            .filter { it.name.startsWith(root.name + "$") }
            .forEach { node(it) }
        node(visitor).declaration =
            "public interface Visitor<T> { " +
                methods.joinToString(" ") {
                    "T ${it.name}(${it.parameterTypes.single().canonicalName} value);"
                } +
                "T unknown(com.openai.core.JsonValue value); }"
        return "package ${root.`package`.name}; ${tree.render(true)}"
    }
}
