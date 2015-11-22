import WebJs._
import RjsKeys._

name := """play-java-backbone-require"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, SbtWeb)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  evolutions,
  "org.hibernate" % "hibernate-entitymanager" % "5.0.4.Final",
  // Webjars
  "org.webjars" %% "webjars-play" % "2.4.0-1",
  "org.webjars" % "jquery" % "1.11.1",
  "org.webjars" % "bootstrap" % "3.3.5",
  "org.webjars" % "requirejs" % "2.1.20",
  "org.webjars" % "underscorejs" % "1.8.3",
  "org.webjars" % "backbonejs" % "1.2.3",
  "org.webjars" % "pace" % "1.0.2"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

// Running Play in development mode while using JPA will work fine, but in order to
// deploy the application you will need to add this to your build.sbt file.
// -- https://www.playframework.com/documentation/2.4.x/JavaJPA#Deploying-Play-with-JPA
PlayKeys.externalizeResources := false

// https://www.playframework.com/documentation/2.4.x/RequireJS-support#Enablement-and-Configuration
pipelineStages := Seq(rjs, digest, gzip)

// RJS
modules += JS.Object( "name" -> "catalog")
modules += JS.Object( "name" -> "cart")

// MochaJS
//MochaKeys.requires += "SetupMocha.js"