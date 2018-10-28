package com.marcin.residence.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ApartmentControllerTest.class,
    LoginControllerTest.class,
    OwnerControllerTest.class,
    RatesControllerTest.class,
    RentControllerTest.class,
})

public class ControllersTestSuite {

}
