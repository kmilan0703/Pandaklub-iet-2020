# Code smell-ek javítása

A kód minőségén a fájlokban található code smell-ek refaktorálásával javítottunk. Ezeket Sonar segítségével kerestük meg. 
![](images/sonar.PNG)

A kezdeti 68 code smell-ből a végére már csak 30 maradt. 

Voltak nagyon gyorsan és könnyen kijavítható code smell-ek, például:
-egy objektumot új sorba kellett inicializálni, nem az előzővel összevonni
-kivételkezelésnél Throwable helyett Exception használata
-" " helyett ' ' használata
-if-else ágak összevonása, ha ugyanaz a művelet hajtódott végre több ágban is
-kódoláshoz használt import átírása
-felesleges import és komment törlése

Kettő nagyobb code smell-et is javítottunk a projektben:

-Az egyik ilyen egy NullPointerException bug volt, emiatt a Sonar test meg is bukott, amíg nem került javításra. Ennek oka az volt, hogy a függvényben használt egyik attribútumra hiányzott egy !=null vizsgálat, és ha mégis egyenlő egy else ágban lekezelni ezt a helyzetet is. 

-A másik kivételkezeléssel kapcsolatos code smell esetén egy saját osztályt kellett létrehozni UnsupportedLiteralException néven, melyet az egyik függvénynél a RuntimeException helyett használunk a kód minőség javításának érdekében. 

Kezdetben a code coverage 68.7 %-on állt: 

![](images/before-sonar.png)

Végeredményként ezt 74%-ra sikerült javítanunk:

![](images/after-sonar.PNG)
