package DataAcesses;
import MUONSACH.DauSach;
import LIST.ListDauSach;
import LIST.ListDauSach.NodeDauSach;
import java.io.*;




public class DauSachDA {
    private static final String fileName = "DauSach.txt";


    public ListDauSach layDanhSach() {
        ListDauSach lst = new ListDauSach();
        DauSach dauSach;
        String[] tmp;
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                tmp = line.split("#"); // # la ky tu phan tach giua cac truong trong file
                dauSach = new DauSach(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]);
                lst.insertTail(dauSach);
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
    public void ghiDanhSach(ListDauSach lst) {
        NodeDauSach tg = lst.getHead();

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
    public void ghiDauSach(DauSach dauSach) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true));
            pw.println(dauSach.toString());
            pw.close();
        } catch (IOException e) {
            System.err.println("Không thể ghi vào tệp " + fileName);
        }
    }


}
