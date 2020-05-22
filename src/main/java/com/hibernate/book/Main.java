package com.hibernate.book;

import com.hibernate.book.lib.Injector;
import com.hibernate.book.model.Author;
import com.hibernate.book.model.Book;
import com.hibernate.book.model.Gender;
import com.hibernate.book.service.AuthorService;
import com.hibernate.book.service.BookService;
import com.hibernate.book.service.GenderService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.hibernate.book");

    public static void main(String[] args) {
        Author author1 = new Author();
        author1.setName("King Stephen");
        AuthorService authorService = (AuthorService) INJECTOR.getInstance(AuthorService.class);
        author1 = authorService.add(author1);

        Author author2 = new Author();
        author2.setName("Rowling Joanne");
        author2 = authorService.add(author2);

        Gender gender1 = new Gender();
        gender1.setDescription("Thriller");
        GenderService genderService = (GenderService) INJECTOR.getInstance(GenderService.class);
        gender1 = genderService.add(gender1);

        Gender gender2 = new Gender();
        gender2.setDescription("Adventure");
        gender2 = genderService.add(gender2);

        Book book1 = new Book();
        book1.setTitle("Dark Tower");
        book1.setAuthors(author1);
        book1.setGender(gender1);
        BookService bookService = (BookService) INJECTOR.getInstance(BookService.class);
        bookService.add(book1);

        Book book2 = new Book();
        book2.setTitle("Harry Potter");
        book2.setAuthors(author2);
        book2.setGender(gender2);
        bookService.add(book2);

        bookService.getByTitle("Harry Potter").forEach(System.out::println);
        bookService.getByGender(gender2).forEach(System.out::println);
        bookService.getByAuthor(author1).forEach(System.out::println);
    }
}
