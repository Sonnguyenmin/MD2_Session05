package Books_TH.run;


import Books_TH.Books;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class BookManagement {
    public static Books[] arrBooks = new Books[50];
    public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**************************QUAN LY SACH****************************");
            System.out.println("*           1. Nhập thông tin n sách (n nhập từ bàn phím)        *");
            System.out.println("*           2. Tính lợi nhuận các sách                           *");
            System.out.println("*           3. Hiển thị thông tin sách                           *");
            System.out.println("*           4. Sắp xếp sách theo giá bán tăng dần                *");
            System.out.println("*           5. Sắp xếp sách theo lợi nhuận giảm dần              *");
            System.out.println("*           6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)*");
            System.out.println("*           7. Thống kê số lượng sách theo năm xuất bản          *");
            System.out.println("*           8. Thống kê số lượng sách theo tác giả               *");
            System.out.println("*           9: Thoát                                             *");
            System.out.println("******************************************************************");
            System.out.print("Lựa chọn của bạn:");
            int choine = Integer.parseInt(scanner.nextLine());
            switch (choine) {
                case 1:
                    BookManagement.inputListStudent(scanner);
                    break;
                case 2:
                    BookManagement.calculateInterest();
                    break;
                case 3:
                    BookManagement.displayListBooks();
                    break;
                case 4:
                    BookManagement.sortAscendingBooks();
                    break;
                case 5:
                    BookManagement.sortDescendingProfit();
                    break;
                case 6:
                    BookManagement.searchBookByName(scanner);
                    break;
                case 7:
                    BookManagement.statiticYearBook(scanner);
                    break;
                case 8:
                    BookManagement.statiticAuthorBook(scanner);
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui long chon 1 - 9");
            }
        }
        while (true);
    }

    //case: 1
    public static void inputListStudent(Scanner scanner) {
        System.out.println(" Nhap so sach can nhap thong tin:");
        int countBook = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countBook; i++) {
            //Nhap thong tin cho sach co chi so currentIndex trong mang
            arrBooks[currentIndex] = new Books();
            arrBooks[currentIndex].inputData(scanner);
            currentIndex++;
        }
    }
    //case: 2
    public static void calculateInterest() {
        for (int i = 0; i < currentIndex; i++) {
            arrBooks[i].inputInterest();
        }
        System.out.println("Da tinh loi nhuan cho tat ca cac sach");
    }

    //case: 3
    public static void displayListBooks() {
        for (int i = 0; i < currentIndex; i++) {
            arrBooks[i].displayData();
        }
    }

    //case: 4
    public static void sortAscendingBooks() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if(arrBooks[i].getExportPrice() > arrBooks[j].getExportPrice()) {
                    Books temp = arrBooks[i];
                    arrBooks[i] = arrBooks[j];
                    arrBooks[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep xong sach theo gia ban tang dan");
    }
//    case:5
    public static void sortDescendingProfit() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if(arrBooks[i].getInterrest() < arrBooks[j].getInterrest()) {
                    Books temp = arrBooks[i];
                    arrBooks[i] = arrBooks[j];
                    arrBooks[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep xong sach theo loi nhuan giam dan");
    }
    //case: 6
    public static void searchBookByName(Scanner scanner) {
        System.out.print("Nhap ten sach can tim: ");
        String bookNameSearch = scanner.nextLine();
        int countBook = 0;
        System.out.println("Các Sach tìm thấy:");
        for (int i = 0; i < currentIndex; i++) {
            if (arrBooks[i].getBookName().toLowerCase().contains(bookNameSearch.toLowerCase())) {
                arrBooks[i].displayData();
                countBook++;
            }
        }
        System.out.printf("Co %d sinh vien duoc tim thay\n", countBook);
    }

    //case: 7
    public static void statiticYearBook (Scanner scanner) {
        System.out.print("Nhap khoang thoi gian can thong ke (Tu nam): ");
        int fromYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap khoang thoi gian can thong ke (Den nam): ");
        int toYear = Integer.parseInt(scanner.nextLine());
        int yearBookCount = 0;
        for (int i = 0; i < currentIndex; i++) {
            if (arrBooks[i].getYear() >= fromYear && arrBooks[i].getYear() <= toYear) {
                yearBookCount++;
            }
        }
        System.out.printf("Co %d sach co nam tu %d den %d\n", yearBookCount, fromYear, toYear);
    }

    //case: 8
    public static void statiticAuthorBook(Scanner scanner) {

    }


}
