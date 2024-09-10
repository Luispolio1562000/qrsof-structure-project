
lazy val scala3 = "3.4.2"
ThisBuild / scalaVersion := scala3
ThisBuild / version := "1.0-SNAPSHOT"
ThisBuild / organization := "com.qrsof.structureproject"


libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test
lazy val commonSettings = Seq(
  libraryDependencies ++= commonDependencies,
  scalacOptions ++= Seq(
    "-feature",
    "-Wunused:all",
    "-Wshadow:all",
    "-explain",
  ),
  Test / testOptions ++= Seq(
    Tests.Argument(TestFrameworks.ScalaTest, "-o"),
    Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports"),
    Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports")
  )
)



lazy val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "org.scalamock" %% "scalamock" % "6.0.0" % Test,
  "com.vladsch.flexmark" % "flexmark-all" % "0.64.8" % Test
)

lazy val commonDependencies = Seq(
  "com.fasterxml.uuid" % "java-uuid-generator" % "5.1.0",
  "org.playframework" %% "play" % "3.0.5",
  "net.codingwell" %% "scala-guice" % "6.0.0",
  "io.scalaland" %% "chimney" % "1.3.0",
  "com.lihaoyi" %% "ujson" % "4.0.0"
) ++ testDependencies




lazy val business = (project in file("business"))
  .dependsOn()
  .settings(
    libraryDependencies ++= Seq(
      "org.playframework" %% "play-slick" % "6.1.1"),
    Test / testOptions ++= Seq(
      Tests.Argument(TestFrameworks.ScalaTest, "-o"),
      Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports"),
      Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports/domain")
    ),
    commonSettings,
  )


lazy val data = (project in file("data"))
  .dependsOn(business)
  .settings(
    libraryDependencies ++= Seq(
      "org.playframework" %% "play-slick" % "6.1.1",
      "org.playframework" %% "play-slick-evolutions" % "6.1.1",
      "org.postgresql" % "postgresql" % "42.7.3"
    ),
    Test / testOptions ++= Seq(
      Tests.Argument(TestFrameworks.ScalaTest, "-o"),
      Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports"),
      Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports/data")
    ),
    commonSettings
  )

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "qrsof-structure-project",
    commonSettings,
    libraryDependencies ++= Seq(
      guice,
      "net.codingwell" %% "scala-guice" % "6.0.0",
      "io.lemonlabs" %% "scala-uri" % "4.0.3",
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test,
    )
  )
  .dependsOn(business, data)
  .aggregate(business, data)

import scala.concurrent.duration.*

ThisBuild / forceUpdatePeriod := Some(0.seconds)






// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"