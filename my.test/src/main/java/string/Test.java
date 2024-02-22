package string;

public class Test {
	public static void main(String[] args) {
		String y = "tttt";
		String x = "tttt";
		final String z = x + y;
		final String d = x + y;

		java.lang.System.out.println(x.equals(y));
		java.lang.System.out.println(x == y);
		java.lang.System.out.println(z.equals(d));
		java.lang.System.out.println(z == d);

	}
	
	{
		final String y = "tttt";
		final String x = "tttt";	
		final String z = x + y;
		final String d = x + y;

		java.lang.System.out.println(x.equals(y));
		java.lang.System.out.println(x == y);
		java.lang.System.out.println(z.equals(d));
		java.lang.System.out.println(z == d);

	}
}
