pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
               git branch:"marwan", url:"https://github.com/mahdichaffai/ciTimesheet.git"; 
            }
        }

       stage("Build") {
           steps {
                bat "mvn -version"
                bat "mvn clean install"
            }
            post {
            success {
               jacoco()
            }
           }
           
        }
       stage("Sonar") {
        steps {
           bat "mvn sonar:sonar"
         }
       }
       stage("nexus") {
        steps {
           bat "mvn deploy -Dmaven.test.skip"
         }
       }
       
       stage ('Email Notification') {
        steps {
           mail bcc: '', body: 'your pipeline is building', cc: '', from: '', replyTo: '', subject: 'Build', to: 'benabdelkader.marwan@gmail.com'
         }
      }
    
   }   
}
