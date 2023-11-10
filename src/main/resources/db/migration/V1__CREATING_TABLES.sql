create table person(
    id bigint not null auto_increment,
    name varchar(100) not null,
    birth_date date not null,
    document_number varchar(20) not null,
    document_type varchar(20) not null,

    primary key(id)
);

create table student(
    id bigint not null auto_increment,
    person_id bigint not null,
    course_id bigint not null,

    primary key(id)
);

create table student_class(
    id bigint not null auto_increment,
    student_id bigint not null,
    subject_class_id bigint not null,

    primary key(id)
);

create table subject(
    id bigint not null auto_increment,
    name varchar(20) not null,
    description varchar(60) not null,

    primary key(id)
);

create table subject_class(
    id bigint not null auto_increment,
    teacher_id bigint not null,
    subject_id bigint not null,

    primary key(id)
);

create table teacher(
   id bigint not null auto_increment,
   person_id bigint not null,

   primary key(id)
);

create table course(
   id bigint not null auto_increment,
   name varchar (50) not null,
   description varchar(255) not null,
   acronym varchar(10) not null,

   primary key(id)
);

create table course_subject(
    subject_id bigint not null,
    course_id bigint not null,
    semester varchar (25) not null,

    primary key(subject_id, course_id)

);

