package fi.haagahelia.bookstore.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.bookstore.bookstore.domain.Book;
import fi.haagahelia.bookstore.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository cRepoository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

	// Show all books
	@GetMapping("/booklist")
	public String bookStore(Model model) {
		model.addAttribute("books", repository.findAll());

		return "booklist";
	}

	// RESTful service to get all books

	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();

	}

	// RESTful service to get book by id
	@GetMapping("/books/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}

	// Add new book
	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", cRepoository.findAll());

		return "addbook";
	}

	// Save new book
	@PostMapping(value = "/save")
	public String save(Book book) {
		repository.save(book);

		return "redirect:booklist";
	}

	// Delete book
	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		
		return "redirect:/booklist";
	}

}
