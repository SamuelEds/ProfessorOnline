-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 29-Maio-2020 às 19:53
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `profonline`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefone` varchar(100) DEFAULT NULL,
  `serie` varchar(30) NOT NULL,
  `escola` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`matricula`, `nome`, `email`, `telefone`, `serie`, `escola`) VALUES
(577790, 'Humberto Gabriel Ferreira', 'hg@gmail.com', '123', 'Segundo Ano do Ensino Médio', 'Arisvaldo Cruz e Souza'),
(4111722, 'Samuel Edson Ribeiro Sampaio', 'samuel@gmail.com', '(85) 98765-9034', 'Terceiro Ano do Ensino Médio', 'Joaqui Nogueira Silva'),
(4111810, 'Samuel Edson Ribeiro Sampaio', 'saa@gmail.com', '123', 'Primeiro Ano do Ensino Médio', 'Joaquim Nogueira'),
(4111890, 'Felipe Santana', 'felipe@gmail.com', '(85) - 98672-8900', 'Terceiro Ano do Ensino Médio', 'Arivaldo de Azevedo'),
(4111899, 'Sla quem é', 'saa@gmail.com', '123', 'Primeiro Ano do Ensino Médio', 'Joaquim Nogueira');

-- --------------------------------------------------------

--
-- Estrutura da tabela `boletim`
--

CREATE TABLE `boletim` (
  `id` int(11) NOT NULL,
  `matricula` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `disciplina` varchar(100) NOT NULL,
  `serie` varchar(200) NOT NULL,
  `prova_parcial` float NOT NULL,
  `prova_bimestral` float NOT NULL,
  `media` float NOT NULL,
  `resultado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `boletim`
--

INSERT INTO `boletim` (`id`, `matricula`, `nome`, `disciplina`, `serie`, `prova_parcial`, `prova_bimestral`, `media`, `resultado`) VALUES
(1, 577790, 'Humberto Gabriel Ferreira', 'Português', 'Segundo Ano do Ensino Médio', 9.38, 10, 9.7, 'APROVADO'),
(2, 4111722, 'Samuel Edson Ribeiro Sampaio', 'Português', 'Terceiro Ano do Ensino Médio', 9.38, 10, 9.7, 'APROVADO'),
(3, 4111899, 'Sla quem é', 'Português', 'Primeiro Ano do Ensino Médio', 9.5, 10, 9.8, 'APROVADO'),
(4, 4111899, 'Sla quem é', 'Português', 'Primeiro Ano do Ensino Médio', 8, 10, 9, 'APROVADO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `escola`
--

CREATE TABLE `escola` (
  `nome` varchar(64) DEFAULT NULL,
  `bairro` varchar(54) DEFAULT NULL,
  `cep` varchar(64) DEFAULT NULL,
  `cidade` varchar(64) DEFAULT NULL,
  `dependencia` varchar(64) DEFAULT NULL,
  `endereco` varchar(64) DEFAULT NULL,
  `codigo` varchar(64) DEFAULT NULL,
  `id` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `escola`
--

INSERT INTO `escola` (`nome`, `bairro`, `cep`, `cidade`, `dependencia`, `endereco`, `codigo`, `id`) VALUES
('2', '1', '5', '7', 'Estadual', '4', '3', 1),
('b', 'b', 'bb', 'b', 'Estadual', 'b', 'bb', 2),
('1', '5', '2', '3', 'Estadual', NULL, '4', 3),
('p', 'p', 'p', 'p', 'Particular', 'p', 'p', 7),
('ggggggggg', 'Sousa', 'De sa', 'Marques', 'Particular', '123', '4', 8),
('Pedin2', 'E', 'POL', 'PLO', 'Estadual', 'SEI', 'RUA', 9),
('E.E.E.P JOAQUIM NOGUEIRA', 'Bairro dos Chiques', '2341-908', 'Fortaleza', 'Estadual', 'Rua dos Burgueses', 'SEEEEPM', 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professores`
--

CREATE TABLE `professores` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `telefone` varchar(200) DEFAULT NULL,
  `escola_per` varchar(200) NOT NULL,
  `disciplina` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `professores`
--

INSERT INTO `professores` (`id`, `nome`, `email`, `telefone`, `escola_per`, `disciplina`, `senha`) VALUES
(1, 'Fernanda', 'frm@gmail.com', '123', 'JN', 'Química', '123'),
(2, 'Denis', 'denis@gmail.com', '123', 'JN', 'Português', '123'),
(3, 'Fernando', 'fer@gmail.com', '(85) - 98342-3123', 'Arivaldo de Azevedo Neves', 'Sociologia', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `resultado`
--

CREATE TABLE `resultado` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `serie` varchar(100) NOT NULL,
  `disciplina` varchar(100) NOT NULL,
  `bimestre_um` float DEFAULT NULL,
  `bimestre_dois` float DEFAULT NULL,
  `bimestre_tres` float DEFAULT NULL,
  `bimestre_quatro` float DEFAULT NULL,
  `media_final` float DEFAULT NULL,
  `resultado` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `resultado`
--

INSERT INTO `resultado` (`matricula`, `nome`, `serie`, `disciplina`, `bimestre_um`, `bimestre_dois`, `bimestre_tres`, `bimestre_quatro`, `media_final`, `resultado`) VALUES
(4111810, 'Samuel Edson Ribeiro Sampaio', 'Primeiro Ano do Ensino Médio', 'Português', 10, 10, 10, 10, 10, 'APROVADO');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`matricula`);

--
-- Indexes for table `boletim`
--
ALTER TABLE `boletim`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `escola`
--
ALTER TABLE `escola`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `professores`
--
ALTER TABLE `professores`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `resultado`
--
ALTER TABLE `resultado`
  ADD PRIMARY KEY (`matricula`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `boletim`
--
ALTER TABLE `boletim`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `escola`
--
ALTER TABLE `escola`
  MODIFY `id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `professores`
--
ALTER TABLE `professores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
