class CinemaTicketSystem {
    private var nextMovieId = 1
    private var nextUserId = 1
    private var nextTicketId = 1

    private val movies = mutableMapOf<Int, String>()
    private val users = mutableMapOf<Int, String>()
    private val tickets = mutableMapOf<Int, Pair<Int, Int>>()

    init {
        println("инициализирует объект системы управления билетами")
    }

    //добавляет новый фильм
    fun addMovie(movieName: String): Int {
        val movieId = nextMovieId++
        movies[movieId] = movieName
        return movieId
    }

    //список доступных фильмов.
    fun showAllMovies() {
        println("Доступные фильмы:")
        for ((id, name) in movies) {
            println("$id. $name")
        }
    }

    //регистрация нового пользователя
    fun addUser(userName: String): Int {
        val userId = nextUserId++
        users[userId] = userName
        return userId
    }

    // покупка билета
    fun buyTicket(userId: Int, movieId: Int): Int {
        if (!users.containsKey(userId)) {
            throw IllegalArgumentException("Пользователь с ID $userId не существует.")
        }
        if (!movies.containsKey(movieId)) {
            throw IllegalArgumentException("Фильм с ID $movieId не существует.")
        }
        val ticketId = nextTicketId++
        tickets[ticketId] = Pair(userId, movieId)
        println("tickets: ${tickets[ticketId]}")
        return ticketId
    }

    // отмена покупку билета
    fun cancelTicket(ticketId: Int): Boolean {
        return if (tickets.containsKey(ticketId)) {
            tickets.remove(ticketId)
            true
        } else {
            false
        }
    }
}
