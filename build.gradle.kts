plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.4"
}

group = "pro.dkart"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
java {
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2024.3.5")
    type.set("PS") // Target IDE Platform

    plugins.set(
            listOf(
                    "com.jetbrains.php"
            )
    )
}

tasks {
    buildSearchableOptions {
        enabled = false
    }
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "19"
        targetCompatibility = "19"
    }

    patchPluginXml {
        sinceBuild.set("231")
        untilBuild.set("243.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }

    runIde {
        jvmArgs = listOf("-Didea.ProcessCanceledException=disabled")
    }
}
