#!/bin/bash
wget --no-cookies --no-check-certificate --header "Cookie: oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-linux-x64.tar.gz"
tar -xvf jdk-8u171-linux-x64.tar.gz 
rm -rf jdk-8u171-linux-x64.tar.gz
mv jdk1* jdk
echo export  PATH=${JAVA_HOME}/bin:$PATH >> ~/.bashrc

