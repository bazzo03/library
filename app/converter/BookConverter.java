package converter;

import dto.BookDto;
import entity.BookEntity;

public class BookConverter {
    
    public static BookEntity fromDto(BookDto bookDto) {
	
	BookEntity bookEntity = new BookEntity();
	bookEntity.setAuthorName(bookDto.getAuthorName());
	bookEntity.setName(bookDto.getName());
	bookEntity.setSerialNumber(bookDto.getSerialNumber());
	
	return bookEntity;
    }
    
    public static BookDto toDto(BookEntity bookEntity) {
    
	BookDto bookDto = new BookDto();
	bookDto.setAuthorName(bookEntity.getAuthorName());
	bookDto.setName(bookEntity.getName());
	bookDto.setSerialNumber(bookEntity.getSerialNumber());
	
	return bookDto;
    }
}
