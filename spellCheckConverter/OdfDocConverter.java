package spellCheckConverter;

public class OdfDocConverter extends DocConverter {
	public OdfDocConverter() {
		super("odf");
		
	}
	
	public void save (String filename) {
		System.out.println(filename+".odf�� ��ȯ�ؼ� �����մϴ�.");
	}
}
