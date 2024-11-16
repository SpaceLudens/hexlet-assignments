package exercise.controller;

import java.util.List;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> getAll() {
        return bookService.getAll();
    }

    // Получить книгу по ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    // Создать новую книгу
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@Valid @RequestBody BookCreateDTO bookCreateDTO) {
        return bookService.create(bookCreateDTO);
    }

    // Обновить информацию о книге
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO update(@PathVariable Long id, @Valid @RequestBody BookUpdateDTO bookUpdateDTO) {
        return bookService.update(bookUpdateDTO, id);
    }

    // Удалить книгу по ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
    // END
}
