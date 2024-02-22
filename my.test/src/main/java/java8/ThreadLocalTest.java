package java8;

public class ThreadLocalTest {
	public static void main(String[] args) {
		ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 5);
		Integer result = threadLocal.get();
		System.out.println(result);
	}
}
