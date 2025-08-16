pipeline {
    agent any //{ label 'windows' } // or just "any" if no windows agent configured

    environment {
        BASE_URL      = 'https://dev.onion.gnapitech.org'
        CONTROLS_URL  = 'https://chandu0609.github.io/SeleniumAllControlsRepo/Selenium_Practice.html'
        BROWSER       = 'chrome'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Set up JDK 17') {
            steps {
                echo "Setting up JDK 17"
                // Jenkins must have JDK installed or use a tool config
                tool name: 'jdk17', type: 'jdk'
            }
        }

        stage('Build with Maven TestNG (headless)') {
            steps {
                echo "Running Maven tests"
                bat """
                    mvn clean verify -Dheadless=true -DBaseurl=%BASE_URL% -DBrowser=%BROWSER%
                """
            }
        }

        stage('Generate Allure Report') {
            steps {
                echo "Generating Allure report"
                bat "mvn allure:report"
            }
        }

        stage('Archive Reports') {
            steps {
                echo "Archiving Extent and Allure reports"
                archiveArtifacts artifacts: 'reports/ExtentReport.html', allowEmptyArchive: true
                archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true
                archiveArtifacts artifacts: 'target/allure-report/**', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo "Pipeline finished. Reports archived."
        }
    }
}


/*pipeline {
    agent any
    stages {
        stage('Hello') {
            steps {
                echo "✅ Jenkinsfile detected correctly"
            }
        }
        stage('Build') {
            steps {
                echo "Running build..."
            }
        }
    }
}*/
