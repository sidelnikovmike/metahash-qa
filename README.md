# Metahash QA

This repository contains code for automation testing for `Metahash` project.

Main modules:
* Web tests - contains web tests for product
* Selenoid - some files for selenoid
* Core - base classes and utilities to use them in code

More description you could find in modules readme files

## Requirements to run code

* maven - version 3.3.9 or more
* java - version 8
* to run selenoid - docker and docker-compose

## Build all code

To build all code use command:

    mvn clean install -Dmaven.test.skip=true


End.
