-- A utilizacao de IA foi para organziar e formular respostas mais claras e eficientes das que eu respondi! ( uso do chat gpt para analisar, completar e corrigir minhas respotas)

-------------- PARTE A -------------------

-TCP----

1. Sim. O endereço localhost e a porta 5093 estão escritos diretamente no código do cliente. Isso prejudica a transparência de localização, pois o cliente precisa conhecer onde o servidor está.

2. Sim. O cliente lê uma string do teclado e a envia diretamente pelo socket. O servidor precisa interpretar essa mensagem para saber o que deve fazer. Isso representa ausência ou baixa transparência de acesso, pois o programador precisa lidar diretamente com o formato da comunicação.

3. Se o servidor mudasse de máquina, o cliente não funcionaria sem alteração, pois seria necessário trocar localhost pelo novo endereço do servidor no código-fonte.

----UDP----

1. Sim. O endereço localhost e a porta 5094 estão escritos diretamente no código. Isso prejudica a transparência de localização, pois o cliente conhece explicitamente a localização do servidor.

2. Sim. A mensagem é convertida manualmente para bytes e colocada em um DatagramPacket. O servidor precisa interpretar os dados recebidos. Isso representa ausência ou baixa transparência de acesso, pois a comunicação e o formato dos dados são tratados diretamente pelo programador.

3. Se o servidor mudasse de máquina, o cliente precisaria ser alterado para utilizar o novo endereço. Portanto, não sobreviveria à mudança sem modificar o código-fonte.

----Multicast----

1. Sim. O endereço do grupo multicast 230.0.0.1 está escrito diretamente no código. Isso prejudica a transparência de localização, pois o cliente precisa conhecer o endereço do grupo ao qual deve se conectar.

2. Sim. As mensagens são recebidas como bytes e depois convertidas manualmente para String. O cliente e o servidor precisam conhecer o formato dos dados trocados. Isso representa baixa transparência de acesso, pois parte da comunicação precisa ser tratada manualmente.

3. Se o grupo multicast mudasse de endereço, o cliente precisaria ser alterado. Portanto, essa solução não sobreviveria a uma mudança do endereço do grupo sem modificar o código-fonte.

----WebSocket----

1. Sim. A URI ws://localhost:8980 está escrita diretamente no código do cliente. Isso prejudica a transparência de localização, pois o cliente precisa conhecer o endereço e a porta do servidor.

2. O cliente envia mensagens de texto diretamente usando sendText(), e recebe os textos através do onText(). Porém, o WebSocket já abstrai a criação dos sockets, o envio dos pacotes e parte do gerenciamento da comunicação. Portanto, há maior transparência de acesso em comparação com TCP e UDP, embora o formato das mensagens ainda seja responsabilidade da aplicação.

3. Se o servidor mudasse de máquina, o cliente não conseguiria se conectar ao novo servidor sem alterar a URI ws://localhost:8980 no código-fonte. Portanto, também não sobreviveria à mudança sem alteração.

Pasrte A - Resposrtas

1. Dentre os 8 tipos de transparência listados, qual você diria que é a mais visível para o programador que está usando um serviço remoto?

A transparência de acesso é uma das mais visíveis, pois o programador percebe diretamente como precisa utilizar o serviço remoto. Em um sistema com maior transparência de acesso, uma operação remota pode parecer uma chamada de função comum, sem exigir que o programador cuide diretamente de sockets, envio e recebimento de dados ou parsing das mensagens.

2. Transparência total é sempre desejável?

Não. Esconder completamente que uma operação é remota pode dificultar o tratamento de problemas de desempenho ou falhas. Por exemplo, uma chamada para um servidor distante pode demorar mais ou falhar caso exista um problema de rede. Se isso for totalmente escondido do programador, ele pode tratar a operação como se fosse local e não considerar situações como latência, timeout ou indisponibilidade do servidor.

3. Comparação entre TCP e gRPC

A resposta desta questão será complementada após a implementação das Partes C e D. No cliente TCP, é necessário lidar diretamente com aspectos da rede, como socket, envio e recebimento de dados e interpretação das mensagens. No gRPC, o programador pode chamar um método do serviço e receber o resultado, enquanto o framework cuida de grande parte da comunicação. Isso está relacionado principalmente à transparência de acesso.

Parte B — Respostas

1. O central.proto deixa definido de forma clara quais operações existem e quais dados são enviados e recebidos. Além disso, o código é gerado automaticamente, reduzindo erros e evitando que cliente e servidor precisem combinar manualmente o formato das mensagens.

2. Isso mostra que diferentes partes de um sistema distribuído podem ser desenvolvidas em linguagens diferentes e ainda assim se comunicar, desde que sigam o mesmo contrato definido no .proto. Assim, um servidor Java pode atender um cliente Python, por exemplo.

3. No Java, as operações aparecem na classe gerada CentralAtendimentoGrpc, que contém métodos relacionados ao serviço, como consultarHorario e acompanharAvisos. Em Python, elas também aparecem no código gerado em central_pb2_grpc.py, principalmente na classe CentralAtendimentoStub.

Parte B — Respostas

1. Entre a chamada do cliente e o retorno da resposta, o gRPC serializa a mensagem usando Protocol Buffers, envia a requisição pela rede usando HTTP/2 e, no servidor, desserializa a mensagem para executar o método. Depois, a resposta é serializada novamente, enviada ao cliente e desserializada automaticamente.

2. No ClienteTCP, o cliente precisava montar a mensagem manualmente e receber e interpretar a resposta usando strings. No gRPC, esse trabalho é feito automaticamente pelo framework e pelo código gerado a partir do arquivo .proto. Assim, o programador trabalha principalmente com objetos e métodos, sem precisar manipular diretamente sockets ou fazer parsing das mensagens.

3. Se o servidor estiver desligado, o cliente não consegue realizar a chamada RPC. No teste realizado em Python, o gRPC retornou o status `UNAVAILABLE` e a mensagem `Connection refused`, indicando que não havia nenhum servidor aceitando conexões na porta utilizada.
