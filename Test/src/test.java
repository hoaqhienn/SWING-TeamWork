
import java.util.Random;
public class test {
	public static void main(String[] args) {
		Random rand = new Random();
		int int_random = rand.nextInt(900000)+100000;
		System.out.println(int_random);
	}
}
