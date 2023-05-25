println("producer\build.gradle.kts")

open class CompileJava : DefaultTask() {
    @TaskAction
    fun action() {
        println("$name compile java in producer")
        project.exec {
            executable = "javac"
            args = listOf(
                "-d", "build/classes",
                "src/main/java/*.java"
            )
        }
    }
}

open class Jar : DefaultTask() {
    @TaskAction
    fun action() {
        println("$name assemble jar")
        project.exec{
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
}


val jar = tasks.register<CompileJava>("jar") {
    println("$name configuration")
}
