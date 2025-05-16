CREATE TABLE booking
(
    id      SERIAL PRIMARY KEY,
    tour_id BIGINT REFERENCES tour (id),
    date    DATE,
    email   VARCHAR(255),
    message VARCHAR(255)
);