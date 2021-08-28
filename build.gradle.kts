plugins {
    idea
	scala
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
