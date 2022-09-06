import color.Color;
import models.Book;
import repos.BookHelper;

import java.util.List;

/**
 * Домашнее задание 4
 * Задание 6
 * Создать Gradle (Maven) -проект и настроить его под Hibernate.
 * Взять пример ex_003_hibernate_get_and_insert.
 * Получить объект Book и коллекцию объектов.
 * Получить конкретный Book по id.
 * Добавить Новый Book. И это все реализовать в классе BookHelper.
 */

public class Main {
    public static void main(String[] args) {
        BookHelper bookHelper = new BookHelper();
        Book[] masBooks = {new Book("Фактор Черчилля", 1), new Book("Чистый код", 4),
                new Book("Зелёный свет", 3)};

        //добавление книг
        for (Book book : masBooks) {
            bookHelper.addBook(book);
        }

        //получение коллекции книг
        List<Book> bookList = bookHelper.getBookList();
        for (Book book : bookList) {
            System.out.println(Color.GREEN + book + Color.DEFAULT);
        }

        //добавление новой книги
        Book book4 = new Book("Java Библиотека профессионала", 2);
        bookHelper.addBook(book4);

        //получение книги по Id 2
        System.out.println(Color.GREEN + bookHelper.getById(4) + Color.DEFAULT);

        //редактирование имени книги по Id 1
        bookHelper.updateNameById(1, "Паттерны проектирования");

        //получение коллекции книг
        List<Book> bookList2 = bookHelper.getBookList();
        for (Book book : bookList2) {
            System.out.println(Color.GREEN + book + Color.DEFAULT);
        }

       //удаление книги с Id 3
        Book book5 = bookHelper.getById(3);
        bookHelper.removeBook(book5);

    }
}
