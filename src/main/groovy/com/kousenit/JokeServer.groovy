package com.kousenit

import com.gmongo.GMongo
import com.mongodb.DB

class JokeServer {
    GMongo mongo = new GMongo()
    Map jokes = [:]
    List ids = []
    
    JokeServer() {
        DB db = mongo.getDB('icndb')
//        def jokesInDB = db.cnjokes.find([categories: [$ne : 'explicit']])
        def jokesInDB = db.cnjokes.find([categories: 'nerdy'])
        jokesInDB.each { j ->
            jokes[j.id] = j.joke
        }
        ids = jokes.keySet() as List
    }
    
    String getJoke(String firstName = 'Chuck', String lastName = 'Norris') {
        Collections.shuffle(ids)
        String joke = jokes[ids[0]]
        if (!joke) println "Null joke at id=$id"
        if (firstName != 'Chuck')
            joke = joke.replaceAll(/Chuck/, firstName)
        if (lastName != 'Norris')
            joke = joke.replaceAll(/Norris/, lastName)
        return joke
    }
}
