# VeeDigital
Teste Java por Riberto Junior - ribertojunior@gmail.com

## Instru��es
Para escolher qual teste rodar usa-se como primeiro argumento o n�mero equivalente de cada teste, 1 para o Teste 1, 2 para o Teste 2, 3 para o Teste 3.

Para o teste 1 deve-se fornecer mais tr�s argumentos: a palavra que se deseja testar, true ou false para ignorar espa�os (false ignora), true ou false para ignorar caixa do texto (false ignora).

Os par�metros do Teste 2 s�o poss�veis em duas vers�es:<br>

- Na primeira, s�o dois par�metros o n�mero para qual se deve encontrar o complementar no array e o arquivo texto onde se encontra o array (em uma linha, com os elemntos separados por espa�o).
- Na segunda, temos o mesmo par�metro da primeira e em seguida n par�metros, sendo cada um elemento do array de n elementos.


Para o Teste 3 temos apenas um par�metro com o endere�o local do arquivo a ser analisado.<br>

### Exemplos
Quando na pasta onde o arquivo jar est�:

java -jar VeeDigital.jar 1 "ovo e ovo" false false - para o teste 1.

java -jar VeeDigital.jar 2 3 2 1 1 2 0 - para o teste 2.

java -jar VeeDigital.jar 3 "C:\Users\riber\git\VeeDigital\src\file\arq_c.txt" - para o teste 3.