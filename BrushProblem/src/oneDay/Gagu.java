package oneDay;

public class Gagu {
	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(answer);
	}

	static float answer;

	public static float solution(int n) {
		if (n == 1) return answer += 1;
		float temp;
		if (n % 2 == 0) {
			temp = (n * solution(--n));
			answer -= (1 / temp);
			return temp;
		} else {

			temp = (n * solution(--n));
			answer += 1 / temp;
			return temp;
		}
	}
}
