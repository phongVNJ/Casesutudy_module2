package QLS;
import Businese.DauSachBL;
import Businese.SachBL;
import LIST.ListDauSach;
import MUONSACH.DauSach;

import java.util.Scanner;

public class QLDauSach {
    Scanner scanner = new Scanner(System.in);
    SachBL sachBL = new SachBL();
    DauSachBL dauSachBL = new DauSachBL();

    public void menu() {
        do {
            System.out.println();
//            System.out.println("----------------------------\n");
            System.out.println("            QUẢN LÍ ĐẦU SÁCH");
            System.out.println("-----------------***---------------");
            System.out.println("|  1. Thêm đầu sách.                |");
            System.out.println("|  2. Sửa thông tin.                |");
            System.out.println("|  3.Xóa đầu sách.                  |");
            System.out.println("|  4.Xem danh sách.                 |");
            System.out.println("|  5.Sắp xếp theo tên.              |");
            System.out.println("|  6.Tìm kiếm.                      |");
            System.out.println("|  9.Quay lại menu chính            |");
            System.out.println("|  0.Thoát chương trình             |");
            System.out.println("-------------------------------------");
            System.out.print(" Mời chọn chức năng: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n){
                case 1:
                    them();
                    break;
                case 2:
                    sua();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    xemDanhSach();
                    break;
                case 5:
                    sapXepTheoTen();
                    break;
                case 6:
                    timKiem();
                    break;
                case 9:
                    Main.menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
            System.out.println("\n---------------------KẾT THÚC QUẢN LÍ ĐẦU SÁCH------------------\n");
        }while (true);
    }

    private void xoa() {
        System.out.println();
        System.out.println("XÓA THÔNG TIN SÁCH ");
        System.out.println("Nhập vào mã của sách xóa: ");
        String maDauSach = scanner.nextLine();
        if (dauSachBL.kiemTra(maDauSach)) {
            dauSachBL.xoa(maDauSach);
            System.out.println("Xóa thành công sách có mã: " + maDauSach);
        } else {
            System.out.println("Không tồn tại sách có mã: " + maDauSach);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }

    private void xemDanhSach() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("DANH SÁCH ");
        ListDauSach lst = dauSachBL.layDanhSach();
        lst.sapXepTheoTen();
        NodeDauSach tg = lst.getHead();
        System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                "Mã Đầu Sách ",
                "Tên Sách",
                "Thể Loại",
                "Tác Giả",
                "Số Lượng",
                "Trạng thái");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        while (tg != null) {

            tg.getInfo().hienThi();
            tg = tg.getNext();
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");

    }

    private void sapXepTheoTen() {
        System.out.println();
        System.out.println("DANH SÁCH NHÂN VIÊN");
        ListDauSach lst = dauSachBL.layDanhSach();
        lst.sapXepTheoTen();
        NodeDauSach tg = lst.getHead();
        System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                "Mã Đầu Sách ",
                "Tên Sách",
                "Thể Loại",
                "Tác Giả",
                "Số Lượng",
                "Trạng thái");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        while (tg != null) {
            tg.getInfo().hienThi();
            tg = tg.getNext();
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");

    }

    private void sua() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("SỬA SÁCH");
        System.out.println("MỜI NHẬP VÀO CÁC THÔNG TIN:");

        String maDauSach, tenSach,theLoai,tacGia, soluong, trangThai;

        do {
            System.out.print("Nhập vào mã sách cần sửa: ");
            maDauSach = scanner.nextLine();
        } while (maDauSach == "");
        if (sachBL.kiemTra(maDauSach)) {
            do {
                System.out.print("Nhập tên sách: ");
                tenSach = scanner.nextLine();
            } while (tenSach == "");

            do {
                System.out.print("Nhập thể loại: ");
                theLoai = scanner.nextLine();
            } while (theLoai == "");

            do {
                System.out.print("Nhập tên tác giả: ");
                tacGia = scanner.nextLine();
            } while (tacGia == "");
            do {
                System.out.print("Nhập số lượng: ");
                soluong = scanner.nextLine();
            } while (soluong == "");

            do {
                System.out.print("Nhập trạng thái : ");

                trangThai = scanner.nextLine();
            } while (trangThai == "");

            DauSach sach = new DauSach( maDauSach, tenSach,theLoai,tacGia, soluong, trangThai);
            dauSachBL.sua(sach);
        } else {
            System.out.println(
                    "Đã tồn tại sách có mã: " + maDauSach);
        }
        System.out.println("\n-----------------------------------------------------------------------------\n");

    }

    public void them() {
        System.out.println();
        System.out.println("------------------------------------\n");
        System.out.println("THÊM SÁCH");
        System.out.println("Mời Nhập Vào Các Thông Tin:");

        String maDauSach, tenSach, theloai, tacgia, soluong, trangThai;
        do {
            System.out.print("Nhập vào mã cho sách:");
            maDauSach = scanner.nextLine();
        } while (maDauSach == "");
        if (!dauSachBL.kiemTra(maDauSach)) {
            do {
                System.out.print("Nhập tên sách: ");
                tenSach = scanner.nextLine();
            } while (tenSach == "");
            do {
                System.out.print("nhập thể loại:");
                theloai = scanner.nextLine();
            } while (theloai == "");
            do {
                System.out.print("Nhập tên tác giả");
                tacgia = scanner.nextLine();
            } while (tacgia == "");
            do {
                System.out.print("Nhập số lượng sách: ");
                soluong = scanner.nextLine();
            } while (soluong == "");
            do {
                System.out.println("Nhập trạng thái");
                trangThai = scanner.nextLine();
            } while (trangThai == "");
            DauSach Dausach = new DauSach(maDauSach, tenSach, theloai, tacgia, soluong, trangThai);
            dauSachBL.them(Dausach);
        } else {
            System.out.println("Đã tồn tại: " + maDauSach);
        }
        System.out.println("\n-------------------------------------------------------------------\n");
    }

    public void timKiem() {
        do {
            System.out.println();
//            System.out.println("---------------------------------------\n");
            System.out.println("              TÌM KIẾM ĐẦU SÁCH");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Tìm theo mã đầu sách.            |");
            System.out.println("|   2. Tìm theo tên sách.               |");
            System.out.println("|   3. Tìm gần đúng theo mã đầu sách.   |");
            System.out.println("|   9. Quay lại menu QL Sách.           |");
            System.out.println("|   0. Thoát chương trình.              |");
            System.out.println("-----------------------------------------");
            System.out.print("  Mời chọn chức năng: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    timMa();
                    break;
                case 2:
                    timTen();
                    break;
                case 3:
                    timGanMa();
                    break;
                case 9:
                    menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n--------------------KẾT THÚC MENU TÌM KIẾM ĐẦU SÁCH-------------------\n");
        } while (true);


    }

    private void timMa() {
        System.out.println();
        System.out.println("TÌM KIẾM THEO MÃ ĐẦU SÁCH");
        System.out.print("Nhập vào mã đầu sách cần tìm kiếm: ");
        String maDauSach = scanner.nextLine();
        NodeSach tg = sachBL.timMa(maDauSach);

        System.out.println();
        if (tg != null) {
            System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                    "Mã Đầu Sách ",
                    "Tên Sách",
                    "Thể Loại",
                    "Tác Giả",
                    "Số Lượng",
                    "Trạng thái");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            tg.getInfo().hienThi();
        } else {
            System.out.println("Không có kết quả nào phù hợp.");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");

    }

    private void timTen() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("TÌM KIẾM THEO TÊN SÁCH ");
        System.out.print("Nhập vào tên sách cần tìm kiếm: ");
        String tenSach = scanner.nextLine();
        ListDauSach lst = dauSachBL.timTen(tenSach);
        NodeDauSach tg = lst.getHead();

        System.out.println();
        if (tg != null) {
            System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                    "Mã Đầu Sách ",
                    "Tên Sách",
                    "Thể Loại",
                    "Tác Giả",
                    "Số Lượng",
                    "Trạng thái");

            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            while (tg != null) {
                tg.getInfo().hienThi();
                tg = tg.getNext();
            }
        } else {
            System.out.println("Không có kết quả nào phù hợp.");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");
    }



    private void timGanMa() {
        System.out.println();
        System.out.println("TÌM KIẾM GẦN ĐÚNG THEO MÃ ĐẦU SÁCH");
        System.out.print("Nhập vào mã đầu sách gần đúng tìm kiếm: ");
        String maDauSach = scanner.nextLine();
        ListDauSach lst = dauSachBL.timGanMa(maDauSach);
        NodeDauSach tg = lst.getHead();

        System.out.println();
        if (tg != null) {
            System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                    "Mã Đầu Sách ",
                    "Tên Sách",
                    "Thể Loại",
                    "Tác Giả",
                    "Số lượng",
                    "Trạng thái");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            while (tg != null) {
                tg.getInfo().hienThi();
                tg = tg.getNext();
            }
        } else {
            System.out.println("Không có kết quả nào phù hợp.");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");

    }
}
