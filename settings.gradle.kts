pluginManagement {
	repositories {
		mavenCentral()
		gradlePluginPortal()

		maven("https://maven.fabricmc.net") {
			content {
				includeGroupAndSubgroups("net.fabricmc")
			}
		}
		// Stonecutter
		maven("https://maven.kikugie.dev/snapshots") {
			content {
				includeGroupAndSubgroups("dev.kikugie")
			}
		}
	}
}

rootProject.name = "skyblock-item-list"

plugins {
	id("dev.kikugie.stonecutter") version "0.10-beta.1"
}

stonecutter {
	create(rootProject) {
		version("26.3")
		version("26.2")
		version("26.1", "26.1.2")
	}
}

val versions = listOf("26.3", "26.2", "26.1")

dependencyResolutionManagement {
	versionCatalogs {
		versions.forEach {
			create("versionedLibs${it.replace(".", "")}") {
				from(files("gradle/${it.replace(".", "_")}.versions.toml"))
			}
		}
	}
}

