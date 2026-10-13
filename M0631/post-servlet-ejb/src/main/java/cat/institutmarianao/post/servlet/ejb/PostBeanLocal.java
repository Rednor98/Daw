package cat.institutmarianao.post.servlet.ejb;

import jakarta.ejb.Local;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Local interface for the PostBean EJB. This interface defines the methods that
 * can be called by clients to interact with the PostBean. It includes methods
 * for getting and setting the email, age, and message fields, along with
 * validation constraints to ensure that the data meets certain criteria.
 */
@Local
public interface PostBeanLocal {
	@NotBlank(message = "<b>Email:</b> The e-mail cannot be blank")
	@Email(message = "<b>Email:</b> The e-mail is not valid")
	String getEmail();

	void setEmail(String email);

	@Min(value = 18, message = "<b>Age:</b> You must be older than 18 to write a message")
	@Max(value = 120, message = "<b>Age:</b> The maximum age is 120")
	int getAge();

	void setAge(String age);

	@NotBlank(message = "<b>Message:</b> The message cannot be blank")
	@Size(max = 150, message = "<b>Message:</b> The message must have at most 150 characters")
	String getMessage();

	void setMessage(String message);

}
