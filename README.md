# Workshop JSR 375

During this workshop we will 

## Requirements
These applications are provided on a USB stick during the workshop.

- Java 8 SDK, tested with version 1.8.0_121
- IDE of your choice(Intellij, Netbeans and Eclipse are tested but project is ran via command line)
- Maven, tested with version 3.3.9
- Wildfly
- OWASP ZAP for automated testing

## Installing Java
- Download latest version at [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- brew update; brewtap caskroom/cask; brew cask install java


## Installing Wildfly
- Download the latest version of wildfly at: [http://wildfly.org/downloads](http://wildfly.org/downloads)
- brew install wildfly-as

After installing, start the server and make sure it’s started by viewing [http://localhost:9990](http://localhost:9990)
When the server is running, try to add a user via command line(installed path/bin/add-user.sh).
After logging in with the user, wildfly is ready to be used in Netbeans and Intellij, for Eclipse JBoss Tools needs to be installed.

## Installing OWASP ZAP
- Download the latest version at [OWASP](https://www.owasp.org/index.php/OWASP_Zed_Attack_Proxy_Project)
- brew cask install owasp-zap

## Exercises


### Exercise 1, implementing security API
In the master branch of the repository is a shell for implementing the security API. You can use this as a starting point to implement the following parts:
- Embedded autentication using EmbeddedIdentityStoreDefinition
- Custom HttpAuthenticationMechanism
- Custom Identity store

The solutions for these implementations are in the solution branch.

### Exercise 2, testing using OWASP
After finishing the first exercise, try using OWASP ZAP to find an exploit in the finished application
(need to be expanded)

### Exercise 3, implementing new features 

