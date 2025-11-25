pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    stages {

        stage('Checkout from GitHub') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Shruti21091995/BDD-Cucumber-Complete-Automation-Framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Option 1: Run with testng.xml (all runners)
                bat 'mvn clean test'
                
                // Option 2: Run specific suite
                // bat 'mvn clean test -DsuiteXmlFile=master_suite.xml'
                
                // Option 3: Run parallel suite
                // bat 'mvn clean test -DsuiteXmlFile=parallel_suit.xml'
                
                // Option 4: Run cross-browser suite
                // bat 'mvn clean test -DsuiteXmlFile=Cross_Browser.xml'
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    allure includeProperties: false,
                           jdk: '',
                           results: [[ path: 'target/allure-results' ]]
                }
            }
        }
    }

    post {
        always {
            echo "Publishing test results"
            // Publish TestNG results
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
            
            // Publish Cucumber reports
            junit allowEmptyResults: true, testResults: '**/target/cucumber-reports/*.xml'
        }
        success {
            echo "Build succeeded!"
        }
        failure {
            echo "Build failed!"
        }
    }
}
