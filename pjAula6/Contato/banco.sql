CREATE TABLE IF NOT EXISTS `contato` (
  `id` int(10) NOT NULL auto_increment,
  `nome` varchar(100) default NULL,
  `email` varchar(100) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `mensagem` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
