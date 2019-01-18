-- --------------------------------------------------------
-- tabela forum_topics

CREATE TABLE IF NOT EXISTS `forum_topics` (
  `topicId` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `topicName` varchar(50) NOT NULL,
  `topicContent` text NOT NULL,
  `topicAuthor` varchar(30) NOT NULL,
  `topicCreateDate` date NOT NULL
);

-- forum_topics content

INSERT INTO `forum_topics` (`topicName`, `topicContent`, `topicAuthor`, `topicCreateDate`) VALUES
	('First test topic', 'Pierwszy temat na forum', 'Admin', NOW()),
	('Second test topic', 'Drugi testowy temat', 'Admin', NOW());

-- --------------------------------------------------------

-- tabela forum_posts

CREATE TABLE IF NOT EXISTS `forum_posts` (
  `postId` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `postTopicId` int(32) NOT NULL,
  `postContent` text NOT NULL,
  `postAuthor` varchar(30) NOT NULL,
  `postCreateDate` date NOT NULL
);

-- forum_posts content

INSERT INTO `forum_posts` (`postTopicId`, `postContent`,`postAuthor`, `postCreateDate`) VALUES
(1, 'Pierwszy post w pierwszym temacie', 'Uzyszkodnik', NOW()),
(2, 'Drugi post w drugim temacie', 'NowyNick', NOW()),
(1, 'Trzeci post w pierwszym temacie', 'Nieznajomy', NOW());

-- --------------------------------------------------------