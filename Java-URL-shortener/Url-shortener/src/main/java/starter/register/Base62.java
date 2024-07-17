package starter.register;

public class Base62 {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE62 = ALPHABET.length();
   
    public static String toBase62(long number) 
    {
        final StringBuilder sb = new StringBuilder(1);
        	do 
        	{
        		sb.insert(0, ALPHABET.charAt((int) (number % BASE62)));
        		number /= BASE62;
        	} while (number > 0);
        
        return sb.toString();

    }
}