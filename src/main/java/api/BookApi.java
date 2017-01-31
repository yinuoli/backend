package api;

import template.Book.BookDao;

public class BookApi {
    private BookDao dao;

    public void setDao(BookDao dao) {
        this.dao = dao;
    }
}
