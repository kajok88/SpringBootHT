-- Check if the value 'ROLE_USER' doesn't exist
MERGE INTO roles AS target
    USING (SELECT 'ROLE_USER' AS name) AS source
    ON target.name = source.name
    WHEN NOT MATCHED THEN
        INSERT (name) VALUES (source.name);

-- Check if the value 'ROLE_ADMIN' doesn't exist
MERGE INTO roles AS target
    USING (SELECT 'ROLE_ADMIN' AS name) AS source
    ON target.name = source.name
    WHEN NOT MATCHED THEN
        INSERT (name) VALUES (source.name);