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