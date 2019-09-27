
CREATE TABLE schema4.notification
(
  not_pk SERIAL NOT NULL,
  not_message character varying(1024),
  CONSTRAINT pk_notification PRIMARY KEY (not_pk)
)

insert into schema4.notification (not_pk, not_message) VALUES
(1, 'hello'),
(2, 'world');
