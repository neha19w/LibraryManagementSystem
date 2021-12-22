package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.BookHistory;
import model.Books;
import model.LibraryInfoData;
import model.Reader;
import service.Rservice;


@RestController
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RequestMapping(value="/api")
public class Controller {
		
	
	@Autowired
	private Rservice rservice;
	
	@PostMapping("save-book")
	public boolean saveBook(@RequestBody Books bookObject) {
		 return rservice.saveBook(bookObject);
		
	}
	@GetMapping("getBook-list")
	public List<Books> allrule() {
			return rservice.getBooks();
	}

	
	@GetMapping("getBookByAuthor/{author}")
	public List<Books> allbookbybookauthor(@PathVariable("author") String author,Books bookObject) {
		bookObject.setAuthor(author);
		List<Books> local=rservice.getBooksByAuthor(bookObject);	
		 return local;
		
	}
	
	@GetMapping("getBookByGenre/{genre}")
	public List<Books> allbookbygenre(@PathVariable("genre") String genre, Books bookObject){
		bookObject.setGenre(genre);
		List<Books>local=rservice.getBooksByGenre(bookObject);
		return local;
	}
	
	@DeleteMapping("deleteBook/{author}")
	public boolean deleteBooks(@PathVariable("author") String author,Books bookObject) {
		bookObject.setAuthor(author);
		return rservice.deleteBooks(bookObject);
	}
	
	@PostMapping("save-reader")
	public boolean saveReader(@RequestBody Reader readerObject) {
		 return rservice.saveReader(readerObject);
		
	}
	@PostMapping("save-bookHistory")
	public boolean saveBookHistory(@RequestBody BookHistory bookHistoryObject) {
		 return rservice.saveBookHistory(bookHistoryObject);
		
	}
	
	
	@PutMapping("update-ADetails")
	public boolean updateDetails(@RequestBody LibraryInfoData  libraryInfoDataObject) {
		
		return rservice.updateDetails(libraryInfoDataObject);	
	}
	
	@PutMapping("update-UaDetails")
	public boolean updateUnassignDetails(@RequestBody LibraryInfoData  libraryInfoDataObject) {
		
		return rservice.updateUnassignDetails(libraryInfoDataObject);	
	}
	
	
}
