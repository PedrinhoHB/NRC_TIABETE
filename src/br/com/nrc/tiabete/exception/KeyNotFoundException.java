package br.com.nrc.tiabete.exception;

@SuppressWarnings("serial")
public class KeyNotFoundException extends Exception {

	public KeyNotFoundException() {
		super();
	}

	public KeyNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public KeyNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public KeyNotFoundException(String arg0) {
		super(arg0);
	}

	public KeyNotFoundException(Throwable arg0) {
		super(arg0);
	}
}