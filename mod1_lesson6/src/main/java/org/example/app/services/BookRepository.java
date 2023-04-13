package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        logger.info("store new book: " + book);
        repo.add(book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        for (Book book : retreiveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                logger.info("remove book completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeBookByRegex(String queryRegex) {
        boolean flag = false;
        if(isNumber(queryRegex)) {
            flag = removeBookBySize(Integer.parseInt(queryRegex));
        }
        for(Book book : retreiveAll()) {
            if(book.getTitle().equalsIgnoreCase(queryRegex) || book.getAuthor().equalsIgnoreCase(queryRegex)) {
                logger.info("remove book completed: " + book);
                repo.remove(book);
                flag = true;
            }
        }
        return flag;
    }

    public boolean removeBookBySize(Integer size) {
        boolean flag = false;
        for(Book book : retreiveAll()) {
            if(book.getSize() != null && book.getSize().intValue() == size.intValue()) {
                logger.info("remove book completed: " + book);
                repo.remove(book);
                flag = true;
            }
        }
        return flag;
    }

    public boolean isNumber(String queryRegex) {
        try {
            Integer.parseInt(queryRegex);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
