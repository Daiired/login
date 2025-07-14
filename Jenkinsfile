pipeline {
    agent any
    tools {
        maven 'Maven3'  // nombre en Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Daiired/login.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Archive WAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true
            }
        }
    }
}