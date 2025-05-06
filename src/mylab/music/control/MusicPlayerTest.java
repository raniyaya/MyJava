package mylab.music.control;

import mylab.music.entity.*;

public class MusicPlayerTest {
    public static void main(String[] args) {
        System.out.println("===== ���� ��� �ý��� �׽�Ʈ =====\n");

        System.out.println("--- MP3 �׽�Ʈ ---");
        MP3 mp3 = new MP3("Dynamite", "BTS", "MP3", 5);
        mp3.displayInfo();
        mp3.play();
        mp3.setVolume(8);
        mp3.play();
        mp3.stop();

        System.out.println("\n--- Vinyl �׽�Ʈ ---");
        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        vinyl.displayInfo();
        vinyl.play();
        vinyl.clean();

        System.out.println("\n--- ������ �׽�Ʈ ---");
        MusicMedia media = new MP3("Butter", "BTS", "MP3", 4);
        media.displayInfo();
        media.play();

        System.out.println("\n--- ĳ���� �׽�Ʈ ---");
        if (media instanceof Playable) {
            Playable p = (Playable) media;
            p.setVolume(3);
            media.play();
            p.setVolume(7);
            p.stop();
        }
    }
}
