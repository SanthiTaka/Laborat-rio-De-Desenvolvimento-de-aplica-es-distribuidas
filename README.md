# Laboratório de Desenvolvimento de Aplicações Distribuídas

Projeto desenvolvido para prática de comunicação em redes utilizando diferentes protocolos, modelos de comunicação e arquiteturas distribuídas.

Foram implementadas aplicações cliente/servidor utilizando:

- TCP
- UDP
- Multicast
- WebSocket
- gRPC

As implementações foram realizadas utilizando **Java** e **Python**, permitindo comparar as características e diferenças entre os diferentes modelos de comunicação.

---

# Estrutura do Projeto

```text
lab-GRPC
│
├── java
│   ├── tcp
│   ├── udp
│   ├── multicast
│   ├── websocket
│   └── grpc-central
│       ├── pom.xml
│       └── src
│           └── main
│               ├── java
│               │   └── br
│               │       └── pucminas
│               │           └── labdamd
│               │               └── central
│               │                   ├── ClienteCentral.java
│               │                   └── ServidorCentral.java
│               └── proto
│                   └── central.proto
│
├── python
│   ├── tcp
│   ├── udp
│   ├── multicast
│   ├── websocket
│   └── grpc_central
│       ├── central_pb2.py
│       ├── central_pb2_grpc.py
│       ├── servidor_central.py
│       └── cliente_central.py
│
├── proto
│   └── central.proto
│
└── evidencias
    ├── tcp
    ├── udp
    ├── multicast
    ├── websocket
    └── streaming
        ├── streaming-java.png
        └── streaming-python.png
Tecnologias Utilizadas
Java
Java 17+
Maven
Java-WebSocket
gRPC
Protocol Buffers
Python
Python 3
grpcio
grpcio-tools
websockets

Instalação das bibliotecas Python:

pip install grpcio grpcio-tools websockets
Parte A — Comunicação TCP
Descrição

Implementação de comunicação utilizando TCP, onde o cliente estabelece uma conexão com o servidor antes de realizar a troca de mensagens.

Características:

Comunicação orientada à conexão;
Garantia de entrega das mensagens;
Mensagens recebidas na mesma ordem em que foram enviadas.
Execução Java

Servidor:

java ServidorTCP

Cliente:

java ClienteTCP
Execução Python

Servidor:

python servidor_tcp.py

Cliente:

python cliente_tcp.py
Parte B — Comunicação UDP
Descrição

Implementação utilizando UDP, onde as mensagens são enviadas sem estabelecer uma conexão prévia entre cliente e servidor.

Características:

Comunicação sem conexão;
Menor controle de entrega;
Menor overhead comparado ao TCP.
Execução Java

Servidor:

java ServidorUDP

Cliente:

java ClienteUDP
Execução Python

Servidor:

python servidor_udp.py

Cliente:

python cliente_udp.py
Parte C — Comunicação Multicast
Descrição

Implementação de comunicação em grupo utilizando multicast.

O servidor envia uma mensagem para um grupo multicast e todos os clientes inscritos nesse grupo recebem os avisos.

Características:

Um único envio para vários clientes;
Comunicação em grupo;
Não existe conexão individual entre servidor e clientes.

Grupo utilizado:

230.0.0.1
Execução Java

Servidor:

java ServidorMulticast

Cliente:

java ClienteMulticast
Execução Python

Servidor:

python servidor_multicast.py

Cliente:

python cliente_multicast.py
Parte D — WebSocket
Descrição

Implementação de um mural de avisos em tempo real utilizando WebSocket.

O servidor mantém conexões abertas com os clientes e encaminha as mensagens recebidas para os usuários conectados.

Características:

Comunicação bidirecional;
Conexão persistente;
Atualização em tempo real.
WebSocket Java
Estrutura
java/websocket

├── pom.xml

└── src
    └── main
        └── java
            ├── MuralServidor.java
            └── MuralCliente.java
Dependência Maven

Biblioteca utilizada:

<dependency>
    <groupId>org.java-websocket</groupId>
    <artifactId>Java-WebSocket</artifactId>
    <version>1.5.6</version>
</dependency>
Executar Java WebSocket

Entrar na pasta:

cd java/websocket

Compilar:

mvn compile

Servidor:

mvn exec:java "-Dexec.mainClass=MuralServidor"

Cliente:

mvn exec:java "-Dexec.mainClass=MuralCliente"
WebSocket Python
Estrutura
python/websocket

├── mural_servidor.py
└── mural_cliente.py
Executar Python WebSocket

Servidor:

python mural_servidor.py

Cliente:

python mural_cliente.py
Parte E — gRPC
Descrição

Implementação de comunicação utilizando gRPC (Google Remote Procedure Call) e Protocol Buffers.

O gRPC permite que o cliente invoque métodos remotos como se fossem chamadas de métodos locais, enquanto a comunicação e a serialização dos dados são realizadas pelo framework.

A aplicação implementa uma Central de Atendimento, permitindo consultar o horário atual e acompanhar avisos enviados pelo servidor.

Foram implementadas duas operações:

ConsultarHorario: RPC unário, com uma requisição e uma resposta;
AcompanharAvisos: RPC com server-side streaming, permitindo que o servidor envie vários avisos ao cliente ao longo da mesma conexão.
Protocol Buffers

O contrato da comunicação é definido no arquivo:

proto/central.proto

O serviço possui as seguintes operações:

ConsultarHorario
AcompanharAvisos

O arquivo .proto é utilizado para gerar automaticamente os códigos necessários para comunicação entre cliente e servidor.

gRPC Java
Estrutura
java/grpc-central

├── pom.xml
│
└── src
    └── main
        ├── java
        │   └── br
        │       └── pucminas
        │           └── labdamd
        │               └── central
        │                   ├── ClienteCentral.java
        │                   └── ServidorCentral.java
        │
        └── proto
            └── central.proto
Compilação

Entrar na pasta:

cd java/grpc-central

Compilar:

mvn clean compile
Executar o servidor
mvn compile exec:java "-Dexec.mainClass=br.pucminas.labdamd.central.ServidorCentral"

O servidor utiliza a porta:

50051 + OFFSET

Para o laboratório, foi utilizado:

OFFSET = 93
Porta = 50144
Executar o cliente

Em outro terminal:

mvn compile exec:java "-Dexec.mainClass=br.pucminas.labdamd.central.ClienteCentral"

O cliente solicita o nome do aluno e realiza a chamada ConsultarHorario.

Em seguida, realiza a inscrição no streaming AcompanharAvisos.

gRPC Python
Estrutura
python/grpc_central

├── central_pb2.py
├── central_pb2_grpc.py
├── servidor_central.py
└── cliente_central.py

Os arquivos central_pb2.py e central_pb2_grpc.py são gerados a partir do arquivo central.proto.

Gerar os arquivos Python

A partir da pasta:

python/grpc_central

executar:

python -m grpc_tools.protoc -I ../../proto --python_out=. --grpc_python_out=. ../../proto/central.proto
Executar o servidor Python

Entrar na pasta:

cd python/grpc_central

Executar:

python servidor_central.py

O servidor utiliza:

OFFSET = 93
Porta = 50154
Executar o cliente Python

Em outro terminal:

cd python/grpc_central

Executar:

python cliente_central.py

O cliente realiza a consulta de horário e posteriormente recebe os cinco avisos enviados pelo servidor através do streaming.

RPC com Server Streaming

Na operação AcompanharAvisos, o cliente realiza uma única requisição:

InscricaoAvisos

O servidor então envia cinco mensagens Aviso, com intervalo de dois segundos entre elas.

Fluxo simplificado:

Cliente
   │
   │ InscricaoAvisos
   ▼
Servidor
   │
   ├── Aviso #1
   ├── Aviso #2
   ├── Aviso #3
   ├── Aviso #4
   └── Aviso #5

Diferentemente do Multicast, o streaming gRPC estabelece uma comunicação individual entre o servidor e cada cliente conectado.

Comparação dos Protocolos
Protocolo	Conexão	Garantia de entrega	Comunicação
TCP	Com conexão	Sim	Cliente e servidor
UDP	Sem conexão	Não	Cliente e servidor
Multicast	Grupo	Não	Um servidor para vários clientes
WebSocket	Conexão persistente	Sim	Bidirecional e em tempo real
gRPC	Conexão HTTP/2	Sim	RPC unário ou streaming
Comparação dos Modelos de Comunicação

Durante os laboratórios foram utilizados diferentes modelos:

TCP

Comunicação orientada à conexão entre cliente e servidor.

UDP

Comunicação sem conexão, com menor overhead e sem garantia de entrega.

Multicast

Comunicação de um servidor para múltiplos clientes inscritos em um grupo multicast.

WebSocket

Comunicação bidirecional e persistente, adequada para aplicações em tempo real.

gRPC

Comunicação baseada em chamadas de procedimentos remotos, utilizando Protocol Buffers e HTTP/2, podendo trabalhar tanto com chamadas unárias quanto com streaming.

Conceitos Trabalhados

Durante o desenvolvimento dos laboratórios foram praticados:

Criação de servidores e clientes;
Uso de sockets;
Comunicação TCP e UDP;
Comunicação multicast;
Comunicação em grupo;
Comunicação bidirecional;
Conexões persistentes;
Comunicação em tempo real;
RPC (Remote Procedure Call);
gRPC;
Protocol Buffers;
Server-side streaming;
Geração automática de código a partir de arquivos .proto;
Comunicação entre aplicações desenvolvidas em linguagens diferentes;
Gerenciamento de múltiplos clientes e conexões.
Evidências

Os testes realizados estão disponíveis na pasta:

evidencias/

Contendo registros das execuções:

TCP;
UDP;
Multicast;
WebSocket Java;
WebSocket Python;
Streaming gRPC Java;
Streaming gRPC Python.

As evidências do streaming gRPC estão organizadas em:

evidencias/streaming/

Com os arquivos:

streaming-java.png
streaming-python.png
Autor

Santhiago Takaesu Sampaio
