package com.example.demo.Services;

import com.example.demo.Entities.Currency;
import com.example.demo.Entities.UserType;
import com.example.demo.Repos.CurrencyRepo;
import com.example.demo.Repos.UserTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepo repo;
    public List<Currency> GetAllCurrencies(){
        return repo.findAll();
    }

    public void CreateCurrency(Currency currency){
        repo.save(currency);
    }

    public void DeleteCurrencyById(long id){
        repo.deleteById(id);
    }

    public void UpdateCurrency(Currency currency){
        repo.save(currency);
    }
}
