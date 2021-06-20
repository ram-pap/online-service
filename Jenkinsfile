
pipeline{

	agent any
	
	stages{
	

	        steage('Initializing'){
			 steps{
				 echo '${PATH}'
				 echo '${M2_HOME'}
			 }
		 }
		stage('build'){
			steps{
				echo 'Building'
			}
			
		}
		stage('test'){
			steps{
				echo 'testing'
			}
			
		}
		stage('publish'){
			steps{
				echo 'publishing'
			}
			
		}
		stage('deploy'){
			steps{
				echo 'deploy'
			}
			
		}
		
	    }
}

		}	
	}
}
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
        stage('Deploy') { 
            steps {
               bat 'mvn deploy'
            }
        }
    }
}

