package fi.haagahelia.bookstore.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity 
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private List<Book> books;
	
	public Category() {
	
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public String toString() {
		return this.name;
	}
	
	
}
