## LDTS_T15G1 - Bomberman

A ideia principal do nosso projeto é recriar o jogo estragégico de computador Bomberman, através do uso de Java. O jogo envolve colocar bombas para explodir blocos e assim encontrar a porta para passar de nível, e derrotar todos os inimigos para esta se abrir.

O projeto foi desenvolvido por Daniel Vecera, Gabriela Silva e Xavier Outeiro para a disciplina de LDTS 2022⁄23.

### FEATURES IMPLEMENTADAS

- **Colocação de bombas** - A personagem vai colocar uma bomba no sítio onde se encontra ao premir a tecla do espaço.
- **Passagem de nível** - Este evento ocorre ao encontrar a porta escondida num dos blocos destrutíveis e todos os inimigos estarem derrotados.
- **Derrotar os inimigos** - Se um inimigo estiver no alcance de uma bomba, vão ser derrotados.
- **Explosão de blocos destrutíveis** - Se um destes blocos estiver no alcance de uma bomba, vão ser destruídos.

### FEATURES PLANEADAS

- **Poderes** - Vão se encontrar escondidos nos blocos destrutíveis e irão permitir maior velocidade, passagem por cima das bombas, etc.

### FEATURES POSSÍVEIS

- **Items bónus** - Items raros desbloqueados pela conquista de pontos

### MOCKUP


### DESIGN

**Implementação**

As classes usadas são as apresentadas abaixo e estão contidas nos ficheiros associados:

- [Player](https://github.com/FEUP-LDTS-2022/project-l15gr01/src/main/java/elements/Player.java)
- [StaticBlocks](https://github.com/FEUP-LDTS-2022/project-l15gr01/src/main/java/elements/StaticBlock.java)
- [TempBlocks](https://github.com/FEUP-LDTS-2022/project-l15gr01/src/main/java/elements/TempBlock.java)
- [Enemies](https://github.com/FEUP-LDTS-2022/project-l15gr01/src/main/java/elements/Enemies.java)
- [Powers](https://github.com/FEUP-LDTS-2022/project-l15gr01/src/main/java/elements/Powers.java)

------
