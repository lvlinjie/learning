package com.tgb.activemq;


import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
public class QueueTest {
    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
        Connection connection = factory.createConnection();
        connection.start();


        //创建一个Queue
        Queue queue = new ActiveMQQueue("testQueue");
        //创建一个Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //注册消费者1
        MessageConsumer comsumer1 = session.createConsumer(queue);
        comsumer1.setMessageListener(new MessageListener(){
            public void onMessage(Message m) {
                try {
                    System.out.println("吕林杰 get " + ((TextMessage)m).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });


        //注册消费者2
        MessageConsumer comsumer2 = session.createConsumer(queue);
        comsumer2.setMessageListener(new MessageListener(){
            public void onMessage(Message m) {
                try {
                    System.out.println("小满 get " + ((TextMessage)m).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

        });


        //创建一个生产者，然后发送多个消息。
        MessageProducer producer = session.createProducer(queue);
        for(int i=0; i<10; i++){
            System.out.println("老子生产了一个消息 ");
            producer.send(session.createTextMessage("Message:" + i));
        }
    }
}


