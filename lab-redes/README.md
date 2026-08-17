# Central de Avisos da Turma — Lab de Redes

Projeto desenvolvido para prática de comunicação em redes utilizando diferentes protocolos e arquiteturas de comunicação.

Foram implementadas aplicações cliente/servidor utilizando:

- TCP
- UDP
- Multicast
- WebSocket

As implementações foram feitas utilizando **Java** e **Python**, permitindo comparar as diferenças entre cada modelo de comunicação.

---

# Estrutura do Projeto

```
lab-redes
│
├── java
│   ├── tcp
│   ├── udp
│   ├── multicast
│   └── websocket
│
├── python
│   ├── tcp
│   ├── udp
│   ├── multicast
│   └── websocket
│
└── evidencias
    ├── tcp
    ├── udp
    ├── multicast
    └── websocket
```

---

# Tecnologias Utilizadas

## Java

- Java 17+
- Maven
- Biblioteca Java-WebSocket

## Python

- Python 3
- Biblioteca websockets

Instalação da biblioteca WebSocket:

```bash
pip install websockets
```

---

# Parte A — Comunicação TCP

## Descrição

Implementação de comunicação utilizando TCP, onde o cliente estabelece uma conexão com o servidor antes de realizar a troca de mensagens.

Características:

- Comunicação orientada à conexão;
- Garantia de entrega das mensagens;
- Mensagens recebidas na mesma ordem em que foram enviadas.

---

## Execução Java

Servidor:

```bash
java ServidorTCP
```

Cliente:

```bash
java ClienteTCP
```

---

## Execução Python

Servidor:

```bash
python servidor_tcp.py
```

Cliente:

```bash
python cliente_tcp.py
```

---

# Parte B — Comunicação UDP

## Descrição

Implementação utilizando UDP, onde as mensagens são enviadas sem estabelecer uma conexão prévia entre cliente e servidor.

Características:

- Comunicação sem conexão;
- Menor controle de entrega;
- Menor overhead comparado ao TCP.

---

## Execução Java

Servidor:

```bash
java ServidorUDP
```

Cliente:

```bash
java ClienteUDP
```

---

## Execução Python

Servidor:

```bash
python servidor_udp.py
```

Cliente:

```bash
python cliente_udp.py
```

---

# Parte C — Comunicação Multicast

## Descrição

Implementação de comunicação em grupo utilizando multicast.

O servidor envia uma mensagem para um grupo multicast e todos os clientes inscritos nesse grupo recebem os avisos.

Características:

- Um único envio para vários clientes;
- Comunicação em grupo;
- Não existe conexão individual entre servidor e clientes.

Grupo utilizado:

```
230.0.0.1
```

---

## Execução Java

Servidor:

```bash
java ServidorMulticast
```

Cliente:

```bash
java ClienteMulticast
```

---

## Execução Python

Servidor:

```bash
python servidor_multicast.py
```

Cliente:

```bash
python cliente_multicast.py
```

---

# Parte D — WebSocket

## Descrição

Implementação de um mural de avisos em tempo real utilizando WebSocket.

O servidor mantém conexões abertas com os clientes e encaminha as mensagens recebidas para todos os usuários conectados.

Características:

- Comunicação bidirecional;
- Conexão persistente;
- Atualização em tempo real.

---

# WebSocket Java

## Estrutura

```
java/websocket

├── pom.xml

└── src
    └── main
        └── java
            ├── MuralServidor.java
            └── MuralCliente.java
```

---

## Dependência Maven

Biblioteca utilizada:

```xml
<dependency>
    <groupId>org.java-websocket</groupId>
    <artifactId>Java-WebSocket</artifactId>
    <version>1.5.6</version>
</dependency>
```

---

## Executar Java WebSocket

Entrar na pasta:

```bash
cd java/websocket
```

Compilar:

```bash
mvn compile
```

Servidor:

```bash
mvn exec:java "-Dexec.mainClass=MuralServidor"
```

Cliente:

```bash
mvn exec:java "-Dexec.mainClass=MuralCliente"
```

---

# WebSocket Python

## Estrutura

```
python/websocket

├── mural_servidor.py
└── mural_cliente.py
```

---

## Executar Python WebSocket

Servidor:

```bash
python mural_servidor.py
```

Cliente:

```bash
python mural_cliente.py
```

---

# Comparação dos Protocolos

| Protocolo | Conexão             | Garantia de entrega | Comunicação                      |
| --------- | ------------------- | ------------------- | -------------------------------- |
| TCP       | Com conexão         | Sim                 | Cliente e servidor               |
| UDP       | Sem conexão         | Não                 | Cliente e servidor               |
| Multicast | Grupo               | Não                 | Um servidor para vários clientes |
| WebSocket | Conexão persistente | Sim                 | Comunicação em tempo real        |

---

# Conceitos Trabalhados

Durante o desenvolvimento do laboratório foram praticados:

- Criação de servidores e clientes;
- Uso de sockets;
- Comunicação TCP e UDP;
- Comunicação multicast;
- Comunicação em grupo;
- Comunicação em tempo real com WebSocket;
- Gerenciamento de múltiplos clientes conectados.

---

# Evidências

Os testes realizados estão disponíveis na pasta:

```
evidencias/
```

Contendo registros das execuções:

- TCP;
- UDP;
- Multicast;
- WebSocket Java;
- WebSocket Python.

---

# Autor

Santhiago Takaesu Sampaio

Laboratório de Desenvolvimento de Aplicações Distribuídas
