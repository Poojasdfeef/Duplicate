import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class DataVerification {

    public static String computeChecksum(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static boolean verifyData(List<Map<String, String>> localData, List<Map<String, String>> migratedData) throws NoSuchAlgorithmException {
        for (int i = 0; i < localData.size(); i++) {
            String localChecksum = computeChecksum(localData.get(i).toString());
            String migratedChecksum = computeChecksum(migratedData.get(i).toString());
            if (!localChecksum.equals(migratedChecksum)) {
                System.out.println("Mismatch found in row: " + i);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Example usage (populate localData and migratedData with actual data)
        List<Map<String, String>> localData = getDataFromLocalDatabase();
        List<Map<String, String>> migratedData = getDataFromMigratedDatabase();
        
        if (verifyData(localData, migratedData)) {
            System.out.println("Data matches between local and migrated databases.");
        } else {
            System.out.println("Data mismatch detected.");
        }
    }

    // Placeholder methods for data retrieval
    public static List<Map<String, String>> getDataFromLocalDatabase() {
        // Logic to retrieve data from the local database
        return null;
    }

    public static List<Map<String, String>> getDataFromMigratedDatabase() {
        // Logic to retrieve data from the migrated database
        return null;
    }
}
