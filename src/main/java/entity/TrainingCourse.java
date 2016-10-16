package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "training_course")
public class TrainingCourse implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "teacher_fk"), referencedColumnName = "id", name = "teacher_id", nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "trainingCourse", cascade = CascadeType.ALL)
    private Set<Exam> exams;

    public void addExam(Exam exam) {
        exam.setTrainingCourse(this);
        exams.add(exam);
    }

    @OneToMany(mappedBy = "id.trainingCourse", cascade = CascadeType.ALL)
    private Set<StudentResult> studentResults;

    public void addStudentResult(StudentResult studentResult) {
        studentResult.getId().setTrainingCourse(this);
        studentResults.add(studentResult);
    }

    public TrainingCourse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    public Set<StudentResult> getStudentResults() {
        return studentResults;
    }

    public void setStudentResults(Set<StudentResult> studentResults) {
        this.studentResults = studentResults;
    }
}
