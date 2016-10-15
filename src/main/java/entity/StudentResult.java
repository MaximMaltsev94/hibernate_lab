package entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "student_result")
public class StudentResult {

    @EmbeddedId
    private StudentResultKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", referencedColumnName = "id", nullable = true)
    private Exam exam;

    @Column(nullable = false)
    private Integer result;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar date;

    @Column(nullable = true, length = 50)
    private String note;

    public StudentResult() {
    }

    public StudentResultKey getId() {
        return id;
    }

    public void setId(StudentResultKey id) {
        this.id = id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
