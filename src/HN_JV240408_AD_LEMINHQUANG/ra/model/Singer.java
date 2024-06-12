package HN_JV240408_AD_LEMINHQUANG.ra.model;

import HN_JV240408_AD_LEMINHQUANG.ra.run.MusicManagement;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
    }

    public Singer(int age, boolean gender, String genre, String nationality, int singerId, String singerName) {
        this.age = age;
        this.gender = gender;
        this.genre = genre;
        this.nationality = nationality;
        this.singerId = singerId;
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public void inputSinger(Scanner scanner) {
        // ▪ singerId– mã ca sĩ– int (Tự động tăng)
        this.singerId = inputSingerId();
        // ▪ singerName– tên ca sĩ– String (Không được để trống)
        this.singerName = inputSingerName(scanner);
        // ▪ age– ttuổi– int (Phải lớn hơn 0)
        this.age = inputAge(scanner);
        // ▪ nationality– quốc tịch– String (không được để trống)
        this.nationality = inputNationality(scanner);
        // ▪ gender- giới tính- boolean
        this.gender = inputGender(scanner);
        // ▪ genre- thể loại- String (Không được để trống)
        this.genre = inputGenre(scanner);
    }

    public int inputSingerId() {
        do {
            if (MusicManagement.indexSinger == 0) {
                return this.singerId + 1;
            } else {
                int max = MusicManagement.arrSingers[0].getSingerId();
                for (int i = 0; i < MusicManagement.indexSinger; i++) {
                    if (max < MusicManagement.arrSingers[i].getSingerId()) {
                        max = MusicManagement.arrSingers[i].getSingerId();
                    }
                }
                return max + 1;
            }
        } while (true);
    }
    public String inputSingerName(Scanner scanner) {
       do {
           System.out.println("Nhập tên ca sĩ:");
           String singerName = scanner.nextLine();
           if(singerName.length() == 0){
               System.err.println("Không được để trống");
           }else {
               return singerName;
           }
       }while (true);
    }
    public  int inputAge(Scanner scanner) {
        do {
            System.out.println("nhập tuổi ca sĩ:");
            int age = Integer.parseInt(scanner.nextLine());
            if(age > 0){
                return age;
            }else {
                System.err.println("tuổi phải lớn hơn 0");
            }
        }while (true);

    }
    public String inputNationality(Scanner scanner) {
       do {
           System.out.println("Nhập quốc tịch:");
           String nationality = scanner.nextLine();
           if(nationality.length() == 0){
               System.err.println("Quốc tịch không được để trống");
           }else {
               return nationality;
           }
       }while (true);
    }
    public boolean inputGender(Scanner scanner) {
        do {
            System.out.println("Nhập giới tính");
            String gender = scanner.nextLine();
            if(gender.equals("true") || gender.equals("false")){
                return Boolean.parseBoolean(gender);
            }else {
                System.err.println("chỉ nhận true hoặc false");
            }
        }while (true);
    }
    public String inputGenre (Scanner scanner) {
        do {
            System.out.println("Nhập thể loại");
            String genre = scanner.nextLine();
            if(genre.trim().isEmpty()){
                System.err.println("không được để trống");
            }else {
                return genre;
            }
        }while (true);
    }

    public void displaySinger() {
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("|ID: %d|Name: %s|age: %d|nationlity: %s|Gender: %b|Genre: %s| \n",
                singerId, singerName, age, nationality, gender ? "Nam" : "Nữ", genre);
        System.out.println("----------------------------------------------------------------------");
    }
}
