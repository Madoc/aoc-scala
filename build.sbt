organization := "eu.madoc"
version := "0.0.0-SNAPSHOT"

ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"

lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(name := "aoc-scala")

lazy val commonSettings = Seq(
  scalaVersion := "3.2.1",
  libraryDependencies ++= Seq(
    "io.monix" %% "minitest" % "2.9.6" % Test withSources () withJavadoc (),
  ),
  testFrameworks += new TestFramework("minitest.runner.Framework"),
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-language:postfixOps",
  ),
  semanticdbEnabled := true,
  semanticdbVersion := scalafixSemanticdb.revision,
)

val projectNames: Seq[String] = Seq("root")

test := Seq((root / Test / test).value)

run / fork := true

addCommandAlias(
  "localBuild",
  "scalafmtSbt; " + projectNames.map(n => s"$n/scalafixAll; $n/scalafmtAll; $n/compile; $n/Test/compile").mkString(";"))
