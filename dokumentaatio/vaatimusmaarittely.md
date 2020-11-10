# Vaatimusmäärittely

## Sovelluksen tarkoitus

Yksinkertainen "Tower Defence" tyyppinen, yhden pelaajan peli. Pelaaja rakentaa, sekä strategisesti asettaa kartalle torneja. Viholliset kävelevät kartan läpi määriteltyä polkua pitkin päästä päähän. Yksi peli koostuu useasta aallosta vihollisia. Jokainen aalto on edellistä vaarallisempi. Pelaajan tavoitteena rakentaa ja asettaa tornit niin, että ne onnistuvat tuhoamaan kaikki viholliset ennenkuin ne pääsevät polun loppuun asti. Jokainen tuhottu vihollinen antaa pelaajalle tietyn määrän rahaa. Rahaa käytetään uusien tornien rakentamiseen, sekä mahdollisesti tornien päivitysten ostamiseen. Peli päättyy pelaajan tappioon, kun liian monta vihollista on päässyt livahtamaan kartan läpi. Pelaaja voittaa, kun kaikki vihollisaallot on tuhottu.

## Perusversion tarjoama toiminnallisuus 

- Pieni määrä erilaisia torneja, joilla erilaisia funktioita. Esim. eri vihollistyyppejä vastaan.
  - Perustorni, joka vahingoittaa yhtä vastustajaa kerrallaan ammuksillaan.
  - Aluevahinko-torni, tekee ammuksillaan vahinkoa jollain isommalla alueella jokaiseen alueella olevaan viholliseen.
  - Hidastustorni, hidastaa tornin ympärillä olevien vihollisia nopeutta.
- Erilaisia vihollisia.
  - Perusvihollinen.
  - Nopea vihollinen, perusvihollista vähemmän elämäpisteitä.
  - Perusvihollista heikompi pienempi vihollinen, esiintyy isompina laumoina aallossa.
- Kartta, jolla peli pyörii.
  - Kartalla on polku, jota pitkin viholliset kulkevat.
  - Kartalla on paikkoja, joille pelaaja voi asettaa torneja.
- Pisteytyssysteemi, joka mittaa sitä kuinka optimaalisesti peli on pelattu.
- Paikallinen tulostaulukko, jolla näkyy parhaat pistesaaliit, sekä ne keränneet pelaajat.

## Jatkokehitysideoita

- Erilaisia karttoja, joista valita.
- Lisää erilaisia vihollisia.
- Torneille päivityksiä.
- Gamestaten tallennus, voi jatkaa siitä mihin jäi.