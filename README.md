# auto-paste-from-script #
 
Utilities for interactively pasting script code into an interpreter.
Currently supports Python, R, Scala.

## Python Usage ##

``` python
from auto_paste_from_script import AutoPasteFromScript

myS = AutoPasteFromScript("script.py")

myS(5,10)
```

## R Usage ##

``` r
source("AutoPasteFromScript.R")

myS <- AutoPasteFromScript$new(fileName="this.R")

myS$exec(1,5)
```

## Scala Usage ##

``` scala

import auto.paste.from.script.AutoPasteFromScript

// $intp is the current interpreter
val myS = AutoPasteFromScript("filename.scala", $intp)

myS(1,5)
```

