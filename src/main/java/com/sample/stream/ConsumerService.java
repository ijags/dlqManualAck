package com.sample.stream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.ImmediateAcknowledgeAmqpException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import com.rabbitmq.client.Channel;
import com.sample.stream.model.Order;

@Configuration
public class ConsumerService {
	
    @SuppressWarnings("unchecked")
	@Bean
    Consumer<Message<Order>> orderConsume() {
		return message -> {
			System.out.println("Received message in Manual Ack ..." + message);
			boolean ack = false;
			
			ArrayList<HashMap<String,?>> xdeath = (ArrayList<HashMap<String, ?>>) message.getHeaders().get("x-death");
			
			
			if (xdeath != null && xdeath.get(0).get("count").equals(3L)) {	
                // giving up - don't send to DLX
				System.out.println("Acknowledge manually...");
				System.out.println("==============================================");
				
				Channel channel = (Channel) message.getHeaders().get("amqp_channel");
				long deliveryTag = (long) message.getHeaders().get("amqp_deliveryTag");
				
				System.out.println("Channel..." + channel);
				
				try {
					channel.basicAck(deliveryTag, false);					
					ack = true;
					System.out.println("excuted basicack..." + deliveryTag);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Manually Acknowledge AMQP... " + message.getPayload());
				System.out.println("==============================================");
						
				//throw new ImmediateAcknowledgeAmqpException("Failed after 3 attempts");
            }
			if(!ack) {
				System.out.println("Don't Re-queue message to work queue...");
				System.out.println("==============================================");
	            throw new AmqpRejectAndDontRequeueException("failed");
			}

		};
	}

}

