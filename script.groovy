
def buildApp() {
    echo 'building the application from groovy...'
} 

def testApp() {
    echo 'testing the application from groovy...'
} 

def deployApp() {
    echo 'deplying the application from groovy...'
    echo "deploying version ${params.VERSION}"
} 

return this
