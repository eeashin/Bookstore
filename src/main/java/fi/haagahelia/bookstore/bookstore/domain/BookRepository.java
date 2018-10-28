package fi.haagahelia.bookstore.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByTitle(String title);

	List<Book> findByAuthor(String author);

	// Enabling ignore case
	List<Book> findByTitleIgnoreCase(String title);

	// Enabling ORDER BY for a query
	List<Book> findByTitleOrderByTitleAsc(String title);

}