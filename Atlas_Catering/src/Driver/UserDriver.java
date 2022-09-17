package Driver;

import Controller.UserController;
import Entity.User;
import View.InterfaceUtils;
import View.UserView;

public class UserDriver {
    public static void main(String[] args) {
        UserController controller = new UserController();
        UserView view = new UserView(controller);     
        

        int choices = 4;

        User nengfu = new User("Nengfu", "Amamiya14");
        User tengli = new User("Tengli", "Shiyoruxz");
        User waimin = new User("WaiMin1", "fraGo");
        controller.createUser(nengfu);
        controller.createUser(waimin);
        controller.createUser(tengli);

        while(controller.programRunning()) {
            UserView.printUserMenu();
            int input = UserView.yourInputChoice(choices);
            switch(input) {
                case 1:
                    view.showUserList();
                    InterfaceUtils.continuePrompt();
                    break;
                case 2:
                    view.editUserMenu();
                    break;
                case 3:
                    view.deleteUserMenu();
                    break;
                case 4:
                    System.out.println("Thank you for using Atlas Catering!");
                    controller.endProgram();
                    break;
            }
        }
        
        
    }
}
