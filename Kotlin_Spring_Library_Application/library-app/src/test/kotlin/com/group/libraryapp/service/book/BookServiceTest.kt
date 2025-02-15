package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.book.BookType
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.JavaUserLoanHistoryRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import com.group.libraryapp.dto.book.response.BookStatResponse
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: JavaUserLoanHistoryRepository,
) {

    @AfterEach
    fun afterEach() {
        bookRepository.deleteAll()
        userRepository.deleteAll()
//        userLoanHistoryRepository.deleteAll()
    }

    @Test
    @DisplayName("책 등록이 정상 동작 한다.")
    fun saveBookTest() {

        // given
        val request = BookRequest("이상한 나라의 엘리스", BookType.COMPUTER)

        // when
        bookService.saveBook(request)

        // then
        val books = bookRepository.findAll()
        assertThat(books).hasSize(1)
        assertThat(books[0].name).isEqualTo("이상한 나라의 엘리스")
        assertThat(books[0].name).isEqualTo(BookType.COMPUTER)
    }

    @Test
    @DisplayName("책 대출이 정상 동작한다.")
    fun loanBookTest() {

        // given
        bookRepository.save(Book.fixture("test"))
        val savedUser = userRepository.save(User("test", null))
        val request = BookLoanRequest("test", "test")

        // when
        bookService.loanBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results[0].bookName).isEqualTo("test")
        assertThat(results[0].user.id).isEqualTo(savedUser.id)
        assertThat(results[0].status).isEqualTo(UserLoanStatus.LOANED)
    }

    @Test
    @DisplayName("책이 진작 대출되어 있다면, 신규 대출이 실패한다.")
    fun loanBookFailTest() {
        // given
        bookRepository.save(Book.fixture("test"))
        val savedUser = userRepository.save(User("test", null))
        userLoanHistoryRepository.save(
            UserLoanHistory.fixture(
                savedUser,
                "test"
            )
        )
        val request = BookLoanRequest("test", "test")

        // when & then
//        val message = assertThrows<IllegalArgumentException> {
//            bookService.loanBook(request)
//        }.message
//        assertThat(message).isEqualTo("진작 대출되어 있는 책입니다")
    }


    @Test
    @DisplayName("책 반납이 정상 동작한다")
    fun returnBookTest() {
        // given
        val savedUser = userRepository.save(User("test", null))
        userLoanHistoryRepository.save(UserLoanHistory.fixture(savedUser, "test"))
        val request = BookReturnRequest("test", "test")

        // when
        bookService.returnBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        AssertionsForInterfaceTypes.assertThat(results).hasSize(1)
        assertThat(results[0].status).isEqualTo(UserLoanStatus.RETURNED)
    }

    @Test
    @DisplayName("책 대여 권수를 정상 확인한다")
    fun countLoanedBookTest() {

        // given
        val savedUser = userRepository.save(User("test", null))

        // 대출 건 하나 반납 중 두개 만들자
        userLoanHistoryRepository.saveAll(listOf(
            UserLoanHistory.fixture(savedUser, "A"),
            UserLoanHistory.fixture(savedUser, "B", UserLoanStatus.RETURNED),
            UserLoanHistory.fixture(savedUser, "C", UserLoanStatus.RETURNED),
        ))

        // when
        val result = bookService.countLoanedBook()

        // then
        assertThat(result).isEqualTo(1)

    }

    @Test
    @DisplayName("책 대여 권수를 정상 확인한다")
    fun getBookStatisticsTest() {

        // given
        bookRepository.saveAll(listOf(
            Book.fixture("A", BookType.COMPUTER),
            Book.fixture("B", BookType.COMPUTER),
            Book.fixture("C", BookType.SCIENCE),
        ))

        // when
        val results = bookService.getBookStatisticsV2()

        // then
        assertThat(results).hasSize(2)

//        val computerDto = results.first { result -> result.type == BookType.COMPUTER }
//        assertThat(computerDto.count).isEqualTo(2)
//
//        val scienceDto = results.first { result -> result.type == BookType.SCIENCE }
//        assertThat(scienceDto.count).isEqualTo(1)
        assertCount(results, BookType.COMPUTER, 2)
        assertCount(results, BookType.SCIENCE, 1)
    }

    private fun assertCount(results: List<BookStatResponse>, type: BookType, count: Int) {
        assertThat(results.first { result -> result.type == type }.count).isEqualTo(count)
    }
}