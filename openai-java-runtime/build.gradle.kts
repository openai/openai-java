import com.openai.gradle.CoreCompilationDependencies

plugins { id("openai.core-distribution") }

val jacksonVersion = libs.versions.jacksonPublished.get()
dependencies {
    CoreCompilationDependencies.publishedApiDependencies(jacksonVersion).forEach { api(it) }
    CoreCompilationDependencies.publishedImplementationDependencies(jacksonVersion)
        .forEach { implementation(it) }
}

// Preserve the canonical generated and handwritten rule paths for both installations.
sourceSets.main {
    resources.srcDir(rootProject.file("openai-java-core/src/main/resources"))
    resources.include("META-INF/proguard/**", "META-INF/com.openai/**")
}
