CREATE TABLE CODE_GROUP
(
    id          bigint       NOT NULL auto_increment,
    name  varchar(200) NOT NULL UNIQUE ,
    description varchar(200) NOT NULL,
    use_yn      char(1)      NOT NULL DEFAULT 'Y',
    created_at  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    modified_at timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    primary key (id)
);

CREATE TABLE CODE (
    id	bigint	NOT NULL auto_increment,
    group_id	bigint	NOT NULL,
    name	varchar(200)	NOT NULL,
    description	varchar(200)	NOT NULL,
    use_yn	char(1)	NOT NULL	DEFAULT 'Y',
    created_at	timestamp	NOT NULL	DEFAULT CURRENT_TIMESTAMP(),
    modified_at	timestamp	NOT NULL	DEFAULT CURRENT_TIMESTAMP(),
    orders	integer,
    primary key (id, group_id, name)
);

CREATE TABLE EXTENSION_PROHIBIT_BASIC (
    id	bigint	NOT NULL auto_increment,
    code_name	varchar(200)	NOT NULL,
    created_at	timestamp	NOT NULL	DEFAULT CURRENT_TIMESTAMP(),
    primary key (id)
);

CREATE TABLE EXTENSION_PROHIBIT_CUSTOM (
     id	bigint	NOT NULL auto_increment,
     extension	varchar(200)	NOT NULL,
     created_at	timestamp	NOT NULL	DEFAULT CURRENT_TIMESTAMP(),
     orders integer NOT NULL ,
     primary key (id)
);

INSERT INTO CODE_GROUP(name, description) VALUES ('FILE_EXTENSION', '확장자유형');

INSERT INTO CODE (group_id,name,description,orders) VALUES (1,'BAT','bat', 1 );
INSERT INTO CODE (group_id,name,description,orders) VALUES (1,'CMD','cmd', 2 );
INSERT INTO CODE (group_id,name,description,orders) VALUES (1,'COM','com', 3 );
INSERT INTO CODE (group_id,name,description,orders) VALUES (1,'CPL','cpl', 4 );
INSERT INTO CODE (group_id,name,description,orders) VALUES (1,'EXE','exe', 5 );
INSERT INTO CODE (group_id,name,description,orders) VALUES (1,'SCR','scr', 6 );
INSERT INTO CODE (group_id,name,description,orders) VALUES (1,'JS','js', 7 );