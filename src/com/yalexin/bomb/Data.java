package com.yalexin.bomb;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */

import javax.swing.*;
import java.net.URL;

/**
 * 加载图片资源
 */
public class Data {
    public static URL floor01URL = Data.class.getResource("statics/floor01.png");
    public static ImageIcon floor01 = new ImageIcon(floor01URL);

    public static URL floor02URL = Data.class.getResource("statics/floor02.png");
    public static ImageIcon floor02 = new ImageIcon(floor02URL);

    public static URL floor03URL = Data.class.getResource("statics/floor03.png");
    public static ImageIcon floor03 = new ImageIcon(floor03URL);

    public static URL upURL = Data.class.getResource("statics/up.png");
    public static ImageIcon up = new ImageIcon(upURL);

    public static URL downURL = Data.class.getResource("statics/down.png");
    public static ImageIcon down = new ImageIcon(downURL);

    public static URL leftURL = Data.class.getResource("statics/left.png");
    public static ImageIcon left = new ImageIcon(leftURL);

    public static URL rightURL = Data.class.getResource("statics/right.png");
    public static ImageIcon right = new ImageIcon(rightURL);

    public static URL bombURL = Data.class.getResource("statics/bomb.png");
    public static ImageIcon bomb = new ImageIcon(bombURL);

    public static URL fireURL = Data.class.getResource("statics/fire.png");
    public static ImageIcon fire = new ImageIcon(fireURL);

    public static URL destr01URL = Data.class.getResource("statics/destr01.png");
    public static ImageIcon destr01 = new ImageIcon(destr01URL);
}
