package socialnetworkapi;

import org.hibernate.Session;
import org.hibernate.query.Query;
import socialnetworkapi.models.*;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PersonRelatedImpl implements PersonRelatedAPI{
    public void getProfile(Session session, long pid) {
        System.out.println(session.get(Person.class, pid));
    }

    public void getCommonInterestsOfMyFriends(Session session, long pid) {
        Person person = session.get(Person.class, pid);

        // Detect all Interests of Person
        HashSet<Tag> personInterests = new HashSet<>();
        Iterator<Tag> itrTag = person.getHasInterests().iterator();
        while (itrTag.hasNext()) { personInterests.add((Tag) itrTag.next()); }

        // Detect all common Interests
        HashSet<Tag> commonInterests = new HashSet<>();

        // For all persons he knows
        Iterator<Knows> itrKnows = person.getKnows().iterator();

        while (itrKnows.hasNext()) {
            Iterator<Tag> itrInterests = itrKnows.next().getPerson2().getHasInterests().iterator();

            while (itrInterests.hasNext()) {
                Tag currentInterest = itrInterests.next();

                if (personInterests.contains(currentInterest)) {
                    commonInterests.add(currentInterest);
                    personInterests.remove(currentInterest);
                }
            }
        }

        // For all persons who knows him/her
        itrKnows = person.getIsKnown().iterator();

        while (itrKnows.hasNext()) {
            Iterator<Tag> itrInterests = itrKnows.next().getPerson1().getHasInterests().iterator();

            while (itrInterests.hasNext()) {
                Tag currentInterest = itrInterests.next();

                if (personInterests.contains(currentInterest)) {
                    commonInterests.add(currentInterest);
                    personInterests.remove(currentInterest);
                }
            }
        }

        // Output
        if (commonInterests.size() < 1) {
            System.out.println("Keine gemeinsamen Interessen mit Freunden.");
        }
        else {
            System.out.println("Anzahl gemeinsamer Interessen mit Freunden: " + commonInterests.size());

            itrTag = commonInterests.iterator();

            while (itrTag.hasNext()) {
                Tag commonInterest = itrTag.next();
                System.out.println("• " + commonInterest.getName() + " (" + commonInterest.getTid() + ")");
            }
        }
    }

    public void getCommonFriends(Session session, long pid1, long pid2) {
        Person person = session.get(Person.class, pid1);
        Person otherPerson = session.get(Person.class, pid2);

        // Detect all Friends of Person
        HashSet<Person> personFriends = new HashSet<>();
        Iterator<Knows> itrKnows = person.getKnows().iterator();
        while (itrKnows.hasNext()) { personFriends.add(itrKnows.next().getPerson2()); }
        itrKnows = person.getIsKnown().iterator();
        while (itrKnows.hasNext()) { personFriends.add(itrKnows.next().getPerson1()); }

        // Detect all common Friends
        HashSet<Person> commonFriends = new HashSet<>();
        itrKnows = otherPerson.getKnows().iterator();

        while (itrKnows.hasNext()) {
            Person personToBeChecked = itrKnows.next().getPerson2();

            if (personFriends.contains(personToBeChecked)) {
                commonFriends.add(personToBeChecked);
                personFriends.remove(personToBeChecked);
            }
        }

        itrKnows = otherPerson.getIsKnown().iterator();

        while (itrKnows.hasNext()) {
            Person personToBeChecked = itrKnows.next().getPerson1();

            if (personFriends.contains(personToBeChecked)) {
                commonFriends.add(personToBeChecked);
                personFriends.remove(personToBeChecked);
            }
        }

        // Output
        if (commonFriends.size() < 1) {
            System.out.println("Keine gemeinsamen Freunde.");
        }
        else {
            System.out.println("Anzahl gemeinsamer Freunde: " + commonFriends.size());

            Iterator<Person> itrPerson = commonFriends.iterator();

            while (itrPerson.hasNext()) {
                Person commonFriend = itrPerson.next();
                System.out.println("• " + commonFriend.getFirstName() + " " + commonFriend.getLastName() + " (" + commonFriend.getPid() + ")");
            }
        }
    }

    public void getPersonsWithMostCommonInterests(Session session, long pid) {
        Person person = session.get(Person.class, pid);

        // Detect all Interests of Person
        HashSet<Tag> personInterests = new HashSet<>();
        Iterator<Tag> itrTag = person.getHasInterests().iterator();
        while (itrTag.hasNext()) { personInterests.add(itrTag.next()); }

        // Termination if there are no interests
        if (personInterests.size() < 1) {
            System.out.println("Person hat keine Interessen.");
            return;
        }

        // Detect all Persons with the most common interests
        HashSet<Person> personsWithMostCommonInterests = new HashSet<>();
        int numberOfCommonInterests = 0;

        List<Person> persons = session.createQuery("FROM Person", Person.class).list();

        for (int i = 0; i < persons.size(); i++) {
            Person currentPerson = persons.get(i);

            if (person.getPid() != currentPerson.getPid()) {
                int numberOfMatches = 0;
                itrTag = currentPerson.getHasInterests().iterator();

                while (itrTag.hasNext()) {
                    if (personInterests.contains(itrTag.next())) {
                        numberOfMatches++;
                    }
                }

                if (numberOfMatches > numberOfCommonInterests) {
                    personsWithMostCommonInterests = new HashSet<>();
                    personsWithMostCommonInterests.add(currentPerson);
                    numberOfCommonInterests = numberOfMatches;
                }
                else if (numberOfMatches == numberOfCommonInterests && numberOfMatches > 0) {
                    personsWithMostCommonInterests.add(currentPerson);
                }
            }
        }

        // Output
        if (numberOfCommonInterests == 0) {
            System.out.println("Es gibt keine Person mit Interessenübereinstimmungen.");
        }
        else {
            System.out.println("Personen mit den meisten Interessenübereinstimmungen (" + numberOfCommonInterests + " Interessen):");

            Iterator<Person> itrPerson = personsWithMostCommonInterests.iterator();

            while (itrPerson.hasNext()) {
                Person currentPerson = itrPerson.next();
                System.out.println("• " + currentPerson.getFirstName() + " " + currentPerson.getLastName() + " (" + currentPerson.getPid() + ")");
            }
        }
    }

    public void getJobRecommendation(Session session, long pid) {
        boolean found = false;
        Person person = session.get(Person.class, pid);
        Query uniHql = session.createQuery("FROM University u WHERE u.city = :city", University.class);
        uniHql.setParameter("city", person.getCity());
        List<University> universityList = uniHql.getResultList();
        for(University current: universityList){
            System.out.println(current.getName());
        }
        Query companyHql = session.createQuery("FROM Company c WHERE c.country = :country", Company.class);
        companyHql.setParameter("country", person.getCity().getIsPartOf());
        List<Company> companyList = companyHql.getResultList();
        for(Company current: companyList){
            System.out.println(current.getName());
        }

    }

    public void getShortestFriendshipPath(Session session, long pid1, long pid2) {
        Person person = session.get(Person.class, pid1);
        Person targetPerson = session.get(Person.class, pid2);

        ArrayList<Person> bestPath = new ArrayList<>();
        ArrayList<Person> initialPath = new ArrayList<>();
        initialPath.add(person);

        bestPath = shortestFriendshipPathExtension(initialPath, bestPath, targetPerson, session);

        if (bestPath.size() == 1) {
            System.out.println("Die eingegebene Zielperson ist die gleiche wie die Ausgangsperson.");
        }
        else if (bestPath.size() < 2) {
            System.out.println("Es keine Verbindung bzgl. der Freundschaftsbeziehungen oder sie ist zu weit entfernt.");
        }
        else {
            System.out.println("Kürzeste Verbindung bzgl. der Freundschaftsbeziehungen (" + (bestPath.size() - 1) + " Verbindungen):");
            System.out.println("• " + bestPath.get(0).getFirstName() + " " + bestPath.get(0).getLastName() + " (" + bestPath.get(0).getPid() + ")");

            for (int i = 1; i < bestPath.size(); i++) {
                System.out.println("   ↕ kennen sich");
                System.out.println("• " + bestPath.get(i).getFirstName() + " " + bestPath.get(i).getLastName() + " (" + bestPath.get(i).getPid() + ")");
            }
        }
    }

    private ArrayList<Person> shortestFriendshipPathExtension(ArrayList<Person> previousPath, ArrayList<Person> bestPath, Person targetPerson, Session session) {
        // Check termination condition: target person found.
        if (previousPath.get(previousPath.size() - 1).getPid() == targetPerson.getPid()) {
            return previousPath;
        }

        // Check termination condition: previous chain is longer or as long as the best chain.
        if (bestPath.size() != 0 && previousPath.size() > bestPath.size() - 1) { return bestPath; }

        // Check termination condition: previous chain is to long.
        if (previousPath.size() > 20) { return bestPath; }

        // Check termination condition: no circles.
        long lastPid = previousPath.get(previousPath.size() - 1).getPid();

        for (int i = 0; i < previousPath.size() - 1; i++) {
            if (previousPath.get(i).getPid() == lastPid) { return bestPath; }
        }

        // Determine the next Friends based on previous path end.
        StoredProcedureQuery query = session
                .createStoredProcedureQuery("get_direct_friends", Person.class)
                .registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR)
                .registerStoredProcedureParameter(2, Long.class, ParameterMode.IN)
                .setParameter(2, previousPath.get(previousPath.size() - 1).getPid());

        List<Person> nextFriends = query.getResultList();

        for (int i = 0; i < nextFriends.size(); i++) {
            ArrayList<Person> newPreviousPath = new ArrayList<>(previousPath);
            newPreviousPath.add(nextFriends.get(i));
            bestPath = shortestFriendshipPathExtension(newPreviousPath, bestPath, targetPerson, session);
        }

        return bestPath;
    }
}
