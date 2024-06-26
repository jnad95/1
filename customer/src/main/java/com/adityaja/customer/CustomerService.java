package com.adityaja.customer;

import com.adityaja.amqp.RabbitMQMessageProducer;
import com.adityaja.clients.fraud.FraudCheckResponse;
import com.adityaja.clients.fraud.FraudClient;
import com.adityaja.clients.notification.NotificationClient;
import com.adityaja.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConfig customerConfig;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
//        FraudCheckResponse fraudCheckResponse = customerConfig.restTemplate().getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId());

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

//        notificationClient.sendNotification(new NotificationRequest(
//                customer.getFirstName() + " " + customer.getLastName(),
//                customer.getEmail(),
//                "Hi " + customer.getFirstName() + "\nCongratulations! You have successfully registered")
//        );
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getFirstName() + " " + customer.getLastName(),
                customer.getEmail(),
                "Hi " + customer.getFirstName() + "\nCongratulations! You have successfully registered");

        rabbitMQMessageProducer.publish(notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key");

    }
}
