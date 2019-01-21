"""
Contains a class to interactively paste
scripts into a Python Interpreter
"""

import inspect

class AutoPasteFromScript(object): # pylint: disable=too-few-public-methods
    """ Class to interactively paste
        scripts into an interpreter

        Everytime the file gets reloaded;

        The object is callable:
        ``` myS(m, h) '''
        executes codes in lines [m,h]
    """

    def __init__(self, script_file):
        """
        Args:
            script_file: string
        """

        self.script_file = script_file
        self.__reload__()

    def __reload__(self):
        """
        reloads the content of script_file
        """

        ffile = open(self.script_file, "r")

        self.lines = [l for l in ffile.readlines()]
        ffile.close()

        return None

    def to_string(self, low, high):
        """
        convert lines [low, high]
        to a string
        """

        return ''.join(self.lines[(low-1):high])

    def __call__(self, low, high):
        """
        Execute code in [low,high]
        """

        # reload contents of file
        self.__reload__()

        sstring = self.to_string(low, high)

        # get dictionary of variables, etc...
        # in the caller scope
        outer_globals = inspect.currentframe()\
                        .f_back.f_globals

        exec(sstring, outer_globals) # pylint: disable=exec-used
