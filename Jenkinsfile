pipeline {
    agent any

    options {
        timeout(time: 10, unit: 'MINUTES')
    }

    tools {
        maven '3.9.3'
    }

    stages {

        stage('Execution Time') {
            steps {
                sh "mvn clean test -DsuiteXmlFile=testNGsuite/sample.xml"
            }

            post {
                success {
                    archiveArtifacts artifacts: '*test-output/.html', followSymlinks: false

                }
                always {
                    junit allowEmptyResults: true, skipMarkingBuildUnstable: true, skipOldReports: true, skipPublishingChecks: true, testResults: '*/*.xml'
                }
            }
        }
    }
}