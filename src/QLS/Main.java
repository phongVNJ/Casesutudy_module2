package QLS;

import Businese.DauSachBL;
import Businese.NguoiMuonBL;
import Businese.PhieuMuonBL;
import Businese.SachBL;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        QLNguoiMuon qlNguoiMuon = new QLNguoiMuon();
        QLSach qlSach = new QLSach();
        QLPhieuMuon qlPhieuMuon = new QLPhieuMuon();
        QLDauSach qlDauSach = new QLDauSach();

        do {
            System.out.println();
//            System.out.println("----------------------------\n");
            System.out.println("  CHUƯƠNG TRÌNH QUẢN LÍ THƯ VIỆN");
            System.out.println("---------------****--------------");
            System.out.println("| 1. Quản lí đầu sách.              |");
            System.out.println("| 2. Quản lí sách.                  |");
            System.out.println("| 3. Quản lí phiếu mượn.            |");
            System.out.println("| 4. Quản lí người mượn.            |");
            System.out.println("| 5. Tìm kiếm.                      |");
            System.out.println("| 6. Thống kê.                      |");
            System.out.println("| 0. Thoát chương trình.            |");
            System.out.println("-----------------------------------");
            System.out.println("Mời chọn chức năng: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n){
                case 1:
                    qlDauSach.menu();
                    break;
                case 2:
                    qlSach.menu();
                    break;
                case 3:
                    qlPhieuMuon.menu();
                    break;
                case 4:
                    qlNguoiMuon.menu();
                    break;
                case 5:
                    menuTimKiem();
                    break;
            }
            System.out.println("\n--------------kẾT THÚC MENU CHÍNH---------------\n");
        }while (true);
    }
    public static void menuTimKiem(){
        QLNguoiMuon qlNguoiMuon = new QLNguoiMuon();
        QLSach qlSach = new QLSach();
        QLPhieuMuon qlPhieuMuon = new QLPhieuMuon();
        QLDauSach qlDauSach = new QLDauSach();

        do {
            System.out.println();
//            System.out.println("---------------------------------\n");
            System.out.println("         TÌM KIẾM");
            System.out.println("------------------****---------------");
            System.out.println("| 1.Tìm kiếm đầu sách.              |");
            System.out.println("| 2.Tìm kiếm sách.                  |");
            System.out.println("| 3.Tìm kiếm phiếu mượn             |");
            System.out.println("| 4.Tìm kiếm người mượn.            |");
            System.out.println("| 9.Quay lại menu chính.            |");
            System.out.println("| 0.Thoát khỏi chương trình         |");
            System.out.println("-------------------------------------");
            System.out.print("  Mời chọn chức năng: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n){
                case 1:
                    qlDauSach.timKiem();
                    break;
                case 3:
                    qlPhieuMuon.timKiem();
                    break;
                case 4:
                    qlNguoiMuon.timKiem();
                    break;
                case 5:
                    menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
            System.out.println("\n-------------KẾT THÚC MENU TÌM KIẾM----------------\n");

        }while (true);
    }
    public static void thongke(){
        System.out.println();
        System.out.println("           THỐNG KÊ HỆ THỐNG");
        System.out.println("------------------****-----------------");
        SachBL sachBL = new SachBL();
        int tongSach = sachBL.tongSach();
        int tongSachCon = sachBL.tongSachCon();
        NguoiMuonBL nguoiMuonBL = new NguoiMuonBL();
        int tongNguoiMuon = nguoiMuonBL.tongNguoiMuon();
        PhieuMuonBL phieuMuonBL = new PhieuMuonBL();
        int tongPhieuMuon = phieuMuonBL.tongPhieuMuon();
        DauSachBL dauSachBL = new DauSachBL();
        int tongDauSach = dauSachBL.tongSach();
        System.out.println("|    Tổng người mượn: "+tongNguoiMuon+"             |");
        System.out.println("|    Tổng phiếu mượn: "+tongPhieuMuon+"             |");
        System.out.println("|    Tổng đầu sách: "+tongDauSach+"                 |");
        System.out.println("|    Tổng sách: "+tongSach+"               |");
        System.out.println("|    Tổng sách còn: "+tongSachCon+"              |");
        System.out.println("|    Tổng đầu sách còn: "+ tongDauSach+"          |");
        System.out.println("-----------------------------------------");
        System.out.println("\n--------------KẾT THÚC THỐNG KÊ----------------\n");




    }




}
