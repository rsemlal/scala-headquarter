import sbt._
import Keys._

object ScalaHeadquarterBuild extends Build {
  lazy val root = Project(
    	id = "scala-headquarter",
    	base = file("."),
    	settings = commonSettings
    ) aggregate (
    	scalaHeadquarterCore
    )


  lazy val scalaHeadquarterCore = Project(id = "scala-headquarter-core", base = file("scala-headquarter-core"))

  def commonSettings = Defaults.defaultSettings ++ Seq(
  	sbtVersion in GlobalScope := "0.13.1",
  	scalaVersion := "2.10.3"
  )
}
