name := "d2p-server"

version := "1.0"

scalaVersion := "2.11.8"

lazy val root =
  Project(id = "d2p-server",
    base = file("."))
    .dependsOn(common)

lazy val common =
  Project(id = "d2p-common",
    base = file("common"))

lazy val versions = new {
  val config = "1.3.1"
  val finatra = "2.13.0"
  val guice = "4.0"
  val logback = "1.1.3"
  val swagger = "0.7.2"
  val phantom = "2.14.5"
  val util = "0.30.1"
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases/"
)

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % versions.config,
  "com.twitter" %% "finatra-http" % versions.finatra,
  "com.twitter" %% "finatra-slf4j" % versions.finatra,
  "ch.qos.logback" % "logback-classic" % versions.logback,
  "com.github.xiaodongw" % "swagger-finatra_2.11" % versions.swagger,
  "com.outworkers" %% "phantom-streams" % versions.phantom,
  "com.outworkers" %% "phantom-dsl" % versions.phantom,
  "com.outworkers" %% "phantom-finagle" % versions.phantom,
  "com.outworkers" %% "util-testing" % versions.util
)