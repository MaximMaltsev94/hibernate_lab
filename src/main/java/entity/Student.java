package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20 )
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar birthDate;

    @Column(nullable = false)
    private Boolean sex;

    @Column(name = "hostel_live", nullable = true)
    private Boolean hostelLive;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<ExamResult> examResults;

    private void addExamResult(ExamResult examResult) {
        examResult.setStudent(this);
        examResults.add(examResult);
    }

    @OneToMany(mappedBy = "id.student", cascade = CascadeType.ALL)
    private Set<StudentResult> studentResults;

    public void addStudentResult(StudentResult studentResult) {
        studentResult.getId().setStudent(this);
        studentResults.add(studentResult);
    }

    public Student() {
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

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getHostelLive() {
        return hostelLive;
    }

    public void setHostelLive(Boolean hostelLive) {
        this.hostelLive = hostelLive;
    }

    public Set<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(Set<ExamResult> examResults) {
        this.examResults = examResults;
    }

    public Set<StudentResult> getStudentResults() {
        return studentResults;
    }

    public void setStudentResults(Set<StudentResult> studentResults) {
        this.studentResults = studentResults;
    }
}
