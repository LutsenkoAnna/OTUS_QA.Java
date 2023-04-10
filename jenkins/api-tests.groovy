timeout(60) {
    node('maven-slave') {
        stage('Checkout') {
            checkout scm
        }
        stage('Running API autotest') {
            sh "mvn test"
        }
    }
}