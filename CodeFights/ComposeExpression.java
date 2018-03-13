import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;

class ComposeExpression {
	public static void main(String args[]) {
		List<String> ans = new ComposeExpressionHelper().getCompositeExpressions(args[0], Integer.parseInt(args[1]));
		System.out.println(ans);
	}


}

class ComposeExpressionHelper {
	public List<String> getCompositeExpressions(String s, int target) {
		List<String> result = getCompositeExpressions(s, target, 1);
		Collections.sort(result);
		return result;
	}

	public List<String> getCompositeExpressions(String s, long target, long multiplier) {
		//Base case
		if((s.equals(Long.toString(target))) || (!s.startsWith("0") && (Long.parseLong(s) * multiplier == target))) {
			//System.out.println(String.format("s=%s target=%d multiplier=%d", s, target, multiplier));
			return Arrays.asList(s);
		}

		int n = s.length();
		List<String> result = new ArrayList<>();
		for(int i = 0; i < n-1; i++) {
			String currentNumStr = s.substring(0, i+1);
			long currentNum = Long.parseLong(currentNumStr);
			//CurrentNum appended by + operator
			List<String> subresult = getCompositeExpressions(s.substring(i+1), target - currentNum * multiplier, 1L);
			result.addAll(appendSubResult(currentNumStr, '+', subresult));

			//CurrentNum appended by - operator
			subresult = getCompositeExpressions(s.substring(i+1), currentNum * multiplier - target, 1L);
			result.addAll(appendSubResult(currentNumStr, '-', subresult));
			
			//CurrentNum appended by * operator
			subresult = getCompositeExpressions(s.substring(i+1), target, currentNum * multiplier);
			result.addAll(appendSubResult(currentNumStr, '*', subresult));
			
			if(s.startsWith("0")) {
				break;
			}
		}
		return result;

	}

	private List<String> appendSubResult(String currentNumStr, char operator, List<String> subResults) {
		return subResults.stream()
					.map(s -> {
						if(operator == '-') {
							return new StringBuffer(currentNumStr).append(operator).append(reverseOperators(s)).toString();
						
						} else {
							return new StringBuffer(currentNumStr).append(operator).append(s).toString();						
						}
					})
					.collect(Collectors.toList());
	}
	
	private String reverseOperators(String s) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch(ch) {
				case '+':
					sb.append('-');
					break;
				case '-':
					sb.append('+');
					break;
				default:
					sb.append(ch);
					break;
			}
		}
		return sb.toString();
	}

}
