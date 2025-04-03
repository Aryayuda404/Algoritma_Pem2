// Import Library bawaan java
import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {
    static String[][] user = new String[5][2]; // Array untuk menyimpan username dan password
    static int usercount = 2; // Jumlah user yang tersedia
    static String username = ""; // Variabel untuk menyimpan username yang login
    // ArrayList untuk menyimpan daftar produk yang masuk, keluar, dan stok yang tersedia
    static ArrayList<InboundPro> arrInbound = new ArrayList<>();
    static ArrayList<OutboundPro> arrOutbound = new ArrayList<>();
    static ArrayList<StockAval> available = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String admin1 = "Ilham";
        String admin2 = "Admin";
        String pass = "1234";
        
        user[0][0] = admin1;
        user[1][0] = admin2;
        user[0][1] = pass;
        user[1][1] = pass;
        
//        Menu Utama ->
        
        System.out.println("Program Sederhana CRUD yang mengandung :");
        System.out.println("""
                           1. Method
                           2. Class
                           3. Rekursi""");
        
        System.out.println("");
        
        boolean start = false;
        while (!start){
            System.out.println("Pilih pilihan di bawah ini :");
            System.out.println("""
                               1. Lanjut
                               2. Exit""");
            
            System.out.print("Jawaban : ");
            int jawab = scan.nextInt();
            scan.nextLine();
            
            if(jawab == 1){
                System.out.println("");
                System.out.println("Selamat datang di program sederhana `Warehouse Management`");
                start = true;
            }else if(jawab == 2){
                System.out.println("Keluar dari Program....");
                System.exit(0);
                break;
            }else{
                System.out.println("Invalid Input!");
            }
        }
        
        System.out.println("");
        
//        Menu Login -> 

        login(scan);
        
//        Menu Program/Aplikasi
        
        boolean menu = false;
        while (!menu){
            System.out.println("[ Login sebagai "+username+" ]");
            System.out.println("Program Sederhana Warehouse Management");
            System.out.println("""
                               A. Inbound 
                               B. Outbound
                               C. Adjustment Stock
                               D. Show Availble Stock
                               E. Exit Program""");
            System.out.print("Pilihan : ");
            String choice = scan.nextLine();
            
            System.out.println("");

            switch(choice.toLowerCase()){
                case "a" : {
                    System.out.println("================[ Menu Inbound ]================");
                    inbound(scan);
                    break;
                }
                case "b" : {
                    System.out.println("================[ Menu Outbound ]===============");
                    outbound(scan);
                    break;
                }
                case "c" : {
                    System.out.println("==============[ Menu Adjustment ]===============");
                    adjust(scan);
                    break;
                }
                case "d" : {
                    System.out.println("===============[ Available Stock ]==============");
                    showStock();
                    break;
                }
                case "e" : {
                    System.out.println("Exiting Aplication....");
                    menu = true;
                    break;
                }
                default : System.out.println("Invalid Input!!");
            }
        }
    }
    
//    Method
    
    /* Method Login */
    public static void login(Scanner scan) {
        System.out.println("=======[ Menu Login ]=======");
        System.out.print("Username  : ");
        username = scan.nextLine();
        System.out.print("Password  : ");
        String password = scan.nextLine();
        System.out.println("============================");

        for (int i = 0; i < usercount; i++) {
            if (user[i][0].equals(username) && user[i][1].equals(password)) {
                System.out.println("");
                System.out.println("Login berhasil!!");
                System.out.println("Selamat datang " + username);
                System.out.println("");
                return; // Berhenti jika login sukses
            }
        }
        System.out.println("Username atau password salah, coba lagi...");
        System.out.println("");
        login(scan); // Panggil dirinya sendiri jika salah (rekursi)
    }
    
    /* Method Inbound */
    public static void inbound(Scanner scan){
        int codePro;
        while(true){
            System.out.print("Product Code  : ");
            codePro = scan.nextInt();
            scan.nextLine();
            
            boolean codeExist = false;
            for (InboundPro ProIn : arrInbound){
                if (ProIn.getCode() == codePro){
                    System.out.println("Code yang anda masukan telah tersedia.");
                    System.out.println("...");
                    codeExist = true;
                    break;
                }
            }
            if (!codeExist){
                break;
            }
        }
            
            System.out.print("Product Name  : ");
            String namePro = scan.nextLine();
            System.out.print("Product Qty   : ");
            int qtyPro = scan.nextInt();
            scan.nextLine();
            System.out.print("Product Price : ");
            int pricePro = scan.nextInt();
            scan.nextLine();
            
            InboundPro product = new InboundPro(codePro, namePro, qtyPro, pricePro);
            arrInbound.add(product);
            
            boolean found = false;
            for (StockAval stock : available){
                if (stock.getCode() == codePro){
                    stock.qty += qtyPro;
                    found = true;
                    break;
                }
            }
            if (!found){
                available.add(new StockAval(codePro, namePro, qtyPro, pricePro));
            }
            System.out.println("");
            System.out.println("Product telah ditambahkan....");
            System.out.println("...");
            System.out.println("");
    }
    
    /* Method Outbound */
    public static void outbound(Scanner scan){
        StockAval stock = null;
        
        System.out.print("Product Code  : ");
        int codePro = scan.nextInt();
        scan.nextLine();
        
        for (StockAval s : available){
            if (s.getCode() == codePro){
                stock = s;
                break;
            }
        }
        if (stock == null){
            System.out.println("Product Code "+codePro+" tidak tersedia");
            System.out.println("===");
            System.out.println("");
            return;
        }
        
        System.out.println("Product Name  : "+stock.getName());
        System.out.println("Product Qty   : "+stock.getQty());
        System.out.println("Product Price : "+stock.getPrice());
        
        System.out.println("");
        System.out.println("Qty yang akan di kurangi :");
        System.out.print("-> ");
        int qtyOut = scan.nextInt();
        scan.nextLine();
        
        if (qtyOut > stock.getQty()){
            System.out.println("Stock tidak cukup!");
            System.out.println("...");
            System.out.println("");
        }
        
        stock.qty -= qtyOut;
        
        if (stock.getQty() == 0){
            available.remove(stock);
            System.out.println("Product telah habis.");
            System.out.println("...");
            System.out.println("");
        }
        
        OutboundPro product = new OutboundPro(codePro, stock.getName(), stock.getQty(), stock.getPrice());
        arrOutbound.add(product);
        System.out.println("");
        System.out.println("Stock Product telah dikurangi.");
        System.out.println("...");
        System.out.println("");
    }
    
    /* Method Adjustment/Edit */
    public static void adjust(Scanner scan){
        System.out.println("Masukan Product Code yang akan di Edit : ");
        System.out.print("-> ");
        int codePro = scan.nextInt();
        scan.nextLine();
        
        StockAval stock = null;
        for (StockAval s : available){
            if (s.getCode() == codePro){
                stock = s;
                break;
            }
        }
        if (stock == null){
            System.out.println("Product dengan code "+codePro+" tidak tersedia.");
            System.out.println("");
            return;
        }
        
        System.out.println("");
        
        boolean adj = false;
        while (!adj){
            System.out.println("Product detail : ");
            System.out.println("Product Code   : "+stock.getCode());
            System.out.println("Product Name   : "+stock.getName());
            System.out.println("Available Qty  : "+stock.getQty());
            System.out.println("Product Price  : "+stock.getPrice());
            System.out.println("");
            System.out.println("Apa yang akan anda ubah/adjust? ");
            System.out.println("""
                               1. Product Code
                               2. Product Name
                               3. Available Qty
                               4. Product Price
                               Input [E] untuk menyelesaikan adjustment""");
            System.out.print("-> ");
            String choice = scan.nextLine();
            System.out.println("");
            
            switch (choice.toLowerCase()){
                case "1" : {
                    System.out.print("Masukan Code Baru : ");
                    int newCode = scan.nextInt();
                    scan.nextLine();
                    stock.code = newCode;
                    System.out.println("Code telah di update.");
                    System.out.println("...");
                    System.out.println("");
                    break;
                }
                case "2" : {
                    System.out.print("Masukan Nama Baru : ");
                    String newName = scan.nextLine();
                    stock.name = newName;
                    System.out.println("Nama telah di update.");
                    System.out.println("...");
                    System.out.println("");
                    break;
                }
                case "3" : {
                    System.out.print("Masukan Qty Baru : ");
                    int newQty = scan.nextInt();
                    scan.nextLine();
                    stock.qty = newQty;
                    System.out.println("Qty telah di update.");
                    System.out.println("...");
                    System.out.println("");
                    break;
                }
                case "4" : {
                    System.out.print("Masukan Price Baru : ");
                    int newPrice = scan.nextInt();
                    scan.nextLine();
                    stock.price = newPrice;
                    System.out.println("Price telah di update.");
                    System.out.println("...");
                    System.out.println("");
                    break;
                }
                case "e" : {
                    adj = true;
                    System.out.println("Product telah di Adjust");
                    System.out.println("...");
                    System.out.println("");
                    break;
                }
                default : System.out.println("Invalid input, silahkan input kembali.");
                break;
            }
        }
    }
    
    /* Method Show Stock (menampilkan stok) */
    public static void showStock(){
        if (available.isEmpty()){
            System.out.println("Stock Kosong....");
            System.out.println("...");
            System.out.println("");
            return;
        }
        for (StockAval stock : available){
            stock.showStock();
        }
        System.out.println("===");
        System.out.println("");
    }
    
//    Class
    
    /* Class Inbound */
    public static class InboundPro {
        int code;
        String name;
        int qty;
        int price;
        
        public InboundPro (int code, String name, int qty, int price) {
            this.code = code;
            this.name = name;
            this.qty = qty;
            this.price = price;
        }
        
        public int getCode(){
            return code;
        }
        public String getName(){
            return name;
        }
        public int getQty(){
            return qty;
        }
        public int getPrice(){
            return price;
        }
    }
    
    /* Class Outbound */
    public static class OutboundPro {
        int code;
        String name;
        int qty;
        int price;
        
        public OutboundPro (int code, String name, int qty, int price){
            this.code = code;
            this.name = name;
            this.qty = qty;
            this.price = price;
        }
        
        public int getCode(){
            return code;
        }
        public String getName(){
            return name;
        }
        public int getQty(){
            return qty;
        }
        public int getPrice(){
            return price;
        }
    }
    
    /* Class Stock Available */
    public static class StockAval {
        int code;
        String name;
        int qty;
        int price;
        
        public StockAval (int code, String name, int qty, int price){
            this.code = code;
            this.name = name;
            this.qty = qty;
            this.price = price;
        }
        
        public int getCode(){
            return code;
        }
        public String getName(){
            return name;
        }
        public int getQty(){
            return qty;
        }
        public int getPrice(){
            return price;
        }
        public void showStock(){
            System.out.println("Product Code : "+code+" | Product Name : "+name+" | Available Qty : "+qty+" | Product Price : "+price);
        }
    }
}