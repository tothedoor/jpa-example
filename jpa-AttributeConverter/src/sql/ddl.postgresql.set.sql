--사용자 테이블
CREATE TABLE dev."user" (
    id numeric NOT NULL DEFAULT nextval('dev.id_seq'::regclass),
    "name" varchar(10) NULL,
    use_yn varchar(1) NOT NULL,
    dprt_cd varchar(5) NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

--공통코드 테이블
CREATE TABLE dev.com_cd (
    grp_cd varchar(5) NOT NULL,
    com_cd varchar(5) NOT NULL,
    com_nm varchar(10) NULL,
    CONSTRAINT code_info_pk PRIMARY KEY (grp_cd, com_cd)
);