package com.openai.gradle

import java.io.Serializable
import org.gradle.api.file.FileTreeElement
import org.gradle.api.specs.Spec

/** Publication ownership of the canonical source tree. Castiron continues to write it once. */
enum class CoreDistribution(val artifact: String) {
    RUNTIME("openai-java-runtime"),
    RESPONSES("openai-java-responses-api"),
    FULL("openai-java-core");

    companion object {
        fun owner(path: String): CoreDistribution {
            val source = path.substringAfter("com/openai/", "")
            val packagePath = source.substringBeforeLast('/', "")
            return when {
                packagePath == "models" ||
                    packagePath == "models/responses" ||
                    source.startsWith("core/") ||
                    source.startsWith("auth/") ||
                    source.startsWith("azure/") ||
                    source.startsWith("credential/") ||
                    source.startsWith("errors/") -> RUNTIME
                source.startsWith("responses/") ||
                    source.startsWith("models/responses/") ||
                    source.startsWith("services/blocking/responses/") ||
                    source.startsWith("services/async/responses/") -> RESPONSES
                else -> FULL
            }
        }
    }
}

class DistributionSourceSpec(private val owner: CoreDistribution) :
    Spec<FileTreeElement>, Serializable {
    override fun isSatisfiedBy(element: FileTreeElement): Boolean =
        element.isDirectory || CoreDistribution.owner(element.relativePath.pathString) == owner
}
