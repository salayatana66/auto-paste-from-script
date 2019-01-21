######################################################
# interactiveScript is a reference class
# to interactively execute code from fileName
# 
# instantiate interactiveScript from a file name:
# myS = AutoPasteFromScript$new(fileName=" ")
#
# execute code in lines [a,b]:
# myS$exec(a,b)
######################################################

AutoPasteFromScript <- setRefClass("AutoPasteFromScript",
                                 fields = list(fileName = "character", lines = "character"),
 methods = list(
     load = function() {
         # sep says lines are terminated by \n
         # blank lines will be read
         lines <<- scan(fileName, what = character(), quiet=TRUE, sep = "\n",
                        blank.lines.skip = FALSE)
     },
     
     toString = function(min, max) {
         load()

         # we paste an addintional \n
         pasted <- paste0(paste0(lines[c(min:max)], collapse = "\n"),"\n")
         pasted
     },

     print = function(min, max) {

         string <- toString(min, max)
         cat(string)
     },

     exec = function(min, max) {

         # we need to execute the expression in the global environment
         # otherwise it will evaluate in a local environment
         eval(parse(text=toString(min,max)), env = globalenv())
         }
 )
 )
                                     
