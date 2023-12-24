#어드민 전용 pw:41419
INSERT into tb_user(id, user_id,password ,useremail, username,user_role,created_time)
values (1,'well4149','$2a$12$kbXLEdFVu.icZGMmcxj5q.y2pj.z4gR9T4LAg1WyO1A4GkGBsKXXC','well414965@gmail.com','well1','ROLE_ADMIN',now());
#회원 전용 pw:1234
INSERT into tb_user(id, user_id,password ,useremail, username,user_role,created_time)
values (2,'well124','$2a$12$1KbR0tzDJxJOu1fHobYuou3s25N5jhS/7ZkCjKOhaU4aSs1GfZtZ6','well4149@naver.com','well2','ROLE_USER',now());
INSERT into tb_board(board_id, title, contents, created_by,created_at,id)
values (1,'well4149','well414965@gmail.com','well1',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title1','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title2','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title3','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title4','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title5','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title6','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title7','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title8','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title9','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title10','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title11','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title12','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title13','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title14','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title15','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title16','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title17','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title18','게시글 입니다.','well41419',now(),1);
INSERT into tb_board( title, contents, created_by,created_at,id)
values ('test title19','게시글 입니다.','well41419',now(),1);
/*INSERT into tb_user(id, user_id, useremail, username,created_at,created_time)
values (1,'well4149','well414965@gmail.com','well1','admin',now());
INSERT into tb_user(id, user_id, useremail, username,created_at,created_time)
values (2,'well123','well414965@naver.com','well2','user1',now());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (1, '게시글 제목1', '게시글 내용1', '작성자1', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (2, '게시글 제목2', '게시글 내용2', '작성자2', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (3, '게시글 제목3', '게시글 내용3', '작성자3', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (4, '게시글 제목4', '게시글 내용4', '작성자4', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (5, '게시글 제목5', '게시글 내용5', '작성자5', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (6, '게시글 제목6', '게시글 내용6', '작성자6', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (7, '게시글 제목7', '게시글 내용7', '작성자7', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (8, '게시글 제목8', '게시글 내용8', '작성자8', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (9, '게시글 제목9', '게시글 내용9', '작성자9', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (10, '게시글 제목10', '게시글 내용10', '작성자10', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (11, '게시글 제목11', '게시글 내용11', '작성자11', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (12, '게시글 제목12', '게시글 내용12', '작성자12', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (13, '게시글 제목13', '게시글 내용13', '작성자13', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (14, '게시글 제목14', '게시글 내용14', '작성자14', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (15, '게시글 제목15', '게시글 내용15', '작성자15', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (16, '게시글 제목16', '게시글 내용16', '작성자16', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (17, '게시글 제목17', '게시글 내용17', '작성자17', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (18, '게시글 제목18', '게시글 내용18', '작성자18', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (19, '게시글 제목19', '게시글 내용19', '작성자19', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (20, '게시글 제목20', '게시글 내용20', '작성자20', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (21, '게시글 제목21', '게시글 내용21', '작성자21', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (22, '게시글 제목22', '게시글 내용22', '작성자22', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (23, '게시글 제목23', '게시글 내용23', '작성자23', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (24, '게시글 제목24', '게시글 내용24', '작성자24', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (25, '게시글 제목25', '게시글 내용25', '작성자25', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (26, '게시글 제목26', '게시글 내용26', '작성자26', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (27, '게시글 제목27', '게시글 내용27', '작성자27', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (28, '게시글 제목28', '게시글 내용28', '작성자28', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (29, '게시글 제목29', '게시글 내용29', '작성자29', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (30, '게시글 제목30', '게시글 내용30', '작성자30', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (31, '게시글 제목31', '게시글 내용31', '작성자31', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (32, '게시글 제목32', '게시글 내용32', '작성자32', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (33, '게시글 제목33', '게시글 내용33', '작성자33', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (34, '게시글 제목34', '게시글 내용34', '작성자34', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (35, '게시글 제목35', '게시글 내용35', '작성자35', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (36, '게시글 제목36', '게시글 내용36', '작성자36', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (37, '게시글 제목37', '게시글 내용37', '작성자37', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (38, '게시글 제목38', '게시글 내용38', '작성자38', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (39, '게시글 제목39', '게시글 내용39', '작성자39', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (40, '게시글 제목40', '게시글 내용40', '작성자40', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (41, '게시글 제목41', '게시글 내용41', '작성자41', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (42, '게시글 제목42', '게시글 내용42', '작성자42', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (43, '게시글 제목43', '게시글 내용43', '작성자43', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (44, '게시글 제목44', '게시글 내용44', '작성자44', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (45, '게시글 제목45', '게시글 내용45', '작성자45', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (46, '게시글 제목46', '게시글 내용46', '작성자46', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (47, '게시글 제목47', '게시글 내용47', '작성자47', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (48, '게시글 제목48', '게시글 내용48', '작성자48', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (49, '게시글 제목49', '게시글 내용49', '작성자49', NOW(),1);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT,id)
VALUES (50, '게시글 제목50', '게시글 내용50', '작성자50', NOW(),2);
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (51, '게시글 제목51', '게시글 내용51', '작성자51', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (52, '게시글 제목52', '게시글 내용52', '작성자52', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (53, '게시글 제목53', '게시글 내용53', '작성자53', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (54, '게시글 제목54', '게시글 내용54', '작성자54', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (55, '게시글 제목55', '게시글 내용55', '작성자55', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (56, '게시글 제목56', '게시글 내용56', '작성자56', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (57, '게시글 제목57', '게시글 내용57', '작성자57', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (58, '게시글 제목58', '게시글 내용58', '작성자58', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (59, '게시글 제목59', '게시글 내용59', '작성자59', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (60, '게시글 제목60', '게시글 내용60', '작성자60', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (61, '게시글 제목61', '게시글 내용61', '작성자61', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (62, '게시글 제목62', '게시글 내용62', '작성자62', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (63, '게시글 제목63', '게시글 내용63', '작성자63', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (64, '게시글 제목64', '게시글 내용64', '작성자64', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (65, '게시글 제목65', '게시글 내용65', '작성자65', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (66, '게시글 제목66', '게시글 내용66', '작성자66', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (67, '게시글 제목67', '게시글 내용67', '작성자67', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (68, '게시글 제목68', '게시글 내용68', '작성자68', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (69, '게시글 제목69', '게시글 내용69', '작성자69', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (70, '게시글 제목70', '게시글 내용70', '작성자70', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (71, '게시글 제목71', '게시글 내용71', '작성자71', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (72, '게시글 제목72', '게시글 내용72', '작성자72', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (73, '게시글 제목73', '게시글 내용73', '작성자73', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (74, '게시글 제목74', '게시글 내용74', '작성자74', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (75, '게시글 제목75', '게시글 내용75', '작성자75', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (76, '게시글 제목76', '게시글 내용76', '작성자76', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (77, '게시글 제목77', '게시글 내용77', '작성자77', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (78, '게시글 제목78', '게시글 내용78', '작성자78', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (79, '게시글 제목79', '게시글 내용79', '작성자79', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (80, '게시글 제목80', '게시글 내용80', '작성자80', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (81, '게시글 제목81', '게시글 내용81', '작성자81', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (82, '게시글 제목82', '게시글 내용82', '작성자82', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (83, '게시글 제목83', '게시글 내용83', '작성자83', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (84, '게시글 제목84', '게시글 내용84', '작성자84', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (85, '게시글 제목85', '게시글 내용85', '작성자85', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (86, '게시글 제목86', '게시글 내용86', '작성자86', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (87, '게시글 제목87', '게시글 내용87', '작성자87', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (88, '게시글 제목88', '게시글 내용88', '작성자88', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (89, '게시글 제목89', '게시글 내용89', '작성자89', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (90, '게시글 제목90', '게시글 내용90', '작성자90', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (91, '게시글 제목91', '게시글 내용91', '작성자91', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (92, '게시글 제목92', '게시글 내용92', '작성자92', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (93, '게시글 제목93', '게시글 내용93', '작성자93', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (94, '게시글 제목94', '게시글 내용94', '작성자94', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (95, '게시글 제목95', '게시글 내용95', '작성자95', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (96, '게시글 제목96', '게시글 내용96', '작성자96', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (97, '게시글 제목97', '게시글 내용97', '작성자97', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (98, '게시글 제목98', '게시글 내용98', '작성자98', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (99, '게시글 제목99', '게시글 내용99', '작성자99', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (100, '게시글 제목100', '게시글 내용100', '작성자100', NOW());
INSERT INTO TB_BOARD (IDX, TITLE, CONTENTS, CREATED_BY, CREATED_AT)
VALUES (101, '게시글 제목101', '게시글 내용101', '작성자101', NOW());*/