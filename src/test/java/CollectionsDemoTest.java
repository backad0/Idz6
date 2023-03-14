import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CollectionsDemoTest {

    @Test
    public void numOfStarts() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("aab");
        assertEquals(2, CollectionsDemo.NumOfStarts(arrayList, "a"));
    }


    @Test
    public void getEqualsSurname() {
        ArrayList<Human> initial = new ArrayList<>();
        initial.add(new Human("a","a","",0));
        initial.add(new Human("a","aa","",0));
        initial.add(new Human("b","aa","",0));

        Human Comp = new Human("a", "abba", "", 0);

        ArrayList<Human> res = new ArrayList<>();
        res.add(new Human("a","a","",0));
        res.add(new Human("a","aa","",0));
        assertEquals(res, CollectionsDemo.GetEqualsSurname(initial, Comp));
    }

    @Test
    public void excludeHuman() {
        ArrayList<Human> initial = new ArrayList<>();
        initial.add(new Human("a","a","",0));
        initial.add(new Human("a","aa","",0));
        initial.add(new Human("b","aa","",0));

        Human Comp = new Human("b","aa","",0);

        ArrayList<Human> res = new ArrayList<>();
        res.add(new Human("a","a","",0));
        res.add(new Human("a","aa","",0));
        assertEquals(res, CollectionsDemo.ExcludeHuman(initial, Comp));

    }

    @Test
    public void getNotIntersecting() {
        Set<Integer> comp = new HashSet<>();
        comp.add(1);
        comp.add(2);

        ArrayList<Set<Integer>> arrSets = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>(); set1.add(1); arrSets.add(set1);
        Set<Integer> set2 = new HashSet<>(); set2.add(3); arrSets.add(set2);
        Set<Integer> set3 = new HashSet<>(); set3.add(2); arrSets.add(set3);
        Set<Integer> set4 = new HashSet<>(); set4.add(4); arrSets.add(set4);
        Set<Integer> set5 = new HashSet<>(); set5.add(5); arrSets.add(set5);

        ArrayList<Set<Integer>> expected = new ArrayList<>();
        expected.add(set2);expected.add(set4);expected.add(set5);
        assertEquals(expected, CollectionsDemo.getNotIntersecting(arrSets, comp));

    }

    @Test
    public void getSetWithMaxAge() {
        ArrayList<Human> input = new ArrayList<>();
        input.add(new Human("a", "a", "", 10));
        input.add(new Human("a", "a", "", 13));
        input.add(new Human("a", "a", "", 12));
        input.add(new Human("a", "a", "", 10));
        input.add(new Student("a", "a", "", 13, ""));
        input.add(new Student("a", "a", "", 9, ""));
        input.add(new Student("a", "a", "", 11, ""));

        HashSet<Human> excepted = new HashSet<>();
        excepted.add(new Human("a", "a", "", 13));
        excepted.add(new Student("a", "a", "", 13, ""));

        assertEquals(excepted, CollectionsDemo.getSetWithMaxAge(input));
    }

    @Test
    public void getSetById() {
        Map<Integer, Human> inputMap = new HashMap<Integer, Human>();
        inputMap.put(1,new Human("a","","",0));
        inputMap.put(2,new Human("b","","",0));
        inputMap.put(3,new Human("c","","",0));
        inputMap.put(4,new Human("d","","",0));
        inputMap.put(5,new Human("e","","",0));

        HashSet<Integer> ids = new HashSet<>();
        ids.add(1); ids.add(4);

        HashSet<Human> excepted = new HashSet<>();
        excepted.add(new Human("a","","",0));
        excepted.add(new Human("d","","",0));

        assertEquals(excepted, CollectionsDemo.getSetById(inputMap, ids));

    }

    @Test
    public void getIdsOfAdults() {
        Map<Integer, Human> input = new HashMap<>();
        input.put(1, new Human("a","","",18));
        input.put(2, new Human("aa","","", 15));
        input.put(3, new Human("aaa","","", 26));

        Set<Integer> excepted = new HashSet<>();
        excepted.add(1); excepted.add(3);
        assertEquals(excepted, CollectionsDemo.getIdsOfAdults(input));
    }

    @Test
    public void getMapWithAges() {
        Map<Integer, Human> input = new HashMap<>();
        input.put(1, new Human("a","","",18));
        input.put(2, new Human("aa","","", 15));
        input.put(3, new Human("aaa","","", 26));

        Map<Integer, Integer> excepted = new HashMap<>();
        excepted.put(1, 18);
        excepted.put(2, 15);
        excepted.put(3, 26);
        assertEquals(excepted, CollectionsDemo.getMapWithAges(input));
    }

    @Test
    public void getSetsOfHumanByAge() {
        HashSet<Human> input = new HashSet<>();
        input.add(new Human("a","","", 10));
        input.add(new Human("b","","", 11));
        input.add(new Human("c","","", 10));
        input.add(new Human("d","","", 13));
        input.add(new Human("e","","", 10));
        input.add(new Human("f","","", 13));
        input.add(new Human("g","","", 10));
        input.add(new Human("h","","", 14));
        input.add(new Human("i","","", 10));
        input.add(new Human("j","","", 11));

        Set<Human> age10 = new HashSet<>();
        age10.add(new Human("a","","", 10));
        age10.add(new Human("c","","", 10));
        age10.add(new Human("e","","", 10));
        age10.add(new Human("g","","", 10));
        age10.add(new Human("i","","", 10));
        Set<Human> age11 = new HashSet<>();
        age11.add(new Human("b","","", 11));
        age11.add(new Human("j","","", 11));
        Set<Human> age13 = new HashSet<>();
        age13.add(new Human("d","","", 13));
        age13.add(new Human("f","","", 13));
        Set<Human> age14 = new HashSet<>();
        age14.add(new Human("h","","",14));


        Map<Integer, Set<Human>> excepted = new HashMap<>();

        excepted.put(10, age10);
        excepted.put(11, age11);
        excepted.put(13, age13);
        excepted.put(14, age14);
        assertEquals(excepted, CollectionsDemo.getSetsOfHumanByAge(input));
    }
}
