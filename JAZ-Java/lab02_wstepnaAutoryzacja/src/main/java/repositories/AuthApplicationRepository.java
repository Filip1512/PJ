package repositories;

import domain.AuthApplication;

public interface AuthApplicationRepository {

    AuthApplication getAccountByEmailAddress(String email);
    void register(AuthApplication account);

}
