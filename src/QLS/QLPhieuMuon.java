package QLS;

import Businese.DauSachBL;
import Businese.NguoiMuonBL;
import Businese.PhieuMuonBL;
import Businese.SachBL;
import MUONSACH.PhieuMuon;
import LIST.ListPhieuMuon;
import LIST.ListPhieuMuon.NodePhieuMuon;
import MUONSACH.DauSach;

import java.util.Scanner;

public class QLPhieuMuon {
    Scanner scanner = new Scanner(System.in);
    PhieuMuonBL phieuMuonBL = new PhieuMuonBL();
    SachBL sachBL = new SachBL();
    NguoiMuonBL nguoiMuonBL= new NguoiMuonBL();
    DauSachBL dauSachBL = new DauSachBL();

    public void menu() {
        do {
            System.out.println();
//            System.out.println("---------------------------------------\n");
            System.out.println("            QUẢN LÝ PHIẾU MƯỢN");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Thêm phiếu mượn.                    |");
            System.out.println("|   2. Sửa thông tin.                      |");
            System.out.println("|   3. Xóa phiếu mượn.                     |");
            System.out.println("|   4. Xem danh sách.                      |");
            System.out.println("|   5. Sắp xếp theo loại.                  |");
            System.out.println("|   6. Tìm kiếm.                           |");
            System.out.println("|   9. Quay lại menu chính.                |");
            System.out.println("|   0. Thoát chương trình.                 |");
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

            System.out.println("\n---------------------KẾT THÚC MENU QUẢN LÝ PHIẾU MƯỢN------------------\n");
        } while (true);
    }

    public void them() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("            THÊM PHIẾU MƯỢN");
        System.out.println("-------------------***-------------------");
        System.out.println("MỜI NHẬP VÀO CÁC THÔNG TIN:\n");
        String maNguoiMuon,maSach, madausach, ngayMuon;
        do {
            System.out.print("Nhập vào mã cho phiếu mượn: ");
            maNguoiMuon = scanner.nextLine();
        } while (maNguoiMuon == "");
        if (!phieuMuonBL.kiemTra(maNguoiMuon)) {
            do {
                System.out.print("ngày mượn: ");
                ngayMuon = scanner.nextLine();
            } while (ngayMuon == "");

            do {
                System.out.print("Mã sách: ");
                maSach = scanner.nextLine();
            } while (maSach == ""||!sachBL.kiemTra(maSach));
            do {
                System.out.print("Mã đầu sách: ");
                madausach = scanner.nextLine();
            } while (madausach == ""||!dauSachBL.kiemTra(madausach));


            PhieuMuon phieuMuon = new PhieuMuon(maNguoiMuon,maSach, madausach, ngayMuon);
            phieuMuonBL.them(phieuMuon);
        } else {
            System.out.println("không tồn tại mã: " + maNguoiMuon);
        }
        System.out.println("\n-----------------------------------------------------------------------------\n");

    }

    public void sua() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("         SỬA THÔNG TIN PHIẾU MƯỢN ");
        System.out.println("-------------------***-------------------");
        String maNguoiMuon, ngayMuon,soLuong,maSach, madausach;

        do {
            System.out.print("Nhập vào mã phiếu mượn: ");
            maNguoiMuon = scanner.nextLine();
        } while (maNguoiMuon == ""||!phieuMuonBL.kiemTra(maNguoiMuon));

        if (phieuMuonBL.kiemTra(maNguoiMuon)) {
            System.out.println("NHẬP VÀO THÔNG TIN MỚI CHO PHIẾU MƯỢN MƯỢN : " + maNguoiMuon);
            do {
                System.out.print("Nhập tên NgayMượn: ");
                ngayMuon = scanner.nextLine();
            } while (ngayMuon == "");

            do {
                System.out.print("Nhập số lượng: ");
                soLuong = scanner.nextLine();
            } while (soLuong == "");


            do {
                System.out.print("Nhập mã sách: ");
                maSach = scanner.nextLine();
            } while (maSach == "");
            do {
                System.out.print("Nhập mã đầu sách: ");
                madausach = scanner.nextLine();
            } while (madausach == "");


            PhieuMuon phieuMuon = new PhieuMuon(maNguoiMuon, maSach, madausach, ngayMuon);
            phieuMuonBL.sua(phieuMuon);

        } else {
            System.out.println("Không tồn tại mã: " + maNguoiMuon);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }


    public void xoa() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("          SỬA THÔNG TIN PHIẾU MƯỢN");
        System.out.println("-------------------***-------------------");
        System.out.println("Nhập vào mã của phiếu mượn cần xóa: ");
        String maNguoiMuon = scanner.nextLine();
        if (phieuMuonBL.kiemTra(maNguoiMuon)) {
            phieuMuonBL.xoa(maNguoiMuon);
            System.out.println("Xóa thành công phiếu mươn có mã: " + maNguoiMuon);
        } else {
            System.out.println("Không tồn tại phiếu mượn có mã: " + maNguoiMuon);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }

    public void xemDanhSach() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("DANH SÁCH ");
        ListPhieuMuon lst = phieuMuonBL.layDanhSach();
        lst.sapXepTheoTen();
        NodePhieuMuon tg = lst.getHead();
        System.out.printf("%-25s | %-10s |%-10s | %-10s | %-20s|\n",
                "Mã Người mượn ",
                "Mã sách",
                "Mã Đầu sách",
                "Số lượng",
                "ngày mượn");
        System.out.println("---------------------------------------------------------------------------------------");

        while (tg != null) {
            tg.getInfo().hienThi();
            tg = tg.getNext();
        }

        System.out.println("---------------------------------------------------------------------------------------\n");
    }

    public void sapXepTheoTen() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("DANH SÁCH PHIẾU MƯỢN");
        ListPhieuMuon lst = phieuMuonBL.layDanhSach();
        lst.sapXepTheoTen();
        NodePhieuMuon tg = lst.getHead();
        System.out.printf("%-25s | %-10s |%-10s | %-20s|\n",
                "Mã Người mượn ",
                "Mã sách",
                "Mã Đầu sách",
                "ngày mượn");
        System.out.println("---------------------------------------------------------------------------------------");
        while (tg != null) {
            tg.getInfo().hienThi();
            tg = tg.getNext();
        }

        System.out.println("---------------------------------------------------------------------------------------\n");
    }

    public void timKiem() {
        do {
            System.out.println();
//            System.out.println("---------------------------------------\n");
            System.out.println("            TÌM KIẾM PHIẾU MƯỢN");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Tìm theo mã người mượn.          |");
            System.out.println("|   2. Tìm theo ngày mượn.               |");
            System.out.println("|   9. Quay lại menu QL Thư Viện.       |");
            System.out.println("|   0. Thoát chương trình.              |");
            System.out.println("-----------------------------------------");
            System.out.print("      Mời chọn chức năng: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    timMa();
                    break;
                case 2:
                    timSoLuong();
                    break;
                case 9:
                    menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n--------------------KẾT THÚC MENU TÌM KIẾM PHIẾU MƯỢN-------------------\n");
        } while (true);
    }


    public void timMa() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("        TÌM KIẾM THEO MÃ NGƯỜI MƯỢN");
        System.out.println("-------------------***-------------------");
        System.out.print("  Nhập vào mã cần tìm kiếm: ");
        String ngayMuon = scanner.nextLine();
        ListPhieuMuon lst = phieuMuonBL.timNgay(ngayMuon);
        NodePhieuMuon tg = lst.getHead();

        System.out.println();
        if (tg != null) {
            System.out.printf("%-25s | %-10s |%-10s | %-20s|\n",
                    "Mã Người mượn ",
                    "Mã sách",
                    "Mã Đầu Sách",
                    "ngày mượn");
            System.out.println("---------------------------------------------------------------------------------------");
            while (tg != null) {
                tg.getInfo().hienThi();
                tg = tg.getNext();
            }
        } else {
            System.out.println("Không có kết quả nào phù hợp.");
        }
        System.out.println("---------------------------------------------------------------------------------------\n");

    }
    public void timSoLuong() {
        System.out.println();
//        System.out.println("---------------------------------------\n");
        System.out.println("         TÌM KIẾM THEO SỐ LƯỢNG");
        System.out.println("-------------------***-------------------");
        System.out.print("  Nhập vào số lượng cần tìm kiếm: ");
        String soLuong = scanner.nextLine();
        ListPhieuMuon lst = phieuMuonBL.timSoLuong(soLuong);
        NodePhieuMuon tg = lst.getHead();

        System.out.println();
        if (tg != null) {
            System.out.printf("%-25s | %-10s |%-10s | %-20s|\n",
                    "Mã Người mượn ",
                    "Mã sách",
                    "Mã Đầu Sách",
                    "ngày mượn");
            System.out.println("---------------------------------------------------------------------------------------");

            while (tg != null) {
                tg.getInfo().hienThi();
                tg = tg.getNext();
            }
        } else {
            System.out.println("Không có kết quả nào phù hợp.");
        }
        System.out.println("---------------------------------------------------------------------------------------\n");

    }
}
