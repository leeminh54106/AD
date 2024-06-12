package HN_JV240408_BS_LEMINHQUANG.ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(String author, int bookId, String bookName, boolean bookStatus, String descriptions, double exportPrice, double importPrice, float interest) {
        this.author = author;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookStatus = bookStatus;
        this.descriptions = descriptions;
        this.exportPrice = exportPrice;
        this.importPrice = importPrice;
        this.interest = interest;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public void inputBook(Scanner scanner) {
        //bookId–mã sách– int (Tự động tăng)
        this.bookId = inputBookId();
        //▪ bookName–tên sách– String (Không được để trống)
        this.bookName = inputBookName(scanner);
        //author– tác giả– String (Không được để trống)
        this.author = inputAuthor(scanner);
        //descriptions– mô tả về sách– String (Không được để trống, ít nhất 10 ký tự)
        this.descriptions = inputBookDescription(scanner);
        //importPrice– giá nhập– double (phải lớn hơn 0)
        this.importPrice = inputImportPrice(scanner);
        //exportPrice– giá xuất– double (phải lớn hơn 1.2 lần giá nhập)
        this.exportPrice = inputExportPrice(scanner);
        //interest– lợi nhuận– float
        this.interest = inputInterest();
        //bookStatus– trạng thái– Boolean (mặc định là true)
        this.bookStatus = true;
    }

    public int inputBookId() {
        do {
            if (BookManagement.indexBook == 0) {
                return this.bookId + 1;
            } else {
                int max = BookManagement.arrBook[0].getBookId();
                for (int i = 1; i < BookManagement.indexBook; i++) {
                    if (max < BookManagement.arrBook[i].getBookId()) {
                        max = BookManagement.arrBook[i].getBookId();
                    }
                }
                return max + 1;
            }
        } while (true);

    }

    public String inputBookName(Scanner scanner) {
        do {
            System.out.println("Nhập tên sách:");
            String bookName = scanner.nextLine();
            if (bookName.length() == 0) {
                System.err.println("không được để trống");
            } else {
                return bookName;
            }
        } while (true);
    }

    public String inputAuthor(Scanner scanner) {
        do {
            System.out.println("Nhập tên tác giả:");
            String author = scanner.nextLine();
            if (author.length() == 0) {
                System.err.println("Không được để trống");
            } else {
                return author;
            }
        } while (true);
    }

    public String inputBookDescription(Scanner scanner) {
        do {
            System.out.println("Nhập mô tả:");
            String bookDescription = scanner.nextLine();
            if (bookDescription.length() == 0) {
                System.err.println("Không được để trống");
            } else {
                if (bookDescription.length() >= 10) {
                    return bookDescription;
                } else {
                    System.err.println(" không được nhỏ hơn 10 ký tự");
                }

            }
        } while (true);
    }

    public double inputImportPrice(Scanner scanner) {
        do {
            System.out.println("Giá nhập vào:");
            double importPrice = Double.parseDouble(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("phải > 0");
            }
        } while (true);
    }

    public double inputExportPrice(Scanner scanner) {
        do {
            System.out.println("Nhập giá xuất:");
            double exportPrice = Double.parseDouble(scanner.nextLine());
            if (exportPrice > this.importPrice * 1.2) {
                return exportPrice;
            } else {
                System.err.println("giá bán phải > 120% giá nhập");
            }
        } while (true);
    }

    public float inputInterest() {
        return (float) (this.exportPrice - this.importPrice);
    }

    public void displayBook() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("|Id:\t%-5d|Name:\t%-10s|Author:\t%-10s|Descriptions:\t%-10s|\n",
                this.bookId, this.bookName, this.author, this.descriptions);
        System.out.printf("|ImportPrice: \t%-10.0f|ExportPrice: \t%-10.0f|Interest: \t%-10.0f|Status \t%b\n",
                this.importPrice, this.exportPrice, this.interest, this.bookStatus);
        System.out.println("--------------------------------------------------------------------------");
    }
}
