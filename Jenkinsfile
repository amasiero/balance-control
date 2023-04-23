pipeline {
    agent any
    tools {
        jdk 'openjdk-17'
    }
    stages {
        stage('test') {
            steps {
                echo 'Testing the application'
                withGradle() {
                    sh './gradlew test'
                }
            }
        }

        stage('build') {
            steps {
                echo '### Building the application ###'
                withGradle() {
                    sh './gradlew bootJar'
                }
            }
        }



        stage('deploy') {
            steps {
                echo 'deploying...'
            }
        }
    }
}