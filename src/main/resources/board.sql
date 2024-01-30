#어드민 전용 pw:41419
INSERT into tb_user(id, user_id,password ,useremail, username,user_role,created_time)
values (1,'well4149','$2a$12$lg8IA/Kup8Dm95p1Wcndle5FKVMCP25snnNR4cj4yl6cE81GnfqtC','well414965@gmail.com','well1','ROLE_ADMIN',now());
#회원 전용 pw:1234
INSERT into tb_user(id, user_id,password ,useremail, username,user_role,created_time)
values (2,'well124','$2a$12$1KbR0tzDJxJOu1fHobYuou3s25N5jhS/7ZkCjKOhaU4aSs1GfZtZ6','well4149@naver.com','well2','ROLE_USER',now());
#회원2 pw:qwer4149

select * from tb_user;
select * from tb_board;
select * from tb_comment;
select * from tb_file;

INSERT into tb_board(title, contents, created_by,created_at,user_idx)
values ('admin title','admin contents','well4149',now(),1);
INSERT into tb_board(title, contents, created_by,created_at,user_idx)
values ('test title','test contents!','well124',now(),2);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title1','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title2','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title3','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title4','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title5','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title6','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title7','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title8','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title9','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title10','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title11','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title12','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title13','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title14','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title15','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title16','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title17','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title18','게시글 입니다.','well4149',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,user_idx)
values ('test title19','게시글 입니다.','well4149',now(),1);

insert into tb_comment(contents, created_at, created_by, board_id,user_idx)
VALUES ('test comment',now(),'well4149',1,1);

INSERT INTO spring_react.tb_file (id, created_at, file_path, file_type, origin_file_name, stored_file_name, board_id) VALUES (4, '2024-01-01 02:25:51', 'C:\\\\testupload\\\\', 'image/png', 'jpaBlog.png', 'FILE_1_8d06224a-56c7-4b5e-b29c-8bd760445adf.png', 1);
INSERT INTO spring_react.tb_file (id, created_at, file_path, file_type, origin_file_name, stored_file_name, board_id) VALUES (5, '2024-01-01 02:25:51', 'C:\\\\testupload\\\\', 'application/x-sql', 'test.sql', 'FILE_1_6c46a8fb-a2b9-4b6c-b724-add5cdaec464.sql', 1);
INSERT INTO spring_react.tb_file (id, created_at, file_path, file_type, origin_file_name, stored_file_name, board_id) VALUES (6, '2024-01-01 02:25:51', 'C:\\\\testupload\\\\', 'text/plain', '트러블 슈팅 및 구현기능.txt', 'FILE_1_44b33639-edd7-4857-835c-2ae54ccc3813.txt', 1);
INSERT INTO spring_react.tb_file (id, created_at, file_path, file_type, origin_file_name, stored_file_name, board_id) VALUES (9, '2024-01-03 22:33:25', 'C:\\\\testupload\\\\', 'text/plain', 'ip주소는 네트워크 통신에 있어서 각각의 통신기기에 할당된 식별.txt', 'FILE_28_10544b94-0463-4bec-af2c-00dc23b78c55.txt', 28);
INSERT INTO spring_react.tb_file (id, created_at, file_path, file_type, origin_file_name, stored_file_name, board_id) VALUES (10, '2024-01-03 22:33:25', 'C:\\\\testupload\\\\', 'text/plain', 'redis.txt', 'FILE_28_bd270231-568f-4a51-a4d2-a82c6e0e7e5b.txt', 28);
