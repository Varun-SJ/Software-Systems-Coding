package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryAttack {
	private Map<String, String> passwordMap = new HashMap<String, String>();
	private Map<String, String> hashDictionary = new HashMap<String, String>();
	
	private static final String PATH = "D:\\$SSHOME\\Eclipse Workspace\\Software_Systems\\src\\ss\\week6\\test\\";

	/**
	 * Reads a password file. Each line of the password file has the following form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be filled
	 * with the content of the file. The key for the map should be the username and
	 * the password hash should be the content.
	 * 
	 * @param filename
	 */
	public void readPasswords(String filename) {
		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)));
			while (scan.hasNextLine()) {
				String[] parts = scan.nextLine().split(": ");
				passwordMap.put(parts[0], parts[1]);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting hash (or
	 * sometimes called digest) should be hex-encoded in a String.
	 * 
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return byteArrayToHex(md.digest(password.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	/**
	 * Converts an array of bytes to a hexadecimal encoded string
	 * 
	 * @param a
	 * @return
	 */
	public static String byteArrayToHex(byte[] input) {
		StringBuilder sb = new StringBuilder(input.length * 2);
		for (byte b : input) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	/**
	 * Check the password for the user the password list. If the user does not
	 * exist, return false.
	 * 
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		return ((passwordMap.get(user).equals(getPasswordHash(password))) && getPasswordHash(password) != null);
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add entries to
	 * a dictionary that maps password hashes (hex-encoded) to the original
	 * password.
	 * 
	 * @param filename filename of the dictionary.
	 */
	public void addToHashDictionary(String filename) {
		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)));
			while (scan.hasNextLine()) {
				String plain = scan.nextLine();
				hashDictionary.put(getPasswordHash(plain), plain);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		int i = 0;
		for (String user : passwordMap.keySet()) {
			String plain = hashDictionary.get(passwordMap.get(user));
			if (plain != null) {
				System.out.println(user + " " + plain);
				i++;
			}
		}
		System.out.println("Progress: " + i + "/" + passwordMap.size());
	}

	public void dumpMap() {
		for (String i : passwordMap.keySet()) {
			System.out.println(i + " " + passwordMap.get(i));
		}
		System.out.println("Passwordmap");
	}

	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		da.readPasswords(PATH + "LeakedPasswords.txt");
		da.addToHashDictionary(PATH + "john.txt");
		da.checkPassword("katrine", "spongebob");
		da.doDictionaryAttack();
	}

}