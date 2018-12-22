package com.marcin.residence.account.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles incoming requests for sending e-mail messages manually.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Controller
@RequestMapping("/residence")
public class EmailController {

    @Autowired
    private EmailScheduler emailScheduler;

    /**
     * Allows to send e-mail messages to owners with an account overdraft manually.
     * Runs {@link EmailScheduler#startTask()} method immediately after app user
     * triggers the "Send Messages" button on the application Main Page.
     *
     * @return jsp page with results of e-mail messages sending
     */
    @GetMapping("/sendEmails")
    public String sendEmails() {
        emailScheduler.startTask();
        return "manual-email-sending-result";
    }
}
