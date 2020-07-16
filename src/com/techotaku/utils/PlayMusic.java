package com.techotaku.utils;

import com.techotaku.enums.Music;

import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Author：Yalexin
 * Email： 181303209@yzu.edu.cn
 */
public class PlayMusic {
    private ArrayList<String> files;
    private static PlayMusic PlayMusicInstance = new PlayMusic();

    private PlayMusic() {
        files = new ArrayList<String>();
        files.add("music/release.wav");
        files.add("music/bomb.wav");
        files.add("music/burns.wav");
        files.add("music/getProps.wav");
    }

    public static PlayMusic getInstance() {
        return PlayMusicInstance;
    }

    public void play(Music musicType) {
        try {
            int i = 0;
            if (musicType == Music.RELEASE){
                i = 0;
            } else if (musicType == Music.BOMB) {
                i = 1;
            } else if (musicType == Music.BURNS) {
                i = 2;
            } else if (musicType == Music.GET_PROPS) {
                i = 3;
            }
            byte[] buffer = new byte[1024 * 8];
            File file = new File(files.get(i));
            InputStream stream = new FileInputStream(file);
            InputStream bufferedIn = new BufferedInputStream(stream);

            AudioInputStream is = AudioSystem.getAudioInputStream(bufferedIn);
            AudioFormat format = is.getFormat();
            SourceDataLine line = AudioSystem.getSourceDataLine(format);
            line.open(format);
            line.start();
            while (is.available() > 0) {
                int len = is.read(buffer);
                line.write(buffer, 0, len);
            }
            line.drain();
            line.close();
        } catch (Exception e) {
            System.out.println("出错啦~~");
        }
    }
}