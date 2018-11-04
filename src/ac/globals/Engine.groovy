package ac.globals

import groovy.json.JsonSlurperClassic

class Engine implements Serializable {
  def script
  Engine(script) {
    this.script = script
  }
  
  def Checkout() {
    script.node {
      script.stage('Checkout') {
        script.checkout script.scm
      }
    }
  }
  
  def RunStepsInDockerImage(image, steps) {
    script.dir('temp') {
      script.sh 'pwd'
      script.sh 'ls'
    }
    script.node {
      script.stage('DockerBuild') {
        script.docker.image(image).inside('-u root') {
          steps()
        }
      }
    }
  }

  def BuildDockerFile() {
    script.node {
      script.stage('Build Docker File') {
        def image = script.docker.build("adriancheong/${script.env.JOB_NAME}:${script.env.BUILD_NUMBER}".toLowerCase())
      }
    }
  }
  
  def Test() {
  }
  
  def Scan() {
  }
  
  def Publish() {
  }
}
