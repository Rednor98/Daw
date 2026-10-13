package cat.institutmarianao.post.servlet.ejb.impl;

import cat.institutmarianao.post.servlet.ejb.PostBeanLocal;
import jakarta.ejb.Stateful;

/**
 * Stateful EJB that implements the PostBeanLocal interface. This bean is used
 * to store and manage user input data such as email, age, and message. It
 * provides getter and setter methods for these fields, allowing clients to
 * retrieve and update the values as needed.
 */
@Stateful
public class PostBean implements PostBeanLocal {

	private String email;
	private int age;
	private String message;

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(String age) {
		if (!"".equals(age)) {
			this.age = Integer.parseInt(age);
		} else {
			this.age = 0;
		}
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

}