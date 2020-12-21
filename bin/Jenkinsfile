pipeline {
    agent any

    stages {
        stage('clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('deploy'){
        	steps{
        		sh 'cp /home/ec2-user/.jenkins/workspace/BarkerBackend/target/barker.war /home/ec2-user/apache-tomcat-8.5.61/webapps'
        	}
        }
    }
}
