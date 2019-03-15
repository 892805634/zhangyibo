package com.third.easyprice.wx.AIMAIN;

import java.util.Scanner;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/12/20
 * Time:16:42
 */
public class AIMAIN {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str;
        while(true){
            str = sc.next();
            str=str.replace("吗","");
            str=str.replace("？","!");
            str=str.replace("？","!");
            System.out.println(str);
        }
    }
}
