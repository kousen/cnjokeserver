import static ratpack.groovy.Groovy.*
import com.kousenit.JokeServer

JokeServer server = JokeServer.instance

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
