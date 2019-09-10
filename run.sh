#!/usr/bin/env bash

mkdir build
javac -d build -cp src src/*.java
java -cp build/ Main $1 $2
rm -rf build