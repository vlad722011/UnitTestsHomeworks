import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class BookServiceTest {

      /* Задача:
    Есть класс BookService, который использует интерфейс BookRepository для получения информации
    о книгах из базы данных. Задача - написать unit-тесты для BookService, используя Mockito для
    создания мок-объекта BookRepository.
     */

    static Book book1;
    static Book book2;

    @BeforeAll
    static void setup() {
        book1 = new Book("1", "Book1", "Author1");
        book2 = new Book("2", "Book2", "Author2");
    }

    @Test
    void bookServiceFindBookByIdTest() {
        // заглушка для интерфейса bookRepository
        BookRepository bookRepository = mock(InMemoryBookRepository.class);

        // задаем поведение заглушки
        when(bookRepository.findById("1")).thenReturn(book1);

        // создаем объект bookService, который зависит от интерфейса bookRepository
        BookService bookService = new BookService(bookRepository);

        // сравниваем фактический результат полученный в результате работы сервиса "bookService" с ожидаемым
        assertThat(bookService.findBookById("1")).isEqualTo(book1);
    }

    @Test
    void bookServiceFindAllBooksTest() {
        // заглушка для интерфейса bookRepository
        BookRepository bookRepository = mock(InMemoryBookRepository.class);

        // задаем поведение заглушки
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        // создаем объект bookService, который зависит от интерфейса bookRepository
        BookService bookService = new BookService(bookRepository);

        // сравниваем фактический результат полученный в результате работы сервиса "bookService" с ожидаемым
        assertThat(bookService.findAllBooks().size()).isEqualTo(2);
    }
}
