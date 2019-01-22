#
#  Copyright 2019 Andrea Schioppa
#
# Licensed under the Apache License, Version 2.0 (the "License")
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

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

