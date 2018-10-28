package fi.haagahelia.bookstore.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.bookstore.domain.Book;
import fi.haagahelia.bookstore.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.bookstore.domain.Category;
import fi.haagahelia.bookstore.bookstore.domain.CategoryRepository;
import fi.haagahelia.bookstore.bookstore.domain.User;
import fi.haagahelia.bookstore.bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository cRepository, UserRepository urepository) {

		return (args) -> {
			// Your code...add some demo data to db
			Category category1 = new Category("Programming");
			Category category2= new Category("React");
			Category category3= new Category("Database");
			
			cRepository.save(category1);
			cRepository.save(category2);
			cRepository.save(category3);
			
			Book book1 = new Book("Server Programming", "Juha Hinkula", "2018", "12345", 20,category1);
			Book book2 = new Book("Front End & React", "Juha Hinkula", "2018", "1234567", 30, category2);
			Book book3 = new Book("Database Programming", "Kari Sipliö", "2018", "1234567", 30, category3);
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
			
			// Create users: admin/adminpassword user/userpassword
			User user1 = new User("user", "$2a$04$0sU2lmNultKtZUDNWoR3fOBxbZ4ksJ.wZOqbbpib140tDRBjyqPWi", "user@bookstore.fi", "USER");
			User user2 = new User("admin", "$2a$04$ufGHTiDx6iuBCTKdWbgmWejkvDLUtfSH6prjymYLxgFuJj.w0viDG","admin@bookstore.fi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
		
			
		};
	}

}
