package DataAcesses;
import LIST.ListPhieuMuon;
import MUONSACH.PhieuMuon;

import java.io.*;

public class PhieuMuonDA {
    private static final String fileName = "PhieuMuon.txt";

    public ListPhieuMuon layDanhSach() {
        ListPhieuMuon lst = new ListPhieuMuon();
        PhieuMuon phieuMuon;
        String[] tmp;
        String line = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                tmp = line.split("#"); // # la ky tu phan tach giua cac truong trong file
                phieuMuon = new PhieuMuon(tmp[0], tmp[1],tmp[2],tmp[3]);
                lst.insertTail(phieuMuon);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Không thể mở file hoặc không tồn tại file " + fileName);
        } catch (IOException ex) {
            System.err.println("Không thể đọc file " + fileName);
        }
        return lst;
    }

    // Ghi danh sách thông tin máy ảnh vào tệp.
    public void ghiDanhSach(ListPhieuMuon lst) {
        ListPhieuMuon.NodePhieuMuon tg = lst.getHead();
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            while (tg != null) {
                bufferedWriter.write(tg.getInfo().toString());
                bufferedWriter.newLine();
                tg = tg.getNext();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ex) {
            System.err.println("Không thể ghi vào file " + fileName);
        }
    }

    //Ghi thêm thông tin máy ảnh vào cuối tệp.
    public void ghiPhieuMuon(PhieuMuon phieuMuon) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(fileName, true));
            pw.println(phieuMuon.toString());
            pw.close();
        } catch (IOException e) {
            System.err.println("Không thể ghi vào tệp " + fileName);
        }
    }

}
