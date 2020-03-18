package QLS;

import Businese.DauSachBL;
import Businese.NguoiMuonBL;
import Businese.PhieuMuonBL;
import Businese.SachBL;

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

    private void xemDanhSach() {
    }

    private void sapXepTheoTen() {
    }

    private void sua() {
    }

    private void them() {
    }

    public void timKiem() {
    }
    public void xoa(){
    }
}
