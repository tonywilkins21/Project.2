# BIG COSMIC DATA
This was my first group project to create a generator to generate data from the csv file with 10,000 records! The team and I then created a spark session to run SPARKSQL queries to get the datasets we wanted. Finally we researched and use vegas as our data visulalization.

# Technologies Used

For Windows 11-

IntelliJ IDEA 2022.1.1 (Community Edition)
Java 1.8

Build.sbt version = 0.1

ScalaVersion = 2.11.12


# Features

1. Created a username and password login.
2.  allows the person to select what query they would like to view after login.
3.  shows bar graph of queries with vegas

To-do List:
1. Structure database to store users
2. learn more about vegas

#Getting Started

Import LibraryDependencies-

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.1"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.1"

libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.2.1"

For Generator:

import java.time.LocalDate 
import scala.util.Random

For firstfilter:
import org.apache.spark
import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level, Logger}
Imported Vegas

# Usage

once everything is installed, you can perform queries to get certain information you may want to view.

# Contributors
ScrumMaster- Normand Jean
Team:
Morgan
Sherrell
Abnel
Tony (Myself)

