package ui;

import model.human.Human;
import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class Console implements View {

    private Presenter presenter;//куда отправлять информацию
    private Scanner scanner;
//    private Scanner scannerId;
    private boolean work;
    private Menu menu;


    public Console() {
        scanner = new Scanner(System.in);
//        scannerId = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }



    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print());
            int choice = Integer.parseInt(scan());
            menu.execute(choice);
        }
    }
    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
    public Presenter getPresenter() {
        return presenter;
    }



    private  boolean check(String text){
        return text.matches("[0-9]+");//Метод проверки что введено именно целое число из [0-9]
    }

    private String scan() {

        return scanner.nextLine();
    }
    private int scanId() {
        System.out.println("Введите id: ");
        return scanner.nextInt();
    }

    private String scanName() {
        System.out.println("Введите имя: ");
        return scanner.nextLine();
    }

    private String scanFamily() {
        System.out.println("Введите фамилию: ");
        return scanner.nextLine();
    }

    @Override
    public void printHuman(Human human) {

        System.out.println(human);
    }

    @Override
    public void addHuman(){

        String name = scanName();
        String family = scanFamily();
        presenter.addHuman(family,name);
    }
    @Override
    public void addMother(){
            System.out.println("Введите id человека, которому хотите добавить мать");
            int id = scanId();
            scanner.nextLine();
            String name = scanName();
            String family = scanFamily();
            presenter.addMother(id, family, name);
    }
    @Override
    public void addFather(){
        System.out.println("Введите id человека, которому хотите добавить отца.");
        int id = scanId();
        scanner.nextLine();
        String name = scanName();
        String family = scanFamily();
        presenter.addFather(id, family, name);
    }
    @Override
    public void addChild(){
        System.out.println("Введите id человека, которому хотите добавить ребенка.");
        int id = scanId();
        scanner.nextLine();
        String name = scanName();
        String family = scanFamily();
        presenter.addChild(id, family, name);
    }


    public void finish(){

        work = false;
    }
    @Override
    public void printTree() {
        System.out.println(presenter.getTree().getInfo());
    }


    public void searchHuman() {
        String name = scanName();
        String family = scanFamily();
        System.out.println(presenter.searchHuman(family,name));
    }

    @Override
    public void searchChild() {
        String name = scanName();
        String family = scanFamily();
        System.out.println(presenter.searchChild(family,name));
    }
    @Override
    public void save() {
        System.out.println(presenter.save());
    }

    @Override
    public void printFile() {
        System.out.println(presenter.printFile());
    }

}
