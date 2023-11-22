package com.enmivida.eazybank.config;

//@Service
//@RequiredArgsConstructor
public class EazyBankUserDetail {//implements UserDetailsService {
/**
 *  Ya no es necesario al implementar EazyBankUsernamePwdAuthenticationProvider
 * */
   /* private final CustomerRepository repository;

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
    }*/
}
