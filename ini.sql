/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.25 : Database - bf
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

SET GLOBAL FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS bf;
CREATE DATABASE bf;

USE bf;

/*Table structure for table `article` */

CREATE TABLE `article` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_id` int NOT NULL,
  `user_id` int NOT NULL,
  `follow` int DEFAULT '0',
  `title` varchar(50) NOT NULL,
  `date` varchar(50) DEFAULT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE,
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

/*Data for the table `article` */

insert  into `article`(`id`,`book_id`,`user_id`,`follow`,`title`,`date`,`content`) values 
(1,3,1,1,'走出唯一真理观','2021-06-06','在阅读这位肤浅而喜欢说教的教授所作的几篇毫无层次和亮点的文章时，我看到了这句话：“如果我努力回忆自己在学习社会学之前是否产生了阶级意识，我几乎回忆不起来，而这并不是因为年代久远导致的记忆模糊；换句话说，我不认为现代社会的每一个成员都一定认为自己从属于社会之中某个既定的，被称为阶级的群体。社会阶层无疑客观存在，但阶级成员的阶级意识并不一定存在。\n    我认为资产阶级出身的儿童缺乏阶级归属意识是可能的。统治阶级意识不到自己属于某个特定群体（就如同白人不能意识到自己属于白人群体，异性恋不能意识到自己属于异性恋群体）。因而，这段评论也展示出它的真实面貌：属于特权阶级的作者天真地承认自己在接触社会学之前没有阶级意识，而这件事本身恰恰展示了他的社会身份。我只见过这位人物一面见到他后我立刻觉得反感。我讨厌他虚伪的笑容和柔和的声音，他用这种方式展示着自己的沉着、理性，但归根结底无非是展示着他作为资产阶级所拥有的丰厚的物质条件和成熟稳重的思维方式。'),
(2,3,1,1,'三虎桥阿娇米线','2021-06-06','我们并非所有时候都能把真诚与被迫、主动和被动分得清清楚楚。有时候，我被胁迫去做一件事，我讨厌人家胁迫我，我恨别人胁迫我，但在适当的条件下，我也许会让自己觉得，其实我不是被胁迫的，我是自愿去做的。不说别的，这里涉及我的自尊，自愿去做一件事情比较多一点尊严，被人胁迫去做一件事情，尊严就少一点。我不想再在这个方向上分析下去了，人性中有很多让人不忍深思的东西。'),
(3,4,1,0,'黄昏','2021-06-06`comments`','山下的村庄，在天黑前后，异常安静。直到天黑透，路灯亮了，才又听见小孩的嘶喊声。本培说，这村里有个说法，说是人不能在外面看着天慢慢变黑，否则小孩不会念书，大人没心思干活。我记起小时候似乎也听奶奶说过类似的话。山区里，古时山路阻隔，往往两村之间口音风俗都有所差异，但毕竟同在一县，相似处还是较多。为什么会有这种说法呢？天黑透了却不忌讳，小孩一样玩要，大人出来乘凉。忌讳的是由黄昏转入黑夜的那一小会。也许那时辰阴阳未定，野外有什么鬼魅出没？我想象在黄昏和黑夜的边界，有一条极窄的缝隙，另一个世界的阴风从那里刮过来。坐了几个黄昏，我似有点明白了。有种消沉的力量，一种广大的消沉，在黄昏时来。在那个时刻，事物的意义在散。在一点一点黑下来的天空中，什么都显得无关紧要。你先是有点慌，然后释然，然后你就不存在了。那种感受，没有亲身体验，实在难于形容。如果你在山野中，在暮色四合时凝望过一棵树，足够长久地凝望一棵，直到你和它一并消融在黑暗中，成为夜的部分一一这种体验，经过多次，你就会无可挽回地成为个古怪的人。对什么都心不在焉，游离于现实之外。本地有个说法，叫心野掉了。心野掉了就念不进书，就没心思干活，就只适合日复一日地坐在野地里发呆，在黄昏和夜晚的缝隙中一次又一次地消融。你就很难再回到真实的人世间，捡起上进心，努力去做一个世俗的成功者了。因为你已经知道了，在山野中，在天一点一点黑下来的时刻，一切都无关紧要。知道了就没法再不知道。'),
(4,6,1,0,'唯爱与自由为毕生所求','2021-06-06','本培说，这村里有个说法，说是人不能在外面看着天慢慢变黑，否则小孩不会念书，大人没心思干活。我记起小时候似乎也听奶奶说过类似的话。山区里，古时山路阻隔，往往两村之间口音风俗都有所差异，但毕竟同在一县，相似处还是较多。为什么会有这种说法呢？天黑透了却不忌讳，小孩一样玩耍，大人出来乘凉。忌讳的是由黄昏转入黑夜的那一小会也许那时辰阴阳未定，野外有什么鬼魅出没？我想象在黄昏和黑夜的边界，有一条极窄的缝隙，另一个世界的阴风从那里刮过来。坐了几个黄昏，我似乎有点明白了。有种消沉的力量，一种广大的消沉，在黄昏时来。在那个时刻，事物的意义在飘散。在一点一点黑下来的天空中，什么都显得无关紧要。你先是有点慌，然后释然，然后你就不存在了。那种感受，没有亲身体验，实在难于形容。如果你在山野中，在暮色四合时凝望过一棵树，足够长久地凝望一棵树，直到你和它一并消融在黑暗中，成为夜的部分一一这种体验，经过多次，你就会无可挽回地成为一个古怪的人。对什么都心不在焉，游离于现实之外。本地有个说法，叫心野掉了。心野掉了就念不进书，就没心思干活，就只适合日复一日地坐在野地里发呆，在黄昏和夜晚的缝隙中一次又一次地消融。你就很难再回到真实的人世间，捡起上进心，努力去做一个世俗的成功者了。因为你已经知道了，在山野中，在天一点一点黑下来的时刻，一切都无关紧要。知道了就没法再不知道。'),
(5,9,1,0,'推荐一本书','2021-06-06','出于一些个人原因，我不太喜欢陈春成老师。这本书在首页刷屏，我原本不打算买；有一天，没忍住买了。书到了，放在桌上搁置了几天。30号那天带去公司看，一上午没有上班，一口气看到一半。1号回家，再用一下午看完了。看完了，就明白为什么首页那些从事文字工作的友邻会略带悲凉的酸意转发，说“写得真好。”这种事情就是，我也不想说别的了，因为看完之后，我对陈老师的不喜欢也没有什么改观，所以对于他洞悉一切幽微联系的作品，我也很遗憾没有什么心情去做精细的评价。我大概只能含着羞愤说，真TM写得好，篇篇都好，装帧也好，连作者简介，封底摘录，都他妈的好得戳我心窝子，靠！！！'),
(6,6,1,0,'他在幻想的羊水中写作','2021-06-06','去年夏天，我读到了《音乐家》。读完最后一个字，我想，如果这个叫做陈春成的陌生人能出小说集，我得为他写点什么。这种急迫乃至草率的欲望，出于什么？出于一个被满足了的读者的舒适，出于一个被挑逗了的评论者的好奇，出于一个年轻人对另一个年轻人成熟程度的惊讶，出于焦虑的缓解：夏天来临，年轻一代的文学还不至于早衰。\n\n由于肉眼可见的文学质地，事实的进展和想象一样迅速。很快，陈春成的小说便进入了理想国的出版序列，我也在今年夏天拿到了试读本。为了确认我初读的激赏并非仅仅源自阅读快感，我又一次，穿过庭院回廊一样慢慢穿过了这些故事。当然，在一些短故事中，我经历了激情的冷却。但在几篇长故事中，我再次踏入了同一条眩晕的河流，再次被淹没、包裹、浸透，在美的诱惑中落水。于是我想：值得动笔，而且应该动笔了。\n\n为了描述的方便而非精确，我认为，可以像面对一具血肉之躯一样，面对陈春成的故事：血是古人的，肉是博尔赫斯的，骨是奥威尔的，心是陈春成自己的。血、肉、骨、心，对应着语言、叙事、主题与美学风格。但我要再次强调，评论的力量和局限，都在于评论是一种概括，这种概括在提供认识的方便的同时，不可以代替对故事本身的阅读。真不可以代替美，真要引渡美，美才能流传。'),
(7,5,1,0,'就是人类吧','2021-06-06','面对浩瀚到足以把人类所有科学努力都约等于零的宇宙，就算有科学家宣称人类是宇宙里唯一的文明物种，恐怕也没有多少人会真的相信。哪怕仅仅出于好奇心和爱幻想的天性，很多人也宁愿选择相信，在近乎无限的宇宙深处，可能会有不同的文明存在。对未来科技、人类和地球的命运乃至外星文明的幻想，让科幻小说得以生长繁荣。而《星球大战》《星际穿越》之类的经典科幻电影的出现，则以更为直观的方式催化了人类对探索宇宙的热望与期待，甚至滋生出各种错觉—比如星际移民这等事会在并不遥远的将来发生。\n\n人类在推进科技发展和探索宇宙的过程中所付出的努力固然可歌可泣。近半个世纪以来，除了登月成功，人类还先后把五艘探测器送出了太阳系，其中最近的一艘—2006年1月19日由NASA(美国宇航局)发射的新地平线号探测器，现已进入太阳系外围的柯伊伯带深处。可是，这种耗费巨大、历时很久、堪称代表了人类科技最高水平的宇宙探测行动，在激动人心之余，也显露出微不足道的本质—就像人类文明之于宇宙。人类探测宇宙的能力越是强大，这种人类渺小的感觉就会越是强烈。最近有消息称，科学家通过长期观测与计算得出判断:距地球约6000光年的一颗被命名为GROJ1655-40的黑洞，正向地球奔来，预计会在1000万年后进入太阳系......面对这一听起来颇令人震惊的消息，其实单看1000万年这个时间长度，就足以让人瞬间释然了—1000万年?到时人类跟地球是否还存在都是个问题。\n\n不管科学家如何预言人类寿命在未来有怎样的延长可能，也不论科幻小说家如何描绘人类的遥远未来，至少到目前为止，人类仍旧处在“人生不满百，常怀千岁忧”的状态。尤其是想想如今全球环境、气候、资源危机，想想人类社会不断加剧的矛盾冲突，以及人类所拥有的核武库规模，都会让我不敢去想象30年后的人类乃至地球会是怎样的状态。活在这个互联网时代，面对关乎危机与灾难的海量信息，只要稍微还有点理性的人，都很难对人类未来做出乐观的预测。在这样的大背景下，无论我们做出什么样的理性思考与大胆想象，其实都很难从根本上摆脱某种无法形容的沉重意味。\n\n写下这些感慨之后，我得承认，在读糖匪这本科幻小说集《奥德赛博》的过程中，始终有种沉重的悲剧意味缠绕着我。当然，这跟糖匪在小说里所设定的时间点没什么关系—因为不管她如何为不同的小说设置不同的时间段，在我看来都有种发生在同一时间段里的感觉，它们就伴随着阅读的时刻正在发生着。那感觉就像是我在正对着一个监视器，而那些小说里的场景正不断浮现着，就在此时此刻......更耐人寻味的是，随着阅读的延展深入，那些原本属于不同小说的场景，甚至还会在脑海里相互重叠、彼此渗透，就好像这8篇小说原本就是一个整体，或是发生在同一个时空里的，以至于读到最后，我会觉得自己看过的只是一个无始无终的一切共存的小说，因为里面的人物(不管是人类还是外星人)意识状态就是这样的，就像某个人物所自道的那样:“在我活着的每时每刻，都和未来共存，都与过去共存，感知时间之流的每一份律动。我的生命与其说是短暂的一条直线，不如说是混沌时空的一个永不消失的点。我从未存在也从未消失。”\n\n弥漫在整本书里的那种沉重感与悲剧意味，跟这种浑然一体的小说状态和人物的意识状态当然是密切相关的，但是还有一个更为重要的深层来源，那就是作者糖匪的世界观。透过那些小说的情节设置，以及对环境背景的铺陈，可以逐渐发现，糖匪笔下的世界似乎都处在濒临解体或解体进程中的状态—人的世界如此，外星人的世界也如此，而与之相伴的，是作者对人的意识层面的种种裂变所做出的非常幽深的探测。或许，在糖匪眼中，世界的解体在很大程度上既是物理意义上的，更是人类(包括外星人)的意识层面上的。为了获取某种意义上的幸存状态，人所能坚守的最后堡垒可能也就是在意识这个层面上—意识的自我重构、重新赋体后的延续、在最为幽微处的隐藏，为此甚至拒绝以无肉身的方式获得永生的可能。于是那些人物的意识世界既有其全然封闭的一面，也有隐秘敞开的一面。在封闭状态下，意识本身即是个体存在的最后堡垒，而在隐秘敞开的状态下，个体意识又像是可以跟整个世界发生某些感应的......“据说，在可被察觉的意识下面，是不可测度的意识深海，不被察觉，难以探究，渊面混沌，智性之光无法穿透。偶尔其中一些碎片会浮上海面，被捕获和破解，变得明晰易懂。”\n\n或许也正因如此，在糖匪笔下，无论是在地球不复存在后以类似于流浪地球的状态独自向外太空航行的北美大陆板块，还是烟雾弥荡的可以收留外星人寄居的北京，或是仿佛处在未来灾难后史前时期的彼得堡，或是如同高度仿真的虚拟游戏世界里的贵州苗寨......在那些看起来无一例外都身处危境且能力微弱的人物的意识世界里，既发生着看起来坚忍而又微不足道的最后抵抗，如同暂时活在封闭且轻薄的意识气泡里，也发生着他们对外面正在解体或濒临解体的世界里某些残留的“微光”及其可能性的寻觅或感知。而让人觉得有沉重的悲剧感的是，任何意义上的幸存状态在那个濒临或正在分崩离析的世界里都是非常渺小的，甚至是难以察觉的，在这样的状态下，人已不需要再去想什么乐观或悲观了，因为“就某种意义来说，生活的确不会变得更糟糕”。\n\n在糖匪的小说世界里，无论她以什么样的笔法来叙事描写，都无法消除那种贯穿始终的如梦似幻的现实感，或者说，在她的笔下，因为人的意识生成、流动与转化的状态已然消解了整个世界不同层面的界限。因此就有了诸多让人觉得奇异的文字状态—所有梦幻般的意味都是由那些异常简练克制的仿佛毫无情绪介入的文字来呈现的，所有界限的消失都是通过极富层次感的文体之美来完成的......以至于有时候，读着读着，会有种莫名的错觉，糖匪似乎并不是在写小说，而是在写着另一种长篇叙事诗—不是西方古典意义上的那种，也不是当下的那些仍然有人在做的尝试，而是只属于她自己的需要耗掉很多生命能量的那种文本状态，尽管在形式上无疑仍旧是文学的，但从本质上说又更近乎某种复杂的程序编码状态，只不过其中有很多局部编码已以未知的方式遗失了，这也导致整个程序的世界再也无法以完整的方式呈现所有叙事的界面，但也还有很多个区域仍能自行其是，不断生成，又像不断在裂解。这些次第展现的文字，每个都是那么的清晰，可是又都像是半透明的状态，以至于你每一次离开字面而抬起头时，都会有种它们组合在一起就如同某种液体，像河流似的不断地掠过头顶不远处的半空中，里面浮动隐现着种种淡薄的意识图景。\n\n决定作家的文字状态的，只能是其意识的状态—其对自我和世界的感知、认识与想象的方式决定了其意识的生成状态。也正是从这个意义上说，当我认为糖匪对文字与文体有着非同寻常的敏感和执拗追求时，实际上我所指的是她的世界观和意识状态的独特，甚至可以更深一步说，指的是她的个体存在状态和对意识世界的探索整合过程的独特。我不认为她对小说里的所有因素和结构细部的掌控都已到了无可挑剔的程度，但我觉得比这种技术性评估更值得珍视的，是无论她以何种方式去处理小说生成的过程，始终都没有让最关键的因素缺位或被淹没，那就是能在最细微处触动人心的东西......就像她在《孢子》里针对那个人工智能人的绘画，以貌似不经意的方式写下的那句:“即使知道这些线条笔画对她一个人工智能而言只是算法而已，我仍然会被画面本身打动。这就是人类吧。”\n\n实际上，由于平时交流不多，我并不知道糖匪如何看待其所身处的日常世界，有着什么样的生活状态，情感模式又是什么样的。我只能透过她的小说所提供的界面去猜测，当然我完全知道这样的猜测其实是没有什么意义的，也是极为无趣的。我并不能说她的科幻小说抵达了何种境界，但我可以说她对人的意识世界所知极深。或许，她的意识世界就像一个无形的沙漏，能把她能看到听到想到的所有日常世界里的现象以及梦境幻觉里的现象统统吸纳进去，让它们转换成最小物理单位的微粒状态，然后穿过位于她脑海深处的那个细孔，进入到她所构建的另一个时空里，以新的方式生成她想要的世界—而她自己，跟那个脑海深处的细孔一样，永远处在某种异常临界的状态，无时无刻不在深刻体验着转化的过程所产生的压力、热能以及熵，而出现在她笔下的那些文字，则既是不断流动的液态，也是随时结晶的状态，既是本质上寂静的，也是某种声音，发自其灵魂的深处......尤其是在最后，整部小说最后的句号出现的时候，体会着无尽虚无中的某种微妙触动，我会想，此时此刻，她在写些什么?将来，她还会写些什么?');

/*Table structure for table `book` */

CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` int NOT NULL,
  `user_id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `ibsn` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `publisher` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ibsn` (`ibsn`),
  KEY `category_id` (`category_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE,
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;

/*Data for the table `book` */

insert  into `book`(`id`,`category_id`,`user_id`,`name`,`ibsn`,`author`,`publisher`,`date`,`description`) values 
(1,3,2,'愤怒的葡萄',NULL,'斯坦贝克','上海译文出版社','2018-01','本书是美国著名作家、诺贝尔文学奖获得者斯坦贝克的代表作。20世纪30年代，美国经济恐慌期间大批农民破产逃荒，作家曾跟随俄克拉何马州的农民流浪到加利福尼亚，沿途所见，令他非常震惊，“有五千户人家即将饿死，问题十分尖锐...”他以深刻写实的笔触，在书中展现了当时美国农民在生死线上挣扎、反抗的情景。作品出版后，引起各州统治阶层的恐慌，许多州禁止小说发行，甚至有一本名为《快乐的葡萄》的小说出版以示针锋相对。但一切都无法动摇《愤怒的葡萄》在美国现代文学史上的重要地位。'),
(2,3,3,'推销员之死',NULL,'阿瑟·米勒','上海译文出版社','2020-08','《推销员之死》是米勒戏剧创作的巅峰之作，荣获普利策奖和纽约剧评界奖，为他赢得国际声誉。推销员威利·洛曼因年老体衰，要求在办公室里工作，却被老板辞退。威利懊丧之下，责怪两个儿子不务正业，一事无成。儿予反唇相讥，嘲笑他不过是个蹩脚的跑街罢了。老推销员做了一辈子的美梦，现在全都幻灭了，自尊心受到严重挫伤。他梦呓似的与他那已故的、在非洲发财致富的大哥争论。'),
(3,3,3,'麦田里的守望者',NULL,'季羡林','古吴轩出版社','2020-08','视《朗读者》节目多次朗读书目。跨四代共读心灵读本，一本书阅尽大师智慧精华！人生的美好状态就是活得清醒、坦荡、真实。季羡林写给万千迷茫的青年一代！愿你历尽沧桑，永葆天真模样'),
(4,2,2,'笑场',NULL,'李诞','北京联合出版有限公司','2018-12','《我也不知道这书怎么就卖了100万册！《吐槽大会》总策划人李诞首部作品100万册全新精装纪念版！4万字私藏文稿首次增加，《扯经》故事完整版首次呈现。未曾开言我先笑场，笑场完了听我诉一诉衷肠。'),
(5,6,1,'围城','null','钱钟书','人民文学出版社','1999-02','人生是围城，婚姻是围城，冲进去了，就被生存的种种烦愁包围。《围城》是钱钟书撰写的一部“新《儒林外史》”。钱钟书以他洒脱幽默的文笔，描写了一群知识分子的生活百态。《围城》里面的精言妙语是这部小说的最成功之处，也是最值得赏析的地方。'),
(6,3,2,'奥德赛博',' 9787555025801','糖匪','海峡文艺出版社','2021-6','学者王德威推荐，作家赵松作序，星云奖、菲利普·迪克奖得主盛赞；作品获中国科幻读者选择奖（引力奖），让我们把时间浪费在赛博世界！'),
(7,3,3,'夜晚的潜水艇','9787542669964',' 陈春成','上海三联书店',' 2020-9','《夜晚的潜水艇》是作家陈春成的首部短篇小说集。九个故事，笔锋游走于旧山河与未知宇宙间，以瑰奇飘扬的想象、温厚清幽的笔法，在现实与幻境间辟开若干条秘密的通道：海底漫游的少年、深山遗落的古碑、弥散入万物的字句、云彩修剪站、铸剑与酿酒、铁幕下的萨克斯、蓝鲸内的演奏厅……'),
(8,3,3,'回归故里',' 9787553518510','[法]迪迪埃·埃里蓬 ','上海文化出版社',' 2020-7','“我们来到这个世界时，命运是否早已被宣判？”'),
(9,2,1,'走出唯一真理观','9787532175468',' 陈嘉映 ','上海文艺出版社',' 2020-5','“我们来到这个世界时，命运是否早已被宣判？”'),
(10,1,2,'理想国',NULL,'柏拉图','红旗出版社','2017-12','《理想国》是柏拉图的一部重要对话录、一部典型的大综合的著作，涉及到哲学、政治、伦理、教育、心理、社会、家庭、宗教、艺术等等诸多问题，而且语言颇富文学色彩，充满了思辨哲理，细细品味，余香四溢。《理想国》是西方知识界必读之书，震古铄今。我们要认识当代西方社会政治文化，就需要追本溯源，了解西方古代的政治文化思想，而《理想国》正是西方古代政治思想的一个源头，是留存下来的第一部反映西方古代政治思想的专著。'),
(11,3,2,'围城',NULL,'钱钟书','人民文学出版社','1999-02','人生是围城，婚姻是围城，冲进去了，就被生存的种种烦愁包围。《围城》是钱钟书撰写的一部“新《儒林外史》”。钱钟书以他洒脱幽默的文笔，描写了一群知识分子的生活百态。《围城》里面的精言妙语是这部小说的最成功之处，也是最值得赏析的地方。'),
(12,3,2,'愤怒的葡萄',NULL,'斯坦贝克','上海译文出版社','2018-01','本书是美国著名作家、诺贝尔文学奖获得者斯坦贝克的代表作。20世纪30年代，美国经济恐慌期间大批农民破产逃荒，作家曾跟随俄克拉何马州的农民流浪到加利福尼亚，沿途所见，令他非常震惊，“有五千户人家即将饿死，问题十分尖锐...”他以深刻写实的笔触，在书中展现了当时美国农民在生死线上挣扎、反抗的情景。作品出版后，引起各州统治阶层的恐慌，许多州禁止小说发行，甚至有一本名为《快乐的葡萄》的小说出版以示针锋相对。但一切都无法动摇《愤怒的葡萄》在美国现代文学史上的重要地位。'),
(13,3,3,'推销员之死',NULL,'阿瑟·米勒','上海译文出版社','2020-08','《推销员之死》是米勒戏剧创作的巅峰之作，荣获普利策奖和纽约剧评界奖，为他赢得国际声誉。推销员威利·洛曼因年老体衰，要求在办公室里工作，却被老板辞退。威利懊丧之下，责怪两个儿子不务正业，一事无成。儿予反唇相讥，嘲笑他不过是个蹩脚的跑街罢了。老推销员做了一辈子的美梦，现在全都幻灭了，自尊心受到严重挫伤。他梦呓似的与他那已故的、在非洲发财致富的大哥争论。'),
(14,3,3,'麦田里的守望者',NULL,'季羡林','古吴轩出版社','2020-08','视《朗读者》节目多次朗读书目。跨四代共读心灵读本，一本书阅尽大师智慧精华！人生的美好状态就是活得清醒、坦荡、真实。季羡林写给万千迷茫的青年一代！愿你历尽沧桑，永葆天真模样'),
(15,2,2,'笑场',NULL,'李诞','北京联合出版有限公司','2018-12','《我也不知道这书怎么就卖了100万册！《吐槽大会》总策划人李诞首部作品100万册全新精装纪念版！4万字私藏文稿首次增加，《扯经》故事完整版首次呈现。未曾开言我先笑场，笑场完了听我诉一诉衷肠。');

/*Table structure for table `category` */

CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values 
(1,'亲自家教'),
(2,'哲学理论'),
(3,'小说'),
(4,'投资理财'),
(5,'政治军事'),
(6,'现代随笔'),
(7,'社会科学'),
(8,'科普百科'),
(9,'经济管理'),
(10,'青春文学');

/*Table structure for table `comments` */

CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `article_id` int NOT NULL,
  `user_id` int NOT NULL,
  `follow` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;

/*Data for the table `comments` */

insert  into `comments`(`id`,`article_id`,`user_id`,`follow`,`content`,`date`) values 
(1,6,9,0,'写得真好啊',''),
(2,2,9,0,'写得真好啊','2020-01-01'),
(3,3,9,0,'写得真好啊','2020-01-01'),
(4,1,9,0,'写得真好啊','2020-01-01'),
(5,5,9,0,'写得真好啊','2020-01-01'),
(6,4,9,0,'写得真好啊','2020-01-01'),
(7,4,7,0,'鞭辟入里，作者用心了','2020-01-01'),
(8,7,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(9,2,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(10,3,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(11,1,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(12,5,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(13,4,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(14,4,2,2,'写得太好了吧','2020-01-01'),
(15,7,2,2,'写得太好了吧','2020-01-01'),
(16,2,2,2,'写得太好了吧','2020-01-01'),
(17,3,2,2,'写得太好了吧','2020-01-01'),
(18,1,2,2,'写得太好了吧','2020-01-01'),
(19,5,2,2,'写得太好了吧','2020-01-01'),
(20,4,2,2,'写得太好了吧','2020-01-01');

/*Table structure for table `msg` */

CREATE TABLE `msg` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb3;

/*Data for the table `msg` */

insert  into `msg`(`id`,`content`,`date`) values 
(1,'加油！！！奥利给！！！','05/29 19:41'),
(2,'加油！！！','05/29 19:42'),
(3,'所以 Saber 都不是人来玩了，全是机器？！','05/29 19:50'),
(4,'今晚上彻底搞完毕设','05/29 19:59'),
(5,'生而为人我很抱歉','05/29 20:41'),
(6,'芜湖','05/30 20:41'),
(7,'好难好难！！！！','05/30 20:43'),
(8,'两片面包夹范斯！','05/30 20:45'),
(9,'图论， 船新的算法，带你体验抽象的数据结构，解决不可能想到实际上可以解决但思维跳跃极大的问题<(￣︶','05/30 20:45'),
(10,'蓝桥杯国赛，加油！！！','05/30 20:46'),
(11,'跪求手机APP','05/30 20:47'),
(12,'又遇见素质不高骂别人素质不高的了','05/31 20:48'),
(13,'发多少个法国岁的法国梵蒂冈的梵蒂冈的方法','05/31 20:49'),
(14,'沙发','05/31 20:50'),
(15,'大郎说他饿了','05/31 20:01'),
(16,'大郎说他渴了','05/31 20:03'),
(17,'加油！！！','05/31 20:04'),
(18,'加油！！！','05/31 20:07'),
(19,'阿打算','19:56:12'),
(20,'额鹅鹅鹅  你想说啥','2021-06-03 19:57:23'),
(21,'额鹅鹅鹅  你想说啥','2021-06-03 19:57:23'),
(22,'额鹅鹅鹅  你想说啥','2021-06-03 19:57:24'),
(23,'额鹅鹅鹅  你想说啥','2021-06-03 19:57:24'),
(24,'额鹅鹅鹅  你想说啥','2021-06-03 19:57:30'),
(25,'全新算法','2021-06-03 19:57:41'),
(26,'你好啊 ','2021-06-03 19:58:34'),
(27,'苏安然我 ','2021-06-03 19:58:39'),
(28,'我啥都不想说了 真的 ','2021-06-03 20:02:32'),
(29,'我啥都不想说了 真的的  ','2021-06-03 20:28:06'),
(30,' 我啥都不想说了 真的  ','2021-06-03 20:28:09'),
(31,'加油！！！奥利给！！！','05/29 19:41'),
(32,'加油！！！','05/29 19:42'),
(33,'所以 Saber 都不是人来玩了，全是机器？！','05/29 19:50'),
(34,'今晚上彻底搞完毕设','05/29 19:59'),
(35,'生而为人我很抱歉','05/29 20:41'),
(36,'芜湖','05/30 20:41'),
(37,'好难好难！！！！','05/30 20:43'),
(38,'两片面包夹范斯！','05/30 20:45'),
(39,'图论， 船新的算法，带你体验抽象的数据结构，解决不可能想到实际上可以解决但思维跳跃极大的问题<(￣︶','05/30 20:45'),
(40,'蓝桥杯国赛，加油！！！','05/30 20:46'),
(41,'跪求手机APP','05/30 20:47'),
(42,'又遇见素质不高骂别人素质不高的了','05/31 20:48'),
(43,'发多少个法国岁的法国梵蒂冈的梵蒂冈的方法','05/31 20:49'),
(44,'沙发','05/31 20:50'),
(45,'大郎说他饿了','05/31 20:01'),
(46,'大郎说他渴了','05/31 20:03'),
(47,'加油！！！','05/31 20:04'),
(48,'加油！！！','05/31 20:07'),
(49,'阿打算','19:56:12'),
(50,'额鹅鹅鹅  你想说啥','2021-06-03 19:57:23'),
(51,'额鹅鹅鹅  你想说啥','2021-06-03 19:57:23'),
(52,'额鹅鹅鹅  你想说啥','2021-06-03 19:57:24'),
(53,'额鹅鹅鹅  你想说啥','2021-06-03 19:57:24'),
(54,'额鹅鹅鹅  你想说啥','2021-06-03 19:57:30'),
(55,'全新算法','2021-06-03 19:57:41'),
(56,'你好啊 ','2021-06-03 19:58:34'),
(57,'苏安然我 ','2021-06-03 19:58:39'),
(58,'我啥都不想说了 真的 ','2021-06-03 20:02:32'),
(59,'我啥都不想说了 真的的  ','2021-06-03 20:28:06'),
(60,' 我啥都不想说了 真的  ','2021-06-03 20:28:09');

/*Table structure for table `user` */

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `psd` varchar(255) NOT NULL,
  `authority` int NOT NULL DEFAULT '1',
  `logcnt` int DEFAULT '1',
  `birthday` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`psd`,`authority`,`logcnt`,`birthday`,`city`,`gender`) values 
(1,'admin','123456',0,14,NULL,NULL,NULL),
(2,'gm','gm',1,1,NULL,NULL,NULL),
(3,'最帅制作人','zszzr',-1,1,NULL,NULL,NULL),
(4,'ffgz','ffgz',-1,1,NULL,NULL,NULL),
(5,'无敌大魔王','wddmw',1,1,NULL,NULL,NULL),
(6,'susy','susya',1,1,'1999-12-31','贺州','femal'),
(7,'ally','allya',1,1,'1700-09--1','newyork','man'),
(8,'allysmith','allya',1,1,'1703-09--1','newyork','woman'),
(9,'fork','fffooorrrkkk',1,1,'1999-11-02','HeZhou','man');

SET GLOBAL FOREIGN_KEY_CHECKS=1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
