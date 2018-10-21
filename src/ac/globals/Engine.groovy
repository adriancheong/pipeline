package ac.globals

import groovy.json.JsonSlurperClassic

class Engine implements Serializable {
  def script
  Engine(script) {
    this.script = script
  }
    
  def Checkout() {
//    script.node {
      script.stage('Checkout') {
        script.checkout script.scm
      }
  //  }
  }
  
  def Build() {
  }

  def Test() {
  }
  
  def Scan() {
  }
  
  def Publish() {
  }
}
