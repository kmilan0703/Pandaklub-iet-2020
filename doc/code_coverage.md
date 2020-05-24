# Kód lefedettség
## Teszt kijavítása
Ide még kell írni!!!
## Nem használt osztályok/metódusok eltávolítása
A Beans osztály getDeclaredFields metódusa, és a Fields osztály nem kellet a könyvtár megfelelő működéséhez, ugyanis az getter és setter metódusokat használ a bean-ek olvasására/módosítására. A SourcedObject és a SourcedObjectImpl interfész és megvalósítása pedig egy már nem használt, vagy még el nem készült feature részei, ami jelenleg nincs használva. Ezeket mind biztonságosan el tudtuk távolítani a projektből és ezzel nőtt a kód lefedettség.
