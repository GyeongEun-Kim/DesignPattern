package spellCheckConverter;

public class PdfDocConverter extends DocConverter{
	public PdfDocConverter() {
		super("pdf");
	}
	public void save (String filename) {
		System.out.println(filename+".pdf�� ��ȯ�ؼ� �����մϴ�.");
	}
}
