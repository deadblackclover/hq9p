package hq9p

import scala.io.Source

object Main extends App {
  if (args.length == 0) {
    println("Unknown file!")
  } else {
    val file = Source.fromFile(args(0))
    val acc = for (line <- file.getLines()) yield {
      line match {
        case "H" => println("Hello, world!")
        case "Q" =>
          val source = Source.fromFile(args(0))
          println(source.getLines().mkString("\r\n"))
          source.close()
        case "9" =>
          for (i <- (1 to 99).reverse) {
            println(s"$i bottles of beer on the wall,")
            println(s"$i bottles of beer.")
            println("Take one down, pass it around,")
            println(s"${i - 1} bottles of beer on the wall.")
          }
        case "+" => "+"
      }
    }
    println("Accumulator value:" + acc.count(x => x == "+"))
    file.close()
  }
}
