## LDTS_T15G1 - Bomberman

A ideia principal do nosso projeto é recriar o jogo estragégico de computador Bomberman, através do uso de Java. O jogo envolve colocar bombas para explodir blocos, derrotar todos os inimigos e encontrar a porta para passar para o próximo nível.

O projeto foi desenvolvido por Daniel Vecera, Gabriela Silva e Xavier Outeiro para a disciplina de LDTS 2022⁄23.

### FEATURES IMPLEMENTADAS



### FEATURES PLANEADAS

- **Poderes** - Vão-se encontrar escondidos nos blocos destrutíveis e irão permitir maior velocidade, passagem por cima das bombas, etc.
- **Colocação de bombas** - A personagem vai colocar uma bomba no sítio onde se encontra ao premir a tecla do espaço.
- **Passagem de nível** - Este evento ocorre ao encontrar a porta escondida num dos blocos destrutíveis e todos os inimigos estarem derrotados.
- **Derrotar os inimigos** - Se um inimigo estiver no alcance de uma bomba, vão ser derrotados.
- **Explosão de blocos destrutíveis** - Se um destes blocos estiver no alcance de uma bomba, vão ser destruídos.

### FEATURES POSSÍVEIS

- **Items bónus** - Items raros desbloqueados pela conquista de pontos

### MOCKUPS

**Arena**
![Arena](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/Arena.png) ![Game Over](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/GameOver.png)

**Game Over**


**Menu**
![Menu](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/Menu.png)

**Vitória**
![Vitória](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/Victory.png)

### DESIGN

**Problema em contexto** 

O comportamento das ações do jogador irá variar consoante os diferentes poderes que adquiriu durante o jogo até aí (irá potencialmente conseguir passar por cima das bombas que colocou, estas poderão ganhar maior alcance, etc.).

**Padrão utilizado**

Aplicou-se o padrão *State* na estruturação do programa, onde o comportamento de um objeto depende do seu estado atual, e esse estado irá-se alterar durante o run-time do jogo. Este método irá permitir localizar e dividir comportamentos para diversos estados, assim como fazer as transições de estado explícitas.

**Implementação**

As classes usadas são as apresentadas abaixo e estão contidas nos ficheiros associados:

- [Player](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/Player.java)
- [StaticBlock](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/FixBlock.java)
- [TempBlock](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/TempBlock.java)
- [Enemy](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/Enemy.java)
- [Power](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/Power.java)
- [Wall](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/Wall.java)

**Consequências**

- Os vários estados que representam as abilidades e comportamento da personagem principal ficam explícitos no código, em vez de baseados em flags.
- Não será necessário o uso de grandes conjuntos de *ifs* e *switches* associados aos diversos estados. Ao invés disso, o polimorfismo vai ativar as ações certas.

**Diagrama de classes UML**

### TESTAGEM

### AUTOAVALIAÇÃO

- Daniel Vecera (33.3%)
- Gabriela Silva (33.3%)
- Xavier Outeiro (33.3%)

------
