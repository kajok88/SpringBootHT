-- Check if the value 'ROLE_USER' doesn't exist
IF NOT EXISTS (SELECT 1 FROM dbo.roles WHERE name = 'ROLE_USER')
BEGIN
INSERT INTO dbo.roles (name) VALUES ('ROLE_USER');
END;

-- Check if the value 'ROLE_ADMIN' doesn't exist
IF NOT EXISTS (SELECT 1 FROM dbo.roles WHERE name = 'ROLE_ADMIN')
BEGIN
INSERT INTO dbo.roles (name) VALUES ('ROLE_ADMIN');
END;