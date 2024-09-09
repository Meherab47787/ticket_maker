CREATE TABLE IF NOT EXISTS airport (
    state_id INT PRIMARY KEY,
    state_name VARCHAR(255),
    state_short CHAR(3) CHECK (UPPER(state_short) = state_short),
    country VARCHAR(255) NOT NULL,
    station_name VARCHAR(255) NOT NULL UNIQUE
);