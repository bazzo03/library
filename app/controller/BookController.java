package controller;

import com.google.inject.Inject;
import dto.BookDto;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.BookService;

import java.util.concurrent.CompletionStage;

public class BookController extends Controller {
    
    @Inject
    private BookService bookService;
    
    public Result saveBook() {
        
        BookDto bookDto = Json.fromJson(request().body().asJson(), BookDto.class);
        if (bookService.saveBook(bookDto)) {
            return ok();
        }
        return internalServerError();
    }
    
    public CompletionStage<Result> findBookBySerial(Long serial) {
        
        return bookService.findBookBySerial(serial).thenApplyAsync((x) -> {
            return ok(Json.toJson(x));
        });
    }
    
}
