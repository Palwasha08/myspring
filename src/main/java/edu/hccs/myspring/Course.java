package edu.hccs.myspring;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Course {
	private String courseNo;
	private String grade;
	private int creditHours;

	public Course() {
	}

	public Course(String courseNo, String grade, int creditHours) {
		super();
		this.courseNo = courseNo;
		this.grade = grade;
		this.creditHours = creditHours;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Course course = (Course) o;
		return courseNo.equals(course.courseNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseNo);
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	@Override
	public String toString() {
		return "Course{" + "courseNo='" + courseNo + '\'' + ", grade='" + grade + '\'' + ", creditHours=" + creditHours
				+ '}';
	}
}
