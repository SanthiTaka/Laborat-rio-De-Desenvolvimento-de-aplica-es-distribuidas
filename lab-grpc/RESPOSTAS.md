--------- ROTEIRO 3 ------------------
1. No UDP/ TCP e Websocket, o cliente conhece o localHost e a porta do servidor. ja no Multicast, o cliente conhece diretamente o grupo e a porta. Portanto, a localizacao esta embutido no codigo, o que nao favorece a transparencia. Se a localizacao do servidor mudar, o cliente precisa saber deassa mudança.

2. Isso se caracteriza como meio termo, justamente porque exsite uma interface de comunicao com cliente, mas o servidor precisa conhecer o formato e conteudo das mensagens.

3. Como a solucao nao possui transparencia de localizacao suficiente para que o servidor mude de maquina, vai ter que ser preciso alterar ou recongifurar o cliente.