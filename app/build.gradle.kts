plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    application
}
tasks {
    compileKotlin {
        kotlinOptions.languageVersion = "1.8"
        kotlinOptions.jvmTarget = "11"
    }

    compileTestKotlin {
        kotlinOptions.languageVersion = "1.8"
        kotlinOptions.jvmTarget = "11"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:30.1.1-jre")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

