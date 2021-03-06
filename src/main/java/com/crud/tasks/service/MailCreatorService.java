package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyInfoConfig;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private CompanyInfoConfig companyInfo;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your own tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        context.setVariable("companyName", companyInfo.getCompanyName());
        context.setVariable("companyMail", "mail: " + companyInfo.getCompanyEmail());
        context.setVariable("companyPhone", "tel: " + companyInfo.getCompanyPhone());
        context.setVariable("companyGoal", companyInfo.getCompanyGoal());
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildMailHowManyTasks(String message) {

        long size = taskRepository.count();
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("howManyTasks", "Currently in databases u got "
                + ((size == 1) ? size + " task" : size + " tasks"));
        context.setVariable("preview", "Info about create new card");
        context.setVariable("goodbye", "Bye");
        context.setVariable("companyName", companyInfo.getCompanyName());
        context.setVariable("companyMail", "mail: " + companyInfo.getCompanyEmail());
        context.setVariable("companyPhone", "tel: " + companyInfo.getCompanyPhone());
        context.setVariable("companyGoal", companyInfo.getCompanyGoal());
        return templateEngine.process("mail/info-how-many-tasks-in-database", context);
    }
}

