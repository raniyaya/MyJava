package lab.student.control;

import lab.student.entity.Student;

public class StudentTest {
    public static void main(String[] args) {
        // �л� ��ü ����
        Student student = new Student("20230101", "��μ�", "��ǻ�Ͱ���", 3);

        // �л� ���� ���
        System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "�г�");

        // �г� ���� �� ��ȿ���� ���� ��
        student.setGrade(5);
    }
}
