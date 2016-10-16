package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exam_result")
public class ExamResult implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "exam_result_teacher_fk"), referencedColumnName = "id", name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "exam_result_student_fk"), referencedColumnName = "id", name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Integer result;

    @Column(nullable = true, length = 50)
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "exam_result_exam_fk"), referencedColumnName = "id", name = "exam_id", nullable = false)
    private Exam exam;

    public ExamResult() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
