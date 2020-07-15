package com.techotaku;



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

    // 蓝角色
    public static URL upURL = Data.class.getResource("statics/up.png");
    public static ImageIcon blueUp = new ImageIcon(upURL);

    public static URL downURL = Data.class.getResource("statics/down.png");
    public static ImageIcon blueDown = new ImageIcon(downURL);

    public static URL leftURL = Data.class.getResource("statics/left.png");
    public static ImageIcon blueLeft = new ImageIcon(leftURL);

    public static URL rightURL = Data.class.getResource("statics/right.png");
    public static ImageIcon blueRight = new ImageIcon(rightURL);

    // 红角色
    public static URL redUpURL = Data.class.getResource("statics/redUp.png");
    public static ImageIcon redUp = new ImageIcon(redUpURL);

    public static URL redDownURL = Data.class.getResource("statics/redDown.png");
    public static ImageIcon redDown = new ImageIcon(redDownURL);

    public static URL redLeftURL = Data.class.getResource("statics/redLeft.png");
    public static ImageIcon redLeft = new ImageIcon(redLeftURL);

    public static URL redRightURL = Data.class.getResource("statics/redRight.png");
    public static ImageIcon redRight = new ImageIcon(redRightURL);

    public static URL bombURL = Data.class.getResource("statics/bomb.png");
    public static ImageIcon bomb = new ImageIcon(bombURL);

    public static URL fireURL = Data.class.getResource("statics/fire.png");
    public static ImageIcon fire = new ImageIcon(fireURL);

    public static URL destr01URL = Data.class.getResource("statics/destr01.png");
    public static ImageIcon destr01 = new ImageIcon(destr01URL);

    public static URL bloodBottleUrl = Data.class.getResource("statics/bloodBottle.png");
    public static ImageIcon bloodBottle = new ImageIcon(bloodBottleUrl);

    public static URL shieldingUrl = Data.class.getResource("statics/shielding.png");
    public static ImageIcon shielding = new ImageIcon(shieldingUrl);
}
