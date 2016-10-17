package cn.apeius.usermanage.test;

import io.jsonwebtoken.impl.crypto.MacProvider;

import java.io.*;
import java.security.Key;

/**
 * Created by Asus on 2016/10/14.
 */
public class test {
    public static void main(String[] args){
        String parent = test.class.getClassLoader().getResource("").getPath();
        File file = new File(parent,"jwt_key");
        if(!file.exists()){
            try {
                if(!file.createNewFile()){
                    throw new RuntimeException("文件创建失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getAbsolutePath());

        Key key = null;
        try{
            if(file.length() == 0){
                System.out.println("新文件");
                key = MacProvider.generateKey();
                //写入文件
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                objectOutputStream.writeObject(key);
                objectOutputStream.close();
            }else{
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                objectInputStream.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //放入context


    }
}
