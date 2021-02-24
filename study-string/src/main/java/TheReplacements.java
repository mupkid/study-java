import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {
	public static void main(String[] args) throws Exception {
		String s = "Here's a block of text to use as input to the regular expression matcher. "
				+ "Note that we'll first extract the block of text by looking for the special "
				+ "delimiters, then process the extracted block.";

		Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
		if (mInput.find()) {
			s = mInput.group(1);
		}
		s = s.replaceAll(" {2,}", " ");
		s = s.replaceAll("(?m)^ +", "");
		System.out.println(s);

	}
}
