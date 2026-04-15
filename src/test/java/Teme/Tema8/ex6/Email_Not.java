package Teme.Tema8.ex6;

public class Email_Not extends Notificari {

        private String emailAddress;

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        @Override
        public void send() {
            System.out.println("Se trimite email catre: " + emailAddress);
        }
    }

