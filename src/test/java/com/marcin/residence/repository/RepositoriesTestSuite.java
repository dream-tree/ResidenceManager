package com.marcin.residence.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ApartmentRepositoryImplTest.class,
    OwnerRepositoryImplTest.class,
    RatesRepositoryImplTest.class,
})

public class RepositoriesTestSuite {

}
