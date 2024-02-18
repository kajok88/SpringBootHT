-- THIS IS THE MIGRATION FILE FOR MS SQL SERVER DATABASE
-- USED BY PROD PROFILE

-- Make sure to first create a database in MS SQL server, that is named accordingly to the datasource.url
-- in application-prod.properties


-- Users table to store user information
IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'users')
BEGIN
    CREATE TABLE users
    (
        user_id INT PRIMARY KEY IDENTITY(1,1),
        username VARCHAR(255) NOT NULL,
        password_hash VARCHAR(255) NOT NULL,
        user_role VARCHAR(255) NOT NULL,
        -- Add other user-related fields as needed
        CONSTRAINT unique_username UNIQUE (username)
    );
END

-- Categories table to store different event categories
IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'categories')
BEGIN
    CREATE TABLE categories
    (
        category_id INT PRIMARY KEY IDENTITY(1,1),
        user_id INT,
        category_name VARCHAR(255) NOT NULL,
        FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT unique_category UNIQUE (user_id, category_name)
    );
END

-- Events table to store diary entries and calendar events
IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'events')
BEGIN
    CREATE TABLE events
    (
        event_id INT PRIMARY KEY IDENTITY(1,1),
        user_id INT,
        event_title VARCHAR(255) NOT NULL,
        event_description TEXT,
        event_date DATE,
        event_time TIME,
        due_date DATE,
        FOREIGN KEY (user_id) REFERENCES users(user_id)
    );
END

-- Junction table to represent the many-to-many relationship between events and categories
IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'event_categories')
BEGIN
    CREATE TABLE event_categories
    (
        event_id INT,
        category_id INT,
        PRIMARY KEY (event_id, category_id),
        FOREIGN KEY (event_id) REFERENCES events(event_id),
        FOREIGN KEY (category_id) REFERENCES categories(category_id)
    );
END

-- Junction table to represent the many-to-many relationship between events and categories
IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'event_categories')
BEGIN
CREATE TABLE event_categories
(
    event_id INT,
    category_id INT,
    PRIMARY KEY (event_id, category_id),
    FOREIGN KEY (event_id) REFERENCES events(event_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);
END