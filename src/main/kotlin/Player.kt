class Player(var name: String, var number: Int)  {
    //override string
    override fun toString(): String {
        return "$name - $number"
    }
}//default property syntax, which means you don't need to explicitly define getters and setters
// for the name and number properties. The compiler automatically generates them for you.