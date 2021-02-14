name := """SharingNotes"""
organization := "sharingnotes"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.12"

crossScalaVersions := List("2.12.12", "2.11.12")

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "sharingnotes.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "sharingnotes.binders._"

libraryDependencies += "org.apache.tika" % "tika-core" % "1.24"
libraryDependencies += "org.apache.tika" % "tika-parsers" % "1.24"

libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.6.0"
libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.6.0"

resolvers += Resolver.bintrayRepo("hmrc", "releases")
libraryDependencies += "uk.gov.hmrc" %% "emailaddress" % "3.5.0"

libraryDependencies += "org.apache.lucene" % "lucene-core" % "8.7.0"
libraryDependencies += "org.apache.lucene" % "lucene-analyzers-common" % "8.7.0"
libraryDependencies += "org.apache.lucene" % "lucene-facet" % "8.7.0"
libraryDependencies += "org.apache.lucene" % "lucene-queryparser" % "8.7.0"

resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies += "com.github.play-rconf" % "play-rconf" % "release~19.09"
libraryDependencies += "com.github.play-rconf" % "play-rconf-etcd" % "release~20.05"
