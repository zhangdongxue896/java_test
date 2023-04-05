package rmi_test;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class server{
    public server() {}
    public static void main(String args[]) {
        System.setSecurityManager(new RMISecurityManager());//安全性管理器
        final MyFileImpl obj = new MyFileImpl();
        try {                               // 0 - anonymous TCP port ↓
            MyFile stub = (MyFile)UnicastRemoteObject.exportObject(obj, 0);
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(9527);//设置端口号
            registry.rebind("MyFile", stub);
            System.err.println("Server ready....");
            System.err.println("Listinging on port 9527 ....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}