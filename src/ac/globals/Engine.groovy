package ac.globals

import groovy.json.JsonSlurperClassic

class Engine implements Serializable {
  def script
  Engine(script) {
    this.script = script
  }
    
  def Hello() {
    script.node {
    script.sh 'echo Hello!'
    }
  }
  
  def Checkout() {
    script.node {
      script.stage('Checkout') {
        script.sh 'echo start of Checkout'
        script.checkout script.scm
        script.sh 'echo end of Checkout'
      }
    }
  }
  
  def DockerBuild(image, steps) {
    script.node {
      script.stage('Checkout2') {
        if (steps instanceof Map) {
          script.sh 'echo it is instance of map'
          steps = steps.values()
        } else {
          script.sh 'echo it is NOT instance of map'
          steps = [steps]
        }   

        steps()
//        script.checkout script.scm
        
      }
      script.docker.image(image).inside('-u root') {
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
