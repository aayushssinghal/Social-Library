create table book (
    accno   numeric(8, 0),
    title   varchar(30),
    author  varchar(30),
    publication     varchar(40),
    edition numeric(3,0),
    volume  numeric(3,0),
    yyyy    numeric(4,0),
    pages   numeric(5,0),
    subject varchar(30),
    ddc     varchar(30),
    sears   varchar(30)
);


insert into book values(1, 'Concepts of Physics', 'H. C. Verma', 'bharti bhawan', 1, 1, 1992, 280, 'Physics', '', '');

select * from book;
