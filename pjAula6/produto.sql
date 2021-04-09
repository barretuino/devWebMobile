CREATE TABLE `pjcurso`.`produto` 
( `codigo` INT NOT NULL , 
	`descricao` TEXT NOT NULL , 
	`unidade_medida` TEXT NOT NULL , 
	`localizacao` INT NOT NULL COMMENT 'Localização no Estoque' , 
	`fornecedor` INT NOT NULL , 
	`data_cadastro` DATE NOT NULL ) ENGINE = InnoDB;