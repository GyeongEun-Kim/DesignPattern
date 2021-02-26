package spellCheckConverter;
import java.util.*;

public class WordProcessor {

	String filename;
	Map <String,DocConverter> docConverters=new HashMap <String,DocConverter>();
	ISpellChecker spellChecker;
	
	public WordProcessor (String filename) {
		this.filename=filename;
			} 
	
	public void addDocConverter (DocConverter converter) {
		docConverters.put(converter.getExtension(),converter);
		}
	
	public void convertDocTo (String ext) {
			//	System.out.println(docConverters.keySet());
				if ((docConverters.containsKey(ext)==true)) {
					DocConverter execute=docConverters.get(ext);
					execute.save(filename);
				}
				else
					System.out.println(ext+"���� ������ �����ϴ� DocConverter�� �����ϴ�");				
			}
		
	
	
	public void setSpellChecker (ISpellChecker spellChecker) {
		this.spellChecker=spellChecker;
	}
	
	public void checkSpelling () {
		spellChecker.check();
	}
	
	
	}


