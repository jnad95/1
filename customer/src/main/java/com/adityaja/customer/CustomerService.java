package com.adityaja.customer;

import com.adityaja.clients.fraud.FraudCheckResponse;
import com.adityaja.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    //private final CustomerConfig customerConfig;
    private final CustomerConfig customerConfig;

    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //TODO: check if email is valid
        //TODO: check if email is "not taken"
        customerRepository.saveAndFlush(customer);
//        FraudCheckResponse fraudCheckResponse = customerConfig.restTemplate().getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId());

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

    }
}
