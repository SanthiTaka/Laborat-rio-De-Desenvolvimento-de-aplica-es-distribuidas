# 🌐 Laboratório de Desenvolvimento de Aplicações Distribuídas

Projeto desenvolvido para a prática de **comunicação em redes**, utilizando diferentes protocolos, modelos de comunicação e arquiteturas distribuídas.

Foram implementadas aplicações cliente/servidor utilizando:

* 🔌 **TCP**
* 📡 **UDP**
* 📢 **Multicast**
* 🔄 **WebSocket**
* ⚡ **gRPC**

As implementações foram realizadas em **Java** e **Python**, permitindo comparar as características, vantagens e diferenças entre os diversos modelos de comunicação.

---

## 📑 Sumário

* [📁 Estrutura do Projeto](#-estrutura-do-projeto)
* [🛠️ Tecnologias Utilizadas](#️-tecnologias-utilizadas)
* [📦 Instalação](#-instalação)
* [🔌 Parte A — Comunicação TCP](#-parte-a--comunicação-tcp)
* [📡 Parte B — Comunicação UDP](#-parte-b--comunicação-udp)
* [📢 Parte C — Comunicação Multicast](#-parte-c--comunicação-multicast)
* [🔄 Parte D — WebSocket](#-parte-d--websocket)
* [⚡ Parte E — gRPC](#-parte-e--grpc)
* [📊 Comparação dos Protocolos](#-comparação-dos-protocolos)
* [🔄 Comparação dos Modelos de Comunicação](#-comparação-dos-modelos-de-comunicação)
* [📚 Conceitos Trabalhados](#-conceitos-trabalhados)
* [🖼️ Evidências](#️-evidências)
* [👨‍💻 Autor](#-autor)

---

# 📁 Estrutura do Projeto

```text
lab-GRPC/
│
├── java/
│   ├── tcp/
│   ├── udp/
│   ├── multicast/
│   ├── websocket/
│   │   ├── pom.xml
│   │   └── src/
│   │       └── main/
│   │           └── java/
│   │               ├── MuralServidor.java
│   │               └── MuralCliente.java
│   │
│   └── grpc-central/
│       ├── pom.xml
│       └── src/
│           └── main/
│               ├── java/
│               │   └── br/
│               │       └── pucminas/
│               │           └── labdamd/
│               │               └── central/
│               │                   ├── ClienteCentral.java
│               │                   └── ServidorCentral.java
│               │
│               └── proto/
│                   └── central.proto
│
├── python/
│   ├── tcp/
│   ├── udp/
│   ├── multicast/
│   ├── websocket/
│   │   ├── mural_servidor.py
│   │   └── mural_cliente.py
│   │
│   └── grpc_central/
│       ├── central_pb2.py
│       ├── central_pb2_grpc.py
│       ├── servidor_central.py
│       └── cliente_central.py
│
├── proto/
│   └── central.proto
│
└── evidencias/
    ├── tcp/
    ├── udp/
    ├── multicast/
    ├── websocket/
    └── streaming/
        ├── streaming-java.png
        └── streaming-python.png
```

---

# 🛠️ Tecnologias Utilizadas

## ☕ Java

* Java 17+
* Maven
* Java-WebSocket
* gRPC
* Protocol Buffers

## 🐍 Python

* Python 3
* `grpcio`
* `grpcio-tools`
* `websockets`

---

# 📦 Instalação

## Python

Instale as bibliotecas necessárias:

```bash
pip install grpcio grpcio-tools websockets
```

---

# 🔌 Parte A — Comunicação TCP

## 📖 Descrição

Implementação de comunicação utilizando **TCP**, onde o cliente estabelece uma conexão com o servidor antes de realizar a troca de mensagens.

### Características

* Comunicação orientada à conexão;
* Garantia de entrega das mensagens;
* Mensagens recebidas na mesma ordem em que foram enviadas;
* Comunicação confiável entre cliente e servidor.

---

## ☕ Execução em Java

### Servidor

```bash
java ServidorTCP
```

### Cliente

```bash
java ClienteTCP
```

---

## 🐍 Execução em Python

### Servidor

```bash
python servidor_tcp.py
```

### Cliente

```bash
python cliente_tcp.py
```

---

# 📡 Parte B — Comunicação UDP

## 📖 Descrição

Implementação utilizando **UDP**, onde as mensagens são enviadas sem estabelecer uma conexão prévia entre cliente e servidor.

### Características

* Comunicação sem conexão;
* Menor controle sobre a entrega das mensagens;
* Não há garantia de entrega;
* Menor overhead comparado ao TCP;
* Maior simplicidade e rapidez na transmissão.

---

## ☕ Execução em Java

### Servidor

```bash
java ServidorUDP
```

### Cliente

```bash
java ClienteUDP
```

---

## 🐍 Execução em Python

### Servidor

```bash
python servidor_udp.py
```

### Cliente

```bash
python cliente_udp.py
```

---

# 📢 Parte C — Comunicação Multicast

## 📖 Descrição

Implementação de comunicação em grupo utilizando **Multicast**.

O servidor envia uma mensagem para um grupo multicast e todos os clientes inscritos nesse grupo recebem os avisos.

### Características

* Um único envio para vários clientes;
* Comunicação em grupo;
* Não existe uma conexão individual entre servidor e clientes;
* Clientes podem entrar ou sair do grupo de comunicação.

### 🌐 Grupo utilizado

```text
230.0.0.1
```

---

## ☕ Execução em Java

### Servidor

```bash
java ServidorMulticast
```

### Cliente

```bash
java ClienteMulticast
```

---

## 🐍 Execução em Python

### Servidor

```bash
python servidor_multicast.py
```

### Cliente

```bash
python cliente_multicast.py
```

---

# 🔄 Parte D — WebSocket

## 📖 Descrição

Implementação de um **mural de avisos em tempo real** utilizando WebSocket.

O servidor mantém conexões abertas com os clientes e encaminha as mensagens recebidas para os usuários conectados.

### Características

* Comunicação bidirecional;
* Conexão persistente;
* Atualização em tempo real;
* Baixa necessidade de reconexão;
* Comunicação contínua entre cliente e servidor.

---

## ☕ WebSocket em Java

### 📁 Estrutura

```text
java/websocket/
│
├── pom.xml
│
└── src/
    └── main/
        └── java/
            ├── MuralServidor.java
            └── MuralCliente.java
```

### 📦 Dependência Maven

Biblioteca utilizada:

```xml
<dependency>
    <groupId>org.java-websocket</groupId>
    <artifactId>Java-WebSocket</artifactId>
    <version>1.5.6</version>
</dependency>
```

### ▶️ Executar o WebSocket Java

Entre na pasta:

```bash
cd java/websocket
```

Compile o projeto:

```bash
mvn compile
```

Inicie o servidor:

```bash
mvn exec:java "-Dexec.mainClass=MuralServidor"
```

Em outro terminal, inicie o cliente:

```bash
mvn exec:java "-Dexec.mainClass=MuralCliente"
```

---

## 🐍 WebSocket em Python

### 📁 Estrutura

```text
python/websocket/
│
├── mural_servidor.py
└── mural_cliente.py
```

### ▶️ Executar o servidor

```bash
python mural_servidor.py
```

### ▶️ Executar o cliente

```bash
python mural_cliente.py
```

---

# ⚡ Parte E — gRPC

## 📖 Descrição

Implementação de comunicação utilizando **gRPC (Google Remote Procedure Call)** e **Protocol Buffers**.

O gRPC permite que o cliente invoque métodos remotos como se fossem chamadas de métodos locais, enquanto a comunicação e a serialização dos dados são realizadas pelo framework.

A aplicação implementa uma **Central de Atendimento**, permitindo:

* 🕒 Consultar o horário atual;
* 📢 Acompanhar avisos enviados pelo servidor.

---

## 🔧 Operações Implementadas

### 1️⃣ `ConsultarHorario`

RPC do tipo **unário**, contendo:

```text
1 requisição → 1 resposta
```

### 2️⃣ `AcompanharAvisos`

RPC utilizando **Server-Side Streaming**, permitindo que:

```text
1 requisição → várias respostas
```

O cliente realiza uma única inscrição e permanece recebendo avisos enviados pelo servidor.

---

# 📄 Protocol Buffers

O contrato da comunicação é definido no arquivo:

```text
proto/central.proto
```

O serviço possui as seguintes operações:

```text
ConsultarHorario
AcompanharAvisos
```

O arquivo `.proto` é utilizado para gerar automaticamente os códigos necessários para a comunicação entre cliente e servidor.

---

# ☕ gRPC em Java

## 📁 Estrutura

```text
java/grpc-central/
│
├── pom.xml
│
└── src/
    └── main/
        ├── java/
        │   └── br/
        │       └── pucminas/
        │           └── labdamd/
        │               └── central/
        │                   ├── ClienteCentral.java
        │                   └── ServidorCentral.java
        │
        └── proto/
            └── central.proto
```

---

## 🔨 Compilação

Entre na pasta:

```bash
cd java/grpc-central
```

Compile o projeto:

```bash
mvn clean compile
```

---

## ▶️ Executar o Servidor

```bash
mvn compile exec:java "-Dexec.mainClass=br.pucminas.labdamd.central.ServidorCentral"
```

O servidor utiliza a porta:

```text
50051 + OFFSET
```

Para este laboratório:

```text
OFFSET = 93
Porta  = 50144
```

---

## ▶️ Executar o Cliente

Em outro terminal:

```bash
mvn compile exec:java "-Dexec.mainClass=br.pucminas.labdamd.central.ClienteCentral"
```

O cliente:

1. Solicita o nome do aluno;
2. Realiza a chamada `ConsultarHorario`;
3. Realiza a inscrição no streaming `AcompanharAvisos`;
4. Permanece recebendo os avisos enviados pelo servidor.

---

# 🐍 gRPC em Python

## 📁 Estrutura

```text
python/grpc_central/
│
├── central_pb2.py
├── central_pb2_grpc.py
├── servidor_central.py
└── cliente_central.py
```

Os arquivos:

```text
central_pb2.py
central_pb2_grpc.py
```

são gerados automaticamente a partir do arquivo:

```text
central.proto
```

---

## ⚙️ Gerar os Arquivos Python

A partir da pasta:

```bash
cd python/grpc_central
```

Execute:

```bash
python -m grpc_tools.protoc \
  -I ../../proto \
  --python_out=. \
  --grpc_python_out=. \
  ../../proto/central.proto
```

---

## ▶️ Executar o Servidor Python

Entre na pasta:

```bash
cd python/grpc_central
```

Execute:

```bash
python servidor_central.py
```

O servidor utiliza:

```text
OFFSET = 93
Porta  = 50154
```

---

## ▶️ Executar o Cliente Python

Em outro terminal:

```bash
cd python/grpc_central
```

Execute:

```bash
python cliente_central.py
```

O cliente realiza a consulta de horário e, posteriormente, recebe os cinco avisos enviados pelo servidor através do streaming.

---

# 📡 RPC com Server-Side Streaming

Na operação `AcompanharAvisos`, o cliente realiza uma única requisição:

```text
InscricaoAvisos
```

O servidor então envia cinco mensagens `Aviso`, com intervalo de dois segundos entre elas.

## 🔄 Fluxo Simplificado

```text
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
```

Diferentemente do **Multicast**, o streaming gRPC estabelece uma comunicação individual entre o servidor e cada cliente conectado.

---

# 📊 Comparação dos Protocolos

| Protocolo     | Conexão              | Garantia de Entrega | Modelo de Comunicação         |
| ------------- | -------------------- | ------------------- | ----------------------------- |
| **TCP**       | Com conexão          | ✅ Sim               | Cliente ↔ Servidor            |
| **UDP**       | Sem conexão          | ❌ Não               | Cliente → Servidor            |
| **Multicast** | Comunicação em grupo | ❌ Não               | Um servidor → Vários clientes |
| **WebSocket** | Conexão persistente  | ✅ Sim               | Bidirecional e em tempo real  |
| **gRPC**      | Conexão HTTP/2       | ✅ Sim               | RPC unário ou streaming       |

---

# 🔄 Comparação dos Modelos de Comunicação

## 🔌 TCP

Comunicação orientada à conexão entre cliente e servidor, com confiabilidade e garantia de entrega.

## 📡 UDP

Comunicação sem conexão, com menor overhead, porém sem garantia de entrega ou ordenação.

## 📢 Multicast

Comunicação de um servidor para múltiplos clientes inscritos em um grupo multicast.

## 🔄 WebSocket

Comunicação bidirecional e persistente, adequada para aplicações que necessitam de atualizações em tempo real.

## ⚡ gRPC

Comunicação baseada em **chamadas de procedimentos remotos**, utilizando **Protocol Buffers** e **HTTP/2**, podendo trabalhar com chamadas unárias e diferentes tipos de streaming.

---

# 📚 Conceitos Trabalhados

Durante o desenvolvimento dos laboratórios foram praticados os seguintes conceitos:

* Criação de servidores e clientes;
* Uso de sockets;
* Comunicação TCP;
* Comunicação UDP;
* Comunicação Multicast;
* Comunicação em grupo;
* Comunicação bidirecional;
* Conexões persistentes;
* Comunicação em tempo real;
* RPC (*Remote Procedure Call*);
* gRPC;
* Protocol Buffers;
* Server-Side Streaming;
* Geração automática de código a partir de arquivos `.proto`;
* Comunicação entre aplicações desenvolvidas em linguagens diferentes;
* Gerenciamento de múltiplos clientes e conexões.

---

# 🖼️ Evidências

Os testes realizados estão disponíveis na pasta:

```text
evidencias/
```

Contendo registros das execuções de:

* 🔌 TCP;
* 📡 UDP;
* 📢 Multicast;
* 🔄 WebSocket em Java;
* 🐍 WebSocket em Python;
* ⚡ Streaming gRPC em Java;
* ⚡ Streaming gRPC em Python.

## 📂 Streaming gRPC

As evidências do streaming gRPC estão organizadas em:

```text
evidencias/streaming/
```

Com os arquivos:

```text
streaming-java.png
streaming-python.png
```

---

# 🎯 Objetivo do Projeto

O objetivo deste laboratório foi compreender, na prática, como diferentes protocolos e arquiteturas distribuídas se comportam em relação a:

* Conexão;
* Confiabilidade;
* Desempenho;
* Modelo de comunicação;
* Número de participantes;
* Persistência da conexão;
* Comunicação em tempo real;
* Streaming de dados;
* Integração entre diferentes linguagens de programação.

---

# 👨‍💻 Autor

**Santhiago Takaesu Sampaio**

---

⭐ Projeto desenvolvido para a disciplina de **Laboratório de Desenvolvimento de Aplicações Distribuídas**.
