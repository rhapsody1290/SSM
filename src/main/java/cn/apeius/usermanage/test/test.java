package cn.apeius.usermanage.test;

import io.jsonwebtoken.impl.crypto.MacProvider;

import java.io.*;
import java.security.Key;

/**
 * Created by Asus on 2016/10/14.
 */
public class test {
    public static void main(String[] args){
        A a = new B();
        a.test();
    }


}
abstract class A{
    abstract void a();
    public void  test(){
        a();
    }
}
class B extends A{

    @Override
    void a() {
        System.out.println("b实现a");
    }
}
