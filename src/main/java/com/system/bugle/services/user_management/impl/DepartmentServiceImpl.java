package com.system.bugle.services.user_management.impl;

import com.system.bugle.dto.DepartmentDto;
import com.system.bugle.entity.user_management.Department;
import com.system.bugle.repo.user_management.DepartmentRepo;
import com.system.bugle.repo.user_management.EmailCredRepo;
import com.system.bugle.services.user_management.DepartmentService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;

    private final JavaMailSender getJavaMailSender;
    private final EmailCredRepo emailCredRepo;
    private final ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    @Qualifier("emailConfigBean")
    private Configuration emailConfig;

    @Override
    public void saveData(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        departmentRepo.save(department);
    }

    @Override
    public List<Department> getData() {
        return departmentRepo.findAll();
    }

    @Override
    public Optional<Department> getById(Integer id) {

        return departmentRepo.findById(id);
    }

    @Override
    public Department getByIdNoOpt(Integer id) {
        return departmentRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }


    @Override
    public void deleteById(Integer id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public List<Department> getAllData() {
       return departmentRepo.findAll();
    }

    @Override
    public Optional<Department> fetchById(Integer id) {
        return departmentRepo.findById(id);
    }

    @Override
    public void dropById(Integer id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public void sendEmail() {
        try {
            Map<String, String> model = new HashMap<>();

            MimeMessage message = getJavaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            Template template = emailConfig.getTemplate("emailTemp.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            mimeMessageHelper.setTo("sendfrom@yopmail.com");
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setSubject("Registration");
            mimeMessageHelper.setFrom("testFromMe@yopmail.com");

            taskExecutor.execute(new Thread() {
                public void run() {
                    getJavaMailSender.send(message);
                }
            });
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
