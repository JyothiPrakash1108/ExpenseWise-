package com.mjp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mjp.models.Expense;
import com.mjp.models.Room;
import com.mjp.models.User;
import com.mjp.repository.UserRepository;
import com.mjp.repository.RoomRepository;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    // for minute change to month 
    @Scheduled(fixedRate = 60000)  
    public void sendRoomExpenseEmails() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            Room room = user.getRoom();

            if (room != null) {
                String subject = "Room Expense Summary";
                String message = generateExpenseSummary(room);
                sendEmail(user.getGmail(), subject, message);
            }
        }
    }

    private String generateExpenseSummary(Room room) {
        StringBuilder summary = new StringBuilder();
        summary.append("Dear Room Member,\n\n");
        summary.append("Here is the summary of your room expenses:\n");

        for (Expense expense : room.getExpenses()) {
            summary.append(expense.getUser().getGmail())
                   .append(" spent ")
                   .append(expense.getAmount())
                   .append(" on ")
                   .append(expense.getDescription())
                   .append(" (")
                   .append(expense.getDate())
                   .append(")\n");
        }

        summary.append("\nThank you,\nExpenseWise");
        return summary.toString();
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
