package cat.institutmarianao.auth.ejb;

public interface LibraryBeanLocal {
	/**
	 * Returns a string with the catalog of books available in the library.
	 *
	 * @param book The title of the book to search for in the catalog.
	 * @return A string representing the catalog of books.
	 */
	String catalog(String book);

	/**
	 * Checks if a specific book is available in the library.
	 *
	 * @param book The title of the book to check for availability.
	 * @return true if the book is available, false otherwise.
	 */
	boolean checkAvailability(String book);

	/**
	 * Borrows a specific book from the library.
	 *
	 * @param book The title of the book to borrow.
	 * @return true if the book was successfully borrowed, false otherwise.
	 */
	boolean borrow(String book);
}