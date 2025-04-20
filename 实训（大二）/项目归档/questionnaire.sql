/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : questionnaire

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 09/06/2022 20:16:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for excle_user
-- ----------------------------
DROP TABLE IF EXISTS `excle_user`;
CREATE TABLE `excle_user`  (
                               `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
                               `role_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色类型',
                               `student_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学号/师号',
                               `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
                               `academy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所属院校',
                               `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '专业',
                               `class_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '班级',
                               `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
                               `wechat` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '微信号',
                               `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'QQ号',
                               `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
                               `mailbox` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电子邮箱',
                               `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户导入表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of excle_user
-- ----------------------------
INSERT INTO `excle_user` VALUES (1, '学生', '11112', '柳成林', '东北大学', '软件', '202', '男', '1321u3h290', '1347182921', '153122184721', '2947140558@qq.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (2, '学生', '11113', 'qaq', '东北大学', '计算机', '212', '女', '1242516tua', '1726173', '15198231938', '2947140558@qq.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (4, '老师', '11114', 'yyy', '东北大学', '计算机网络', '202', '男', '1321u3h290', '1347182921', '153122184721', 'yyy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (5, '学生', '11115', 'qaq', '东北大学', '计算机', '212', '女', '1242516tua', '1726173', '15198231938', 'yuqy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (6, '学生', '11116', 'qaq', '东北大学', '计算机', '212', '女', '1242516tua', '1726173', '15198231938', 'yuqy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (7, '老师', '11117', 'yyy', '东北大学', '计算机网络', '202', '男', '1321u3h290', '1347182921', '153122184721', 'yyy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (8, '学生', '11118', 'qaq', '东北大学', '计算机', '212', '女', '1242516tua', '1726173', '15198231938', 'yuqy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (9, '学生', '11119', 'qaq', '东北大学', '计算机', '212', '女', '1242516tua', '1726173', '15198231938', 'yuqy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (10, '老师', '11120', 'yyy', '东北大学', '计算机网络', '202', '男', '1321u3h290', '1347182921', '153122184721', 'yyy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (11, '学生', '11121', 'qaq', '东北大学', '计算机', '212', '女', '1242516tua', '1726173', '15198231938', 'yuqy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (12, '学生', '11122', 'qaq', '东北大学', '计算机', '212', '女', '1242516tua', '1726173', '15198231938', 'yuqy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (13, '学生', '11123', 'qaq', '东北大学', '计算机', '212', '女', '1242516tua', '1726173', '15198231938', 'yuqy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (14, '学生', '11124', 'qaq', '东北大学', '计算机', '212', '女', '1242516tua', '1726173', '15198231938', 'yuqy@163.com', '2022-06-30 00:11:20');
INSERT INTO `excle_user` VALUES (15, '老师1112', '11125', 'yyy', '东北大学', '计算机网络', '20211', '男', '1321u3h290', '1347182921', '153122184721', 'yyy@163.com', '2022-06-30 00:17:07');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
                            `id` varchar(255) NOT NULL ,
                            `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户id',
                            `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '项目名称',
                            `project_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '项目内容',
                            `created_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
                            `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人名称',
                            `creation_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                            `last_updated_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人id',
                            `last_updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人名称',
                            `last_update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
                            `is_delete` int(2) NULL DEFAULT 0 COMMENT '是否删除（0未删除1已删除）',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '项目组' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '1', '一个新的项目名称', '项目描述', '1', 'admin', '2022-06-07 18:30:06', NULL, NULL, NULL, 0);
INSERT INTO `project` VALUES (2, '1', '一个新的测试项目', '项目描述', '1', 'admin', '2022-06-07 18:44:56', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire`  (
                                  `id` varchar(255) NOT NULL  COMMENT 'id',
                                  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户id',
                                  `project_id` varchar(255) NULL DEFAULT NULL COMMENT '项目id',
                                  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '项目名称',
                                  `inquiry_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '调查类型',
                                  `inquiry_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '调查名称',
                                  `inquiry_explain` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '调查说明',
                                  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
                                  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
                                  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人昵称',
                                  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                  `update_user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人',
                                  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
                                  `is_delete` int(11) NULL DEFAULT 0 COMMENT '是否删除（0未删除1已删除）',
                                  `is_start` int(11) NULL DEFAULT 0 COMMENT '是否启动（0是1否）',
                                  `answer_number` int(11) NULL DEFAULT 0 COMMENT '答卷数量',
                                  `click_number` int(11) NULL DEFAULT 0 COMMENT '点击量',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '问卷表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questionnaire
-- ----------------------------
INSERT INTO `questionnaire` VALUES (1, '1', 1, '一个新的项目名称', '', '调查名称1', '一个调查说明1111', '2022-06-03 18:30:00', '2022-06-17 18:30:00', 'admin', '2022-06-07 18:32:26', 'admin', '2022-06-07 18:32:48', 0, 0, 1, 1);
INSERT INTO `questionnaire` VALUES (2, '1', 1, '一个新的项目名称', '', '创建一个导入的问卷手动编辑', '调查说明11', '2022-06-07 18:36:00', '2022-06-12 18:36:00', 'admin', '2022-06-07 18:37:06', 'admin', '2022-06-07 18:37:31', 0, 0, 1, 1);
INSERT INTO `questionnaire` VALUES (3, '1', 2, '一个新的测试项目', '', '一个新的调查问卷', '调查说明', '2022-06-07 18:45:00', '2022-06-09 18:45:00', 'admin', '2022-06-07 18:46:57', 'admin', '2022-06-07 18:47:22', 0, 0, 1, 1);
INSERT INTO `questionnaire` VALUES (4, '1', 2, '一个新的测试项目', '', '测试一个导入模板', '调查说明', '2022-06-07 18:48:00', '2022-06-18 18:48:00', 'admin', '2022-06-07 18:48:32', 'admin', '2022-06-07 18:48:49', 0, 0, 1, 2);
INSERT INTO `questionnaire` VALUES (5, '1', 2, '一个新的测试项目', '', '1111', '111', '2022-06-10 00:10:00', '2022-06-25 00:10:00', 'admin', '2022-06-08 00:12:20', NULL, NULL, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for questionnaire_answer
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire_answer`;
CREATE TABLE `questionnaire_answer`  (
                                         `id` varchar(255) NOT NULL  COMMENT 'id',
                                         `questionnaire_id` varchar(255) NULL DEFAULT NULL COMMENT '问卷id',
                                         `question_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问卷标题',
                                         `question_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问卷说明',
                                         `response_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '答题时间',
                                         `create_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
                                         `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '提交ip',
                                         `answer` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '问题回答',
                                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '问卷回答表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questionnaire_answer
-- ----------------------------
INSERT INTO `questionnaire_answer` VALUES (1, 1, '问卷标题', '添加问卷说明', NULL, '2022-06-07 18:36:05', '114.253.168.117', '[\"yyy\",\"1\",\"0\",\"0\",\"1\"]');
INSERT INTO `questionnaire_answer` VALUES (2, 2, '问卷标题', '添加问卷说明', NULL, '2022-06-07 18:37:52', '114.253.168.117', '[\"2222\",\"0\",\"0\",\"2\"]');
INSERT INTO `questionnaire_answer` VALUES (3, 3, '问卷标题', '添加问卷说明', NULL, '2022-06-07 18:47:47', '114.253.168.117', '[\"yyy\",\"0\",\"0&1&2\",\"0\",\"3\"]');
INSERT INTO `questionnaire_answer` VALUES (4, 4, '问卷标题', '添加问卷说明', NULL, '2022-06-07 18:49:08', '114.253.168.117', '[\"qqq\",\"0\",\"0\",\"0\"]');

-- ----------------------------
-- Table structure for questionnaire_issue
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire_issue`;
CREATE TABLE `questionnaire_issue`  (
                                        `id` varchar(255) NOT NULL  COMMENT 'id',
                                        `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户id',
                                        `questionnaire_id` varchar(255) NULL DEFAULT NULL COMMENT '所属问卷',
                                        `question_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问卷标题',
                                        `question_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问卷说明',
                                        `question_list` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '问卷问题',
                                        `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                        `is_delete` int(2) NULL DEFAULT 0 COMMENT '是否删除（0未删除，1已删除）',
                                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '问卷问题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questionnaire_issue
-- ----------------------------
INSERT INTO `questionnaire_issue` VALUES (1, '1', 1, '问卷标题', '添加问卷说明', '[{\"questionType\":\"2\",\"questionTitle\":\"请输入姓名\",\"questionOption\":[],\"important\":\"必答题\"},{\"questionType\":\"1\",\"questionTitle\":\"请选择兴趣爱好\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"游戏\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"音乐\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"读书\",\"optionGrade\":\"\"}],\"important\":\"必答题\"},{\"questionType\":\"0\",\"questionTitle\":\"请选择性别\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"男\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"女\",\"optionGrade\":\"\"}],\"important\":\"必答题\"},{\"questionType\":\"3\",\"questionTitle\":\"请选择年级\",\"questionOption\":[{\"lineTitle\":\"您现在所在的年级是\",\"optionWord\":\"大一\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"大二\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"大三\",\"optionGrade\":\"\"}],\"important\":\"必答题\"},{\"questionType\":\"4\",\"questionTitle\":\"请给我们进行评分\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"4\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"3\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"2\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"\",\"optionGrade\":\"\"}],\"important\":\"必答题\"}]', '2022-06-07 18:32:00', 0);
INSERT INTO `questionnaire_issue` VALUES (2, '1', 2, '问卷标题', '添加问卷说明', '[{\"questionType\":\"2\",\"questionTitle\":\"请输入姓名\",\"questionOption\":[],\"important\":\"必答题\"},{\"questionType\":\"1\",\"questionTitle\":\"请选择兴趣爱好\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"游戏\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"音乐\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"读书\",\"optionGrade\":\"\"}],\"important\":\"必答题\"},{\"questionType\":\"0\",\"questionTitle\":\"请选择性别\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"男\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"女\",\"optionGrade\":\"\"}],\"important\":\"必答题\"},{\"questionType\":\"4\",\"questionTitle\":\"请给我们进行评分\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"4\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"3\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"2\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"\",\"optionGrade\":\"\"}],\"important\":\"必答题\"}]', '2022-06-07 18:32:00', 0);
INSERT INTO `questionnaire_issue` VALUES (3, '1', 3, '问卷标题', '添加问卷说明', '[{\"questionType\":\"2\",\"questionTitle\":\"请输入姓名\",\"questionOption\":[],\"important\":\"必答题\"},{\"questionType\":\"0\",\"questionTitle\":\"请选择性别\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"男\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"女\",\"optionGrade\":\"\"}],\"important\":\"必答题\"},{\"questionType\":\"1\",\"questionTitle\":\"请选择兴趣爱好\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"读书\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"画画\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"游戏\",\"optionGrade\":\"\"}],\"important\":\"必答题\"},{\"questionType\":\"3\",\"questionTitle\":\"请选择年级\",\"questionOption\":[{\"lineTitle\":\"请选择\",\"optionWord\":\"大一\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"大二\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"大三\",\"optionGrade\":\"\"}],\"important\":\"必答题\"},{\"questionType\":\"4\",\"questionTitle\":\"请给我们评分\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"4\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"3\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"2\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"1\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"\",\"optionGrade\":\"\"}],\"important\":\"必答题\"}]', '2022-06-07 18:46:00', 0);
INSERT INTO `questionnaire_issue` VALUES (4, '1', 4, '问卷标题', '添加问卷说明', '[{\"questionType\":\"2\",\"questionTitle\":\"请输入姓名\",\"questionOption\":[],\"important\":\"必答题\"},{\"questionType\":\"0\",\"questionTitle\":\"请选择性别\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"男\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"女\",\"optionGrade\":\"\"}],\"important\":\"必答题\"},{\"questionType\":\"1\",\"questionTitle\":\"请选择兴趣爱好\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"读书\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"画画\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"游戏\",\"optionGrade\":\"\"}],\"important\":\"必答题\"},{\"questionType\":\"3\",\"questionTitle\":\"请选择年级\",\"questionOption\":[{\"lineTitle\":\"请选择\",\"optionWord\":\"大一\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"大二\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"大三\",\"optionGrade\":\"\"}],\"important\":\"必答题\"}]', '2022-06-07 18:46:00', 0);
INSERT INTO `questionnaire_issue` VALUES (5, '1', 5, '问卷标题', '添加问卷说明', '[{\"questionType\":\"0\",\"questionTitle\":\"111\",\"questionOption\":[{\"lineTitle\":\"\",\"optionWord\":\"必答题11\",\"optionGrade\":\"\"},{\"lineTitle\":\"\",\"optionWord\":\"11\",\"optionGrade\":\"\"}],\"important\":\"必答题\"}]', '2022-06-08 00:12:20', 0);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
                              `id` varchar(255) NOT NULL ,
                              `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
                              `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
                              `roleId` int(11) NULL DEFAULT NULL COMMENT '角色id',
                              `start_time` datetime(0) NULL DEFAULT NULL,
                              `stop_time` datetime(0) NULL DEFAULT NULL,
                              `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '状态',
                              `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                              `creation_date` datetime(0) NULL DEFAULT NULL,
                              `last_updated_by` varchar(255) NULL DEFAULT NULL,
                              `last_update_date` datetime(0) NULL DEFAULT NULL,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', 'admin', 1, NULL, NULL, '1', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
