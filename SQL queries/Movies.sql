CREATE SCHEMA `movies`;

CREATE TABLE `directors`(`id` INT PRIMARY KEY,
`director_name` VARCHAR(40) NOT NULL,
`notes` TEXT);
INSERT INTO `directors` (`id`,`director_name`, `notes`) VALUES ('1','Kevin', 'HACKER');
INSERT INTO `directors` (`id`,`director_name`, `notes`) VALUES ('2','Kevin2', 'HAC123KER');
INSERT INTO `directors` (`id`,`director_name`, `notes`) VALUES ('3','Kevin3', 'HAC454KER');
INSERT INTO `directors` (`id`,`director_name`, `notes`) VALUES ('4','Kevin4', 'HACKasrER');
INSERT INTO `directors` (`id`,`director_name`, `notes`) VALUES ('5','Kevin5', 'HACasrKER');

CREATE TABLE `generes`(`id` INT PRIMARY KEY,
`genre_name` VARCHAR(40) NOT NULL,
`notes` TEXT);
INSERT INTO `generes` (`id`,`genre_name`, `notes`) VALUES ('1','SAUCsdEkid', 'gang');
INSERT INTO `generes` (`id`,`genre_name`, `notes`) VALUES ('2','SAsdUCEkid', 'gang2');
INSERT INTO `generes` (`id`,`genre_name`, `notes`) VALUES ('3','SUCEkid', 'gang3');
INSERT INTO `generes` (`id`,`genre_name`, `notes`) VALUES ('4','SAUCsdEkid', 'gang4');
INSERT INTO `generes` (`id`,`genre_name`, `notes`) VALUES ('5','SaaAUCEkid', 'gang5');

CREATE TABLE `categories`(`id` INT PRIMARY KEY,
`category_name` VARCHAR(40) NOT NULL,
`notes` TEXT);
INSERT INTO `categories` (`id`,`category_name`, `notes`) VALUES ('1', 'drama', 'albablabal');
INSERT INTO `categories` (`id`,`category_name`, `notes`) VALUES ('2', 'horror', 'albabla3213bal');
INSERT INTO `categories` (`id`,`category_name`, `notes`) VALUES ('3', 'comedy', 'albabl455abal');
INSERT INTO `categories` (`id`,`category_name`, `notes`) VALUES ('4', 'fun', 'al5babl555abal');
INSERT INTO `categories` (`id`, `category_name`, `notes`) VALUES ('5', 'love', 'alba5543blabal');

CREATE TABLE `movies`(`id` INT PRIMARY KEY,
`title` VARCHAR(40) NOT NULL,
`director_id` INT,
`copyright_year` YEAR,
`length` TIME,
`genre_id` INT,
`category_id`INT,
`raiting` DOUBLE(3, 2),
`notes` TEXT);
INSERT INTO `movies` (`id`,`title`, `copyright_year`, `length`, `raiting`, `notes`) VALUES ('1','Huse keehp', 2004, '03:00:13', '7.23', 'asdsasd');
INSERT INTO `movies` (`id`,`title`, `copyright_year`, `length`, `raiting`, `notes`) VALUES ('2','Huse keeip', 2005, '07:00:13', '8.23', 'asdsaasd');
INSERT INTO `movies` (`id`,`title`, `copyright_year`, `length`, `raiting`, `notes`) VALUES ('3','Huse keedp', 2006, '08:00:13', '9.23', 'asdddasd');
INSERT INTO `movies` (`id`,`title`, `copyright_year`, `length`, `raiting`, `notes`) VALUES ('4','Huse keeap', 2007, '01:00:13', '2.23', 'asdggasd');
INSERT INTO `movies` (`id`,`title`, `copyright_year`, `length`, `raiting`, `notes`) VALUES ('5','Huse keesp', 2008, '02:00:13', '3.23', 'asdfdasd');





