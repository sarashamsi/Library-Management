package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    // TODO: Define a data structure that stores ISBNs and their matching Book objects
    private CustomHashMap<String , Book> books ;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        this.books = new CustomHashMap<>() ;
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        books.put(book.getIsbn() , book);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        Book book = books.get(isbn);
        if (book != null && book.isAvailable()){
            return true ;
        } else {
            return false;
        }
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = books.get(isbn);
        if (book != null){
            book.setAvailable(available);
        }
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = books.get(isbn);
        Member member = memberManager.getMember(memberId);
        if (book != null && member != null){
            book.addToWaitlist(member);
        }
    }

    public Member getNextFromWaitlist(String isbn) throws NoSuchFieldException {
        Book book = books.get(isbn);
        if (book != null){
            return book.getNextInWaitlist();
        } else {
            return null;
        }
    }

    public boolean hasWaitlist(String isbn) {
        Book book = books.get(isbn);
        if (book != null && book.hasWaitlist()){
            return true ;
        }else {
            return false;
        }
    }
}