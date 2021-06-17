pipeline {
    agent any 
    stages {
        stage('Initialize') { 
            steps {
              withMaven(maven : 'apache-maven-3.6.1') {
              bat'mvn clean compile'
              }
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
