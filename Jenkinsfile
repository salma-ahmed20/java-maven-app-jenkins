/*def gv

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage("init") {
            steps {
                script {
                   gv = load "script.groovy"
                }
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("deploy") {
            // input{
            //     message "Select Environment"
            //     ok "Done"
            //     parameters{
            //         choice(name: 'ENV', choices: ['dev', 'prod', 'stage'], description: '')
            //     }
            // }
            steps {
                script {
                    env.ENV = input message: "Select Environment",ok: Done,
                    parameters:[choice(name: 'ENV', choices: ['dev', 'prod', 'stage'], description: '')]
                    gv.deployApp()
                    echo "deploying to ${env.ENV}"
                }
            }
        }
    }
}
*/

pipeline {
    agent any
    tools {
        maven 'maven-3.9.1'
    }
    stages {
        stage('Buils jar') {
            steps {
                script {
                    echo 'Building the application'
                    sh 'mvn package'
                }
            }
        }
        stage('Build docker image') {
            steps {
                script {
                    echo 'Building docker image'
                    withCredentials([usernamePassword(credetialsId:'dockerhub-repo', passwordVariable:'PASS', usernameVariable:'USER')]){
                        sh 'docker build -t salma101/java-maven-app:jma-2.0 .'
                        sh "echo $PASS| docker login -u $USER --password-stdin"
                        sh 'docker push salma101/java-maven-app:jma-2.0'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying the application'
                }
            }
        }
    }
}
