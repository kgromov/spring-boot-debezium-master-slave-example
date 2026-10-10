CREATE TABLE Customer
(
    CustomerID   SERIAL PRIMARY KEY,
    CustomerName VARCHAR(255),
    City         VARCHAR(255),
    Country      VARCHAR(255)
);

ALTER TABLE Customer
    REPLICA IDENTITY FULL;

INSERT INTO Customer (CustomerName, City, Country)
VALUES ('Cardinal', 'Stavanger', 'Norway');