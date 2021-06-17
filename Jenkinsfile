pipeline {
    agent any 
    stages {
        stage('Initialize') { 
            steps {
              echo '${PATH}'
                echo '${M2_HOME}'
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
