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
