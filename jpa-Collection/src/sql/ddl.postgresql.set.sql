--user 테이블
CREATE TABLE dev."user" (
                            id numeric NOT NULL,
                            "name" varchar(20) NULL,
                            CONSTRAINT user_pk PRIMARY KEY (id)
);

--user_tel 테이블
CREATE TABLE dev.user_tel (
                              user_id numeric NOT NULL,
                              tel_no varchar(20) NULL,
                              CONSTRAINT user_tel_fk FOREIGN KEY (user_id) REFERENCES dev."user"(id)
);