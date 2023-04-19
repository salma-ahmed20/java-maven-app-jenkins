
def incrementVersion(){
    echo 'incrementing app version...'
    sh 'mvn build-helper:parse-version versions:set \
       -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
        versions:commit'
    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
    def version = matcher[0][1]
    VERSION_NUMBER = "$version-$BUILD_NUMBER"
}

def deployApp() {
    echo 'deploying the application...'
}

def commitChanges(){
    script.withCredentials([script.usernamePassword(credentialsId: 'github-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'git config --global user.email "salma.ahmed0075@gmail.com"'
        sh 'git config --global user.name "salma"'

        sh 'git status'
        sh 'git branch'
        sh 'git config --list'

        sh "git remote set-url origin https://${USER}:${PASS}@github.com/salma-ahmed20/java-maven-app-jenkins.git"
        sh 'git add .'
        sh 'git commit -m "ci: version bump"'
        sh 'git push origin head:jenkins-shared-library'
    }
}

return this

