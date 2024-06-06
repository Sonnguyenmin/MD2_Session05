package Books_TH;

import Books_TH.run.BookManagement;

import java.util.Scanner;

public class Books {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interrest;
    private int year;

    public Books() {
    }

    public Books(String bookId, String bookName, float importPrice, float exportPrice, String author, float interrest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interrest = interrest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterrest() {
        return interrest;
    }

    public void setInterrest(float interrest) {
        this.interrest = interrest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputData(Scanner scanner) {
        this.bookId = inputBookId(scanner);
        this.bookName = inputBookName(scanner);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.author = inputAuthor(scanner);
        this.interrest = inputInterest();
        this.year = inputYear(scanner);
    }

    public String inputBookId (Scanner scanner) {
        System.out.println("Nhap vao ma sach: ");
        do {
            String bookId = scanner.nextLine();
            //khong duoc de trong
            if(bookId.trim().isEmpty()) {
                System.err.println("* Ma sach khong duoc de trong");
            }
            else  {
                if (bookId.length() == 4) {
                    if(bookId.startsWith("B")) {
                        boolean isExit = false;
                        for (int i = 0; i < BookManagement.currentIndex; i++) {
                            if (BookManagement.arrBooks[i].getBookId().equals(bookId)) {
                                isExit = true;
                                break;
                            }
                        }

                        if (isExit) {
                            System.err.println("Ma sach da ton tai, vui long nhap lai");
                        }
                        else {
                            return bookId;
                        }
                    }
                    else  {
                        System.err.println("Ma sach bat dau la B, vui long nhap lai");
                    }
                }
                else {

                    System.err.println("Ma sach gom 4 ky tu, vui long nhap lai");
                }
            }
        } while (true);
    }

    public String inputBookName (Scanner scanner) {
        System.out.println("Nhap vao ten sach: ");
        do {
            String bookName = scanner.nextLine();
            if(bookName.trim().isEmpty()) {
                System.err.println("* Ten sach khong duoc de trong");
            }
            else {
                if(bookName.length() >= 6 && bookName.length() <= 50) {
                    return bookName;
                }
                else  {
                    System.err.println("Ten sach phai nhap tu 6 -50 ky tu");
                }

            }
        }while (true);
    }

    public float inputImportPrice(Scanner scanner) {
        System.out.println("Gíá nhập của sách:");
        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("Giá nhập của sách có giá trị lớn hơn 0,vui lòng nhập lại");
            }
        } while (true);
    }

    public float inputExportPrice(Scanner scanner) {
        System.out.println("Giá xuất của sách");
        do {
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if (exportPrice >= importPrice * 1.3) {
                return exportPrice;
            } else {
                System.err.println("Giá xuất của sách có giá trị lớn hơn ít nhất 30% so với giá nhập, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputAuthor(Scanner scanner) {
        System.out.println(" Mời nhập tác giả:");
        do {
            String author = scanner.nextLine();
           if(author.trim().isEmpty()) {
               System.err.println("* Tac gia khong duoc de trong");
           }
           else  {
               if (author.length() > 6 && author.length() < 50) {
                   return author;
               } else {
                   System.err.println("Tác giả có từ 6-50 ký tự,vui lòng nhập lại");
               }
           }
        } while (true);
    }

    public float inputInterest() {
        interrest = exportPrice - importPrice;
        return interrest;
    }

    public int inputYear(Scanner scanner) {
        System.out.println("Mời nhập năm xuất bản");
        do {
            int year = Integer.parseInt(scanner.nextLine());
            if (year > 2000) {
                return year;
            } else {
                System.err.println("Ít nhất xuất bản sau năm 2000,vui lòng nhập lại");
            }
        } while (true);
    }

    public void displayData() {
        System.out.printf("Ma sach: %s - Ten sach: %s - Gia tien nhap: %s - Gia tien ban: %s \n", this.bookId, this.bookName, this.importPrice, this.exportPrice);
        System.out.printf("Ten tac gia: %s - Loi nhuan: %s - Nam Xuat ban: %s \n", this.author, this.interrest, this.year);
    }
}


