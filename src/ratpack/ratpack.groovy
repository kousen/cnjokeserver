import static ratpack.groovy.Groovy.*
//import static ratpack.groovy.Template.groovyTemplate

import com.kousenit.JokeServer

JokeServer server = new JokeServer()

ratpack {
    handlers {
        get {
            String message
            if(request.queryParams.firstName || request.queryParams.lastName) {
                message = server.getJoke(
                    request.queryParams.firstName, 
                    request.queryParams.lastName)
            } else {
                message = server.joke
            }
            response.headers.set 'Content-Type', 'application/json'
            response.send message
        }
        
        assets "public"
    }
}
