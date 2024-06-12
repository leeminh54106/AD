package ra.entity;

import java.util.Scanner;

public class ShopManagement {
    public static Categories[] arrCategories = new Categories[100];
    public static int indexCategories;
    public static Product[] arrProducts = new Product[100];
    public static int indexProducts;

    static {
        Categories categories = new Categories(1,"com",true,"rat la ngon");
        Categories categories2 = new Categories(2,"banh my",true,"bay my nuong");
        Categories categories3 = new Categories(3,"chao",true,"rat long");
        arrCategories[0]=categories;
        arrCategories[1]=categories2;
        arrCategories[2]=categories3;
        indexCategories=3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Categories c = new Categories();
//        c.demo();
        do {
            System.out.println("******************SHOP MENU******************* ");
            System.out.println("1. Quản lý danh mục sản phẩm ");
            System.out.println("2. Quản lý sản phẩm ");
            System.out.println("3. Thoát");
            System.out.println(" lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayCategoriesMenu(sc);
                    break;
                case 2:
                    displayProductsMenu(sc);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("lựa chọn của bạn không đúng");
            }
        } while (true);
    }

    public static void displayCategoriesMenu(Scanner sc) {
        boolean isExit = true;
        do {
            System.out.println("********************CATEGORIES MENU*********** ");
            System.out.println("1. Nhập thông tin các danh mục ");
            System.out.println("2. Hiển thị thông tin các danh mục ");
            System.out.println("3. Cập nhật thông tin danh mục ");
            System.out.println("4. Xóa danh mục ");
            System.out.println("5. Cập nhật trạng thái danh mục ");
            System.out.println("6. Thoát ");
            System.out.println(" lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    //Khi chọn 1: cho phép nhập thông tin nhiều danh mục, số danh mục nhập dữ
                    //liệu do người dùng nhập từ bàn phím
                   inputCategoriesMenu(sc);
                    break;
                case 2:
                    //Khi chọn 2: cho phép hiển thị tất cả các thông tin danh mục đang quản lý
                    displayCategoriesMenu();
                    break;
                case 3:
                   // Khi chọn 3: cho phép cập nhật thông tin danh mục
                    //✓ Người dùng nhập vào mã danh mục cần cập nhật thông tin
                    //✓ Kiểm tra mã danh mục có tồn tại trong mảng danh mục hay không
                    //✓ Nếu tồn tại, cho phép người dùng nhập lại các thông tin của danh mục
                    //(Mã danh mục không được cập nhật)
                    UpdateCategoriesMenu(sc);
                    break;
                case 4:
                    //Khi chọn 4: Xóa sản phẩm
                    //✓ Người dùng nhập mã danh mục cần xóa
                    //✓ Kiểm tra mã danh mục có tồn tại trong mảng các danh mục
                    //✓ Nếu mã danh mục có tồn tại, kiểm tra danh mục đó có chứa sản phẩm
                    //không
                    //✓ Nếu không chứa sản phẩm, tiến hành xóa trong mảng danh mục
                    //✓ Nếu chứa sản phẩm, hiển thị thông báo không thể xóa danh mục
                    DeleteCategoriesMenu(sc);
                    break;
                case 5:
                    //Khi chọn 5: cho phép người dùng nhập mã danh mục cần cập nhật trạng thái,
                    //nếu tồn tại mã danh mục, tiến hành cập nhật trạng thái danh mục (true ->
                    //false, false->true)
                    statusCategoriesMenu(sc);
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.err.println("lựa chọn của bạn không đúng");
            }
        } while (isExit);
    }

    public static void inputCategoriesMenu (Scanner sc) {
        System.out.println("Nhập số lượng danh mục cần thêm");
        int number = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < number; i++){
            arrCategories[indexCategories] = new Categories();
            arrCategories[indexCategories].inputDataCatalog(sc);
            indexCategories++;
        }
        System.out.println("thêm thành công");
    }
    public  static void displayCategoriesMenu(){
        if(indexCategories >= 0){
            for( int i = 0; i < indexCategories; i++){
                arrCategories[i].DisplayCategories();
            }
        }else {
            System.err.println("Danh mục trống");
        }

    }
    public  static  void UpdateCategoriesMenu(Scanner sc){
        System.out.println("Nhập Id danh mục");
        int catalogId = Integer.parseInt(sc.nextLine());
        boolean isExit = false;
        int check = 0;
        for(int i = 0; i < indexCategories;i++){
            if(arrCategories[i].getCatalogId() == catalogId){
                isExit = true;
                check = i;
                break;
            }
        }
        if(isExit){
            System.out.println("Tên cần update");
            arrCategories[check].setCatalogName(sc.nextLine());
            System.out.println("mô tả update");
            arrCategories[check].setDescriptions(sc.nextLine());
            System.out.println("update status");
            arrCategories[check].setCatalogStatus(Boolean.parseBoolean(sc.nextLine()));
        }else {
            System.err.println("Id chưa chính xác");
        }
    }
    public static void DeleteCategoriesMenu(Scanner sc){
        System.out.println("Nhập vào Id danh mục muốn xóa");
        int catalogId = Integer.parseInt(sc.nextLine());
        int indexDelate = getIndexByCatalogId(catalogId);
        if(indexDelate >= 0 ){
            boolean isExit = false;
            for(int i = 0; i < indexProducts;i++){
                if(arrProducts[i].getCatalogId() == catalogId){
                    isExit =true;
                    break;
                }
            }
            if(isExit){
                System.err.println("Sản phẩm đang tồn tại, không thể xóa");
            }else {
               for(int i =indexDelate; i < indexCategories;i++){
                   arrCategories[i] = arrCategories[i +1];

               }
                indexCategories--;
            }
        }else {
            System.err.println("Id không tồn tại");
        }

    }
    public static int getIndexByCatalogId(int catalogId){
        for(int i = 0; i < indexCategories;i++){
            if(arrCategories[i].getCatalogId() == catalogId){
                return i;
            }
        }
        return -1;
    }
    public  static void statusCategoriesMenu(Scanner sc){
        System.out.println("nhập  tên danh mục cần thay đổi trạng thái");
        int catalogId = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < indexCategories;i++){
            if(arrCategories[i].getCatalogId()== catalogId){
                arrCategories[i].setCatalogStatus(!arrCategories[i].isCatalogStatus());
                break;
            }
        }

    }

    public static void displayProductsMenu(Scanner sc){
        boolean isExit = true;
        do {
            System.out.println("*******************PRODUCT MANAGEMENT***************** ");
            System.out.println("1. Nhập thông tin các sản phẩm ");
            System.out.println("2. Hiển thị thông tin các sản phẩm ");
            System.out.println("3. Sắp xếp các sản phẩm theo giá ");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm ");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím) ");
            System.out.println("8. Thoát");
            System.out.println("lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    inputProductsMenu(sc);
                    break;
                case 2:
                    displayProductMenu(sc);
                    break;
                case 3:
                    sortProductPiceMenu(sc);
                    break;
                case 4:
                    UpdateProductById(sc);
                    break;
                case 5:
                    DeleteProductMenu(sc);
                    break;
                case 6:
                    SeachProductByName(sc);
                    break;
                case 7:
                    searchPriceRange(sc);
                    break;
                case 8:
                    isExit = false;
                    break;
                default:
                    System.err.println("lựa chọn không nằm trong danh mục");

            }
        }while (isExit);
    }
    public static void inputProductsMenu(Scanner sc){
        System.out.println("Nhập thông tin sản phẩm");
        arrProducts[indexProducts] = new Product();
        arrProducts[indexProducts].inputProduct(sc);
        indexProducts++;
    }
    public static void displayProductMenu(Scanner sc){
        for (int i = 0; i < indexProducts;i++){
            arrProducts[i].displayProduct();
        }
    }
    public static void sortProductPiceMenu(Scanner sc){
        if(indexProducts >=0){
            for(int i = 0; i<indexProducts;i++){
                for(int j = 0; j<indexProducts;j++){
                    if(arrProducts[i].getPrice() > arrProducts[j].getPrice()){
                        Product temp = arrProducts[i];
                        arrProducts[i] = arrProducts[j];
                        arrProducts[j] = temp;
                    }
                }
            }
        }else {
            System.err.println("Ko tồn tại sản phẩm");
        }

    }
    public static void UpdateProductById(Scanner sc){
        System.out.println("Nhập Id sản phẩm cần update");
        String productId = sc.nextLine();
        int indexUpdate = getIndexProductById(productId);
        System.out.println("nhập tên update");
        arrProducts[indexUpdate].setProductName(sc.nextLine());
        System.out.println("nhập mô tả update");
        arrProducts[indexUpdate].setDescription(sc.nextLine());
        System.out.println("nhập status update");
        System.out.println("1.đang bán");
        System.out.println("2.hết hàng");
        System.out.println("3.không bán");
        arrProducts[indexUpdate].setProductStatus(Integer.parseInt(sc.nextLine()));
    }
    public static int getIndexProductById(String productId){
        for(int i = 0; i < indexProducts;i++){
            if(arrProducts[i].getProductid().equals(productId)){
                return i;
            }
        }
        return -1;
    }
    public static void DeleteProductMenu(Scanner sc){
        System.out.println("Nhập Id sản phẩm  muốn xóa");
        String catalogId = sc.nextLine();
        for(int i = 0; i < indexProducts;i++){
            if(arrProducts[i].getProductid().equals(catalogId)){
                arrProducts[i] = arrProducts[i +1];
                indexProducts--;
            }else {
                System.err.println("Id nhập sai");
            }
        }
    }
    public static void SeachProductByName(Scanner sc){
        System.out.println("Tìm kiếm sản phẩm theo Idcategory");
        int catalogID = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < indexProducts;i++){
            if(arrProducts[i].getCatalogId() == catalogID){
                arrProducts[i].displayProduct();
            }
        }
    }
    public static void searchPriceRange(Scanner sc){
        System.out.print("khoảng giá từ: \n");
        int startPrice = Integer.parseInt(sc.nextLine());
        System.out.print("đến: \n");
        int endPrice = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < indexProducts;i++){
            if( arrProducts[i].getPrice() >= startPrice && arrProducts[i].getPrice()<=endPrice){
                arrProducts[i].displayProduct();
            }
        }
    }


}
