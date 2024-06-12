package HN_JV240408_AD_LEMINHQUANG.ra.model;

import HN_JV240408_AD_LEMINHQUANG.ra.run.MusicManagement;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
    }

    public Song(Date createdDate, String descriptions, Singer singer, String songId, String songName, boolean songStatus, String songWriter) {
        this.createdDate = createdDate;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songId = songId;
        this.songName = songName;
        this.songStatus = songStatus;
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }
    public void inputSong(Scanner scanner){
     for(int i = 0; i < MusicManagement.indexSinger;i++){
         if(MusicManagement.indexSinger == 0){
             System.err.println("Không tồn tại ca sĩ,yêu cầu nhập ca sĩ");
         }else {
             //▪ songId– mã bài hát– String (Có 4 ký tự và bắt đầu bằng kí tự S, không trùng lặp)
             this.songId = inputSongId(scanner);
             // ▪ songName– tên bài hát– String (Không được để trống)
             this.songName = inputSongName(scanner);
             // ▪ descriptions– mô tả bài hát– String
             this.descriptions = inputDescriptions(scanner);
             // ▪ singer- ca sĩ- Singer (không được null)
             this.singer = inputSinger(scanner);
             // ▪ songWriter- người sáng tác- String (không được để trống)
             this.songWriter = inputsongWriter(scanner);
             // ▪ createdDate- ngày tạo- Date (mặc định là thời gian hệ thống)
             this.createdDate = new Date();
             // ▪ songStatus- trạng thái- boolean
             this.songStatus = inputsongStatus(scanner);
         }
     }

    }
    public String inputSongId(Scanner scanner){
        String songRegex = "[S]\\w{3}";
        do {
            System.out.println("Nhập Id bài hát");
            String songId = scanner.nextLine();
            if(Pattern.matches(songRegex,songId)){
                boolean isExit = false;
                for(int i = 0; i < MusicManagement.indexSong; i++){
                    if(MusicManagement.arrSongs[i].getSongId().equals(songId)){
                        isExit = true;
                        break;
                    }
                }
                if(isExit){
                    System.err.println("Id đã tồn tại");
                }else {
                    return songId;
                }
            }else {
                System.err.println("Phải có 4 kí tự bắt đầu bằng chữ S");
            }
        }while (true);
    }
    public String inputSongName(Scanner scanner){
        do {
            System.out.println("Nhập tên bài hát:");
            String songName = scanner.nextLine();
            if(songName.trim().isEmpty()){
                System.err.println("Không được để trống");
            }else {
                return songName;
            }
        }while (true);
    }
    public String inputDescriptions(Scanner scanner){
       do {
           System.out.println("Nhập mô tả:");
           String descriptions = scanner.nextLine();
           if(descriptions.trim().isEmpty()){
               System.err.println("Không được để trống");
           }else {
               if(descriptions.length() > 10){
                   return descriptions;
               }else {
                   System.err.println("phải > 10 ký tự");
               }
           }
       }while (true);
    }

    public Singer inputSinger(Scanner scanner){
        for(int i = 0; i < MusicManagement.indexSinger;i++){
            MusicManagement.arrSingers[i].displaySinger();
        }
       do {
           System.out.println("nhập id tên ca sĩ:");
           int singerId = Integer.parseInt(scanner.nextLine());
           for(int i = 0; i < MusicManagement.indexSinger; i++){
               if(MusicManagement.arrSingers[i].getSingerId() == singerId){
                   return MusicManagement.arrSingers[i];
               }
           }
       }while (true);
    }

    public String inputsongWriter(Scanner scanner){
        do {
            System.out.println("Người sáng tác:");
            String songWriter = scanner.nextLine();
            if(songWriter.trim().isEmpty()){
                System.err.println("Không được để trống");
            }else {
                return songWriter;
            }
        }while (true);
    }
    public  boolean inputsongStatus(Scanner scanner){
       do {
           System.out.println("Nhập trạng thái status");
           String status = scanner.nextLine();
           if(status.equals("true")||status.equals("false")){
               return Boolean.parseBoolean(status);
           }else {
               System.err.println("chỉ nhận true hoặc false");
           }
       }while (true);
    }

    public void displaySong(){
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("|Id: %s|Name: %s|Mô tả: %s|ca sĩ: %s|NST: %s|Date: %s|Status: %b|\n",
                songId, songName, singer, songWriter, createdDate, songStatus ? "Hot trend" : "Down trend");
        System.out.println("---------------------------------------------------------------------------");
    }
}
