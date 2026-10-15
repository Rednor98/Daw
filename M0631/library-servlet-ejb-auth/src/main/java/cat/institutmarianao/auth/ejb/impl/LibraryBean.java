package cat.institutmarianao.auth.ejb.impl;

import java.util.Random;

import cat.institutmarianao.auth.ejb.LibraryBeanLocal;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;

// The class is annotated with @DeclareRoles to declare the roles "librarian" and "user".
@DeclareRoles({ "librarian", "user" })
@Stateless
public class LibraryBean implements LibraryBeanLocal {

	// The catalog method is only accessible to users with the "librarian" role
	@RolesAllowed({ "librarian" })
	@Override
	public String catalog(String book) {
		// Generate a random ISBN for the book
		String isbn = generateRandomIsbn();
		return "isbn: " + isbn + ", title: " + book + ", author: John Doe";
	}

	// The checkAvailability method is accessible to all users
	@PermitAll
	@Override
	public boolean checkAvailability(String book) {
		// Only the book "java" is available
		return "java".equalsIgnoreCase(book);
	}

	// The borrow method is denied to all users
	@DenyAll
	@Override
	public boolean borrow(String book) {
		// No one is allowed to borrow books
		return false;
	}

	private String generateRandomIsbn() {
		Random random = new Random();
		return String.format("%03d-%03d-%03d-%01d", random.nextInt(1000), random.nextInt(1000), random.nextInt(1000),
				random.nextInt(10));
	}

}