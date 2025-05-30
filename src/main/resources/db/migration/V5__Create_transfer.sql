CREATE TABLE transfers
(
    id               SERIAL PRIMARY KEY,
    email            VARCHAR(255) NOT NULL,
    message          VARCHAR(255) NOT NULL,
    date             TIMESTAMP    NOT NULL,
    from_airport     varchar(50)      NOT NULL,
    destination_city VARCHAR(50)  NOT NULL,
    passenger_count  INT          NOT NULL,
    return_trip      BOOLEAN DEFAULT FALSE
);
