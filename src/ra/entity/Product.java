package ra.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    private String productid;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(int catalogId, Date created, String description, float price, String productid, String productName, int productStatus) {
        this.catalogId = catalogId;
        this.created = created;
        this.description = description;
        this.price = price;
        this.productid = productid;
        this.productName = productName;
        this.productStatus = productStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputProduct(Scanner sc) {
        // productid – String: mã sản phẩm đồ uống, gồm 4 ký tự bắt đầu là
        //một trong 3 ký tự (C: các đồ uống là café, S: các đồ uống là sinh
        //tố, A: các đồ ăn nhanh), không được trùng lặp
        this.productid = inputProductId(sc);
        //productName – String: tên sản phẩm đồ uống, có từ 10-50 ký tự,
        //không được trùng lặp
        this.productName = inputProductName(sc);
        //price – float: giá sản phẩm có giá trị lớn hơn 0
        this.price = inputPrice(sc);
        //description – String: mô tả sản phẩm
        this.description = inputDescription(sc);
        //created – date: ngày nhập sản phẩm có định dạng dd/mm/yyyy
        this.created = inputCreated(sc);
        //catalogId – int: Mã danh mục mà sản phẩm thuộc về
        this.catalogId = inputCatalogId(sc);
        //productStatus – int: trạng thái sản phẩm, chỉ nhận 1 trong các trạng
        //thái sau (0: Đang bán – 1: Hết hàng – 2: Không bán)
        this.productStatus = inputProductStatus(sc);

    }

    public String inputProductId(Scanner sc) {
        String productIdRegex = "[CSA]\\w{3}";
        do {
            System.out.println("Nhập mã sản phẩm :");
            String productid = sc.nextLine();
            if (Pattern.matches(productIdRegex, productid)) {
                boolean isExit = false;
                for (int i = 0; i < ShopManagement.indexProducts; i++) {
                    if (ShopManagement.arrProducts[i].getProductid().equals(productid)) {
                        isExit = true;
                        break;
                    }
                }
                if (isExit) {
                    System.err.println("Mã đã tồn tại");
                } else {
                    return productid;
                }
            } else {
                System.err.println("4 kí tự và bắt đầu là CSA");
            }
        } while (true);
    }

    public String inputProductName(Scanner sc) {
        do {
            System.out.println("Nhập tên sản phẩm");
            String productName = sc.nextLine();
            if (productName.length() >= 10 && productName.length() <= 50) {
                boolean isExit = false;
                for (int i = 0; i < ShopManagement.indexProducts; i++) {
                    if (ShopManagement.arrProducts[i].getProductid().equals(productName)) {
                        isExit = true;
                        break;
                    }
                }
                if (isExit) {
                    System.err.println("Tên sản phẩm đã tồn tại");
                } else {
                    return productName;
                }
            } else {
                System.err.println("độ dài >=10 && <= 50");
            }
        } while (true);
    }

    public float inputPrice(Scanner sc) {
        do {
            System.out.println("Nhập giá sản phẩm");
            float price = Float.parseFloat(sc.nextLine());
            if (price > 0) {
                return price;
            } else {
                System.err.println("Giá sản phẩm phải > 0");
            }
        } while (true);
    }

    public String inputDescription(Scanner sc) {
        System.out.println("Nhập mô tả");
        return sc.nextLine();
    }

    public Date inputCreated(Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nhập vào ngày nhập sản phẩm:");
        do {
            try {
                Date created = sdf.parse(scanner.nextLine());
                return created;
            } catch (Exception ex) {
                System.err.println("Định dạng ngày nhập là dd/MM/yyyy, vui lòng nhập lại");
            }
        } while (true);
    }

    public int inputCatalogId(Scanner sc) {
        do {
            System.out.println("Lưạ chọn danh mục");
            for (int i = 0; i < ShopManagement.indexCategories; i++) {
                System.out.printf("%d. %s\n", i + 1, ShopManagement.arrCategories[i].getCatalogName());
            }
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 0 && choice <= ShopManagement.indexCategories) {
                return ShopManagement.arrCategories[choice - 1].getCatalogId();
            } else {
                System.err.println("bạn chưa chọn đúng danh mục");
            }
        } while (true);
    }

    public int inputProductStatus(Scanner sc) {
        do {
            System.out.println("----------chọn trạng thái sản phẩm------------");
            System.out.println("           1. Đang bán");
            System.out.println("           2. Hết hàng");
            System.out.println("           3. Không bán");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice > 0 && choice < 4){
                return choice -1;
            }else {
                System.err.println("lựa chọn không đúng");
            }
        } while (true);
    }

    public void displayProduct(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("|Id:\t%-5s|Name:\t%-10s|Des:\t%-10s|Status:\t%-10s|Price: \t%-10.2f|Date: \t%-10s|\n",
                productid,productName,description,
                (productStatus == 0) ? "Đang bán":(productStatus == 1) ? "Hết hàng":"Không bán",price,created);
        System.out.println("--------------------------------------------------------------------------");
    }
}
