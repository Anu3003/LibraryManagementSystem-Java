public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private String issuedTo;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.issuedTo = null;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public String getIssuedTo() { return issuedTo; }

    public void issueTo(String memberId) {
        this.isAvailable = false;
        this.issuedTo = memberId;
    }

    public void returnBook() {
        this.isAvailable = true;
        this.issuedTo = null;
    }

    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Issued to Member ID: " + issuedTo;
        return "[" + bookId + "] " + title + " by " + author + " - " + status;
    }
}
