package repository;

import com.google.inject.ImplementedBy;
import entity.BookEntity;

import java.util.concurrent.CompletableFuture;

@ImplementedBy(JPABookRepository.class)
public interface BookRepository {
    
    CompletableFuture<BookEntity> findBookBySerial(Long serial);
    
    void save(BookEntity bookEntity);
}
