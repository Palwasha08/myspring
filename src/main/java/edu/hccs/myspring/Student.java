package edu.hccs.myspring;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;

@Component
public class Student {
	    private int id;
		private String first_name;
		private String email;
		private String gender;
	    private List<Course> course;
	    
		public Student() {
			
		}
		
		 public Student(String first_name, String email, String gender, List<Course> course) {
		        super();
		        this.first_name = first_name;
		        this.email = email;
		        this.gender = gender;
		        this.course = course;
		    }
		 @Override
		    public boolean equals(Object o) {
		        if (this == o)
		            return true;
		        if (o == null || getClass() != o.getClass())
		            return false;
		        Student student = (Student) o;
		        return Objects.equals(first_name, student.first_name);
		    }
		  @Override
		    public int hashCode() {
		        return Objects.hash(first_name);
		    }

		    public List<Course> getCourse() {
		        return course;
		    }

		    public void setCourse(List<Course> course) {
		        this.course = course;
		    }

		    public String getFirst_name() {
		        return first_name;
		    }

		    public void setFirst_name(String first_name) {
		        this.first_name = first_name;
		    }

		    public String getEmail() {
		        return email;
		    }

		    public void setEmail(String email) {
		        this.email = email;
		    }

		    public String getGender() {
		        return gender;
		    }

		    public void setGender(String gender) {
		        this.gender = gender;
		    }

		    public int getId() {
		        return id;
		    }

		    public void setId(int id) {
		        this.id = id;
		    }

		    @Override
		    public String toString() {
		        return "Student{" +
		                "id=" + id +
		                ", first_name='" + first_name + '\'' +
		                ", email='" + email + '\'' +
		                ", gender='" + gender + '\'' +
		                ", course=" + course+
		                '}';
		    }
		}
		 
		 


