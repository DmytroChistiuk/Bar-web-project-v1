-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Июн 11 2021 г., 10:44
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
-- База данных: `barproject`
--

-- --------------------------------------------------------

--
-- Структура таблицы `additive`
--

CREATE TABLE `additive` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `additive`
--

INSERT INTO `additive` (`id`, `name`) VALUES
(1, 'Лайм'),
(2, 'Мята');

-- --------------------------------------------------------

--
-- Структура таблицы `additive_cocktail_ingredient`
--

CREATE TABLE `additive_cocktail_ingredient` (
  `id` int(11) NOT NULL,
  `additiveId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `additive_cocktail_ingredient`
--

INSERT INTO `additive_cocktail_ingredient` (`id`, `additiveId`) VALUES
(1, 1),
(2, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `alcohol`
--

CREATE TABLE `alcohol` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `alcohol`
--

INSERT INTO `alcohol` (`id`, `name`) VALUES
(1, 'Джин'),
(2, 'Ром'),
(3, 'Водка'),
(4, 'Кофейный ликер');

-- --------------------------------------------------------

--
-- Структура таблицы `alcohol_cocktail_ingredient`
--

CREATE TABLE `alcohol_cocktail_ingredient` (
  `id` int(11) NOT NULL,
  `alcoholId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `alcohol_cocktail_ingredient`
--

INSERT INTO `alcohol_cocktail_ingredient` (`id`, `alcoholId`) VALUES
(2, 1),
(1, 2),
(3, 3),
(4, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `alcohol_user_bar`
--

CREATE TABLE `alcohol_user_bar` (
  `id` int(11) NOT NULL,
  `UserBarAlcoholId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `cocktail_info`
--

CREATE TABLE `cocktail_info` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `cocktail_type` varchar(100) NOT NULL,
  `recipe` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `cocktail_ ingredient`
--

CREATE TABLE `cocktail_ ingredient` (
  `name` varchar(100) NOT NULL,
  `alcoholId` int(11) NOT NULL,
  `softdrinkId` int(11) NOT NULL,
  `additiveId` int(11) NOT NULL,
  `decoration` varchar(200) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `cocktail_ ingredient`
--

INSERT INTO `cocktail_ ingredient` (`name`, `alcoholId`, `softdrinkId`, `additiveId`, `decoration`, `id`) VALUES
('Мохито', 1, 1, 1, 'Цедра лайма', 1),
('Джин Тоник', 2, 2, 2, 'Долька лайма', 2),
('Белый русский', 3, 3, 3, 'Натертый шоколад', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `softdrink`
--

CREATE TABLE `softdrink` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `softdrink`
--

INSERT INTO `softdrink` (`id`, `name`) VALUES
(1, 'Содовая'),
(2, 'Сахарный сироп'),
(3, 'Тоник'),
(4, 'Сливки');

-- --------------------------------------------------------

--
-- Структура таблицы `softdrink_cocktail_ingredient`
--

CREATE TABLE `softdrink_cocktail_ingredient` (
  `id` int(11) NOT NULL,
  `softdrinkId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `softdrink_cocktail_ingredient`
--

INSERT INTO `softdrink_cocktail_ingredient` (`id`, `softdrinkId`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `softdrink_user_bar`
--

CREATE TABLE `softdrink_user_bar` (
  `id` int(11) NOT NULL,
  `UserBarSoftdrinkId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `name`, `surname`, `login`, `password`) VALUES
(1, '1', '1', '1', '1'),
(2, 'Никита', 'Шевчук', '123', '123'),
(3, 'ME', '1', 'login', 'password'),
(123, '123', '123', '123', '123');

-- --------------------------------------------------------

--
-- Структура таблицы `user_bar`
--

CREATE TABLE `user_bar` (
  `UserBarAlcoholId` int(11) NOT NULL,
  `UserBarSoftdrinkId` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cocktail_info`
--
ALTER TABLE `cocktail_info`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `cocktail_ ingredient`
--
ALTER TABLE `cocktail_ ingredient`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_bar`
--
ALTER TABLE `user_bar`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cocktail_info`
--
ALTER TABLE `cocktail_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `cocktail_ ingredient`
--
ALTER TABLE `cocktail_ ingredient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;

--
-- AUTO_INCREMENT для таблицы `user_bar`
--
ALTER TABLE `user_bar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
