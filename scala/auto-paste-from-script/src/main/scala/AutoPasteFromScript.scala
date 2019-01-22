/*
 * Copyright 2019 Andrea Schioppa
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

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
