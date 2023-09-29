# České zadání

Nevytvářejte fork tohoto repozitáře, ale místo toho [duplikujte toto úložiště](https://docs.github.com/en/repositories/creating-and-managing-repositories/duplicating-a-repository). Pokud se přihlásíte na GitHub, můžete vytvořit repozitář ze šablony. Pokud se přihlásíte na GitHub, můžete [vytvořit repozitář ze šablony](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template).

![Use this template button](https://docs.github.com/assets/cb-95207/images/help/repository/use-this-template-button.png)

Svět JavaScriptových frameworků je velmi nepřehledný a nestálý. Chceme mít nástroj pro jejich evidenci, ke kterému budeme přistupovat pomocí jednoduchého REST API. Informace by měly obsahovat:
* jméno frameworku
* čísla verzí
* datum, kdy která verze přestala být aktuální (kdy přestala být podporovaná)
* hodnocení ve stylu 1-5 hvězdiček

API by mělo umožňovat následující operace:
* výpis všech záznamů
* přidávat další záznamy
* upravovat existující záznam
* smazat existující záznam
* fulltextově vyhledávat v záznamech podle zadání uživatele


## Použité technologie

* Spring Boot
* Java 17
* Gradle
* JUnit 5
* H2 in-memory databáze pro tento příklad postačuje
* libovolné vývojové prostředí, doporučujeme [IntelliJ IDEA](https://www.jetbrains.com/idea/), nebo [Eclipse IDE](https://www.eclipse.org/ide/)


## Rozchození

Je potřeba mít nainstalované JDK 17. Preferujeme verzi OpenJDK z distribuce [Eclipse Temurin](https://adoptium.net/), ale fungovat by měla jakákoliv. Následně stačí spustit `gradlew.bat` (Windows) nebo `./gradlew` (MacOS a Linux) v tomto adresáři s parametry:
* `build` - sestavení aplikace
* `bootRun` - spuštění aplikace
* `test` - spuštění testů


## Co hodnotíme

Hodnotíme hlavně funkčnost, správnost a udržitelnost kódu. Řešení není potřeba dopracovávat do zcela funkčního celku, ale samozřejmě inciativu oceníme. Očekáváme, že řešení zabere několik hodin až maximálně dva dny, více času nemá smysl tomu věnovat. Neočekáváme dodání do druhého dne, spíše počítáme s řešením v klidu přes víkend. Řešení slouží jako podklad pro diskuzi na pohovoru.

---

# English instructions

Do not fork this repository, but instead [duplicate this repository](https://docs.github.com/en/repositories/creating-and-managing-repositories/duplicating-a-repository). If you login to GitHub, you can [create a repository from a template](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template).

![Use this template button](https://docs.github.com/assets/cb-95207/images/help/repository/use-this-template-button.png)

The world of JavaScript frameworks is pretty chaotic and unstable place. We want to have a tool for record keeping of JavaScript frameworks. We'd like to use it through a REST API. The information should include:
* the name of the framework
* version numbers
* date of deprecation of framework versions (the date when the version stopped being supported)
* rating (1 to 5 stars)

The API should be able to carry out these operations:
* list all entries
* insert new entries
* modify existing entry
* delete existing entry
* fulltext search in entry data according to user input


## Used technologies

* Spring Boot
* Java 17
* Gradle
* JUnit 5
* H2 in-memory database is sufficient for this example
* any suitable development environment, we recommend [IntelliJ IDEA](https://www.jetbrains.com/idea/), or [Eclipse IDE](https://www.eclipse.org/ide/)


## How to start

You'll need to have JDK 17 installed beforehand. We prefer OpenJDK distribution from [Eclipse Temurin](https://adoptium.net/) project. Afterwards, you only need to run `gradle.bat` (on Windows) or `./gradlew` (on MacOS or Linux) in this directory with those parameters:
* `build` - build the application
* `bootRun` - run the application
* `test` - run tests


## What will be judged?

The most important aspects of the solution for us are functionality, correctness, and maintainability of the code. Completing the full working application is not necessary but we will appreciate the initiative. The assignment should take from a few hours to two days at maximum. We don't expect to have solution the next day, we'd rather you take your time and maybe do it on weekend. The solution serves as a basis for discussion during the interview.
