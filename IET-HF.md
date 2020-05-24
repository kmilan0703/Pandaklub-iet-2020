# Pinto projekt

## Projekt célja

A Pinto egy olyan Java alapú keretrendszer, amelynek segítségével Java beaneket (lényegében olyan Java osztályok, amelyeknek minden adattagja privát láthatóságú, van egy paraméter nélküli publikus konstruktoruk és implementálják a Serializable interfészt) tudunk konvertálni RDF fájlokká és RDF fájlokat Java beanekké.
A konvertálás gyakorlati megvalósítása nagyon egyszerű, egy kódsor is elég hozzá, de a keretrendszer támogatja az annotációkat is, hogy az objektumok szerializálódását jobban kontrollálni tudjuk.

## Elvégzett feladataink

* ### Technológia fókusz

A keretrendszer beüzemelését a Gradle és a Github Actions CI teszi ki.
A manuális kód átvizsgáláshoz a Githubot alkalmazzuk, a statikus kód átvizsgáláshoz pedig a SonarQube-ot.
Kódlefedettség méréshez a Jacoco-t használjuk.

* ### Termék/felhasználó fókusz

A nem funkcionális jellemzők vizsgálatára teljesítmény tesztet vetünk be.
Ezen felül még manuális tesztelést is alkamazunk.