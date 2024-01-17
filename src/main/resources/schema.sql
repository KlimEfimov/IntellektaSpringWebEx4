DROP TABLE if exists sales;

CREATE TABLE IF NOT EXISTS sales (
                                     id bigint AUTO_INCREMENT PRIMARY KEY,
                                     product_id CHAR(4),
                                     store_date date,
                                     sales_date date,
                                     price float
);

INSERT INTO sales (product_id, store_date, sales_date, price) VALUES ('1111', '2023-01-01', '2023-02-01', 1.1);
INSERT INTO sales (product_id, store_date, sales_date, price) VALUES ('2222', '2023-01-02', '2023-02-02', 2.2);
INSERT INTO sales (product_id, store_date, sales_date, price) VALUES ('3333', '2023-01-03', '2023-02-03', 3.3);
INSERT INTO sales (product_id, store_date, sales_date, price) VALUES ('4444', '2023-01-04', '2023-02-04', 4.4);
INSERT INTO sales (product_id, store_date, sales_date, price) VALUES ('6666', '2023-01-05', '2023-02-05', 5.5);
INSERT INTO sales (product_id, store_date, sales_date, price) VALUES ('7777', '2023-01-05', '2023-02-05', 107.7);
INSERT INTO sales (product_id, store_date, sales_date, price) VALUES ('8888', '2023-01-05', '2023-02-05', 108.8);