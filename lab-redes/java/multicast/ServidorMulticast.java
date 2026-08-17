
import java.io.IOException;
import java.net.*;

public class ServidorMulticast {

    // Use o MESMO OFFSET do ClienteMulticast.java
    static final int OFFSET = 4539;

    public static void main(String[] args) throws IOException, InterruptedException {

        String grupoMulticast = "230.0.0.1";
        int porta = 4446 + OFFSET;

        InetAddress grupo = InetAddress.getByName(grupoMulticast);

        // Usa a própria máquina para teste local
        NetworkInterface interfaceRede = NetworkInterface.getByInetAddress(
                InetAddress.getLoopbackAddress()
        );

        try (MulticastSocket socket = new MulticastSocket()) {

            socket.setNetworkInterface(interfaceRede);

            System.out.println("[Multicast] Enviando avisos para o grupo "
                    + grupoMulticast + ":" + porta);

            int contador = 1;

            while (contador <= 5) {

                String mensagem = "Aviso #" + contador
                        + ": a aula começa em "
                        + (5 - contador)
                        + " minuto(s)!";

                byte[] dados = mensagem.getBytes();

                DatagramPacket pacote = new DatagramPacket(
                        dados,
                        dados.length,
                        grupo,
                        porta
                );

                socket.send(pacote);

                System.out.println("[Multicast] Enviado: " + mensagem);

                contador++;

                Thread.sleep(2000);
            }
        }

        System.out.println("[Multicast] Servidor encerrado.");
    }
}
