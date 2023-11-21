create table grade(
    id bigint not null auto_increment,
    value bigint not null,
    student_id bigint not null,
    subject_class_id bigint not null,
    
    primary key(id)
);


