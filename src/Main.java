
public class Main {
    public static void main(String[] args){
        System.out.println("Правильный ввод:");
        try {
            verification("My_Little_Pony_123", "Pinkie_Pie_123", "Pinkie_Pie_123");
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } catch (WrongLoginException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Неправильный ввод:");
        try {
            verification("My_Little_Pony_12345678906789", "PinkiePie1231", "Pinkie_Pie_123");
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } catch (WrongLoginException e){
            System.out.println(e.getMessage());
        }

    }

    static void verification(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {

        if(login.length() < 20 & isAlphaNumeric(login)){
            if(password.length() < 20 & isAlphaNumeric(password) & password == confirmPassword){
                System.out.println(true);
            }
            else {
                throw new WrongPasswordException("false");
            }
        }
        else {
            throw new WrongLoginException("false");
        }

    }

    public static boolean isAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9_]*$");
    }
}