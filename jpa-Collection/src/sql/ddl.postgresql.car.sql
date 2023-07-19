CREATE TABLE dev.car (
                         id numeric NOT NULL,
                         "name" varchar(50) NULL,
                         company varchar(50) NOT NULL,
                         reg_dtm date NOT NULL,
                         int_val numeric NULL,
                         decimal_val numeric NULL,
                         curr varchar(10) NULL,
                         discount_int_val numeric NULL,
                         discount_decimal_val numeric NULL,
                         CONSTRAINT car_pk PRIMARY KEY (id)
);