package com.enmivida.eazybank.config;

import com.enmivida.eazybank.model.Customer;
import com.enmivida.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EazyBankUserDetail implements UserDetailsService {

    private final CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // the username is the email for this example
        List<Customer> customerList = repository.findByEmail(username);

        if (customerList.size() == 0) {
            throw new UsernameNotFoundException("User details not found for the email: " + username);
        } else {
            Customer customer = customerList.get(0);
            return User.builder()
                    .username(customer.getEmail())
                    .password(customer.getPwd())
                    // es un array que puede recibir varios roles
                    .authorities(new SimpleGrantedAuthority(customer.getRole()))
                    .build();
        }
    }
}
