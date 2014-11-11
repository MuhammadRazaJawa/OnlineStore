package org.orangedevelopers.onlinesotre.email;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
@Service
public @Data class EmailSender {

	@Autowired
	private JavaMailSenderImpl mailSender;
	
	private static final String SENDER = "vickyshah129@gmail.com";
	
	public boolean sendSingleMail(String to, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(SENDER);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		try{
			mailSender.send(message);
		}catch(MailException ex){
			ex.getMessage();
		}
		return true;
	}
	
	public boolean sendMultipleMail(String[] to, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(SENDER);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		try{
			mailSender.send(message);
		}catch(MailException ex){
			ex.getMessage();
		}
		return true;
	}
	
	public boolean sendMultipleMail(String[] to, String[] cc, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(SENDER);
		message.setTo(to);
		message.setCc(cc);
		message.setSubject(subject);
		message.setText(msg);
		try{
			mailSender.send(message);
		}catch(MailException ex){
			ex.getMessage();
		}
		return true;
	}
	
	public boolean sendMultipleMailBcc(String[] to, String[] bcc, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(SENDER);
		message.setTo(to);
		message.setBcc(bcc);
		message.setSubject(subject);
		message.setText(msg);
		try{
			mailSender.send(message);
		}catch(MailException ex){
			ex.getMessage();
		}
		return true;
	}
	
	public boolean sendMultipleMail(String[] to, String[] cc, String[] bcc, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(SENDER);
		message.setTo(to);
		message.setCc(cc);
		message.setBcc(bcc);
		message.setSubject(subject);
		message.setText(msg);
		try{
			mailSender.send(message);
		}catch(MailException ex){
			ex.getMessage();
		}
		return true;
	}
	
}
