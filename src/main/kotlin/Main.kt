fun main(args: Array<String>) {
    val cinemaSystem = CinemaTicketSystem()

    val movieId1 = cinemaSystem.addMovie("Дэдпул и Росомаха")
    val movieId2 = cinemaSystem.addMovie("Планета обезьян: Новое царство")

    cinemaSystem.showAllMovies()

    val userId1 = cinemaSystem.addUser("Magzhan")
    val userId2 = cinemaSystem.addUser("Samat")

    val ticketId1 = cinemaSystem.buyTicket(userId1, movieId1)
    val ticketId2 = cinemaSystem.buyTicket(userId2, movieId2)

    println(cinemaSystem.cancelTicket(ticketId1))
    println(cinemaSystem.cancelTicket(3))
    println(cinemaSystem.cancelTicket(ticketId2))
}