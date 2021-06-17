pipeline {
    agent any 
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk11'
    }
    stages {
        stage('Initialize') { 
            steps {
               bat'mvn clean compile'
            }
        }
        stage('Build') { 
            steps {
              echo 'Build'
            }
        }
        stage('Test') { 
            steps {
                echo 'test'
            }
        }
        stage('Deploy') { 
            steps {
               echo 'Deploy'
            }
        }
    }
}
