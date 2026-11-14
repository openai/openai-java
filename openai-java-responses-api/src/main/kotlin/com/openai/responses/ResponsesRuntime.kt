package com.openai.responses

import java.io.IOException
import java.net.JarURLConnection
import java.net.URL
import java.util.jar.Attributes

private const val RUNTIME_MARKER = "META-INF/com.openai/openai-java-runtime.marker"
private const val OPTIONS_CLASS = "com/openai/core/ClientOptions.class"
private val oldRelease = Regex("""[0-4]\.\d+\.\d+""")

/** Best effort for identifiable release JARs visible to this entry point's defining loader. */
@JvmSynthetic
internal fun checkResponsesRuntime(loader: ClassLoader?) {
    val version =
        try {
            if (loader?.getResource(RUNTIME_MARKER) == null) return
            loader
                .getResources(OPTIONS_CLASS)
                .asSequence()
                .mapNotNull(::oldCoreVersion)
                .firstOrNull()
        } catch (_: IOException) {
            null
        } catch (_: SecurityException) {
            null
        }

    check(version == null) {
        "Found openai-java-core $version alongside the split openai-java-runtime. " +
            "Remove the old core or align com.openai dependencies with openai-java-bom. " +
            "Dependencies compiled against v4 may require migration and recompilation."
    }
}

private fun oldCoreVersion(resource: URL): String? {
    if (resource.protocol != "jar") return null
    return try {
        val connection = resource.openConnection() as? JarURLConnection ?: return null
        if (connection.jarFileURL.protocol != "file" || connection.entryName != OPTIONS_CLASS)
            return null
        connection.useCaches = false
        connection.jarFile.use { jar ->
            // A repackaged split runtime may have inherited the enclosing JAR's manifest.
            if (jar.getJarEntry(RUNTIME_MARKER) != null) return null
            val attributes = jar.manifest?.mainAttributes ?: return null
            if (attributes.getValue(Attributes.Name.IMPLEMENTATION_TITLE) != "openai-java-core")
                return null
            attributes.getValue(Attributes.Name.IMPLEMENTATION_VERSION)?.takeIf(oldRelease::matches)
        }
    } catch (_: IOException) {
        null
    } catch (_: SecurityException) {
        null
    }
}
