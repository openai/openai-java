import com.openai.gradle.CoreCompilationDependencies
import com.openai.gradle.CoreCompilationShard
import com.openai.gradle.CoreCompilationShardSpec
import com.openai.gradle.CoreCompilationShards
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { id("openai.kotlin") }

val shard = CoreCompilationShards.shardForProject(project.name)
val coreSourceDirectory = rootProject.layout.projectDirectory.dir("openai-java-core/src/main/kotlin")

kotlin.sourceSets.named("main") {
    kotlin.srcDir(coreSourceDirectory)
    kotlin.include(CoreCompilationShardSpec(shard))
}

val friendOutputs =
    shard.transitiveDependencies().map { dependencyShard ->
        rootProject.layout.projectDirectory.dir(
            "${dependencyShard.projectName}/build/classes/kotlin/main"
        )
    }

tasks.named<KotlinCompile>("compileKotlin") { friendPaths.from(friendOutputs) }

configurations.configureEach {
    resolutionStrategy {
        CoreCompilationDependencies.jacksonCompatibilityDependencies.forEach(::force)
    }
}

dependencies {
    shard.dependencies.forEach { dependencyShard ->
        api(project(":${dependencyShard.projectName}"))
    }

    if (shard == CoreCompilationShard.RUNTIME) {
        // These are internal compilation projects, so exposing every external dependency here only
        // supplies downstream shards with the same compiler classpath as openai-java-core. The
        // projects are not published and never appear in openai-java-core's metadata.
        CoreCompilationDependencies.compilerClasspathDependencies.forEach { api(it) }
    }
}
