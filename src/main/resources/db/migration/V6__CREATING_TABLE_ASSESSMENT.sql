create table assessment(
    id bigint not null auto_increment,
    subject_class_id bigint not null,
    description varchar(60) not null,
    title varchar(30) not null,
    
    primary key(id)
);

ALTER TABLE grade
ADD COLUMN assessment_id bigint not null;




