# Руководство пользователя

Это информационная система магазина бытовой техники.

## Перед работой

Стоит настроить пару аспектов для корректной работы данной системы:

1. Подготовить рабочее пространство
	a) Установить OpenServer или MYSQLServer
	b) Установить NetBeans
	c) Скачать mysql-connector версии 8.0.17 или 8.0.26
3. Скачать репозиторий
4. Изменить версию mysql-connector в зависимости по надобности
5. Открыть файл sh.mwb и импортировать эту модель к себе в БД
6. Вставить в БД в таблицу роли 2 записи
	- INSERT INTO Userrole VALUES(1, 'admin');
	- INSERT INTO Userrole VALUES(2, 'user');
7. Запустить программу
