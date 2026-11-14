import com.openai.gradle.CoreCompilationDependencies
import com.openai.gradle.CoreCompilationShard
import com.openai.gradle.CoreCompilationShardSpec
import com.openai.gradle.CoreCompilationShards
import com.openai.gradle.CoreDistribution
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { id("openai.kotlin") }

val shard = CoreCompilationShards.shardForProject(project.name)
val jacksonPublishedVersion =
    extensions
        .getByType(VersionCatalogsExtension::class.java)
        .named("libs")
        .findVersion("jacksonPublished")
        .get()
        .requiredVersion
val coreSourceDirectory =
    rootProject.layout.projectDirectory.dir("openai-java-core/src/main/kotlin")

kotlin.sourceSets.named("main") {
    kotlin.srcDir(coreSourceDirectory)
    kotlin.include(CoreCompilationShardSpec(shard))
    kotlin.exclude {
        !it.isDirectory &&
            CoreDistribution.owner(it.relativePath.pathString) != CoreDistribution.FULL
    }
}

val upstreamShards = shard.transitiveDependencies()
val friendProjects =
    upstreamShards.map { it.projectName } +
        (upstreamShards + shard).mapNotNull { it.distributionDependency?.artifact }.distinct()

tasks.named<KotlinCompile>("compileKotlin") {
    friendPaths.from(
        friendProjects.map {
            rootProject.layout.projectDirectory.dir("$it/build/classes/kotlin/main")
        }
    )
}

configurations.configureEach {
    resolutionStrategy {
        CoreCompilationDependencies.jacksonCompatibilityDependencies.forEach(::force)
    }
}

dependencies {
    shard.dependencies.forEach { dependencyShard ->
        api(project(":${dependencyShard.projectName}"))
    }

    shard.distributionDependency?.let { api(project(":${it.artifact}")) }

    if (shard == CoreCompilationShard.RUNTIME) {
        // These are internal compilation projects, so exposing every external dependency here only
        // supplies downstream shards with the same compiler classpath as openai-java-core. The
        // projects are not published and never appear in openai-java-core's metadata.
        CoreCompilationDependencies.compilerClasspathDependencies(jacksonPublishedVersion).forEach {
            api(it)
        }
    }
}
