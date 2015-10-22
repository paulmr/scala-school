import scala.io.Source

object Main extends App {

  def insertComponent = ???

  val insertRegex = """^\s*<!-- TEMPLATE -->"""

  val template = Source.fromFile("template.html").getLines

  template foreach { line =>
    if(line.matches(insertRegex))
      println("[ insertComponent ]")
    else
      println(line)
  }

}
