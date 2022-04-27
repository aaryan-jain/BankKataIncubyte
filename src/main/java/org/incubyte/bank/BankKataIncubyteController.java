package org.incubyte.bank;

import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import org.incubyte.response.ResponseWrapper;

import java.util.List;
import java.util.Optional;

@Controller("/bankKataIncubyte")
public class BankKataIncubyteController {

    @Inject
    BankService bankService;

    @Get(uri="/", produces="text/html")
    public String index() {
        return bankService.welcome();
    }


    @Post
    public Branch save(@Body Branch branch) {
        return bankService.save(branch);
    }

    @Get("/branches/{id}")
    public ResponseWrapper getBranchById(long id) {
        return bankService.findById(id);
    }

    @Get(uri="/getAllData", produces="application/json")
    public Iterable<Branch> getAllData(){
        return bankService.findAll();
    }
}