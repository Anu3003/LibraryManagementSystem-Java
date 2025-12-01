import java.util.*;

public class Library {
    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, Member> members = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    // ---------------------- BOOK OPERATIONS ---------------------- //
    public void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();

        if (books.containsKey(id)) {
            System.out.println("Book ID already exists!");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        books.put(id, new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books.values()) {
            System.out.println(b);
        }
    }

    public void searchBook() {
        System.out.print("Enter title/author to search: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Book b : books.values()) {
            if (b.getTitle().toLowerCase().contains(keyword) ||
                b.getAuthor().toLowerCase().contains(keyword)) {
                System.out.println(b);
                found = true;
            }
        }

        if (!found) System.out.println("No matching books found.");
    }

    public void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        String id = scanner.nextLine();

        if (!books.containsKey(id)) {
            System.out.println("Book not found!");
            return;
        }

        Book book = books.get(id);
        if (!book.isAvailable()) {
            System.out.println("Cannot remove! Book is currently issued.");
            return;
        }

        books.remove(id);
        System.out.println("Book removed successfully.");
    }

    // ---------------------- MEMBER OPERATIONS ---------------------- //
    public void addMember() {
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine();

        if (members.containsKey(id)) {
            System.out.println("Member ID already exists!");
            return;
        }

        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();

        members.put(id, new Member(id, name));
        System.out.println("Member added successfully!");
    }

    public void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        for (Member m : members.values()) {
            System.out.println(m);
        }
    }

    public void searchMember() {
        System.out.print("Enter name/ID to search: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Member m : members.values()) {
            if (m.getName().toLowerCase().contains(keyword) ||
                m.getMemberId().toLowerCase().contains(keyword)) {
                System.out.println(m);
                found = true;
            }
        }

        if (!found) System.out.println("No matching members found.");
    }

    public void removeMember() {
        System.out.print("Enter Member ID to remove: ");
        String id = scanner.nextLine();

        if (!members.containsKey(id)) {
            System.out.println("Member not found!");
            return;
        }

        // Check if member has any issued book
        for (Book b : books.values()) {
            if (id.equals(b.getIssuedTo())) {
                System.out.println("Cannot remove member! They have issued books.");
                return;
            }
        }

        members.remove(id);
        System.out.println("Member removed successfully.");
    }

    // ---------------------- ISSUE / RETURN ---------------------- //
    public void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        String bookId = scanner.nextLine();

        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();

        if (!books.containsKey(bookId)) {
            System.out.println("Book not found!");
            return;
        }

        if (!members.containsKey(memberId)) {
            System.out.println("Member not found!");
            return;
        }

        Book book = books.get(bookId);

        if (!book.isAvailable()) {
            System.out.println("Book is already issued!");
            return;
        }

        book.issueTo(memberId);
        System.out.println("Book issued successfully!");
    }

    public void returnBook() {
        System.out.print("Enter Book ID to return: ");
        String bookId = scanner.nextLine();

        if (!books.containsKey(bookId)) {
            System.out.println("Book not found!");
            return;
        }

        Book book = books.get(bookId);

        if (book.isAvailable()) {
            System.out.println("Book is already in library!");
            return;
        }

        book.returnBook();
        System.out.println("Book returned successfully!");
    }

    // ---------------------- MAIN MENU ---------------------- //
    public void showMenu() {
        while (true) {
            System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Add Member");
            System.out.println("6. View Members");
            System.out.println("7. Search Member");
            System.out.println("8. Remove Member");
            System.out.println("9. Issue Book");
            System.out.println("10. Return Book");
            System.out.println("11. Exit");

            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addBook(); break;
                case "2": viewBooks(); break;
                case "3": searchBook(); break;
                case "4": removeBook(); break;
                case "5": addMember(); break;
                case "6": viewMembers(); break;
                case "7": searchMember(); break;
                case "8": removeMember(); break;
                case "9": issueBook(); break;
                case "10": returnBook(); break;
                case "11":
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
