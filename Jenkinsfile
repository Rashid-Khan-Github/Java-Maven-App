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
        stage("Building JAR "){
            steps{
                script{
                    gv.buildJAR()
                }
            }
        }
        stage("Building Image"){
            steps{
                script{
                    gv.buildImage()
                }
            }
        }
        stage("Deploying the Application..."){
            steps{
                script{
                    gv.buildImage()
                }
            }
        }
    }
}