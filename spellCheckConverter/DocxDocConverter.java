package spellCheckConverter;

public class DocxDocConverter extends DocConverter{
	public DocxDocConverter () {
		super("docx");
		
	} 
		
	public void save (String filename) {
		System.out.println(filename+".docx로 변환해서 저장합니다.");
	}
	
}
