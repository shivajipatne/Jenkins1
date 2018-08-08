#! groovy
import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*

println("Setting credentials")
def domain = Domain.global()
def store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

def user = new File("/run/secrets/jenkins-user").text.trim()
def pass = new File("/run/secrets/jenkins-pass").text.trim()

def credentials=['username':'user', 'password':'pass', 'description':'Irtifactory OSS Credentials']
def user = new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL, credentials.description, credentials.username, credentials.password)
store.addCredentials(domain, user)
