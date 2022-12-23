## LDTS_T15G1 - Bomberman

A ideia principal do nosso projeto é recriar o jogo estragégico de computador Bomberman, através do uso de Java. O jogo envolve colocar bombas para explodir blocos, derrotar todos os inimigos e encontrar a porta para vencer o jogo.

O projeto foi desenvolvido por Daniel Vecera, Gabriela Silva e Xavier Outeiro para a disciplina de LDTS 2022⁄23.

## Features Implementadas

- **Poderes** - Vão-se encontrar escondidos em alguns blocos destrutíveis e irão adicionar vidas ou pontos, irão permitir imunidade a explosões ou a passagem por cima de bombas ou blocos. Em caso de colisão com um inimigo os poderes são perdidos.
- **Colocação de bombas** - O jogador coloca uma bomba no sítio onde se encontra ao premir a tecla B.
- **Derrotar os inimigos** - Se um inimigo estiver no alcance de uma bomba vai ser derrotado.
- **Explosão de blocos destrutíveis** - Os blocos que estiverem no alcance da explosão da bomba, vão ser destruídos.
- **Colisões** - O jogador colide com paredes exteriores, blocos fixos, blocos temporários e a bomba, quando se mover na direção deles, e ao colidir com os inimigos perde uma vida.
- **Game Over** - Este evento ocorre quando o jogaor perde todas as vidas.
- **Vitória no jogo** - Este evento ocorre quando o jogador encontra a porta escondida num dos blocos destrutíveis e a porta só fica disponível quando todos os inimigos forem derrotados.


## Features Planeadas

- Foram implementadas todas as *features* que se pretendia obrigatoriamente ter concluídas aquando do começo do projeto.


## GIF

![Arena](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/bombermanGIF.gif) 


## Design

### Comportamento da Personagem Controlada Variável

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

### Estrutura Geral do Código

**Problema em contexto** 

Devido à possível existência de uma quantidade excessiva de código e desorganização caso este fosse restringido a um único ficheiro, procurou-se escolher uma arquitetura que melhor resolvesse este problema e se adequasse às especificações únicas do programa em questão.

**Padrão utilizado**

Dada a grande quantidade de código e diversas classes a utilizar ao todo, para criar o programa de uma maneira mais eficaz e organizada, foi escolhido o padrão de arquitetura Model-view-controller (MVC), tendo também em conta o uso de uma *graphical user interface* (GUI).

**Diagrama de classes UML**

![Diagram](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/diagram_2.png) 

### GUI

**Problema em contexto** 

A biblioteca Lanterna tem diversas funções que não têm uso para o nosso programa em concreto, uma violação do princípio da segregação de interfaces (Interface Segregation Principle), e está em falta no que toca a outras funções de que a aplicação realmente necessita.

**Padrão utilizado**

Foi utilizado o padrão *Facade*, que permite uma interface simples para um sistema complexo, permitindo escolher apenas as *features* que realmente são importantes para a aplicação em questão.

**Implementação**

As classes relacionadas são as apresentadas abaixo e estão contidas nos ficheiros associados:

- [Game](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/Game.java)
- [GUI](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/gui/GUI.java)
- [LanternaGUI](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/src/main/java/feupL15G01/gui/LanternaGUI.java)

## Code Smells e Refactoring

**Classes de Grande Tamanho**

Certas classes, nomeadamente a *Game*, têm um grande tamanho enquanto outras, como a GUI contêm muitos métodos. Porém, são ambas justificáveis devido ao facto de Game ser a classe principal para a aplicação interativa propriamente dita, e necessariamente precisar de armazenar muitos dados, enquanto que apenas podemos chamar muitos métodos a partir do GUI também, não fazendo sentido subdividir esta classe também.

**Data Classes**

Todas as classes na parte *model* são Data Classes, dado que contêm apenas fields, e nenhum comportamento. Isto deve-se à estrutura escolhida de MVC (Model-View-Controller) como padrão de arquitetura, onde o controlador vai implementar as funcionalidades de lógica dessa parte. Não se trata, portanto, de um *code smell*, sendo apenas uma consequência natural da estrutura escolhida para o código.

**Refactoring do Código**

Na parte final de revisão do código compilado, foram feitos refactors no sentido de remover comentários deixados no começo da programação, encurtar métodos mais longos e clarificar alguns outros mais difíceis de entender a uma primeira vista. Por exemplo, **game.setState(new GameState(new RandomBoardBuilder(32, 32, 4,150 , 15).createBoard()))** passa a **game.setState(new GameState(board))**.

## Testagem

**Coverage testing**

![Coverage](https://github.com/FEUP-LDTS-2022/project-l15gr01/blob/develop/images/coverage_2.png) 

## Autoavaliação

- Daniel Vecera: 33.3%
- Gabriela Silva: 33.3%
- Xavier Outeiro: 33.3%

------
