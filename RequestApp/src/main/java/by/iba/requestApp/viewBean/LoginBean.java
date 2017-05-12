package by.iba.requestApp.viewBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class LoginBean {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
	private int id;

	@Column(name="username")
	@NotEmpty(message = "Please enter your name")
    @Size(min = 3, max = 20, message = "Your name must be between 3 and 20 characters")
	private String username;
	
	@Column(name="password")
	@NotEmpty(message = "Please enter your password")
	@Size(min = 5, max = 20, message = "Your password must be between 5 and 20 characters.")
	private String password;
	
	@Column(name="role")
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
