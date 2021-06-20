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
              bat 'mvn install'
            }
        }
        stage('Test') { 
            steps {
                bat 'mvn test'
            }
        }
        
    }
}

