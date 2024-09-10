CREATE TABLE IF NOT EXISTS airport (
    airport_id INT PRIMARY KEY,
    state_name VARCHAR(255),
    state_short CHAR(3) CHECK (UPPER(state_short) = state_short),
    country VARCHAR(255) NOT NULL,
    station_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS ticket (
    ticketId INT PRIMARY KEY AUTO_INCREMENT,
    from_airport_id INT,
    to_airport_id INT,
    duration TIME,
    seat_number INT,
    departure TIMESTAMP,
    FOREIGN KEY (from_airport_id) REFERENCES airport(airport_id),
    FOREIGN KEY (to_airport_id) REFERENCES airport(airport_id),
    UNIQUE (ticketId, seat_number) -- ensures no duplicate seat numbers for the same ticketId
);


--this it my exsiting table now create a table called ticket which will contain "ticketId"(uniqie id rimary key), "from", "to", "duration" of flight(hour and minute), "seat_number"(upto 30 and no duplicates for each "ticketId"), "departure" (time and date), "from" and "to" should have a relation with the airport ticket