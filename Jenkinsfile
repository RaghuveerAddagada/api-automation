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
                always {
                    archiveArtifacts allowEmptyArchive: true, artifacts: 'test-output/*', followSymlinks: false
                    junit allowEmptyResults: true, skipMarkingBuildUnstable: true, skipOldReports: true, skipPublishingChecks: true, testResults: '*.xml'
                }
            }
        }
    }
}