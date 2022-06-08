import cats.Group
import javassist.runtime.Desc
import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec.SELECT
import org.apache.http.client.methods.RequestBuilder.options
import org.apache.spark
import org.glassfish.jersey.internal.Errors.mark
import scalafx.scene.chart.Chart
import vegas.DSL.Vegas
import vegas.sparkExt.VegasSpark
import vegas.spec.Spec.MarkEnums.Bar
import vegas.spec.Spec.TypeEnums.Nominal
import vegas.{Area, Line, Nom, Quant, Quantitative}

import scala.io.StdIn.{readInt, readLine}
import scala.Seq
import org.apache.hive._

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession


object firstFilter {




  case class Customer(OrderId: Int, CusId: Int, CustomerName: String, ProductName: String, ProductPrice: Int, Qty: Double,
                      PayType: String, Valid: String, DatePurchased: String, Country: String, Website: String)

  def main(args: Array[String]): Unit = {

    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    // Use SparkSession interface
    val spark = SparkSession
      .builder
      .appName("firstFilter")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()
    // Load each line of the source data into an Dataset
    import spark.implicits._
    val schemaPeople = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv("Data/Project1.csv")
      .as[Customer]
//////////////////////////////////////////
val reg = new RegisterUser()
    val UserName = reg.UserName
    val Password = reg.Password
    val UserId = reg.generateId()
    reg.nuUsers.put(UserId, (UserName, Password))
    println(s"Wonderful $UserName This is your ID : $UserId")
    println("Try to login!")
    var login = true
    while(login){
      val loginUsr = readLine("Enter your Username :  ")
      val passUsr = readLine("Enter your Password :  ")
      val nuUser = (loginUsr, passUsr)
      val getUsers = reg.nuUsers.get(UserId)
      if (getUsers.contains(nuUser)) {
        Menus.WelcomeText()
        println("Choose:")
        var options = readInt()
        println(s"You Chose : $options")
        while (options != 0) {
          if (options == 2) {
            println("Available Options")
            Menus.Queries()
            println("Choose:")
            var options1 = readInt()
            println(s"You Chose : $options1")
            if (options1 == 1) {
              while (options1 != 0) {
                Menus.ActualQueries()
                var option2 = readInt()
                while (option2 != 0) {
                  if (option2 == 1) {
                    println("Initializing...")
                    println("Get Ready to Query the world!")
                    //1st Query
                    //
                    schemaPeople.printSchema()
                    schemaPeople.createOrReplaceTempView("people")
                    val filteredPeople = spark.sql("SELECT sum(ProductPrice) AS Price,ProductName,Category,Country FROM people GROUP BY ProductName,Category,Country HAVING Price >=10000  Order BY ProductName,Country")
                    filteredPeople.show(100)

                    //vegas query
                    val plot = Vegas("maxSalesPerCountry").
                      withDataFrame(filteredPeople.toDF()).

                      encodeX("Category", Nom).
                      encodeY("Price", Quant).
                      mark(Bar)
                      .encodeColor("Country",Nominal)
                    plot.show


                    Menus.ActualQueries()
                    println(s"What else do you want to do? Choose an Option =>")
                    option2 = readInt()
                  }
                  else if (option2 == 2) {
                    Menus.SubQueryMenus()
                    var option3 = readInt()
                    println(s"Choose a query =>")
                    while(option3 != 0){
                      if(option3 == 1){
                        println("Initializing...")
                        println("Ready!")
                        println("The Year 2022")
                        //Sub Query 3 Year 2022
                        schemaPeople.printSchema()
                        schemaPeople.createOrReplaceTempView("people")
                        val PopularProducts1 = spark.sql("SELECT SUM(Qty)AS Qty, ProductName, Country FROM people WHERE DatePurchased LIKE '2022%' GROUP BY Country,ProductName ")
                        PopularProducts1.show(100)
                        //vegas code below
                        val plot = Vegas("maxSalesPerCountry").
                          withDataFrame(PopularProducts1.toDF()).

                          encodeX("ProductName", Nom).
                          encodeY("Qty", Quant).
                          mark(Bar)
                          .encodeColor("Country",Nominal)
                        plot.show



                        Menus.SubQueryMenus()
                        println(s"What else do you want to do? Choose an Option =>")
                        option3 = readInt()
                      }
                      else if(option3 == 2){
                        //Sub Query 3 Year 2021
                        //
                        schemaPeople.printSchema()
                        schemaPeople.createOrReplaceTempView("people")
                        val PopularProducts1 = spark.sql("SELECT SUM(Qty)AS Qty, ProductName, Country FROM people WHERE DatePurchased LIKE '2021%' GROUP BY Country,ProductName ")
                        PopularProducts1.show(100)
                        //vegas code below
                        val plot = Vegas("maxSalesPerCountry").
                          withDataFrame(PopularProducts1.toDF()).

                          encodeX("ProductName", Nom).
                          encodeY("Qty", Quant).
                          mark(Bar)
                          .encodeColor("Country",Nominal)
                        plot.show
                        println("The Year 2021")
                        Menus.SubQueryMenus()
                        println(s"What else do you want to do? Choose an Option =>")
                        option3 = readInt()
                      }
                      else if(option3 == 3){
                        //Sub Query 3 Year 2020
                        schemaPeople.printSchema()
                        schemaPeople.createOrReplaceTempView("people")
                        val PopularProducts1 = spark.sql("SELECT SUM(Qty)AS Qty, ProductName, Country FROM people WHERE DatePurchased LIKE '2022%' GROUP BY Country,ProductName ")
                        PopularProducts1.show(100)
                        //vegas code below
                        val plot = Vegas("maxSalesPerCountry").
                          withDataFrame(PopularProducts1.toDF()).

                          encodeX("ProductName", Nom).
                          encodeY("Qty", Quant).
                          mark(Bar)
                          .encodeColor("Country",Nominal)
                        plot.show

                        println("The Year 2020")
                        Menus.SubQueryMenus()
                        println(s"What else do you want to do? Choose an Option =>")
                        option3 = readInt()
                      }
                      else{
                        println("Invalid")
                        Menus.SubQueryMenus()
                        println(s"What else do you want to do? Choose an Option =>")
                        option3 = readInt()
                      }
                    }
                    option2 = 0
                  }
                  else if (option2 == 3) {
                    //Query 3
                    schemaPeople.printSchema()
                    schemaPeople.createOrReplaceTempView("people")
                    val firstHiveQuery = spark.sql("SELECT COUNT(CusId) AS CusId, Country, SUM(ProductPrice) AS Price,ProductName FROM people GROUP BY Country,ProductName ORDER BY Price DESC")
                    firstHiveQuery.show(10)

                    //vegas query

                    val plot = Vegas("HighestTrafficPerCountries").
                      withDataFrame(firstHiveQuery.toDF()).

                      encodeX("Country", Nom).
                      encodeY("CusId", Quant).
                      mark(Bar)
                      .encodeColor("ProductName",Nominal)
                    plot.show


                    Menus.ActualQueries()
                    println(s"What else do you want to do? Choose an Option =>")
                    option2 = readInt()
                  }
                  else if (option2 == 4) {
                    //Query 4
                    schemaPeople.printSchema()
                    schemaPeople.createOrReplaceTempView("people")
                    val firstHiveQuery2 = spark.sql("SELECT SUM(ProductPrice) AS Price,DatePurchased,Country FROM people GROUP BY DatePurchased,Country ")
                    firstHiveQuery2.show(10)
                    //vegas query
                    val plot = Vegas("HighestTrafficPerCountries").
                      withDataFrame(firstHiveQuery2.toDF()).

                      encodeX("Country", Nom).
                      encodeY("Price", Quant).
                      mark(Line)
                      .encodeColor("Country",Nominal)
                    plot.show


                    Menus.ActualQueries()
                    println(s"What else do you want to do? Choose an Option =>")
                    option2 = readInt()
                  }
                  else {
                    println("Invalid Selection!")
                    Menus.ActualQueries()
                    println(s"What else do you want to do? Choose an Option =>")
                    option2 = readInt()
                  }
                }
                Menus.Queries()
                println(s"What else do you want to do? Choose an Option =>")
                options1 = readInt()
                if (options1 == 2) {
                  options = 2
                  options1 = 1
                }
                else if (options1 == 0) {
                  Menus.HomeMenu()
                  println("Choose:")
                  options = readInt()
                  println(s"You Chose : $options")
                }
//                else {
//                  println("Invalid")
//                }
              }
            }
          }
          else if(options == 1){
            println("Coming Soon")
            Menus.HomeMenu()
            println("Choose:")
            options = readInt()
            println(s"You Chose : $options")
          }
          else {
            println("Invalid")
            Menus.HomeMenu()
            println("Choose:")
            options = readInt()
            println(s"You Chose : $options")
          }
        }
        login = false
      } else {
        println("Try Again!")
      }
    }
    println("Thank you for visiting BigCosmicData!")



    //                    firstHiveQuery2.groupBy("DatePurchased", "Country").sum("ProductPrice").sort($"sum(ProductPrice)".desc).show()

//                    schemaPeople.printSchema()
//                    schemaPeople.createOrReplaceTempView("people")
//                  val firstHiveQuery2 = spark.sql("SELECT SUM(ProductPrice) AS Price,DatePurchased,Country FROM people GROUP BY DatePurchased,Country ")
//                    firstHiveQuery2.show(10)
//                      //vegas query
//                    val plot = Vegas("HighestTrafficPerCountries").
//                      withDataFrame(firstHiveQuery2.toDF()).
//
//                      encodeX("Country", Nom).
//                      encodeY("Price", Quant).
//                      mark(Bar)
//                      .encodeColor("Country",Nominal)
//                    plot.show





//    schemaPeople.printSchema()
//    schemaPeople.createOrReplaceTempView("people")
//    val PopularProducts1 = spark.sql("SELECT SUM(Qty)AS Qty, ProductName, Country FROM people WHERE DatePurchased LIKE '2022%' GROUP BY Country,ProductName ")
//    PopularProducts1.show(100)
//    //vegas code below
//    val plot = Vegas("maxSalesPerCountry").
//      withDataFrame(PopularProducts1.toDF()).
//
//      encodeX("ProductName", Nom).
//      encodeY("Qty", Quant).
//      mark(Bar)
//      .encodeColor("Country",Nominal)
//    plot.show



    spark.stop()
  }



}