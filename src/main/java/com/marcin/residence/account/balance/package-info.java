/**
 * Experimental module for the clearance of a residence account.
 * It's supposed to group: bank account transfers and monthly residence rent
 * to determine the residence liabilities.
 * This module is going to use some kind of automatic schedulers to perform
 * individual tasks i.e., receiving info about bank account transfers, fetching
 * current residence rent and fixing residence liabilities at a fixed date.
 * As a result it is supposed to notify the messaging mechanism
 * to perform sending e-mails to the residents with an account overdraft.
 *
 * As for now the bank account transfers are fixed "by hand" and are fetched
 * from the database since an appropriate API for this purpose is another
 * kind of challenge for me by now (just playing now with Account Information API
 * from https://developer.ing.com/api-marketplace/marketplace).
 *
 * First version of this task is to be designed for a single residence
 * rather than for the all residences stored in the database.
 *
 * Note: Liabilities always concern a single apartment (not an owner) and the bank
 * account is also assigned to a particular apartment. Since an owner may have more
 * than one residence, his total liabilities amount is a sum of liabilities of
 * apartments owned by him.
 *
 * Note: Package structure in com.marcin.residence.account module is organized in
 * a different manner than in the main module (general com.marcin.residence tree).
 * There are no controller/entity/service/repository sections here. It is rather
 * divided taking into account the available features. These two different way of
 * organizing classes will change in the future and a single system will be chosen.
 * This app grows constantly up that`s why it will be eventually organized by
 * features probably.
 *
 * WORK IN PROGRESS.
 */
/**
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
package com.marcin.residence.account.balance;