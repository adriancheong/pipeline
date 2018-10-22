package ac.globals

import groovy.json.JsonSlurperClassic

class Engine implements Serializable {
  def script
  Engine(script) {
    this.script = script
  }
    
  def RunFunc(func) {
    script.node {
      func()
    }
  }
  
  def Hello() {
    script.node {
    script.sh 'echo Hello!'
    }
  }
  
  def Checkout() {
    script.node {
      script.stage('Checkout') {
        script.checkout script.scm
      }
    }
  }
  
  def DockerBuild(image, steps) {
    script.node {
      script.docker.image(image).inside('-u root') {
        steps()
      }
    }
  }
      //      script.docker.image(image).inside('-u root') {
  //      script.node {
    //      steps()
      //  }
      //}


  def Test() {
  }
  
  def Scan() {
  }
  
  def Publish() {
  }
}
