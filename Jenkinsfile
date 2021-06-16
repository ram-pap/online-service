pipeline
 {
  agent any

  tools
   {
    maven "Maven3"
    jdk "JDK11"
   }

  options
   {
    buildDiscarder(logRotator(numToKeepStr: '4'))
    skipStagesAfterUnstable()
    disableConcurrentBuilds()
   }


  triggers
   {
    // MINUTE HOUR DOM MONTH DOW
    pollSCM('H 6-18/4 * * 1-5')
   }
	 stages{
		 steage('Initializing'){
			 steps{
				 echo '${PATH}'
				 echo '${M2_HOME'}
			 }
		 }
	 }
}
