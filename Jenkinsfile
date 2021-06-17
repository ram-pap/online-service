pipeline {
    agent any 
    tools {
        maven 'Maven_3.5.2' 
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
