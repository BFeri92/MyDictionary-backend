#!groovy

node {
   def mvnHome
   stage('Checkout') {
      checkout scm
   }
   stage('Build') {
        withMaven() {
            sh 'mvn clean package -Pintegration'
        }
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
   }
   stage('Deploy') {
        sh 'cp $(find $JENKINS_HOME/jobs/$JOB_BASE_NAME/builds/$BUILD_ID/archive -name "*.war") /var/mydictionary-ci/mydictionary-backend/mydictionary-backend.war && sudo /etc/init.d/mydictionary-backend-ci restart'
   }
}
