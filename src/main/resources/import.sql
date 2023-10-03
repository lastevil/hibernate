DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price integer, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('First', 1), ('Second', 2), ('Third', 3),('Fourth',4),('Fifth',5);
