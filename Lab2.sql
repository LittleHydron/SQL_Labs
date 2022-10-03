use Labor_SQL;

-- 1
-- Знайти виробників ПК. Вивести: maker, type.
-- Вихідні дані впорядкувати за спаданням за стовпцем maker.
SELECT distinct maker, type FROM Product WHERE type = "PC" order by maker desc;

-- 2
-- БД «Аеропорт». З таблиці Pass_in_trip вивести дати, коли були зай-
-- няті місця 'c' у будь-якому ряді.
SELECT date from Pass_in_trip where place like "%c";

-- 3
-- Для пасажирів таблиці Passenger вивести дати, ко-
-- ли вони користувалися послугами авіаліній.
SELECT Passenger.name, Pass_in_trip.date
FROM Passenger
LEFT JOIN Pass_in_trip
ON Passenger.ID_psg = Pass_in_trip.ID_psg;

-- 4
-- Вивести класи всіх кораблів України ('Ukraine'). Як-
-- що в БД немає класів кораблів України, тоді вивести класи для всіх

-- наявних у БД країн. Вивести: country, class.
SELECT country, class FROM Classes
WHERE not exists(SELECT class FROM Classes WHERE country="Ukraine") OR country = "Ukraine";

INSERT INTO Classes(class, type, country, numGuns, bore, displacement) VALUE(
	"Koko", "bb", "Ukraine", 12, 15, 42000
);
INSERT INTO Classes(class, type, country, numGuns, bore, displacement) VALUE(
	"Koka", "bb", "Ukraine", 12, 15, 42000
);

DELETE FROM Classes WHERE country = "Ukraine";

-- 5
-- Виведіть тих виробників ноутбуків, які не
-- випускають принтери.
SELECT (SELECT Product.maker FROM Product WHERE Product.model = Laptop.model) maker FROM Laptop
WHERE not exists(
SELECT Printer.code FROM Printer
WHERE (SELECT Product.maker FROM Product WHERE Product.model = Laptop.model) = (SELECT Product.maker FROM Product WHERE Product.model = Printer.model)
);

-- 6
-- Для таблиці Printer вивести всю інформацію з
-- коментарями в кожній
SELECT concat("code: ", code), concat("model: ", model), concat("color: ", color), concat("type: ", type), concat("price: ", price)
FROM Printer;

-- 7
-- Для кожної країни визначити рік, у якому було спу-
-- щено на воду максимальна кількість її кораблів. У випадку, якщо ви-
-- явиться декілька таких років, тоді взяти мінімальний із них. Вивести:

-- country, кількість кораблів, рік.

WITH tmp_table as(
SELECT DISTINCT Classes.country country, Ships.launched launched, COUNT(Ships.name) number_of_ships
FROM Classes
INNER JOIN Ships ON Ships.class = Classes.class
GROUP BY Classes.country, Ships.launched order by Classes.country, Ships.launched),
tmp_table1 as(
SELECT tmp_table.country, max(tmp_table.number_of_ships) max_number_of_ships FROM tmp_table GROUP BY tmp_table.country)
SELECT tmp_table.country, tmp_table.number_of_ships, min(tmp_table.launched) year_of_launch FROM tmp_table
INNER JOIN tmp_table1 ON tmp_table.country = tmp_table1.country and tmp_table.number_of_ships = tmp_table1.max_number_of_ships
GROUP BY tmp_table.country, tmp_table.number_of_ships;

-- 8
-- Для таблиці Product отримати підсумковий набір
-- у вигляді таблиці зі стовпцями maker, pc, laptop та printer, у якій для

-- кожного виробника необхідно вказати кількість продукції, що ним ви-
-- пускається, тобто наявну загальну кількість продукції в таблицях, від-
-- повідно, PC, Laptop та Printer. (Підказка: використовувати підзапити в

-- якості обчислювальних стовпців)

SELECT Product.maker, COUNT(Laptop.model) number_of_laptops, COUNT(PC.model) number_of_pcs, COUNT(Printer.model) number_of_printers
FROM Product
LEFT JOIN Laptop ON Laptop.model = Product.model
LEFT JOIN PC ON PC.model = Product.model
LEFT JOIN Printer ON Printer.model = Product.model
GROUP BY Product.maker ORDER BY Product.maker;

-- 9
-- Для таблиці Product отримати підсумковий набір

-- у вигляді таблиці зі стовпцями maker, laptop, у якій для кожного ви-
-- робника необхідно вказати, чи виробляє він ('yes'), чи ні ('no')

-- відповідний тип продукції. У першому випадку ('yes') додатково
-- вказати поруч у круглих дужках загальну кількість наявної (тобто, що
-- знаходиться в таблиці Laptop) продукції, наприклад, 'yes(2)'. (Підказка:
-- використовувати підзапити в якості обчислювальних стовпців та
-- оператор CASE)

SELECT Product.maker,
case
when COUNT(Laptop.model) > 0 then concat('yes', '(', COUNT(Laptop.model), ')')
else 'no'
end makes_laptops
FROM Product
LEFT JOIN Laptop ON Laptop.model = Product.model
GROUP BY Product.maker ORDER BY Product.maker;

-- 10
-- Знайдіть класи, до яких входить лише один кора-
-- бель з усієї БД (врахувати також кораблі в таблиці Outcomes, яких

-- немає в таблиці Ships). Вивести: class. (Підказка: використовувати
-- оператор UNION та операцію EXISTS)

SELECT Ships.class, COUNT(Ships.name) number_of_ships FROM Ships
GROUP BY Ships.class
HAVING number_of_ships = 1
UNION
SELECT Outcomes.battle, COUNT(Outcomes.ship) number_of_ships FROM Outcomes
GROUP BY Outcomes.battle
HAVING number_of_ships = 1;

INSERT INTO Classes(class, type, country, numGuns, bore, displacement) VALUE("First", "bb", "Ukraine", 69, 11, 40000);
INSERT INTO Ships(name, class, launched) VALUE("NewShip", "First", 1001);
DELETE FROM Ships WHERE class = "First";
DELETE FROM Classes WHERE class = "First";

INSERT INTO Battles(name, date) VALUE("Battle1", '1212-12-12 00:00:00');
INSERT INTO Outcomes(ship, battle, result) VALUE("Kokolo", "Battle1", "won");
DELETE FROM Outcomes WHERE battle = "Battle1";
DELETE FROM Battles WHERE name = "Battle1";


