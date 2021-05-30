-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 27 2021 г., 10:56
-- Версия сервера: 10.4.19-MariaDB
-- Версия PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `hw_lesson3`
--

-- --------------------------------------------------------

--
-- Структура таблицы `car`
--

CREATE TABLE `car` (
  `car_brand` varchar(20) NOT NULL,
  `color` varchar(20) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `car`
--

INSERT INTO `car` (`car_brand`, `color`, `price`) VALUES
('bmw', 'black', 10000),
('bmw', 'white', 7790),
('lada', 'white', 3000),
('bmw', 'red', 5000),
('bmw', 'black', 25000),
('ford', 'black', 1500),
('ford', 'green', 7500),
('lada', 'black', 700),
('lada', 'silver', 500),
('lexus', 'black', 18000),
('lexus', 'black', 24000);

-- --------------------------------------------------------

--
-- Структура таблицы `carorder`
--

CREATE TABLE `carorder` (
  `order_number` int(11) NOT NULL,
  `car_brand` varchar(20) NOT NULL,
  `client_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `carorder`
--

INSERT INTO `carorder` (`order_number`, `car_brand`, `client_name`) VALUES
(1, 'bmw', 'Вася'),
(2, 'bmw', 'Толик'),
(3, 'bmw', 'Коля'),
(4, 'bmw', 'Петя'),
(5, 'lada', 'Сеня'),
(6, 'lada', 'Дима'),
(7, 'lada', 'Настя'),
(8, 'ford', 'Жорик'),
(9, 'ford', 'Вика'),
(10, 'ford', 'Саша'),
(11, 'ford', 'Влада');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
