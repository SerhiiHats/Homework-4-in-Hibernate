import color.Color;
import models.Book;
import repos.BookHelper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookHelper bookHelper = new BookHelper();
        Book book1 = new Book(0, "Фактор Черчилля", 1);
        Book book2 = new Book(0, "Чистый код", 4);
        Book book3 = new Book(0, "Зелёный свет", 3);
        System.out.println(Color.BLUE + "добавление книг" + Color.DEFAULT);
        System.out.println(Color.GREEN + "Добавлена книга: " + bookHelper.addBook(book1) + Color.DEFAULT);
        System.out.println(Color.GREEN + "Добавлена книга: " + bookHelper.addBook(book2) + Color.DEFAULT);
        System.out.println(Color.GREEN + "Добавлена книга: " + bookHelper.addBook(book3) + Color.DEFAULT);

        System.out.println(Color.BLUE + "получение коллекции книг" + Color.DEFAULT);
        List<Book> bookList = bookHelper.getBookList();
        for (Book book : bookList) {
            System.out.println(Color.GREEN + book + Color.DEFAULT);
        }

        System.out.println(Color.BLUE + "получение книги по Id" + Color.DEFAULT);
        System.out.println(Color.GREEN + bookHelper.getById(2) + Color.DEFAULT);

        System.out.println(Color.BLUE + "добавление книги" + Color.DEFAULT);
        Book book4 = new Book(0, "Java Библиотека профессионала", 2);
        System.out.println(Color.GREEN + "Добавлена книга: " + bookHelper.addBook(book4) + Color.DEFAULT);

        System.out.println(Color.BLUE + "получение коллекции книг" + Color.DEFAULT);
        List<Book> bookList2 = bookHelper.getBookList();
        for (Book book : bookList2) {
            System.out.println(Color.GREEN + book + Color.DEFAULT);
        }

        System.out.println(Color.BLUE + "удаление книги по Id" + Color.DEFAULT);
        Book book5 = bookHelper.getById(4);
        bookHelper.removeBook(book5);
        System.out.println(Color.GREEN + "Удалена книга: " + book5 + Color.DEFAULT);


        System.out.println(Color.BLUE + "получение коллекции книг" + Color.DEFAULT);
        List<Book> bookList3 = bookHelper.getBookList();
        for (Book book : bookList3) {
            System.out.println(Color.GREEN + book + Color.DEFAULT);
        }



    }
}
