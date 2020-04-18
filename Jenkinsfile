pipeline{
    agent any
    stages{
        stage('Clean Test'){
            steps{
                bat 'mvn clean test'
            }
        }
    }
post {
        always {
            script {
                allure([includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']]
                ])
            }
        }
    }