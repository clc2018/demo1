pipeline {
    agent {
      label "jenkins-s2i"
    }
    environment {
      ORG               = 'jenkinsx-pw1'
      APP_NAME          = 'demo1'
      BRANCH_NAME       = "$GIT_BRANCH".replaceAll('^origin/','')
      REV               = "$GIT_COMMIT".trim().take(7)
      RELEASE_VERSION   = "$BRANCH_NAME-$BUILD_NUMBER-$REV"
      RELEASE_NAMESPACE = "$APP_NAME-$BRANCH_NAME".toLowerCase()
      IMAGE_NAME        = "$DOCKER_REGISTRY/$ORG/$APP_NAME"
    }
    stages {
      stage('First stage') {
        steps {
          container('s2i') {
            sh "s2i build . fabric8/s2i-java:3.0-java8 $IMAGE_NAME:$RELEASE_VERSION"
            sh "docker push $IMAGE_NAME:$RELEASE_VERSION"
          }

        }
      }
      stage('Second stage') {
        steps {
          container('s2i') {
            dir("charts/$APP_NAME") {
              sh "make version"
              sh "helm upgrade --install --wait --namespace $RELEASE_NAMESPACE $APP_NAME ."
            }
          }
        }
      }
    }
    post {
        always {
            cleanWs()
        }
    }
  }
