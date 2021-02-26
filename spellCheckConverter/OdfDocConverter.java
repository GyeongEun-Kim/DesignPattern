package spellCheckConverter;

public class OdfDocConverter extends DocConverter {
	public OdfDocConverter() {
		super("odf");
		
	}
	
	public void save (String filename) {
		System.out.println(filename+".odf로 변환해서 저장합니다.");
	}
}
