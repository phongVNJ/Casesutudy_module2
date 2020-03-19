package Businese;

import DataAcesses.DauSachDA;
import LIST.ListDauSach;
import LIST.ListDauSach.NodeDauSach;
import LIST.ListSach;
import LIST.ListSach.NodeSach;
import MUONSACH.DauSach;

public class DauSachBL {
    DauSachDA dausachDA = new DauSachDA();

    public ListDauSach layDanhSach() {
        return dausachDA.layDanhSach();
    }

    public void them(DauSach Dausach) {
        dausachDA.ghiDauSach(Dausach);
    }

    public void sua(DauSach dausach) {
        ListDauSach lst = dausachDA.layDanhSach();
        NodeDauSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getMaDauSach().equalsIgnoreCase(dausach.getMaDauSach())) {
                tg.getInfo().capNhat(dausach);
            }
            tg = tg.getNext();
        }
        dausachDA.ghiDanhSach(lst);
    }

    public void xoa(String maDauSach) {
        ListDauSach lst = dausachDA.layDanhSach();
        ListDauSach.NodeDauSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getMaDauSach().equalsIgnoreCase(maDauSach)) {
                lst.removeNode(tg);
            }
            tg = tg.getNext();
        }
        dausachDA.ghiDanhSach(lst);
    }

    public boolean kiemTra(String maDauSach) {
        ListDauSach lst = dausachDA.layDanhSach();
        ListDauSach.NodeDauSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getMaDauSach().equalsIgnoreCase(maDauSach)) return true;
            tg = tg.getNext();
        }
        return false;
    }

    public ListDauSach.NodeDauSach timMa(String maDauSach) {
        ListDauSach lst = dausachDA.layDanhSach();
        ListDauSach.NodeDauSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getMaDauSach().equalsIgnoreCase(maDauSach)) return tg;
            tg = tg.getNext();
        }
        return null;
    }
    public ListDauSach timGanMa(String maDauSach) {
        ListDauSach kq = new ListDauSach();
        ListDauSach lst = dausachDA.layDanhSach();
        NodeDauSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getMaDauSach().contains(maDauSach))
                kq.insertTail(tg.getInfo());
            tg = tg.getNext();
        }
        return kq;
    }

    public ListDauSach timTen(String tenSach) {
        ListDauSach kq = new ListDauSach();
        ListDauSach lst = dausachDA.layDanhSach();
        NodeDauSach tg = lst.getHead();
        while (tg != null) {
            if (tg.getInfo().getTenSach().contains(tenSach))
                kq.insertTail(tg.getInfo());
            tg = tg.getNext();
        }
        return kq;
    }

    public int tongSach() {
        int dem = 0;
        ListDauSach.NodeDauSach tg = dausachDA.layDanhSach().getHead();
        while (tg != null) {
            dem++;
            tg = tg.getNext();
        }
        return dem;
    }
    public int tongSachCon(){
        int dem=0;
        ListDauSach.NodeDauSach tg = dausachDA.layDanhSach().getHead();
        while(tg!=null){
            if (tg.getInfo().getTrangThai().equalsIgnoreCase("con"))
                dem++;
            tg=tg.getNext();
        }
        return dem;
    }


}
