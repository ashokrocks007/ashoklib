def call(ip,user,credid) {
sshagent([credid]) {
// rename file
sh "mv target/myweb*.war target/app.war"
//copy war
sh "scp -o StrictHostKeyChecking=no target/app.war ${user}@${ip}:/opt/tomcat10/webapps "
//start and stop tomcat
sh "ssh ${user}@${ip} /opt/tomcat10/bin/shutdown.sh"
sh "ssh ${user}@${ip} /opt/tomcat10/bin/startup.sh"
}
}
