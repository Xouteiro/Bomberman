## LDTS_T15G1 - Bomberman

A ideia principal do nosso projeto é recriar o jogo estragégico de computador Bomberman, através do uso de Java. O jogo envolve colocar bombas para explodir blocos, derrotar todos os inimigos e encontrar a porta para passar para o próximo nível.

O projeto foi desenvolvido por Daniel Vecera, Gabriela Silva e Xavier Outeiro para a disciplina de LDTS 2022⁄23.

### FEATURES IMPLEMENTADAS

- **Poderes** - Vão-se encontrar escondidos nos blocos destrutíveis e irão permitir imunidade a explosões, assim como passagem por cima de bombas e blocos.
- **Colocação de bombas** - A personagem vai colocar uma bomba no sítio onde se encontra ao premir a tecla do espaço.
- **Derrotar os inimigos** - Se um inimigo estiver no alcance de uma bomba, vão ser derrotados.
- **Explosão de blocos destrutíveis** - Se um destes blocos estiver no alcance de uma bomba, vão ser destruídos.
- **Vitória no jogo** - Este evento ocorre ao encontrar a porta escondida num dos blocos destrutíveis e todos os inimigos estarem derrotados.
- **Colisões** - O jogador irá colidir com as paredes exteriores e blocos fixos quando se mover na direção deles.

### FEATURES PLANEADAS

- Foram implementadas todas as *features* que se pretendia obrigatoriamente ter concluídas aquando do começo do projeto.

### MOCKUPS

**Arena**

![Arena](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/Arena.png) 

**Game Over**

![Game Over](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/GameOver.png)

**Menu**

![Menu](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/Menu.png)

**Vitória**

![Vitória](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/Victory.png)

### DESIGN

#### COMPORTAMENTO DA PERSONAGEM CONTROLADA VARIÁVEL


**Problema em contexto** 

O comportamento das ações do jogador irá variar consoante os diferentes poderes que adquiriu durante o jogo até aí (irá potencialmente conseguir passar por cima das bombas que colocou, estas poderão ganhar maior alcance, etc.).

**Padrão utilizado**

Aplicou-se o padrão *State* na estruturação do programa, onde o comportamento de um objeto depende do seu estado atual, e esse estado irá-se alterar durante o run-time do jogo. Este método irá permitir localizar e dividir comportamentos para diversos estados, assim como fazer as transições de estado explícitas.

**Implementação**

As classes relacionadas são as apresentadas abaixo e estão contidas nos ficheiros associados:

- [Player](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/Player.java)
- [StaticBlock](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/FixBlock.java)
- [TempBlock](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/TempBlock.java)
- [Enemy](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/Enemy.java)
- [Power](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/Power.java)
- [Wall](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/Wall.java)
- [Bomb](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/model/game/elements/Bomb.java)

**Consequências**

- Os vários estados que representam as abilidades e comportamento da personagem principal ficam explícitos no código, em vez de baseados em flags.
- Não será necessário o uso de grandes conjuntos de *ifs* e *switches* associados aos diversos estados. Ao invés disso, o polimorfismo vai ativar as ações certas.

#### EXCESSO DE CÓDIGO NUMA SECÇÃO E DIFÍCIL LEITURA


**Problema em contexto** 

Devido à possível existência de uma quantidade excessiva de código e desorganização caso este fosse restringido a um único ficheiro, procurou-se escolher uma arquitetura que melhor resolvesse este problema e se adequasse às especificações únicas do programa em questão.

**Padrão utilizado**

Dada a grande quantidade de código e diversas classes a utilizar ao todo, para criar o programa de uma maneira mais eficaz e organizada, foi escolhido o padrão de arquitetura Model-view-controller (MVC), tendo também em conta o uso de uma *graphical user interface* (GUI).

**Diagrama de classes UML**

![Diagram](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/diagram.png) 

### TESTAGEM

**Coverage testing**

![Coverage](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/coverageInterm.png) 

### AUTOAVALIAÇÃO

- Daniel Vecera: 33.3%
- Gabriela Silva: 33.3%
- Xavier Outeiro: 33.3%

------
