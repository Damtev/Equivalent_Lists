#!/usr/bin/env bash

mkdir -p build
javac -d build -cp .:lib/* $(find . -name "*.java")
java -cp build:lib/* org.junit.runner.JUnitCore Tester