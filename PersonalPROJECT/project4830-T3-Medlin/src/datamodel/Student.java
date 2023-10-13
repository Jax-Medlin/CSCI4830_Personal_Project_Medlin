package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE EmployeeMedlin (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,
  student_id VARCHAR(30) NOT NULL,
  email VARCHAR (30) NOT NULL,
  credit_hours INT NOT NULL,
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "Student")
public class Student {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "name")
   private String name;
   
   @Column(name = "student_id")
   private String student_id;
   
   @Column(name = "email")
   private String email;
   
   @Column(name = "credit_hours") // specify the column name. Without it, it will use method name
   private String credit_hours;


   public Student() {
   }

	public Student(Integer id, String name, String student_id, String email, String credit_hours) {
		this.id = id;
		this.name = name;
		this.student_id = student_id;
		this.email = email;
		this.credit_hours = credit_hours;
	}
	
	public Student(String name, String student_id, String email, String credit_hours) {
		this.name = name;
		this.student_id = student_id;
		this.email = email;
		this.credit_hours = credit_hours;
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
	
	public String getStudent_id() {
		return student_id;
	}
	
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCredit_hours() {
		return credit_hours;
	}
	
	public void setCredit_hours(String credit_hours) {
		this.credit_hours = credit_hours;
	}

@Override
   public String toString() {
      return "Student: " + this.name + ", " + this.student_id 
    		  + ", " + this.email + ", " + this.credit_hours;
   }
}