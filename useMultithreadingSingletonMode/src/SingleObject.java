public class SingleObject {
	private SingleObject() {
	}

	private volatile static SingleObject singleObject = null;
	public static int count = 0;

	public static SingleObject getSingleObject() {
		if (singleObject == null) {
			synchronized (SingleObject.class) {
				if (singleObject == null) {
					singleObject = new SingleObject();
					count++;
				}
			}
		}
		return singleObject;
	}
}
