CREATE TABLE products (
    id_product UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    count INTEGER NOT NULL,
    date_time_last_change TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);