1. O cliente não consegue se conectar e apresenta erro, pois não existe um servidor esperando naquela porta. No TCP, o servidor precisa estar ligado primeiro para aceitar a conexão.

2. O TCP usa números de sequência e confirmações de recebimento (ACK) para organizar as mensagens e garantir que elas cheguem na ordem correta.

3. Não suporta. O servidor aceita apenas um cliente por vez, pois depois do accept() ele fica preso atendendo somente essa conexão. Para aceitar vários clientes seria necessário criar uma thread para cada cliente.

-------------- PARTE B ----------------

1. Com o servidor desligado, a mensagem foi enviada pelo cliente, mas não apareceu nenhuma resposta. Isso acontece porque o UDP não verifica se existe um servidor conectado antes de enviar os dados. No TCP seria diferente, pois o cliente não conseguiria conectar e apresentaria erro, já que o TCP precisa estabelecer uma conexão antes da comunicação.

2. Um exemplo é jogos online, pois precisam de respostas rápidas e é melhor perder alguns pacotes do que atrasar a comunicação.
   Outro exemplo é streaming de vídeo e chamadas de vídeo, pois a velocidade é mais importante que garantir todos os pacotes. Um pequeno atraso é pior do que perder alguns dados.

3. Sim, seria possível. O servidor teria que guardar informações dos clientes. A aplicação ficaria mais parecida com um sistema de controle de conexões, mesmo o UDP não tendo conexão de verdade.

-------------- PARTE C ----------------

1. No unicast, o servidor precisa enviar a mesma mensagem separadamente para cada cliente, aumentando o tráfego da rede. No multicast, ele envia apenas uma vez para o grupo, e os clientes recebem a mesma mensagem, economizando banda.

2. O TTL define até onde o pacote multicast pode chegar na rede, controlando a quantidade de roteadores que ele pode atravessar. Ele evita que mensagens sejam enviadas para redes muito distantes sem necessidade.

3. Não. O cliente não recebe as mensagens antigas porque o multicast não armazena os avisos enviados. Ele só recebe as mensagens que forem enviadas enquanto estiver conectado ao grupo.

-------------- PARTE D ----------------

1. Depois do handshake, a conexão deixa de ser uma comunicação HTTP normal e passa a usar o protocolo WebSocket. A conexão TCP continua aberta, permitindo troca de mensagens nos dois sentidos em tempo real.

2. No WebSocket, o servidor mantém uma lista dos clientes conectados e envia a mensagem para cada um deles. No Multicast, o servidor envia para um grupo de rede, e os clientes que estiverem inscritos nesse grupo recebem a mensagem.

3. Porque o WebSocket já possui uma estrutura pronta para comunicação em tempo real, com mensagens e vários clientes conectados. No TCP puro seria necessário criar manualmente o controle das conexões e o envio das mensagens para cada client



