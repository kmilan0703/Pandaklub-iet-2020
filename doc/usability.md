# Felhasználhatóság értékelése

Egy program vagy keretrendszer felhasználhatóságának növeléséhez 5 alapelvet érdemes figyelembe venni, az alábbiakban is ez alapján értékeljük a kódot:

**1. Tanulhatóság**

A keretrendszer ennek a szempontnak megfelel, szintaxisa és használata egyszerű, így könnyen tanulható. Egy egyszerű, pl. Személy osztályból, melynek van getter-setter-e, már az alábbi egy sorral könnyen szerializálhatjuk RDF formátumba: 
Graph aGraph = RDFMapper.create().writeValue(new Person("Michael Grove"));

**2. Hatékonyság**

A hatékonyságot a teljesítményteszttel tudjuk a legjobban mérni. A projektünkben a doc/performance_test.md fájlban található ennek az eredménye, melynek alapján az mondható, hogy hatékonyságból nem a legmegfelelőbb a rendszer. Az RDF<--> Java konverzió esetében az egyre szaporodó pontok esetében a konverziós idő már exponenciálisan növekedett, ami nagyobb adatok feldolgozása esetén már hátrány lehet. 

**3. Megjegyezhetőség**

Ez a tulajdonság valamilyen szinten adódik az első szempontból. Mivel a keretrendszer használata könnyen tanulható és egyszerű, emiatt ebből a szempontból is jól teljesít.

**4. Hibatűrés**

Ebből a szempontból vannak hiányosságai a keretrendszernek. A manual-test.md fájlban leírt manuális tesztelés során kiderült, hogy a végtelen irányú konverzió oda-vissza irányba is problémát okoz, az alkalmazás StackOverflowError-ral kilép. 

**5. Elégedettség**

Ezt a szempontot, mivel nincsen a keretrendszernek UI felülete, talán leginkább az előzőekből levont következtetetések összegzésével lehet értékelni. Az előző 4 szempont közül 2 volt az, amire leginkább pozitív visszajekzést tudunk adni a tapasztaltak alapján, ebből következően még ezen a szemponton is lehetne javítani. 
