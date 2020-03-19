package Businese;

import LIST.ListPhieuMuon;
import LIST.ListPhieuMuon.NodePhieuMuon;
import MUONSACH.PhieuMuon;
import DataAcesses.PhieuMuonDA;

public class PhieuMuonBL {
    PhieuMuonDA phieuMuonDA = new PhieuMuonDA();

    public ListPhieuMuon layDanhSach() {
        return phieuMuonDA.layDanhSach();
    }

    public void them(PhieuMuon phieuMuon) {
        phieuMuonDA.ghiPhieuMuon(phieuMuon);
    }

    public void sua(PhieuMuon phieuMuon) {
        ListPhieuMuon lst = phieuMuonDA.layDanhSach();
        NodePhieuMuon tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getmaNguoiMuon().equalsIgnoreCase(phieuMuon.getmaNguoiMuon())
                    && tg.getInfo().getmaNguoiMuon().equalsIgnoreCase(phieuMuon.getmaNguoiMuon())) {
                tg.getInfo().capNhat(phieuMuon);
            }
            tg = tg.getNext();
        }
        phieuMuonDA.ghiDanhSach(lst);
    }

    public void xoa(String maNguoiMuon) {
        ListPhieuMuon lst = phieuMuonDA.layDanhSach();
        NodePhieuMuon tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getmaNguoiMuon().equalsIgnoreCase(maNguoiMuon)) {
                lst.removeNode(tg);
            }
            tg = tg.getNext();
        }
        phieuMuonDA.ghiDanhSach(lst);
    }

    public boolean kiemTra(String maNguoiMuon) {
        ListPhieuMuon lst = phieuMuonDA.layDanhSach();
        NodePhieuMuon tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getmaNguoiMuon().equalsIgnoreCase(maNguoiMuon)) return true;
            tg = tg.getNext();
        }
        return false;
    }
    public ListPhieuMuon timNgay(String ngayMuon) {
        ListPhieuMuon kq = new ListPhieuMuon();
        ListPhieuMuon lst = phieuMuonDA.layDanhSach();
        NodePhieuMuon tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getNgayMuon().contains(ngayMuon))
                kq.insertTail(tg.getInfo());
            tg = tg.getNext();
        }
        return kq;
    }
    public int tongPhieuMuon() {
        int dem = 0;
        ListPhieuMuon.NodePhieuMuon tg = phieuMuonDA.layDanhSach().getHead();
        while (tg != null) {
            dem++;
            tg = tg.getNext();
        }
        return dem;
    }

    public ListPhieuMuon timSoLuong(String soLuong) {
        return null;
    }
}
