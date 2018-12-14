package repository;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import entity.BookEntity;
import play.db.jpa.JPAApi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class JPABookRepository implements BookRepository {
    
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;
    
    @Inject
    public JPABookRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
	this.jpaApi = jpaApi;
	this.executionContext = executionContext;
    }
    
    private <T> T wrap(Function<EntityManager, T> function) {
	return jpaApi.withTransaction(function);
    }
    
    private BookEntity insert(EntityManager em, BookEntity bookEntity) {
	em.persist(bookEntity);
	return bookEntity;
    }
    
    private Stream<BookEntity> list(EntityManager em) {
	List<BookEntity> books = em.createQuery("select b from BookEntity b", BookEntity.class).getResultList();
	return books.stream();
    }
    
    private BookEntity listBySerial(Long serial, EntityManager em) {
	BookEntity book = em.createQuery("select b from BookEntity b where b.serialNumber = " + serial, BookEntity.class).getSingleResult();
	return book;
    }
    
    @Override
    public CompletableFuture<BookEntity> findBookBySerial(Long serial) {
	
	return supplyAsync(() -> wrap(em -> {
	    return listBySerial(serial, em);
	}), executionContext) ;
    }
    
    @Override
    public void save(BookEntity bookEntity) {
    
        supplyAsync(() -> wrap(em -> insert(em, bookEntity)), executionContext);
    }
}
