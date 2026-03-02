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
