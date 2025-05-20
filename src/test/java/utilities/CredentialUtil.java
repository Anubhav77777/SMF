package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CredentialUtil {

	
	
		    private static final File tempFile;

	    static {
	        try {
	            tempFile = File.createTempFile("userCreds", ".txt");
	            tempFile.deleteOnExit(); // Auto-delete on JVM exit
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to create temp file", e);
	        }
	    }

	    public static void saveCredentials(String username, String password) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
	            writer.write("username=" + username);
	            writer.newLine();
	            writer.write("password=" + password);
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to write credentials to temp file", e);
	        }
	    }

	    public static Map<String, String> loadCredentials() {
	        Map<String, String> credentials = new HashMap<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split("=");
	                if (parts.length == 2) {
	                    credentials.put(parts[0], parts[1]);
	                }
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to read credentials from temp file", e);
	        }
	        return credentials;
	    }
	}

	
	
	
	

