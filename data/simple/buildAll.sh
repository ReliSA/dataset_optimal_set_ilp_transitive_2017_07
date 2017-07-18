#!/usr/bin/env bash

rm -r ./out
mkdir ./out

#build simple-1-0
cd ./simple-1-0
mvn install
cp target/simple-1-1.0.0.jar ../out
cd ../

#build simple-1-1
cd ./simple-1-1
mvn install
cp target/simple-1-1.1.0.jar ../out
cd ../

#build simple-2-0
cd ./simple-2-0
mvn install
cp target/simple-2-1.0.0.jar ../out
cd ../

#build simple-2-1
cd ./simple-2-1
mvn install
cp target/simple-2-1.0.1.jar ../out
cd ../

#build simple-2-2
cd ./simple-2-2
mvn install
cp target/simple-2-1.1.0.jar ../out
cd ../
