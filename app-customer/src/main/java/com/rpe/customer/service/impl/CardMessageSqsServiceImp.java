package com.rpe.customer.service.impl;

import com.rpe.customer.domain.Card;
import com.rpe.customer.service.MessageService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardMessageSqsServiceImp implements MessageService {
    private static final Logger LOG = Logger.getLogger(CardMessageSqsServiceImp.class);

    @Override
    public void send(Card card) {

        card.setCreatedAt(LocalDateTime.now().toString());
        card.setUpdatedAt(LocalDateTime.now().toString());

        // TODO Implementar serviço para envio do card na fila do SQS
        LOG.info("Sending message to SQS: " + card);

    }
}
