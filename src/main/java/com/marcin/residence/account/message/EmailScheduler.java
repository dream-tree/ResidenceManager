package com.marcin.residence.account.message;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Provides the task scheduler for the self-starting e-mail service.
 * Messages are sent to the owners with an apartment account overdraft.
 * Apartment account balance is verified every 27th day of each month
 * at 10.30 a.m. and is followed by sending messages to appropriate owners.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Configuration
@EnableScheduling
public class EmailScheduler {

    @Autowired
    private EmailService emailService;

    /**
     * Runs the following methods:
     * <ol>
     * <li> {@link EmailScheduler#getApartmentAccountsWithOverdraft}
     * for getting all apartment account balances with an overdraft
     * and returning a collection mapping</li>
     * <ul>
     * <li>apartment ids (as Integers) and</li>
     * <li>amounts of account overdraft (as BigDecimals)</li>
     * </ul>
     * <li>{@link EmailScheduler#getEmailAddresses}
     * for getting all owner email addresses corresponding to the apartments
     * with an account overdraft and returning a collection mapping</li>
     * <ul>
     * <li>apartment ids (as Integers) and</li>
     * <li>owner email addresses (as Strings)</li>
     * </ul>
     * <li> {@link EmailService#sendMail}
     * for starting email service sending messages to appropriate owners with
     * an apartment account overdraft</li>
     * </ol>
     * Note: Both Map implementations are TreeMaps so it is guaranteed by the
     * apartment id that the (BigDecimal) overdraft corresponds to the
     * appropriate (String) email address.
     * <br>
     * Additional note: we have an Apartment id only, and now: Apartment has
     * Owner (fk owner_id), Owner has email property:
     * "SELECT owner.email FROM Apartment " || owner in Apartment is a field and
     * + "WHERE id = :theApartmentId ")     || at the same time is a fk pointing
     *                                      || to owner_id in the Owner entity!
     *                                      || And id is Apartment class id
     *                                      || field.
     */
    @Scheduled(cron = "0 30 10 27 JAN-DEC *")
    public void startTask() {
        Map<Integer, BigDecimal> apartmentsWithOverdrafts =
                getApartmentAccountsWithOverdraft();
        Map<Integer, String> apartmentsWithEmails =
                getEmailAddresses(apartmentsWithOverdrafts);
        EmailFactory emailService =
                new EmailFactory("smtp.gmail.com", 587, "***", "***");

        apartmentsWithOverdrafts.forEach((key, value) ->
                System.out.println(key + ", " + value));
        apartmentsWithEmails.forEach((key, value) ->
                System.out.println(key + ", " + value));

        emailService.sendMail(apartmentsWithOverdrafts, apartmentsWithEmails);
    }

    /**
     * Gets all apartment account balances with an overdraft and gets the
     * corresponding amount of the overdraft (bulk operation).
     * Note: ApartmentAccountBalance entity SHARES the Primary Key with
     * the Apartment entity.
     *
     * @return collection of apartment ids (equaling apartment account balances
     *      ids) mapping to the amount of the overdraft for the particular
     *      apartment
     */
    public Map<Integer, BigDecimal> getApartmentAccountsWithOverdraft() {
        return emailService.getApartmentAccountsWithOverdraft();
    }

    /**
     * Gets all owner email addresses corresponding to the apartments with
     * an account overdraft (bulk operation).
     * Number of email addresses is equal or less to number of apartments due to
     * one owner might own more than one apartment.
     *
     * @param apartmentsWithOverdraft collection of apartment ids mapping to the
     *      amount of the overdraft for the particular apartment
     * @return collection of apartment ids mapping to the email addresses of the
     *      apartment owners
     */
    public Map<Integer, String> getEmailAddresses(
            Map<Integer, BigDecimal> apartmentsWithOverdraft) {
        return emailService.getEmailAddresses(apartmentsWithOverdraft);
    }
}
