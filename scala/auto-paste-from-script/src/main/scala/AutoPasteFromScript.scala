/* To automate pasting and executing in scala REPL
 */

package auto.paste.from.script

import scala.io.Source

import scala.tools.nsc.interpreter.IMain 

case class AutoPasteFromScript(filePath : String,
  interpreter : IMain ) {

  // everytime we reload the file
  def reload  = Source.fromFile(filePath).getLines.
    toList

  /* we format the file to a string
   * note how we add linebreaks
   */

  def toString(min: Int, max: Int) : String = {
    val lFile = this.reload.
      map(_ + "\n")

    lFile.slice(min-1, max).reduce( _ + _)

  }

  def print(min : Int, max : Int) : Unit = {
   
    println(this.toString(min, max))
  }

  // We execute accessing the interpreter
  def exec(min: Int, max: Int) : Unit = {

    val lFile = this.reload
    interpreter.interpret(toString(min,max))
  }

  // convenience method
  def apply(min: Int, max: Int) : Unit = exec(min, max)

}
