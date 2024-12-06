pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TestApplication"

//include(":startup")
includeCnLib("startup")

fun includeCnLib(subProject: String) {
    include(subProject)
    project(":$subProject").projectDir = file("cn/$subProject")
}
include(":mylibrary")
