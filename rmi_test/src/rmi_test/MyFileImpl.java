package rmi_test;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class MyFileImpl implements MyFile {
    public MyFileImpl() {
    }
    public boolean createFile(String filePath) {
        boolean flag = false;
        File newFile = new File(filePath);
        if (!newFile.exists()) {//如果文件不存在
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            flag = true;
        }
        return flag;
    }
    public boolean updateFile(String filePath,String str) {
        boolean flag = false;
        File updateFile = new File(filePath);
        if (updateFile.exists()) {
            try{
                FileWriter fw = new FileWriter(filePath,true);//true代表允许在文件后继续写入文件，否则将覆盖原文件
                fw.write(str);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            flag = true;
        }
        return flag;
    }
    public boolean deleteFile(String filePath){
        boolean flag = false;
        File deleteFile = new File(filePath);
        if(deleteFile.exists()) {
            deleteFile.delete();
            flag = true;
        }
        return flag;
    }
    public File[] listFile(String folderPath){
        File folder = new File(folderPath);
        return folder.listFiles();
    }
    public int countFile(String folderPath){
        File folder = new File(folderPath);
        return folder.listFiles().length;
    }
    public double sizeFile(File file){//递归计算文件夹大小，如果是文件，就加上文件的大小，如果是文件夹，就遍历加上文件夹的所有文件的大小，然后递归文件夹中的文件夹
        if (file.isFile())
            return file.length();
        final File[] files = file.listFiles();
        long size = 0;
        if (files != null)
            for (final File file1 : files)
                size += sizeFile(file1);
        return size;
    }
}