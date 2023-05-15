#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'Maven-3.6'
    }

    stages {

        stage("Version Increment") {
            steps {
                script {
                    echo 'Incrementing the version...'
                    sh 'mvn build-helper:parse-version versions:set \
                    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                     versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }

        stage("Testing") {
            steps {
                script {
                    echo "Testing the application"
                    echo "Executing pipeline for branch ${BRANCH_NAME}"
                }
            }
        }

        stage("Build ") {
            steps {
                script {
                    echo "Building the application"
                    echo "mvn clean package"
                }
            }
        }
        stage("Building Docker Image") {
            steps {
                script {
                    echo "building the docker image.."
                    withCredentials([usernamePassword(credentialsId: 'My-Docker-Hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t dockerjackal/java-maven-app:${IMAGE_NAME} ."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push dockerjackal/java-maven-app:${IMAGE_NAME}"
                    }
                }
            }

            stage("Deploy") {

                steps {
                    script {
                        echo "Deploying the Application"
                    }
                }
            }
        }
    }
}