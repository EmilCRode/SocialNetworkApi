package socialnetworkapi;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import socialnetworkapi.models.Person;

import java.util.List;
import java.util.Scanner;

public class SocialNetworkAPI {
    Session session;
    Scanner scanner;

    public SocialNetworkAPI() {
        initializeHibernate();
        scanner = new Scanner(System.in);
    }

    private void initializeHibernate () {
        try {
            System.out.println("Initializing Hibernate");
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            System.out.println("Finished Initializing Hibernate");
        } catch(HibernateException ex) {
            ex.printStackTrace();
            System.exit(5);
        }
    }

    public void close() {
        session.close();
        scanner.close();
    }

    public void run() {
        boolean appRunning = true;

        while (appRunning) {
            char mainMenuSelect = mainMenu();

            if (mainMenuSelect == '1') {
                boolean apiRunning = true;
                PersonRelatedAPI pApi = new PersonRelatedImpl();

                while (apiRunning) {
                    char menuSelect = personRelatedMenu();

                    if (menuSelect == '1') {
                        Person person = readPersonFromId();
                        if (person != null) pApi.getProfile(session, person);
                    }
                    else if (menuSelect == '2') {
                        Person person = readPersonFromId();
                        if (person != null) pApi.getCommonInterestsOfMyFriends(session, person);
                    }
                    else if (menuSelect == '3') {
                        Person person = readPersonFromId();

                        if (person != null) {
                            Person targetPerson = readTargetPerson();

                            if (targetPerson != null) pApi.getCommonFriends(session, person, targetPerson);
                        }
                    }
                    else if (menuSelect == '4') {
                        Person person = readPersonFromId();
                        if (person != null) pApi.getPersonsWithMostCommonInterests(session, person);
                    }
                    else if (menuSelect == '5') {
                        Person person = readPersonFromId();
                        if (person != null) pApi.getJobRecommendation(session, person);
                    }
                    else if (menuSelect == '6') {
                        Person person = readPersonFromId();

                        if (person != null) {
                            Person targetPerson = readTargetPerson();

                            if (targetPerson != null) pApi.getShortestFriendshipPath(session, person, targetPerson);
                        }
                    }
                    else apiRunning = false;
                }
            }
            else if (mainMenuSelect == '2') {
                boolean apiRunning = true;
                StatisticImpl sApi = new StatisticImpl();

                while (apiRunning) {
                    char menuSelect = statisticMenu();

                    if (menuSelect == '1') sApi.getTagClassHierarchy(session);
                    else if (menuSelect == '2') {
                        int minNumber = readMinimumNumberOfLikes();

                        if (minNumber > -1) sApi.getPopularComments(session, minNumber);
                    }
                    else if (menuSelect == '3') sApi.getMostPostingCountry(session);
                    else apiRunning = false;
                }
            }
            else {
                appRunning = false;
            }
        }

        close();
    }

    private char mainMenu() {
        System.out.println("\n| Social Network API");
        System.out.println("| ==================");
        System.out.println("| Option wählen:");
        System.out.println("| 1: Personenbezogene API");
        System.out.println("| 2: Statistik API");
        System.out.println("| X: Beenden\n");

        String input = null;

        do {
            if (input != null) System.out.println("Fehlerhafte Eingabe.");

            try {
                System.out.print("Auswahl (1, 2, X): ");
                input = scanner.nextLine();
            }
            catch(Exception e) {
                input = "";
            }

            if (!input.equals("1") && !input.equals("2") && !input.equals("X") && !input.equals("x")) input = "";
        } while(input.equals(""));

        if (input.equals("x")) input = "X";

        System.out.println("");

        return input.charAt(0);
    }

    private char personRelatedMenu() {
        System.out.println("\n| Personenbezogene API");
        System.out.println("| ====================");
        System.out.println("| Option wählen:");
        System.out.println("| 1: Profil");
        System.out.println("| 2: Gemeinsame Interessen");
        System.out.println("| 3: Überlappende Freundesmengen");
        System.out.println("| 4: Ähnlichste Interessen");
        System.out.println("| 5: Job-Empfehlung");
        System.out.println("| 6: Kürzester Pfad zu einer anderen Person");
        System.out.println("| X: zurück zum Hauptmenü\n");

        String input = null;

        do {
            if (input != null) System.out.println("Fehlerhafte Eingabe.");

            try {
                System.out.print("Auswahl (1, 2, 3, 4, 5, 6, X): ");
                input = scanner.nextLine();
            }
            catch(Exception e) {
                input = "";
            }

            if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("X") && !input.equals("x")) input = "";
        } while(input.equals(""));

        if (input.equals("x")) input = "X";

        System.out.println("");

        return input.charAt(0);
    }

    private char statisticMenu() {
        System.out.println("\n| Statistik API");
        System.out.println("| =============");
        System.out.println("| Option wählen:");
        System.out.println("| 1: TagClass-Hierarchie");
        System.out.println("| 2: Beliebteste Kommentare");
        System.out.println("| 3: Land mit häufigsten Kommentaren und Posts");
        System.out.println("| X: zurück zum Hauptmenü\n");

        String input = null;

        do {
            if (input != null) System.out.println("Fehlerhafte Eingabe.");

            try {
                System.out.print("Auswahl (1, 2, 3, X): ");
                input = scanner.nextLine();
            }
            catch(Exception e) {
                input = "";
            }

            if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("X") && !input.equals("x")) input = "";
        } while(input.equals(""));

        if (input.equals("x")) input = "X";

        System.out.println("");

        return input.charAt(0);
    }

    private Person readPersonFromId() {
        System.out.print("Eingabe Personen-ID: ");
        String input = scanner.nextLine();

        long pid;

        try {
            pid = Long.parseLong(input);
        }
        catch (Exception e) {
            System.out.println("Ungültige ID. Vorgang abgebrochen.");
            return null;
        }

        Person person = session.get(Person.class, pid);

        if (person == null) {
            System.out.println("Person existiert nicht.");
            return null;
        }

        System.out.println("Eingegebene Person: " + person.getFirstName() + " " + person.getLastName() + " (" + person.getPid() + ")\n");
        return person;
    }

    private Person readPersonFromName() {
        System.out.print("Eingabe Vorname: ");
        String firstName = scanner.nextLine();
        System.out.print("Eingabe Nachname: ");
        String lastName = scanner.nextLine();

        List<Person> persons = session.createQuery("FROM Person WHERE first_name = :first_name AND last_name = :last_name", Person.class)
                .setParameter("first_name", firstName).setParameter("last_name", lastName).list();

        if (persons.size() < 1) {
            System.out.println("Person existiert nicht. Vorgang abgebrochen.");
            return null;
        }

        Person person = persons.get(0);

        if (person == null) {
            System.out.println("Person existiert nicht. Vorgang abgebrochen.");
            return null;
        }

        System.out.println("Eingegebene Person: " + person.getFirstName() + " " + person.getLastName() + " (" + person.getPid() + ")\n");
        return person;
    }

    private Person readTargetPerson() {
        String input = null;

        do {
            if (input != null) System.out.println("Fehlerhafte Eingabe.");

            try {
                System.out.print("Eingabe der Zielperson durch ID (1) oder Name (2): ");
                input = scanner.nextLine();
            }
            catch(Exception e) {
                input = "";
            }

            if (!input.equals("1") && !input.equals("2")) input = "";
        } while(input.equals(""));

        System.out.println("");

        if (input.equals("1")) return readPersonFromId();

        return readPersonFromName();
    }

    private int readMinimumNumberOfLikes() {
        System.out.print("Eingabe Mindestanzahl an Likes: ");
        String input = scanner.nextLine();

        int minNumber;

        try {
            minNumber = Integer.parseInt(input);
        }
        catch (Exception e) {
            System.out.println("Eingabe muss eine ganze Zahl sein. Vorgang abgebrcochen.");
            return -1;
        }

        if (minNumber < 0) {
            System.out.println("Eingabe muss eine ganze Zahl größer oder gleich Null sein. Vorgang abgebrochen.");
            return -1;
        }

        return minNumber;
    }
}
