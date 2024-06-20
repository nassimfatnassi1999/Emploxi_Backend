pipeline {
    agent any
    tools {
        jdk 'JAVA_HOME'
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    def gitStatus = sh(script: 'git ls-remote https://github.com/nassimfatnassi1999/Emploxi_Backend.git', returnStatus: true)
                    if (gitStatus != 0) {
                        error("Failed to access Git repository")
                    }
                }
                git branch: 'main', url: 'https://github.com/nassimfatnassi1999/Emploxi_Backend.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
    }
}
