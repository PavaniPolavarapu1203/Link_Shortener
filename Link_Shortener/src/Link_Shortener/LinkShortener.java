package Link_Shortener;
import java.util.*;
public class LinkShortener {
	    private Map<String, String> shortToLongMap;
	    private Map<String, String> longToShortMap;
	    public LinkShortener() {
	        shortToLongMap = new HashMap<>();
	        longToShortMap = new HashMap<>();
	    }
	    private String generateShortURL() {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder shortURL = new StringBuilder();
	        Random rand = new Random();
	        for (int i = 0; i < 6; i++) {
	            shortURL.append(characters.charAt(rand.nextInt(characters.length())));
	        }
	        return shortURL.toString();
	    }
	    public String shortenURL(String longURL) {
	        if (longToShortMap.containsKey(longURL)) {
	            return longToShortMap.get(longURL);
	        }
	        String shortURL = generateShortURL();
	        while (shortToLongMap.containsKey(shortURL)) {
	            shortURL = generateShortURL();
	        }
	        shortToLongMap.put(shortURL, longURL);
	        longToShortMap.put(longURL, shortURL);
	        return shortURL;
	    }
	    public String expandURL(String shortURL) {
	        if (!shortToLongMap.containsKey(shortURL)) {
	            return "Short URL not found.";
	        }
	        return shortToLongMap.get(shortURL);
	    }
	    public static void main(String[] args) {
	        LinkShortener linkShortener = new LinkShortener();
	        String longURL = "https://github.com/PavaniPolavarapu1203/Expense-Tracker";
	        String shortURL = linkShortener.shortenURL(longURL);
	        System.out.println("Shortened URL: " + shortURL);
	        String expandedURL = linkShortener.expandURL(shortURL);
	        System.out.println("Expanded URL: " + expandedURL);
	    }
	}
