plugins {
    idea
	scala
    id("org.nosphere.gradle.github.actions") version "1.2.0"
}


buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.adtran:scala-multiversion-plugin:2.+")
    }
}

allprojects {
    apply(plugin = "scala")
    apply(plugin = "com.adtran.scala-multiversion-plugin")
    repositories {
        mavenCentral()
    }
    dependencies {
        implementation("org.scala-lang:scala-library:%scala-version%")
        testImplementation("org.scalatest:scalatest_%%:3.1.1")
    }

    tasks.register<JavaExec>("scalaTest"){
        main = "org.scalatest.tools.Runner"
        args("-R", "build/classes/scala/test", "-o")
        classpath(sourceSets["test"].runtimeClasspath)
    }

    tasks {
        "test" { dependsOn("scalaTest") }
    }
}

project(":A") {
}
project(":B") {
    dependencies {
        implementation(project(":A"))
    }
}
project(":C") {
    dependencies {
        implementation(project(":A"))
        implementation(project(":B"))
    }
}
