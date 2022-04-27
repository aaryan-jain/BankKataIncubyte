package org.incubyte.bank;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.incubyte.response.ResponseWrapper;

import java.util.List;
import java.util.Optional;

@Singleton
public class BankService {

    @Inject
    BranchRepository branchRepository;
    public String welcome() {
        return "<h2>Welcome from BankService Class</h2>";
    }

    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    public Iterable<Branch> findAll() {
        return  branchRepository.findAll();
    }

    public ResponseWrapper findById(long id) {
        Optional<Branch> branchMaybe = branchRepository.findById(id);
        if(branchMaybe.isPresent()){
            return new ResponseWrapper(branchMaybe.get(),"SUCCESS");
        }
        else{
            return new ResponseWrapper("", "Failure");
        }

    }
}
