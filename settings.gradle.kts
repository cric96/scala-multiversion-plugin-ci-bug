rootProject.name = "gradle-test"
plugins {
    id("com.gradle.enterprise") version("3.6.4")
}

include("A", "B", "C")
