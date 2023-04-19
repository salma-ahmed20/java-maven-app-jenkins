// #!/usr/bin/env groovy

// @Library('jenkins-shared-library')
// def gv

// pipeline {
//     agent any
//     tools {
//         maven 'maven-3.9.1'
//     }
//     stages {
//         stage('init') {
//             steps {
//                 script {
//                     gv = load 'script.groovy'
//                 }
//             }
//         }
//         stage('Buils jar') {
//             steps {
//                 script {
//                     buildJar()
//                 }
//             }
//         }
//         stage('Build and pushdocker image') {
//             steps {
//                 script {
//                     buildImage 'java-maven-app:jma-5.0'
//                     dockerLogin()
//                     pushImage 'java-maven-app:jma-5.0'
//                 }
//             }
//         }
//         stage('Deploy') {
//             steps {
//                 script {
//                     gv.deployApp()
//                 }
//             }
//         }
//     }
// }

def gv

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
        // stage("build") {
        //     steps {
        //         script {
        //             gv.buildJar()
        //         }
        //     }
        // }
        // stage("test") {
        //     when {
        //         expression {
        //             params.executeTests
        //         }
        //     }
        //     steps {
        //         script {
        //             gv.testApp()
        //         }
        //     }
        // }
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
                    env.DeploymentEnv = input message: "Select Environment",
                    parameters:[choice(name: 'DeploymentEnv', choices: ['dev', 'prod', 'stage'], description: '')]
                    gv.deployApp()
                    echo "deploying to ${DeploymentEnv}"
                }
            }
        }
    }
}