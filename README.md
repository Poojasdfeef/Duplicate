# Duplicate
To ensure that the data copied from a locally hosted database to AWS or GCP is identical to the original data, several verification steps can be performed. The data in the tables is assumed to be in the form List<Map<String, String>>, which is a common structure for representing tabular data in a collection of rows (list) where each row is a map of column names (keys) to their values (strings).

Steps to Verify Data Consistency
1. Row Count Check:
Description: First, check if the number of rows in each table of the original database matches the number of rows in the copied database.
Implementation: Run a query like SELECT COUNT(*) FROM table_name on both databases and compare the results.

2. Checksum or Hash-Based Verification:
Description: Generate checksums or hash values for each table or each row to ensure that the content is identical. This is a more comprehensive check than just counting rows.
Implementation: Use a checksum or hash function (like MD5 or SHA-256) to generate a hash of the entire table's contents. Compare the hash values of the original and migrated databases.

3. Column-Wise Data Comparison:
Description: Check if each column's data is identical between the original and the migrated databases. This can be done by comparing a sample of rows or specific columns.
Implementation: Write SQL queries to extract specific columns and compare them between the two databases.

4. Primary Key or Unique Identifier Check:
Description: If each row has a unique identifier (like a primary key), compare the corresponding rows by their primary keys.
Implementation: Extract rows by their primary key from both databases and compare them.

5. Data Type and Schema Validation:
Description: Ensure that the schema (table definitions, column types, etc.) is identical between the original and migrated databases.
Implementation: Compare the schema definitions from both databases. This can be done using database tools or querying metadata tables.

6. Automated Data Validation Tools:
Description: Use specialized tools or scripts to automate the data comparison process. Tools like AWS Database Migration Service (DMS) include data validation features.
Implementation: Set up data validation rules and automate the comparison process using these tools.

Summary
Row Count Check: Quick verification that row counts match.
Checksum/Hash Comparison: More in-depth check using hash functions for accuracy.
Column-Wise and Primary Key Comparison: Ensures data integrity at a more granular level.
Schema Validation: Confirms that table structures are consistent.
Automated Tools: Use available tools for a comprehensive and automated approach.
