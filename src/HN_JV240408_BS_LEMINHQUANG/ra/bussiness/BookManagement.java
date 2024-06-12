package HN_JV240408_BS_LEMINHQUANG.ra.bussiness;

import java.util.Scanner;

public class BookManagement {
    public static Book[] arrBook = new Book[100];
    public static int indexBook = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("***************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println("lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    //Nhập số sách (n) cần nhập thông tin từ bàn phím và thực hiện nhập thông tin cho
                    // n cuốn sách đó , yêu cầu validate dữ liệu.(danh sách tối đa là 100 phần tử
                    inputArrBook(scanner);
                    break;
                case 2:
                    //Hiển thị tất cả sách đang lưu trữ .
                    displayArrBook();
                    break;
                case 3:
                    // Sử dụng thuật toán sắp xếp để sắp xếp sách đang lưu trữ theo lợi nhuận tăng.
                    sortbyInterest();
                    break;
                case 4:
                    //Nhập mã sách cần xóa từ bàn phím, thực hiện xóa sách trong danh sách.
                    deleteArrBook(scanner);
                    break;
                case 5:
                    //: Nhập chuỗi tìm kiếm từ bàn phím, thực hiện tìm và in ra những sách có tên hoặc
                    // môtả phù hợp.
                    searchArrBook(scanner);
                    break;
                case 6:
                    // Nhập vào mã sản phẩm, thay đổi các thông tin sách , chú ý validate dữ liệu như
                    // thêm mới
                    updateArrBook(scanner);
                    break;
                case 7:
                    System.exit(0);
                    //Thoát khỏi chương trình
                    break;
                default:
                    System.err.println("lựa chọn không đúng, vui lòng nhập lại");

            }
        } while (true);
    }

    public static void inputArrBook(Scanner scanner) {
        System.out.println("nhập số lượng sách cần thêm");
        int number = Integer.parseInt(scanner.nextLine());
        if (number == 0) {
            System.err.println("số lượng cần nhập phải lớn hơn 0");
        } else {
            for (int i = 0; i < number; i++) {
                arrBook[indexBook] = new Book();
                arrBook[indexBook].inputBook(scanner);
                indexBook++;
            }
        }
    }

    public static void displayArrBook() {
        for (int i = 0; i < indexBook; i++) {
            arrBook[i].displayBook();
        }
    }

    public static void sortbyInterest() {
        for (int i = 0; i < indexBook - 1; i++) {
            for (int j = i + 1; j < indexBook; j++) {
                if (arrBook[i].getInterest() > arrBook[j].getInterest()) {
                    Book temp = arrBook[i];
                    arrBook[i] = arrBook[j];
                    arrBook[j] = temp;

                }
            }
        }
    }

    public static void deleteArrBook(Scanner scanner) {
        System.out.println("nhập mã sách cần xóa");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < indexBook; i++) {
            if (arrBook[i].getBookId() == number) {
                for (int j = i; j < indexBook; j++) {
                    arrBook[j] = arrBook[j + 1];
                }
                indexBook--;
                break;
            }
        }

    }

    public static void searchArrBook(Scanner scanner) {
        System.out.println("nhập tên sách cần tìm");
        String search = scanner.nextLine();
        for (int i = 0; i < indexBook; i++) {
            if (arrBook[i].getBookName().toLowerCase().contains(search.toLowerCase())) {
                arrBook[i].displayBook();
                break;
            } else {
                System.err.println("sách không tồn tại");
            }
        }
    }

    public static void updateArrBook(Scanner scanner) {
        System.out.println("nhập id cần sửa");
        int bookId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < indexBook; i++) {
            if (arrBook[i].getBookId() == bookId) {
                System.out.println("tên sách mới:");
                arrBook[i].setBookName(scanner.nextLine());
                System.out.println("tên tác giả mới");
                arrBook[i].setAuthor(scanner.nextLine());
                System.out.println("giá mới:");
                arrBook[i].setImportPrice(Integer.parseInt(scanner.nextLine()));
            }
        }
    }


}
