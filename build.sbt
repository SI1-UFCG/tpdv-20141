name := """tpdva"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,   
  javaJpa,
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.apache.directory.api" % "api-all" % "1.0.0-M14",
  "org.hibernate" % "hibernate-core" % "4.2.3.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.2.3.Final"
)

