package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.RdaoImp;
import model.BookHistory;
import model.Books;
import model.LibraryInfoData;
import model.Reader;

@Service
@Transactional
public class RserviceImp implements Rservice{
	
	@Autowired
	private RdaoImp rdao;
	@Override
	public boolean saveBook(Books bookObject) {
		
		return rdao.saveBook(bookObject);
		
	}

	@Override
	public List<Books> getBooks() {
		
		return rdao.getBooks();
	
	}

	@Override
	public List<Books>getBooksByAuthor(Books bookObject) {
				
		return rdao.getBooksByAuthor(bookObject);
	}
	
	@Override
	public List<Books> getBooksByGenre(Books bookObject) {
		
		return rdao.getBooksByGenre(bookObject);
	}

	@Override
	public boolean deleteBooks(Books bookObject) {
		
		return rdao.deleteBooks(bookObject);
		
	}

	@Override
	public boolean saveReader(Reader readerObject) {
		
		return rdao.saveReader(readerObject);
	}

	@Override
	public boolean saveBookHistory(BookHistory bookHistoryObject) {
		
		return rdao.saveBookHistory(bookHistoryObject);
	}
	

	@Override
	public boolean updateDetails(LibraryInfoData libraryInfoDataObject) {
		
		return rdao.updateDetails(libraryInfoDataObject);
	}
	
	@Override
	public boolean updateUnassignDetails(LibraryInfoData libraryInfoDataObject) {
		
		return rdao.updateUnassignDetails(libraryInfoDataObject);
	}
	
}
