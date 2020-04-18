pipeline{
    agent any
    stages{
      steps {
        sh 'mvn clean'
      }
    }
    stage('Test') {
      steps{
        sh 'mvn test'
      }
    }
post{
always{
  script{
        allure([
          includeProperties: false,
          jdk:'',
          properties:[],
          reportBuildPolicy:'ALWAYS',
          results: [[path: 'target/allure-results']]
        ])

      }
    }
  }
}