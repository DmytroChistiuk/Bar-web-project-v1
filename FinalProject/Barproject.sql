-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Июн 02 2021 г., 12:23
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

-- --------------------------------------------------------

--
-- Структура таблицы `additive_cocktail_ingredient`
--

CREATE TABLE `additive_cocktail_ingredient` (
  `id` int(11) NOT NULL,
  `additiveId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `alcohol`
--

CREATE TABLE `alcohol` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `alcohol_cocktail_ingredient`
--

CREATE TABLE `alcohol_cocktail_ingredient` (
  `id` int(11) NOT NULL,
  `alcoholId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Структура таблицы `bar_device`
--

CREATE TABLE `bar_device` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `cocktail_info`
--

CREATE TABLE `cocktail_info` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `cocktail_type` varchar(100) NOT NULL,
  `recipe` text NOT NULL,
  `tableware` varchar(200) NOT NULL,
  `barDeviceId` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `cocktail_ ingredient`
--

CREATE TABLE `cocktail_ ingredient` (
  `name` varchar(100) NOT NULL,
  `alcoholId` varchar(100) NOT NULL,
  `softdrinkId` varchar(100) NOT NULL,
  `additiveId` varchar(200) NOT NULL,
  `decoration` varchar(200) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `softdrink`
--

CREATE TABLE `softdrink` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `softdrink_cocktail_ingredient`
--

CREATE TABLE `softdrink_cocktail_ingredient` (
  `id` int(11) NOT NULL,
  `softdrinkId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------

--
-- Структура таблицы `user_bar`
--

CREATE TABLE `user_bar` (
  `UserBarAlcoholId` varchar(100) NOT NULL,
  `UserBarSoftdrinkId` varchar(100) NOT NULL,
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `user_bar`
--
ALTER TABLE `user_bar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
