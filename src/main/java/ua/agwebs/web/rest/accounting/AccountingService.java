package ua.agwebs.web.rest.accounting;


import java.util.List;

public interface AccountingService {

    void createEntry(AccountingDTO dto, long userId);

    List<CurrencyDTO> findAllCurrency();

}
