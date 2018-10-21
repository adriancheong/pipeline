package ac.globals

import groovy.json.JsonSlurperClassic

class Engine implements Serializable {
  def script
  Engine(script) {
    this.script = script
  }
  
  def hello(){
    script.sh 'echo hello'
    return 'Hello World!'
  }
}
