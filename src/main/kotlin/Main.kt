import java.util.*
//wildcard import statement
//imports all the classes and interfaces from the java.util package


// Declare a global ArrayList of Player objects
 val playerList = ArrayList<Player>()

fun main() {
    // Create and add Player objects to the global ArrayList
    val player1 = Player("Billy", 12)
    val player2 = Player("Victor", 33)
    val player3 = Player("Sally", 67)
    val player4 = Player("Janell", 45)
    val player5= Player("Jennifer", 30)
    playerList.add(player1)
    playerList.add(player2)
    playerList.add(player3)
    playerList.add(player4)
    playerList.add(player5)

    //menu to choose
    while (true) {
        println("Players")
        println("1. Display Player")
        println("2. Display Player with an Odd Number")
        println("3. Display PLayers starting with a letter")
        println("4. Add Player")
        print("Enter your choice: ")

        //using try/catch to make sure that user enter an interger
        try {
            val scanner = Scanner(System.`in`)
            val choice: Int = scanner.nextInt()

            //using when and else instead of switch/default
            //each choice calling different method
            when (choice) {
                1 -> {
                    displayPlayer()
                    println("-------------------------------\n\n")
                }

                2 -> {
                    displayOddNumber(playerList)
                    println("-------------------------------\n\n")
                }

                3 -> {
                    displayFirstLetterOfName(playerList)
                    println("-------------------------------\n\n")
                }

                4 -> {
                    addPlayer(playerList)
                    println("-------------------------------\n\n")
                }

                //default
                else -> {println("Pick the right choice 1 to 4\n")}
            }
        } catch (e: InputMismatchException) {
            println("Invalid input. Please enter an integer.\n")
        }
    } //while
}//main

fun displayPlayer() {
    // Access the global ArrayList
    for (player in playerList) {
        println(player)
    }
} //option 1

fun displayOddNumber(players: ArrayList<Player>) {
    //have ArrayList of Players as an argument
    //looping through the list with index and indices of elements in a collection(players)
    for (i in players.indices) {
        if (players[i].number % 2 != 0) {
            println(players[i])
        }
    }
} //option 2

fun isALetter(input: Char): Boolean {
    //boolean check to make sure that a letter that is entered is char(letter)
    return input.isLetter()
}

fun displayFirstLetterOfName(players: ArrayList<Player>) {
    var isValidInput = false

    //using while loop to make sure user enter what we want which is a single letter
    while (!isValidInput) {
        print("Enter the letter: ")
        val scanner = Scanner(System.`in`)
        val letter = scanner.nextLine()

        //set condition to find the letter that match the name
        var isFound = false

        ///if/else condition for a single letter
        if (letter.length == 1) {
            val enter = letter[0]
            val isALetter: Boolean = isALetter(enter)

            //if it is a letter, this scope runs, the user(s) found and set the isValidInput to true
            if (isALetter) {
                for (i in players.indices) {
                    val name = players[i].name
                    val firstLetter = name[0]
                    val lowerCase = firstLetter.lowercaseChar()
                    if (enter == firstLetter || enter == lowerCase) {
                        println(players[i])
                        isFound = true
                    }
                }

                //if the user is not found, the isFound condition is still False, this block of
                //code runs because it true and then runs isValidInput to get out of the loop
                if (!isFound) {
                    println("No players found with $enter")
                }

                isValidInput = true // Break out of the loop
            }
            else {
                println("Please enter Number only")
            }

        } else {
            println("Please enter 1 letter only.")
        }
    }
} //option 3

fun addPlayer(players: ArrayList<Player>) {
    print("Enter Name: ")
    val scanner1 = Scanner(System.`in`)
    val name = scanner1.nextLine()
    var isNumber = false

    //try/catch for an interger
    while (!isNumber) {
        try {
            print("Enter Number: ")
            val scanner2 = Scanner(System.`in`)
            val number = scanner2.nextInt()

            //if it is a success, pass the name and number in
            players.add(Player(name, number))

            isNumber = true//end the loop
        } catch (e: InputMismatchException) {
            println("Invalid input. Please enter an integer.")
        }
    }
} //option 4





