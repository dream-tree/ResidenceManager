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
 * kind of challenge for me by now.
 *
 * First version of this task is to be designed for a single residence
 * rather than for the all residences stored in the database.
 *
 * Note: Liabilities always concern a single apartment and bank account
 * transfers always concern a single owner. Since an owner may have more than
 * one residence, the liabilities and transfers do not match as one-to-one
 * relationship.
 *
 * WORK IN PROGRESS.
 */
/**
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
package com.marcin.residence.account.clearance;