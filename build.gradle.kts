plugins {
    java
}

version = "1.0"

tasks.register<Zip>("dist") {

    dependsOn("build")

    from("build/libs") {
        include("*.jar")
    }

    from("src/main/zip") {
        include("*.xml")
        filter {
            it.replace("@VERSION@", "$version")
        }
    }

    destinationDirectory.set(file("build/distributions"))
    archiveFileName = "${rootProject.name}.zip"
}