package run;

import bussines.Students;

import java.util.Scanner;

public class studentManagement {
    //Mảng lưu các đối tượng sinh viên đang quản lý
    public static Students[] arrStudents = new Students[100];
    //Chỉ số pần tử nhỏ nhất trong mảng chưa lưu sinh viên
    public static int currentIndex = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************QUAN LY SINH VIEN****************");
            System.out.println("* 1. Danh sách sinh viên                        *");
            System.out.println("* 2. Thêm mới sinh viên                         *");
            System.out.println("* 3. Cập nhật sinh viên                         *");
            System.out.println("* 4. Xóa sinh viên                              *");
            System.out.println("* 5. Tìm sinh viên theo tên sinh viên           *");
            System.out.println("* 6. Thống kê sinh viên theo khoảng tuổi        *");
            System.out.println("* 7. Sắp xếp sinh viên theo tuổi tăng dần       *");
            System.out.println("* 8. Thoát                                      *");
            System.out.println("*************************************************");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentManagement.displayListStudent();
                    break;
                case 2:
                    studentManagement.inputListstudent(scanner);
                    break;
                case 3:
                    studentManagement.updateStudent(scanner);
                    break;
                case 4:
                    studentManagement.deleteStudent(scanner);
                    break;
                case 5:
                    studentManagement.searchStudentByName(scanner);
                    break;
                case 6:
                    studentManagement.statiticStudent(scanner);
                    break;
                case 7:
                    studentManagement.sortStudent();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn 1 - 8");
            }
        } while (true);
    }
    public static void displayListStudent() {
        for (int i = 0; i < currentIndex; i++) {
            arrStudents[i].displayData();
        }
    }

    public static void inputListstudent(Scanner scanner) {
        System.out.println("Nhập số sinh viên cần nhập thông tin:");
        int countStudent = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countStudent; i++) {
            //Nhập thông tin cho sinh viên có chỉ số currentIndex trong mảng
            arrStudents[currentIndex] = new Students();
            arrStudents[currentIndex].inputData(scanner);
            currentIndex++;
        }
    }

    public static void updateStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần cập nhật:");
        String studentId = scanner.nextLine();
        int indexUpdate = getIndexById(studentId);
        if (indexUpdate >= 0) {
            //Thực hiện cập nhật
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên sinh viên");
                System.out.println("2. Cập nhật tuổi sinh viên");
                System.out.println("3. Cập nhật giới tính sinh viên");
                System.out.println("4. Cập nhật địa chỉ sinh viên");
                System.out.println("5. Cập nhật số điện thoại sinh viên");
                System.out.println("6. Thoát");
                System.out.print("Lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        arrStudents[indexUpdate].setStudentName(scanner.nextLine());
                        break;
                    case 2:
                        arrStudents[indexUpdate].setAge(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        arrStudents[indexUpdate].setGender(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 4:
                        arrStudents[indexUpdate].setAddress(scanner.nextLine());
                        break;
                    case 5:
                        arrStudents[indexUpdate].setPhone(scanner.nextLine());
                        break;
                    default:
                        isExit = false;
                }
            } while (isExit);
        } else {
            System.err.println("Mã sinh viên không tồn tại");
        }
    }

    public static int getIndexById(String studentId) {
        for (int i = 0; i < currentIndex; i++) {
            if (arrStudents[i].getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần xóa:");
        String studentId = scanner.nextLine();
        int indexDelete = getIndexById(studentId);
        if (indexDelete >= 0) {
            for (int i = indexDelete; i < currentIndex; i++) {
                arrStudents[i] = arrStudents[i + 1];
            }
            currentIndex--;
        } else {
            System.err.println("Mã sinh viên không tồn tại");
        }
    }

    public static void searchStudentByName (Scanner scanner) {
        System.out.println("Nhập vào tên sinh viên cần tìm:");
        String studentNameSeach = scanner.nextLine();
        int cntStudent = 0;
        System.out.println("Các sinh viên tìm thấy:");
        for (int i = 0; i < currentIndex; i++) {
            if (arrStudents[i].getStudentName().toLowerCase().contains(studentNameSeach.toLowerCase())) {
                arrStudents[i].displayData();
                cntStudent++;
            }
        }
        System.out.printf("Có %d sinh viên được tìm thấy\n", cntStudent);
    }

    public static void statiticStudent(Scanner scanner) {
        System.out.println("Nhập vào tuổi bắt đầu:");
        int fromAge = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào tuổi kết thúc:");
        int toAge = Integer.parseInt(scanner.nextLine());
        int countStudent = 0;
        for (int i = 0; i < currentIndex; i++) {
            if(arrStudents[i].getAge() >= fromAge && arrStudents[i].getAge() <= toAge) {
                countStudent++;
            }
        }
        System.out.printf("Có %d sinh viên có tuổi từ %d đến %d\n", countStudent, fromAge, toAge);
    }

    public static void sortStudent() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrStudents[i].getAge() > arrStudents[j].getAge()) {
                    Students temp = arrStudents[i];
                    arrStudents[i] = arrStudents[j];
                    arrStudents[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp xong sinh viên theo tuổi tăng dần");
    }

}
