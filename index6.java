for (Map<String, String> row : localData) {
    String primaryKey = row.get("primaryKeyColumn");
    Map<String, String> migratedRow = findRowByPrimaryKey(migratedData, primaryKey);
    if (!row.equals(migratedRow)) {
        System.out.println("Mismatch found for primary key: " + primaryKey);
    }
}

