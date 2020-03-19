package DataAcesses;
import MUONSACH.NguoiMuon;
import LIST.ListNguoiMuon;
import LIST.ListNguoiMuon.NodeNguoiMuon;
import java.io.*;

public class NguoiMuonDA {
    private static final String fileName = "NguoiMuon.txt";


    public ListNguoiMuon layDanhSach() {
        ListNguoiMuon lst = new ListNguoiMuon();
        NguoiMuon nguoiMuon;
        String[] tmp;
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                tmp = line.split("#"); // # la ky tu phan tach giua cac truong trong file
                nguoiMuon = new NguoiMuon(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]);
                lst.insertTail(nguoiMuon);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Không thể mở file hoặc không tồn tại file " + fileName);
        } catch (IOException ex) {
            System.err.println("Không thể đọc file " + fileName);
        }
        return lst;
    }

    // Ghi danh sách thông tin máy ảnh vào tệp.
    public void ghiDanhSach(ListNguoiMuon lst) {
        NodeNguoiMuon tg = lst.getHead();

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while (tg != null) {
                bufferedWriter.write(tg.getInfo().toString());
                bufferedWriter.newLine();
                tg = tg.getNext();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println("Không thể ghi vào file " + fileName);
        }
    }


//    //Ghi thêm thông tin máy ảnh vào cuối tệp.
//    public void ghiMayAnh(MayAnh mayAnh) {
//        String s = mayAnh.toString();
//        byte data[] = s.getBytes();
//        Path p = Paths.get("./" + fileName);
//        try {
//            OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, APPEND));
//            out.write(data, 0, data.length);
//        } catch (IOException x) {
//            System.err.println(x);
//        }
//    }

    //Ghi thêm thông tin máy ảnh vào cuối tệp.
    public void ghiNguoiMuon(NguoiMuon nguoiMuon) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true));
            pw.println(nguoiMuon.toString());
            pw.close();
        } catch (IOException e) {
            System.err.println("Không thể ghi vào tệp " + fileName);
        }
    }

}
