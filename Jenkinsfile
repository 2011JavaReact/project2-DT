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
        		sh sh 'cp /home/ec2-user/.jenkins/workspace/BarkerBackend/target/Barker-api.war /home/ec2-user/apache-tomcat-9.0.41/webapps'
        	}
        }
    }
}
