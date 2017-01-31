package api;

import template.Book.BookDao;

public class BookApi {
    private BookDao dao;

    public void setDbi(BookDao dao) {
        this.dao = dao;
    }
}
