List<String> localChecksums = new ArrayList<>();
List<String> migratedChecksums = new ArrayList<>();

for (Map<String, String> row : tableRows) {
    String rowString = row.toString();
    String checksum = computeChecksum(rowString); // MD5 or SHA-256 hash
    localChecksums.add(checksum);
}

// Compare the two lists of checksums
if (localChecksums.equals(migratedChecksums)) {
    System.out.println("Data matches!");
} else {
    System.out.println("Data mismatch found.");
}
