import groovy.json.JsonSlurper
import com.gmongo.GMongo

GMongo mongo = new GMongo()
def db = mongo.getDB('icndb')
db.cnjokes.drop()

JsonSlurper slurper = new JsonSlurper()
String jsonTxt = 'http://api.icndb.com/jokes/count'.toURL().text
def json = slurper.parseText(jsonTxt)
int total = json.value.toInteger()

jsonTxt = "http://api.icndb.com/jokes/random/${total}".toURL().text
json = slurper.parseText(jsonTxt)
def jokes = json.value
jokes.each {
    db.cnjokes << it
}
assert total == jokes*.id.size()
assert total == db.cnjokes.find().count()