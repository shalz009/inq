name := """inq"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  cache,
  ws,
  "com.sksamuel.elastic4s" %% "elastic4s-core" % "5.5.4",
  "com.sksamuel.elastic4s" %% "elastic4s-http" % "5.5.4",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)
