import setuptools
from pathlib import Path

with open(Path("../README.md").resolve(), "r") as fh:
    long_description = fh.read()

setuptools.setup(
    name='auto_paste_from_script',  
    version='1.0',
    author="Andrea Schioppa",
    author_email="andrej.schioppa@gmail.com",
    description="Package to execute lines from scripts into Python interpreters",
    long_description=long_description,
    long_description_content_type="text/markdown",
    url="https://github.com/salayatana66/auto-paste-from-script",
    packages=setuptools.find_packages(),
    classifiers=[
         "Programming Language :: Python :: 3",
         "License :: OSI Approved :: MIT License",
         "Operating System :: OS Independent",
     ],
)
