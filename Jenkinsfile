pipeline {
    agent any 
    tools {
        maven 'maven'
    }
    stages {
        stage('Initialize') { 
            steps {
               bat'mvn clean compile'
            }
        }
        stage('Build') { 
            steps {
              bat 'mvn build'
            }
        }
        stage('Test') { 
            steps {
                bat 'mvn test'
            }
        }
        stage('Deploy') { 
            steps {
               bat 'mvn package'
            }
        }
    }
}
