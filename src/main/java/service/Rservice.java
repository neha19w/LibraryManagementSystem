package service;

import java.util.List;

import model.BookHistory;
import model.Books;
import model.LibraryInfoData;
import model.Reader;


public interface Rservice {
		
	public boolean saveBook(Books bookObject);
	
	public List<Books> getBooks();
	public List<Books> getBooksByAuthor(Books bookObject );
	public List<Books> getBooksByGenre(Books bookObject);
	
	public boolean deleteBooks(Books bookObject);
	
	public boolean saveReader(Reader readerObject);
	public boolean saveBookHistory(BookHistory bookHistoryObject);
	
	public boolean updateDetails(LibraryInfoData libraryInfoDataObject);
	public boolean updateUnassignDetails(LibraryInfoData libraryInfoDataObject);
}
