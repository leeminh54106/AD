package HN_JV240408_AD_LEMINHQUANG.ra.run;

import HN_JV240408_AD_LEMINHQUANG.ra.model.Singer;
import HN_JV240408_AD_LEMINHQUANG.ra.model.Song;

import java.util.Scanner;

public class MusicManagement {
    public static Singer[] arrSingers = new Singer[100];
    public static int indexSinger = 0;
    public static Song[] arrSongs = new Song[100];
    public static int indexSong = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát ");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    singerManage(scanner);
                    break;
                case 2:
                    songManagement(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lựa chọn sai, xin hãy nhập lại");
            }
        } while (true);
    }


    public static void inputArrSingers(Scanner scanner) {
        System.out.println("Nhập số lượng ca sĩ:");
        int number = Integer.parseInt(scanner.nextLine());
        if (number == 0) {
            System.err.println("không được để trống");
        } else {
            for (int i = 0; i < number; i++) {
                arrSingers[indexSinger] = new Singer();
                arrSingers[indexSinger].inputSinger(scanner);
                indexSinger++;
            }
        }
    }

    public static void displayArrSingers() {
        for (int i = 0; i < indexSinger; i++) {
            arrSingers[i].displaySinger();
        }
    }

    public static void updateArrSingers(Scanner scanner) {
        System.out.println("nhập id cần update:");
        int singerId = Integer.parseInt(scanner.nextLine());
        int idUpdate = getIndexBySingerId(singerId);
        if (indexSinger >= 0) {
            System.out.println("nhập tên update:");
            arrSingers[idUpdate].setSingerName(scanner.nextLine());
            System.out.println("nhập tuổi update:");
            arrSingers[idUpdate].setAge(Integer.parseInt(scanner.nextLine()));
            System.out.println("nhập quốc tịch update");
            arrSingers[idUpdate].setNationality(scanner.nextLine());
            System.out.println("nhập giới tính update");
            arrSingers[idUpdate].setGender(Boolean.parseBoolean(scanner.nextLine()));
            System.out.println("nhập thể loại update:");
            arrSingers[idUpdate].setGenre(scanner.nextLine());
        } else {
            System.err.println("danh mục trống");
        }
    }

    public static int getIndexBySingerId(int singerId) {

        for (int i = 0; i < indexSinger; i++) {
            if (arrSingers[i].getSingerId() == singerId) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteArrSingers(Scanner scanner) {
        System.out.println("Nhập ID ca sĩ muốn xóa");
        int singerId = Integer.parseInt(scanner.nextLine());
        int indexDelete = getIndexBySingerId(singerId);
        if (indexDelete >= 0) {
            boolean inExit = false;
            for (int i = 0; i < indexSong; i++) {
                if (arrSongs[i].getSinger().getSingerId() == singerId) {
                    System.err.println("Không thể xóa được vì tồn tại bài hát");
                } else {
                    for (int j = indexDelete; j < indexSinger; j++) {
                        arrSingers[j] = arrSingers[j + 1];
                    }
                    --indexSinger;
                }
            }
        } else {
            System.err.println("ID không tồn tại");
        }
    }

    public static void singerManage(Scanner scanner) {
        boolean quit = true;
        do {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println(" 1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println(" 2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println(" 3.Thay đổi thông tin ca sĩ theo mã id");
            System.out.println(" 4.Xóa ca sĩ theo mã id");
            System.out.println(" 5.Thoát");
            System.out.println("lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputArrSingers(scanner);
                    break;
                case 2:
                    displayArrSingers();
                    break;
                case 3:
                    updateArrSingers(scanner);
                    break;
                case 4:
                    // 4.Xóa ca sĩ theo mã id (kiểm tra xem nếu ca sĩ có bài hát thì không xóa được)
                    deleteArrSingers(scanner);
                    break;
                case 5:
                    quit = false;
                    break;
                default:
                    System.err.println("lựa chọn không đúng,vui lòng chọn lại");
            }
        } while (quit);
    }

    public static void songManagement(Scanner scanner) {
        boolean exit = true;
        do {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println(" 1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println(" 2.Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println(" 3.Thay đổi thông tin bài hát theo mã id");
            System.out.println(" 4.Xóa bài hát theo mã id");
            System.out.println(" 5.Thoát");
            System.out.println("lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputArrSong(scanner);
                    break;
                case 2:
                    displayArrSong();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    exit = false;
                    break;
                default:
                    System.err.println("lựa chọn không đúng,vui lòng chọn lại");
            }

        } while (exit);
    }

    public static void inputArrSong(Scanner scanner) {
        System.out.println("Nhập số lượng bài hát:");
        int number = Integer.parseInt(scanner.nextLine());
        if (number == 0) {
            System.err.println("không được để trống");
        } else {
            for (int i = 0; i < number; i++) {
                arrSongs[indexSong] = new Song();
                arrSongs[indexSong].inputSong(scanner);
                indexSong++;
            }
        }
    }
    public static void displayArrSong() {
        for (int i = 0; i < indexSong; i++) {
            arrSongs[i].displaySong();
        }
    }
    public static void updateArrSong(Scanner scanner) {
        System.out.println("nhập id cần update:");
        int songId = Integer.parseInt(scanner.nextLine());
        int idUpdate = getIndexBySingerId(songId);
        if (indexSong >= 0) {
            for(int i =0; i < indexSong; i++) {

            }
//            System.out.println("nhập tên update:");
//            arrSongs[idUpdate].setSongName(scanner.nextLine());
//
//            System.out.println("nhập mô tả update");
//            arrSongs[idUpdate].setDescriptions(scanner.nextLine());
//
////            System.out.println("nhập ca sĩ update:");
////            arrSongs[idUpdate].setSinger();
//            System.out.println("nhập trạng thái update:");
//            arrSongs[idUpdate].isSongStatus(Boolean.parseBoolean(scanner.nextLine()));

        } else {
            System.err.println("danh mục trống");
        }
    }
}
