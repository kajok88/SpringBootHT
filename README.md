# SpringBootHT
Palvelinohjelmoinnin harjoitustyö
___
## Suunnitelma

Ideana on toteuttaa muistiinpano-sovellus, johon on myös mahdollista
liittää kuvia tekstin lisäksi. Muistiinpanot tallennetaan paikalliselle
MSSQL serverille. Kokonaisvaltainen toiminallisuus löytyy käyttöliittymöstö selaimen
puolelta.


___

Käytetyt resurssit:
- DB: Microsoft SQL server 19
- Backend: Spring Boot 3.1.6
- Frontend: Thymeleaf

___

Käytetyt dependencyt:

- Flyway tietokantamigraatiota varten

Päädyin käyttämään MSSQL serverin versiota 19, sillä kyseinen 
versio on minulle entuudestaan tuttu, ja halusin välttyä 
mahdollisilta ajureiden yhteensopivuusongelmilta tämän 
harjoitustyön kanssa.

Mikäli aikaa jää, saatan tehdä frontend:in Reactilla.


## Huom.
> Jos jos käytössä on LocalTime.now() -funktio ajan generoimiseen ja ohjelmaa käytetään klo 00 - 01 välisenä aikana, tulee ongelmia hibernaten kanssa,
> kun se yrittää muuttaa SQL Time:n LocalTime:ksi. Päädyin siis käyttämään javacriptiä.
> 
> Aiheesta lisää: https://discourse.hibernate.org/t/hibernate-incorrectly-converting-sql-time-to-localtime-between-12am-and-1am-only-if-using-localtime-now/7866