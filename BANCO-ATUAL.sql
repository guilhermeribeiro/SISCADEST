SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `salaoteste` ;
CREATE SCHEMA IF NOT EXISTS `salaoteste` DEFAULT CHARACTER SET latin1 ;
USE `salaoteste` ;

-- -----------------------------------------------------
-- Table `salaoteste`.`agendamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `salaoteste`.`agendamento` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `data` DATE NULL DEFAULT NULL ,
  `hora` VARCHAR(50) NULL DEFAULT NULL ,
  `cliente` VARCHAR(50) NULL DEFAULT NULL ,
  `servico` VARCHAR(50) NULL DEFAULT NULL ,
  `status` VARCHAR(50) NULL DEFAULT NULL ,
  `atendente` VARCHAR(50) NOT NULL ,
  `obs` VARCHAR(200) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `salaoteste`.`clientes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `salaoteste`.`clientes` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(50) NOT NULL ,
  `cpf` VARCHAR(50) NOT NULL ,
  `rg` VARCHAR(50) NOT NULL ,
  `rua` VARCHAR(50) NULL DEFAULT NULL ,
  `bairro` VARCHAR(50) NULL DEFAULT NULL ,
  `cep` VARCHAR(50) NULL DEFAULT NULL ,
  `cidade` VARCHAR(50) NULL DEFAULT NULL ,
  `numero` VARCHAR(50) NULL DEFAULT NULL ,
  `telefonefixo` VARCHAR(50) NULL DEFAULT NULL ,
  `celular1` VARCHAR(50) NULL DEFAULT NULL ,
  `celular2` VARCHAR(50) NULL DEFAULT NULL ,
  `cargo` VARCHAR(50) NULL DEFAULT NULL ,
  `empresa` VARCHAR(50) NULL DEFAULT NULL ,
  `telefoneempresa` VARCHAR(50) NULL DEFAULT NULL ,
  `renda` DOUBLE NULL DEFAULT NULL ,
  `juros` DOUBLE NULL DEFAULT NULL ,
  `foto` VARCHAR(200) NULL DEFAULT NULL ,
  `dtNasc` VARCHAR(200) NULL DEFAULT NULL ,
  `email` VARCHAR(300) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `nome` (`nome` ASC) ,
  UNIQUE INDEX `cpf` (`cpf` ASC) ,
  UNIQUE INDEX `rg` (`rg` ASC) ,
  UNIQUE INDEX `nome_2` (`nome` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `salaoteste`.`servicos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `salaoteste`.`servicos` (
  `cod` INT(10) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(50) NOT NULL ,
  `preco` DOUBLE NOT NULL ,
  `nomecliente` VARCHAR(50) NOT NULL ,
  `formaPagamento` VARCHAR(45) NULL DEFAULT NULL ,
  `data` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`cod`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
