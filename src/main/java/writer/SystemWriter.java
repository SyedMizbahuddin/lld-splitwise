package writer;

public class SystemWriter implements OutputWriter {

	@Override
	public void printNewLine(String s) {
		System.out.println(s);
	}

}
