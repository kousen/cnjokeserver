import com.gmongo.GMongo

GMongo mongo = new GMongo()
def db = mongo.getDB('icndb')

println db.cnjokes.find().count()
def jokes = db.cnjokes.find([
    categories : ~/[^(explicit)]/])
println jokes*.id.sort()
println jokes.size()