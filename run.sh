#!/usr/bin/env bash

mkdir -p build
javac -d build -cp src src/*.java
java -cp build/ Main $1 $2