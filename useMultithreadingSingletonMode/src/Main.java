public class Main {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				SingleObject singleObject = SingleObject.getSingleObject();
				System.out.println(Thread.currentThread().getName() + "验证" + SingleObject.count);
			}).start();
			new Thread(() -> {
				SingleObject singleObject = SingleObject.getSingleObject();
				System.out.println(Thread.currentThread().getName() + "验证" + SingleObject.count);
			}).start();
		}
	}
}
