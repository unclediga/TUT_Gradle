println("producer\build.gradle.kts")

abstract class CompileJava : AbstractExecTask<CompileJava>(CompileJava::class.java) {

    @get:InputDirectory
    abstract val sourcesDirectory: DirectoryProperty

    @get:OutputDirectory
    abstract val classesDirectory: DirectoryProperty

    override fun exec() {
        println("$name compile java in producer")

        val sourceFiles = sourcesDirectory.asFileTree.map { it.path }

        executable = "javac"
        args(listOf("-d", classesDirectory.get().asFile.path) + sourceFiles)
        super.exec()
    }
}

val compileJava = tasks.register<CompileJava>("compileJava") {
    println("$name configuration")
    //classesDirectory.set(File("build\\classes"))
    classesDirectory.set(layout.buildDirectory.dir("classes"))
    sourcesDirectory.set(layout.projectDirectory.dir("src/main/java"))
}


val jar = tasks.register<Jar>("jar") {
    println("$name configuration ")
    from(compileJava.flatMap { it.classesDirectory })
    destinationDirectory.set(layout.buildDirectory.dir("libs"))
    archiveBaseName.set(project.name)
}
