import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class JustTest {
	@Test
	public void min() {
		List<String> list=new ArrayList<>(3);
		list.add("a");
		list.add("b");
		list.add("c");
		String[] array=new String[5];
		list.toArray(array);
		StringBuilder stringBuilder=new StringBuilder();
		for (String str:array){
			System.out.println(str);
		}
	}
	public void con(String s,Integer d){

	}
	public void con( Integer s, String d){

	}
}

enum SeasonEnum {
	MO(1), ME(2), AUT(3), SDS(4);
	private int seq;

	SeasonEnum(int seq) {
		this.seq = seq;
	}

	public int getSeq() {
		return seq;
	}
}
 interface XC{

	  default int d(){
	 	return 3;
	 }
}