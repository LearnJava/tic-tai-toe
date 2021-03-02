import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.useIR = true

plugins {
    val kotlinVer = "1.4.30"
    id("java")
    id("com.github.johnrengelman.shadow") version "5.2.0"
    kotlin("jvm") version kotlinVer
}
group = "ru.konstantin"
version = "0.0.1"

java.sourceCompatibility = JavaVersion.VERSION_1_8
val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
repositories {
    mavenCentral()
    jcenter()
    maven { url=uri("https://jcenter.bintray.com/org/eclipse/swt/") }

}
dependencies {
//    implementation(fileTree("lib") { include("*.jar") })
    implementation("org.eclipse.swt:org.eclipse.swt.win32.win32.x86_64:4.3")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("junit:junit:4.12")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.jar {
    manifest {
        attributes(
                "Main-Class" to "java.zero.StartAllVersionHere"
        )
    }
}