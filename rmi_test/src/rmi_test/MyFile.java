package rmi_test;

import java.io.File;

public interface MyFile extends java.rmi.Remote{
    boolean createFile(String filePath) throws java.rmi.RemoteException;
    boolean updateFile(String filePath, String str) throws java.rmi.RemoteException;
    boolean deleteFile(String filePath) throws java.rmi.RemoteException;
    File[] listFile(String folderPath) throws java.rmi.RemoteException;
    int countFile(String folderPath) throws java.rmi.RemoteException;
    double sizeFile(File file) throws java.rmi.RemoteException;
}