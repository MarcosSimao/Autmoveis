package model.exceptios;

public class DbException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DbException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DbException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DbException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
