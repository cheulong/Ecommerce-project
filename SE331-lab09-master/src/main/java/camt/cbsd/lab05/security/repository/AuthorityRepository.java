package camt.cbsd.lab05.security.repository;

import camt.cbsd.lab05.entity.security.Authority;
import camt.cbsd.lab05.entity.security.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dto on 17-Apr-17.
 */
public interface AuthorityRepository extends JpaRepository <Authority,Long> {
    Authority findByName(AuthorityName input);
}
