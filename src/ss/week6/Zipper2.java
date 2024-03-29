package ss.week6;

//import ss.week3.bill.SysoutPrinter;

public class Zipper2 {
	
	/*@
    requires s1 != null & s2 != null;
    requires s1.length() == s2.length();
  */
    public static String zip2(String s1, String s2) throws TooFewArgumentsException, ArgumentLengthsDifferException {
	 
	    if (s1 == null || s2 == null) {
		    throw new TooFewArgumentsException();
	    } else if (s1.length() != s2.length()) {
		 throw new ArgumentLengthsDifferException(s1, s2);
	 }else {
     String result = "";
     for (int i = 0; i < s1.length(); i++) {
         result += Character.toString(s1.charAt(i))
                   + Character.toString(s2.charAt(i));
     }
     return result;
	 }
 }
 

 public static void main(String[] args) {
     String s1 = args.length >= 1 ? args[0] : null;
     String s2 = args.length >= 2 ? args[1] : null;
     try {
    	 System.out.println(zip2(s1,s2));
     }catch (Exception e) {
    	 System.out.println(e.getMessage());
     }
 }

}
