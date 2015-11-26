package desugar

object Main extends App {
  val parent = List(List(1,2), List(3,4,5))
  val changed =
    for {
      sublist <- parent
      item    <- sublist
    } yield {
      s"Item: $item"
    }
}
