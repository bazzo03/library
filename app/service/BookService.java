package service;

import com.google.inject.Inject;
import converter.BookConverter;
import entity.BookEntity;
import repository.BookRepository;
import dto.BookDto;

import java.util.concurrent.CompletableFuture;

public class BookService {
    
    @Inject
    private BookRepository bookRepository;
    
    public boolean saveBook(BookDto bookDto) {
        
        bookRepository.save(BookConverter.fromDto(bookDto));
        return true;
    }
    
    public CompletableFuture<BookEntity> findBookBySerial(Long serial) {
        
        System.out.println(serial);
        return bookRepository.findBookBySerial(serial);
    }
}
