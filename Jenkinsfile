/*pipeline {
    agent { label 'windows' }   // runs on a Windows agent; use 'any' if Linux is fine

    environment {
        BASE_URL     = "https://dev.onion.gnapitech.org"
        CONTROLS_URL = "https://chandu0609.github.io/SeleniumAllControlsRepo/Selenium_Practice.html"
        BROWSER      = "chrome"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/chandraalahari/PowerfulProjectTestNG.git',
                    credentialsId: 'github-cred'
            }
        }

        stage('Set up JDK 17') {
            steps {
                echo "Using JDK 17 (ensure Jenkins tool configuration has JDK17 installed)"
                // If you have JDK configured in Jenkins tools:
                // tool name must match Jenkins global tool config
                // def javaHome = tool name: 'jdk17', type: 'jdk'
                // env.JAVA_HOME = "${javaHome}"
                // PATH+JAVA="${javaHome}/bin"
            }
        }

        stage('Build with Maven TestNG (headless)') {
            steps {
                dir("${WORKSPACE}") {
                    bat """
                        mvn verify -Dheadless=true -DBaseurl=%BASE_URL% -DBrowser=%BROWSER%
                    """
                }
            }
            post {
                always {
                    echo "Maven test execution completed (success or fail)."
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                bat 'mvn allure:report'
            }
        }

        stage('List target directory') {
            steps {
                bat 'dir target /s'
            }
        }

        stage('Archive Extent Report') {
            steps {
                archiveArtifacts artifacts: 'reports/ExtentReport.html', allowEmptyArchive: true
            }
        }

        stage('Archive Allure Results') {
            steps {
                archiveArtifacts artifacts: 'target/allure-results*', allowEmptyArchive: true
            }
        }

        stage('Publish Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }

        stage('Archive Allure HTML') {
            steps {
                archiveArtifacts artifacts: 'target/allure-report*', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo "Pipeline finished (success or failure)."
        }
        success {
            echo "✅ All stages completed successfully!"
        }
        failure {
            echo "❌ One or more stages failed — check logs and reports."
        }
    }
}
*/

pipeline {
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
}