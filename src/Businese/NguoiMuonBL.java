package Businese;

import DataAcesses.NguoiMuonDA;
import LIST.ListNguoiMuon;
import MUONSACH.NguoiMuon;
import LIST.ListNguoiMuon.NodeNguoiMuon;

public class NguoiMuonBL {
    NguoiMuonDA nguoiMuonDA = new NguoiMuonDA();

    public ListNguoiMuon layDanhSach() {
        return nguoiMuonDA.layDanhSach();
    }

    public void them(NguoiMuon nguoiMuon) {
        nguoiMuonDA.ghiNguoiMuon(nguoiMuon);
    }

    public void sua(NguoiMuon nguoiMuon) {
        ListNguoiMuon lst = nguoiMuonDA.layDanhSach();
        ListNguoiMuon.NodeNguoiMuon tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getmaNguoiMuon().equalsIgnoreCase(nguoiMuon.getmaNguoiMuon())) {
                tg.getInfo().capNhat(nguoiMuon);
            }
            tg = tg.getNext();
        }
        nguoiMuonDA.ghiDanhSach(lst);
    }

    public void xoa(String maNguoiMuon) {
        ListNguoiMuon lst = nguoiMuonDA.layDanhSach();
        ListNguoiMuon.NodeNguoiMuon tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getmaNguoiMuon().equalsIgnoreCase(maNguoiMuon)) {
                lst.removeNode(tg);
            }
            tg = tg.getNext();
        }
        nguoiMuonDA.ghiDanhSach(lst);
    }

    public boolean kiemTra(String maNguoiMuon) {
        ListNguoiMuon lst = nguoiMuonDA.layDanhSach();
        ListNguoiMuon.NodeNguoiMuon tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getmaNguoiMuon().equalsIgnoreCase(maNguoiMuon)) return true;
            tg = tg.getNext();
        }
        return false;
    }

    public ListNguoiMuon timTen(String tenNguoiMuon) {
        ListNguoiMuon kq = new ListNguoiMuon();
        ListNguoiMuon lst = nguoiMuonDA.layDanhSach();
        NodeNguoiMuon tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getTenNguoiMuon().contains(tenNguoiMuon))
                kq.insertTail(tg.getInfo());
            tg = tg.getNext();
        }
        return kq;
    }

    public ListNguoiMuon timDiaChi(String diaChi) {
        ListNguoiMuon kq = new ListNguoiMuon();
        ListNguoiMuon lst = nguoiMuonDA.layDanhSach();
        ListNguoiMuon.NodeNguoiMuon tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getDiaChi().contains(diaChi))
                kq.insertTail(tg.getInfo());
            tg = tg.getNext();
        }
        return kq;
    }


    public int tongNguoiMuon() {
        int dem = 0;
        ListNguoiMuon.NodeNguoiMuon tg = nguoiMuonDA.layDanhSach().getHead();
        while (tg != null) {
            dem++;
            tg = tg.getNext();
        }
        return dem;
    }

}
