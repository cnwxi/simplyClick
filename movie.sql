/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : localhost:3306
 Source Schema         : movie

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 14/06/2020 00:31:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for belong
-- ----------------------------
DROP TABLE IF EXISTS `belong`;
CREATE TABLE `belong`  (
  `filmType` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `filmId` int NOT NULL,
  PRIMARY KEY (`filmType`, `filmId`) USING BTREE,
  INDEX `FK_Reference_4`(`filmId`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`filmType`) REFERENCES `type` (`filmType`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`filmId`) REFERENCES `film` (`filmId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of belong
-- ----------------------------
INSERT INTO `belong` VALUES ('剧情', 1);
INSERT INTO `belong` VALUES ('剧情', 2);
INSERT INTO `belong` VALUES ('剧情', 3);
INSERT INTO `belong` VALUES ('喜剧', 3);
INSERT INTO `belong` VALUES ('喜剧', 4);
INSERT INTO `belong` VALUES ('动作', 5);
INSERT INTO `belong` VALUES ('剧情', 6);
INSERT INTO `belong` VALUES ('动作', 6);
INSERT INTO `belong` VALUES ('喜剧', 7);
INSERT INTO `belong` VALUES ('悬疑', 7);
INSERT INTO `belong` VALUES ('惊悚', 7);
INSERT INTO `belong` VALUES ('悬疑', 8);
INSERT INTO `belong` VALUES ('惊悚', 8);
INSERT INTO `belong` VALUES ('科幻', 8);
INSERT INTO `belong` VALUES ('剧情', 9);
INSERT INTO `belong` VALUES ('爱情', 9);
INSERT INTO `belong` VALUES ('剧情', 10);
INSERT INTO `belong` VALUES ('爱情', 10);
INSERT INTO `belong` VALUES ('剧情', 11);
INSERT INTO `belong` VALUES ('科幻', 11);
INSERT INTO `belong` VALUES ('剧情', 12);
INSERT INTO `belong` VALUES ('悬疑', 12);
INSERT INTO `belong` VALUES ('科幻', 12);
INSERT INTO `belong` VALUES ('动作', 13);
INSERT INTO `belong` VALUES ('惊悚', 13);
INSERT INTO `belong` VALUES ('动作', 14);
INSERT INTO `belong` VALUES ('惊悚', 14);
INSERT INTO `belong` VALUES ('科幻', 14);

-- ----------------------------
-- Table structure for cast
-- ----------------------------
DROP TABLE IF EXISTS `cast`;
CREATE TABLE `cast`  (
  `castId` int NOT NULL COMMENT '演职人员编号',
  `castName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '演职人员姓名',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '演职人员性别',
  `country` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '演职人员国籍',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  PRIMARY KEY (`castId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cast
-- ----------------------------
INSERT INTO `cast` VALUES (1, ' 殷若昕', 0, '中国', '1986-11-21');
INSERT INTO `cast` VALUES (2, ' 游晓颖', 0, '中国', '2020-04-01');
INSERT INTO `cast` VALUES (3, ' 张子枫', 0, '中国', '2001-08-27');
INSERT INTO `cast` VALUES (4, '肖央', 1, '中国', '1980-04-27');
INSERT INTO `cast` VALUES (5, '朱媛媛', 0, '中国', '1974-03-18');
INSERT INTO `cast` VALUES (6, ' 弗兰克·德拉邦特', 1, '法国', '1959-01-28');
INSERT INTO `cast` VALUES (7, '斯蒂芬·金', 1, '美国', '1947-09-21');
INSERT INTO `cast` VALUES (8, '蒂姆·罗宾斯', 1, '美国', '1958-10-16');
INSERT INTO `cast` VALUES (9, '摩根·弗里曼', 1, '美国', '1937-06-01');
INSERT INTO `cast` VALUES (10, '鲍勃·冈顿', 1, '美国', '1945-11-15');
INSERT INTO `cast` VALUES (11, '文牧野', 1, '中国', '1985-02-14');
INSERT INTO `cast` VALUES (12, '韩家女', 0, '中国', '2020-04-01');
INSERT INTO `cast` VALUES (13, '钟伟', 1, '中国', '2020-04-01');
INSERT INTO `cast` VALUES (14, '徐峥', 1, '中国', '1972-04-18');
INSERT INTO `cast` VALUES (15, '王传君', 1, '中国', '1985-10-18');
INSERT INTO `cast` VALUES (16, '闫非', 1, '中国', '2020-04-01');
INSERT INTO `cast` VALUES (17, '彭大魔', 1, '中国', '2020-04-01');
INSERT INTO `cast` VALUES (18, '林炳宝', 1, '中国', '2020-04-01');
INSERT INTO `cast` VALUES (19, '沈腾 ', 1, '中国', '1979-10-23');
INSERT INTO `cast` VALUES (20, '宋芸桦', 0, '中国', '1992-10-21');
INSERT INTO `cast` VALUES (21, ' 林诣彬', 1, '中国', '1971-10-11');
INSERT INTO `cast` VALUES (22, '丹·凯西', 1, '美国', '1981-11-15');
INSERT INTO `cast` VALUES (23, '盖瑞·斯科特·汤普森', 1, ' 萨摩亚', '1959-10-07');
INSERT INTO `cast` VALUES (24, '范·迪塞尔 ', 1, '美国', '1967-07-18');
INSERT INTO `cast` VALUES (25, '约翰·塞纳', 1, '美国', '1977-04-23');
INSERT INTO `cast` VALUES (26, '吕克·贝松', 1, '法国', '1959-03-18');
INSERT INTO `cast` VALUES (27, '让·雷诺', 1, '摩洛哥', '1949-07-30');
INSERT INTO `cast` VALUES (28, '娜塔莉·波特曼 ', 0, '以色列', '1981-06-09');
INSERT INTO `cast` VALUES (29, '加里·奥德曼', 1, '英国', '1958-03-21');
INSERT INTO `cast` VALUES (30, '丹尼·爱罗', 1, '美国', '1933-06-20');
INSERT INTO `cast` VALUES (31, '斯里兰姆·拉格万', 1, '印度', '2020-04-01');
INSERT INTO `cast` VALUES (32, '阿里吉特·比沙什', 1, '印度', '2020-04-01');
INSERT INTO `cast` VALUES (33, '约戈什·查德卡尔', 1, '印度', '2020-04-01');
INSERT INTO `cast` VALUES (34, '阿尤斯曼·库拉纳', 1, '印度', '1984-09-14');
INSERT INTO `cast` VALUES (35, '塔布', 0, '印度', '1970-11-04');
INSERT INTO `cast` VALUES (36, ' 邓肯·琼斯', 1, '英国', '1971-05-30');
INSERT INTO `cast` VALUES (37, '本·雷普利', 1, '英国', '2020-04-01');
INSERT INTO `cast` VALUES (38, '杰克·吉伦哈尔', 1, '美国', '1980-12-19');
INSERT INTO `cast` VALUES (39, '维拉·法米加', 0, '美国', '1973-08-06');
INSERT INTO `cast` VALUES (40, '米歇尔·莫纳汉', 0, '美国', '1976-03-23');
INSERT INTO `cast` VALUES (41, '詹姆斯·卡梅隆 ', 1, '加拿大', '1954-08-16');
INSERT INTO `cast` VALUES (42, '莱昂纳多·迪卡普里奥', 1, '美国', '1974-11-11');
INSERT INTO `cast` VALUES (43, '凯特·温丝莱特', 0, '英国', '1975-10-05');
INSERT INTO `cast` VALUES (44, '比利·赞恩', 1, '美国', '1966-02-24');
INSERT INTO `cast` VALUES (45, '凯西·贝茨', 0, '美国', '1948-06-28');
INSERT INTO `cast` VALUES (46, '岩井俊二', 1, '日本', '1963-01-24');
INSERT INTO `cast` VALUES (47, '中山美穗 ', 0, '日本', '1970-03-01');
INSERT INTO `cast` VALUES (48, '丰川悦司', 1, '日本', '1962-03-18');
INSERT INTO `cast` VALUES (49, '酒井美纪', 0, '日本', '1978-02-21');
INSERT INTO `cast` VALUES (50, '柏原崇', 1, '日本', '1977-03-16');
INSERT INTO `cast` VALUES (51, '彼得·威尔', 1, '澳大利亚', '1944-08-21');
INSERT INTO `cast` VALUES (52, '安德鲁·尼科尔', 1, '新西兰', '1964-06-10');
INSERT INTO `cast` VALUES (53, '金·凯瑞', 1, '加拿大', '1962-01-17');
INSERT INTO `cast` VALUES (54, '劳拉·琳妮', 0, '美国', '1964-02-05');
INSERT INTO `cast` VALUES (55, '艾德·哈里斯', 1, '美国', '1950-11-28');
INSERT INTO `cast` VALUES (56, '克里斯托弗·诺兰 ', 1, '英国', '1970-07-30');
INSERT INTO `cast` VALUES (57, '莱昂纳多·迪卡普里奥', 1, '美国', '1974-11-11');
INSERT INTO `cast` VALUES (58, '约瑟夫·高登-莱维特 ', 1, '美国', '1981-02-17');
INSERT INTO `cast` VALUES (59, '艾利奥特·佩吉', 0, '加拿大', '1987-02-21');
INSERT INTO `cast` VALUES (60, '汤姆·哈迪', 1, '英国', '1977-09-15');
INSERT INTO `cast` VALUES (61, '延尚昊', 1, '韩国', '2020-04-01');
INSERT INTO `cast` VALUES (62, '孔刘', 1, '韩国', '1979-07-01');
INSERT INTO `cast` VALUES (63, '郑有美', 0, '韩国', '1983-01-18');
INSERT INTO `cast` VALUES (64, '马东锡', 1, '韩国', '1971-03-01');
INSERT INTO `cast` VALUES (65, '金秀安', 0, '韩国', '2006-01-27');
INSERT INTO `cast` VALUES (66, '鲁本·弗雷斯彻', 1, '美国', '1974-10-31');
INSERT INTO `cast` VALUES (67, '杰夫·皮克纳', 1, '美国', '2020-04-01');
INSERT INTO `cast` VALUES (68, '斯科特·罗森伯格', 1, '美国', '1963-04-24');
INSERT INTO `cast` VALUES (69, '汤姆·哈迪', 1, '英国', '1977-09-15');
INSERT INTO `cast` VALUES (70, '米歇尔·威廉姆斯', 0, '美国', '1980-09-09');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `filmId` int NOT NULL COMMENT '电影编号',
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `score` float NULL DEFAULT NULL COMMENT '用户评分',
  `modified` date NULL DEFAULT NULL,
  PRIMARY KEY (`username`, `filmId`) USING BTREE,
  INDEX `FK_Reference_2`(`filmId`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`filmId`) REFERENCES `film` (`filmId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1234', 1, '最后安然带着安子恒跑出领养家庭的时候，忘了把银行卡带上，这个事儿让我很挂心。', 4, '2020-04-03');
INSERT INTO `comment` VALUES ('1234', 2, '恐惧让你沦为囚犯，希望让你重获自由。——《肖申克的救赎》', 3, '2020-06-23');
INSERT INTO `comment` VALUES ('1234', 3, '最大的病，其实是穷病。真的被感动了，整体都很成熟，也有些许韩片的影子。几个演员表演都非常出色。可看性和内在的表达都不错。这个世界最荒诞在于，越贴近真实，真实越荒诞。人这一生，太不易了。最后，王传君，加油哦！', 3, '2020-06-08');
INSERT INTO `comment` VALUES ('1234', 4, '作为一个笑点还比较高的人，一度笑崩溃了。亮点很多，惊喜密集。而难得的是，阐述了喜剧比较高级的力量，对当今社会做了不同角度和程度的讽刺。', 3, '2020-06-23');
INSERT INTO `comment` VALUES ('1234', 5, '捏妈，下一部直接速度与激情10:星球大战。', 3, '2020-06-15');
INSERT INTO `comment` VALUES ('1234', 6, '里昂只有一颗盆栽，不善言辞，爱喝牛奶。他不像，却真正是一个杀手。玛蒂达的到来，是包袱，也给里昂带来了生机。不过这种设定，注定是悲剧收场。里昂死后，玛蒂达将他盆栽的种子落地生根，里昂终于不再每日拿着手枪在椅子上不安地入睡，他落地了。娜塔莉波特曼太灵了，玛蒂达是如此特别。', 4, '2020-06-25');
INSERT INTO `comment` VALUES ('1234', 7, '谁能想到今年最佳悬疑片是印度片？', 3, '2020-07-05');
INSERT INTO `comment` VALUES ('1234', 9, '爱你原本只是一瞬，却不知在时间的洪流中成了永恒。', 3, '2020-06-02');
INSERT INTO `comment` VALUES ('1234', 12, '1、电影确实精彩。2、没有想象的难懂，相信你自己。3、总会有一个让你记一辈子的镜头。4、请降低期待值。5、请提前上厕所。6、记得关手机。7、一定要去影院，因为影院也是个造梦机器。8、记得听完结尾音乐。因为它负责让你醒来。9、极可能是近几年你在影院看过最精彩的电影。10、穿越吧少年', 4, '2020-06-16');
INSERT INTO `comment` VALUES ('1234', 13, '好过美国的《僵尸世界大战》，韩国在丧尸类型片的开拓一出手就登峰造极，个别桥段快准狠到了心骨眼！最后孕妇和小女孩穿过隧道如果遇到河正宇，那这片就真的是神作了！＝。＝', 4, '2020-06-09');
INSERT INTO `comment` VALUES ('1234', 14, '2.5 / 反英雄反到什么程度呢？Loser有了神力就可以直接决定他人生死？在自己星球是Loser所以到相对弱的地球来称王？到头来主角一边叫嚣着正义一边回到最简单粗暴的善恶二分，还继承了反派强者通吃的逻辑。这不是反英雄，而是倒退到反智。连自由平等的谎言都懒得编了，可以说是完全匹配当下美帝精神困境了。好莱坞主旋律拍着拍着到这个程度在价值观上已经和《西虹市首富》一步之遥了吧？', 2, '2020-06-24');
INSERT INTO `comment` VALUES ('2234', 1, '全片最震惊的一句话“从小被表哥当沙包，被姑父看洗澡”。', 2, '2020-04-02');
INSERT INTO `comment` VALUES ('2234', 2, '策划了19年的私奔……', 4, '2020-06-01');
INSERT INTO `comment` VALUES ('2234', 3, '小时候路过一家药店，门口的对联写着“只愿世间无疾病，何愁架上药染尘”', 4, '2020-06-01');
INSERT INTO `comment` VALUES ('2234', 4, '除了尴尬的台湾女主其他人都很好笑，沈腾和常远一出场大家就笑，本来是8-9分的好笑程度，因为女主演技稀烂扣掉2星，最后金先生承认自己是二奶好评，电影现在能公开带一点同性恋内容也不容易', 2, '2020-07-01');
INSERT INTO `comment` VALUES ('2234', 5, '比较失望，仍然停留在银河系范围跳不出来，动作设计始终没有摆脱力学的限制，希望下一部再接再厉', 3, '2020-05-12');
INSERT INTO `comment` VALUES ('2234', 8, '如果结局停在那一吻我就给四星半了。', 4, '2004-10-21');
INSERT INTO `comment` VALUES ('2234', 10, '2000年，本人看得第一部文艺片，当时不知道啥是文艺片，表面上洋洋得意，认为自己算个文艺青年了，内心里无比的可惜那一块钱，因为本来是租《唐伯虎点秋香》去的。被人租走了才不得以看《情书》', 3, '2020-06-16');
INSERT INTO `comment` VALUES ('2234', 13, '目前亚洲商业片的最高水准 看完之后对国产电影充满了愤怒。', 4, '2020-06-16');
INSERT INTO `comment` VALUES ('3234', 1, '它本可以是《何以为家》，但它选择了《以家人之名》。', 2, '2020-06-02');
INSERT INTO `comment` VALUES ('3234', 2, 'Fear Can Hold You Prisoner, Hope Can Set You Free', 4, '2020-06-24');
INSERT INTO `comment` VALUES ('3234', 3, '“今后都会越来越好吧，希望这一天早点来”口罩成为符号，不是雾霾，而是人性的仪式，结尾竟然看到《辛德勒名单》一样的救赎。通俗感人，上海电影节首映哭倒一片，基于真实事件改编的社会意义加分，或许《我不是药神》之于中国，就像《摔跤吧爸爸》之于印度吧…能看到就不错。“其实只有一种病：穷病”', 4, '2020-06-24');
INSERT INTO `comment` VALUES ('3234', 4, '论同性婚姻合法化的重要性，要是二奶合法继承了，还有他王多鱼什么事', 3, '2020-06-01');
INSERT INTO `comment` VALUES ('3234', 5, '柯南:以后别光说我，这货比我更科幻片', 4, '2020-06-02');
INSERT INTO `comment` VALUES ('3234', 7, '短片《调音师》的加长版，但是改编的非常成功，情节多变，反转无数，黑色幽默接连不断。前面兔子的预言影射全片且首尾相连，很牛逼，结局的反转也超棒，拐棍把罐子打到一边正明还是装瞎，那么他是换了谁的眼角膜。。。', 4, '2020-05-31');
INSERT INTO `comment` VALUES ('3234', 10, '翻过来的卡片，肖像，是初恋回忆的完美情书', 5, '2020-06-24');
INSERT INTO `comment` VALUES ('4234', 1, '姑妈那条线 就是两代人的悲哀', 3, '2020-05-19');
INSERT INTO `comment` VALUES ('4234', 2, '墙里的人老是喊自由，可是墙外的我们真正得到了吗？', 4, '2020-07-03');
INSERT INTO `comment` VALUES ('4234', 3, '炸裂，哭成狗，从观影体验上看，比达拉斯买家俱乐部好，之间隔了差不多五个《动物世界》，导演处女作就这完成度，只能说剧本实在太好。我爸爸也是药神的受益者之一，否则我应该房子也没了。感谢他们。', 3, '2020-06-19');
INSERT INTO `comment` VALUES ('4234', 6, '超级爱那个男人抱着一盆植物走在街道上的样子。', 5, '2020-06-25');
INSERT INTO `comment` VALUES ('4234', 9, '“我甚至连一张他的画像都没有，但他永远活在我心中。” 要敢说，这是我一直深爱的电影。', 4, '2020-06-09');
INSERT INTO `comment` VALUES ('4234', 11, '年轻时候的金凯瑞真TMD 帅。尤其一头柔顺的头发。', 3, '2020-06-24');
INSERT INTO `comment` VALUES ('4234', 12, '你永远记不起一个梦的开端，就像记不起我们如何来到这个世界上。', 3, '2020-06-01');
INSERT INTO `comment` VALUES ('5234', 1, '太多人叫女性认命了，现在甚至女导演也如此。。。', 3, '2020-04-28');
INSERT INTO `comment` VALUES ('5234', 2, '这样的男人谁会舍得背叛。。。', 2, '2020-06-07');
INSERT INTO `comment` VALUES ('5234', 3, '我就是想实名表扬一下王传君，内地青年演员里竟然也有这种会演戏并且很卖力的实力派演员，这要是搁在好莱坞，他能拿下一座奥斯卡最佳男配。像这样的现实主义题材电影，如果编剧不是韩家女，它可能连拍摄许可证都拿不到，过审更没戏，它在国内的审查制度下没有可复制性，像这样的电影，且看且珍惜吧！', 2, '2020-05-18');
INSERT INTO `comment` VALUES ('5234', 6, '我到哪里找，像你这么好。', 4, '2020-07-01');
INSERT INTO `comment` VALUES ('5234', 11, '要想阻挡我 只有杀我', 4, '2020-06-26');

-- ----------------------------
-- Table structure for film
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film`  (
  `filmId` int NOT NULL COMMENT '电影编号',
  `filmName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电影名称',
  `posterPath` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电影海报',
  `area` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '制片地区',
  `language` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '语言',
  `footage` smallint NULL DEFAULT NULL COMMENT '片长，以分钟为单位',
  `avgScore` float NULL DEFAULT NULL COMMENT '电影平均评分',
  `profile` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电影简介',
  PRIMARY KEY (`filmId`) USING BTREE,
  INDEX `FK_Reference_7`(`posterPath`) USING BTREE,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`posterPath`) REFERENCES `pic` (`path`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES (1, '我的姐姐', '/images/我的姐姐.png', '中国大陆', '汉语普通话/四川话', 127, 2.8, '影片围绕失去父母的姐姐在面对追求个人独立生活还是抚养弟弟的问题上展开了一段细腻感人的亲情故事。');
INSERT INTO `film` VALUES (2, '肖申克的救赎', '/images/肖申克的救赎.png', '美国', '英语', 142, 3.4, '一场谋杀案使银行家安迪蒙冤入狱，谋杀妻子及其情人的指控将囚禁他终生。在肖申克监狱的首次现身就让监狱“大哥”瑞德对他另眼相看。瑞德帮助他搞到一把石锤和一幅女明星海报，两人渐成患难之交。很快，安迪在监狱里大显其才，担当监狱图书管理员，并利用自己的金融知识帮助监狱官避税，引起了典狱长的注意，被招致麾下帮助典狱长洗黑钱。偶然一次，他得知一名新入狱的小偷能够作证帮他洗脱谋杀罪。燃起一丝希望的安迪找到了典狱长，希望他能帮自己翻案。阴险伪善的狱长假装答应安迪，背后却派人杀死小偷，让他唯一能合法出狱的希望泯灭。沮丧的安迪并没有绝望，在一个电闪雷鸣的风雨夜，一场暗藏几十年的越狱计划让他自我救赎，重获自由！老朋友瑞德在他的鼓舞和帮助下，也勇敢地奔向自由。');
INSERT INTO `film` VALUES (3, '我不是药神', '/images/我不是药神.png', '中国大陆', '汉语普通话 / 英语', 117, 3.2, '普通中年男子程勇（徐峥 饰）经营着一家保健品店，失意又失婚。不速之客吕受益（王传君 饰）的到来，让他开辟了一条去印度买药做“代购”的新事业，虽然困难重重，但他在这条“买药之路”上发现了商机，一发不可收拾地做起了治疗慢粒白血病的印度仿制药独家代理商。赚钱的同时，他也认识了几个病患及家属，为救女儿被迫做舞女的思慧（谭卓 饰）、说一口流利“神父腔”英语的刘牧师（杨新鸣 饰），以及脾气暴烈的“黄毛”（章宇 饰），几个人合伙做起了生意，利润倍增的同时也危机四伏。程勇昔日的小舅子曹警官（周一围 饰）奉命调查仿制药的源头，假药贩子张长林（王砚辉 饰）和瑞士正牌医药代表（李乃文 饰）也对其虎视眈眈，生意逐渐变成了一场关于救赎的拉锯战。本片改编自慢粒白血病患者陆勇代购抗癌药的真实事迹。');
INSERT INTO `film` VALUES (4, '西虹市首富', '/images/西虹市首富.png', '中国大陆', ' 汉语普通话', 118, 2.66667, '　西虹市丙级球队大翔队的守门员王多鱼（沈腾 饰）因比赛失利被教练开除，一筹莫展之际王多鱼突然收到神秘人士金老板（张晨光 饰）的邀请，被告知自己竟然是保险大亨王老太爷（李立群 饰）的唯一继承人，遗产高达百亿！但是王老太爷给出了一个非常奇葩的条件，那就是要求王多鱼在一个月内花光十亿，还不能告诉身边人，否则失去继承权。王多鱼毫不犹豫签下了“军令状”，与好友庄强（张一鸣 饰）以及财务夏竹（宋芸桦 饰）一起开启了“挥金之旅”，即将成为西虹市首富的王多鱼，第一次感受到了做富人的快乐，同时也发现想要挥金如土实在没有那么简单！');
INSERT INTO `film` VALUES (5, '速度与激情9', '/images/速度与激情9.png', '美国', '英语', 142, 3, '“唐老大”多姆·托莱多（范·迪塞尔 饰）与莱蒂（米歇尔·罗德里格兹 饰）和他的儿子小布莱恩，过上了远离纷扰的平静生活。然而他们也知道，安宁之下总潜藏着危机。这一次，为了保护他所爱的人，唐老大不得不直面过去。他和伙伴们面临的是一场足以引起世界动荡的阴谋，以及一个前所未遇的一流杀手和高能车手。而这个名叫雅各布（约翰·塞纳 饰）的人，恰巧是多姆遗落在外的亲弟弟。');
INSERT INTO `film` VALUES (6, '这个杀手不太冷', '/images/这个杀手不太冷.png', '法国 / 美国', '英语 / 意大利语 / 法语', 110, 4.33333, '里昂（让·雷诺饰）是名孤独的职业杀手，受人雇佣。一天，邻居家小姑娘马蒂尔达（纳塔丽·波特曼饰)敲开他的房门，要求在他那里暂避杀身之祸。原来邻居家的主人是警方缉毒组的眼线，只因贪污了一小包毒品而遭恶警（加里·奥德曼饰）杀害全家的惩罚。马蒂尔达得到里昂的留救，幸免于难，并留在里昂那里。里昂教小女孩使枪，她教里昂法文，两人关系日趋亲密，相处融洽。\r\n　　女孩想着去报仇，反倒被抓，里昂及时赶到，将女孩救回。混杂着哀怨情仇的正邪之战渐次升级，更大的冲突在所难免……\r\n');
INSERT INTO `film` VALUES (7, '调音师', '/images/调音师.png', '印度', '印地语 / 英语', 139, 3.5, '双目失明的钢琴家阿卡什（阿尤斯曼·库拉纳 Ayushmann Khurrana 饰）为了参加国际大赛，平日里通过私人授课赚取经费。事实上他的眼睛完全正常，只不过希望通过这种方式感受不同的生活。因为一场意外，阿卡什结识了美丽的姑娘苏菲（拉迪卡·艾普特 Radhika Apte 饰）。凭借出色的演奏技巧，阿卡什在苏菲父亲经营的西餐馆谋得兼职。他的演奏不仅令食客们倾倒，更虏获了苏菲的心。某天，阿卡什接受过气的影星普拉默（安尔·德霍万 Anil Dhawan 饰）的邀请，登门为对方的妻子西米（塔布 Tabu 饰）演奏庆生，谁知却亲眼目睹了倒在血泊中的普拉默的尸体。惊慌失措的阿卡什假装镇定，虽然暂时骗过了西米及其情夫，但是他的秘密还是慢慢被人戳穿……本片改编自2010年的同名法国高分悬疑短片。');
INSERT INTO `film` VALUES (8, '源代码', '/images/源代码.png', '美国 / 加拿大', '英语', 93, 4, '在阿富汗执行任务的美国空军飞行员科特史蒂文斯上尉（杰克·吉伦哈尔 Jake Gyllenhaal 饰）突然惊醒，发现自己在一辆高速行驶的列车上，而他的身边坐着一个素不相识的女子克里斯蒂安（米歇尔·莫娜汉 Michelle Monaghan 饰）正在与自己讲话。科尔不知自己为什么会在这辆车上，而且他发现自己居然是以另一个人的身份存在，正当他迷惑不解的时候，列车上忽然发生爆炸……科特又一次惊醒，发现自己身处一个密闭的太空仓里，有一位女军官古德温（维拉·法米加 Vera Farmiga 饰）正在通过视频和自己对话，并要求自己报告列车上发生的事情。一头雾水的科特还没搞明白是怎么回事时，他又一次被送上那辆列车。这次之后，科特终于明白自己在执行一件任务，负责调察芝加哥火车爆炸案找到恐怖份子并查出他的下一个目标。科特被一次又一次的送上那辆高速列车，每次只有八分钟... ');
INSERT INTO `film` VALUES (9, '泰坦尼克号 ', '/images/泰坦尼克号.png', '美国', '英语 / 意大利语 ', 194, 3.5, '1912年4月10日，号称 “世界工业史上的奇迹”的豪华客轮泰坦尼克号开始了自己的处女航，从英国的南安普顿出发驶往美国纽约。富家少女罗丝（凯特•温丝莱特）与母亲及未婚夫卡尔坐上了头等舱；另一边，放荡不羁的少年画家杰克（莱昂纳多·迪卡普里奥）也在码头的一场赌博中赢得了下等舱的船票。罗丝厌倦了上流社会虚伪的生活，不愿嫁给卡尔，打算投海自尽，被杰克救起。很快，美丽活泼的罗丝与英俊开朗的杰克相爱，杰克带罗丝参加下等舱的舞会、为她画像，二人的感情逐渐升温。1912年4月14日，星期天晚上，一个风平浪静的夜晚。泰坦尼克号撞上了冰山，“永不沉没的”泰坦尼克号面临沉船的命运，罗丝和杰克刚萌芽的爱情也将经历生死的考验。');
INSERT INTO `film` VALUES (10, '情书', '/images/情书.png', '日本', '日语', 117, 4, '日本神户某个飘雪的冬日，渡边博子（中山美穗）在前未婚夫藤井树的两周年祭日上又一次悲痛到不能自已。正因为无法抑制住对已逝恋人的思念，渡边博子在其中学同学录里发现“藤井树” 在小樽市读书时的地址时，依循着寄发了一封本以为是发往天国的情书。不想不久渡边博子竟然收到署名为“藤 井树（中山美穗）”的回信，经过进一步了解，她知晓此藤井树是一个同她年纪相仿的女孩，且还是男友藤井树（柏原崇）少年时代的同班同学。为了多了解一些昔日恋人在中学时代的情况，渡边博子开始与女性藤井树书信往来。而藤井树在不断的回忆中，渐渐发现少年时代与她同名同姓的那个藤井树曾对自己藏了一腔柔情。');
INSERT INTO `film` VALUES (11, '楚门的世界', '/images/楚门的世界.png', '美国', '英语', 103, 3.5, '楚门（金•凯瑞 Jim Carrey 饰）是一个平凡得不能再平凡的人，除了一些有些稀奇的经历之外——初恋女友突然失踪、溺水身亡的父亲忽然似乎又出现在眼前，他和绝大多数30多岁的美国男人绝无异样。这令他倍感失落。他也曾试过离开自己生活了多年的地方，但总因种种理由而不能成行。直到有一天，他忽然发觉自己似乎一直在被人跟踪，无论他走到哪里，干什么事情。这种感觉愈来愈强烈。楚门决定不惜一切代价逃离这个他生活了30多年的地方，去寻找他的初恋女友。但他却发现自己怎样也逃不出去。真相其实很残忍。');
INSERT INTO `film` VALUES (12, '盗梦空间', '/images/盗梦空间.png', '美国 / 英国', ' 英语 / 日语', 148, 3.5, '道姆·柯布（莱昂纳多·迪卡普里奥 Leonardo DiCaprio 饰）与同事阿瑟（约瑟夫·戈登-莱维特 Joseph Gordon-Levitt 饰）和纳什（卢卡斯·哈斯 Lukas Haas 饰）在一次针对日本能源大亨齐藤（渡边谦 饰）的盗梦行动中失败，反被齐藤利用。齐藤威逼利诱因遭通缉而流亡海外的柯布帮他拆分他竞争对手的公司，采取极端措施在其唯一继承人罗伯特·费希尔（希里安·墨菲 Cillian Murphy 饰）的深层潜意识中种下放弃家族公司、自立门户的想法。为了重返美国，柯布偷偷求助于岳父迈尔斯（迈克尔·凯恩 Michael Caine 饰），吸收了年轻的梦境设计师艾里阿德妮（艾伦·佩吉 Ellen Page 饰）、梦境演员艾姆斯（汤姆·哈迪 Tom Hardy 饰）和药剂师约瑟夫（迪利普·劳 Dileep Rao 饰）加入行动。在一层层递进的梦境中，柯布不仅要对付费希尔潜意识的本能反抗，还必须直面已逝妻子梅尔（玛丽昂·歌迪亚 Marion Cotillard 饰）的处处破坏，实际情况远比预想危险得多……');
INSERT INTO `film` VALUES (13, '釜山行', '/images/釜山行.png', '韩国', '韩语', 118, 4, '证券公司基金管理人石宇（孔侑 饰）光鲜精干，却也是个重利轻义之徒。妻子为此与之决裂，女儿秀安（金秀安 饰）则对如此自私的父亲越来越失望，决定前往釜山和母亲生活。在秀安生日这天，石宇抽出时间陪伴女儿登上开往釜山的特快列车。而与此同时，城市四处出现了极为可疑的暴动事件。政府极力洗白无法掩盖丧尸肆虐的事实，即便懵然无知的列车乘客也因为不速之客的到来而堕入恐慌绝望的地狱中。开车的刹那，一名感染者冲入车厢，而她很快尸变并对目光所及之处的健康人展开血腥屠杀。未过多久，丧尸便呈几何数爆发性地增长。石宇被迫和幸存者的乘客们在逼仄的空间中奋力求生。通往釜山的遥遥旅途布满杀机，危难时刻每个幸存者的人性也承受巨大的考验……');
INSERT INTO `film` VALUES (14, '毒液', '/images/毒液.png', '美国 / 中国大陆', '英语 / 汉语普通话', 112, 2, '艾迪（汤姆·哈迪 Tom Hardy 饰）是一位深受观众喜爱的新闻记者，和女友安妮（米歇尔·威廉姆斯 Michelle Williams 饰）相恋多年，彼此之间感情十分要好。安妮是一名律师，接手了生命基金会的案件，在女友的邮箱里，艾迪发现了基金会老板德雷克（里兹·阿迈德 Riz Ahmed 饰）不为人知的秘密。为此，艾迪不仅丢了工作，女友也离他而去。之后，生命基金会的朵拉博士（珍妮·斯蕾特 Jenny Slate 饰）找到了艾迪，希望艾迪能够帮助她阻止德雷克疯狂的罪行。在生命基金会的实验室里，艾迪发现了德雷克进行人体实验的证据，并且在误打误撞之中被外星生命体毒液附身。回到家后，艾迪和毒液之间形成了共生关系，他们要应对的是德雷克派出的一波又一波杀手。');

-- ----------------------------
-- Table structure for participation
-- ----------------------------
DROP TABLE IF EXISTS `participation`;
CREATE TABLE `participation`  (
  `filmId` int NOT NULL COMMENT '电影编号',
  `castId` int NOT NULL COMMENT '人员编号',
  `role` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '担任职务',
  `character` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '担任角色',
  PRIMARY KEY (`filmId`, `castId`, `role`, `character`) USING BTREE,
  INDEX `FK_Reference_6`(`castId`) USING BTREE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`filmId`) REFERENCES `film` (`filmId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`castId`) REFERENCES `cast` (`castId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of participation
-- ----------------------------
INSERT INTO `participation` VALUES (1, 1, '导演', '导演');
INSERT INTO `participation` VALUES (1, 2, '编剧', '编剧');
INSERT INTO `participation` VALUES (1, 3, '主演', '女主角');
INSERT INTO `participation` VALUES (1, 4, '主演', '男主角');
INSERT INTO `participation` VALUES (1, 5, '演员', '女二号');
INSERT INTO `participation` VALUES (2, 6, '主演', '导演');
INSERT INTO `participation` VALUES (2, 6, '编剧', '编剧');
INSERT INTO `participation` VALUES (2, 7, '编剧', '编剧');
INSERT INTO `participation` VALUES (2, 8, '主演', '男主角');
INSERT INTO `participation` VALUES (2, 9, '演员', '男二号');
INSERT INTO `participation` VALUES (2, 10, '演员', '男三号');
INSERT INTO `participation` VALUES (3, 11, '导演', '导演');
INSERT INTO `participation` VALUES (3, 11, '编剧', '编剧');
INSERT INTO `participation` VALUES (3, 12, '编剧', '编剧');
INSERT INTO `participation` VALUES (3, 13, '编剧', '编剧');
INSERT INTO `participation` VALUES (3, 14, '主演', '男主角');
INSERT INTO `participation` VALUES (3, 15, '演员', '男二号');
INSERT INTO `participation` VALUES (4, 16, '导演', '导演');
INSERT INTO `participation` VALUES (4, 16, '编剧', '编剧');
INSERT INTO `participation` VALUES (4, 17, '导演', '导演');
INSERT INTO `participation` VALUES (4, 17, '编剧', '编剧');
INSERT INTO `participation` VALUES (4, 18, '编剧', '编剧');
INSERT INTO `participation` VALUES (4, 19, '主演', '男主角');
INSERT INTO `participation` VALUES (4, 20, '主演', '女主角');
INSERT INTO `participation` VALUES (5, 21, '导演', '导演');
INSERT INTO `participation` VALUES (5, 22, '编剧', '编剧');
INSERT INTO `participation` VALUES (5, 23, '编剧', '编剧');
INSERT INTO `participation` VALUES (5, 24, '主演', '男主角');
INSERT INTO `participation` VALUES (5, 25, '主演', '男主角');
INSERT INTO `participation` VALUES (6, 26, '导演', '导演');
INSERT INTO `participation` VALUES (6, 26, '编剧', '编剧');
INSERT INTO `participation` VALUES (6, 27, '主演', '男主角');
INSERT INTO `participation` VALUES (6, 28, '主演', '女主角');
INSERT INTO `participation` VALUES (6, 29, '演员', '男二号');
INSERT INTO `participation` VALUES (6, 30, '演员', '男三号');
INSERT INTO `participation` VALUES (7, 31, '导演', '导演');
INSERT INTO `participation` VALUES (7, 32, '编剧', '编剧');
INSERT INTO `participation` VALUES (7, 33, '编剧', '编剧');
INSERT INTO `participation` VALUES (7, 34, '主演', '男主角');
INSERT INTO `participation` VALUES (7, 35, '主演', '女主角');
INSERT INTO `participation` VALUES (8, 36, '导演', '导演');
INSERT INTO `participation` VALUES (8, 37, '编剧', '编剧');
INSERT INTO `participation` VALUES (8, 38, '主演', '男主角');
INSERT INTO `participation` VALUES (8, 39, '主演', '女主角');
INSERT INTO `participation` VALUES (8, 40, '演员', '女二号');
INSERT INTO `participation` VALUES (9, 41, '导演', '导演');
INSERT INTO `participation` VALUES (9, 41, '编剧', '编剧');
INSERT INTO `participation` VALUES (9, 42, '主演', '男主角');
INSERT INTO `participation` VALUES (9, 43, '主演', '女主角');
INSERT INTO `participation` VALUES (9, 44, '演员', '男二号');
INSERT INTO `participation` VALUES (9, 45, '演员', '女二号');
INSERT INTO `participation` VALUES (10, 46, '导演', '导演');
INSERT INTO `participation` VALUES (10, 46, '编剧', '编剧');
INSERT INTO `participation` VALUES (10, 47, '主演', '女主角');
INSERT INTO `participation` VALUES (10, 48, '主演', '男主角');
INSERT INTO `participation` VALUES (10, 49, '演员', '女二号');
INSERT INTO `participation` VALUES (10, 50, '演员', '男二号');
INSERT INTO `participation` VALUES (11, 51, '导演', '导演');
INSERT INTO `participation` VALUES (11, 52, '编剧', '编剧');
INSERT INTO `participation` VALUES (11, 53, '主演', '男主角');
INSERT INTO `participation` VALUES (11, 54, '主演', '女主角');
INSERT INTO `participation` VALUES (11, 55, '演员', '男二号');
INSERT INTO `participation` VALUES (12, 56, '导演', '导演');
INSERT INTO `participation` VALUES (12, 56, '编剧', '编剧');
INSERT INTO `participation` VALUES (12, 57, '主演', '男主角');
INSERT INTO `participation` VALUES (12, 58, '演员', '男二号');
INSERT INTO `participation` VALUES (12, 59, '主演', '女主角');
INSERT INTO `participation` VALUES (12, 60, '主演', '男三号');
INSERT INTO `participation` VALUES (13, 61, '导演', '导演');
INSERT INTO `participation` VALUES (13, 61, '编剧', '编剧');
INSERT INTO `participation` VALUES (13, 62, '主演', '男主角');
INSERT INTO `participation` VALUES (13, 63, '主演', '女主角');
INSERT INTO `participation` VALUES (13, 64, '演员', '男二号');
INSERT INTO `participation` VALUES (13, 65, '演员', '女二号');
INSERT INTO `participation` VALUES (14, 66, '导演', '导演');
INSERT INTO `participation` VALUES (14, 67, '编剧', '编剧');
INSERT INTO `participation` VALUES (14, 68, '编剧', '编剧');
INSERT INTO `participation` VALUES (14, 69, '主演', '男主角');
INSERT INTO `participation` VALUES (14, 70, '主演', '女主角');

-- ----------------------------
-- Table structure for pic
-- ----------------------------
DROP TABLE IF EXISTS `pic`;
CREATE TABLE `pic`  (
  `path` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`path`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pic
-- ----------------------------
INSERT INTO `pic` VALUES ('/images/情书.png');
INSERT INTO `pic` VALUES ('/images/我不是药神.png');
INSERT INTO `pic` VALUES ('/images/我的姐姐.png');
INSERT INTO `pic` VALUES ('/images/楚门的世界.png');
INSERT INTO `pic` VALUES ('/images/毒液.png');
INSERT INTO `pic` VALUES ('/images/泰坦尼克号.png');
INSERT INTO `pic` VALUES ('/images/源代码.png');
INSERT INTO `pic` VALUES ('/images/盗梦空间.png');
INSERT INTO `pic` VALUES ('/images/肖申克的救赎.png');
INSERT INTO `pic` VALUES ('/images/西红柿首富.png');
INSERT INTO `pic` VALUES ('/images/调音师.png');
INSERT INTO `pic` VALUES ('/images/这个杀手不太冷.png');
INSERT INTO `pic` VALUES ('/images/速度与激情9.png');
INSERT INTO `pic` VALUES ('/images/釜山行.png');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `filmType` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`filmType`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('剧情');
INSERT INTO `type` VALUES ('动作');
INSERT INTO `type` VALUES ('喜剧');
INSERT INTO `type` VALUES ('悬疑');
INSERT INTO `type` VALUES ('惊悚');
INSERT INTO `type` VALUES ('爱情');
INSERT INTO `type` VALUES ('科幻');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户用户名',
  `nickname` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '用户性别',
  `permission` int NULL DEFAULT NULL COMMENT '用户权限',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1234', '虫子', '1234', '2020-06-15', 1, 2);
INSERT INTO `user` VALUES ('2234', '滋养丰富风味绝', '123', '2020-06-30', 1, 2);
INSERT INTO `user` VALUES ('3234', '關於藤井樹', '1234', '2020-06-15', 0, 2);
INSERT INTO `user` VALUES ('4234', 'WRONGCOLOR', '1234', '2020-05-13', 0, 2);
INSERT INTO `user` VALUES ('5234', '只想谈钱', '1234', '2020-06-09', 0, 2);
INSERT INTO `user` VALUES ('admin', '信息管理员', '1234', '2020-06-13', 0, 1);
INSERT INTO `user` VALUES ('root', '用户管理员', '1234', '2020-06-13', 1, 0);
INSERT INTO `user` VALUES ('tester', '测试', '1234', '2020-06-13', 1, 2);

-- ----------------------------
-- Triggers structure for table comment
-- ----------------------------
DROP TRIGGER IF EXISTS `avg3`;
delimiter ;;
CREATE TRIGGER `avg3` AFTER DELETE ON `comment` FOR EACH ROW IF OLD.score >0 THEN
	UPDATE film SET film.avgScore = (SELECT AVG(`comment`.score) FROM `comment` WHERE `comment`.score >0 AND `comment`.filmId = OLD.filmId) WHERE film.filmId= OLD.filmId;
END IF
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table comment
-- ----------------------------
DROP TRIGGER IF EXISTS `avg1`;
delimiter ;;
CREATE TRIGGER `avg1` AFTER INSERT ON `comment` FOR EACH ROW IF NEW.score >0 THEN
	UPDATE film SET film.avgScore = (SELECT AVG(`comment`.score) FROM `comment` WHERE `comment`.score >0 AND `comment`.filmid = new.filmId) WHERE film.filmId=NEW.filmId;
END IF
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table comment
-- ----------------------------
DROP TRIGGER IF EXISTS `avg2`;
delimiter ;;
CREATE TRIGGER `avg2` AFTER UPDATE ON `comment` FOR EACH ROW IF NEW.score >0 AND NEW.score!= OLD.score THEN
	UPDATE film SET film.avgScore = (SELECT AVG(`comment`.score) FROM `comment` WHERE `comment`.score >0 AND `comment`.filmId = new.filmId) WHERE film.filmId=NEW.filmId;
END IF
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
