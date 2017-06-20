-- phpMyAdmin SQL Dump
-- version 3.4.3.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 12/12/2012 às 22h04min
-- Versão do Servidor: 5.5.25
-- Versão do PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `salao`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agendamento`
--

CREATE TABLE IF NOT EXISTS `agendamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `hora` varchar(50) DEFAULT NULL,
  `cliente` varchar(50) DEFAULT NULL,
  `servico` varchar(50) DEFAULT NULL,
  `preco` double NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `atendente` varchar(200) NOT NULL,
  `obs` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `agendamento`
--

INSERT INTO `agendamento` (`id`, `data`, `hora`, `cliente`, `servico`, `preco`, `status`, `atendente`, `obs`) VALUES
(1, '2012-12-11', '14:00', 'alan', 'Corte de Cabelo', 10, 'Aberto', 'xxx', 'yyy'),
(2, '2012-12-10', '15:00', 'alan', 'Corte de Cabelo', 10, 'Aberto', 'aline', ''),
(3, '2013-12-10', '14:00', 'Aline', 'fazer unha', 15, 'Aberto', 'ssss', ''),
(4, '2012-12-12', '14:00', 'rafael', 'fazer unha', 15, 'Aberto', 'lucas', 'asdad');

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(50) NOT NULL,
  `rg` varchar(50) NOT NULL,
  `rua` varchar(50) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cep` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `numero` varchar(50) DEFAULT NULL,
  `telefonefixo` varchar(50) DEFAULT NULL,
  `celular1` varchar(50) DEFAULT NULL,
  `celular2` varchar(50) DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `empresa` varchar(50) DEFAULT NULL,
  `telefoneempresa` varchar(50) DEFAULT NULL,
  `renda` double DEFAULT NULL,
  `juros` double DEFAULT NULL,
  `foto` varchar(200) DEFAULT NULL,
  `dtNasc` varchar(200) DEFAULT NULL,
  `email` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `rg` (`rg`),
  UNIQUE KEY `nome_2` (`nome`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `cpf`, `rg`, `rua`, `bairro`, `cep`, `cidade`, `numero`, `telefonefixo`, `celular1`, `celular2`, `cargo`, `empresa`, `telefoneempresa`, `renda`, `juros`, `foto`, `dtNasc`, `email`) VALUES
(4, 'Aline', '11', '11', '1111', 'centro', '', '', '', 'xxxxxxxx', 'xxxxxxxxxx', 'xxxxxxxxx', '', '', '', 0, 0, 'C:/Users/Alan/Pictures/Artur e Castro_Banner.jpg', '10/12/1991', ''),
(5, 'alan', '', '', '', '', '', '', '', '', '', '', '', '', '', 0, 0, '', '  /  /    ', ''),
(8, 'rafael', '1111111', '2222', '', '', '', '', '', '', '', '', '', '', '', 0, 0, 'C:/Users/Alan/Pictures/Artur e Castro_Banner.jpg', '10/12/1991', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicos`
--

CREATE TABLE IF NOT EXISTS `servicos` (
  `cod` int(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `preco` double NOT NULL,
  `descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`cod`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `servicos`
--

INSERT INTO `servicos` (`cod`, `nome`, `preco`, `descricao`) VALUES
(1, 'Corte de Cabelo', 10, 'cortar o cabelo'),
(2, 'fazer unha', 15, 'aaaaa');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
