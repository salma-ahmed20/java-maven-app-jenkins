// def gv

pipeline {
    agent any
        parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }

    stages {
        // stage("init") {
        //     steps {
        //         script {
        //             gv = load "script.groovy"
        //         }
        //     }
        // }
        stage("build") {
            steps {
                script {
                    echo "building jar"
                    //gv.buildJar()
                }
            }
        }
        // stage("build image") {
        //     steps {
        //         script {
        //             echo "building image"
        //             //gv.buildImage()
        //         }
        //     }
        // }
            stage('test') {
                when{
                    expression{
                        params.executeTests
                    }
                }
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    echo "deploying Version ${params.VERSION}"

                    //gv.deployApp()
                }
            }
        }
    }   
}