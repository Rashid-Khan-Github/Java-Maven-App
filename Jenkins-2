
pipeline{
    agent any

    stages{

        stage("Testing"){
            steps{
                script{
                    echo "Testing the application"
                    echo "Executing pipeline for branch $BRANCH_NAME"
                }
            }
        }

        stage("Build "){
            when{
                    expression{
                        BRANCH_NAME == "master"
                    }
                }

            steps{
                script{
                    echo "Building the application"
                }
            }
        }
        
        stage("Deploy"){
            when{
                    expression{
                        BRANCH_NAME == "master"
                    }
                }
            steps{
                script{
                    echo "Deploying the Application"
                }
            }
        }
    }
}
