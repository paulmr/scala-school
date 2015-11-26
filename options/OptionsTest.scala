case class Dog(name: String)

case class Cage(contents: Dog)

object Dog {

  /* input is like this: "Dog: Fido" */

  def deserialiseDog(input: String): Option[Dog] = {
    val DogPattern = "Dog:\\s*([A-Za-z]+)".r
    input match {
      case DogPattern(name) => Some(Dog(name))
      case _ => None
    }
  }
}

object Main extends App {

  def f(o: Option[Dog]) =
    o foreach { d =>
      println(d.name)
    }

  f(Dog.deserialiseDog("Dog: Fido"))

  f(Dog.deserialiseDog("Dog:"))

}
