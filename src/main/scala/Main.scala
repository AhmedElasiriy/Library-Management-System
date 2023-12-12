import scala.io.StdIn.readLine
import scala.util.control.Breaks
import org.slf4j.LoggerFactory
import ch.qos.logback.classic.{Level, LoggerContext}

object Main {

  val loggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
  // loggerContext.getLogger("org.slf4j.impl.StaticLoggerBinder").setLevel(Level.INFO)
  loggerContext.stop()

  def main(args: Array[String]): Unit = {
    var continue = true
    println("Welcome to Library Management System!")

    while (continue) {
      println(
        """
Please select an option from the following menu:
 -----------------------------------------------------------------
| 1.  Managing users              |   2.  Managing books          |
| 3.  Report Generation           |   4.  Manage Library Resources|
| 5.  Handle Book Checkout        |   6.  Manage Users Accounts    |
| 7.  Create Reports              |   8.  Monitor Library Usage   |
| 9.  View Available Books        |   10. View Borrowed Books     |
| 11. Search for Books            |   12. Exit                    |
 -----------------------------------------------------------------
"""
      )

      try {
        var choice = readLine(
          "Enter number corresponding to your choice: "
        ).toInt

        choice match {
          // 1. Register New User
          case 1 =>
            var manageUsers = true
            while (manageUsers) {
              println(
                """
Please select an option from the following menu:
  -----------------------------------------------------------------
  | 1.  Add New User           |   2.  Remove User                |
  | 3.  Update User            |   4.  View All Users             |
  | 5.  View User by Id        |   6. Back to Main Menu           |
  -----------------------------------------------------------------
"""
              )
              try {
                var choice = readLine(
                  "Enter number corresponding to your choice: "
                ).toInt

                choice match {
                  // 1. Add New User
                  case 1 =>
                    var nationalId = readLine("Enter national id of user: ")
                    var name = readLine("Enter name of user: ")
                    userService.addUser(nationalId, name)

                  // // 2. Remove User
                  case 2 =>
                    var nationalId = readLine(
                      "Enter national id of user to be removed: "
                    )
                    userService.removeUser(nationalId)

                  // // 3. Update User
                  case 3 =>
                    var nationalId = readLine(
                      "Enter national id of user to be updated: "
                    )
                    var name = readLine("Enter name of user: ")
                    userService.updateUser(nationalId, name)

                  // // 4. View All Users
                  case 4 =>
                    userService.getAllUsers()

                  // // 5. View User by Id
                  case 5 =>
                    var nationalId = readLine(
                      "Enter national id of user to be viewed: "
                    )
                    userService.getUserByNationalId(nationalId)

                  // // 6. Back to Main Menu
                  case 6 =>
                    manageUsers = false

                  case _ =>
                    println("Invalid choice. Please try again.")
                }
              } catch {
                case a: NumberFormatException =>
                  println(s"NumberFormatException occurred. Try again!")
              }
            }

          // 2. Manage Books
          case 2 =>
            var manageBooks = true
            while (manageBooks) {
              println("""
Please select an option from the following menu:
  -----------------------------------------------------------------
  | 1.  Add New Book           |   2.  Remove Book                | 
  | 3.  Update Book            |   4.  View All Books             |
  | 5.  View Book by Id        |   6. Back to Main Menu           |
  -----------------------------------------------------------------
                """)
              try {
                var choice = readLine(
                  "Enter number corresponding to your choice: "
                ).toInt

                choice match {
                  // 1. Add New Book
                  case 1 =>
                    var title = readLine("Enter title of book: ")
                    var author = readLine("Enter author of book: ")
                    var isbn = readLine("Enter isbn of book: ")
                    var availability = readLine("Enter availability of book: ").toBoolean
                    var location = readLine("Enter location of book: ")
                    bookService.addBook(title, author, isbn, availability, location)

                  // 2. Remove Book
                  case 2 =>
                    var bookId = readLine(
                      "Enter Id of book to be removed: "
                    ).toInt
                    bookService.removeBook(id = bookId)

                  // 3. Update Book
                  case 3 =>
                    var bookId = readLine(
                      "Enter Id of book to be updated: "
                    ).toInt
                    var title = readLine("Enter title of book: ")
                    var author = readLine("Enter author of book: ")
                    var isbn = readLine("Enter isbn of book: ")
                    var availability = readLine("Enter availability of book: ").toBoolean
                    var location = readLine("Enter location of book: ")
                    bookService.updateBook(bookId, title, author, isbn, availability, location)

                  // 4. View All Books
                  case 4 =>
                    bookService.getAllBooks()

                  // 5. View Book by Id
                  case 5 =>
                    var bookId = readLine(
                      "Enter Id of book to be viewed: "
                    ).toInt
                    bookService.getBookById(id = bookId)

                  // 6. Back to Main Menu
                  case 6 =>
                    manageBooks = false

                  case _ =>
                    println("Invalid choice. Please try again.")
                }
              } catch {
                case a: NumberFormatException =>
                  println(s"NumberFormatException occurred. Try again!")
              }
            }

          // 12. Exit
          case 12 =>
            println("Exiting...")
            continue = false

          case _ =>
            println("Invalid choice. Please try again.")
        }
      } catch {
        case a: NumberFormatException =>
          println(s"NumberFormatException occurred. Try again!")
      }
    }
  }
}

// // 2.  Check In
// case 2 =>
//   var customerId = readLine(
//     "Enter Id of customer to be removed: "
//   ).toInt
//   userService.removeCustomer(id = customerId)
// // 3.  Report Generation
// case 3 =>
//   var name = readLine("Enter name of student: ")
//   var rollNo = readLine("Enter Roll.No of student: ")
//   var batch = readLine("Enter batch of student: ")
//   userService.addStudent(name, rollNo, batch)
// // 4.  Manage Library Resources
// case 4 =>
//   var studentId = readLine(
//     "Enter Roll.No of student to be removed : "
//   )
// // 5.  Handle Book Checkout
// case 5 =>
//   var studentId = readLine(
//     "Enter Roll.No of student to be removed : "
//   )
// // 6.  Manage User Accounts
// case 6 =>
//   var studentId = readLine(
//     "Enter Roll.No of student to be removed : "
//   )
// // 7.  Create Reports
// case 7 =>
//   var studentId = readLine(
//     "Enter Roll.No of student to be removed : "
//   )
// // 8.  Monitor Library Usage
// case 8 =>
//   var studentId = readLine(
//     "Enter Roll.No of student to be removed : "
//   )
// // 9.  View Available Books
// case 9 =>
//   var studentId = readLine(
//     "Enter Roll.No of student to be removed : "
//   )
// // 10. View Borrowed Books
// case 10 =>
//   var studentId = readLine(
//     "Enter Roll.No of student to be removed : "
//   )
// // 11. Search for Books
// case 11 =>
//   var studentId = readLine(
//     "Enter Roll.No of student to be removed : "
//   )
// // 12. Exit
// case 12 =>
//   var studentId = readLine(
//     "Enter Roll.No of student to be removed : "
//   )
// case _ =>
//   println("Invalid choice. Please try again.")
