# VeeDigital
Teste Java por Riberto Junior - ribertojunior@gmail.com

##Instruções
Para escolher qual teste rodar usa-se como primeito argumento o número equivalante de cada teste, 1 para o Teste 1, 2 para o Teste 2, 3 para o Teste 3.

Para o teste 1 deve-se fornecer mais três argumentos: a palavra que se deseja testar, true ou false para ignorar espaços (false ignora), true ou false para ignorar caixa do texto (false ignora).

Os parâmetros do Teste 2 são possíveis em duas versões:<br> 
- Na primeira, são dois parâmetros o número para qual se deve encontrar o complementar no array e o arquivo texto onde se encontra o array (em uma linha, com os elemntos separados por espaço).<br> 
- Na segunda, temos o mesmo parâmetro doa primeira e em seguida k parâmetros, sendo cada um elemento do array.

Para o Teste 3 temos apenas um parâmetro com o endereço local do arquivo a ser analisado.

###Exemplos
java VeeDigital 1 1 "ovo e ovo" false false - para o teste 1.<br>
java VeeDigital 2 6 2 1 1 2 0 - para o teste 2.<br>
java VeeDigital 3 "C:\\Users\\riber\\git\\VeeDigital\\src\\file\\arq_c.txt" - para o teste 3.