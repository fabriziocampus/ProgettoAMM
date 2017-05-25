// USERNAME: fabrizio
// PASSWORD: fabrizio


CREATE TABLE PostType (
    PostType_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    PostType_name VARCHAR(32)
);

CREATE TABLE UtenteRegistrato(
	UtenteRegistrato_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	UtenteRegistrato_name VARCHAR(32),
	UtenteRegistrato_surname VARCHAR(32),
	UrlImg VARCHAR(256),
	Date VARCHAR(16),
	Frase VARCHAR(1024),
	Email VARCHAR(64),
	Password VARCHAR(32),
	ConfermaPsw VARCHAR(32)
);

CREATE TABLE Post(
	Post_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	Contenuto VARCHAR(1024),
	Type INTEGER,
	FOREIGN KEY (Type) REFERENCES PostType(PostType_id),
	Author INTEGER,
	FOREIGN KEY (author) REFERENCES UtenteRegistrato(UtenteRegistrato_id),
	Gruppo INTEGER,
	FOREIGN KEY (Gruppo) REFERENCES Gruppo(Gruppo_id)
);

CREATE TABLE Gruppo(
	Gruppo_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	Gruppo_name VARCHAR(64),
	Immagine VARCHAR(64)
);

CREATE TABLE Membro(
	Id_Gruppo INTEGER,
	FOREIGN KEY (Id_Gruppo) REFERENCES Gruppo(Gruppo_id),
	Id_Membro INTEGER,
	FOREIGN KEY (Id_membro) REFERENCES UtenteRegistrato(UtenteRegistrato_id),
	PRIMARY KEY (Id_Gruppo, Id_membro)
);

CREATE TABLE Amici(
	Follower INTEGER,
	FOREIGN KEY (Follower) REFERENCES UtenteRegistrato(UtenteRegistrato_id),
	Followed INTEGER,
	FOREIGN KEY (Followed) REFERENCES UtenteRegistrato(UtenteRegistrato_id),
	 PRIMARY KEY (follower, followed)
);


insert into UtenteRegistrato(UtenteRegistrato_id, UtenteRegistrato_name, UtenteRegistrato_surname, UrlImg, Date, Frase, Email, Password, ConfermaPsw)
VALUES (default, 'Simone', 'Padoin', 'prof.jpeg', '18/09/1980', 'Chi la f� la spesa', 'SP20@email.com', 'ciaociao', 'ciaociao');

insert into UtenteRegistrato(UtenteRegistrato_id, UtenteRegistrato_name, UtenteRegistrato_surname, UrlImg, Date, Frase, Email, Password, ConfermaPsw)
VALUES (default, 'Ezequiel', 'Schelotto', 'prof.png', '23/10/1984', 'Tanto va la gatta al lardo che se lo mangia', 'ES14@email.com', 'schelotto', 'schelotto');

insert into UtenteRegistrato(UtenteRegistrato_id, UtenteRegistrato_name, UtenteRegistrato_surname, UrlImg, Date, Frase, Email, Password, ConfermaPsw)
VALUES (default, 'Ronaldo', 'De Assis Moreira Ronaldinho', 'prof.jpg', '29-04-1978', 'Tutturuturututtu', 'RR10@email.com', 'pallone', 'pallone');

INSERT INTO PostType (PostType_id, PostType_name)
VALUES (default, 'TEXT');

INSERT INTO PostType (PostType_id, PostType_name)
VALUES (default, 'IMAGE');

INSERT INTO PostType (PostType_id, PostType_name)
VALUES (default, 'LINK');

INSERT INTO Post(Post_id, Contenuto, Type, Author, Gruppo)
VALUES(default, 'anatra.jpg', 2, 2, null);

INSERT INTO Post(Post_id, Contenuto, Type, Author, Gruppo)
VALUES(default, 'http://www.unica.it/', 3, 3, null);

INSERT INTO Post(Post_id, Contenuto, Type, Author, Gruppo)
VALUES(default, 'Oggi � una bella giornata', 1, 1, null);

INSERT INTO Amici(Follower, Followed)
Values(1,2),
      (2,1),
      (1,3),
      (3,1);

INSERT INTO Gruppo(Gruppo_id, Gruppo_name, Immagine)
VALUES (default, 'Mongolfieristi', 'mon.jpg');

INSERT INTO Gruppo(Gruppo_id, Gruppo_name, Immagine)
VALUES (default, 'Ritardatari', 'sv.jpg');

INSERT INTO Membro(Id_Gruppo, Id_Membro)
VALUES(1,1),
      (2,1),
      (1,3),
      (2,2);

