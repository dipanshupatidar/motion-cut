package starter.redirect;


public class Base10 {


	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int base = ALPHABET.length();

	public static long reverseUrl(String reverse)
	{
		long reverseUrlId= convertTobase10(reverse);
		return reverseUrlId;

	}

	private static long convertTobase10(String reverse) {
		long nBase10 = 0;
		char [] chars = new StringBuilder(reverse).reverse().toString().toCharArray();

		for(int i=chars.length -1 ; i >= 0; i--)
		{
			int index=ALPHABET.indexOf(chars[i]);
			nBase10 += index * (long)Math.pow(base, i);
		}
		return nBase10;
	}

}
