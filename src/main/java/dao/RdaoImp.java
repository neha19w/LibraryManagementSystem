package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.BookHistory;
import model.Books;
import model.LibraryInfoData;
import model.Reader;


@Repository
public class RdaoImp {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean saveBook(Books bookObject) {
		
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(bookObject);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	public List<Books> getBooks() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Books> query=currentSession.createQuery("from Books", Books.class);
		List<Books> list=query.getResultList();
			
		return list;
	}
	
	public List<Books> getBooksByAuthor(Books book) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Books> query=currentSession.createQuery("from Books where author=:author", Books.class);
		query.setParameter("author", book.getAuthor());
		List<Books> list=query.getResultList();
		return list;
	}
	
	public List<Books> getBooksByGenre(Books book){
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Books> query=currentSession.createQuery("from Books where genre=:genre",Books.class);
		query.setParameter("genre", book.getGenre());
		List<Books>list=query.getResultList();
		System.out.println(list.size());
		return list;
	}
	
	public boolean deleteBooks(Books bookObject )  {
		
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(bookObject);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

		public boolean saveReader(Reader readerObject) {
		
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(readerObject);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
		
		
		public boolean saveBookHistory(BookHistory bookHistoryObject) {
			
			boolean status=false;
			try {
				sessionFactory.getCurrentSession().save(bookHistoryObject);
				status=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		}
		
		
		
	public boolean updateDetails(LibraryInfoData libraryInfoDataObject) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Books> query=currentSession.createQuery("from Books where id=:id", Books.class);
		query.setParameter("id", libraryInfoDataObject.getBookid() );
		List<Books> list=query.getResultList();
	
		Books updateBooks = list.get(0);
		updateBooks.setCurrentIdReader(libraryInfoDataObject.getReaderid());
		
		currentSession.clear();
		updateInTime(libraryInfoDataObject.getBookid(),libraryInfoDataObject.getReaderid());
		
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(updateBooks);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	
		public boolean updateUnassignDetails(LibraryInfoData libraryInfoDataObject) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Books> query=currentSession.createQuery("from Books where id=:id And currentIdReader=:currentIdReader", Books.class);
		query.setParameter("id", libraryInfoDataObject.getBookid() );
		query.setParameter("currentIdReader", libraryInfoDataObject.getReaderid() );
		
		List<Books> list=query.getResultList();
		
		boolean status=false;
		
		if(list.size()>0) {
			Books updateBooks = list.get(0);
			updateBooks.setCurrentIdReader(0);
		
			currentSession.clear();
			updateOutTime(libraryInfoDataObject.getBookid(),libraryInfoDataObject.getReaderid());

			try {
				sessionFactory.getCurrentSession().update(updateBooks);
				status=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}
		void updateInTime(int bookId,int readerId) {
			BookHistory temp=new BookHistory();
			temp.setBookId(bookId);
			Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            String strDate = dateFormat.format(date);  
			temp.setDateIn(strDate);
			temp.setDateOut("");
			temp.setReaderId(readerId);
			
			
			Session currentSession = sessionFactory.getCurrentSession();
			sessionFactory.getCurrentSession().save(temp);
			currentSession.clear();
			
		}
		
		void updateOutTime(int bookId,int readerId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			Query<BookHistory> query=currentSession.createQuery("from BookHistory where bookId=:bookId And readerId=:readerId and dateOut='' ", BookHistory.class);
			query.setParameter("bookId", bookId );
			query.setParameter("readerId", readerId );
			
			List<BookHistory> list=query.getResultList();
			
			if(list.size()>0) {
				BookHistory oldrecord=list.get(0);
			

				currentSession.clear();

			Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            String strDate = dateFormat.format(date);  
            oldrecord.setDateOut(strDate);
			
			
            sessionFactory.getCurrentSession().update(oldrecord);
			currentSession.clear();
			
			}
		}
		
		

}
