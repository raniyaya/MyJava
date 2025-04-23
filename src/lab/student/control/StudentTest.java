package lab.student.control;

import lab.student.entity.Student;

public class StudentTest {
    public static void main(String[] args) {
        // 학생 객체 생성
        Student student = new Student("20230101", "김민수", "컴퓨터공학", 3);

        // 학생 정보 출력
        System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");

        // 학년 변경 → 유효하지 않은 값
        student.setGrade(5);
    }
}
