# VeeDigital
Teste Java por Riberto Junior - ribertojunior@gmail.com

## Instruções
Para escolher qual teste rodar usa-se como primeiro argumento o número equivalente de cada teste, 1 para o Teste 1, 2 para o Teste 2, 3 para o Teste 3.<br>

Para o teste 1 deve-se fornecer mais três argumentos: a palavra que se deseja testar, true ou false para ignorar espaços (false ignora), true ou false para ignorar caixa do texto (false ignora).<br>

Os parâmetros do Teste 2 são possíveis em duas versões:<br>

- Na primeira, são dois parâmetros o número para qual se deve encontrar o complementar no array e o arquivo texto onde se encontra o array (em uma linha, com os elemntos separados por espaço).<br>
- Na segunda, temos o mesmo parâmetro da primeira e em seguida n parâmetros, sendo cada um elemento do array de n elementos.<br>


Para o Teste 3 temos apenas um parâmetro com o endereço local do arquivo a ser analisado.<br>

### Exemplos
Quando na pasta onde o arquivo jar está:

java -jar VeeDigital.jar 1 "ovo e ovo" false false - para o teste 1.
java -jar VeeDigital.jar 2 3 2 1 1 2 0 - para o teste 2.
java -jar VeeDigital.jar 3 "C:\Users\riber\git\VeeDigital\src\file\arq_c.txt" - para o teste 3.