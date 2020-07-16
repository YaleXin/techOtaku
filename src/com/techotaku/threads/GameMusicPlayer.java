package com.techotaku.threads;

import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;

/**
 *Author: techOtaku
 */
//背景音乐
public class GameMusicPlayer extends Thread{
    private ArrayList<String> files;

    @Override
    public void run(){
        try {
            startMusic();
        } catch (UnsupportedAudioFileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public GameMusicPlayer(){
        files = new ArrayList<String>();
        files.add("music/bgm0.wav");
        files.add("music/bgm1.wav");
        files.add("music/bgm2.wav");
    }

    public void startMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        int i = 0;
        byte[] buffer = new byte[1024*8];
        while(true){
            File file = new File(files.get(i));
            InputStream stream = new FileInputStream(file);
            InputStream bufferedIn = new BufferedInputStream(stream);

            AudioInputStream is = AudioSystem.getAudioInputStream(bufferedIn);
            AudioFormat format = is.getFormat();
            SourceDataLine line = AudioSystem.getSourceDataLine(format);
            line.open(format);
            line.start();
            while(is.available() > 0){
                int len = is.read(buffer);
                line.write(buffer, 0, len);
            }
            line.drain();
            line.close();

            i++;
            i = i % 3;
        }
    }
}

