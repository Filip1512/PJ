package repositories;

import domain.AuthApplication;

import java.util.ArrayList;
import java.util.List;

public class AbstractAuthApplicationRepository implements AuthApplicationRepository {

    private static List<AuthApplication> db = new ArrayList<>();


        @Override
    public AuthApplication getAccountByEmailAddress(String email){
        for (AuthApplication account: db) {
            if (account.getEmail().equalsIgnoreCase(email))
                return account;
        }
        return null;
        }


        @Override
    public void register(AuthApplication account){
            db.add(account);
        }


}
