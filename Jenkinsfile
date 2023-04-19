#!/usr/bin/env groovy

@Library('jenkins-shared-library')
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
        stage('increment version') {
            steps {
                script {
                    gv.incrementVersion()
                }
            }
        }
        stage('Buils jar') {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage('Build and pushdocker image') {
            steps {
                script {
                    buildImage "java-maven-app:${VERSION_NUMBER}"
                    dockerLogin()
                    pushImage "java-maven-app:${VERSION_NUMBER}"
                }
            }
        }
       
        stage('Deploy') {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}

