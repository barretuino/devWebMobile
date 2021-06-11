--
-- Create schema pjgerencia
--

CREATE DATABASE IF NOT EXISTS pjgerencia;
USE pjgerencia;

--
-- Definition of table `medidas`
--

DROP TABLE IF EXISTS `medidas`;
CREATE TABLE `medidas` (
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `valor` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;