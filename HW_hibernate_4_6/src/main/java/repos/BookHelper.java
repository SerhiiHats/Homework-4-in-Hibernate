package repos;

import models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BookHelper {
    public SessionFactory sessionFactory;

    public BookHelper() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Book addBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        criteriaQuery.from(Book.class);
        Query query = session.createQuery(criteriaQuery);
        List<Book> bookList = query.getResultList();
        session.close();
        return bookList;
    }

    public Book getById(long id) {
        Session session = sessionFactory.openSession();
        Book book = (Book) session.get(Book.class, id);
        session.close();
        return book;
    }

    public void removeBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    }


}
