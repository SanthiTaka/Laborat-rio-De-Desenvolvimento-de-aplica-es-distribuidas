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
