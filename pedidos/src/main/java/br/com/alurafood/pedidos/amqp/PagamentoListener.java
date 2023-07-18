package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void recebendoMensagem(PagamentoDto pagamentoDto) {
        String mensagem = """
                Dados do pagamento: %s
                Número do pedido: %s
                Valor R$: %s
                Status: %s 
                     """.
                formatted(pagamentoDto.getId(),
                        pagamentoDto.getNumero(),
                        pagamentoDto.getValor(),
                        pagamentoDto.getStatus());
        System.out.println("Recebendo mensagem " + mensagem.toString());

    }

}
