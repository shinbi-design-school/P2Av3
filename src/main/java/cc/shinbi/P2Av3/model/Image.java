package cc.shinbi.P2Av3.model;

import java.io.InputStream;

public class Image {
	private String fileName;
	private InputStream stream;

	public Image(String fileName, InputStream stream) {
		this.fileName = fileName;
		this.stream = stream;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}
}
