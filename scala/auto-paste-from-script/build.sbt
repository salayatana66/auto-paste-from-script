lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.10",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Auto Paste From Script",  

// to access the REPL libraries
   libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value )
