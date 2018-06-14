#!/bin/bash
wget https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.5.0/apache-maven-3.5.0-bin.tar.gz
tar -xvf apache-maven-3.5.0-bin.tar.gz
rm -rf apache-maven-3.5.0-bin.tar.gz
mv apache-* maven
echo export PATH=${M2_HOME}/bin:$PATH >> ~/.bashrc

