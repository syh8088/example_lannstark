package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.JavaBookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.JavaUserRepository;
import com.group.libraryapp.domain.user.loanhistory.JavaUserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.JavaBookLoanRequest;
import com.group.libraryapp.dto.book.request.JavaBookRequest;
import com.group.libraryapp.dto.book.request.JavaBookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JavaBookService {

  private final JavaBookRepository bookRepository;
  private final JavaUserRepository userRepository;
  private final JavaUserLoanHistoryRepository userLoanHistoryRepository;

  public JavaBookService(
      JavaBookRepository bookRepository,
      JavaUserRepository userRepository,
      JavaUserLoanHistoryRepository userLoanHistoryRepository
  ) {
    this.bookRepository = bookRepository;
    this.userRepository = userRepository;
    this.userLoanHistoryRepository = userLoanHistoryRepository;
  }

  @Transactional
  public void saveBook(JavaBookRequest request) {
//    Book newBook = new Book(request.getName(), null);
//    bookRepository.save(newBook);
  }

  @Transactional
  public void loanBook(JavaBookLoanRequest request) {
    Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);
//    if (userLoanHistoryRepository.findByBookNameAndIsReturn(request.getBookName(), false) != null) {
//      throw new IllegalArgumentException("진작 대출되어 있는 책입니다");
//    }

    User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
    user.loanBook(book);
  }

  @Transactional
  public void returnBook(JavaBookReturnRequest request) {
    User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
    user.returnBook(request.getBookName());
  }

}
