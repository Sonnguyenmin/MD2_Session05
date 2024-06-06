package bussines;

import run.studentManagement;

import java.util.Scanner;


public class Students {
    private String studentId;
    private String studentName;
    private int age;
    private boolean gender;
    private String address;
    private String phone;

    public Students() {
    }

    public Students(String studentId, String studentName, int age, boolean gender, String address, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void inputData(Scanner scanner) {
        //1. Nhập mã sinh viên: gồm 5 k tự bắt đầu la SV, không trùng lặp
        this.studentId = inputStudentId(scanner);
        //2. Nhập tên sinh vin phải có 6 dến 50 ký tự
        this.studentName = inputStudentName(scanner);
        //3. Tuổi sing vin phải có gi trị lớn hn hoặc bằng 18
        this.age = inputAge(scanner);
        //4. Giới tính chỉ nhận giá trị true/false
        this.gender = inputGender(scanner);
        //5. địa chỉ không được rỗng
        this.address = inputAddress(scanner);
        //6. Dien thoai : Gom 10 ky tu bat dau la ky tu 0, khong trung lặp
        this.phone = inputPhone(scanner);
    }
    
    public String inputStudentId(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên: ");
        do {
            String studentId = scanner.nextLine();
            //Nhập 5 ký tự
            if(studentId.length() == 5) {
                //Bắt đầu 'SV'
                if(studentId.startsWith("SV")) {
                    //Không trùng lặp
                    boolean isExist = false;//chưa tồn tại
                    for (int i = 0; i < studentManagement.currentIndex; i++) {
                        if (studentManagement.arrStudents[i].getStudentId().equals(studentId)) {
                            isExist = true; // đã tồn tại
                            break;
                        }
                    }

                    if(isExist) {
                       // đã tồn tại
                        System.err.println(" Mã sinh viên đã tồn tại , vui lòng nhập lại");
                    }
                    else {
                        return studentId;
                    }
                }
                else  {
                    System.err.println("Mã sinh viên bắt đầu là SV, vui lòng nhập lại");
                }
            }
            else  {
                System.err.println("Mã sinh viên gồm 5 ký tự, vui lòng nhập lại");
            }
        }while (true);
    }

    public String inputStudentName(Scanner scanner) {
        System.out.println("Nhập vào tên sinh viên:");
        do {
            String studentName = scanner.nextLine();
            if(studentName.trim().isEmpty()) {
                System.err.println("* Ten sinh vien khong dược de trong");
            } else  {
                if(studentName.length() >= 6 && studentName.length() <= 50) {
                    return studentName;
                } else  {
                    System.err.println("Tên sinh viên từ 6-50 ký tự, vui lòng nhập lại");
                }
            }
        } while (true);
    }

    public int inputAge(Scanner scanner) {
        System.out.println(" Nhập vào tuổi sinh viên: ");
        do {
            int age = Integer.parseInt(scanner.nextLine());
            if( age >= 18) {
                return age;
            }
            else  {
                System.err.println("Sinh viên phải có tuổi lớn hơn hoặc bằng 18, vui lòng nhập lại");
            }
        } while (true);
    }

    public boolean inputGender (Scanner scanner){
        System.out.println("Nhập vào giới tính sinh viên:");
        do {
            String gender = scanner.next();
            if(gender.equals("true") || gender.equals("false")) {
                return Boolean.parseBoolean(gender);
            }
            else {
                System.err.println("Giới tính sinh viên chỉ nhận giá trị true|false, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputAddress (Scanner scanner) {
        System.out.println("Nhập vào địa chỉ sinh viên:");
        do {
            String address = scanner.nextLine();
            if (address.trim().isEmpty()) {
                System.out.println("Chưa nhập địa chỉ, vui lòng nhập lại");
            } else  {
                return address;
            }
        } while (true);
    }

    public String inputPhone(Scanner scanner) {
        System.out.println("Nhập vào số điện thoại của sinh viên:");
        do {
            String phone = scanner.nextLine();
            if (phone.charAt(0) == '0') {
                if(phone.length() == 10) {
                    boolean isExist = false;
                    for (int i = 0; i < studentManagement.currentIndex; i++) {
                        if(studentManagement.arrStudents[i].getPhone().equals(phone)) {
                            isExist = true;
                            break;
                        }
                    }

                    if (isExist) {
                        System.err.println("Số điện thoại đã được đăng ký, vui lòng nhập lại");
                    }
                    else {
                        return phone;
                    }
                }
                else  {
                    System.err.println("Số điện thoại có 10 ký tự, vui lòng nhập lại");
                }
            }
            else  {
                System.err.println("Số điện thoại phải bắt đầu là 0, vui lòng nhập lại");
            }
        }
        while (true);
    }

    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d - Giới tính: %s\n",
                this.studentId, this.studentName, this.age, this.gender ? "Nam" : "Nữ");
        System.out.printf("Địa chỉ: %s - Số điện thoại: %s\n", this.address, this.phone);
    }
}
