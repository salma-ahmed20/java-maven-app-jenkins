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
        stage('Buils jar') {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage('Build docker image') {
            steps {
                script {
                    buildImage 'java-maven-app:jma-4.0'
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