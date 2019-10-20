insert into room (id, name, capacity, description) values (1, 'Sala 1', 130, '10 rzedow po 13 miejsc');
insert into room (id, name, capacity, description) values (2, 'Sala 2', 121, '11 rzedow po 11 miejsc');
insert into room (id, name, capacity, description) values (3, 'Sala 3', 150, '10 rzedow po 15 miejsc');
insert into room (id, name, capacity, description) values (4, 'Sala 4', 144, '12 rzedow po 12 miejsc');


insert into movie (id, title, category, length, description, required_Age) values (5, 'After', 'ROMANTIC', 106,'Ekranizacja bestsellera', 16);
insert into movie (id, title, category, length, description, required_Age) values (6, 'Avengers', 'ACTION', 182,'Ekranizacja bestsellera', 16);
insert into movie (id, title, category, length, description, required_Age) values (7, 'Green Book', 'COMEDY', 116,'Ekranizacja bestsellera', 16);
insert into movie (id, title, category, length, description, required_Age) values (8, 'Hellboy gry', 'HORROR', 186,'Ekranizacja bestsellera', 16);
insert into movie (id, title, category, length, description, required_Age) values (9, 'Przemytnik', 'ROMANTIC', 106,'Ekranizacja bestsellera', 16);
insert into movie (id, title, category, length, description, required_Age) values (10, 'Niedobrani', 'ROMANTIC', 106,'Ekranizacja bestsellera', 16);
insert into movie (id, title, category, length, description, required_Age) values (11, 'After 2', 'ROMANTIC', 106,'Ekranizacja bestsellera', 16);


insert into poster (id, movie_id, file_path) values (12, 8, '/images/poster1.png');
insert into poster (id, movie_id, file_path) values (13, 9, '/images/poster2.png');
insert into poster (id, movie_id, file_path) values (14, 10, '/images/poster3.png');

insert into session(id, movie_id, room_id, start_time) values (15,8,2, TIMESTAMP '2019-05-21 12:00:00');
insert into session(id, movie_id, room_id, start_time) values (16,8,1, TIMESTAMP '2019-05-22 12:00:00');
insert into session(id, movie_id, room_id, start_time) values (17,10,3, TIMESTAMP '2019-05-23 12:00:00');

insert into ticket (id, session_id, seat, price) values (18,15,'r10m3', 21.00);
insert into ticket (id, session_id, seat, price) values (19,15,'r11m3', 21.00);
insert into ticket (id, session_id, seat, price) values (20,15,'r10m2', 18.00);
insert into ticket (id, session_id, seat, price) values (21,15,'r07m3', 18.00);

select setval('public.hibernate_sequence', 21, true);
