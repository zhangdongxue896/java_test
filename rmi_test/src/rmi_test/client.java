package rmi_test;

import java.net.MalformedURLException;
import java.rmi.*;
import java.io.File;
import java.util.Scanner;
public class client {
    private client() {
    }
    public static void main(String[] args) throws RemoteException, MalformedURLException,NotBoundException {
        String host = (args.length < 1) ? "localhost" : args[0];
        String urlo = "rmi://" + host + ":9527/MyFile";
        MyFile stub = (MyFile) Naming.lookup(urlo);
        System.out.println("link to the server: \n" + urlo);
        File test = new File("D://test");//测试的文件夹放在D盘，并且命名为test
        if(!test.exists()){//如果test文件夹不存在，那就新建一个文件夹，以下的所有文件夹操作都将在test文件夹内操作
            test.mkdir();
        }
        Scanner input = new Scanner(System.in);//用以接收操作的指令
        boolean flag = true;
        while(flag){
            System.out.println("input a number to select an operation:");
            System.out.println("1 for creating a file");//新建文件
            System.out.println("2 for updating a file");//修改文件（在文件后面添加数据）
            System.out.println("3 for deleting a file");//删除文件
            System.out.println("4 for listing files");//列出test文件夹里的所有文件和文件夹
            System.out.println("5 for counting files");//计算test文件夹里所有文件和文件夹的个数
            System.out.println("6 for outputting the size of files");//计算test文件夹下所有文件的大小
            System.out.println("other number to exit");
            switch (input.nextInt()) {
                case 1:
                    System.out.println("name the file");
                    Scanner inputfilename1 = new Scanner(System.in);
                    String filename1 = inputfilename1.nextLine();
                    boolean cF = stub.createFile("D:/test/"+filename1+".txt");
                    if (cF) {
                        System.out.println("create a new file successfully!");
                    }
                    else{
                        System.out.println("file already exists");
                    }
                    break;
                case 2:
                    System.out.println("choose a file");
                    Scanner inputfilename2 = new Scanner(System.in);
                    String filename2 = inputfilename2.nextLine();
                    System.out.println("input the content");
                    Scanner inputcontent = new Scanner(System.in);
                    String content = inputcontent.nextLine();
                    boolean uF = stub.updateFile("D:/test/"+filename2+".txt", content);
                    if (uF) {
                        System.out.println("update file successfully!");
                    }
                    else{
                        System.out.println("update unsuccessfully");
                    }
                    break;
                case 3:
                    System.out.println("choose a file to delete");
                    Scanner inputfilename3 = new Scanner(System.in);
                    String filename3 = inputfilename3.nextLine();
                    boolean dF = stub.deleteFile("D:/test/"+filename3+".txt");
                    if(dF){
                        System.out.println("delete file successfully");
                    }
                    else{
                        System.out.println("delete file unsuccessfully");
                    }
                    break;
                case 4:
                    File[] files = stub.listFile("D:/test/");
                    for(File file:files){
                        System.out.println(file.getName());
                    }
                    break;
                case 5:
                    System.out.println("there are "+stub.countFile("D:/test/")+" files");
                    break;
                case 6:
                    System.out.println(stub.sizeFile(new File("D:/test/"))+"bytes");
                    break;
                default:{
                    flag = false;
                }
            }
        }
    }
}