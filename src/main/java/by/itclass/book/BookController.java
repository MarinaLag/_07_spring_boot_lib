package by.itclass.book;

import by.itclass.library.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    private BookRepository bookRepository;
    private LibraryRepository libraryRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GetMapping(value = "/addBook/{id}")
    public ModelAndView addBook(@PathVariable(name = "id") int id) {
        return new ModelAndView("add-book", "book", new BookIntLibrary(id));
    }

    @PostMapping(value = "/saveBook")
    public String saveBook(@ModelAttribute(name = "book") BookIntLibrary bookIntLibrary) {
        var book = new Book(bookIntLibrary.getTitle(), bookIntLibrary.getPages());
        book.setLibrary(libraryRepository.findById(bookIntLibrary.getLibrary_id()).get());
        bookRepository.save(book);
        return "redirect:/view/" + bookIntLibrary.getLibrary_id();
    }

    @GetMapping(value = "/deleteBook/{libraryId}/{bookId}")
    public String deleteBook(
            @PathVariable(name = "libraryId") int libraryId,
            @PathVariable(name = "bookId") int bookId) {
        bookRepository.deleteById(bookId);
        return "redirect:/view/" + libraryId;
    }
}
