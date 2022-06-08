ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.12"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.1"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.4.1"

libraryDependencies += "org.vegas-viz" %% "vegas" % "0.3.11"
libraryDependencies += "org.vegas-viz" %% "vegas-spark" % "0.3.11"