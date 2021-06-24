package com.mycompany.envio_de_mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author julio
 */
public class Main {
    public static void main(String args[]) {

          // a quien se le envia.
        String to = "hernandezbelen.92@gmail.com";

        // quien es el remitente
        String from = "barriovistacielo@gmail.com";

        // se envia a través del protocolo smt de gmail
        String host = "smtp.gmail.com";

        // propiedades del sistema
        Properties properties = System.getProperties();

        // setup del server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // obtener la sesion.// y pasar usuario y clave
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("barriovistacielo@gmail.com", "mathushoyos7878");

            }

        });

        // utilizado para debuggear
        session.setDebug(true);

        try {
            // Crear el objeto MimeMessage.
            MimeMessage mensaje = new MimeMessage(session);

            // quien envia.
            mensaje.setFrom(new InternetAddress(from));

            // quien recibe.
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // configurar el subjectd
            mensaje.setSubject("El Administrador del Barrio le envia un mensaje!");

            // el mensaje
            mensaje.setText("Estas preparada para comer unos ricos lomos?!!!");

            System.out.println("enviando...");
            // enviar el mensaje
            Transport.send(mensaje);
            System.out.println("El mensaje se envió exitosamente....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        
    }
}
