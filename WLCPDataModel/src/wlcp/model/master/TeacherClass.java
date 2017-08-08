package wlcp.model.master;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Teacher Class
 *
 */
@Entity
@Table(name = "TEACHER_CLASS")
public class TeacherClass implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEACHER_CLASS_ID")
	private Integer teacherClassId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "TEACHER_ID")
	private Teacher teacher;
	
	@Column(length = 40, name = "TEACHER_CLASS_NAME")
	private String teacherClassName;
	
	@Column(name = "GRADE")
	private Integer grade;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SCHOOL_ID", referencedColumnName = "SCHOOL_ID")
	private School school;
	
	@Column(name = "SCHOOL_YEAR_START")
	private Integer schoolYearStart;
	
	@Column(name = "SCHOOL_YEAR_END")
	private Integer schoolYearEnd;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "CLASS_STUDENTS", joinColumns = @JoinColumn(name = "TEACHER_CLASS_ID", referencedColumnName = "TEACHER_CLASS_ID"),
	inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID"))
	private List<Student> students = new ArrayList<Student>();
	
	public TeacherClass(Teacher teacher, String teacherClassName, Integer grade, School school, Integer schoolYearStart,
			Integer schoolYearEnd) {
		super();
		this.teacher = teacher;
		this.teacherClassName = teacherClassName;
		this.grade = grade;
		this.school = school;
		this.schoolYearStart = schoolYearStart;
		this.schoolYearEnd = schoolYearEnd;
	}
	
	public TeacherClass() {
		super();
	}

	public Integer getTeacherClassId() {
		return teacherClassId;
	}

	public void setTeacherClassId(Integer teacherClassId) {
		this.teacherClassId = teacherClassId;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getTeacherClassName() {
		return teacherClassName;
	}

	public void setTeacherClassName(String teacherClassName) {
		this.teacherClassName = teacherClassName;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Integer getSchoolYearStart() {
		return schoolYearStart;
	}

	public void setSchoolYearStart(Integer schoolYearStart) {
		this.schoolYearStart = schoolYearStart;
	}

	public Integer getSchoolYearEnd() {
		return schoolYearEnd;
	}

	public void setSchoolYearEnd(Integer schoolYearEnd) {
		this.schoolYearEnd = schoolYearEnd;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}