package spellCheckConverter;

public class DocxDocConverter extends DocConverter{
	public DocxDocConverter () {
		super("docx");
		
	} 
		
	public void save (String filename) {
		System.out.println(filename+".docx�� ��ȯ�ؼ� �����մϴ�.");
	}
	
}
