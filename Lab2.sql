use Labor_SQL;

-- 1
SELECT distinct maker, type FROM Product WHERE type = "PC" order by maker desc;

-- 2
SELECT date from Pass_in_trip where place like "%c";

-- 3
SELECT Passenger.name, Pass_in_trip.date
FROM Passenger
LEFT JOIN Pass_in_trip
ON Passenger.ID_psg = Pass_in_trip.ID_psg;

-- 4
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
SELECT (SELECT Product.maker FROM Product WHERE Product.model = Laptop.model) maker FROM Laptop
WHERE not exists(
SELECT Printer.code FROM Printer
WHERE (SELECT Product.maker FROM Product WHERE Product.model = Laptop.model) = (SELECT Product.maker FROM Product WHERE Product.model = Printer.model)
);

-- 6
SELECT concat("code: ", code), concat("model: ", model), concat("color: ", color), concat("type: ", type), concat("price: ", price)
FROM Printer;

-- 7
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
SELECT Product.maker, COUNT(Laptop.model) number_of_laptops, COUNT(PC.model) number_of_pcs, COUNT(Printer.model) number_of_printers
FROM Product
LEFT JOIN Laptop ON Laptop.model = Product.model
LEFT JOIN PC ON PC.model = Product.model
LEFT JOIN Printer ON Printer.model = Product.model
GROUP BY Product.maker ORDER BY Product.maker;

-- 9
SELECT Product.maker,
case
when COUNT(Laptop.model) > 0 then concat('yes', '(', COUNT(Laptop.model), ')')
else 'no'
end makes_laptops
FROM Product
LEFT JOIN Laptop ON Laptop.model = Product.model
GROUP BY Product.maker ORDER BY Product.maker;

-- 10
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


