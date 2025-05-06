package mylab.music.entity;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize;
    private int volume;

    public MP3(String title, String artist, String format, int fileSize) {
        super(title, artist, format);
        this.fileSize = fileSize;
        this.volume = 5; // �⺻ ����
    }

    public MP3(String title) {
        this(title, "Unknown", "MP3", 1);
    }

    @Override
    public void play() {
        super.play();
        System.out.println("���� ����: " + volume);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("���� ũ��: " + fileSize + "MB");
    }

    @Override
    public void setVolume(int level) {
        this.volume = level;
        System.out.println("������ " + level + "�� �����Ǿ����ϴ�.");
    }

    @Override
    public void stop() {
        System.out.println("MP3 ����� �����Ǿ����ϴ�.");
    }
}