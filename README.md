# VeeDigital
Teste Java por Riberto Junior - ribertojunior@gmail.com

## Instru��es
Para escolher qual teste rodar usa-se como primeito argumento o n�mero equivalante de cada teste, 1 para o Teste 1, 2 para o Teste 2, 3 para o Teste 3.

Para o teste 1 deve-se fornecer mais tr�s argumentos: a palavra que se deseja testar, true ou false para ignorar espa�os (false ignora), true ou false para ignorar caixa do texto (false ignora).

Os par�metros do Teste 2 s�o poss�veis em duas vers�es:<br> 
- Na primeira, s�o dois par�metros o n�mero para qual se deve encontrar o complementar no array e o arquivo texto onde se encontra o array (em uma linha, com os elemntos separados por espa�o).<br> 
- Na segunda, temos o mesmo par�metro doa primeira e em seguida k par�metros, sendo cada um elemento do array.

Para o Teste 3 temos apenas um par�metro com o endere�o local do arquivo a ser analisado.

### Exemplos
java -jar VeeDigital.jar 1 "ovo e ovo" false false - para o teste 1.<br>
java -jar VeeDigital.jar 2 3 2 1 1 2 0 - para o teste 2.<br>
java -jar VeeDigital.jar 3 "C:\\Users\\riber\\git\\VeeDigital\\src\\file\\arq_c.txt" - para o teste 3.