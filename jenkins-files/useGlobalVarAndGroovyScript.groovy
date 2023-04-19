def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9.1'
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage('Buils jar') {
            when{
                expression{
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        // stage('Build docker image') {
        //     steps {
        //         script {
        //             gv.buildImage()
        //         }
        //     }
        // }
        stage('Deploy') {
             when{
                expression{
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.deployApp
                }
            }
        }
    }
}
