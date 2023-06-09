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