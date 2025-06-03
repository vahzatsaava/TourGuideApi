CREATE TABLE tour_image
(
    id      SERIAL PRIMARY KEY,
    url     TEXT   NOT NULL,
    tour_id BIGINT NOT NULL REFERENCES tour (id) ON DELETE CASCADE
);