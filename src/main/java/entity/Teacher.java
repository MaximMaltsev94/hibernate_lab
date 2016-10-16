package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "techer")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<TrainingCourse> trainingCourses;

    public void addTrainingCourse(TrainingCourse trainingCourse) {
        trainingCourse.setTeacher(this);
        trainingCourses.add(trainingCourse);
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Exam> exams;

    public void addExam(Exam exam) {
        exam.setTeacher(this);
        exams.add(exam);
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<ExamResult> examResults;

    public void addExamResult(ExamResult examResult) {
        examResult.setTeacher(this);
        examResults.add(examResult);
    }

    public Teacher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<TrainingCourse> getTrainingCourses() {
        return trainingCourses;
    }

    public void setTrainingCourses(Set<TrainingCourse> trainingCourses) {
        this.trainingCourses = trainingCourses;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    public Set<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(Set<ExamResult> examResults) {
        this.examResults = examResults;
    }
}
