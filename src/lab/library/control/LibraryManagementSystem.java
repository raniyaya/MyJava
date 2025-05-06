package lab.library.control;

import lab.library.entity.Book;
import lab.library.entity.Library;

import java.util.List;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library("�߾� ������");

        addSampleBooks(library);
        printLibraryStatus(library);

        testFindBook(library);
        testCheckOut(library);
        testReturn(library);
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        System.out.println("������ �߰��Ǿ����ϴ�: �ڹ� ���α׷���");

        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        System.out.println("������ �߰��Ǿ����ϴ�: ��ü������ ��ǰ� ����");

        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        System.out.println("������ �߰��Ǿ����ϴ�: Clean Code");

        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        System.out.println("������ �߰��Ǿ����ϴ�: Effective Java");

        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        System.out.println("������ �߰��Ǿ����ϴ�: Head First Java");

        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
        System.out.println("������ �߰��Ǿ����ϴ�: �ڹ��� ����");
    }

    private static void printLibraryStatus(Library library) {
        System.out.println("\n===== �߾� ������ =====");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
    }

    private static void printLibraryCurrentStatus(Library library) {
        System.out.println("\n������ ���� ����");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
    }

    private static void testFindBook(Library library) {
        System.out.println("\n===== ���� �˻� �׽�Ʈ =====");

        List<Book> titleSearch = library.findBookByTitle("�ڹ��� ����");
        System.out.println("�������� �˻� ���:");
        for (Book book : titleSearch) {
            printBookInfo(book);
        }

        List<Book> authorSearch = library.findBooksByAuthor("Robert C. Martin");
        System.out.println("\n���ڷ� �˻� ���:");
        for (Book book : authorSearch) {
            printBookInfo(book);
        }
    }

    private static void testCheckOut(Library library) {
        System.out.println("\n===== ���� ���� �׽�Ʈ =====");
        boolean success = library.checkOutBook("978-89-01-14077-4");
        if (success) {
            System.out.println("���� ���� ����!");
            Book book = library.findBookByISBN("978-89-01-14077-4");
            System.out.println("����� ���� ����:");
            printBookInfo(book);
        } else {
            System.out.println("���� ���� ����!");
        }
        printLibraryCurrentStatus(library);
    }

    private static void testReturn(Library library) {
        System.out.println("\n===== ���� �ݳ� �׽�Ʈ =====");
        boolean success = library.returnBook("978-89-01-14077-4");
        if (success) {
            System.out.println("���� �ݳ� ����!");
            Book book = library.findBookByISBN("978-89-01-14077-4");
            System.out.println("�ݳ��� ���� ����:");
            printBookInfo(book);
        } else {
            System.out.println("���� �ݳ� ����!");
        }
        printLibraryCurrentStatus(library);
    }

    private static void displayAvailableBooks(Library library) {
        System.out.println("\n===== ���� ������ ���� ��� =====");
        for (Book book : library.getAvailableBooks()) {
            printBookInfo(book);
            System.out.println("------------------------");
        }
    }

    // ���� å ���� ��� �޼���
    private static void printBookInfo(Book book) {
        System.out.println("å ����: " + book.getTitle()
                + "\t����: " + book.getAuthor()
                + "\tISBN: " + book.getIsbn()
                + "\t���ǳ⵵: " + book.getPublishYear()
                + "\t���� ���� ����: " + (book.isAvailable() ? "����" : "���� ��"));
    }
}
