package ra.entity;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, boolean catalogStatus, String descriptions) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.catalogStatus = catalogStatus;
        this.descriptions = descriptions;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void inputDataCatalog(Scanner sc) {
//catalogId – int: mã danh mục, tự tăng – Khi tạo danh mục mới mã
//danh mục lấy mã danh mục lớn nhất + 1
        this.catalogId = inputCatalogId(sc);
//catalogName – String: tên danh mục, có độ dài tối đa 50 ký tự,
//không trùng lặp
        this.catalogName = inputCatalogName(sc);
//descriptions – String: mô tả danh mục
        this.descriptions = InputDescription(sc);
//catalogStatus – Boolean: chỉ nhận khi nhập 1 trong 2 giá trị true
//hoặc false (true – hoạt động, false – không hoạt động)
        this.catalogStatus = InputCatalogStatus(sc);
    }

    public int inputCatalogId(Scanner sc) {
        do {
//            System.out.println("Nhập Id catalog");
//            int catalogId = Integer.parseInt(sc.nextLine());
            if(ShopManagement.indexCategories == 0){
                return catalogId +1;
            } else {
                int maxId = ShopManagement.arrCategories[0].getCatalogId();
                for(int i = 1; i < ShopManagement.indexCategories; i++){
                    if(maxId < ShopManagement.arrCategories[i].getCatalogId()){
                        maxId = ShopManagement.arrCategories[i].getCatalogId();

                    }
                }
                return maxId +1;
            }
        }while (true);
    }
    public String inputCatalogName(Scanner sc) {
        do {
            System.out.println("Nhập tên catalog: ");
            String catalogName = sc.nextLine();
           if(catalogName.length() <= 50){
               boolean isExit = false;
               for(int i = 0; i < ShopManagement.indexCategories; i++){
                   if(ShopManagement.arrCategories[i].getCatalogName().equals(catalogName)){
                       isExit = true;
                       break;
                   }
               }
               if(isExit){
                   System.err.println("Tên đã tồn tại");
               }else {
                   return catalogName;
               }
           }else {
               System.err.println("tên có độ dài <= 50");
           }

        }while (true);
    }
    public String InputDescription(Scanner sc) {
        System.out.println("Nhập mô tả");
        return sc.nextLine();
    }
    public boolean InputCatalogStatus(Scanner sc) {
       do {
           System.out.println("Nhập trạng thái");
           String catalogStatus = sc.nextLine();
           if(catalogStatus.equals("true") || catalogStatus.equals("false")){
               return Boolean.parseBoolean(catalogStatus);
           }else {
               System.err.println("chỉ nhận true/false");
           }
       }while (true);
    }
//    public void demo(){
//        this.catalogId = 001;
//        this.catalogName = "quang";
//        this.catalogStatus = true;
//        this.descriptions = "very nice";
//        DisplayCategories();
//    }

    public void DisplayCategories() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("|Id:\t%-5d|Name:\t%-10s|Des:\t%-10s|Status:\t%-10s|\n",
                catalogId, catalogName,descriptions, catalogStatus ? "Hoạt động" : "Không hoạt động");
        System.out.println("--------------------------------------------------------------------------");
    }

}
