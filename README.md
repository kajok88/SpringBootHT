# SpringBootHT
Palvelinohjelmoinnin harjoitustyö
___
## Suunnitelma

Ideana oli alunperin toteuttaa muistiinpano-sovellus, johon on myös mahdollista
liittää kuvia tekstin lisäksi ja frontend Reactilla. Muistiinpanot voidaan tallentaa paikalliselle
MSSQL serverille tai H2 tietokantaan. Kokonaisvaltainen toiminallisuus löytyy käyttöliittymöstä selaimen
puolelta osoitteesta: http://localhost:8074/.

> Kuvien liittämisestä ja fronendin tekemisestä Reactilla jouduin kuitenkin luopumaan rajallisen ajan vuoksi. 
> Mahdollisesti jatkokehitän tulevaisuudessa, jolloin lisään myös Telegram-botin hälyttämään muistiinpanojen "eräpäivistä".
___

Käytetyt resurssit:
- DB: Microsoft SQL server 19, H2, Flyway migraatioita varten
- Backend: Spring Boot 3.2.1 & Spring Security 6.2.2
- Frontend: Thymeleaf & Bootstrap
- Java 17

___


Päädyin käyttämään MSSQL serverin versiota 19, sillä kyseinen 
versio on minulle entuudestaan tuttu, ja halusin välttyä 
mahdollisilta ajureiden yhteensopivuusongelmilta tämän 
harjoitustyön kanssa.

---
## Toiminnallisuus
- Käyttäjien rekisteröinti ja kirjautumien rekisteröidyillä tunnuksilla (käyttäjänimi ja salasana).
- Käyttäjäkohtainen Notes -näkymä muistiinpanoille, jossa muistiinpanoja voidaan lajitella eri sarakkeiden mukaan ja etsiä hakukentän avulla (Sama toiminnallisuus myös kategorioilla).
- Käyttäjäkohtainen My Categories -näkymä (Löytyy navigointipalkin linkistä "Categories") kaikille käyttäjän kategoriolle.
- Muistiinpanoja ja kategorioita voidaan siis luoda, editoida ja poistaa (CRUD). Muistiinpanoja luodessa, voidaan niille asettaa haluttu kategoria, joka yhdistää musitiinpanon k.o. kategoriaan.
- Dev/Prod konfiguraatioprofiilit. Dev -profiili käyttää tietokantanaan H2 tietokantaa ja Prod -profiili Microsoft SQL server:iä. Microsoft sql serverin kanssa tulee ensin luoda tietokanta "Notes", jonka jälkeen flyway huolehtii oikeiden taulujen täyttämisestä ym. Itse käytin MS SQL serveriä dockerissa.
- Kentissä on käytössä myös syötteiden validointia.
- Thymeleafissa on hyödynnetty fragmentteja toistuvien rakenteiden hallinnoimiseksi

### Muita:
- Yksittäisen eventin näyttäminen path-muuttujien avulla
- Kategoriatagit kategorioille

## Huom.
> Jos jos käytössä on LocalTime.now() -funktio ajan generoimiseen ja ohjelmaa käytetään klo 00 - 01 välisenä aikana, tulee ongelmia hibernaten kanssa,
> kun se yrittää muuttaa SQL Time:n LocalTime:ksi. Päädyin siis käyttämään javacriptiä.
> 
> Aiheesta lisää: https://discourse.hibernate.org/t/hibernate-incorrectly-converting-sql-time-to-localtime-between-12am-and-1am-only-if-using-localtime-now/7866