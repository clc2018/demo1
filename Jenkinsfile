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
        }
      }
    }
    stage('Second stage') {
      steps {
        container('s2i') {
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
