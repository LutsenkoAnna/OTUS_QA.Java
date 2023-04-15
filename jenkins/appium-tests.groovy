timeout(60) {
    node('maven-slave') {
        stage('Checkout') {
            checkout scm
        }
        stage('Running API autotest') {
            sh "mvn test"
        }
        stage('Publisher allure report') {
            allure([
                    includeProperties: false,
                    jdk              : '',
                    properties       : [],
                    reportBuildPolicy: 'ALWAYS',
                    results          : [[path: 'allure-results']]
            ])
        }
    }
}