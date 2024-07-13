package interfacesegregation.followed;

public class Chef implements ChefInterface {
    @Override
    public void cookFood() {
        System.out.println("Chef cooks food");
    }

    @Override
    public void decideMenu() {
        System.out.println("Chef decides menu");
    }
}
