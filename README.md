The Internet Carlos Ray Server (local version)
----------------------------------------------

This is a local [ratpack](http://www.ratpack.io) project for serving up Chuck Norris jokes. The jokes were downloaded from the [Internet Chuck Norris Database (ICNDB)](http://icndb.com). This version stores the jokes in a MongoDB database and serves them up on demand. Unlike the ICNDB web site, these jokes are returned as raw strings after parsing the JSON object.

The server expects a MongoDB database called `icndb`. If you have MongoDB installed, you can create and populate the database using the `download_jokes.groovy` script in the `src/ratpack/public/scripts` folder. It needs the GMongo library in the classpath, which is part of the gradle dependencies. A similar `query_jokes.groovy` script is included to check the resulting database.

Run the application by typing

    ./gradlew run

The jokes are then available at [http://localhost:5050](http://localhost:5050). 

You can change the name of the hero using `firstName` and `lastName` parameters, as in [http://localhost:5050?firstName=Carlos&lastName=Ray](http://localhost:5050?firstName=Carlos&lastName=Ray) (aside: Chuck Norris's real name is Carlos Ray Norris; a fact I discovered when I received a takedown notice from his lawyers. See [this post](http://kousenit.wordpress.com/2013/10/02/making-java-groovy-ratpack-mongodb-and-chuck-norris/) and [this other one](http://kousenit.wordpress.com/2013/10/09/carlos-ray-and-springs-resttemplate/) from my blogfor details.)

The project contains a unit test for the joke server and an integration test for the overall ratpack application. Running `./gradlew test` will execute both.

Finally, yes, the `ratpack.groovy` file is duplicated both in the root and in the `src/ratpack` directory. The former is used by the tests and the latter by the running application. When I figure out how to make both use the same file, I'll remove one.