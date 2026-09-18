package com.cfs.BookMyShowBE.service;

import com.cfs.BookMyShowBE.GlobalException.CustomerNotFound;
import com.cfs.BookMyShowBE.GlobalException.ProfileException;
import com.cfs.BookMyShowBE.dto.CreateProfileRequest;
import com.cfs.BookMyShowBE.dto.ResponseDto.ProfileResponse;
import com.cfs.BookMyShowBE.entity.Customer;
import com.cfs.BookMyShowBE.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ProfileService {

    private final CustomerRepository customerRepository;

    public ProfileService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
//sign in
    @Transactional
    public ProfileResponse create(CreateProfileRequest request){
        String email=request.email().trim().toUpperCase(Locale.ROOT);
        String phone=request.phone();
        String name=request.name();
        if(customerRepository.existsByEmail(email) || customerRepository.existsByPhone(phone)){
            throw new ProfileException("An user already exists with " + request.email());
        }
return ProfileResponse.from(customerRepository.save(new Customer(request.name().trim(), email,phone)));

    }

//    login service
    @Transactional
    public ProfileResponse login(String phoneNo){
        String value=phoneNo==null?" " : phoneNo.trim();
        String phone =value.replaceAll("\\D","");
        Customer customer=value.contains("@")
                ? customerRepository.findByEmail(value.toLowerCase(Locale.ROOT)).orElse(null)
                : customerRepository.findByPhone(phone).orElse(null);

        if(customer==null)
        {
            throw new CustomerNotFound("NO profile found for this phone number or email");
        }

        return ProfileResponse.from(customer);
    }

    public String normalizePhone(String phone)
    {
        String normalize=phone==null ? "" : phone.replaceAll("\\D","");
        if(normalize.length()<10 || normalize.length()>15)
        {
            throw  new IllegalArgumentException("Enter valid Phone number");
        }
        return normalize;
    }

    }


