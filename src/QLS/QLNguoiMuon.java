package QLS;

import Businese.NguoiMuonBL;
import Businese.PhieuMuonBL;
import Businese.SachBL;
import MUONSACH.NguoiMuon;
import java.util.Scanner;

import LIST.ListNguoiMuon.NodeNguoiMuon;

public class QLNguoiMuon<ListNguoiMuon> {
    Scanner scanner = new Scanner(System.in);
    NguoiMuonBL nguoiMuonBL = new NguoiMuonBL();
    SachBL sachBL = new SachBL();
    PhieuMuonBL phieuMuonBL = new PhieuMuonBL();

    public void menu() {
        do {
            System.out.println();
            System.out.println("            QUẢN LÝ NGƯỜI MƯỢN");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Thêm người mượn.                 |");
            System.out.println("|   2. Sửa thông tin.                   |");
            System.out.println("|   3. Xóa người mượn.                  |");
            System.out.println("|   4. Xem danh sách.                   |");
            System.out.println("|   5. Sắp xếp theo tên.                |");
            System.out.println("|   6. Tìm kiếm.                        |");
            System.out.println("|   9. Quay lại menu chính.             |");
            System.out.println("|   0. Thoát chương trình.              |");
            System.out.println("-----------------------------------------");
            System.out.print("Mời chọn chức năng: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
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

            System.out.println("\n---------------------KẾT THÚC MENU QUẢN LÝ NGƯỜI MƯỢN------------------\n");
        } while (true);


    }

    private void sapXepTheoTen() {
        System.out.println();
        System.out.println("DANH SÁCH NGƯỜI MƯỢN");
        LIST.ListNguoiMuon lst = nguoiMuonBL.layDanhSach();
        lst.sapXepTheoTen();
        NodeNguoiMuon tg = lst.getHead();

        System.out.printf("%-15s | %-20S | %-25s | %-30s | %-20s |\n",
                "Mã Người mượn ",
                "Tên người mượn",
                "Địa chỉ",
                "SĐT",
                "Email");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        while (tg != null) {
            tg.getInfo().hienThi();
            tg = tg.getNext();
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");

    }

    private void xemDanhSach() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("DANH SÁCH ");
        LIST.ListNguoiMuon lst = nguoiMuonBL.layDanhSach();
        NodeNguoiMuon tg = lst.getHead();
        lst.sapXepTheoTen();

        System.out.printf("%-15s | %-20S | %-25s | %-30s | %-20s |\n",
                "Mã Người mượn ",
                "Tên người mượn",
                "Địa Chỉ",
                "SĐT",
                "Email");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        while (tg != null) {
            tg.getInfo().hienThi();
            tg = tg.getNext();
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");


    }

    private void xoa() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("         XÓA THÔNG TIN  NGƯỜI MƯỢN");
        System.out.println("-------------------***-------------------");
        System.out.println("Nhập vào mã của người mượn cần xóa: ");
        String maNguoiMuon = scanner.nextLine();
        if (nguoiMuonBL.kiemTra(maNguoiMuon)) {
            nguoiMuonBL.xoa(maNguoiMuon);
            System.out.println("Xóa thành công người mươn có mã: " + maNguoiMuon);
        } else {
            System.out.println("Không tồn tại người mượn có mã: " + maNguoiMuon);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }

    private void sua() {
        System.out.println();
        System.out.println("        SỬA THÔNG TIN NGƯỜI MƯỢN ");
        System.out.println("-------------------***-------------------");
        String maNguoiMuon, tenNguoiMuon, diaChi, soDienThoai, email;

        do {
            System.out.print("Nhập vào mã người mượn: ");
            maNguoiMuon = scanner.nextLine();
        } while (maNguoiMuon == "");

        if (nguoiMuonBL.kiemTra(maNguoiMuon)) {
            System.out.println("NHẬP VÀO THÔNG TIN MỚI CHO NGƯỜI MƯỢN : " + maNguoiMuon);
            do {
                System.out.print("Nhập tên Người Mượn: ");
                tenNguoiMuon = scanner.nextLine();
            } while (tenNguoiMuon == "");
            do {
                System.out.print("Nhập địa chỉ: ");
                diaChi = scanner.nextLine();
            } while (diaChi == "");
            do {
                System.out.print("Nhập SDT: ");

                soDienThoai = scanner.nextLine();
            } while (soDienThoai == "");

            do {
                System.out.print("Nhập email: ");
                email = scanner.nextLine();
            } while (email == "");


            NguoiMuon nguoiMuon = new NguoiMuon(maNguoiMuon, tenNguoiMuon, diaChi, soDienThoai, email);
            nguoiMuonBL.sua(nguoiMuon);

        } else {
            System.out.println("Không tồn tại mã: " + maNguoiMuon);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");

    }

    private void them() {
        System.out.println();
        System.out.println("            THÊM NGƯỜI MƯỢN");
        System.out.println("-------------------***-------------------");
        System.out.println("MỜI NHẬP VÀO CÁC THÔNG TIN:");
        String maNguoiMuon, tenNguoiMuon, diaChi, soDienThoai, email;
        do {
            System.out.print("Nhập vào mã cho người mượn: ");
            maNguoiMuon = scanner.nextLine();
        } while (maNguoiMuon == "");
        if (!nguoiMuonBL.kiemTra(maNguoiMuon)) {
            do {
                System.out.print("Nhập tên : ");
                tenNguoiMuon = scanner.nextLine();
            } while (tenNguoiMuon == "");
            do {
                System.out.print("email: ");
                email = scanner.nextLine();
            } while (email == "");
            do {
                System.out.print("Nhập địa chỉ: ");

                diaChi = scanner.nextLine();
            } while (diaChi == "");

            do {
                System.out.print("Nhập SDT: ");
                soDienThoai = scanner.nextLine();
            } while (soDienThoai == "");
            NguoiMuon nguoiMuon = new NguoiMuon(maNguoiMuon, tenNguoiMuon, diaChi, soDienThoai, email);
            nguoiMuonBL.them(nguoiMuon);
        } else {
            System.out.println("Đã tồn tại mã: " + maNguoiMuon);

        }
        System.out.println("\n-----------------------------------------------------------------------------\n");


    }

    public void timKiem() {
        do {
            System.out.println();
//            System.out.println("---------------------------------------\n");
            System.out.println("            TÌM KIẾM NGƯỜI MƯỢN");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Tìm theo tên.                    |");
            System.out.println("|   2. Tìm theo địa chỉ.                |");
            System.out.println("|   9. Quay lại menu QL Thư Viện.       |");
            System.out.println("|   0. Thoát chương trình.              |");
            System.out.println("-----------------------------------------");
            System.out.print("      Mời chọn chức năng: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    timTen();
                    break;
                case 2:
                    timDiaChi();
                    break;
                case 9:
                    menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n--------------------KẾT THÚC MENU TÌM KIẾM NGƯỜI MƯỢN-------------------\n");
        } while (true);


    }

    private void timTen() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("            TÌM KIẾM THEO TÊN");
        System.out.println("-------------------***-------------------");
        System.out.print("  Nhập vào tên cần tìm kiếm: ");
        String tenNguoiMuon = scanner.nextLine();
        LIST.ListNguoiMuon lst = nguoiMuonBL.timTen(tenNguoiMuon);
        NodeNguoiMuon tg = lst.getHead();

        System.out.println();
        if (tg != null) {
            System.out.printf("%-15s | %-20S | %-25s | %-30s | %-20s |\n",
                    "Mã Ngươi mượn ",
                    "Tên người mượn",
                    "Địa Chỉ",
                    "SĐT",
                    "Email");
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

    private void timDiaChi() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("          TÌM KIẾM THEO ĐỊA CHỈ");
        System.out.println("-------------------***-------------------");
        System.out.print("Nhập vào địa chỉ cần tìm kiếm: ");
        String diaChi = scanner.nextLine();
        LIST.ListNguoiMuon lst = nguoiMuonBL.timDiaChi(diaChi);
        NodeNguoiMuon tg = lst.getHead();

        System.out.println();
        if (tg != null) {
            System.out.printf("%-15s | %-20S | %-25s | %-30s | %-20s |\n",
                    "Mã Người mượn ",
                    "Tên người mượn",
                    "Địa Chỉ",
                    "SĐT",
                    "Email");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        }
    }
}