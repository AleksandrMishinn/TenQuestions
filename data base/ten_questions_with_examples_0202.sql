-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Фев 02 2020 г., 19:08
-- Версия сервера: 10.3.13-MariaDB-log
-- Версия PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `ten_questions`
--

-- --------------------------------------------------------

--
-- Структура таблицы `answers`
--

CREATE TABLE `answers` (
  `id` int(11) UNSIGNED NOT NULL,
  `quastion_id` int(11) UNSIGNED NOT NULL,
  `text` text NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `answers`
--

INSERT INTO `answers` (`id`, `quastion_id`, `text`, `active`) VALUES
(1, 1, 'Первый вариант....', 1),
(2, 1, 'Предпочту второй вариант', 1),
(3, 1, 'What ??? ', 1),
(4, 1, 'Что-то я среди вас одноглазых не вижу!', 1),
(9, 2, 'Буду одинок и несчастен', 1),
(10, 2, 'Буду счастливо жить в окружении близких людей', 1),
(11, 2, 'Уеду в закат', 1),
(12, 2, 'Вряд ли я доживу до старости', 1),
(13, 3, 'Читаю книги.', 1),
(14, 3, 'Играю в ПК.', 1),
(15, 3, 'Стараюсь куда-нибудь выбраться.', 1),
(16, 3, 'Свободное время???', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `answer_history`
--

CREATE TABLE `answer_history` (
  `id` int(11) UNSIGNED NOT NULL,
  `user` int(11) UNSIGNED NOT NULL,
  `question` int(11) UNSIGNED NOT NULL,
  `answer` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `answer_history`
--

INSERT INTO `answer_history` (`id`, `user`, `question`, `answer`) VALUES
(1, 1, 1, 4),
(2, 2, 1, 3),
(5, 2, 3, 15),
(3, 3, 1, 3),
(4, 3, 3, 13);

-- --------------------------------------------------------

--
-- Структура таблицы `questions`
--

CREATE TABLE `questions` (
  `id` int(11) UNSIGNED NOT NULL,
  `text` text NOT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `questions`
--

INSERT INTO `questions` (`id`, `text`, `theme`, `active`) VALUES
(1, 'Вилкой в глаз или...', NULL, 1),
(2, 'В старости я', NULL, 1),
(3, 'В свободное время я обычно', NULL, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) UNSIGNED NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `number` char(12) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` enum('male','female') NOT NULL,
  `age` tinyint(3) UNSIGNED NOT NULL DEFAULT 0,
  `want_sex` set('male','female') NOT NULL,
  `want_age_from` tinyint(3) UNSIGNED NOT NULL,
  `want_age_to` tinyint(3) UNSIGNED NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `email`, `number`, `name`, `sex`, `age`, `want_sex`, `want_age_from`, `want_age_to`, `password`) VALUES
(1, 'alexandrmishinn@yandex.ru', '+79117716422', 'Sashok55', 'male', 25, 'female', 23, 27, '123qweasd'),
(2, 'typecalUser777@mail.com', '+79111111112', 'Пользователь классический', 'male', 20, 'female', 18, 25, '123456'),
(3, 'test@mail.ru', '+79111111111', 'test', 'female', 30, 'male', 25, 35, '123456');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `quastion_id` (`quastion_id`);

--
-- Индексы таблицы `answer_history`
--
ALTER TABLE `answer_history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user` (`user`,`question`,`answer`),
  ADD KEY `answer` (`answer`),
  ADD KEY `question` (`question`);

--
-- Индексы таблицы `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`,`number`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `answers`
--
ALTER TABLE `answers`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT для таблицы `answer_history`
--
ALTER TABLE `answer_history`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `answers_ibfk_1` FOREIGN KEY (`quastion_id`) REFERENCES `questions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `answer_history`
--
ALTER TABLE `answer_history`
  ADD CONSTRAINT `answer_history_ibfk_1` FOREIGN KEY (`user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `answer_history_ibfk_2` FOREIGN KEY (`answer`) REFERENCES `answers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `answer_history_ibfk_3` FOREIGN KEY (`question`) REFERENCES `questions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
