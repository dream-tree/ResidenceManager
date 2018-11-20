package com.marcin.residence.account.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Provides the task scheduler for assigning new bank transfers to the
 * appropriate apartment account and updating the apartment account balance.
 * Runs every 26th day of each month at 10.30 a.m.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Configuration
@EnableScheduling
public class ScheduledApartmentAccountBankTransaction {

    // TODO

}
