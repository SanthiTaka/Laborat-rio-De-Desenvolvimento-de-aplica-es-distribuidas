1. O cliente não consegue se conectar e apresenta erro, pois não existe um servidor esperando naquela porta. No TCP, o servidor precisa estar ligado primeiro para aceitar a conexão.

2. O TCP usa números de sequência e confirmações de recebimento (ACK) para organizar as mensagens e garantir que elas cheguem na ordem correta.

3. Não suporta. O servidor aceita apenas um cliente por vez, pois depois do accept() ele fica preso atendendo somente essa conexão. Para aceitar vários clientes seria necessário criar uma thread para cada cliente.
