package service;

import model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book findById(int id);

}
