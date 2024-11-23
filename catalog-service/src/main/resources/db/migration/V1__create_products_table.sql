CREATE TABLE products
(
    code TEXT NOT NULL UNIQUE,
    name TEXT NOT NULL,
    description TEXT,
    image_url TEXT,
    price NUMERIC NOT NULL
);