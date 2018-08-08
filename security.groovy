#!groovy

import jenkins.model.*
import hudson.model.*
import Jenkins.security.s2m.AdminWhitlistRule
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*

def instance = new getInstance()
def domain = Domain.global()
def store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

def user = new File("/run/secrets/jenkins-user").text.trim()
def pass = new File("/run/secrets/jenkins-pass").text.trim()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(user, pass)
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)
instance.save()

def credentials=['username':'user', 'password':'pass', 'description':'Irtifactory OSS Credentials']
def user = new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL, credentials.description, credentials.username, credentials.password)
store.addCredentials(domain, user)


Jenkins.instance.getInjector().getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)

