/**
 * Experimental module for the clearance of a residence account.
 * It's supposed to group: bank account transfers and monthly residence rent
 * to determine the residence liabilities.
 * This module uses self-starting schedulers to perform certain individual
 * tasks i.e., receiving info about bank account transfers, fetching current
 * residence rent and fixing residence liabilities at a fixed date.
 * As a result it is supposed to notify the messaging mechanism
 * to perform the process of e-mails sending to the owners with an account
 * overdraft.
 *
 * As for now the bank account transfers are fixed "by hand" and are fetched
 * from the database since an appropriate API for this purpose is another
 * kind of challenge for me by now (just playing around with Account Information
 * API from https://developer.ing.com/api-marketplace/marketplace).
 *
 * Note: Liabilities always concern a single apartment (not an owner) and the bank
 * account is also assigned to a particular apartment. Since an owner may have more
 * than one residence, his total liabilities amount is a sum of liabilities of
 * apartments owned by him.
 *
 * Note: Package structure in com.marcin.residence.account module is organized
 * in a different manner than in the main module (com.marcin.residence tree).
 * There are no controller/entity/service/repository sections here. It is rather
 * divided by taking into account the available features. These two different
 * way of organizing classes might change in the future and a single system
 * might be chosen. This app was growing constantly up in the last months.
 * It is quite big now, and it should be eventually organized by features as
 * a whole. But, by now it is a kind of experiment for me that's why it is not
 * changed yet.
 */
/**
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
package com.marcin.residence.account.balance;