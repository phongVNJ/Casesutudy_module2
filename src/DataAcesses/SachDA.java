package DataAcesses;
import MUONSACH.Sach;
import MUONSACH.Sach;
import LIST.ListSach;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class SachDA {
    private static final String fileName="Sach.txt";


    public ListSach layDanhSach()
    {
        ListSach lst=new ListSach();
        Sach sach;
        String [] tmp;
        String line=null;

        try {
            FileReader fileReader=new FileReader(fileName);
            BufferedReader  bufferedReader=new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                tmp = line.split("#"); // # la ky tu phan tach giua cac truong trong file
                sach = new Sach(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]);
                lst.insertTail(sach);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Không thể mở file hoặc không tồn tại file "+fileName);
        } catch (IOException ex) {
            System.err.println("Không thể đọc file "+fileName);
        }
        return lst;
    }

    // Ghi danh sách thông tin máy ảnh vào tệp.
    public void ghiDanhSach(ListSach lst)
    {
        ListSach.NodeSach tg=lst.getHead();

        try {
            FileWriter fileWriter=new FileWriter(fileName);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            while(tg!=null)
            {
                bufferedWriter.write(tg.getInfo().toString());
                bufferedWriter.newLine();
                tg=tg.getNext();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println("Không thể ghi vào file "+fileName);
        }
    }


    //Ghi thêm thông tin máy ảnh vào cuối tệp.
    public void ghiSach(Sach sach) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true));
            pw.println(sach.toString());
            pw.close();
        } catch (IOException e) {
            System.err.println("Không thể ghi vào tệp " + fileName);
        }
    }
}
