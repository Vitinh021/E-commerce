-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 10-Dez-2019 às 15:40
-- Versão do servidor: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loja`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `fluxocaixa`
--

CREATE TABLE `fluxocaixa` (
  `id` int(10) NOT NULL,
  `id_v` int(10) DEFAULT NULL,
  `id_u` int(10) DEFAULT NULL,
  `apurado` float DEFAULT NULL,
  `despesas` float DEFAULT NULL,
  `data` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemvenda`
--

CREATE TABLE `itemvenda` (
  `id` int(10) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `produto_id` int(11) DEFAULT NULL,
  `venda_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `itemvenda`
--

INSERT INTO `itemvenda` (`id`, `quantidade`, `produto_id`, `venda_id`) VALUES
(9, 1, 2, 7),
(10, 1, 2, 7),
(11, 1, 2, 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `nome` varchar(255) DEFAULT NULL,
  `preco` float DEFAULT NULL,
  `quantidade` int(11) NOT NULL,
  `id` int(10) NOT NULL,
  `codigo` int(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`nome`, `preco`, `quantidade`, `id`, `codigo`) VALUES
('meia', 10, 100, 2, 111),
('toalha athelier', 10, 100, 4, 333),
('toalha jasmim', 10, 100, 5, 444),
('toalha banhão', 10, 100, 6, 555);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(10) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `permissao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `permissao`) VALUES
(1, 'vitinho', 'vitinho@gmail.com', '123', 2),
(2, 'neto', 'neto@gmail.com', '123', 1),
(3, 'Jão', 'Jão@gmail.com', '123', 0),
(4, 'Duda', 'duda@gmail.com', '123', 0),
(5, 'Valeria', 'Valeria@gmail.com', '123', 0),
(6, 'Ruan', 'Ruan@gmail.com', '123', 1),
(7, 'Gui', '', '123', 2),
(8, 'Calil', 'Calil@gmail.com', '123', 0),
(9, 'bebe', 'bebe@gmail.com', '123', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `id` int(10) NOT NULL,
  `valor` float DEFAULT NULL,
  `data` varchar(10) DEFAULT NULL,
  `opcao_venda` varchar(255) DEFAULT NULL,
  `desconto` float DEFAULT NULL,
  `itens` tinyblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`id`, `valor`, `data`, `opcao_venda`, `desconto`, `itens`) VALUES
(7, 20, '10/12/2019', 'credito', 10, 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000077040000000078);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fluxocaixa`
--
ALTER TABLE `fluxocaixa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_v` (`id_v`),
  ADD KEY `id_u` (`id_u`);

--
-- Indexes for table `itemvenda`
--
ALTER TABLE `itemvenda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_g4u5m9a9xnkug2j3d7d5wf17g` (`produto_id`),
  ADD KEY `FK_c7jg4jqyxscjaevvne5vw2fxl` (`venda_id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `itemvenda`
--
ALTER TABLE `itemvenda`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `fluxocaixa`
--
ALTER TABLE `fluxocaixa`
  ADD CONSTRAINT `fluxocaixa_ibfk_1` FOREIGN KEY (`id_v`) REFERENCES `venda` (`id`),
  ADD CONSTRAINT `fluxocaixa_ibfk_2` FOREIGN KEY (`id_u`) REFERENCES `usuario` (`id`);

--
-- Limitadores para a tabela `itemvenda`
--
ALTER TABLE `itemvenda`
  ADD CONSTRAINT `FK_c7jg4jqyxscjaevvne5vw2fxl` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`),
  ADD CONSTRAINT `FK_g4u5m9a9xnkug2j3d7d5wf17g` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
