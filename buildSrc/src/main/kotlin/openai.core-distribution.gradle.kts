import com.openai.gradle.CoreCompilationDependencies
import com.openai.gradle.CoreCompilationShard
import com.openai.gradle.CoreCompilationShardSpec
import com.openai.gradle.CoreCompilationShards
import com.openai.gradle.CoreCompilationStagingOutputSpec
import com.openai.gradle.CoreDistribution
import com.openai.gradle.DistributionPrecedingCohortsSpec
import com.openai.gradle.DistributionSourceSpec
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("openai.kotlin")
    id("openai.publish")
}

val owner = CoreDistribution.values().single { it.artifact == project.name }

// Kotlin uses the compilation module name in JVM names of internal members, including
// calls emitted into downstream inline bodies. Keep its original compilation identity.
val cohorts =
    when (owner) {
        CoreDistribution.RUNTIME -> listOf(
            CoreCompilationShard.RUNTIME,
            CoreCompilationShard.MODELS_FOUNDATION,
            CoreCompilationShard.MODELS_COMMON,
            CoreCompilationShard.CLIENT_BASE,
        )
        CoreDistribution.RESPONSES -> listOf(
            CoreCompilationShard.MODELS_COMMON,
            CoreCompilationShard.SERVICES_RESPONSES,
        )
        CoreDistribution.FULL -> error("Full core already compiles with its original shards")
    }

// Keep the complete owned source tree available to the source JAR and Dokka.
val selectSources = tasks.register<Sync>("selectCanonicalSources") {
    val expectedShards = cohorts.toSet()
    from(rootProject.layout.projectDirectory.dir("openai-java-core/src/main/kotlin")) {
        include(DistributionSourceSpec(owner))
        filesMatching("**/*.kt") {
            check(CoreCompilationShards.shardFor(path) in expectedShards) {
                "Missing original Kotlin compilation for $path in $expectedShards"
            }
        }
    }
    into(layout.buildDirectory.dir("generated/sources/distribution/kotlin"))
}
kotlin.sourceSets.named("main") { kotlin.srcDir(selectSources) }

val mainSources = sourceSets.main.get()
val cohortOutputs = mutableListOf<Provider<Directory>>()
val staging = layout.buildDirectory.dir("classes/kotlin/distribution-main")
val combined = layout.buildDirectory.dir("classes/kotlin/main")
val assembleDistribution = tasks.register<Sync>("assembleDistributionClasses") {
    into(combined)
    duplicatesStrategy = DuplicatesStrategy.FAIL
    // The compiler has already encoded the original module identity in the class metadata.
    // Qualify the resource path so another owner of part of that shard can coexist in a JAR.
    val artifactName = owner.artifact
    rename("(.+)\\.kotlin_module", "$artifactName-$1.kotlin_module")
}

cohorts.forEach { shard ->
    val upstream = files(cohortOutputs.toList())
    val compile = if (shard == cohorts.last()) {
        tasks.named<KotlinCompile>("compileKotlin") {
            destinationDirectory.set(staging)
            exclude(DistributionPrecedingCohortsSpec(cohorts.dropLast(1)))
            libraries.from(upstream)
        }
    } else {
        val suffix = shard.id.split('-').joinToString("") { it.replaceFirstChar(Char::uppercaseChar) }
        val cohort = sourceSets.create("shard$suffix")
        kotlin.sourceSets.named(cohort.name) {
            kotlin.setSrcDirs(listOf(selectSources, layout.projectDirectory.dir("src/main/kotlin")))
            kotlin.include(CoreCompilationShardSpec(shard))
        }
        cohort.compileClasspath = mainSources.compileClasspath + upstream
        tasks.named<KotlinCompile>(cohort.getCompileTaskName("kotlin"))
    }
    val originalProject = project(":${shard.projectName}")
    originalProject.pluginManager.withPlugin("openai.core-shard") {
        val original = originalProject.tasks.named<KotlinCompile>("compileKotlin")
        compile.configure {
            compilerOptions.moduleName.set(original.get().compilerOptions.moduleName.get())
        }
    }
    compile.configure { friendPaths.from(upstream) }
    val output = compile.flatMap { it.destinationDirectory }
    assembleDistribution.configure { from(output) }
    cohortOutputs.add(output)
}

val mainClasses = mainSources.output.classesDirs as ConfigurableFileCollection
mainClasses.setFrom(combined, mainSources.java.classesDirectory)
mainClasses.builtBy(assembleDistribution)
tasks.named<JavaCompile>("compileJava") { classpath += files(assembleDistribution) }
tasks.named("classes") { dependsOn(assembleDistribution) }
tasks.named<Jar>("jar") {
    // The Kotlin JVM plugin also captures the main compilation's staging directory.
    exclude(CoreCompilationStagingOutputSpec(staging.get().asFile))
    duplicatesStrategy = DuplicatesStrategy.FAIL
}

val jacksonVersion =
    extensions.getByType(VersionCatalogsExtension::class.java)
        .named("libs").findVersion("jacksonPublished").get().requiredVersion
dependencies {
    // The compiler exercises the minimum Jackson ABI, while the POM uses the supported runtime.
    CoreCompilationDependencies.compilerClasspathDependencies(jacksonVersion).forEach { compileOnly(it) }
}
configurations.compileClasspath {
    resolutionStrategy {
        CoreCompilationDependencies.jacksonCompatibilityDependencies.forEach(::force)
    }
}

tasks.named<Jar>("sourcesJar") {
    filesMatching("**/*.kt") { path = path.removePrefix("main/") }
}
