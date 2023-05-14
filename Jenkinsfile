#!/usr/bin/env groovy
@Library('jenkins-shared-library')
def gv

pipeline{
    agent any
    tools{
        maven 'Maven-3.6'
    }
    stages{

        stage("Initializing the Groovy Script file.."){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }

        stage("Testing"){
            steps{
                script{
                    echo "Testing the application"
                    echo "Executing pipeline for branch $BRANCH_NAME"
                }
            }
        }

        stage("Building JAR "){
            steps{
                script{
                    buildJar()
                }
            }
        }
        stage("Building Image"){
            steps{
                script{
                    buildImage()
                }
            }
        }
        stage("Deploying the Application..."){
            steps{
                script{
                    gv.deployApp()
                }
            }
        }
    }
}
