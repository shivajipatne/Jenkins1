#this is the base image we use to create our image from
FROM jenkins/jenkins:lts-alpine
#get rid of admin password setup
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
ENV JANKINS_HOME /var/jenkins_home
ENV JAVA_HOME /var/jenkins_home/jdk*
ENV M2_HOME /var/jenkins_home/maven*
#automatically installing all plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

