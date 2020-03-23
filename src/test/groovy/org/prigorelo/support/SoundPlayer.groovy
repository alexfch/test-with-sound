package org.prigorelo.support

import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip

class SoundPlayer {
    public static void playSound(final String soundType) {
        def theme = System.getProperty("prigorelo.theme")
        def path = "./src/test/resources/themes/${theme}/sounds/${soundType}/"
        def files = new File(path).listFiles()*.getName()
        def index = new Random().nextInt(files.size())

        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            new File(path + files[index]).getAbsoluteFile());
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start()
    }
}
