import scala.io.Source

object Main extends App {

  abstract class Component {
    def toHTML: String
  }

  case class Paragraph(text: String) extends Component {
    def toHTML = s"<p>$text</p>"
//    override def toString =
  }

  case class Image(src: String) extends Component {
    def toHTML = s"<img>$src</img>"
  }

  def insertComponent(component: Component) = {
    val c = component match {
      case p @ Paragraph(t) => p.copy(text = s"Text: $t")
      case _ => component
    }
    println(c.toHTML)
  }

  val insertRegex = """^\s*<!-- TEMPLATE -->"""

  val template = Source.fromFile("template.html").getLines

  val component1 = Paragraph("Hello")
  val component2 = Image("cat.img")

  template foreach { line =>
    if(line.matches(insertRegex)) {
      insertComponent(component1)
      insertComponent(component2)
      //println("[ insertComponent ]")
    } else {
      println(line)
    }
  }

}
