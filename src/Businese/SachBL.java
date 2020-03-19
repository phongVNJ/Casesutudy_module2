package Businese;

import DataAcesses.DauSachDA;
import DataAcesses.SachDA;
import LIST.ListSach;
import MUONSACH.Sach;

public class SachBL {

    DataAcesses.SachDA SachDA = new SachDA();
    DauSachDA DausachDA = new DauSachDA();

    public ListSach layDanhSach() {
        return SachDA.layDanhSach();
    }
    public void them(Sach Sach) {
        SachDA.ghiSach(Sach);
    }

    public void sua(Sach Sach) {
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getMasach().equalsIgnoreCase(Sach.getMasach())) {
                tg.getInfo().capNhat(Sach);
            }
            tg = tg.getNext();
        }
        SachDA.ghiDanhSach(lst);
    }

    public void xoa(String maSach) {
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getMasach().equalsIgnoreCase(maSach)) {
                lst.removeNode(tg);
            }
            tg = tg.getNext();
        }
        SachDA.ghiDanhSach(lst);
    }

    public boolean kiemTra(String maSach) {
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getMasach().equalsIgnoreCase(maSach)) return true;
            tg = tg.getNext();
        }
        return false;
    }

    public ListSach timTen(String tenSach) {
        ListSach kq = new ListSach();
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getTenSach().contains(tenSach))
                kq.insertTail(tg.getInfo());
            tg = tg.getNext();
        }
        return kq;
    }
    public ListSach.NodeSach timMa(String maSach) {
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getMasach().equalsIgnoreCase(maSach)) return tg;
            tg = tg.getNext();
        }
        return null;
    }
    public ListSach timGanMa(String maSach) {
        ListSach kq = new ListSach();
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getMasach().contains(maSach))
                kq.insertTail(tg.getInfo());
            tg = tg.getNext();
        }
        return kq;
    }
    public int tongSach() {
        int dem = 0;
        ListSach.NodeSach tg = SachDA.layDanhSach().getHead();
        while (tg != null) {
            dem++;
            tg = tg.getNext();
        }
        return dem;
    }
    public int tongSachCon(){
        int dem=0;
        ListSach.NodeSach tg = SachDA.layDanhSach().getHead();
        while(tg!=null){
            if (tg.getInfo().getTinhTrang().equalsIgnoreCase("con"))
                dem++;
            tg=tg.getNext();
        }
        return dem;
    }

}
