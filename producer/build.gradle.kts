println("producer\build.gradle.kts")

abstract class CompileJava : DefaultTask() {

    @get:OutputDirectory
    abstract val classesDirectory: DirectoryProperty

    @TaskAction
    fun action() {
        println("$name compile java in producer")
        project.exec {
            executable = "javac"
            args = listOf(
                "-d", classesDirectory.get().asFile.path,
                "src/main/java/*.java"
            )
        }
    }
}

open class Jar : DefaultTask() {

    init {
        group = "build"
    }

    @TaskAction
    fun action() {
        println("$name assemble jar")
        project.exec {
            executable = "jar"
            args = listOf(
                "cvf", "build\\libs\\producer.jar",
                "-C", "build\\classes", "."
            )
        }
    }
}

val compileJava = tasks.register<CompileJava>("compileJava") {
    println("$name configuration")
    classesDirectory.set(File("build\\classes"))
    classesDirectory.set(layout.buildDirectory.dir("classes"))
}


val jar = tasks.register<Jar>("jar") {
    println("$name configuration")
}
