-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- ホスト: 127.0.0.1
-- 生成日時: 2021-11-18 03:49:46
-- サーバのバージョン： 10.4.19-MariaDB
-- PHP のバージョン: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- データベース: `quiz`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `answertime`
--

CREATE TABLE `answertime` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `answerTime` varchar(20) NOT NULL,
  `time` varchar(20) DEFAULT NULL,
  `quizName` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `answertime`
--

INSERT INTO `answertime` (`id`, `userid`, `answerTime`, `time`, `quizName`) VALUES
(1, 2, '5804', NULL, NULL),
(2, 1, '20', NULL, NULL),
(3, 2, '2', NULL, NULL),
(4, 2, '5', NULL, NULL),
(5, 2, '4', NULL, NULL),
(6, 2, '2', NULL, NULL),
(7, 2, '3', NULL, NULL),
(8, 2, '3', '2021-11-16', NULL),
(9, 2, '3', '2021-11-16', '栃木クイズ'),
(10, 2, '2', '2021-11-16', '栃木クイズ'),
(11, 2, '2', '2021-11-16', '栃木クイズ'),
(12, 2, '2', '2021-11-16', '栃木クイズ'),
(13, 2, '3', '2021-11-16', '雑学クイズ２'),
(14, 2, '1159', '2021-11-17', '栃木クイズ'),
(15, 2, '159', '2021-11-17', '栃木クイズ'),
(16, 2, '133', '2021-11-18', '栃木クイズ'),
(17, 2, '133', '2021-11-18', '栃木クイズ'),
(18, 2, '302', '2021-11-18', '栃木クイズ'),
(19, 2, '5', '2021-11-18', '雑学クイズ３'),
(20, 2, '5', '2021-11-18', '雑学クイズ３'),
(21, 2, '2', '2021-11-18', '雑学クイズ３'),
(22, 2, '1', '2021-11-18', '雑学クイズ３');

-- --------------------------------------------------------

--
-- テーブルの構造 `inqueryform`
--

CREATE TABLE `inqueryform` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `accountname` varchar(20) NOT NULL,
  `mailaddress` varchar(30) NOT NULL,
  `query` varchar(500) NOT NULL,
  `reply` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `inqueryform`
--

INSERT INTO `inqueryform` (`id`, `userid`, `accountname`, `mailaddress`, `query`, `reply`) VALUES
(1, 0, 'momose', 'aaa@aaa', 'momose', NULL),
(2, 2, 'momose', 'aaa@aaa', 'momose', '試し'),
(3, 2, 'momose', 'aaa@aaa', 'qqqqqqqqqq', 'mmmmmmmmmmmmmmmmm'),
(4, 2, 'momose', 'aaaa@ppppp', '試しーーーーーー', NULL);

-- --------------------------------------------------------

--
-- テーブルの構造 `quiz`
--

CREATE TABLE `quiz` (
  `id` int(11) NOT NULL,
  `question` varchar(100) NOT NULL,
  `answer` int(1) NOT NULL,
  `selection1` varchar(100) NOT NULL,
  `selection2` varchar(100) NOT NULL,
  `selection3` varchar(100) NOT NULL,
  `selection4` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `quiz`
--

INSERT INTO `quiz` (`id`, `question`, `answer`, `selection1`, `selection2`, `selection3`, `selection4`) VALUES
(1, '栃木県の県庁所在地は？', 1, '宇都宮市', '小山市', '鹿沼市', '栃木市'),
(2, '栃木県で最も有名な農産物は？', 1, 'かんぴょう', 'さとう', '木材', 'サトウキビ'),
(3, '栃木県で有名な果物は？', 4, 'なし', 'みかん', 'ぶどう', 'いちご'),
(4, '栃木県の人口はおおよそ何人？', 1, '１９５万人', '１０００万人', '５００万人', '３６５万人'),
(5, '栃木県にある国立公園の名前は？', 2, '益子国立公園', '日光国立公園', '足利国立公園', '宇都宮国立公園'),
(6, '栃木県に下野市というのがあるがなんと読むか？', 3, 'したのし', 'げやのし', 'しもつけし', 'しものし'),
(7, '栃木県の所在地は？', 3, '東北地方', '中部地方', '関東地方', '近畿地方'),
(8, '２００８年度の栃木県の県民総生産額はいくら？', 4, '１兆９９０１億円', '３兆９９０１億円', '５兆９９０１億円', '７兆９９０１億円'),
(9, '栃木県の伝統工芸は？', 2, '南部鉄器', '結城紬、益子焼', '伊勢崎餅、桐生織', '房州うちわ'),
(10, '栃木県で国宝（建造物）として有名なものは？', 3, '中尊寺金色堂', '正福寺地蔵堂', '日光東照宮', '羽黒山五重塔');

-- --------------------------------------------------------

--
-- テーブルの構造 `quiz2`
--

CREATE TABLE `quiz2` (
  `id` int(11) NOT NULL,
  `question` varchar(100) NOT NULL,
  `answer` int(1) NOT NULL,
  `selection1` varchar(100) NOT NULL,
  `selection2` varchar(100) NOT NULL,
  `selection3` varchar(100) NOT NULL,
  `selection4` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `quiz2`
--

INSERT INTO `quiz2` (`id`, `question`, `answer`, `selection1`, `selection2`, `selection3`, `selection4`) VALUES
(0, 'ピカチュウは何ポケモン？', 1, 'ねずみポケモン', 'いぬポケモン', 'たぬきポケモン', 'きつねポケモン'),
(1, 'ドラえもんの好物は？', 2, 'やきいも\r\n', 'どらやき', 'プリン', 'すなぎも'),
(2, 'ドイツの首都の名前は？', 1, 'ベルリン', 'ハンブルク', 'ノイケルン', 'ミュンヘン'),
(3, '宮城県の仙台市に無い区はどれ？', 4, '宮城野区', '太白区', '若林区', '宇治区'),
(4, 'ムーミンの原作となった国の名前はどれ？', 4, 'イギリス', 'ロシア', 'スイス', 'フィンランド'),
(5, 'バイクの故障率が低い日本のメーカーは？', 1, 'YAMAHA', 'SUZUKI', 'HONDA', 'KAWASAKI'),
(6, '１万円の原価いくら？', 2, '１１円', '２２円', '３３円', '４４円'),
(7, 'オランダの公用語はどれ？', 3, '英語', 'フランス語', 'オランダ語', 'イタリア語'),
(8, 'お酢に卵を殻ごと入れるとどうなる？', 4, '変わらない', '溶けて崩れる', '石のように固くなる', '透明になる。'),
(9, '木魚をたたく意味はなに？', 3, 'リズムをつけるため', '天国に行けるように祈るため', '眠くならないようにするため', '悪霊を寄せ付けないようにするため'),
(10, '植物にも人間と同じようにあるものはどれ？', 1, '血液型', '心臓', '髪の毛', '脳みそ'),
(11, '一番人気の寿司ネタはどれ？', 2, 'マグロ', 'サーモン', 'いくら', 'えび'),
(12, '磁石を加熱するとどうなる？', 4, '磁力が強くなる', '変形する', '崩れる', '磁力が弱くなる'),
(13, 'ヨーロッパの貴族が銀のスプーンを使っていた理由はどれ？', 3, '貴金属だから', '綺麗な輝きがあるから', '経済力をアピールするため', '健康を維持するため'),
(14, 'アップルの創設者の名前はなに？', 1, 'スティーブ・ジョブス', 'スティーブン・ジョブス', 'ステーブン・ジョブス', 'スティーベン・ジョブス'),
(15, '愛知県は何地方？', 4, '関東地方', '中国地方', '四国地方', '中部地方'),
(16, 'マクドナルドの人気メニューはどれ？', 2, 'マックシェイク', 'ポテト', 'ナゲット', 'チーズバーガー'),
(17, '麻雀の国士無双の由来の人物はどれ？', 1, '韓信', '劉邦', '項羽', '劉璋'),
(18, '砂糖の原材料ではないものはどれ？', 1, 'ハクサイ', 'サトウキビ', 'テンサイ', 'サトウカエデ'),
(19, 'ナトリウムの炎色反応は何色？', 2, '赤色', '黄色', '緑色', '紫色');

-- --------------------------------------------------------

--
-- テーブルの構造 `quiz3`
--

CREATE TABLE `quiz3` (
  `id` int(11) NOT NULL,
  `question` varchar(100) NOT NULL,
  `answer` int(1) NOT NULL,
  `selection1` varchar(100) NOT NULL,
  `selection2` varchar(100) NOT NULL,
  `selection3` varchar(100) NOT NULL,
  `selection4` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `quiz3`
--

INSERT INTO `quiz3` (`id`, `question`, `answer`, `selection1`, `selection2`, `selection3`, `selection4`) VALUES
(0, 'インターネットの検索ツールで有名なグーグル、グーグルの創設者の名前はどれ？', 2, 'ビル・ゲイツ', 'ラリー・ペイジ', 'ヴィタリック・ブリテン', 'サンダー・ピチャイ'),
(1, 'STGFOPは何の専門用語？', 4, 'トウモロコシ', 'コンピューター', 'お酒', '紅茶'),
(2, '世界一深いプールでギネス認定されたプールの深さは何メートル？', 3, '20メートル', '40メートル', '60メートル', '80メートル'),
(3, '兎に角（とにかく）という当て字の由来となった作家はどれ？', 1, '夏目漱石', '芥川龍之介', '森鷗外', '宮沢賢治'),
(4, 'チューリップの花言葉はどれ？', 4, '恋', '謙虚', '純粋', '思いやり'),
(5, '淡水魚を生食してはいけない理由はどれ？', 1, '寄生虫', '血液に毒', '法律', 'バクテリア'),
(6, 'ココアで有名なヴァン・ホーテンの出身国はどこ？', 2, 'イタリア', 'オランダ', 'マカオ', 'ギリシャ'),
(7, 'マーク・ザッカーバーグがFacebookを立ち上げたのは西暦何年か？', 3, '2000年', '2002年', '2004年', '2006年');

-- --------------------------------------------------------

--
-- テーブルの構造 `quiz4`
--

CREATE TABLE `quiz4` (
  `id` int(11) NOT NULL,
  `question` varchar(100) NOT NULL,
  `answer` int(1) NOT NULL,
  `selection1` varchar(100) NOT NULL,
  `selection2` varchar(100) NOT NULL,
  `selection3` varchar(100) NOT NULL,
  `selection4` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `quiz4`
--

INSERT INTO `quiz4` (`id`, `question`, `answer`, `selection1`, `selection2`, `selection3`, `selection4`) VALUES
(1, 'What is the meaning of Australia?\r\n', 4, 'North land', 'East land\r\n', 'West land', 'South land\r\n'),
(2, 'What caused the \'De Havilland COMET\' to be grounded?\r\n', 3, 'the engines constantly flamed out', 'they were too costly to operate\r\n', 'they broke apart at altitude', 'the metal that they were made from had a tendency to corrode\r\n'),
(3, 'Until 2011, where were all the Airbus A-320s assembled?\r\n', 3, 'Madrid, Spain', 'Montreal, Canada', 'Toulouse, France', 'Seattle, USA'),
(4, 'From 1976 until 2003, this was not only the FASTEST commercial airliner, but also the HIGHEST flying', 4, 'B-747', 'SAAB-340', 'Cessna 152', 'BAE-Concorde'),
(5, 'How many wheels are on a Boeing 747?\r\n', 3, '14', '12', '18', '16'),
(6, 'What does \'EPR\' stand for in regards to Gas Turbine Engines?', 1, 'engine pressure ratio', 'engine performance rating', 'exceeded power range', 'extreme pressure reserve'),
(7, 'On some commercial airliners, a three man crew was used. The captain or pilot, the first officer or ', 3, 'bombardier', 'boom operator', 'flight engineer\r\n', 'radio operator'),
(8, 'HND(RJTT) and NRT(RJAA) both service one of the world\'s major cities. Which city is it?', 4, 'Osaka', 'Utsunomiya', 'Chiba', 'Tokyo');

-- --------------------------------------------------------

--
-- テーブルの構造 `thenumberofcorrectanswer`
--

CREATE TABLE `thenumberofcorrectanswer` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `correctNumber` varchar(11) NOT NULL,
  `quizName` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `thenumberofcorrectanswer`
--

INSERT INTO `thenumberofcorrectanswer` (`id`, `userId`, `correctNumber`, `quizName`) VALUES
(1, 1, '８／１０', NULL),
(2, 2, '６／１０', NULL),
(3, 2, '3/10', NULL),
(4, 2, '3/10', NULL),
(5, 2, '3/10', NULL),
(6, 2, '3/10', NULL),
(7, 2, '3/10', NULL),
(8, 2, '3/10', NULL),
(9, 2, '3/10', '栃木クイズ'),
(10, 2, '3/10', '栃木クイズ'),
(11, 2, '3/10', '栃木クイズ'),
(12, 2, '3/10', '栃木クイズ'),
(13, 2, '7/20', '雑学クイズ２'),
(14, 2, '3/10', '栃木クイズ'),
(15, 2, '3/10', '栃木クイズ'),
(16, 2, '3/10', '栃木クイズ'),
(17, 2, '3/10', '栃木クイズ'),
(18, 2, '3/10', '栃木クイズ'),
(19, 2, '3/8', '雑学クイズ３'),
(20, 2, '3/8', '雑学クイズ３'),
(21, 2, '2/8', '雑学クイズ３'),
(22, 2, '2/8', '雑学クイズ３');

-- --------------------------------------------------------

--
-- テーブルの構造 `usertable`
--

CREATE TABLE `usertable` (
  `id` int(11) NOT NULL,
  `accountname` varchar(100) DEFAULT NULL,
  `passwordByteString` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `usertable`
--

INSERT INTO `usertable` (`id`, `accountname`, `passwordByteString`) VALUES
(1, 'admin', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b'),
(2, 'momose', '599be0513f5e68e2599c926d9e3e11507ba366532ed24f1557be4d07fc5e5491'),
(6, 'gg', 'cbd3cfb9b9f51bbbfbf08759e243f5b3519cbf6ecc219ee95fe7c667e32c0a8d'),
(7, 'hh', '72b289ec78e0a928c565480a435453e30acb92eddb3b78ff168b28737cf6a849');

--
-- ダンプしたテーブルのインデックス
--

--
-- テーブルのインデックス `answertime`
--
ALTER TABLE `answertime`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `inqueryform`
--
ALTER TABLE `inqueryform`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `quiz2`
--
ALTER TABLE `quiz2`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `quiz3`
--
ALTER TABLE `quiz3`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `quiz4`
--
ALTER TABLE `quiz4`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `thenumberofcorrectanswer`
--
ALTER TABLE `thenumberofcorrectanswer`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `usertable`
--
ALTER TABLE `usertable`
  ADD PRIMARY KEY (`id`);

--
-- ダンプしたテーブルの AUTO_INCREMENT
--

--
-- テーブルの AUTO_INCREMENT `answertime`
--
ALTER TABLE `answertime`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- テーブルの AUTO_INCREMENT `inqueryform`
--
ALTER TABLE `inqueryform`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- テーブルの AUTO_INCREMENT `thenumberofcorrectanswer`
--
ALTER TABLE `thenumberofcorrectanswer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- テーブルの AUTO_INCREMENT `usertable`
--
ALTER TABLE `usertable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
