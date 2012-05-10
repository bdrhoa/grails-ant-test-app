package org.grails.plugins.test.ant

class ReloadTestController {
    
    /*
      Key: GPANT-1
                URL: http://jira.grails.org/browse/GPANT-1
            Project: Ant Plugin
         Issue Type: Bug
           Reporter: Daniel Henrique Alves Lima
           Assignee: Brad Rhoads


1. Start grails using 'grails run-app';
2. Invoke your Controller that uses ant;
3. Change your Controller and wait for reloading;
4. Invoke your Controller again.

No such property: ant for class: AbcController


You should redefine dynamic methods in GrailsAntGrailsPlugin.onChange

       {code}
       // Something like
       def onChange = { event ->
               doWithDynamicMethod(event.ctx) // There is no need of redefine dynamic methods for all Grails artifacts
       }
       {code}

or use dependency injection instead of MOP:

       {code}
       // Something like
       def doWithSpring = {
               ant(groovy.util.AntBuilder) {bean ->
                    bean.singleton = false
               }
       }
       {code}
*/

    def index = { 
       ant.echo message: 'Hello From Ant!'
       ant.echo message: 'Good by From Ant!'
    }
    
}
