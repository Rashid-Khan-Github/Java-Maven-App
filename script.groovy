def buildJAR(){
    echo "Building Jar file"
    sh 'mvn clean package'

}
def buildImage(){
    echo "building the docker image.."
    withCredentials([usernamePassword(credentialsId: 'My-Docker-Hub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t dockerjackal/java-maven-app:JMA-2.0'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push dockerjackal/java-maven-app:JMA-2.0 .'
    }
}
def deployApp(){
    echo "Deploying the Builded Application with version ${VERSION}"
}
return this