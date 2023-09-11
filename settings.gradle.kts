pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }

    versionCatalogs {

        create("ktx") {
            library("bom", "org.jetbrains.kotlin", "kotlin-bom").version("1.8.0")
            library("core", "androidx.core", "core-ktx").version("1.9.0")
            library("lifecycle-runtime","androidx.lifecycle","lifecycle-runtime-ktx").version("2.6.1")
        }

    }
}

rootProject.name = "TangtangToolbox"
include(":app")
include(":autoclick")
