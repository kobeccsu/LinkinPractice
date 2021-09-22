package com.leizhou.roomcleannotifier;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomCleanNotifierApplication {
	public static final String QUEUE_NAME = "room-cleaner";
	public static final String EXCHANGE_NAME = "operations";

	@Bean
	public Queue queue(){
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	public TopicExchange exchange(){
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with("leizhou.rooms.cleaner");
	}


	public static void main(String[] args) {
		SpringApplication.run(RoomCleanNotifierApplication.class, args);
	}

}
