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
                bat 'mvn clean test -Dsurefire.suiteXmlFiles=testng.xml'
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
        echo "Publishing JUnit results"
        junit 'target/cucumber-reports/*.xml'
    }
}
}
