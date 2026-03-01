# Noc za hranicí

Textová adventura v Javě inspirovaná hororovou atmosférou zakázaného lesa.
Hraješ za archeologa, který překročil starou bránu do světa, kde neplatí běžné zákony času a prostoru.
Cílem je přežít noc za hranicí, odhalit tajemství lesa a dostat se k zakončení hry.

## Ovládání (příkazy)
Příkazy se zadávají do konzole ve formátu: `prikaz argument`

- `jdi <směr>` – pohyb do jiné lokace (např. `jdi les`, `jdi brana`)
- `prozkoumej` – vypíše popis lokace, postavy, předměty a východy
- `vezmi <id_predmetu>` – sebere předmět z lokace do inventáře (např. `vezmi rusty_key`)
- `inventar` – vypíše obsah inventáře
- `pouzij <id_predmetu>` – použije předmět (např. `pouzij torch`)
- `mluv <id_npc>` – zahájí dialog s postavou (např. `mluv havel`)
- `utoc <id_npc>` – útok na NPC (např. `utoc nameless_shadows`)
- `ukoly` – vypíše úkoly / umožní aktivaci úkolu (podle implementace)
- `napoveda` – vypíše seznam příkazů

## Herní mechaniky
- Svět je načítán z JSON souboru (lokace, směry, NPC, předměty, questy).
- Inventář hráče a použití předmětů (pochodeň, klíč, amulet…).
- Boj s NPC (HP, damage, možnost dropu předmětů).
- Quest systém (aktivace / splnění).

## Spuštění hry (IDE)
1. Otevři projekt v IntelliJ IDEA.
2. Spusť třídu `Main`.

## Spuštění hry (JAR)
1. Ujisti se, že máš Java 17+ (nebo verzi dle projektu).
2. Spusť:
   ```bash
   java -jar noc-za-hranici.jar

> Pokud máš jiné názvy tříd / jar jméno, uprav.

---

## 5) Jak vyrobit spustitelný .jar v IntelliJ (rychle)
### Varianta A: Artifact (nejjednodušší ve škole)
1. **File → Project Structure…**
2. **Artifacts → + → JAR → From modules with dependencies**
3. Vyber `Main` jako Main Class
4. Zaškrtni **Extract to the target JAR** (ať se přibalí knihovny jako Gson)
5. OK
6. **Build → Build Artifacts… → Build**

V `out/artifacts/...` najdeš jar.

### Varianta B: Maven/Gradle (pokud používáš)
- Maven: `mvn package`
- Gradle: `gradle shadowJar` / `gradle build`
  Ale pokud to máš “school style” bez build systému, Artifact je jistota.

---

## 6) Mini věci, co ti zvednou body
- V `napoveda` vypiš i příklady použití
- V `prozkoumej` vypisuj předměty i s jejich **ID**, aby hráč věděl co napsat do `vezmi/pouzij`
    - např. `Rezavý klíč (rusty_key)`
- Když hráč umře → vypiš konec hry + zastav loop (`running=false`)
- Do repa přidej i `gameData.json` do resources (a zkontroluj že je v jaru)

---

Jestli chceš, pošli mi výpis tvých příkazů (jak přesně se jmenují v parseru) a já ti upravím README, aby seděl 1:1 k tvé hře (ať tě nikdo nenachytá, že “README lže”).