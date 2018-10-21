package ac.globals

import groovy.json.JsonSlurperClassic

class Engine implements Serializable {
  def hello(){
    println 'hello'
    sh 'echo hello'
    bat 'echo hello'
    return 'Hello World!'
  }
}
